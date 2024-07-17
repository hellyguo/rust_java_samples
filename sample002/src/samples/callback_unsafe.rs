use jni::objects::{GlobalRef, JClass, JMethodID, JObject, JValue};
use jni::signature::{Primitive, ReturnType};
use jni::sys::jlong;
use jni::JNIEnv;
use std::sync::Mutex;

static GLOBAL_REF_STORE: Mutex<Option<InvokeTarget>> = Mutex::new(None);

struct InvokeTarget {
    global_ref: GlobalRef,
    method_id: JMethodID,
}

#[no_mangle]
pub extern "system" fn Java_sample_s002_Caller2_receive<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_val: jlong,
) {
    if let Ok(guard) = GLOBAL_REF_STORE.lock() {
        let target = guard.as_ref().unwrap();
        let args = [JValue::Long(j_val).as_jni()];
        let _ = unsafe {
            env.call_method_unchecked(
                &target.global_ref,
                target.method_id,
                ReturnType::Primitive(Primitive::Void),
                args.as_slice(),
            )
        };
    }
}

#[no_mangle]
pub extern "system" fn Java_sample_s002_Caller2_defReceivedAction<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_callback: JObject<'local>,
) {
    if let Ok(vm) = env.get_java_vm() {
        if let Ok(global_callback) = env.new_global_ref(j_callback) {
            def_java_callback(global_callback, vm);
        } else {
            panic!("failed to create global reference to callback object");
        }
    } else {
        panic!("failed to get java vm");
    }
}

fn def_java_callback(global_callback: GlobalRef, vm: jni::JavaVM) {
    match GLOBAL_REF_STORE.lock() {
        Ok(mut guard) => {
            if let Ok(mut closure_env) = vm.get_env() {
                let class = closure_env
                    .get_object_class(global_callback.as_obj())
                    .unwrap();
                let method_id = closure_env
                    .get_method_id(class, "onReceived", "(J)V")
                    .unwrap();
                guard.replace(InvokeTarget {
                    global_ref: global_callback,
                    method_id,
                });
            } else {
                panic!("failed to get JNIEnv");
            }
        }
        Err(e) => panic!("failed to get global ref: {}", e),
    }
}

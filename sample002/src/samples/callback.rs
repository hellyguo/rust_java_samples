use jni::objects::{GlobalRef, JClass, JObject, JValueGen};
use jni::sys::jlong;
use jni::JNIEnv;
use std::sync::Mutex;

static GLOBAL_REF_STORE: Mutex<Option<GlobalRef>> = Mutex::new(None);

#[no_mangle]
pub extern "system" fn Java_sample_s002_Caller_receive<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_val: jlong,
) {
    if let Ok(guard) = GLOBAL_REF_STORE.lock() {
        let global_ref = guard.as_ref().unwrap();
        let _ = env.call_method(
            global_ref,
            "onReceived",
            "(J)V",
            &[JValueGen::Long(j_val); 1],
        );
    }
}

#[no_mangle]
pub extern "system" fn Java_sample_s002_Caller_defReceivedAction<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_callback: JObject<'local>,
) {
    if let Ok(global_callback) = env.new_global_ref(j_callback) {
        def_java_callback(global_callback);
    } else {
        panic!("failed to create global reference to callback object");
    }
}

fn def_java_callback(global_callback: GlobalRef) {
    match GLOBAL_REF_STORE.lock() {
        Ok(mut guard) => {
            guard.replace(global_callback);
        }
        Err(e) => panic!("failed to get global ref: {}", e),
    }
}

use jni::objects::{GlobalRef, JClass, JObject, JValueGen};
use jni::sys::jlong;
use jni::JNIEnv;

static mut GLOBAL_REF_STORE: Option<GlobalRef> = None;
static mut CALLBACK_STORE: Option<Box<dyn Fn(u64)>> = None;

#[no_mangle]
pub extern "system" fn Java_sample_s002_Caller_receive<'local>(
    _env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_val: jlong,
) {
    if let Some(callback) = unsafe { CALLBACK_STORE.as_ref() } {
        callback(j_val as u64);
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
    unsafe { GLOBAL_REF_STORE = Some(global_callback) };
    def_callback(move |data| {
        let j_val = data as jlong;
        if let Ok(mut closure_env) = vm.get_env() {
            let _ = closure_env.call_method(
                unsafe { GLOBAL_REF_STORE.as_ref().unwrap() },
                "onReceived",
                "(J)V",
                &[JValueGen::Long(j_val); 1],
            );
        }
    });
}

fn def_callback<F>(f: F)
where
    F: Fn(u64) + 'static,
{
    unsafe { CALLBACK_STORE = Some(Box::new(f)) };
}

use jni::objects::JClass;
use jni::signature::{Primitive, ReturnType};
use jni::sys::jboolean;
use jni::JNIEnv;
use std::sync::atomic::{AtomicBool, Ordering};
use std::sync::Mutex;
use std::thread;
use std::time::Duration;

static ACTIVE: Mutex<AtomicBool> = Mutex::new(AtomicBool::new(true));

#[no_mangle]
pub extern "system" fn Java_sample_s011_RunInRustThread2_callAsync<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) {
    let vm = env.get_java_vm().expect("get jvm");
    thread::spawn(move || {
        let mut env = vm.attach_current_thread().expect("attach");
        let class = env.find_class("sample/s011/LogCaller").expect("find class");
        let method_id = env
            .get_static_method_id(&class, "hello", "()V")
            .expect("get method");
        loop {
            if let Ok(active) = ACTIVE.lock() {
                if active.load(Ordering::SeqCst) {
                    let _ = unsafe {
                        env.call_static_method_unchecked(
                            &class,
                            &method_id,
                            ReturnType::Primitive(Primitive::Void),
                            &[],
                        )
                    };
                } else {
                    println!("quit");
                    break;
                }
            }
            thread::sleep(Duration::from_millis(50));
        }
    });
}

#[no_mangle]
pub extern "system" fn Java_sample_s011_RunInRustThread2_stopExecute<'local>(
    _env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) -> jboolean {
    if let Ok(active) = ACTIVE.lock() {
        active.store(false, Ordering::SeqCst);
        1
    } else {
        println!("failed to lock active");
        0
    }
}

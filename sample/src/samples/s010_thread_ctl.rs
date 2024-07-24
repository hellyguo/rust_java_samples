use jni::objects::{JClass, JString};
use jni::sys::jboolean;
use jni::JNIEnv;
use std::sync::atomic::{AtomicBool, Ordering};
use std::sync::Mutex;
use std::thread;
use std::time::{Duration, Instant};

static ACTIVE: Mutex<AtomicBool> = Mutex::new(AtomicBool::new(true));

#[no_mangle]
pub extern "system" fn Java_sample_s010_RunInRustThread_callAsync<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_msg: JString<'local>,
) {
    let recv_msg = if let Ok(msg) = env.get_string(&j_msg) {
        String::from(msg)
    } else {
        String::from("failed to get java string")
    };
    thread::spawn(move || loop {
        if let Ok(active) = ACTIVE.lock() {
            if active.load(Ordering::SeqCst) {
                println!("{}, {:?}", recv_msg, Instant::now());
            } else {
                println!("quit");
                break;
            }
        }
        thread::sleep(Duration::from_millis(50));
    });
}

#[no_mangle]
pub extern "system" fn Java_sample_s010_RunInRustThread_stopExecute<'local>(
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

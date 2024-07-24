use jni::objects::{JClass, JString};
use jni::strings::JNIString;
use jni::{JNIEnv, NativeMethod};
use std::ffi::c_void;

#[no_mangle]
pub extern "system" fn Java_sample_s009_NativeMethodRegister_reg<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) {
    let s009_class = env.find_class("sample/s009/NativeMethodRegister").unwrap();
    if let Err(e) = env.register_native_methods(
        s009_class,
        &[NativeMethod {
            name: JNIString::from("anotherMethod"),
            sig: JNIString::from("()Ljava/lang/String;"),
            fn_ptr: native_another_method as *mut c_void,
        }],
    ) {
        panic!("register method failed: {}", e);
    }
}

#[no_mangle]
extern "C" fn native_another_method<'local>(
    env: JNIEnv<'local>,
    _class: JClass,
) -> JString<'local> {
    env.new_string("hello, from rust").unwrap()
}

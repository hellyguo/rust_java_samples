use jni::objects::JClass;
use jni::sys::{jbyteArray, jdouble, jfloat, jint, jlong};
use jni::JNIEnv;

// This keeps Rust from "mangling" the name and making it unique for this
// crate.
#[no_mangle]
pub extern "system" fn Java_sample_s001_Bytes_int2bytes<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: jint,
) -> jbyteArray {
    let data = input.to_be_bytes();
    conv2bytes(env, data.as_slice(), data.len())
}

#[no_mangle]
pub extern "system" fn Java_sample_s001_Bytes_long2bytes<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: jlong,
) -> jbyteArray {
    let data = input.to_be_bytes();
    conv2bytes(env, data.as_slice(), data.len())
}

#[no_mangle]
pub extern "system" fn Java_sample_s001_Bytes_float2bytes<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: jfloat,
) -> jbyteArray {
    let data = input.to_be_bytes();
    conv2bytes(env, data.as_slice(), data.len())
}

#[no_mangle]
pub extern "system" fn Java_sample_s001_Bytes_double2bytes<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: jdouble,
) -> jbyteArray {
    let data = input.to_be_bytes();
    conv2bytes(env, data.as_slice(), data.len())
}

fn conv2bytes(env: JNIEnv, data: &[u8], _len: usize) -> jbyteArray {
    env.byte_array_from_slice(data).unwrap().into_raw()
}

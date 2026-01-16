use jni::objects::{AutoElements, JByteArray, JClass, ReleaseMode};
use jni::sys::jbyteArray;
use jni::JNIEnv;
use log::info;

#[no_mangle]
pub extern "system" fn Java_sample_s003_ReverseBytes_reverseBytes<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: JByteArray,
) -> jbyteArray {
    let rs = env.get_array_length(&input);
    let array_size = rs.unwrap();
    let rs = unsafe { env.get_array_elements(&input, ReleaseMode::CopyBack) };
    if rs.is_err() {
        panic!("something bad happened");
    }
    let array = rs.unwrap();
    info!("received [{}]/[{}]", array_size, array.len());
    conv2bytes(env, &array, array_size as usize)
}

fn conv2bytes(env: JNIEnv, data: &AutoElements<i8>, len: usize) -> jbyteArray {
    info!("convert to [{}]", len);
    let mut u8vec: Vec<u8> = Vec::with_capacity(len);
    for i in 0..len {
        u8vec.push(data[len - i - 1] as u8);
    }
    env
        .byte_array_from_slice(u8vec.as_slice())
        .unwrap()
        .into_raw()
}

#[no_mangle]
pub extern "system" fn Java_sample_s003_ReverseBytes_reverseBytes2<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    input: JByteArray,
) -> jbyteArray {
    let rs = unsafe { env.get_array_elements(&input, ReleaseMode::CopyBack) };
    if rs.is_err() {
        panic!("something bad happened");
    }
    let mut array = rs.unwrap();
    array.reverse();
    input.as_raw()
}

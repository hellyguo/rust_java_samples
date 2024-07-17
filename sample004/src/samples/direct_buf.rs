use jni::objects::{JByteBuffer, JClass};
use jni::sys::jint;
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_sample_s004_DirectBuf_transferBuf<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_buf: JByteBuffer<'local>,
    j_size: jint,
) {
    let ptr = env.get_direct_buffer_address(&j_buf).unwrap();
    let size = (j_size / u8::BITS as i32) as usize;
    let slice = unsafe { std::slice::from_raw_parts_mut(ptr, size) };
    slice[0..16].copy_from_slice(&[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]);
}

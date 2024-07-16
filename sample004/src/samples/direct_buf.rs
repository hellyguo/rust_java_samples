use jni::objects::{JByteBuffer, JClass};
use jni::sys::jint;
use jni::JNIEnv;
use log::*;
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering};

static mut BUF_HOLDER: AtomicU64 = AtomicU64::new(0);
static mut BUF_SIZE_HOLDER: AtomicUsize = AtomicUsize::new(0);

#[no_mangle]
pub extern "system" fn Java_sample_s004_DirectBuf_bindBuf<'local>(
    env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    j_buf: JByteBuffer<'local>,
    j_size: jint,
) {
    let ptr = env.get_direct_buffer_address(&j_buf).unwrap();
    let v_ptr = ptr as u64;
    let size = (j_size / u8::BITS as i32) as usize;
    info!(
        "sample buffer address: {}, {:016x}, size: {}/{}",
        v_ptr,
        v_ptr,
        { j_size },
        size
    );
    unsafe {
        BUF_HOLDER.store(v_ptr, Ordering::SeqCst);
        BUF_SIZE_HOLDER.store(size, Ordering::SeqCst);
    }
}

#[no_mangle]
pub extern "system" fn Java_sample_s004_DirectBuf_transferBuf<'local>(
    _env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) {
    let v_ptr;
    let size;
    unsafe {
        v_ptr = BUF_HOLDER.load(Ordering::SeqCst);
        size = BUF_SIZE_HOLDER.load(Ordering::SeqCst);
    }
    let ptr = v_ptr as *mut u8;
    info!("ptr:{:016x}, size: {}", v_ptr, size);
    let slice = unsafe { std::slice::from_raw_parts_mut(ptr, size) };
    slice[0..16].copy_from_slice(&[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]);
}

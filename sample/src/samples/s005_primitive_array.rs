use jni::objects::{JByteArray, JClass};
use jni::sys::jint;
use jni::JNIEnv;
use std::ptr;
use std::sync::Mutex;

static MTX_OPT_BYTES_OFFSET: Mutex<Option<isize>> = Mutex::new(None);

#[no_mangle]
pub extern "system" fn Java_sample_s005_PrimitiveArray_setupByteArrayOffset0<'local>(
    _env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    offset: jint,
) {
    match MTX_OPT_BYTES_OFFSET.lock() {
        Ok(mut guard) => {
            guard.replace(offset as isize);
        }
        Err(e) => panic!("modify offset failed: {}", e),
    }
}

#[no_mangle]
pub extern "system" fn Java_sample_s005_PrimitiveArray_copyElement<'local>(
    _env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    src: JByteArray<'local>,
    dst: JByteArray<'local>,
    length: jint,
    position: jint,
) {
    match MTX_OPT_BYTES_OFFSET.lock() {
        Ok(guard) => {
            let len = length as usize;
            let posi = position as usize;
            let offset = guard.unwrap();
            let src = conv(src, len, offset);
            let dst = conv_mut(dst, len, offset);
            unsafe { (*dst)[posi] = (*src)[posi] };
        }
        Err(e) => panic!("get offset failed: {}", e),
    }
}

#[inline(always)]
fn conv(raw: JByteArray<'_>, len: usize, offset: isize) -> *const [u8] {
    let ptr = raw.into_raw() as *const u64;
    unsafe { ptr::slice_from_raw_parts((*ptr as *mut u8).wrapping_offset(offset), len) }
}

#[inline(always)]
fn conv_mut(raw: JByteArray<'_>, len: usize, offset: isize) -> *mut [u8] {
    let ptr = raw.into_raw() as *const u64;
    unsafe { ptr::slice_from_raw_parts_mut((*ptr as *mut u8).wrapping_offset(offset), len) }
}

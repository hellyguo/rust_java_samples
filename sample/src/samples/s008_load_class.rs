use super::s008_class_buf::{CLASS_NAME_Xyz, CLASS_Xyz};
use jni::objects::{JClass, JObject};
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_sample_s008_MemClassLoader_load0<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    loader: JObject<'local>,
) {
    if let Err(e) = env.define_class(CLASS_NAME_Xyz, &loader, &CLASS_Xyz) {
        panic!("load class error: {}", e);
    }
}

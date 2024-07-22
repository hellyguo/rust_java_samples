use jni::objects::{JClass, JObject, JValueGen};
use jni::JNIEnv;

#[no_mangle]
pub extern "system" fn Java_sample_s007_FieldFiller_fill<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
    obj: JObject<'local>,
) {
    let demo = env.new_object("sample/data/Demo", "()V", &[]).unwrap();
    if let Err(e) = env.set_field(obj, "demo", "Lsample/data/Demo;", JValueGen::Object(&demo)) {
        panic!("failed to set field: demo, {}", e);
    }
}

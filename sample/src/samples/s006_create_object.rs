use jni::objects::{JClass, JMethodID, JObject};
use jni::JNIEnv;
use std::sync::Mutex;

static MTX_CONSTRUCTOR_METHOD_ID: Mutex<Option<JMethodID>> = Mutex::new(None);

#[no_mangle]
pub extern "system" fn Java_sample_s006_ObjectCreator_create<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) -> JObject<'local> {
    let obj = env
        .new_object("sample/common/Demo", "()V", &[])
        .expect("Failed to create object");
    obj
}

#[no_mangle]
pub extern "system" fn Java_sample_s006_ObjectCreator_createFast<'local>(
    mut env: JNIEnv<'local>,
    // This is the class that owns our static method. It's not going to be used,
    // but still must be present to match the expected signature of a static
    // native method.
    _class: JClass<'local>,
) -> JObject<'local> {
    match MTX_CONSTRUCTOR_METHOD_ID.lock() {
        Ok(mut guard) => {
            if guard.is_none() {
                let constructor_method_id = env
                    .get_method_id("sample/common/Demo", "<init>", "()V")
                    .expect("Failed to get method id");
                *guard = Some(constructor_method_id);
            }
            let constructor_method_id = guard.as_ref().unwrap();
            let obj = unsafe {
                env.new_object_unchecked("sample/common/Demo", *constructor_method_id, &[])
                    .expect("Failed to create object")
            };
            obj
        }
        Err(e) => panic!("lock failed: {}", e),
    }
}

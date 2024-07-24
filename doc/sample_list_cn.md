# rust-java 样例

[English version, 英文版](sample_list.md)

0. **sample000**, 从 `Java` 调用 `Rust` 方法

   - [s000_hello.rs](../sample/src/samples/s000_hello.rs)
   - [HelloWorld.java](../sample4j/src/main/java/sample/s000/HelloWorld.java)

1. **sample001**, 在 `Rust` 中将 `Java` 原始类型转换为字节

   - [s001_bytes.rs](../sample/src/samples/s001_bytes.rs)
   - [Bytes.java](../sample4j/src/main/java/sample/s001/Bytes.java)

2. **sample002**, 在 `Rust` 中接受 `Java` 对象，并回调到 `Java`

   - [s002_callback.rs](../sample/src/samples/s002_callback.rs)
   - [Caller.java](../sample4j/src/main/java/sample/s002/Caller.java)
   - [s002_callback_fast.rs](../sample/src/samples/s002_callback_fast.rs)
   - [Caller2.java](../sample4j/src/main/java/sample/s002/Caller2.java)

3. **sample003**, 逆转 `Java` 字节

   - [s003_reverse_bytes.rs](../sample/src/samples/s003_reverse_bytes.rs)
   - [ReverseBytes.java](../sample4j/src/main/java/sample/s003/ReverseBytes.java)

4. **sample004**, 在 `Rust` 中访问 `Java` 非堆内存

   - [s004_direct_buf.rs](../sample/src/samples/s004_direct_buf.rs)
   - [DirectBuf.java](../sample4j/src/main/java/sample/s004/DirectBuf.java)

5. **sample005**, 在 `Rust` 中访问 `Java` 基本类型数组

   - [s005_primitive_array.rs](../sample/src/samples/s005_primitive_array.rs)
   - [PrimitiveArray.java](../sample4j/src/main/java/sample/s005/PrimitiveArray.java)

6. **sample006**, 在 `Rust` 中创建 `Java` 对象

   - [s006_create_object.rs](../sample/src/samples/s006_create_object.rs)
   - [ObjectCreator.java](../sample4j/src/main/java/sample/s006/ObjectCreator.java)

7. **sample007**, 在 `Rust` 中为 `Java` 对象设置字段值

   - [s007_fill_field.rs](../sample/src/samples/s007_fill_field.rs)
   - [FieldFiller.java](../sample4j/src/main/java/sample/s007/FieldFiller.java)

8. **sample008**, 在 `Rust` 中加载 `Java` 类

   - [s008_load_class.rs](../sample/src/samples/s008_load_class.rs)
   - [s008_class_buf.rs](../sample/src/samples/s008_class_buf.rs)
   - [MemClassLoader.java](../sample4j/src/main/java/sample/s008/MemClassLoader.java)

   > `s008_class_buf.rs` 是通过 [java2u8vec.sh](../shell/java2u8vec.sh) 生成的

9. **sample009**, 在 `Rust` 中动态注册 `Java` 方法

   - [s009_reg_method.rs](../sample/src/samples/s009_reg_method.rs)
   - [NativeMethodRegister.java](../sample4j/src/main/java/sample/s009/NativeMethodRegister.java)

10. **sample010**, 通过 `Java` 控制 `Rust` 线程

    - [s010_thread_ctl.rs](../sample/src/samples/s010_thread_ctl.rs)
    - [RunInRustThread.java](../sample4j/src/main/java/sample/s010/RunInRustThread.java)

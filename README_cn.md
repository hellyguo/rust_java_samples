# rust-java 样例

## 简介

这个仓库包含调用 `Java` 方法的 `Rust` 代码，以及调用 `Rust` 方法的 `Java` 类。


1. **sample000**, 从 `Java` 调用 `Rust` 方法

   - [hello.rs](sample000/src/samples/hello.rs)
   - [HelloWorld.java](sample4j/src/main/java/sample/s000/HelloWorld.java)

2. **sample001**, 在 `Rust` 中将 `Java` 原始类型转换为字节

   - [bytes.rs](sample001/src/samples/bytes.rs)
   - [Bytes.java](sample4j/src/main/java/sample/s001/Bytes.java)

3. **sample002**, 在 `Rust` 中接受 `Java` 对象，并回调到 `Java`

   - [callback.rs](sample002/src/samples/callback.rs)
   - [Caller.java](sample4j/src/main/java/sample/s002/Caller.java)
   - [callback_unsafe.rs](sample002/src/samples/callback_unsafe.rs)
   - [Caller2.java](sample4j/src/main/java/sample/s002/Caller2.java)

4. **sample003**, 逆转 `Java` 字节

   - [reverse_bytes.rs](sample003/src/samples/reverse_bytes.rs)
   - [ReverseBytes.java](sample4j/src/main/java/sample/s003/ReverseBytes.java)

5. **sample004**, 在 `Rust` 中访问 `Java` 非堆内存

   - [direct_buf.rs](sample004/src/samples/direct_buf.rs)      
   - [DirectBuf.java](sample4j/src/main/java/sample/s004/DirectBuf.java)

6. **sample005**, 在 `Rust` 中访问 `Java` 基本类型数组
   - [primitive_array.rs](sample005/src/samples/primitive_array.rs)  
   - [PrimitiveArray.java](sample4j/src/main/java/sample/s005/PrimitiveArray.java)

## 构建

```shell
cargo build --release
```

`cargo` 在 `target/release` 构建 `.so`, 并会调用 `build_java.sh` 构建 `.jar`，里面的 `resources` 文件夹会包含 `.so`。

## 如何使用

1. 在 IDE 中调用 `Java` 单元测试

   > 需要设置 `JVM` 参数: `-Dsample000Lib=<path to lib>`

2. 在 IDE 中调用 `Java` 单元测试集

   > 需要设置 `JVM` 参数: `-Dlib_dir=<path to lib dir>`

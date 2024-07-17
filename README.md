# rust-java samples

## desc

This repository contains sample `Rust` programs that call `Java` methods, and `Java` classes that call `Rust` methods.

1. **sample000**, call `Rust` method from `Java`

   - [hello.rs](sample000/src/samples/hello.rs)
   - [HelloWorld.java](sample4j/src/main/java/sample/s000/HelloWorld.java)

2. **sample001**, convert `Java` primitive types to bytes in `Rust`

   - [bytes.rs](sample001/src/samples/bytes.rs)
   - [Bytes.java](sample4j/src/main/java/sample/s001/Bytes.java)

3. **sample002**, accept a `Java` object in `Rust`, and callback to `Java`

   - [callback.rs](sample002/src/samples/callback.rs)
   - [Caller.java](sample4j/src/main/java/sample/s002/Caller.java)
   - [callback_unsafe.rs](sample002/src/samples/callback_unsafe.rs)
   - [Caller2.java](sample4j/src/main/java/sample/s002/Caller2.java)

4. **sample003**, reverse `Java` bytes

   - [reverse_bytes.rs](sample003/src/samples/reverse_bytes.rs)
   - [ReverseBytes.java](sample4j/src/main/java/sample/s003/ReverseBytes.java)

5. **sample004**, access `Java` DirectBuffer in `Rust`

   - [direct_buf.rs](sample004/src/samples/direct_buf.rs)      
   - [DirectBuf.java](sample4j/src/main/java/sample/s004/DirectBuf.java)

6. **sample005**, access `Java` primitive array in `Rust`
   - [primitive_array.rs](sample005/src/samples/primitive_array.rs)  
   - [PrimitiveArray.java](sample4j/src/main/java/sample/s005/PrimitiveArray.java)

## how-to

1. call `Java` ecah JUnit test in IDE

   > need to setup `JVM` args: `-Dsample000Lib=<path to lib>`

2. call `Java` JUnit suite in IDE

   > need to setup `JVM` args: `-Dlib_dir=<path to lib dir>`

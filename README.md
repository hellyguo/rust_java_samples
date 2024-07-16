# rust-java samples

## desc

This repository contains sample `Rust` programs that call `Java` methods, and `Java` classes that call `Rust` methods.

| Sample    | Rust File                                                      | Java File                                                                     | Description                                        |
| --------- | -------------------------------------------------------------- | ----------------------------------------------------------------------------- | -------------------------------------------------- |
| sample000 | [hello.rs](sample000/src/samples/hello.rs)                     | [HelloWorld.java](sample4j/src/main/java/sample/s000/HelloWorld.java)         | call Rust method from Java                         |
| sample001 | [bytes.rs](sample001/src/samples/bytes.rs)                     | [Bytes.java](sample4j/src/main/java/sample/s001/Bytes.java)                   | convert Java primitive types to bytes in Rust      |
| sample002 | [callback.rs](sample002/src/samples/callback.rs)               | [Caller.java](sample4j/src/main/java/sample/s002/Caller.java)                 | accept a Java object in Rust, and callback to Java |
| sample003 | [reverse_bytes.rs](sample003/src/samples/reverse_bytes.rs)     | [ReverseBytes.java](sample4j/src/main/java/sample/s003/ReverseBytes.java)     | reverse Java bytes                                 |
| sample004 | [direct_buf.rs](sample004/src/samples/direct_buf.rs)           | [DirectBuf.java](sample4j/src/main/java/sample/s004/DirectBuf.java)           | access Java DirectBuffer in Rust                   |
| sample005 | [primitive_array.rs](sample005/src/samples/primitive_array.rs) | [PrimitiveArray.java](sample4j/src/main/java/sample/s005/PrimitiveArray.java) | access Java primitive array in Rust                |

## how-to

1. call `Java` ecah JUnit test in IDE

   > need to setup `JVM` args: `-Dsample000Lib=<path to lib>`

2. call `Java` JUnit suite in IDE

   > need to setup `JVM` args: `-Dlib_dir=<path to lib dir>`

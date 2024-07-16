# rust-java 样例

## 简介

这个仓库包含调用 `Java` 方法的 `Rust` 代码，以及调用 `Rust` 方法的 `Java` 类。

| 示例      | 描述                                    |
| --------- | --------------------------------------- |
| sample000 | 从 Java 调用 Rust 方法                  |
| sample001 | 在 Rust 中将 Java 原始类型转换为字节    |
| sample002 | 在 Rust 中接受 Java 对象，并回调到 Java |
| sample003 | 逆转 Java 字节                          |
| sample004 | 在 Rust 中访问 Java 非堆内存            |
| sample005 | 在 Rust 中访问 Java 基本类型数组        |

## 如何使用
1. 在 IDE 中调用 `Java` 单元测试
   
    > 需要设置 `JVM` 参数: `-Dsample000Lib=<path to lib>`

2. 在 IDE 中调用 `Java` 单元测试集
   
    > 需要设置 `JVM` 参数: `-Dlib_dir=<path to lib dir>`

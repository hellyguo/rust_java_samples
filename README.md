# rust-java samples

## desc

This repository contains sample `Rust` programs that call `Java` methods, and `Java` classes that call `Rust` methods.

| Sample    | Description                                        |
| --------- | -------------------------------------------------- |
| sample000 | call Rust method from Java                         |
| sample001 | convert Java primitive types to bytes in Rust      |
| sample002 | accept a Java object in Rust, and callback to Java |
| sample003 | reverse Java bytes                                 |
| sample004 | access Java DirectBuffer in Rust                   |
| sample005 | access Java primitive array in Rust                |

## how-to

1. call `Java` ecah JUnit test in IDE
   
    > need to setup `JVM` args: `-Dsample000Lib=<path to lib>`

2. call `Java` JUnit suite in IDE
   
    > need to setup `JVM` args: `-Dlib_dir=<path to lib dir>`

# rust-java samples

## desc

This repository contains sample `Rust` programs that call `Java` methods, and `Java` classes that call `Rust` methods.

## build

```shell
cargo build --release
```

`cargo` will generate `.so` in `target/release`, and call `build_java.sh` to build `.jar`, which contains `.so` in `resources` folder.

## how-to

1. call `Java` ecah JUnit test in IDE

   > need to setup `JVM` args: `-Dsample000Lib=<path to lib>`

2. call `Java` JUnit suite in IDE

   > need to setup `JVM` args: `-Dlib_dir=<path to lib dir>`

## sample list

[sample list](doc/sample_list.md)

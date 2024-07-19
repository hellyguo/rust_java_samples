# rust-java samples

[Chinese version, 中文版](README_cn.md)

## desc

This repository contains sample `Rust` programs that call `Java` methods, and `Java` classes that call `Rust` methods.

## build

```shell
cargo build --release
```

`cargo` will generate `.so` in `target/release`, and call `build_java.sh` to build `.jar`, which contains `.so` in `resources` folder.

## how-to

1. call `Java` ecah JUnit test in IDE

   > need to setup `JVM` args: `-DsampleXYZLib=<path to lib>`

2. call `Java` JUnit suite in IDE

   > need to setup `JVM` args: `-Dlib_dir=<path to lib dir>`

## sample list

[sample list](doc/sample_list.md)

## thanks

Thanks to [metaworm](https://github.com/metaworm)([rust-java-demo](https://github.com/metaworm/rust-java-demo)). This article ([url1](https://zhuanlan.zhihu.com/p/568062165)/[url2](https://rustcc.cn/article?id=4ca84a67-d972-4460-912e-a297ec5edc0a)) is the most effective and detailed for learning how to call `JNI` through `Rust`.

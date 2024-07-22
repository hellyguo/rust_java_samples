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

1. call `Java` each JUnit test in IDE
2. call `Java` JUnit test suite in IDE

> **Note**: need to setup `JVM` args: `-DsampleLib=<path to lib>`

or

1. execute `Java` each JUnit test in console

    ```shell
    gradle test --tests HelloWorldTest
    ```

2. execute `Java` each JUnit test suite in console

    ```shell
    gradle test --tests SamplesSuite
    ```

The [JUnit report](sample4j/build/reports/tests/test/index.html) will be generated.

## sample list

[sample list](doc/sample_list.md)

## thanks

Thanks to [metaworm](https://github.com/metaworm)([rust-java-demo](https://github.com/metaworm/rust-java-demo)). This article ([url1](https://zhuanlan.zhihu.com/p/568062165)/[url2](https://rustcc.cn/article?id=4ca84a67-d972-4460-912e-a297ec5edc0a)) is the most effective and detailed for learning how to call `JNI` through `Rust`.

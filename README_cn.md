# rust-java 样例

[English version, 英文版](README.md)

## 简介

这个仓库包含调用 `Java` 方法的 `Rust` 代码，以及调用 `Rust` 方法的 `Java` 类。

## 构建

```shell
cargo build --release
```

`cargo` 在 `target/release` 构建 `.so`, 并会调用 `build_java.sh` 构建 `.jar`，里面的 `resources` 文件夹会包含 `.so`。

## 如何使用

1. 在 IDE 中调用 `Java` 单元测试

   > 需要设置 `JVM` 参数: `-DsampleXYZLib=<path to lib>`

2. 在 IDE 中调用 `Java` 单元测试集

   > 需要设置 `JVM` 参数: `-Dlib_dir=<path to lib dir>`

## 样例清单

[样例清单](doc/sample_list_cn.md)

## 感谢

感谢 [metaworm](https://github.com/metaworm)([rust-java-demo](https://github.com/metaworm/rust-java-demo))。当时我在学如何通过 `Rust` 调用 `JNI` 时，这篇文章 ([url1](https://zhuanlan.zhihu.com/p/568062165)/[url2](https://rustcc.cn/article?id=4ca84a67-d972-4460-912e-a297ec5edc0a)) 是最有效最详细的。

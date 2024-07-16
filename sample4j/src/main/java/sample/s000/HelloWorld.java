package sample.s000;

import sample.common.NativeLoader;

public class HelloWorld {

    /**
     * This declares that the static `hello` method will be provided
     * a native library.
     */
    public static native String hello(String input);

    static {
        NativeLoader.load(Sample000LibInfo.LIB_INFO);
    }

}

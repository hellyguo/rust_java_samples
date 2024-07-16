package sample.s003;

import sample.common.NativeLoader;

public final class ReverseBytes {

    static {
        NativeLoader.load(Sample003LibInfo.LIB_INFO);
    }

    public static native byte[] reverseBytes(byte[] bytes);
    public static native byte[] reverseBytes2(byte[] bytes);

    private ReverseBytes() {
    }
}

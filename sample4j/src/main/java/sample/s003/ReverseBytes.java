package sample.s003;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

public final class ReverseBytes {

    static {
        NativeLoader.load(new SimpleLibInfo("sample003"));
    }

    public static native byte[] reverseBytes(byte[] bytes);
    public static native byte[] reverseBytes2(byte[] bytes);

    private ReverseBytes() {
    }
}

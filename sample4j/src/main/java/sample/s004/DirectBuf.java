package sample.s004;

import sample.common.NativeLoader;

import java.nio.ByteBuffer;

public final class DirectBuf {

    static {
        NativeLoader.load(Sample004LibInfo.LIB_INFO);
    }

    public static native void bindBuf(ByteBuffer buf, int size);
    public static native void transferBuf();

    private DirectBuf() {
    }
}

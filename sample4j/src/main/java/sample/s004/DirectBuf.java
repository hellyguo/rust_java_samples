package sample.s004;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

import java.nio.ByteBuffer;

public final class DirectBuf {

    static {
        NativeLoader.load(new SimpleLibInfo("sample004"));
    }

    public static native void transferBuf(ByteBuffer buf, int size);

    private DirectBuf() {
    }
}

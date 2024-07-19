package sample.s005;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;
import sun.misc.Unsafe;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/16/24 11:29 AM
 */
public class PrimitiveArray {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }


    public static void setupByteArrayOffset() {
        setupByteArrayOffset0(Unsafe.ARRAY_BYTE_BASE_OFFSET);
    }

    private static native void setupByteArrayOffset0(int offset);

    public static native void copyElement(byte[] src, byte[] dst, int length,int position);

    private PrimitiveArray() {
    }
}

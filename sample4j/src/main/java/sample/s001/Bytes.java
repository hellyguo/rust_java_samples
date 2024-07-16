package sample.s001;

import sample.common.NativeLoader;

public class Bytes {

    static {
        NativeLoader.load(Sample001LibInfo.LIB_INFO);
    }

    public static native byte[] int2bytes(int data);

    public static native byte[] long2bytes(long data);

    public static native byte[] float2bytes(float data);

    public static native byte[] double2bytes(double data);

}

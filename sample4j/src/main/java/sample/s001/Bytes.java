package sample.s001;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

public class Bytes {

    static {
        NativeLoader.load(new SimpleLibInfo("sample001"));
    }

    public static native byte[] int2bytes(int data);

    public static native byte[] long2bytes(long data);

    public static native byte[] float2bytes(float data);

    public static native byte[] double2bytes(double data);

}

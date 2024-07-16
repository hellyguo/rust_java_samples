package sample.s002;

import sample.common.NativeLoader;

public class Caller {

    static {
        NativeLoader.load(Sample002LibInfo.LIB_INFO);
    }

    public static native void receive(long data);
    public static native void defReceivedAction(Callback callback);
    
}

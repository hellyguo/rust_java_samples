package sample.s002;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

public class Caller2 {

    static {
        NativeLoader.load(new SimpleLibInfo("sample002"));
    }

    public static native void receive(long data);
    public static native void defReceivedAction(Callback callback);
    
}

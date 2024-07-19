package sample.s002;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

public class Caller {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }

    public static native void receive(long data);
    public static native void defReceivedAction(Callback callback);
    
}

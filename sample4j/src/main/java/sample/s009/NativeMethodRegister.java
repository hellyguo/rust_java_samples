package sample.s009;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class NativeMethodRegister {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }


    public static native void reg();

    public static native String anotherMethod();
}

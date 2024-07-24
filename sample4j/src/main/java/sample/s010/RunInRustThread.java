package sample.s010;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class RunInRustThread {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }

    public static native void callAsync(String msg);

    public static native boolean stopExecute();
}

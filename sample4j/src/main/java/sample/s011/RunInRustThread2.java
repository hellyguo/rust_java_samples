package sample.s011;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class RunInRustThread2 {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RunInRustThread2.class);

    public static native void callAsync(String msg);

    public static native boolean stopExecute();
}

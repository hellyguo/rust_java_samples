package sample.s008;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class MemClassLoader {

    static {
        NativeLoader.load(new SimpleLibInfo("sample"));
    }


    public static void load(){
        load0(Object.class.getClassLoader());
    }

    private static native void load0(Object loader);
}

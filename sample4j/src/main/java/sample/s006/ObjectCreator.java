package sample.s006;

import sample.common.NativeLoader;
import sample.common.SimpleLibInfo;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class ObjectCreator {

    static {
        NativeLoader.load(new SimpleLibInfo("sample006"));
    }


    public static native Object create();
    public static native Object createFast();
}

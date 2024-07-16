package sample.s000;

import sample.common.LibInfo;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
final class Sample000LibInfo implements LibInfo {

    private static final String SAMPLE000_SHORT_NAME = "sample000";
    private static final String SAMPLE000_PREFIX = "lib" + SAMPLE000_SHORT_NAME;
    private static final String SAMPLE000_NAME = SAMPLE000_PREFIX + EXT;
    private static final String SAMPLE000_IN_JAR_PATH = "resources/" + SAMPLE000_NAME;

    private static final String SAMPLE000_LIB = System.getProperty("sample000Lib", LIB_DEF);

    static final Sample000LibInfo LIB_INFO = new Sample000LibInfo();

    private Sample000LibInfo() {
    }

    @Override
    public String shortName() {
        return SAMPLE000_SHORT_NAME;
    }

    @Override
    public String prefix() {
        return SAMPLE000_PREFIX;
    }

    @Override
    public String name() {
        return SAMPLE000_NAME;
    }

    @Override
    public String jarPath() {
        return SAMPLE000_IN_JAR_PATH;
    }

    @Override
    public String filePath() {
        return SAMPLE000_LIB;
    }
}

package sample.s001;

import sample.common.LibInfo;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
final class Sample001LibInfo implements LibInfo {

    private static final String SAMPLE001_SHORT_NAME = "sample001";
    private static final String SAMPLE001_PREFIX = "lib" + SAMPLE001_SHORT_NAME;
    private static final String SAMPLE001_NAME = SAMPLE001_PREFIX + EXT;
    private static final String SAMPLE001_IN_JAR_PATH = "resources/" + SAMPLE001_NAME;

    private static final String SAMPLE001_LIB = System.getProperty("sample001Lib", LIB_DEF);

    static final Sample001LibInfo LIB_INFO = new Sample001LibInfo();

    private Sample001LibInfo() {
    }

    @Override
    public String shortName() {
        return SAMPLE001_SHORT_NAME;
    }

    @Override
    public String prefix() {
        return SAMPLE001_PREFIX;
    }

    @Override
    public String name() {
        return SAMPLE001_NAME;
    }

    @Override
    public String jarPath() {
        return SAMPLE001_IN_JAR_PATH;
    }

    @Override
    public String filePath() {
        return SAMPLE001_LIB;
    }
}

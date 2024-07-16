package sample.s002;

import sample.common.LibInfo;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
final class Sample002LibInfo implements LibInfo {

    private static final String SAMPLE002_SHORT_NAME = "sample002";
    private static final String SAMPLE002_PREFIX = "lib" + SAMPLE002_SHORT_NAME;
    private static final String SAMPLE002_NAME = SAMPLE002_PREFIX + EXT;
    private static final String SAMPLE002_IN_JAR_PATH = "resources/" + SAMPLE002_NAME;

    private static final String SAMPLE002_LIB = System.getProperty("sample002Lib", LIB_DEF);

    static final Sample002LibInfo LIB_INFO = new Sample002LibInfo();

    private Sample002LibInfo() {
    }

    @Override
    public String shortName() {
        return SAMPLE002_SHORT_NAME;
    }

    @Override
    public String prefix() {
        return SAMPLE002_PREFIX;
    }

    @Override
    public String name() {
        return SAMPLE002_NAME;
    }

    @Override
    public String jarPath() {
        return SAMPLE002_IN_JAR_PATH;
    }

    @Override
    public String filePath() {
        return SAMPLE002_LIB;
    }
}

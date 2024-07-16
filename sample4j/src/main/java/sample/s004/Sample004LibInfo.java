package sample.s004;

import sample.common.LibInfo;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
final class Sample004LibInfo implements LibInfo {

    private static final String SAMPLE004_SHORT_NAME = "sample004";
    private static final String SAMPLE004_PREFIX = "lib" + SAMPLE004_SHORT_NAME;
    private static final String SAMPLE004_NAME = SAMPLE004_PREFIX + EXT;
    private static final String SAMPLE004_IN_JAR_PATH = "resources/" + SAMPLE004_NAME;

    private static final String SAMPLE004_LIB = System.getProperty("sample004Lib", LIB_DEF);

    static final Sample004LibInfo LIB_INFO = new Sample004LibInfo();

    private Sample004LibInfo() {
    }

    @Override
    public String shortName() {
        return SAMPLE004_SHORT_NAME;
    }

    @Override
    public String prefix() {
        return SAMPLE004_PREFIX;
    }

    @Override
    public String name() {
        return SAMPLE004_NAME;
    }

    @Override
    public String jarPath() {
        return SAMPLE004_IN_JAR_PATH;
    }

    @Override
    public String filePath() {
        return SAMPLE004_LIB;
    }
}

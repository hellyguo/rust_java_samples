package sample.s003;

import sample.common.LibInfo;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
final class Sample003LibInfo implements LibInfo {

    private static final String SAMPLE003_SHORT_NAME = "sample003";
    private static final String SAMPLE003_PREFIX = "lib" + SAMPLE003_SHORT_NAME;
    private static final String SAMPLE003_NAME = SAMPLE003_PREFIX + EXT;
    private static final String SAMPLE003_IN_JAR_PATH = "resources/" + SAMPLE003_NAME;

    private static final String SAMPLE003_LIB = System.getProperty("sample003Lib", LIB_DEF);

    static final Sample003LibInfo LIB_INFO = new Sample003LibInfo();

    private Sample003LibInfo() {
    }

    @Override
    public String shortName() {
        return SAMPLE003_SHORT_NAME;
    }

    @Override
    public String prefix() {
        return SAMPLE003_PREFIX;
    }

    @Override
    public String name() {
        return SAMPLE003_NAME;
    }

    @Override
    public String jarPath() {
        return SAMPLE003_IN_JAR_PATH;
    }

    @Override
    public String filePath() {
        return SAMPLE003_LIB;
    }
}

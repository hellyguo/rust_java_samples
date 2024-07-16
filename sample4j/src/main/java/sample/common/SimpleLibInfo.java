package sample.common;

import static sample.common.NativeLoader.EXT;
import static sample.common.NativeLoader.LIB_DEF;

/**
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
public final class SimpleLibInfo implements LibInfo {

    private final String shortName;
    private final String prefix;
    private final String name;
    private final String inJarPath;
    private final String libFilePath;

    public SimpleLibInfo(String shortName) {
        this.shortName = shortName;
        this.prefix = "lib" + shortName;
        this.name = prefix + EXT;
        this.inJarPath = "resources/" + name;
        this.libFilePath = System.getProperty(shortName + "Lib", LIB_DEF);
    }

    @Override
    public String shortName() {
        return shortName;
    }

    @Override
    public String prefix() {
        return prefix;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String jarPath() {
        return inJarPath;
    }

    @Override
    public String filePath() {
        return libFilePath;
    }
}

package sample.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * learn from <a href="https://www.cnblogs.com/FlyingPuPu/p/7598098.html">load from jar</a><br/>
 *
 * @author Helly Guo
 * <p>
 * Created on 11/16/23 10:23 PM
 */
public class NativeLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(NativeLoader.class);

    private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    /**
     * identify native library by system, may be need "os.arch"
     */
    private static final String OS_NAME = System.getProperty("os.name");
    public static final String EXT = (OS_NAME.toLowerCase().contains("win")) ? ".dll" : ".so";
    public static final String LIB_DEF = "ENV_LIB_PARAM_NOT_EXIST";

    private static final Set<String> LOADED_LIB = new ConcurrentSkipListSet<>();

    public static void load(LibInfo libInfo) {
        String name = libInfo.name();
        if (LOADED_LIB.contains(name)) {
            LOGGER.warn("the lib which named: {}, is already loaded. skip it.", name);
            return;
        }
        LOGGER.info("try load native library[{}] from sys lib path", name);
        try {
            System.loadLibrary(libInfo.shortName());
            return;
        } catch (UnsatisfiedLinkError error) {
            LOGGER.warn("try load lib from sys lib path failed: {}", error.getMessage());
        }
        String filePath = libInfo.filePath();
        if (LIB_DEF.equals(filePath)) {
            String jarPath = libInfo.jarPath();
            LOGGER.info("try load native library[{}] from classpath", jarPath);
            loadFromJar(jarPath, libInfo.prefix());
        } else {
            LOGGER.info("try load native library[{}] from {}", name, filePath);
            loadFromSysProperties(name, filePath);
        }
        LOGGER.info("load native library[{}] success", name);
        LOADED_LIB.add(name);
    }

    private static void loadFromJar(String jarPath, String prefix) {
        try (InputStream is = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(jarPath)) {
            if (is == null) {
                throw new RuntimeException(jarPath + " is not found in classpath");
            }
            Path tmpDir = Paths.get(TMP_DIR);
            Path tmpLib = Files.createTempFile(tmpDir, prefix, EXT);
            tmpLib.toFile().deleteOnExit();
            Files.copy(is, tmpLib, StandardCopyOption.REPLACE_EXISTING);
            System.load(tmpLib.toAbsolutePath().toString());
        } catch (UnsatisfiedLinkError | IOException e) {
            LOGGER.warn("failed to load native library[{}] from classpath: {}", jarPath, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void loadFromSysProperties(String name, String filePath) {
        Path path = Paths.get(filePath);
        try {
            System.load(path.toFile().getAbsolutePath());
        } catch (UnsatisfiedLinkError e) {
            LOGGER.info("failed to load native library[{}] from {}: {}", name, filePath, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

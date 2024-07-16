package sample;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/16/24 10:20 AM
 */
public class SamplesInitTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamplesInitTest.class);

    @Test
    public void testInit() {
        String libDir = System.getProperty("lib_dir");
        if (libDir == null) {
            throw new RuntimeException("lib dir is not set");
        }
        Path path = Paths.get(libDir);
        File dir = path.toFile();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles(n -> n.getName().endsWith(".so"));
            if (files != null) {
                Arrays.stream(files).sorted().forEach(f -> {
                    String key = f.getName().substring(3, f.getName().length() - 3) + "Lib";
                    String value = f.getAbsolutePath();
                    LOGGER.info("{} = {}", key, value);
                    System.setProperty(key, value);
                });
            }
        }
    }
}

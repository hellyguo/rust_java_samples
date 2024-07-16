package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sample.s000.HelloWorldTest;
import sample.s001.BytesTest;
import sample.s002.CallbackTest;
import sample.s003.ReverseBytesTest;
import sample.s004.DirectBufTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/16/24 10:20 AM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SamplesInitTest.class,
        HelloWorldTest.class,
        BytesTest.class,
        CallbackTest.class,
        ReverseBytesTest.class,
        DirectBufTest.class,
})
public class SamplesSuite {
    static {
        String libDir = System.getProperty("lib_dir");
        Path path = Paths.get(libDir);
        File dir = path.toFile();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles(n -> n.getName().endsWith(".so"));
            if (files != null) {
                Arrays.stream(files).forEach(f -> {
                    String key = f.getName().substring(3, f.getName().length() - 3) + "Lib";
                    String value = f.getAbsolutePath();
                    System.out.println(key + "=" + value);
                    System.setProperty(key, value);
                });
            }
        }
    }
}

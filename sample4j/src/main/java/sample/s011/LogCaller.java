package sample.s011;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
public class LogCaller {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunInRustThread2.class);

    public static void hello() {
        LOGGER.info("hello from java");
    }
}

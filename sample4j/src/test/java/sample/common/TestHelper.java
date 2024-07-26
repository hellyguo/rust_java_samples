package sample.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TestHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestHelper.class);

    public static void trySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    private TestHelper() {
    }
}
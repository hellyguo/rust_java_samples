package sample.s011;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.common.TestHelper;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/24/24 8:38 PM
 */
public class RunInRustThread2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunInRustThread2Test.class);

    @Test
    public void test() {
        RunInRustThread2.callAsync("a msg from Java");
        TestHelper.trySleep(2000);
        while (true) {
            boolean success = RunInRustThread2.stopExecute();
            if (success) {
                LOGGER.info("success to set active to false");
                break;
            } else {
                LOGGER.warn("fail to set active to false");
                TestHelper.trySleep(1000);
            }
        }
    }

}

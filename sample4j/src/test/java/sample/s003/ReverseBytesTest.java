package sample.s003;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReverseBytesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseBytesTest.class);
    private static final byte[] BYTES = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};

    @Test
    public void test() {
        byte[] retBytes = ReverseBytes.reverseBytes(BYTES);
        LOGGER.info("bytes: [{}]", retBytes);
        Assert.assertNotSame(BYTES, retBytes);
        retBytes = ReverseBytes.reverseBytes2(BYTES);
        LOGGER.info("bytes: [{}]", retBytes);
        Assert.assertSame(BYTES, retBytes);
    }
}

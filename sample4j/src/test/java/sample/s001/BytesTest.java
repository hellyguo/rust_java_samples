package sample.s001;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BytesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BytesTest.class);

    @Test
    public void test() {
        LOGGER.info("bytes: [{}]", Bytes.int2bytes(1));
        LOGGER.info("bytes: [{}]", Bytes.long2bytes(1L));
        LOGGER.info("bytes: [{}]", Bytes.float2bytes(1F));
        LOGGER.info("bytes: [{}]", Bytes.double2bytes(1D));
    }
}

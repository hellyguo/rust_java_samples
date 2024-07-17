package sample.s004;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class DirectBufTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectBufTest.class);

    @Test
    public void test() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        DirectBuf.transferBuf(buffer, 1024);
        buffer.position(0);
        buffer.limit(1024);
        byte[] bytes = new byte[1024];
        buffer.get(bytes);
        LOGGER.info("{}", Arrays.toString(bytes));
    }
}

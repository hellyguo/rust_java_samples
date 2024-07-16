package sample.s005;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/16/24 11:53 AM
 */
public class PrimitiveArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrimitiveArrayTest.class);

    @Test
    public void testArray() {
        byte[] src = {0, 1, 2, 3, 4, 5, 6, 7};
        byte[] dst = new byte[8];
        PrimitiveArray.setupByteArrayOffset();
        PrimitiveArray.copyElement(src, dst, 8, 3);
        Assert.assertEquals(src[3], dst[3]);
        LOGGER.info("src: {}", Arrays.toString(src));
        LOGGER.info("dst: {}", Arrays.toString(dst));
    }
}

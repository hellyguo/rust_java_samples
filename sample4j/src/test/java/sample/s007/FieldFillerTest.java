package sample.s007;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import sample.data.Sample;

import static sample.SimplesConst.LOOP_TIMES;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/20/24 1:54 AM
 */
@OrderWith(Alphanumeric.class)
public class FieldFillerTest {
    @Test
    public void test0Single() {
        Sample sample = new Sample();
        Assert.assertNull(sample.getDemo());
        FieldFiller.fill(sample);
        Assert.assertNotNull(sample.getDemo());
    }
    @Test
    public void test1Multi() {
        Sample sample = new Sample();
        for (int i = 0; i < LOOP_TIMES; i++) {
            FieldFiller.fill(sample);
            Assert.assertNotNull(sample.getDemo());
        }
    }
}

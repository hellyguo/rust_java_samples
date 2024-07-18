package sample.s006;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/18/24 9:12 AM
 */
@OrderWith()
public class ObjectCreatorTest {

    @Test
    public void test0Simple() {
        Object object = ObjectCreator.create();
        Assert.assertNotNull(object);
    }

    @Test
    public void test1Multi() {
        Object object;
        for (int i = 0; i < 10_000_000; i++) {
            object = ObjectCreator.create();
            Assert.assertNotNull(object);
        }
    }

    @Test
    public void test2SimpleFast() {
        Object object = ObjectCreator.createFast();
        Assert.assertNotNull(object);
    }

    @Test
    public void test3MultiFast() {
        Object object;
        for (int i = 0; i < 10_000_000; i++) {
            object = ObjectCreator.createFast();
            Assert.assertNotNull(object);
        }
    }

}

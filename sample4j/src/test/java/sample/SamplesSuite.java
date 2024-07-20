package sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sample.s000.HelloWorldTest;
import sample.s001.BytesTest;
import sample.s002.CallbackTest;
import sample.s003.ReverseBytesTest;
import sample.s004.DirectBufTest;
import sample.s005.PrimitiveArrayTest;
import sample.s006.ObjectCreatorTest;
import sample.s007.FieldFillerTest;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/16/24 10:20 AM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloWorldTest.class,
        BytesTest.class,
        CallbackTest.class,
        ReverseBytesTest.class,
        DirectBufTest.class,
        PrimitiveArrayTest.class,
        ObjectCreatorTest.class,
        FieldFillerTest.class,
})
public class SamplesSuite {
}

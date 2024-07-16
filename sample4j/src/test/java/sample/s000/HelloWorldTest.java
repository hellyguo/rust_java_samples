package sample.s000;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static sample.s000.HelloWorld.hello;

public class HelloWorldTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldTest.class);

    /**
     * The rest is just regular ol' Java!
     */
    @Test
    public void testHello() {
        LOGGER.info("call from rust: {}", hello("nobody"));
        LOGGER.info("call from rust: {}", hello("bob"));
        LOGGER.info("call from rust: {}", hello("nancy"));
    }
}

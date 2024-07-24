package sample.s008;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/24/24 8:58 AM
 */
public class MemClassLoaderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemClassLoaderTest.class);

    @Test
    public void test() {
        MemClassLoader.load();
        try {
            Class<?> clazz = Class.forName("rust.Xyz");
            Method methodHello = clazz.getMethod("hello");
            methodHello.invoke(clazz);
            Method methodCalc = clazz.getMethod("calc", int.class, int.class);
            int val = (Integer) methodCalc.invoke(clazz, 1, 2);
            LOGGER.info("val: {}", val);
        } catch (ClassNotFoundException
                 | NoSuchMethodException
                 | IllegalAccessException
                 | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}

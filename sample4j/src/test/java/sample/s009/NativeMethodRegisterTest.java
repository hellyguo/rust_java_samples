package sample.s009;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/24/24 6:28 PM
 */
public class NativeMethodRegisterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NativeMethodRegisterTest.class);

    @Test
    public void test(){
        try{
            NativeMethodRegister.anotherMethod();
        }catch (UnsatisfiedLinkError e){
            LOGGER.warn("hit error: {}, not ready", e.getMessage(), e);
        }
        NativeMethodRegister.reg();
        String msg = NativeMethodRegister.anotherMethod();
        LOGGER.info("msg: {}", msg);
    }

}

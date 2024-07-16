package sample.s002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallbackImpl implements Callback {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackImpl.class);

    @Override
    public void onReceived(long dataPtr) {
        LOGGER.info("the ptr:{}, as: 0x{}", dataPtr, Long.toHexString(dataPtr));
    }
}

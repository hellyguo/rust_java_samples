package sample.s002;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CallbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackTest.class);

    @Test
    public void test() {
        Caller.defReceivedAction(new CallbackImpl());
        ExecutorService pool = Executors.newFixedThreadPool(32);
        AtomicBoolean active = new AtomicBoolean(true);
        for (int i = 0; i < 32; i++) {
            final int idx = i + 1;
            pool.execute(() -> runInThread(active, idx));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        active.set(false);
        pool.shutdown();
    }

    private void runInThread(AtomicBoolean active, int idx) {
        long count = 0;
        while (active.get()) {
            Caller.receive(idx * 100000000000L + count++);
        }
    }
}

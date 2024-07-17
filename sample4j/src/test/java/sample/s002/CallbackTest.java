package sample.s002;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class CallbackTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackTest.class);

    @Test
    public void test() {
        Caller.defReceivedAction(new CallbackImpl());
        actualTest((idx, count) -> Caller.receive(idx * 100000000000L + count.incrementAndGet()));
    }

    @Test
    public void test2() {
        Caller2.defReceivedAction(new CallbackImpl());
        actualTest((idx, count) -> Caller2.receive(idx * 100000000000L + count.incrementAndGet()));
    }

    private void actualTest(ExecuteTarget target) {
        ExecutorService pool = Executors.newFixedThreadPool(32);
        AtomicBoolean active = new AtomicBoolean(true);
        for (int i = 0; i < 32; i++) {
            final int idx = i + 1;
            pool.execute(() -> runInThread(active, idx, target));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        active.set(false);
        pool.shutdown();
    }

    private void runInThread(AtomicBoolean active, int idx, ExecuteTarget target) {
        AtomicLong count = new AtomicLong(0);
        while (active.get()) {
            target.execute(idx, count);
        }
    }

    private interface ExecuteTarget {
        void execute(int idx, AtomicLong count);
    }
}

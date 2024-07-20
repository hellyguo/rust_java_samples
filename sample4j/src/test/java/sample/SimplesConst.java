package sample;

/**
 * @author Helly Guo
 * <p>
 * Created on 7/20/24 10:38 PM
 */
public final class SimplesConst {

    private static final int DEFAULT_LOOP_TIMES = 1_000_000;

    public static final int LOOP_TIMES = Integer.getInteger("sample.loop_times", DEFAULT_LOOP_TIMES);

    private SimplesConst(){}
}

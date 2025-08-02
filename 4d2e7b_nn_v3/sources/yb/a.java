package yb;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.m;

public final class a extends kotlin.random.a {
    public int e(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    public Random f() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        m.e(current, "current(...)");
        return current;
    }
}

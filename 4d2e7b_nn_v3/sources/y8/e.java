package y8;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class e implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        return g.c(runnable);
    }
}

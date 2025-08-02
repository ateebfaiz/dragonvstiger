package c1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class c {
    public static final ExecutorService b(String str, s sVar, boolean z10) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        b bVar = new b(str, sVar);
        return new ThreadPoolExecutor(z10 ? 1 : 0, 1, 30, TimeUnit.SECONDS, linkedBlockingQueue, bVar);
    }

    /* access modifiers changed from: private */
    public static final Thread c(String str, s sVar, Runnable runnable) {
        return new t(runnable, str, sVar);
    }

    public static final s d(Thread thread) {
        t tVar;
        if (thread instanceof t) {
            tVar = (t) thread;
        } else {
            tVar = null;
        }
        if (tVar == null) {
            return null;
        }
        return tVar.a();
    }
}

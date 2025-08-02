package y0;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class g implements ThreadFactory {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f24846d = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f24847a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f24848b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    private final String f24849c;

    public g() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            threadGroup = Thread.currentThread().getThreadGroup();
        } else {
            threadGroup = securityManager.getThreadGroup();
        }
        this.f24847a = threadGroup;
        this.f24849c = "lottie-" + f24846d.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f24847a;
        Thread thread = new Thread(threadGroup, runnable, this.f24849c + this.f24848b.getAndIncrement(), 0);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}

package i;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadGroup f22005a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22006b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f22007c = new AtomicInteger(1);

    public h(String str) {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f22005a = threadGroup;
        this.f22006b = "MAH_" + str + "-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f22005a;
        Thread thread = new Thread(threadGroup, runnable, this.f22006b + this.f22007c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}

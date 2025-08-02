package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

final class Util$threadFactory$1 implements ThreadFactory {
    final /* synthetic */ boolean $daemon;
    final /* synthetic */ String $name;

    Util$threadFactory$1(String str, boolean z10) {
        this.$name = str;
        this.$daemon = z10;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.$name);
        thread.setDaemon(this.$daemon);
        return thread;
    }
}

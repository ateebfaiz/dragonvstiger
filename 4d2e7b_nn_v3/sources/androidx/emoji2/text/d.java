package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

abstract class d {

    static class a {
        @DoNotInline
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    static Executor b(Handler handler) {
        Objects.requireNonNull(handler);
        return new a(handler);
    }

    static ThreadPoolExecutor c(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread d(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    static Handler e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }
}

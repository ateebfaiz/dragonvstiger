package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor extends TaskExecutor {
    private final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new a());
    private final Object mLock = new Object();
    @Nullable
    private volatile Handler mMainHandler;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f14397a = new AtomicInteger(0);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f14397a.getAndIncrement());
            return thread;
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @NonNull
    private static Handler createAsync(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public void executeOnDiskIO(@NonNull Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public void postToMainThread(@NonNull Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                try {
                    if (this.mMainHandler == null) {
                        this.mMainHandler = createAsync(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.mMainHandler.post(runnable);
    }
}

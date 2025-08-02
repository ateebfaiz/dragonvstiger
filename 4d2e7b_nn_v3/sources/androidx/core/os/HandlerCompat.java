package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static Handler b(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }

        public static boolean c(Handler handler, Runnable runnable, Object obj, long j10) {
            return handler.postDelayed(runnable, obj, j10);
        }
    }

    private static class b {
        public static boolean a(Handler handler, Runnable runnable) {
            return handler.hasCallbacks(runnable);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e10) {
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e10);
            return new Handler(looper);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }

    public static boolean hasCallbacks(@NonNull Handler handler, @NonNull Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.a(handler, runnable);
        }
        try {
            return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(handler, new Object[]{runnable})).booleanValue();
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException e11) {
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e11);
        }
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(handler, runnable, obj, j10);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j10);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(looper, callback);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, callback, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e10) {
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e10);
            return new Handler(looper, callback);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }
}

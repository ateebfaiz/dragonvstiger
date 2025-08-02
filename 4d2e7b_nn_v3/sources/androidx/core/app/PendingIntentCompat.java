package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class a {
        @DoNotInline
        public static void a(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i10, intent, onFinished, handler, str, bundle);
        }
    }

    private static class b {
        @DoNotInline
        public static PendingIntent a(Context context, int i10, Intent intent, int i11) {
            return PendingIntent.getForegroundService(context, i10, intent, i11);
        }
    }

    private static class c implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f14836a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        private PendingIntent.OnFinished f14837b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14838c;

        c(PendingIntent.OnFinished onFinished) {
            this.f14837b = onFinished;
            this.f14838c = false;
        }

        /* access modifiers changed from: private */
        public void j(PendingIntent pendingIntent, Intent intent, int i10, String str, Bundle bundle) {
            boolean z10 = false;
            while (true) {
                try {
                    this.f14836a.await();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.f14837b;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i10, str, bundle);
                this.f14837b = null;
            }
        }

        public void b() {
            this.f14838c = true;
        }

        public void close() {
            if (!this.f14838c) {
                this.f14837b = null;
            }
            this.f14836a.countDown();
        }

        public PendingIntent.OnFinished h() {
            if (this.f14837b == null) {
                return null;
            }
            return new s(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z10, int i10) {
        int i11;
        if (!z10) {
            i11 = 67108864;
        } else if (Build.VERSION.SDK_INT < 31) {
            return i10;
        } else {
            i11 = GameControllerManager.DEVICEFLAG_LIGHT_RGB;
        }
        return i10 | i11;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i11, @Nullable Bundle bundle, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getBroadcast(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @RequiresApi(26)
    @NonNull
    public static PendingIntent getForegroundService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return b.a(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        return PendingIntent.getService(context, i10, intent, addMutabilityFlags(z10, i11));
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, int i10, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        c cVar = new c(onFinished);
        try {
            pendingIntent.send(i10, cVar.h(), handler);
            cVar.b();
            cVar.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i10, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i11, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, addMutabilityFlags(z10, i11));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i10, @NonNull Intent intent, int i11, @Nullable Bundle bundle, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, addMutabilityFlags(z10, i11), bundle);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i10, intent, onFinished, handler, (String) null, (Bundle) null);
    }

    @SuppressLint({"LambdaLast"})
    public static void send(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i10, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        c cVar = new c(onFinished);
        try {
            a.a(pendingIntent, context, i10, intent, onFinished, handler, str, bundle);
            cVar.b();
            cVar.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}

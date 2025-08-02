package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        b future;
        Object tag;

        Completer() {
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            b bVar = this.future;
            if (bVar != null && !bVar.isDone()) {
                bVar.c(new a("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }
            if (!this.attemptedSetting && (resolvableFuture = this.cancellationFuture) != null) {
                resolvableFuture.set(null);
            }
        }

        /* access modifiers changed from: package-private */
        public void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T t10) {
            boolean z10 = true;
            this.attemptedSetting = true;
            b bVar = this.future;
            if (bVar == null || !bVar.b(t10)) {
                z10 = false;
            }
            if (z10) {
                setCompletedNormally();
            }
            return z10;
        }

        public boolean setCancelled() {
            boolean z10 = true;
            this.attemptedSetting = true;
            b bVar = this.future;
            if (bVar == null || !bVar.a(true)) {
                z10 = false;
            }
            if (z10) {
                setCompletedNormally();
            }
            return z10;
        }

        public boolean setException(@NonNull Throwable th) {
            boolean z10 = true;
            this.attemptedSetting = true;
            b bVar = this.future;
            if (bVar == null || !bVar.c(th)) {
                z10 = false;
            }
            if (z10) {
                setCompletedNormally();
            }
            return z10;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    static final class a extends Throwable {
        a(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    private static final class b implements ListenableFuture {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference f14508a;

        /* renamed from: b  reason: collision with root package name */
        private final AbstractResolvableFuture f14509b = new a();

        class a extends AbstractResolvableFuture {
            a() {
            }

            /* access modifiers changed from: protected */
            public String pendingToString() {
                Completer completer = (Completer) b.this.f14508a.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.tag + "]";
            }
        }

        b(Completer completer) {
            this.f14508a = new WeakReference(completer);
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z10) {
            return this.f14509b.cancel(z10);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.f14509b.addListener(runnable, executor);
        }

        /* access modifiers changed from: package-private */
        public boolean b(Object obj) {
            return this.f14509b.set(obj);
        }

        /* access modifiers changed from: package-private */
        public boolean c(Throwable th) {
            return this.f14509b.setException(th);
        }

        public boolean cancel(boolean z10) {
            Completer completer = (Completer) this.f14508a.get();
            boolean cancel = this.f14509b.cancel(z10);
            if (cancel && completer != null) {
                completer.fireCancellationListeners();
            }
            return cancel;
        }

        public Object get() {
            return this.f14509b.get();
        }

        public boolean isCancelled() {
            return this.f14509b.isCancelled();
        }

        public boolean isDone() {
            return this.f14509b.isDone();
        }

        public String toString() {
            return this.f14509b.toString();
        }

        public Object get(long j10, TimeUnit timeUnit) {
            return this.f14509b.get(j10, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> ListenableFuture<T> getFuture(@NonNull Resolver<T> resolver) {
        Completer completer = new Completer();
        b bVar = new b(completer);
        completer.future = bVar;
        completer.tag = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.tag = attachCompleter;
            }
        } catch (Exception e10) {
            bVar.c(e10);
        }
        return bVar;
    }
}

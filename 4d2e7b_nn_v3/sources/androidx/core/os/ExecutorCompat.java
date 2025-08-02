package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {

    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f15036a;

        a(Handler handler) {
            this.f15036a = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f15036a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.f15036a + " is shutting down");
            }
        }
    }

    private ExecutorCompat() {
    }

    @NonNull
    public static Executor create(@NonNull Handler handler) {
        return new a(handler);
    }
}

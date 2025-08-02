package androidx.work.impl.utils.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    public boolean set(@Nullable V v10) {
        return super.set(v10);
    }

    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

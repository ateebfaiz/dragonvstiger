package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

@KeepForSdk
public final class ListenerHolder<L> {
    private final Executor zaa;
    @Nullable
    private volatile L zab;
    @Nullable
    private volatile ListenerKey<L> zac;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final L zaa;
        private final String zab;

        @KeepForSdk
        ListenerKey(L l10, String str) {
            this.zaa = l10;
            this.zab = str;
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.zaa != listenerKey.zaa || !this.zab.equals(listenerKey.zab)) {
                return false;
            }
            return true;
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        @NonNull
        @KeepForSdk
        public String toIdString() {
            String str = this.zab;
            int identityHashCode = System.identityHashCode(this.zaa);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
            sb2.append(str);
            sb2.append("@");
            sb2.append(identityHashCode);
            return sb2.toString();
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(@NonNull L l10);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    @KeepForSdk
    ListenerHolder(@NonNull Looper looper, @NonNull L l10, @NonNull String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(l10, "Listener must not be null");
        this.zac = new ListenerKey<>(l10, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    @KeepForSdk
    @Nullable
    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public void notifyListener(@NonNull Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new zacb(this, notifier));
    }

    /* access modifiers changed from: package-private */
    public final void zaa(Notifier<? super L> notifier) {
        L l10 = this.zab;
        if (l10 == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(l10);
        } catch (RuntimeException e10) {
            notifier.onNotifyListenerFailed();
            throw e10;
        }
    }

    @KeepForSdk
    ListenerHolder(@NonNull Executor executor, @NonNull L l10, @NonNull String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(l10, "Listener must not be null");
        this.zac = new ListenerKey<>(l10, Preconditions.checkNotEmpty(str));
    }
}

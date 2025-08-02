package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> zaa = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(@NonNull L l10, @NonNull Looper looper, @NonNull String str) {
        Preconditions.checkNotNull(l10, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l10, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(@NonNull L l10, @NonNull String str) {
        Preconditions.checkNotNull(l10, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l10, str);
    }

    @NonNull
    public final <L> ListenerHolder<L> zaa(@NonNull L l10, @NonNull Looper looper, @NonNull String str) {
        ListenerHolder<L> createListenerHolder = createListenerHolder(l10, looper, "NO_TYPE");
        this.zaa.add(createListenerHolder);
        return createListenerHolder;
    }

    public final void zab() {
        for (ListenerHolder<?> clear : this.zaa) {
            clear.clear();
        }
        this.zaa.clear();
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(@NonNull L l10, @NonNull Executor executor, @NonNull String str) {
        Preconditions.checkNotNull(l10, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l10, str);
    }
}

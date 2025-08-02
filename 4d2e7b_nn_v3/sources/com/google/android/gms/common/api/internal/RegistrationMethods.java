package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @NonNull
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;
    @NonNull
    public final UnregisterListenerMethod<A, L> zaa;
    @NonNull
    public final Runnable zab;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        /* access modifiers changed from: private */
        public RemoteCall<A, TaskCompletionSource<Void>> zaa;
        /* access modifiers changed from: private */
        public RemoteCall<A, TaskCompletionSource<Boolean>> zab;
        private Runnable zac = zacj.zaa;
        private ListenerHolder<L> zad;
        private Feature[] zae;
        private boolean zaf = true;
        private int zag;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z10;
            boolean z11;
            boolean z12 = false;
            if (this.zaa != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Must set register function");
            if (this.zab != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Must set unregister function");
            if (this.zad != null) {
                z12 = true;
            }
            Preconditions.checkArgument(z12, "Must set holder");
            return new RegistrationMethods<>(new j0(this, this.zad, this.zae, this.zaf, this.zag), new k0(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac, (zacn) null);
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(@NonNull Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> register(@NonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z10) {
            this.zaf = z10;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> setFeatures(@NonNull Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> setMethodKey(int i10) {
            this.zag = i10;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> unregister(@NonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> withHolder(@NonNull ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }

        /* synthetic */ Builder(zacm zacm) {
        }
    }

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacn) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>((zacm) null);
    }
}

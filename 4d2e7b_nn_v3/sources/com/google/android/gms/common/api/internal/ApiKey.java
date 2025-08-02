package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class ApiKey<O extends Api.ApiOptions> {
    private final int zaa;
    private final Api<O> zab;
    @Nullable
    private final O zac;
    @Nullable
    private final String zad;

    private ApiKey(Api<O> api, @Nullable O o10, @Nullable String str) {
        this.zab = api;
        this.zac = o10;
        this.zad = str;
        this.zaa = Objects.hashCode(api, o10, str);
    }

    @NonNull
    public static <O extends Api.ApiOptions> ApiKey<O> zaa(@NonNull Api<O> api, @Nullable O o10, @Nullable String str) {
        return new ApiKey<>(api, o10, str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!Objects.equal(this.zab, apiKey.zab) || !Objects.equal(this.zac, apiKey.zac) || !Objects.equal(this.zad, apiKey.zad)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }

    @NonNull
    public final String zab() {
        return this.zab.zad();
    }
}

package com.google.android.gms.common.internal.service;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Common {
    @NonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY;
    public static final zae zaa = new zae();
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zab;

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        a aVar = new a();
        zab = aVar;
        API = new Api<>("Common.API", aVar, clientKey);
    }
}

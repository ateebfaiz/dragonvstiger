package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.p000authapiphone.zzw;
import com.google.android.gms.tasks.Task;

public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi {
    private static final Api.ClientKey<zzw> zza;
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzw> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        a aVar = new a();
        zzb = aVar;
        zzc = new Api<>("SmsRetriever.API", aVar, clientKey);
    }

    public SmsRetrieverClient(@NonNull Activity activity) {
        super(activity, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public abstract Task<Void> startSmsRetriever();

    @NonNull
    public abstract Task<Void> startSmsUserConsent(@Nullable String str);

    public SmsRetrieverClient(@NonNull Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}

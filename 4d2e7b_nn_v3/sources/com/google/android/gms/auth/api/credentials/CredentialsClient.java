package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.p001authapi.zbn;
import com.google.android.gms.tasks.Task;

@Deprecated
public class CredentialsClient extends GoogleApi<Auth.AuthCredentialsOptions> {
    CredentialsClient(@NonNull Activity activity, @NonNull Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(activity, Auth.CREDENTIALS_API, authCredentialsOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @NonNull
    @Deprecated
    public Task<Void> delete(@NonNull Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), credential));
    }

    @NonNull
    @Deprecated
    public Task<Void> disableAutoSignIn() {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
    }

    @NonNull
    @Deprecated
    public PendingIntent getHintPickerIntent(@NonNull HintRequest hintRequest) {
        return zbn.zba(getApplicationContext(), (Auth.AuthCredentialsOptions) getApiOptions(), hintRequest, ((Auth.AuthCredentialsOptions) getApiOptions()).zbd());
    }

    @NonNull
    @Deprecated
    public Task<CredentialRequestResponse> request(@NonNull CredentialRequest credentialRequest) {
        return PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
    }

    @NonNull
    @Deprecated
    public Task<Void> save(@NonNull Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), credential));
    }

    CredentialsClient(@NonNull Context context, @NonNull Auth.AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, authCredentialsOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}

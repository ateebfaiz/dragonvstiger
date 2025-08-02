package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    @VisibleForTesting
    static int zba = 1;
    private static final b zbb = new b((zba) null);

    GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int zba() {
        int i10;
        try {
            i10 = zba;
            if (i10 == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
                int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable == 0) {
                    i10 = 4;
                    zba = 4;
                } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, (String) null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i10 = 2;
                    zba = 2;
                } else {
                    i10 = 3;
                    zba = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i10;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int zba2 = zba();
        int i10 = zba2 - 1;
        if (zba2 == 0) {
            throw null;
        } else if (i10 == 2) {
            return zbm.zba(applicationContext, (GoogleSignInOptions) getApiOptions());
        } else {
            if (i10 != 3) {
                return zbm.zbb(applicationContext, (GoogleSignInOptions) getApiOptions());
            }
            return zbm.zbc(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
    }

    @NonNull
    public Task<Void> revokeAccess() {
        boolean z10;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient, applicationContext, z10));
    }

    @NonNull
    public Task<Void> signOut() {
        boolean z10;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbg(asGoogleApiClient, applicationContext, z10));
    }

    @NonNull
    public Task<GoogleSignInAccount> silentSignIn() {
        boolean z10;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) getApiOptions();
        if (zba() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        return PendingResultUtil.toTask(zbm.zbe(asGoogleApiClient, applicationContext, googleSignInOptions, z10), zbb);
    }

    GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}

package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;

final class h implements LoaderManager.LoaderCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignInHubActivity f6632a;

    /* synthetic */ h(SignInHubActivity signInHubActivity, zbv zbv) {
        this.f6632a = signInHubActivity;
    }

    public final Loader onCreateLoader(int i10, Bundle bundle) {
        return new zbc(this.f6632a, GoogleApiClient.getAllClients());
    }

    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        Void voidR = (Void) obj;
        SignInHubActivity signInHubActivity = this.f6632a;
        signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
        this.f6632a.finish();
    }

    public final void onLoaderReset(Loader loader) {
    }
}

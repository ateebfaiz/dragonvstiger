package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

final class a extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f7823a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ProviderInstaller.ProviderInstallListener f7824b;

    a(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f7823a = context;
        this.f7824b = providerInstallListener;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.installIfNeeded(this.f7823a);
            return 0;
        } catch (GooglePlayServicesRepairableException e10) {
            return Integer.valueOf(e10.getConnectionStatusCode());
        } catch (GooglePlayServicesNotAvailableException e11) {
            return Integer.valueOf(e11.errorCode);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.f7824b.onProviderInstalled();
            return;
        }
        this.f7824b.onProviderInstallFailed(num.intValue(), ProviderInstaller.zza.getErrorResolutionIntent(this.f7823a, num.intValue(), "pi"));
    }
}

package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

final class g0 implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Api.Client f6691a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ApiKey f6692b;

    /* renamed from: c  reason: collision with root package name */
    private IAccountAccessor f6693c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f6694d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f6695e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f6696f;

    public g0(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f6696f = googleApiManager;
        this.f6691a = client;
        this.f6692b = apiKey;
    }

    /* access modifiers changed from: private */
    public final void e() {
        IAccountAccessor iAccountAccessor;
        if (this.f6695e && (iAccountAccessor = this.f6693c) != null) {
            this.f6691a.getRemoteService(iAccountAccessor, this.f6694d);
        }
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.f6696f.zat.post(new f0(this, connectionResult));
    }

    public final void zae(ConnectionResult connectionResult) {
        zabq zabq = (zabq) this.f6696f.zap.get(this.f6692b);
        if (zabq != null) {
            zabq.zas(connectionResult);
        }
    }

    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.f6693c = iAccountAccessor;
        this.f6694d = set;
        e();
    }
}

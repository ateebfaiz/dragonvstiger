package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;

final class l extends q {

    /* renamed from: b  reason: collision with root package name */
    private final Map f6715b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaaw f6716c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(zaaw zaaw, Map map) {
        super(zaaw, (zaau) null);
        this.f6716c = zaaw;
        this.f6715b = map;
    }

    public final void a() {
        zal zal = new zal(this.f6716c.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f6715b.keySet()) {
            if (!client.requiresGooglePlayServices() || ((i) this.f6715b.get(client)).f6705c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i10 = -1;
        int i11 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i11 < size) {
                i10 = zal.zab(this.f6716c.zac, (Api.Client) arrayList.get(i11));
                i11++;
                if (i10 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i11 < size2) {
                i10 = zal.zab(this.f6716c.zac, (Api.Client) arrayList2.get(i11));
                i11++;
                if (i10 == 0) {
                    break;
                }
            }
        }
        if (i10 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i10, (PendingIntent) null);
            zaaw zaaw = this.f6716c;
            zaaw.zaa.zal(new j(this, zaaw, connectionResult));
            return;
        }
        zaaw zaaw2 = this.f6716c;
        if (zaaw2.zam && zaaw2.zak != null) {
            zaaw2.zak.zab();
        }
        for (Api.Client client2 : this.f6715b.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.f6715b.get(client2);
            if (!client2.requiresGooglePlayServices() || zal.zab(this.f6716c.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaaw3 = this.f6716c;
                zaaw3.zaa.zal(new k(this, zaaw3, connectionProgressReportCallbacks));
            }
        }
    }
}

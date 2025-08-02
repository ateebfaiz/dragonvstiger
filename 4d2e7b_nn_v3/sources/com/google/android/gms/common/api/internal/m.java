package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class m extends q {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f6718b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaaw f6719c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(zaaw zaaw, ArrayList arrayList) {
        super(zaaw, (zaau) null);
        this.f6719c = zaaw;
        this.f6718b = arrayList;
    }

    public final void a() {
        zaaw zaaw = this.f6719c;
        zaaw.zaa.zag.zad = zaaw.zao(zaaw);
        ArrayList arrayList = this.f6718b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zaaw zaaw2 = this.f6719c;
            ((Api.Client) arrayList.get(i10)).getRemoteService(zaaw2.zao, zaaw2.zaa.zag.zad);
        }
    }
}

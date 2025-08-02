package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.m;
import q5.g0;

public final class g extends g0 {

    /* renamed from: w  reason: collision with root package name */
    private final String f4518w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str, (String) null);
        m.f(context, "context");
        m.f(str, "applicationId");
        m.f(str2, "objectId");
        this.f4518w = str2;
    }

    /* access modifiers changed from: protected */
    public void d(Bundle bundle) {
        m.f(bundle, "data");
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.f4518w);
    }
}

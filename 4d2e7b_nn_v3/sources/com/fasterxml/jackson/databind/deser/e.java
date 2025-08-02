package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.util.j;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.Serializable;
import java.util.HashMap;

public final class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final j f5235a;

    /* renamed from: b  reason: collision with root package name */
    protected final HashMap f5236b;

    public e() {
        this(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        this.f5236b.clear();
        return this;
    }

    public e(int i10) {
        this.f5236b = new HashMap(8);
        this.f5235a = new j(Math.min(64, i10 >> 2), i10);
    }
}

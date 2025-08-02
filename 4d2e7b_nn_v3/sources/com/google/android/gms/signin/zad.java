package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zad {
    public static final Api.ClientKey<SignInClientImpl> zaa;
    @ShowFirstParty
    public static final Api.ClientKey<SignInClientImpl> zab;
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zac;
    static final Api.AbstractClientBuilder<SignInClientImpl, zac> zad;
    public static final Scope zae = new Scope(Scopes.PROFILE);
    public static final Scope zaf = new Scope("email");
    public static final Api<SignInOptions> zag;
    public static final Api<zac> zah;

    static {
        Api.ClientKey<SignInClientImpl> clientKey = new Api.ClientKey<>();
        zaa = clientKey;
        Api.ClientKey<SignInClientImpl> clientKey2 = new Api.ClientKey<>();
        zab = clientKey2;
        a aVar = new a();
        zac = aVar;
        b bVar = new b();
        zad = bVar;
        zag = new Api<>("SignIn.API", aVar, clientKey);
        zah = new Api<>("SignIn.INTERNAL_API", bVar, clientKey2);
    }
}

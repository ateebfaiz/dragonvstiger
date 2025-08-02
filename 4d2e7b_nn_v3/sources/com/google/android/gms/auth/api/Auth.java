package com.google.android.gms.auth.api;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.p001authapi.zbl;

public final class Auth {
    @NonNull
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
    @NonNull
    public static final CredentialsApi CredentialsApi = new zbl();
    @NonNull
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
    @NonNull
    public static final GoogleSignInApi GoogleSignInApi = new zbd();
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    @NonNull
    public static final Api.ClientKey zba;
    @NonNull
    public static final Api.ClientKey zbb;
    private static final Api.AbstractClientBuilder zbc;
    private static final Api.AbstractClientBuilder zbd;

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        @NonNull
        public static final AuthCredentialsOptions zba = new AuthCredentialsOptions(new Builder());
        /* access modifiers changed from: private */
        public final String zbb = null;
        /* access modifiers changed from: private */
        public final boolean zbc;
        /* access modifiers changed from: private */
        @Nullable
        public final String zbd;

        @Deprecated
        public static class Builder {
            @NonNull
            protected Boolean zba = Boolean.FALSE;
            @Nullable
            protected String zbb;

            public Builder() {
            }

            @NonNull
            public Builder forceEnableSaveDialog() {
                this.zba = Boolean.TRUE;
                return this;
            }

            @ShowFirstParty
            @NonNull
            public final Builder zba(@NonNull String str) {
                this.zbb = str;
                return this;
            }

            @ShowFirstParty
            public Builder(@NonNull AuthCredentialsOptions authCredentialsOptions) {
                String unused = authCredentialsOptions.zbb;
                this.zba = Boolean.valueOf(authCredentialsOptions.zbc);
                this.zbb = authCredentialsOptions.zbd;
            }
        }

        public AuthCredentialsOptions(@NonNull Builder builder) {
            this.zbc = builder.zba.booleanValue();
            this.zbd = builder.zbb;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            String str = authCredentialsOptions.zbb;
            if (!Objects.equal((Object) null, (Object) null) || this.zbc != authCredentialsOptions.zbc || !Objects.equal(this.zbd, authCredentialsOptions.zbd)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(null, Boolean.valueOf(this.zbc), this.zbd);
        }

        @NonNull
        public final Bundle zba() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", (String) null);
            bundle.putBoolean("force_save_dialog", this.zbc);
            bundle.putString("log_session_id", this.zbd);
            return bundle;
        }

        @Nullable
        public final String zbd() {
            return this.zbd;
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zbb = clientKey2;
        a aVar = new a();
        zbc = aVar;
        b bVar = new b();
        zbd = bVar;
        CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", aVar, clientKey);
        GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", bVar, clientKey2);
    }

    private Auth() {
    }
}

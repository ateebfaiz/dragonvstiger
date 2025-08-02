package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.credentials.GetCustomCredentialOption;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetSignInWithGoogleOption extends GetCustomCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String zza;
    private final String zzb;
    private final String zzc;

    public static final class Builder {
        private final String zza;
        private String zzb;
        private String zzc;

        public Builder(@NonNull String str) {
            m.f(str, "serverClientId");
            this.zza = str;
        }

        public final GetSignInWithGoogleOption build() {
            return new GetSignInWithGoogleOption(this.zza, this.zzb, this.zzc);
        }

        public final Builder setHostedDomainFilter(@NonNull String str) {
            m.f(str, "hostedDomainFilter");
            this.zzb = str;
            return this;
        }

        public final Builder setNonce(String str) {
            this.zzc = str;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static final Bundle zza(@NonNull String str, String str2, String str3, boolean z10) {
            m.f(str, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID", str);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE", str3);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER", str2);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_AUTO_SELECT_ENABLED", true);
            bundle.putString(GoogleIdTokenCredential.BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE, GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL);
            return bundle;
        }

        public final GetSignInWithGoogleOption createFrom(@NonNull Bundle bundle) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID");
                m.c(string);
                return new GetSignInWithGoogleOption(string, bundle.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER"), bundle.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE"));
            } catch (Exception e10) {
                throw new GoogleIdTokenParsingException(e10);
            }
        }

        public /* synthetic */ Companion(@NonNull DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(@NonNull String str, String str2, String str3) {
        super(GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL, Companion.zza(str, str2, str3, true), Companion.zza(str, str2, str3, true), true, true, (Set) null, 32, (DefaultConstructorMarker) null);
        m.f(str, "serverClientId");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    public static final GetSignInWithGoogleOption createFrom(@NonNull Bundle bundle) {
        return Companion.createFrom(bundle);
    }

    @Nullable
    public final String getHostedDomainFilter() {
        return this.zzb;
    }

    @Nullable
    public final String getNonce() {
        return this.zzc;
    }

    public final String getServerClientId() {
        return this.zza;
    }
}

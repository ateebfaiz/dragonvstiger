package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.credentials.GetCustomCredentialOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetGoogleIdOption extends GetCustomCredentialOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private final String zzd;
    private final List zze;
    private final boolean zzf;
    private final boolean zzg;

    public static final class Builder {
        private String zza = "";
        private String zzb;
        private String zzc;
        private boolean zzd = true;
        private boolean zze;
        private boolean zzf;
        private List zzg;

        public final Builder associateLinkedAccounts(@NonNull String str, List<String> list) {
            List list2;
            m.f(str, "linkedServiceId");
            if (str.length() > 0) {
                this.zzb = str;
                if (list != null) {
                    list2 = r.w0(list);
                } else {
                    list2 = null;
                }
                this.zzg = list2;
                return this;
            }
            throw new IllegalArgumentException("linkedServiceId must be provided if you want to associate linked accounts.");
        }

        public final GetGoogleIdOption build() {
            return new GetGoogleIdOption(this.zza, this.zzc, this.zzd, this.zzb, this.zzg, this.zze, this.zzf);
        }

        public final Builder setAutoSelectEnabled(boolean z10) {
            this.zzf = z10;
            return this;
        }

        public final Builder setFilterByAuthorizedAccounts(boolean z10) {
            this.zzd = z10;
            return this;
        }

        public final Builder setNonce(String str) {
            this.zzc = str;
            return this;
        }

        public final Builder setRequestVerifiedPhoneNumber(boolean z10) {
            this.zze = z10;
            return this;
        }

        public final Builder setServerClientId(@NonNull String str) {
            m.f(str, "serverClientId");
            if (str.length() > 0) {
                this.zza = str;
                return this;
            }
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static final Bundle zza(@NonNull String str, String str2, boolean z10, String str3, List list, boolean z11, boolean z12) {
            ArrayList arrayList;
            m.f(str, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID", str);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE", str2);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", z10);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID", str3);
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list);
            }
            bundle.putStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES", arrayList);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", z11);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", z12);
            return bundle;
        }

        public final GetGoogleIdOption createFrom(@NonNull Bundle bundle) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID");
                m.c(string);
                return new GetGoogleIdOption(string, bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE"), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", true), bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID"), bundle.getStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES"), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", false), bundle.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", false));
            } catch (Exception e10) {
                throw new GoogleIdTokenParsingException(e10);
            }
        }

        public /* synthetic */ Companion(@NonNull DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(@NonNull String str, String str2, boolean z10, String str3, List<String> list, boolean z11, boolean z12) {
        super(GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL, Companion.zza(str, str2, z10, str3, list, z11, z12), Companion.zza(str, str2, z10, str3, list, z11, z12), true, z12, (Set) null, 32, (DefaultConstructorMarker) null);
        boolean z13 = z10;
        boolean z14 = z11;
        m.f(str, "serverClientId");
        this.zza = str;
        this.zzb = str2;
        this.zzc = z13;
        this.zzd = str3;
        this.zze = list;
        this.zzf = z14;
        this.zzg = z12;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        } else if (z13 && z14) {
            throw new IllegalArgumentException("filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true;  the Verified Phone Number feature only works in sign-ups.");
        }
    }

    public static final GetGoogleIdOption createFrom(@NonNull Bundle bundle) {
        return Companion.createFrom(bundle);
    }

    public final boolean getAutoSelectEnabled() {
        return this.zzg;
    }

    public final boolean getFilterByAuthorizedAccounts() {
        return this.zzc;
    }

    @Nullable
    public final List<String> getIdTokenDepositionScopes() {
        return this.zze;
    }

    @Nullable
    public final String getLinkedServiceId() {
        return this.zzd;
    }

    @Nullable
    public final String getNonce() {
        return this.zzb;
    }

    public final boolean getRequestVerifiedPhoneNumber() {
        return this.zzf;
    }

    public final String getServerClientId() {
        return this.zza;
    }
}

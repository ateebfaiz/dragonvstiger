package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {
    private final Account zaa;
    private final Set<Scope> zab;
    private final Set<Scope> zac;
    private final Map<Api<?>, zab> zad;
    private final int zae;
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    @KeepForSdk
    public static final class Builder {
        private Account zaa;
        private ArraySet<Scope> zab;
        private String zac;
        private String zad;
        private SignInOptions zae = SignInOptions.zaa;

        @NonNull
        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, (Map<Api<?>, zab>) null, 0, (View) null, this.zac, this.zad, this.zae, false);
        }

        @NonNull
        @KeepForSdk
        public Builder setRealClientPackageName(@NonNull String str) {
            this.zac = str;
            return this;
        }

        @NonNull
        public final Builder zaa(@NonNull Collection<Scope> collection) {
            if (this.zab == null) {
                this.zab = new ArraySet<>();
            }
            this.zab.addAll(collection);
            return this;
        }

        @NonNull
        public final Builder zab(Account account) {
            this.zaa = account;
            return this;
        }

        @NonNull
        public final Builder zac(@NonNull String str) {
            this.zad = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i10, View view, @NonNull String str, @NonNull String str2, SignInOptions signInOptions) {
        this(account, set, map, i10, view, str, str2, signInOptions, false);
    }

    @NonNull
    @KeepForSdk
    public static ClientSettings createDefault(@NonNull Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    @KeepForSdk
    @Nullable
    public Account getAccount() {
        return this.zaa;
    }

    @KeepForSdk
    @Deprecated
    @Nullable
    public String getAccountName() {
        Account account = this.zaa;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.zaa;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getApplicableScopes(@NonNull Api<?> api) {
        zab zab2 = this.zad.get(api);
        if (zab2 == null || zab2.zaa.isEmpty()) {
            return this.zab;
        }
        HashSet hashSet = new HashSet(this.zab);
        hashSet.addAll(zab2.zaa);
        return hashSet;
    }

    @KeepForSdk
    public int getGravityForPopups() {
        return this.zae;
    }

    @NonNull
    @KeepForSdk
    public String getRealClientPackageName() {
        return this.zag;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    @KeepForSdk
    @Nullable
    public View getViewForPopups() {
        return this.zaf;
    }

    @NonNull
    public final SignInOptions zaa() {
        return this.zai;
    }

    @Nullable
    public final Integer zab() {
        return this.zaj;
    }

    @Nullable
    public final String zac() {
        return this.zah;
    }

    @NonNull
    public final Map<Api<?>, zab> zad() {
        return this.zad;
    }

    public final void zae(@NonNull Integer num) {
        this.zaj = num;
    }

    public ClientSettings(Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i10, View view, @NonNull String str, @NonNull String str2, SignInOptions signInOptions, boolean z10) {
        this.zaa = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zab = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.zad = map;
        this.zaf = view;
        this.zae = i10;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        for (zab zab2 : map.values()) {
            hashSet.addAll(zab2.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}

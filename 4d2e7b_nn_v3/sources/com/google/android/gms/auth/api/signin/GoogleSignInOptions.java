package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zae();
    @NonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    @NonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    @NonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope(Scopes.PROFILE);
    @NonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");
    @NonNull
    @VisibleForTesting
    public static final Scope zac = new Scope(Scopes.OPEN_ID);
    @NonNull
    @VisibleForTesting
    public static final Scope zad;
    @NonNull
    @VisibleForTesting
    public static final Scope zae = new Scope(Scopes.GAMES);
    private static Comparator<Scope> zag = new a();
    @SafeParcelable.VersionField(id = 1)
    final int zaf;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getScopes", id = 2)
    public final ArrayList<Scope> zah;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    @Nullable
    public Account zai;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    public boolean zaj;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    public final boolean zak;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    public final boolean zal;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    @Nullable
    public String zam;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    @Nullable
    public String zan;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    public ArrayList<GoogleSignInOptionsExtensionParcelable> zao;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)
    @Nullable
    public String zap;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaq;

    public static final class Builder {
        private Set<Scope> zaa = new HashSet();
        private boolean zab;
        private boolean zac;
        private boolean zad;
        @Nullable
        private String zae;
        @Nullable
        private Account zaf;
        @Nullable
        private String zag;
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zah = new HashMap();
        @Nullable
        private String zai;

        public Builder() {
        }

        private final String zaa(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zae;
            boolean z10 = true;
            if (str2 != null && !str2.equals(str)) {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "two different server client ids provided");
            return str;
        }

        @NonNull
        public Builder addExtension(@NonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.zah.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.zaa.addAll(impliedScopes);
                }
                this.zah.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @NonNull
        public GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae)) {
                Set<Scope> set = this.zaa;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.zaa.remove(scope);
                }
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, (zad) null);
        }

        @NonNull
        public Builder requestEmail() {
            this.zaa.add(GoogleSignInOptions.zab);
            return this;
        }

        @NonNull
        public Builder requestId() {
            this.zaa.add(GoogleSignInOptions.zac);
            return this;
        }

        @NonNull
        public Builder requestIdToken(@NonNull String str) {
            this.zad = true;
            zaa(str);
            this.zae = str;
            return this;
        }

        @NonNull
        public Builder requestProfile() {
            this.zaa.add(GoogleSignInOptions.zaa);
            return this;
        }

        @NonNull
        public Builder requestScopes(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        public Builder requestServerAuthCode(@NonNull String str) {
            requestServerAuthCode(str, false);
            return this;
        }

        @NonNull
        public Builder setAccountName(@NonNull String str) {
            this.zaf = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        @NonNull
        public Builder setHostedDomain(@NonNull String str) {
            this.zag = Preconditions.checkNotEmpty(str);
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setLogSessionId(@NonNull String str) {
            this.zai = str;
            return this;
        }

        @NonNull
        public Builder requestServerAuthCode(@NonNull String str, boolean z10) {
            this.zab = true;
            zaa(str);
            this.zae = str;
            this.zac = z10;
            return this;
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zah);
            this.zab = googleSignInOptions.zak;
            this.zac = googleSignInOptions.zal;
            this.zad = googleSignInOptions.zaj;
            this.zae = googleSignInOptions.zam;
            this.zaf = googleSignInOptions.zai;
            this.zag = googleSignInOptions.zan;
            this.zah = GoogleSignInOptions.zam(googleSignInOptions.zao);
            this.zai = googleSignInOptions.zap;
        }
    }

    static {
        Scope scope = new Scope(Scopes.GAMES_LITE);
        zad = scope;
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        DEFAULT_SIGN_IN = builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = builder2.build();
    }

    /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3, zad zad2) {
        this(3, (ArrayList<Scope>) arrayList, account, z10, z11, z12, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    @Nullable
    public static GoogleSignInOptions zab(@Nullable String str) throws JSONException {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z10 = jSONObject.getBoolean("idTokenRequested");
        boolean z11 = jSONObject.getBoolean("serverAuthRequested");
        boolean z12 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, (ArrayList<Scope>) arrayList, account, z10, z11, z12, str3, str4, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) new HashMap(), (String) null);
    }

    /* access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zam(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.getType()), next);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.getAccount()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zao     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 > 0) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zao     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zah     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zah     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.zai     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.getAccount()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.getAccount()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.zam     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.zam     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.zal     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.zaj     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.isIdTokenRequested()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.zak     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.isServerAuthCodeRequested()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.zap     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.getLogSessionId()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @KeepForSdk
    @Nullable
    public Account getAccount() {
        return this.zai;
    }

    @NonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zao;
    }

    @KeepForSdk
    @Nullable
    public String getLogSessionId() {
        return this.zap;
    }

    @NonNull
    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zah;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @NonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zah);
    }

    @KeepForSdk
    @Nullable
    public String getServerClientId() {
        return this.zam;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zah;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(arrayList2.get(i10).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.zai);
        hashAccumulator.addObject(this.zam);
        hashAccumulator.zaa(this.zal);
        hashAccumulator.zaa(this.zaj);
        hashAccumulator.zaa(this.zak);
        hashAccumulator.addObject(this.zap);
        return hashAccumulator.hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.zal;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.zaj;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.zak;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaf);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zan, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zaf() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zah, zag);
            Iterator<Scope> it = this.zah.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.zai;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.zaj);
            jSONObject.put("forceCodeForRefreshToken", this.zal);
            jSONObject.put("serverAuthRequested", this.zak);
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("serverClientId", this.zam);
            }
            if (!TextUtils.isEmpty(this.zan)) {
                jSONObject.put("hostedDomain", this.zan);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    @SafeParcelable.Constructor
    GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) @Nullable Account account, @SafeParcelable.Param(id = 4) boolean z10, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) boolean z12, @SafeParcelable.Param(id = 7) @Nullable String str, @SafeParcelable.Param(id = 8) @Nullable String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @SafeParcelable.Param(id = 10) @Nullable String str3) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, zam(arrayList2), str3);
    }

    private GoogleSignInOptions(int i10, ArrayList<Scope> arrayList, @Nullable Account account, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.zaf = i10;
        this.zah = arrayList;
        this.zai = account;
        this.zaj = z10;
        this.zak = z11;
        this.zal = z12;
        this.zam = str;
        this.zan = str2;
        this.zao = new ArrayList<>(map.values());
        this.zaq = map;
        this.zap = str3;
    }
}

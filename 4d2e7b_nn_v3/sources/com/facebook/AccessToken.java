package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.facebook.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.q0;

public final class AccessToken implements Parcelable {
    private static final Date C;
    public static final Parcelable.Creator<AccessToken> CREATOR = new b();
    public static final c N0 = new c((DefaultConstructorMarker) null);
    private static final Date X;
    private static final Date Y = new Date();
    private static final d Z = d.FACEBOOK_APPLICATION_WEB;

    /* renamed from: a  reason: collision with root package name */
    private final Date f19464a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f19465b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f19466c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f19467d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19468e;

    /* renamed from: f  reason: collision with root package name */
    private final d f19469f;

    /* renamed from: g  reason: collision with root package name */
    private final Date f19470g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19471h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19472i;

    /* renamed from: j  reason: collision with root package name */
    private final Date f19473j;

    /* renamed from: w  reason: collision with root package name */
    private final String f19474w;

    public interface a {
        void a(l lVar);
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        /* renamed from: a */
        public AccessToken createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new AccessToken(parcel);
        }

        /* renamed from: b */
        public AccessToken[] newArray(int i10) {
            return new AccessToken[i10];
        }
    }

    public static final class c {
        private c() {
        }

        public final AccessToken a(AccessToken accessToken) {
            m.f(accessToken, "current");
            return new AccessToken(accessToken.m(), accessToken.c(), accessToken.n(), accessToken.k(), accessToken.f(), accessToken.g(), accessToken.l(), new Date(), new Date(), accessToken.e(), (String) null, 1024, (DefaultConstructorMarker) null);
        }

        public final AccessToken b(JSONObject jSONObject) {
            Collection collection;
            m.f(jSONObject, "jsonObject");
            if (jSONObject.getInt("version") <= 1) {
                String string = jSONObject.getString("token");
                Date date = new Date(jSONObject.getLong("expires_at"));
                JSONArray jSONArray = jSONObject.getJSONArray("permissions");
                JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
                JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
                Date date2 = new Date(jSONObject.getLong("last_refresh"));
                String string2 = jSONObject.getString("source");
                m.e(string2, "jsonObject.getString(SOURCE_KEY)");
                d valueOf = d.valueOf(string2);
                String string3 = jSONObject.getString("application_id");
                String string4 = jSONObject.getString("user_id");
                Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0));
                String optString = jSONObject.optString("graph_domain", (String) null);
                m.e(string, "token");
                m.e(string3, "applicationId");
                m.e(string4, "userId");
                m.e(jSONArray, "permissionsArray");
                Collection c02 = p0.c0(jSONArray);
                m.e(jSONArray2, "declinedPermissionsArray");
                Collection c03 = p0.c0(jSONArray2);
                if (optJSONArray == null) {
                    collection = new ArrayList();
                } else {
                    collection = p0.c0(optJSONArray);
                }
                return new AccessToken(string, string3, string4, c02, c03, collection, valueOf, date, date2, date3, optString);
            }
            throw new l("Unknown AccessToken serialization format.");
        }

        public final AccessToken c(Bundle bundle) {
            String str;
            Bundle bundle2 = bundle;
            m.f(bundle2, "bundle");
            List f10 = f(bundle2, "com.facebook.TokenCachingStrategy.Permissions");
            List f11 = f(bundle2, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
            List f12 = f(bundle2, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
            v.a aVar = v.f20961d;
            String a10 = aVar.a(bundle2);
            if (p0.Y(a10)) {
                a10 = o.g();
            }
            String str2 = a10;
            String f13 = aVar.f(bundle2);
            if (f13 != null) {
                JSONObject e10 = p0.e(f13);
                if (e10 != null) {
                    try {
                        str = e10.getString("id");
                    } catch (JSONException unused) {
                        return null;
                    }
                } else {
                    str = null;
                }
                if (!(str2 == null || str == null)) {
                    return new AccessToken(f13, str2, str, f10, f11, f12, aVar.e(bundle2), aVar.c(bundle2), aVar.d(bundle2), (Date) null, (String) null, 1024, (DefaultConstructorMarker) null);
                }
            }
            return null;
        }

        public final void d() {
            AccessToken g10 = c.f19600g.e().g();
            if (g10 != null) {
                i(a(g10));
            }
        }

        public final AccessToken e() {
            return c.f19600g.e().g();
        }

        public final List f(Bundle bundle, String str) {
            m.f(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList == null) {
                return r.l();
            }
            List unmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
            m.e(unmodifiableList, "Collections.unmodifiable…ist(originalPermissions))");
            return unmodifiableList;
        }

        public final boolean g() {
            AccessToken g10 = c.f19600g.e().g();
            if (g10 == null || g10.p()) {
                return false;
            }
            return true;
        }

        public final boolean h() {
            AccessToken g10 = c.f19600g.e().g();
            if (g10 == null || g10.p() || !g10.q()) {
                return false;
            }
            return true;
        }

        public final void i(AccessToken accessToken) {
            c.f19600g.e().l(accessToken);
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Date date = new Date(LocationRequestCompat.PASSIVE_INTERVAL);
        C = date;
        X = date;
    }

    public AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, d dVar, Date date, Date date2, Date date3) {
        this(str, str2, str3, collection, collection2, collection3, dVar, date, date2, date3, (String) null, 1024, (DefaultConstructorMarker) null);
    }

    private final void a(StringBuilder sb2) {
        sb2.append(" permissions:");
        sb2.append("[");
        sb2.append(TextUtils.join(", ", this.f19465b));
        sb2.append("]");
    }

    private final d b(d dVar, String str) {
        if (str == null || !str.equals("instagram")) {
            return dVar;
        }
        int i10 = a.f19579a[dVar.ordinal()];
        if (i10 == 1) {
            return d.INSTAGRAM_APPLICATION_WEB;
        }
        if (i10 == 2) {
            return d.INSTAGRAM_CUSTOM_CHROME_TAB;
        }
        if (i10 != 3) {
            return dVar;
        }
        return d.INSTAGRAM_WEB_VIEW;
    }

    public static final AccessToken d() {
        return N0.e();
    }

    public static final boolean o() {
        return N0.g();
    }

    public static final boolean r() {
        return N0.h();
    }

    public static final void s(AccessToken accessToken) {
        N0.i(accessToken);
    }

    private final String u() {
        if (o.C(w.INCLUDE_ACCESS_TOKENS)) {
            return this.f19468e;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    public final String c() {
        return this.f19471h;
    }

    public int describeContents() {
        return 0;
    }

    public final Date e() {
        return this.f19473j;
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (m.b(this.f19464a, accessToken.f19464a) && m.b(this.f19465b, accessToken.f19465b) && m.b(this.f19466c, accessToken.f19466c) && m.b(this.f19467d, accessToken.f19467d) && m.b(this.f19468e, accessToken.f19468e) && this.f19469f == accessToken.f19469f && m.b(this.f19470g, accessToken.f19470g) && m.b(this.f19471h, accessToken.f19471h) && m.b(this.f19472i, accessToken.f19472i) && m.b(this.f19473j, accessToken.f19473j)) {
            String str = this.f19474w;
            String str2 = accessToken.f19474w;
            if (str != null) {
                z10 = m.b(str, str2);
            } else if (str2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final Set f() {
        return this.f19466c;
    }

    public final Set g() {
        return this.f19467d;
    }

    public final Date h() {
        return this.f19464a;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((((((((((((((((((527 + this.f19464a.hashCode()) * 31) + this.f19465b.hashCode()) * 31) + this.f19466c.hashCode()) * 31) + this.f19467d.hashCode()) * 31) + this.f19468e.hashCode()) * 31) + this.f19469f.hashCode()) * 31) + this.f19470g.hashCode()) * 31) + this.f19471h.hashCode()) * 31) + this.f19472i.hashCode()) * 31) + this.f19473j.hashCode()) * 31;
        String str = this.f19474w;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public final String i() {
        return this.f19474w;
    }

    public final Date j() {
        return this.f19470g;
    }

    public final Set k() {
        return this.f19465b;
    }

    public final d l() {
        return this.f19469f;
    }

    public final String m() {
        return this.f19468e;
    }

    public final String n() {
        return this.f19472i;
    }

    public final boolean p() {
        return new Date().after(this.f19464a);
    }

    public final boolean q() {
        String str = this.f19474w;
        if (str == null || !str.equals("instagram")) {
            return false;
        }
        return true;
    }

    public final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.f19468e);
        jSONObject.put("expires_at", this.f19464a.getTime());
        jSONObject.put("permissions", new JSONArray(this.f19465b));
        jSONObject.put("declined_permissions", new JSONArray(this.f19466c));
        jSONObject.put("expired_permissions", new JSONArray(this.f19467d));
        jSONObject.put("last_refresh", this.f19470g.getTime());
        jSONObject.put("source", this.f19469f.name());
        jSONObject.put("application_id", this.f19471h);
        jSONObject.put("user_id", this.f19472i);
        jSONObject.put("data_access_expiration_time", this.f19473j.getTime());
        String str = this.f19474w;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{AccessToken");
        sb2.append(" token:");
        sb2.append(u());
        a(sb2);
        sb2.append("}");
        String sb3 = sb2.toString();
        m.e(sb3, "builder.toString()");
        return sb3;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        parcel.writeLong(this.f19464a.getTime());
        parcel.writeStringList(new ArrayList(this.f19465b));
        parcel.writeStringList(new ArrayList(this.f19466c));
        parcel.writeStringList(new ArrayList(this.f19467d));
        parcel.writeString(this.f19468e);
        parcel.writeString(this.f19469f.name());
        parcel.writeLong(this.f19470g.getTime());
        parcel.writeString(this.f19471h);
        parcel.writeString(this.f19472i);
        parcel.writeLong(this.f19473j.getTime());
        parcel.writeString(this.f19474w);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, d dVar, Date date, Date date2, Date date3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, collection, collection2, collection3, dVar, date, date2, date3, (i10 & 1024) != 0 ? "facebook" : str4);
    }

    public AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, d dVar, Date date, Date date2, Date date3, String str4) {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        m.f(str, "accessToken");
        m.f(str2, "applicationId");
        m.f(str3, "userId");
        q0.j(str, "accessToken");
        q0.j(str2, "applicationId");
        q0.j(str3, "userId");
        this.f19464a = date == null ? X : date;
        if (collection == null) {
            hashSet = new HashSet();
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        m.e(unmodifiableSet, "Collections.unmodifiable…missions) else HashSet())");
        this.f19465b = unmodifiableSet;
        if (collection2 == null) {
            hashSet2 = new HashSet();
        }
        Set unmodifiableSet2 = Collections.unmodifiableSet(hashSet2);
        m.e(unmodifiableSet2, "Collections.unmodifiable…missions) else HashSet())");
        this.f19466c = unmodifiableSet2;
        if (collection3 == null) {
            hashSet3 = new HashSet();
        }
        Set unmodifiableSet3 = Collections.unmodifiableSet(hashSet3);
        m.e(unmodifiableSet3, "Collections.unmodifiable…missions) else HashSet())");
        this.f19467d = unmodifiableSet3;
        this.f19468e = str;
        this.f19469f = b(dVar == null ? Z : dVar, str4);
        this.f19470g = date2 == null ? Y : date2;
        this.f19471h = str2;
        this.f19472i = str3;
        this.f19473j = (date3 == null || date3.getTime() == 0) ? X : date3;
        this.f19474w = str4 == null ? "facebook" : str4;
    }

    public AccessToken(Parcel parcel) {
        d dVar;
        m.f(parcel, "parcel");
        this.f19464a = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        m.e(unmodifiableSet, "Collections.unmodifiable…HashSet(permissionsList))");
        this.f19465b = unmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set unmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        m.e(unmodifiableSet2, "Collections.unmodifiable…HashSet(permissionsList))");
        this.f19466c = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set unmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        m.e(unmodifiableSet3, "Collections.unmodifiable…HashSet(permissionsList))");
        this.f19467d = unmodifiableSet3;
        this.f19468e = q0.n(parcel.readString(), "token");
        String readString = parcel.readString();
        if (readString != null) {
            dVar = d.valueOf(readString);
        } else {
            dVar = Z;
        }
        this.f19469f = dVar;
        this.f19470g = new Date(parcel.readLong());
        this.f19471h = q0.n(parcel.readString(), "applicationId");
        this.f19472i = q0.n(parcel.readString(), "userId");
        this.f19473j = new Date(parcel.readLong());
        this.f19474w = parcel.readString();
    }
}

package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import io.jsonwebtoken.Claims;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.p0;
import q5.q0;

public final class AuthenticationTokenClaims implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new a();
    public static final b S0 = new b((DefaultConstructorMarker) null);
    private final String C;
    private final Map N0;
    private final Map O0;
    private final Map P0;
    private final String Q0;
    private final String R0;
    private final String X;
    private final Set Y;
    private final String Z;

    /* renamed from: a  reason: collision with root package name */
    private final String f19481a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19482b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19483c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19484d;

    /* renamed from: e  reason: collision with root package name */
    private final long f19485e;

    /* renamed from: f  reason: collision with root package name */
    private final long f19486f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19487g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19488h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19489i;

    /* renamed from: j  reason: collision with root package name */
    private final String f19490j;

    /* renamed from: w  reason: collision with root package name */
    private final String f19491w;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AuthenticationTokenClaims createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new AuthenticationTokenClaims(parcel);
        }

        /* renamed from: b */
        public AuthenticationTokenClaims[] newArray(int i10) {
            return new AuthenticationTokenClaims[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public final String a(JSONObject jSONObject, String str) {
            m.f(jSONObject, "$this$getNullableString");
            m.f(str, "name");
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationTokenClaims(String str, String str2) {
        Set set;
        Map map;
        Map map2;
        m.f(str, "encodedClaims");
        m.f(str2, "expectedNonce");
        q0.j(str, "encodedClaims");
        byte[] decode = Base64.decode(str, 8);
        m.e(decode, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decode, d.f797b));
        if (a(jSONObject, str2)) {
            String string = jSONObject.getString(Claims.ID);
            m.e(string, "jsonObj.getString(JSON_KEY_JIT)");
            this.f19481a = string;
            String string2 = jSONObject.getString(Claims.ISSUER);
            m.e(string2, "jsonObj.getString(JSON_KEY_ISS)");
            this.f19482b = string2;
            String string3 = jSONObject.getString(Claims.AUDIENCE);
            m.e(string3, "jsonObj.getString(JSON_KEY_AUD)");
            this.f19483c = string3;
            String string4 = jSONObject.getString("nonce");
            m.e(string4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.f19484d = string4;
            this.f19485e = jSONObject.getLong(Claims.EXPIRATION);
            this.f19486f = jSONObject.getLong(Claims.ISSUED_AT);
            String string5 = jSONObject.getString(Claims.SUBJECT);
            m.e(string5, "jsonObj.getString(JSON_KEY_SUB)");
            this.f19487g = string5;
            b bVar = S0;
            this.f19488h = bVar.a(jSONObject, "name");
            this.f19489i = bVar.a(jSONObject, "given_name");
            this.f19490j = bVar.a(jSONObject, "middle_name");
            this.f19491w = bVar.a(jSONObject, "family_name");
            this.C = bVar.a(jSONObject, "email");
            this.X = bVar.a(jSONObject, "picture");
            JSONArray optJSONArray = jSONObject.optJSONArray("user_friends");
            Map map3 = null;
            if (optJSONArray == null) {
                set = null;
            } else {
                set = Collections.unmodifiableSet(p0.b0(optJSONArray));
            }
            this.Y = set;
            this.Z = bVar.a(jSONObject, "user_birthday");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_age_range");
            if (optJSONObject == null) {
                map = null;
            } else {
                map = Collections.unmodifiableMap(p0.m(optJSONObject));
            }
            this.N0 = map;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_hometown");
            if (optJSONObject2 == null) {
                map2 = null;
            } else {
                map2 = Collections.unmodifiableMap(p0.n(optJSONObject2));
            }
            this.O0 = map2;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("user_location");
            this.P0 = optJSONObject3 != null ? Collections.unmodifiableMap(p0.n(optJSONObject3)) : map3;
            this.Q0 = bVar.a(jSONObject, "user_gender");
            this.R0 = bVar.a(jSONObject, "user_link");
            return;
        }
        throw new IllegalArgumentException("Invalid claims".toString());
    }

    private final boolean a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(Claims.ID);
        m.e(optString, Claims.ID);
        if (optString.length() == 0) {
            return false;
        }
        try {
            String optString2 = jSONObject.optString(Claims.ISSUER);
            m.e(optString2, Claims.ISSUER);
            if (optString2.length() != 0) {
                if (!(!m.b(new URL(optString2).getHost(), "facebook.com")) || !(!m.b(new URL(optString2).getHost(), "www.facebook.com"))) {
                    String optString3 = jSONObject.optString(Claims.AUDIENCE);
                    m.e(optString3, Claims.AUDIENCE);
                    if (optString3.length() == 0 || (!m.b(optString3, o.g()))) {
                        return false;
                    }
                    long j10 = (long) 1000;
                    if (new Date().after(new Date(jSONObject.optLong(Claims.EXPIRATION) * j10))) {
                        return false;
                    }
                    if (new Date().after(new Date((jSONObject.optLong(Claims.ISSUED_AT) * j10) + 600000))) {
                        return false;
                    }
                    String optString4 = jSONObject.optString(Claims.SUBJECT);
                    m.e(optString4, Claims.SUBJECT);
                    if (optString4.length() == 0) {
                        return false;
                    }
                    String optString5 = jSONObject.optString("nonce");
                    m.e(optString5, "nonce");
                    if (optString5.length() != 0 && !(!m.b(optString5, str))) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Claims.ID, this.f19481a);
        jSONObject.put(Claims.ISSUER, this.f19482b);
        jSONObject.put(Claims.AUDIENCE, this.f19483c);
        jSONObject.put("nonce", this.f19484d);
        jSONObject.put(Claims.EXPIRATION, this.f19485e);
        jSONObject.put(Claims.ISSUED_AT, this.f19486f);
        String str = this.f19487g;
        if (str != null) {
            jSONObject.put(Claims.SUBJECT, str);
        }
        String str2 = this.f19488h;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.f19489i;
        if (str3 != null) {
            jSONObject.put("given_name", str3);
        }
        String str4 = this.f19490j;
        if (str4 != null) {
            jSONObject.put("middle_name", str4);
        }
        String str5 = this.f19491w;
        if (str5 != null) {
            jSONObject.put("family_name", str5);
        }
        String str6 = this.C;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.X;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.Y != null) {
            jSONObject.put("user_friends", new JSONArray(this.Y));
        }
        String str8 = this.Z;
        if (str8 != null) {
            jSONObject.put("user_birthday", str8);
        }
        if (this.N0 != null) {
            jSONObject.put("user_age_range", new JSONObject(this.N0));
        }
        if (this.O0 != null) {
            jSONObject.put("user_hometown", new JSONObject(this.O0));
        }
        if (this.P0 != null) {
            jSONObject.put("user_location", new JSONObject(this.P0));
        }
        String str9 = this.Q0;
        if (str9 != null) {
            jSONObject.put("user_gender", str9);
        }
        String str10 = this.R0;
        if (str10 != null) {
            jSONObject.put("user_link", str10);
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        if (!m.b(this.f19481a, authenticationTokenClaims.f19481a) || !m.b(this.f19482b, authenticationTokenClaims.f19482b) || !m.b(this.f19483c, authenticationTokenClaims.f19483c) || !m.b(this.f19484d, authenticationTokenClaims.f19484d) || this.f19485e != authenticationTokenClaims.f19485e || this.f19486f != authenticationTokenClaims.f19486f || !m.b(this.f19487g, authenticationTokenClaims.f19487g) || !m.b(this.f19488h, authenticationTokenClaims.f19488h) || !m.b(this.f19489i, authenticationTokenClaims.f19489i) || !m.b(this.f19490j, authenticationTokenClaims.f19490j) || !m.b(this.f19491w, authenticationTokenClaims.f19491w) || !m.b(this.C, authenticationTokenClaims.C) || !m.b(this.X, authenticationTokenClaims.X) || !m.b(this.Y, authenticationTokenClaims.Y) || !m.b(this.Z, authenticationTokenClaims.Z) || !m.b(this.N0, authenticationTokenClaims.N0) || !m.b(this.O0, authenticationTokenClaims.O0) || !m.b(this.P0, authenticationTokenClaims.P0) || !m.b(this.Q0, authenticationTokenClaims.Q0) || !m.b(this.R0, authenticationTokenClaims.R0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int hashCode = (((((((((((((527 + this.f19481a.hashCode()) * 31) + this.f19482b.hashCode()) * 31) + this.f19483c.hashCode()) * 31) + this.f19484d.hashCode()) * 31) + Long.valueOf(this.f19485e).hashCode()) * 31) + Long.valueOf(this.f19486f).hashCode()) * 31) + this.f19487g.hashCode()) * 31;
        String str = this.f19488h;
        int i22 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i23 = (hashCode + i10) * 31;
        String str2 = this.f19489i;
        if (str2 != null) {
            i11 = str2.hashCode();
        } else {
            i11 = 0;
        }
        int i24 = (i23 + i11) * 31;
        String str3 = this.f19490j;
        if (str3 != null) {
            i12 = str3.hashCode();
        } else {
            i12 = 0;
        }
        int i25 = (i24 + i12) * 31;
        String str4 = this.f19491w;
        if (str4 != null) {
            i13 = str4.hashCode();
        } else {
            i13 = 0;
        }
        int i26 = (i25 + i13) * 31;
        String str5 = this.C;
        if (str5 != null) {
            i14 = str5.hashCode();
        } else {
            i14 = 0;
        }
        int i27 = (i26 + i14) * 31;
        String str6 = this.X;
        if (str6 != null) {
            i15 = str6.hashCode();
        } else {
            i15 = 0;
        }
        int i28 = (i27 + i15) * 31;
        Set set = this.Y;
        if (set != null) {
            i16 = set.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        String str7 = this.Z;
        if (str7 != null) {
            i17 = str7.hashCode();
        } else {
            i17 = 0;
        }
        int i30 = (i29 + i17) * 31;
        Map map = this.N0;
        if (map != null) {
            i18 = map.hashCode();
        } else {
            i18 = 0;
        }
        int i31 = (i30 + i18) * 31;
        Map map2 = this.O0;
        if (map2 != null) {
            i19 = map2.hashCode();
        } else {
            i19 = 0;
        }
        int i32 = (i31 + i19) * 31;
        Map map3 = this.P0;
        if (map3 != null) {
            i20 = map3.hashCode();
        } else {
            i20 = 0;
        }
        int i33 = (i32 + i20) * 31;
        String str8 = this.Q0;
        if (str8 != null) {
            i21 = str8.hashCode();
        } else {
            i21 = 0;
        }
        int i34 = (i33 + i21) * 31;
        String str9 = this.R0;
        if (str9 != null) {
            i22 = str9.hashCode();
        }
        return i34 + i22;
    }

    public String toString() {
        String jSONObject = b().toString();
        m.e(jSONObject, "claimsJsonObject.toString()");
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        parcel.writeString(this.f19481a);
        parcel.writeString(this.f19482b);
        parcel.writeString(this.f19483c);
        parcel.writeString(this.f19484d);
        parcel.writeLong(this.f19485e);
        parcel.writeLong(this.f19486f);
        parcel.writeString(this.f19487g);
        parcel.writeString(this.f19488h);
        parcel.writeString(this.f19489i);
        parcel.writeString(this.f19490j);
        parcel.writeString(this.f19491w);
        parcel.writeString(this.C);
        parcel.writeString(this.X);
        if (this.Y == null) {
            parcel.writeStringList((List) null);
        } else {
            parcel.writeStringList(new ArrayList(this.Y));
        }
        parcel.writeString(this.Z);
        parcel.writeMap(this.N0);
        parcel.writeMap(this.O0);
        parcel.writeMap(this.P0);
        parcel.writeString(this.Q0);
        parcel.writeString(this.R0);
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        m.f(parcel, "parcel");
        this.f19481a = q0.n(parcel.readString(), Claims.ID);
        this.f19482b = q0.n(parcel.readString(), Claims.ISSUER);
        this.f19483c = q0.n(parcel.readString(), Claims.AUDIENCE);
        this.f19484d = q0.n(parcel.readString(), "nonce");
        this.f19485e = parcel.readLong();
        this.f19486f = parcel.readLong();
        this.f19487g = q0.n(parcel.readString(), Claims.SUBJECT);
        this.f19488h = parcel.readString();
        this.f19489i = parcel.readString();
        this.f19490j = parcel.readString();
        this.f19491w = parcel.readString();
        this.C = parcel.readString();
        this.X = parcel.readString();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        Map map = null;
        this.Y = createStringArrayList != null ? Collections.unmodifiableSet(new HashSet(createStringArrayList)) : null;
        this.Z = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(l.f719a.getClass().getClassLoader());
        readHashMap = !(readHashMap instanceof HashMap) ? null : readHashMap;
        this.N0 = readHashMap != null ? Collections.unmodifiableMap(readHashMap) : null;
        b0 b0Var = b0.f709a;
        HashMap readHashMap2 = parcel.readHashMap(b0Var.getClass().getClassLoader());
        readHashMap2 = !(readHashMap2 instanceof HashMap) ? null : readHashMap2;
        this.O0 = readHashMap2 != null ? Collections.unmodifiableMap(readHashMap2) : null;
        HashMap readHashMap3 = parcel.readHashMap(b0Var.getClass().getClassLoader());
        readHashMap3 = !(readHashMap3 instanceof HashMap) ? null : readHashMap3;
        this.P0 = readHashMap3 != null ? Collections.unmodifiableMap(readHashMap3) : map;
        this.Q0 = parcel.readString();
        this.R0 = parcel.readString();
    }
}

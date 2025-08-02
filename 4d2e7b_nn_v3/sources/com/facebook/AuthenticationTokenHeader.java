package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import io.jsonwebtoken.JwsHeader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import org.json.JSONException;
import org.json.JSONObject;
import q5.q0;

public final class AuthenticationTokenHeader implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final b f19492d = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f19493a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19494b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19495c;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AuthenticationTokenHeader createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new AuthenticationTokenHeader(parcel);
        }

        /* renamed from: b */
        public AuthenticationTokenHeader[] newArray(int i10) {
            return new AuthenticationTokenHeader[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationTokenHeader(String str) {
        m.f(str, "encodedHeaderString");
        if (b(str)) {
            byte[] decode = Base64.decode(str, 0);
            m.e(decode, "decodedBytes");
            JSONObject jSONObject = new JSONObject(new String(decode, d.f797b));
            String string = jSONObject.getString(JwsHeader.ALGORITHM);
            m.e(string, "jsonObj.getString(\"alg\")");
            this.f19493a = string;
            String string2 = jSONObject.getString("typ");
            m.e(string2, "jsonObj.getString(\"typ\")");
            this.f19494b = string2;
            String string3 = jSONObject.getString(JwsHeader.KEY_ID);
            m.e(string3, "jsonObj.getString(\"kid\")");
            this.f19495c = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header".toString());
    }

    private final boolean b(String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        q0.j(str, "encodedHeaderString");
        byte[] decode = Base64.decode(str, 0);
        m.e(decode, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decode, d.f797b));
            String optString = jSONObject.optString(JwsHeader.ALGORITHM);
            m.e(optString, JwsHeader.ALGORITHM);
            if (optString.length() <= 0 || !m.b(optString, "RS256")) {
                z10 = false;
            } else {
                z10 = true;
            }
            String optString2 = jSONObject.optString(JwsHeader.KEY_ID);
            m.e(optString2, "jsonObj.optString(\"kid\")");
            if (optString2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            String optString3 = jSONObject.optString("typ");
            m.e(optString3, "jsonObj.optString(\"typ\")");
            if (optString3.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z10 || !z11 || !z12) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public final String a() {
        return this.f19495c;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JwsHeader.ALGORITHM, this.f19493a);
        jSONObject.put("typ", this.f19494b);
        jSONObject.put(JwsHeader.KEY_ID, this.f19495c);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        if (!m.b(this.f19493a, authenticationTokenHeader.f19493a) || !m.b(this.f19494b, authenticationTokenHeader.f19494b) || !m.b(this.f19495c, authenticationTokenHeader.f19495c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f19493a.hashCode()) * 31) + this.f19494b.hashCode()) * 31) + this.f19495c.hashCode();
    }

    public String toString() {
        String jSONObject = c().toString();
        m.e(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        parcel.writeString(this.f19493a);
        parcel.writeString(this.f19494b);
        parcel.writeString(this.f19495c);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        m.f(parcel, "parcel");
        this.f19493a = q0.n(parcel.readString(), JwsHeader.ALGORITHM);
        this.f19494b = q0.n(parcel.readString(), "typ");
        this.f19495c = q0.n(parcel.readString(), JwsHeader.KEY_ID);
    }
}

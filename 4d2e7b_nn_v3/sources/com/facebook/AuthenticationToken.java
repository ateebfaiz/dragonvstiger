package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.pdns.f;
import io.jsonwebtoken.JwtParser;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONObject;
import q5.q0;

public final class AuthenticationToken implements Parcelable {
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public static final b f19475f = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f19476a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19477b;

    /* renamed from: c  reason: collision with root package name */
    private final AuthenticationTokenHeader f19478c;

    /* renamed from: d  reason: collision with root package name */
    private final AuthenticationTokenClaims f19479d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19480e;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AuthenticationToken createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new AuthenticationToken(parcel);
        }

        /* renamed from: b */
        public AuthenticationToken[] newArray(int i10) {
            return new AuthenticationToken[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public final void a(AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.f19497e.a().e(authenticationToken);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationToken(String str, String str2) {
        m.f(str, "token");
        m.f(str2, "expectedNonce");
        q0.j(str, "token");
        q0.j(str2, "expectedNonce");
        List v02 = j.v0(str, new String[]{f.G}, false, 0, 6, (Object) null);
        if (v02.size() == 3) {
            String str3 = (String) v02.get(0);
            String str4 = (String) v02.get(1);
            String str5 = (String) v02.get(2);
            this.f19476a = str;
            this.f19477b = str2;
            AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str3);
            this.f19478c = authenticationTokenHeader;
            this.f19479d = new AuthenticationTokenClaims(str4, str2);
            if (a(str3, str4, str5, authenticationTokenHeader.a())) {
                this.f19480e = str5;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        throw new IllegalArgumentException("Invalid IdToken string".toString());
    }

    private final boolean a(String str, String str2, String str3, String str4) {
        try {
            String b10 = z5.b.b(str4);
            if (b10 != null) {
                PublicKey a10 = z5.b.a(b10);
                return z5.b.c(a10, str + JwtParser.SEPARATOR_CHAR + str2, str3);
            }
        } catch (IOException | InvalidKeySpecException unused) {
        }
        return false;
    }

    public static final void b(AuthenticationToken authenticationToken) {
        f19475f.a(authenticationToken);
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_string", this.f19476a);
        jSONObject.put("expected_nonce", this.f19477b);
        jSONObject.put("header", this.f19478c.c());
        jSONObject.put("claims", this.f19479d.b());
        jSONObject.put("signature", this.f19480e);
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (!m.b(this.f19476a, authenticationToken.f19476a) || !m.b(this.f19477b, authenticationToken.f19477b) || !m.b(this.f19478c, authenticationToken.f19478c) || !m.b(this.f19479d, authenticationToken.f19479d) || !m.b(this.f19480e, authenticationToken.f19480e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((527 + this.f19476a.hashCode()) * 31) + this.f19477b.hashCode()) * 31) + this.f19478c.hashCode()) * 31) + this.f19479d.hashCode()) * 31) + this.f19480e.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        parcel.writeString(this.f19476a);
        parcel.writeString(this.f19477b);
        parcel.writeParcelable(this.f19478c, i10);
        parcel.writeParcelable(this.f19479d, i10);
        parcel.writeString(this.f19480e);
    }

    public AuthenticationToken(Parcel parcel) {
        m.f(parcel, "parcel");
        this.f19476a = q0.n(parcel.readString(), "token");
        this.f19477b = q0.n(parcel.readString(), "expectedNonce");
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.f19478c = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.f19479d = (AuthenticationTokenClaims) readParcelable2;
                this.f19480e = q0.n(parcel.readString(), "signature");
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}

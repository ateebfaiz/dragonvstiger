package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import q5.k;
import q5.r;
import q5.s;

public final class FacebookRequestError implements Parcelable {
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new b();
    public static final c N0 = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final d Z = new d(200, 299);
    private final JSONObject C;
    private final Object X;
    private final HttpURLConnection Y;

    /* renamed from: a  reason: collision with root package name */
    private final String f19519a;

    /* renamed from: b  reason: collision with root package name */
    private l f19520b;

    /* renamed from: c  reason: collision with root package name */
    private final a f19521c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19522d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19523e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19524f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19525g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19526h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19527i;

    /* renamed from: j  reason: collision with root package name */
    private final String f19528j;

    /* renamed from: w  reason: collision with root package name */
    private final JSONObject f19529w;

    public enum a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        /* renamed from: a */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            m.f(parcel, "parcel");
            return new FacebookRequestError(parcel, (DefaultConstructorMarker) null);
        }

        /* renamed from: b */
        public FacebookRequestError[] newArray(int i10) {
            return new FacebookRequestError[i10];
        }
    }

    public static final class c {
        private c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ce A[Catch:{ JSONException -> 0x0123 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.FacebookRequestError a(org.json.JSONObject r20, java.lang.Object r21, java.net.HttpURLConnection r22) {
            /*
                r19 = this;
                r9 = r20
                java.lang.String r0 = "error_code"
                java.lang.String r1 = "error"
                java.lang.String r2 = "FACEBOOK_NON_JSON_RESULT"
                java.lang.String r3 = "body"
                java.lang.String r4 = "code"
                java.lang.String r5 = "singleResult"
                kotlin.jvm.internal.m.f(r9, r5)
                r15 = 0
                boolean r5 = r9.has(r4)     // Catch:{ JSONException -> 0x0123 }
                if (r5 == 0) goto L_0x0123
                int r5 = r9.getInt(r4)     // Catch:{ JSONException -> 0x0123 }
                java.lang.Object r6 = q5.p0.J(r9, r3, r2)     // Catch:{ JSONException -> 0x0123 }
                if (r6 == 0) goto L_0x00ef
                boolean r7 = r6 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0123 }
                if (r7 == 0) goto L_0x00ef
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0123 }
                boolean r7 = r7.has(r1)     // Catch:{ JSONException -> 0x0123 }
                r8 = 1
                java.lang.String r10 = "error_subcode"
                r11 = 0
                r12 = -1
                if (r7 == 0) goto L_0x0082
                r0 = r6
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0123 }
                java.lang.Object r0 = q5.p0.J(r0, r1, r15)     // Catch:{ JSONException -> 0x0123 }
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0123 }
                if (r0 == 0) goto L_0x0046
                java.lang.String r1 = "type"
                java.lang.String r1 = r0.optString(r1, r15)     // Catch:{ JSONException -> 0x0123 }
                goto L_0x0047
            L_0x0046:
                r1 = r15
            L_0x0047:
                if (r0 == 0) goto L_0x0050
                java.lang.String r7 = "message"
                java.lang.String r7 = r0.optString(r7, r15)     // Catch:{ JSONException -> 0x0123 }
                goto L_0x0051
            L_0x0050:
                r7 = r15
            L_0x0051:
                if (r0 == 0) goto L_0x0058
                int r4 = r0.optInt(r4, r12)     // Catch:{ JSONException -> 0x0123 }
                goto L_0x0059
            L_0x0058:
                r4 = r12
            L_0x0059:
                if (r0 == 0) goto L_0x005f
                int r12 = r0.optInt(r10, r12)     // Catch:{ JSONException -> 0x0123 }
            L_0x005f:
                if (r0 == 0) goto L_0x0068
                java.lang.String r10 = "error_user_msg"
                java.lang.String r10 = r0.optString(r10, r15)     // Catch:{ JSONException -> 0x0123 }
                goto L_0x0069
            L_0x0068:
                r10 = r15
            L_0x0069:
                if (r0 == 0) goto L_0x0072
                java.lang.String r13 = "error_user_title"
                java.lang.String r13 = r0.optString(r13, r15)     // Catch:{ JSONException -> 0x0123 }
                goto L_0x0073
            L_0x0072:
                r13 = r15
            L_0x0073:
                if (r0 == 0) goto L_0x007b
                java.lang.String r14 = "is_transient"
                boolean r11 = r0.optBoolean(r14, r11)     // Catch:{ JSONException -> 0x0123 }
            L_0x007b:
                r14 = r11
                r11 = r8
                r8 = r7
                r7 = r12
                r12 = r4
            L_0x0080:
                r4 = r1
                goto L_0x00cc
            L_0x0082:
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0123 }
                boolean r1 = r1.has(r0)     // Catch:{ JSONException -> 0x0123 }
                java.lang.String r4 = "error_reason"
                java.lang.String r7 = "error_msg"
                if (r1 != 0) goto L_0x00a9
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0123 }
                boolean r1 = r1.has(r7)     // Catch:{ JSONException -> 0x0123 }
                if (r1 != 0) goto L_0x00a9
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0123 }
                boolean r1 = r1.has(r4)     // Catch:{ JSONException -> 0x0123 }
                if (r1 == 0) goto L_0x00a2
                goto L_0x00a9
            L_0x00a2:
                r14 = r11
                r7 = r12
                r4 = r15
                r8 = r4
                r10 = r8
                r13 = r10
                goto L_0x00cc
            L_0x00a9:
                r1 = r6
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0123 }
                java.lang.String r1 = r1.optString(r4, r15)     // Catch:{ JSONException -> 0x0123 }
                r4 = r6
                org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ JSONException -> 0x0123 }
                java.lang.String r4 = r4.optString(r7, r15)     // Catch:{ JSONException -> 0x0123 }
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0123 }
                int r0 = r7.optInt(r0, r12)     // Catch:{ JSONException -> 0x0123 }
                r7 = r6
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0123 }
                int r7 = r7.optInt(r10, r12)     // Catch:{ JSONException -> 0x0123 }
                r12 = r0
                r14 = r11
                r10 = r15
                r13 = r10
                r11 = r8
                r8 = r4
                goto L_0x0080
            L_0x00cc:
                if (r11 == 0) goto L_0x00ef
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x0123 }
                r11 = r6
                org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch:{ JSONException -> 0x0123 }
                r17 = 0
                r18 = 0
                r0 = r16
                r1 = r5
                r2 = r12
                r3 = r7
                r5 = r8
                r6 = r13
                r7 = r10
                r8 = r11
                r9 = r20
                r10 = r21
                r11 = r22
                r12 = r17
                r13 = r14
                r14 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0123 }
                return r16
            L_0x00ef:
                com.facebook.FacebookRequestError$d r0 = r19.c()     // Catch:{ JSONException -> 0x0123 }
                boolean r0 = r0.a(r5)     // Catch:{ JSONException -> 0x0123 }
                if (r0 != 0) goto L_0x0123
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x0123 }
                boolean r0 = r9.has(r3)     // Catch:{ JSONException -> 0x0123 }
                if (r0 == 0) goto L_0x0109
                java.lang.Object r0 = q5.p0.J(r9, r3, r2)     // Catch:{ JSONException -> 0x0123 }
                org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0123 }
                r8 = r0
                goto L_0x010a
            L_0x0109:
                r8 = r15
            L_0x010a:
                r13 = 0
                r14 = 0
                r2 = -1
                r3 = -1
                r4 = 0
                r6 = 0
                r7 = 0
                r10 = 0
                r12 = 0
                r0 = r16
                r1 = r5
                r5 = r6
                r6 = r7
                r7 = r10
                r9 = r20
                r10 = r21
                r11 = r22
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0123 }
                return r16
            L_0x0123:
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.c.a(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
        }

        public final synchronized k b() {
            r j10 = s.j(o.g());
            if (j10 != null) {
                return j10.d();
            }
            return k.f23358h.b();
        }

        public final d c() {
            return FacebookRequestError.Z;
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final int f19534a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19535b;

        public d(int i10, int i11) {
            this.f19534a = i10;
            this.f19535b = i11;
        }

        public final boolean a(int i10) {
            int i11 = this.f19534a;
            int i12 = this.f19535b;
            if (i11 <= i10 && i12 >= i10) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ FacebookRequestError(int i10, int i11, int i12, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, l lVar, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, i12, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, lVar, z10);
    }

    public final int b() {
        return this.f19524f;
    }

    public final String c() {
        String str = this.f19519a;
        if (str != null) {
            return str;
        }
        l lVar = this.f19520b;
        if (lVar != null) {
            return lVar.getLocalizedMessage();
        }
        return null;
    }

    public final String d() {
        return this.f19526h;
    }

    public int describeContents() {
        return 0;
    }

    public final l e() {
        return this.f19520b;
    }

    public final JSONObject f() {
        return this.C;
    }

    public final int g() {
        return this.f19523e;
    }

    public final int h() {
        return this.f19525g;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.f19523e + ", errorCode: " + this.f19524f + ", subErrorCode: " + this.f19525g + ", errorType: " + this.f19526h + ", errorMessage: " + c() + "}";
        m.e(str, "StringBuilder(\"{HttpStat…(\"}\")\n        .toString()");
        return str;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "out");
        parcel.writeInt(this.f19523e);
        parcel.writeInt(this.f19524f);
        parcel.writeInt(this.f19525g);
        parcel.writeString(this.f19526h);
        parcel.writeString(c());
        parcel.writeString(this.f19527i);
        parcel.writeString(this.f19528j);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private FacebookRequestError(int i10, int i11, int i12, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, l lVar, boolean z10) {
        a aVar;
        this.f19523e = i10;
        this.f19524f = i11;
        this.f19525g = i12;
        this.f19526h = str;
        this.f19527i = str3;
        this.f19528j = str4;
        this.f19529w = jSONObject;
        this.C = jSONObject2;
        this.X = obj;
        this.Y = httpURLConnection;
        this.f19519a = str2;
        if (lVar != null) {
            this.f19520b = lVar;
            aVar = a.OTHER;
        } else {
            this.f19520b = new q(this, c());
            aVar = N0.b().c(i11, i12, z10);
        }
        this.f19521c = aVar;
        this.f19522d = N0.b().d(aVar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacebookRequestError(java.net.HttpURLConnection r17, java.lang.Exception r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.facebook.l
            if (r1 == 0) goto L_0x000a
            com.facebook.l r0 = (com.facebook.l) r0
            r14 = r0
            goto L_0x0010
        L_0x000a:
            com.facebook.l r1 = new com.facebook.l
            r1.<init>((java.lang.Throwable) r0)
            r14 = r1
        L_0x0010:
            r15 = 0
            r3 = -1
            r4 = -1
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r16
            r13 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.<init>(java.net.HttpURLConnection, java.lang.Exception):void");
    }

    public FacebookRequestError(int i10, String str, String str2) {
        this(-1, i10, -1, str, str2, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (l) null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (JSONObject) null, (JSONObject) null, (Object) null, (HttpURLConnection) null, (l) null, false);
    }
}

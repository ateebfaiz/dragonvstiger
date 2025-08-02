package com.linecorp.linesdk.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LineAuthenticationConfig implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationConfig> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private static int f10002g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static int f10003h = 2;

    /* renamed from: a  reason: collision with root package name */
    private final String f10004a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f10005b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f10006c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f10007d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10008e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10009f;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineAuthenticationConfig createFromParcel(Parcel parcel) {
            return new LineAuthenticationConfig(parcel, (a) null);
        }

        /* renamed from: b */
        public LineAuthenticationConfig[] newArray(int i10) {
            return new LineAuthenticationConfig[i10];
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f10010a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Uri f10011b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Uri f10012c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Uri f10013d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f10014e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f10015f;

        public b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f10010a = str;
                this.f10011b = Uri.parse("https://access.line.me/.well-known/openid-configuration");
                this.f10012c = Uri.parse("https://api.line.me/");
                this.f10013d = Uri.parse("https://access.line.me/oauth2/v2.1/login");
                return;
            }
            throw new IllegalArgumentException("channelId is empty.");
        }

        public LineAuthenticationConfig g() {
            return new LineAuthenticationConfig(this, (a) null);
        }

        public b h() {
            this.f10014e = true;
            return this;
        }
    }

    /* synthetic */ LineAuthenticationConfig(Parcel parcel, a aVar) {
        this(parcel);
    }

    public Uri a() {
        return this.f10006c;
    }

    public String b() {
        return this.f10004a;
    }

    public Uri c() {
        return this.f10005b;
    }

    public Uri d() {
        return this.f10007d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f10009f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineAuthenticationConfig lineAuthenticationConfig = (LineAuthenticationConfig) obj;
        if (this.f10008e == lineAuthenticationConfig.f10008e && this.f10009f == lineAuthenticationConfig.f10009f && this.f10004a.equals(lineAuthenticationConfig.f10004a) && this.f10005b.equals(lineAuthenticationConfig.f10005b) && this.f10006c.equals(lineAuthenticationConfig.f10006c)) {
            return this.f10007d.equals(lineAuthenticationConfig.f10007d);
        }
        return false;
    }

    public boolean f() {
        return this.f10008e;
    }

    public int hashCode() {
        return (((((((((this.f10004a.hashCode() * 31) + this.f10005b.hashCode()) * 31) + this.f10006c.hashCode()) * 31) + this.f10007d.hashCode()) * 31) + (this.f10008e ? 1 : 0)) * 31) + (this.f10009f ? 1 : 0);
    }

    public String toString() {
        return "LineAuthenticationConfig{channelId='" + this.f10004a + '\'' + ", openidDiscoveryDocumentUrl=" + this.f10005b + ", apiBaseUrl=" + this.f10006c + ", webLoginPageUrl=" + this.f10007d + ", isLineAppAuthenticationDisabled=" + this.f10008e + ", isEncryptorPreparationDisabled=" + this.f10009f + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.writeString(this.f10004a);
        parcel.writeParcelable(this.f10005b, i10);
        parcel.writeParcelable(this.f10006c, i10);
        parcel.writeParcelable(this.f10007d, i10);
        int i12 = 0;
        if (this.f10008e) {
            i11 = f10002g;
        } else {
            i11 = 0;
        }
        if (this.f10009f) {
            i12 = f10003h;
        }
        parcel.writeInt(i11 | i12);
    }

    /* synthetic */ LineAuthenticationConfig(b bVar, a aVar) {
        this(bVar);
    }

    private LineAuthenticationConfig(b bVar) {
        this.f10004a = bVar.f10010a;
        this.f10005b = bVar.f10011b;
        this.f10006c = bVar.f10012c;
        this.f10007d = bVar.f10013d;
        this.f10008e = bVar.f10014e;
        this.f10009f = bVar.f10015f;
    }

    private LineAuthenticationConfig(Parcel parcel) {
        this.f10004a = parcel.readString();
        Class<Uri> cls = Uri.class;
        this.f10005b = (Uri) parcel.readParcelable(cls.getClassLoader());
        this.f10006c = (Uri) parcel.readParcelable(cls.getClassLoader());
        this.f10007d = (Uri) parcel.readParcelable(cls.getClassLoader());
        int readInt = parcel.readInt();
        boolean z10 = false;
        this.f10008e = (f10002g & readInt) > 0;
        this.f10009f = (readInt & f10003h) > 0 ? true : z10;
    }
}

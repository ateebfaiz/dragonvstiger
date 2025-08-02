package com.linecorp.linesdk.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import k9.h;

class LineAuthenticationStatus implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationStatus> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private h f10044a;

    /* renamed from: b  reason: collision with root package name */
    private String f10045b;

    /* renamed from: c  reason: collision with root package name */
    private String f10046c;

    /* renamed from: d  reason: collision with root package name */
    private String f10047d;

    /* renamed from: e  reason: collision with root package name */
    private b f10048e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineAuthenticationStatus createFromParcel(Parcel parcel) {
            return new LineAuthenticationStatus(parcel, (a) null);
        }

        /* renamed from: b */
        public LineAuthenticationStatus[] newArray(int i10) {
            return new LineAuthenticationStatus[i10];
        }
    }

    enum b {
        INIT,
        STARTED,
        INTENT_RECEIVED,
        INTENT_HANDLED
    }

    /* synthetic */ LineAuthenticationStatus(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f10048e = b.INTENT_HANDLED;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f10048e = b.INTENT_RECEIVED;
    }

    public void c() {
        this.f10048e = b.STARTED;
    }

    public String d() {
        return this.f10046c;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public h e() {
        return this.f10044a;
    }

    public String f() {
        return this.f10047d;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f10045b;
    }

    public b h() {
        return this.f10048e;
    }

    public void i(String str) {
        this.f10046c = str;
    }

    /* access modifiers changed from: package-private */
    public void j(h hVar) {
        this.f10044a = hVar;
    }

    public void k(String str) {
        this.f10047d = str;
    }

    /* access modifiers changed from: package-private */
    public void l(String str) {
        this.f10045b = str;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        String str;
        h hVar = this.f10044a;
        String str2 = null;
        if (hVar == null) {
            str = null;
        } else {
            str = hVar.a();
        }
        parcel.writeString(str);
        h hVar2 = this.f10044a;
        if (hVar2 != null) {
            str2 = hVar2.b();
        }
        parcel.writeString(str2);
        parcel.writeString(this.f10045b);
        parcel.writeByte((byte) this.f10048e.ordinal());
        parcel.writeString(this.f10046c);
        parcel.writeString(this.f10047d);
    }

    LineAuthenticationStatus() {
        this.f10048e = b.INIT;
    }

    private LineAuthenticationStatus(Parcel parcel) {
        this.f10048e = b.INIT;
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        this.f10044a = (TextUtils.isEmpty(readString) || TextUtils.isEmpty(readString2)) ? null : new h(readString, readString2);
        this.f10045b = parcel.readString();
        this.f10048e = b.values()[parcel.readByte()];
        this.f10046c = parcel.readString();
        this.f10047d = parcel.readString();
    }
}

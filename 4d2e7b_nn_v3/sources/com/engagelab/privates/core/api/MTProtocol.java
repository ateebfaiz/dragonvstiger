package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MTProtocol implements Parcelable {
    public static final Parcelable.Creator<MTProtocol> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f19417a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f19418b;

    /* renamed from: c  reason: collision with root package name */
    private int f19419c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f19420d;

    /* renamed from: e  reason: collision with root package name */
    private String f19421e;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public MTProtocol createFromParcel(Parcel parcel) {
            return new MTProtocol(parcel);
        }

        /* renamed from: b */
        public MTProtocol[] newArray(int i10) {
            return new MTProtocol[i10];
        }
    }

    public MTProtocol() {
    }

    public byte[] a() {
        return this.f19420d;
    }

    public int b() {
        return this.f19418b;
    }

    public long c() {
        return this.f19417a;
    }

    public String d() {
        return this.f19421e;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f19419c;
    }

    public MTProtocol f(byte[] bArr) {
        this.f19420d = bArr;
        return this;
    }

    public MTProtocol g(int i10) {
        this.f19418b = i10;
        return this;
    }

    public MTProtocol h(long j10) {
        this.f19417a = j10;
        return this;
    }

    public MTProtocol i(String str) {
        this.f19421e = str;
        return this;
    }

    public MTProtocol j(int i10) {
        this.f19419c = i10;
        return this;
    }

    public String toString() {
        return "\n{\n  rid=" + this.f19417a + ",\n  command=" + this.f19418b + ",\n  version=" + this.f19419c + ",\n  body=" + this.f19420d + ",\n  threadName=" + this.f19421e + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f19417a);
        parcel.writeInt(this.f19418b);
        parcel.writeInt(this.f19419c);
        parcel.writeByteArray(this.f19420d);
        parcel.writeString(this.f19421e);
    }

    public MTProtocol(Parcel parcel) {
        this.f19417a = (long) parcel.readInt();
        this.f19418b = parcel.readInt();
        this.f19419c = parcel.readInt();
        this.f19420d = parcel.createByteArray();
        this.f19421e = parcel.readString();
    }
}

package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class PlatformTokenMessage implements Parcelable {
    public static final Parcelable.Creator<PlatformTokenMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private byte f19456a;

    /* renamed from: b  reason: collision with root package name */
    private String f19457b;

    /* renamed from: c  reason: collision with root package name */
    private String f19458c = "NULL";

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public PlatformTokenMessage createFromParcel(Parcel parcel) {
            return new PlatformTokenMessage(parcel);
        }

        /* renamed from: b */
        public PlatformTokenMessage[] newArray(int i10) {
            return new PlatformTokenMessage[i10];
        }
    }

    public PlatformTokenMessage() {
    }

    public byte a() {
        return this.f19456a;
    }

    public String b() {
        return this.f19458c;
    }

    public String c() {
        return this.f19457b;
    }

    public PlatformTokenMessage d(byte b10) {
        this.f19456a = b10;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PlatformTokenMessage e(String str) {
        this.f19457b = str;
        return this;
    }

    public String toString() {
        return "\n{\n  platform=" + this.f19456a + ",\n  token=" + this.f19457b + "\n  region=" + this.f19458c + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.f19456a);
        parcel.writeString(this.f19457b);
        parcel.writeString(this.f19458c);
    }

    public PlatformTokenMessage(Parcel parcel) {
        this.f19456a = parcel.readByte();
        this.f19457b = parcel.readString();
        this.f19458c = parcel.readString();
    }
}

package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class TagMessage implements Parcelable {
    public static final Parcelable.Creator<TagMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f19459a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f19460b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String[] f19461c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    private String f19462d = "";

    /* renamed from: e  reason: collision with root package name */
    private boolean f19463e = false;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public TagMessage createFromParcel(Parcel parcel) {
            return new TagMessage(parcel);
        }

        /* renamed from: b */
        public TagMessage[] newArray(int i10) {
            return new TagMessage[i10];
        }
    }

    public TagMessage() {
    }

    public TagMessage a(int i10) {
        this.f19460b = i10;
        return this;
    }

    public TagMessage b(String str) {
        this.f19462d = str;
        return this;
    }

    public TagMessage c(boolean z10) {
        this.f19463e = z10;
        return this;
    }

    public TagMessage d(int i10) {
        this.f19459a = i10;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public TagMessage e(String[] strArr) {
        this.f19461c = strArr;
        return this;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.f19459a + ",\n  code=" + this.f19460b + ",\n  tag=" + Arrays.toString(this.f19461c) + ",\n  queryTag=" + this.f19462d + ",\n  queryTagValid=" + this.f19463e + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19459a);
        parcel.writeInt(this.f19460b);
        parcel.writeStringArray(this.f19461c);
        parcel.writeString(this.f19462d);
        parcel.writeByte(this.f19463e ? (byte) 1 : 0);
    }

    public TagMessage(Parcel parcel) {
        boolean z10 = false;
        this.f19459a = parcel.readInt();
        this.f19460b = parcel.readInt();
        this.f19461c = parcel.createStringArray();
        this.f19462d = parcel.readString();
        this.f19463e = parcel.readByte() != 0 ? true : z10;
    }
}

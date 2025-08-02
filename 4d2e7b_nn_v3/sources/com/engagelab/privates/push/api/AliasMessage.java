package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class AliasMessage implements Parcelable {
    public static final Parcelable.Creator<AliasMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f19426a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f19427b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f19428c = "";

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public AliasMessage createFromParcel(Parcel parcel) {
            return new AliasMessage(parcel);
        }

        /* renamed from: b */
        public AliasMessage[] newArray(int i10) {
            return new AliasMessage[i10];
        }
    }

    public AliasMessage() {
    }

    public AliasMessage a(String str) {
        this.f19428c = str;
        return this;
    }

    public AliasMessage b(int i10) {
        this.f19427b = i10;
        return this;
    }

    public AliasMessage c(int i10) {
        this.f19426a = i10;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.f19426a + ",\n  code=" + this.f19427b + ",\n  alias=" + this.f19428c + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19426a);
        parcel.writeInt(this.f19427b);
        parcel.writeString(this.f19428c);
    }

    public AliasMessage(Parcel parcel) {
        this.f19426a = parcel.readInt();
        this.f19427b = parcel.readInt();
        this.f19428c = parcel.readString();
    }
}

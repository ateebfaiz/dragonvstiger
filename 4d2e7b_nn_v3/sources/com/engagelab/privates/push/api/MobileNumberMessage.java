package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MobileNumberMessage implements Parcelable {
    public static final Parcelable.Creator<MobileNumberMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f19436a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f19437b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f19438c = "";

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public MobileNumberMessage createFromParcel(Parcel parcel) {
            return new MobileNumberMessage(parcel);
        }

        /* renamed from: b */
        public MobileNumberMessage[] newArray(int i10) {
            return new MobileNumberMessage[i10];
        }
    }

    public MobileNumberMessage() {
    }

    public MobileNumberMessage a(int i10) {
        this.f19437b = i10;
        return this;
    }

    public MobileNumberMessage b(String str) {
        this.f19438c = str;
        return this;
    }

    public MobileNumberMessage c(int i10) {
        this.f19436a = i10;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.f19436a + ",\n  code=" + this.f19437b + ",\n  mobileNumber=" + this.f19438c + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19436a);
        parcel.writeInt(this.f19437b);
        parcel.writeString(this.f19438c);
    }

    public MobileNumberMessage(Parcel parcel) {
        this.f19436a = parcel.readInt();
        this.f19437b = parcel.readInt();
        this.f19438c = parcel.readString();
    }
}

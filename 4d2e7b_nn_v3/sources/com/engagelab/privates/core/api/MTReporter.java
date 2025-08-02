package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MTReporter implements Parcelable {
    public static final Parcelable.Creator<MTReporter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f19422a;

    /* renamed from: b  reason: collision with root package name */
    private String f19423b;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public MTReporter createFromParcel(Parcel parcel) {
            return new MTReporter(parcel);
        }

        /* renamed from: b */
        public MTReporter[] newArray(int i10) {
            return new MTReporter[i10];
        }
    }

    public MTReporter() {
    }

    public String a() {
        return this.f19423b;
    }

    public String b() {
        return this.f19422a;
    }

    public MTReporter c(String str) {
        this.f19423b = str;
        return this;
    }

    public MTReporter d(String str) {
        this.f19422a = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19422a);
        parcel.writeString(this.f19423b);
    }

    public MTReporter(Parcel parcel) {
        this.f19422a = parcel.readString();
        this.f19423b = parcel.readString();
    }
}

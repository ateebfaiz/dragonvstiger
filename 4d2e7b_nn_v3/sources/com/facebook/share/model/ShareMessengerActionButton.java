package com.facebook.share.model;

import android.os.Parcel;

@Deprecated
public abstract class ShareMessengerActionButton implements ShareModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4630a;

    ShareMessengerActionButton(Parcel parcel) {
        this.f4630a = parcel.readString();
    }

    public String a() {
        return this.f4630a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4630a);
    }
}

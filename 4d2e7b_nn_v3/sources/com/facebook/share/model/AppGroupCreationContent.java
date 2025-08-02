package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4566a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4567b;

    /* renamed from: c  reason: collision with root package name */
    private b f4568c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        /* renamed from: b */
        public AppGroupCreationContent[] newArray(int i10) {
            return new AppGroupCreationContent[i10];
        }
    }

    public enum b {
        Open,
        Closed
    }

    AppGroupCreationContent(Parcel parcel) {
        this.f4566a = parcel.readString();
        this.f4567b = parcel.readString();
        this.f4568c = (b) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4566a);
        parcel.writeString(this.f4567b);
        parcel.writeSerializable(this.f4568c);
    }
}

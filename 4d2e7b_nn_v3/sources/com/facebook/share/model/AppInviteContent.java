package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class AppInviteContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4572a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4573b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4574c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4575d;

    /* renamed from: e  reason: collision with root package name */
    private final z7.a f4576e;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        /* renamed from: b */
        public AppInviteContent[] newArray(int i10) {
            return new AppInviteContent[i10];
        }
    }

    AppInviteContent(Parcel parcel) {
        this.f4572a = parcel.readString();
        this.f4573b = parcel.readString();
        this.f4575d = parcel.readString();
        this.f4574c = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.f4576e = z7.a.valueOf(readString);
        } else {
            this.f4576e = z7.a.FACEBOOK;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4572a);
        parcel.writeString(this.f4573b);
        parcel.writeString(this.f4575d);
        parcel.writeString(this.f4574c);
        parcel.writeString(this.f4576e.toString());
    }
}

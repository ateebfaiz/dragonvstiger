package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4637a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4638b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f4639c;

    /* renamed from: d  reason: collision with root package name */
    private final ShareMessengerActionButton f4640d;

    /* renamed from: e  reason: collision with root package name */
    private final ShareMessengerActionButton f4641e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateElement(parcel);
        }

        /* renamed from: b */
        public ShareMessengerGenericTemplateElement[] newArray(int i10) {
            return new ShareMessengerGenericTemplateElement[i10];
        }
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        this.f4637a = parcel.readString();
        this.f4638b = parcel.readString();
        this.f4639c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Class<ShareMessengerActionButton> cls = ShareMessengerActionButton.class;
        this.f4640d = (ShareMessengerActionButton) parcel.readParcelable(cls.getClassLoader());
        this.f4641e = (ShareMessengerActionButton) parcel.readParcelable(cls.getClassLoader());
    }

    public ShareMessengerActionButton a() {
        return this.f4641e;
    }

    public ShareMessengerActionButton b() {
        return this.f4640d;
    }

    public Uri c() {
        return this.f4639c;
    }

    public String d() {
        return this.f4638b;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4637a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4637a);
        parcel.writeString(this.f4638b);
        parcel.writeParcelable(this.f4639c, i10);
        parcel.writeParcelable(this.f4640d, i10);
        parcel.writeParcelable(this.f4641e, i10);
    }
}

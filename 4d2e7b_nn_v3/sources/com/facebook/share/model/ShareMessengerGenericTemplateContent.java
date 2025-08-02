package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4631g;

    /* renamed from: h  reason: collision with root package name */
    private final b f4632h;

    /* renamed from: i  reason: collision with root package name */
    private final ShareMessengerGenericTemplateElement f4633i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        /* renamed from: b */
        public ShareMessengerGenericTemplateContent[] newArray(int i10) {
            return new ShareMessengerGenericTemplateContent[i10];
        }
    }

    public enum b {
        HORIZONTAL,
        SQUARE
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        boolean z10;
        if (parcel.readByte() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4631g = z10;
        this.f4632h = (b) parcel.readSerializable();
        this.f4633i = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public ShareMessengerGenericTemplateElement h() {
        return this.f4633i;
    }

    public b i() {
        return this.f4632h;
    }

    public boolean j() {
        return this.f4631g;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeByte(this.f4631g ? (byte) 1 : 0);
        parcel.writeSerializable(this.f4632h);
        parcel.writeParcelable(this.f4633i, i10);
    }
}

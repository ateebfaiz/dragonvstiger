package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final b f4642g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4643h;

    /* renamed from: i  reason: collision with root package name */
    private final Uri f4644i;

    /* renamed from: j  reason: collision with root package name */
    private final ShareMessengerActionButton f4645j;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerMediaTemplateContent(parcel);
        }

        /* renamed from: b */
        public ShareMessengerMediaTemplateContent[] newArray(int i10) {
            return new ShareMessengerMediaTemplateContent[i10];
        }
    }

    public enum b {
        IMAGE,
        VIDEO
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        this.f4642g = (b) parcel.readSerializable();
        this.f4643h = parcel.readString();
        this.f4644i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4645j = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f4643h;
    }

    public ShareMessengerActionButton i() {
        return this.f4645j;
    }

    public b j() {
        return this.f4642g;
    }

    public Uri k() {
        return this.f4644i;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeSerializable(this.f4642g);
        parcel.writeString(this.f4643h);
        parcel.writeParcelable(this.f4644i, i10);
        parcel.writeParcelable(this.f4645j, i10);
    }
}

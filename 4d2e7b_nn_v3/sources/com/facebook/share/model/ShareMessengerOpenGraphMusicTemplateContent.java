package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ShareMessengerOpenGraphMusicTemplateContent extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final Uri f4649g;

    /* renamed from: h  reason: collision with root package name */
    private final ShareMessengerActionButton f4650h;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerOpenGraphMusicTemplateContent(parcel);
        }

        /* renamed from: b */
        public ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i10) {
            return new ShareMessengerOpenGraphMusicTemplateContent[i10];
        }
    }

    ShareMessengerOpenGraphMusicTemplateContent(Parcel parcel) {
        super(parcel);
        this.f4649g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4650h = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public ShareMessengerActionButton h() {
        return this.f4650h;
    }

    public Uri i() {
        return this.f4649g;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f4649g, i10);
        parcel.writeParcelable(this.f4650h, i10);
    }
}

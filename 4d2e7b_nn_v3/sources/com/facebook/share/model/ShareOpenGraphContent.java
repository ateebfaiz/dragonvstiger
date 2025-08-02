package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphAction;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final ShareOpenGraphAction f4660g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4661h;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        /* renamed from: b */
        public ShareOpenGraphContent[] newArray(int i10) {
            return new ShareOpenGraphContent[i10];
        }
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.f4660g = new ShareOpenGraphAction.b().e(parcel).d();
        this.f4661h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public ShareOpenGraphAction h() {
        return this.f4660g;
    }

    public String i() {
        return this.f4661h;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f4660g, 0);
        parcel.writeString(this.f4661h);
    }
}

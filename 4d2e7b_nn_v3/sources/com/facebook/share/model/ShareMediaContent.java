package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Object> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final List f4629g;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMediaContent createFromParcel(Parcel parcel) {
            return new ShareMediaContent(parcel);
        }

        /* renamed from: b */
        public ShareMediaContent[] newArray(int i10) {
            return new ShareMediaContent[i10];
        }
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        this.f4629g = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public List h() {
        return this.f4629g;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelableArray((ShareMedia[]) this.f4629g.toArray(), i10);
    }
}

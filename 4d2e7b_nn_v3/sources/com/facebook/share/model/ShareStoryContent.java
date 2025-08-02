package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent extends ShareContent<ShareStoryContent, Object> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final ShareMedia f4676g;

    /* renamed from: h  reason: collision with root package name */
    private final SharePhoto f4677h;

    /* renamed from: i  reason: collision with root package name */
    private final List f4678i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4679j;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareStoryContent createFromParcel(Parcel parcel) {
            return new ShareStoryContent(parcel);
        }

        /* renamed from: b */
        public ShareStoryContent[] newArray(int i10) {
            return new ShareStoryContent[i10];
        }
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        this.f4676g = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.f4677h = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.f4678i = g(parcel);
        this.f4679j = parcel.readString();
    }

    private List g(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f4679j;
    }

    public ShareMedia i() {
        return this.f4676g;
    }

    public List j() {
        List list = this.f4678i;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public SharePhoto k() {
        return this.f4677h;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f4676g, 0);
        parcel.writeParcelable(this.f4677h, 0);
        parcel.writeStringList(this.f4678i);
        parcel.writeString(this.f4679j);
    }
}

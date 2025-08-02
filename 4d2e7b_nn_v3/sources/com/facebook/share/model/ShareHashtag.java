package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4614a;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        /* renamed from: b */
        public ShareHashtag[] newArray(int i10) {
            return new ShareHashtag[i10];
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4615a;

        public ShareHashtag b() {
            return new ShareHashtag(this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public b c(Parcel parcel) {
            return d((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        public b d(ShareHashtag shareHashtag) {
            if (shareHashtag == null) {
                return this;
            }
            return e(shareHashtag.a());
        }

        public b e(String str) {
            this.f4615a = str;
            return this;
        }
    }

    /* synthetic */ ShareHashtag(b bVar, a aVar) {
        this(bVar);
    }

    public String a() {
        return this.f4614a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4614a);
    }

    private ShareHashtag(b bVar) {
        this.f4614a = bVar.f4615a;
    }

    ShareHashtag(Parcel parcel) {
        this.f4614a = parcel.readString();
    }
}

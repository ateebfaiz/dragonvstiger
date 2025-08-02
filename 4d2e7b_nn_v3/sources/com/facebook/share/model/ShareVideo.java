package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;

public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Uri f4680b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        /* renamed from: b */
        public ShareVideo[] newArray(int i10) {
            return new ShareVideo[i10];
        }
    }

    public static final class b extends ShareMedia.a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Uri f4681b;

        public ShareVideo f() {
            return new ShareVideo(this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public b g(Parcel parcel) {
            return h((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }

        public b h(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            return ((b) super.b(shareVideo)).i(shareVideo.c());
        }

        public b i(Uri uri) {
            this.f4681b = uri;
            return this;
        }
    }

    /* synthetic */ ShareVideo(b bVar, a aVar) {
        this(bVar);
    }

    public ShareMedia.b a() {
        return ShareMedia.b.VIDEO;
    }

    public Uri c() {
        return this.f4680b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f4680b, 0);
    }

    private ShareVideo(b bVar) {
        super((ShareMedia.a) bVar);
        this.f4680b = bVar.f4681b;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.f4680b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}

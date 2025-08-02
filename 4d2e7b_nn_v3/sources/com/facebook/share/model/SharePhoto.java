package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f4665b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f4666c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4667d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4668e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        /* renamed from: b */
        public SharePhoto[] newArray(int i10) {
            return new SharePhoto[i10];
        }
    }

    public static final class b extends ShareMedia.a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f4669b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Uri f4670c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f4671d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f4672e;

        static List n(Parcel parcel) {
            List<ShareMedia> c10 = ShareMedia.a.c(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : c10) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            return arrayList;
        }

        static void s(Parcel parcel, int i10, List list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                shareMediaArr[i11] = (ShareMedia) list.get(i11);
            }
            parcel.writeParcelableArray(shareMediaArr, i10);
        }

        public SharePhoto i() {
            return new SharePhoto(this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public Bitmap j() {
            return this.f4669b;
        }

        /* access modifiers changed from: package-private */
        public Uri k() {
            return this.f4670c;
        }

        /* access modifiers changed from: package-private */
        public b l(Parcel parcel) {
            return m((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public b m(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            return ((b) super.b(sharePhoto)).o(sharePhoto.c()).q(sharePhoto.e()).r(sharePhoto.f()).p(sharePhoto.d());
        }

        public b o(Bitmap bitmap) {
            this.f4669b = bitmap;
            return this;
        }

        public b p(String str) {
            this.f4672e = str;
            return this;
        }

        public b q(Uri uri) {
            this.f4670c = uri;
            return this;
        }

        public b r(boolean z10) {
            this.f4671d = z10;
            return this;
        }
    }

    /* synthetic */ SharePhoto(b bVar, a aVar) {
        this(bVar);
    }

    public ShareMedia.b a() {
        return ShareMedia.b.PHOTO;
    }

    public Bitmap c() {
        return this.f4665b;
    }

    public String d() {
        return this.f4668e;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.f4666c;
    }

    public boolean f() {
        return this.f4667d;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f4665b, 0);
        parcel.writeParcelable(this.f4666c, 0);
        parcel.writeByte(this.f4667d ? (byte) 1 : 0);
        parcel.writeString(this.f4668e);
    }

    private SharePhoto(b bVar) {
        super((ShareMedia.a) bVar);
        this.f4665b = bVar.f4669b;
        this.f4666c = bVar.f4670c;
        this.f4667d = bVar.f4671d;
        this.f4668e = bVar.f4672e;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f4665b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f4666c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4667d = parcel.readByte() != 0;
        this.f4668e = parcel.readString();
    }
}

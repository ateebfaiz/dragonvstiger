package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Object> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new a();

    /* renamed from: w  reason: collision with root package name */
    public static final b f4682w = new b((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private final String f4683g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4684h;

    /* renamed from: i  reason: collision with root package name */
    private final SharePhoto f4685i;

    /* renamed from: j  reason: collision with root package name */
    private final ShareVideo f4686j;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareVideoContent createFromParcel(Parcel parcel) {
            m.f(parcel, "parcel");
            return new ShareVideoContent(parcel);
        }

        /* renamed from: b */
        public ShareVideoContent[] newArray(int i10) {
            return new ShareVideoContent[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareVideoContent(Parcel parcel) {
        super(parcel);
        SharePhoto sharePhoto;
        m.f(parcel, "parcel");
        this.f4683g = parcel.readString();
        this.f4684h = parcel.readString();
        SharePhoto.b l10 = new SharePhoto.b().l(parcel);
        m.e(l10, "previewPhotoBuilder");
        if (l10.k() == null && l10.j() == null) {
            sharePhoto = null;
        } else {
            sharePhoto = l10.i();
        }
        this.f4685i = sharePhoto;
        this.f4686j = new ShareVideo.b().g(parcel).f();
    }

    public int describeContents() {
        return 0;
    }

    public final String h() {
        return this.f4683g;
    }

    public final String i() {
        return this.f4684h;
    }

    public final SharePhoto j() {
        return this.f4685i;
    }

    public final ShareVideo k() {
        return this.f4686j;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "out");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f4683g);
        parcel.writeString(this.f4684h);
        parcel.writeParcelable(this.f4685i, 0);
        parcel.writeParcelable(this.f4686j, 0);
    }
}

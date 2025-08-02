package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, b> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private final String f4616g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4617h;

    /* renamed from: i  reason: collision with root package name */
    private final Uri f4618i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4619j;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        /* renamed from: b */
        public ShareLinkContent[] newArray(int i10) {
            return new ShareLinkContent[i10];
        }
    }

    public static final class b extends ShareContent.a {
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String f4620g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f4621h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public Uri f4622i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f4623j;

        public ShareLinkContent r() {
            return new ShareLinkContent(this, (a) null);
        }
    }

    /* synthetic */ ShareLinkContent(b bVar, a aVar) {
        this(bVar);
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return this.f4616g;
    }

    public String i() {
        return this.f4617h;
    }

    public Uri j() {
        return this.f4618i;
    }

    public String k() {
        return this.f4619j;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f4616g);
        parcel.writeString(this.f4617h);
        parcel.writeParcelable(this.f4618i, 0);
        parcel.writeString(this.f4619j);
    }

    private ShareLinkContent(b bVar) {
        super((ShareContent.a) bVar);
        this.f4616g = bVar.f4620g;
        this.f4617h = bVar.f4621h;
        this.f4618i = bVar.f4622i;
        this.f4619j = bVar.f4623j;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.f4616g = parcel.readString();
        this.f4617h = parcel.readString();
        this.f4618i = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4619j = parcel.readString();
    }
}

package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, a> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new b();

    /* renamed from: h  reason: collision with root package name */
    public static final c f4673h = new c((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private final List f4674g;

    public static final class a extends ShareContent.a {

        /* renamed from: g  reason: collision with root package name */
        private final List f4675g = new ArrayList();

        public final a n(SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                List list = this.f4675g;
                SharePhoto i10 = new SharePhoto.b().m(sharePhoto).i();
                m.e(i10, "SharePhoto.Builder().readFrom(photo).build()");
                list.add(i10);
            }
            return this;
        }

        public final a o(List list) {
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    n((SharePhoto) it.next());
                }
            }
            return this;
        }

        public SharePhotoContent p() {
            return new SharePhotoContent(this, (DefaultConstructorMarker) null);
        }

        public final List q() {
            return this.f4675g;
        }

        public a r(SharePhotoContent sharePhotoContent) {
            if (sharePhotoContent == null) {
                return this;
            }
            return ((a) super.g(sharePhotoContent)).o(sharePhotoContent.h());
        }

        public final a s(List list) {
            this.f4675g.clear();
            o(list);
            return this;
        }
    }

    public static final class b implements Parcelable.Creator {
        b() {
        }

        /* renamed from: a */
        public SharePhotoContent createFromParcel(Parcel parcel) {
            m.f(parcel, "parcel");
            return new SharePhotoContent(parcel);
        }

        /* renamed from: b */
        public SharePhotoContent[] newArray(int i10) {
            return new SharePhotoContent[i10];
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SharePhotoContent(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public int describeContents() {
        return 0;
    }

    public final List h() {
        return this.f4674g;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "out");
        super.writeToParcel(parcel, i10);
        SharePhoto.b.s(parcel, i10, this.f4674g);
    }

    private SharePhotoContent(a aVar) {
        super((ShareContent.a) aVar);
        this.f4674g = r.w0(aVar.q());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharePhotoContent(Parcel parcel) {
        super(parcel);
        m.f(parcel, "parcel");
        List n10 = SharePhoto.b.n(parcel);
        m.e(n10, "SharePhoto.Builder.readPhotoListFrom(parcel)");
        this.f4674g = r.w0(n10);
    }
}

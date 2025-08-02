package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, b> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new a();

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        /* renamed from: b */
        public ShareOpenGraphAction[] newArray(int i10) {
            return new ShareOpenGraphAction[i10];
        }
    }

    public static final class b extends ShareOpenGraphValueContainer.a {
        public ShareOpenGraphAction d() {
            return new ShareOpenGraphAction(this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public b e(Parcel parcel) {
            return f((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }

        public b f(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                return this;
            }
            return ((b) super.c(shareOpenGraphAction)).g(shareOpenGraphAction.e());
        }

        public b g(String str) {
            b("og:type", str);
            return this;
        }
    }

    /* synthetic */ ShareOpenGraphAction(b bVar, a aVar) {
        this(bVar);
    }

    public String e() {
        return c("og:type");
    }

    private ShareOpenGraphAction(b bVar) {
        super((ShareOpenGraphValueContainer.a) bVar);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }
}

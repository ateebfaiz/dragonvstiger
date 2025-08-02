package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Object> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final b f4662b = new b((DefaultConstructorMarker) null);

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareOpenGraphObject createFromParcel(Parcel parcel) {
            m.f(parcel, "parcel");
            return new ShareOpenGraphObject(parcel);
        }

        /* renamed from: b */
        public ShareOpenGraphObject[] newArray(int i10) {
            return new ShareOpenGraphObject[i10];
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }
}

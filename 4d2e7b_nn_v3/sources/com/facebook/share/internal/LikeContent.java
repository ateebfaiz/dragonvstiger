package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;

@Deprecated
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4405a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4406b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        /* renamed from: b */
        public LikeContent[] newArray(int i10) {
            return new LikeContent[i10];
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4407a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4408b;

        public LikeContent c() {
            return new LikeContent(this, (a) null);
        }

        public b d(String str) {
            this.f4407a = str;
            return this;
        }

        public b e(String str) {
            this.f4408b = str;
            return this;
        }
    }

    /* synthetic */ LikeContent(b bVar, a aVar) {
        this(bVar);
    }

    public String a() {
        return this.f4405a;
    }

    public String b() {
        return this.f4406b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4405a);
        parcel.writeString(this.f4406b);
    }

    private LikeContent(b bVar) {
        this.f4405a = bVar.f4407a;
        this.f4406b = bVar.f4408b;
    }

    LikeContent(Parcel parcel) {
        this.f4405a = parcel.readString();
        this.f4406b = parcel.readString();
    }
}

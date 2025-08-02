package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new a();
    public static final b Y = new b((DefaultConstructorMarker) null);
    private final String C;
    private final String X;

    /* renamed from: g  reason: collision with root package name */
    private final String f4409g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4410h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4411i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4412j;

    /* renamed from: w  reason: collision with root package name */
    private final String f4413w;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareFeedContent createFromParcel(Parcel parcel) {
            m.f(parcel, "parcel");
            return new ShareFeedContent(parcel);
        }

        /* renamed from: b */
        public ShareFeedContent[] newArray(int i10) {
            return new ShareFeedContent[i10];
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
    public ShareFeedContent(Parcel parcel) {
        super(parcel);
        m.f(parcel, "parcel");
        this.f4409g = parcel.readString();
        this.f4410h = parcel.readString();
        this.f4411i = parcel.readString();
        this.f4412j = parcel.readString();
        this.f4413w = parcel.readString();
        this.C = parcel.readString();
        this.X = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public final String h() {
        return this.f4410h;
    }

    public final String i() {
        return this.f4412j;
    }

    public final String j() {
        return this.f4413w;
    }

    public final String k() {
        return this.f4411i;
    }

    public final String l() {
        return this.X;
    }

    public final String m() {
        return this.C;
    }

    public final String n() {
        return this.f4409g;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "out");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f4409g);
        parcel.writeString(this.f4410h);
        parcel.writeString(this.f4411i);
        parcel.writeString(this.f4412j);
        parcel.writeString(this.f4413w);
        parcel.writeString(this.C);
        parcel.writeString(this.X);
    }
}

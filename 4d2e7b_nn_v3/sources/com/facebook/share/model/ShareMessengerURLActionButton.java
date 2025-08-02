package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Uri f4651b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f4652c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4653d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4654e;

    /* renamed from: f  reason: collision with root package name */
    private final b f4655f;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        /* renamed from: b */
        public ShareMessengerURLActionButton[] newArray(int i10) {
            return new ShareMessengerURLActionButton[i10];
        }
    }

    public enum b {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        boolean z10;
        Class<Uri> cls = Uri.class;
        this.f4651b = (Uri) parcel.readParcelable(cls.getClassLoader());
        boolean z11 = false;
        if (parcel.readByte() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f4653d = z10;
        this.f4652c = (Uri) parcel.readParcelable(cls.getClassLoader());
        this.f4655f = (b) parcel.readSerializable();
        this.f4654e = parcel.readByte() != 0 ? true : z11;
    }

    public Uri b() {
        return this.f4652c;
    }

    public boolean c() {
        return this.f4653d;
    }

    public boolean d() {
        return this.f4654e;
    }

    public Uri e() {
        return this.f4651b;
    }

    public b f() {
        return this.f4655f;
    }
}

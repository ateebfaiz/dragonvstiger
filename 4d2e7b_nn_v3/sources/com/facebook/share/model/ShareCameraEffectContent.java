package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;

public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Object> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private String f4599g;

    /* renamed from: h  reason: collision with root package name */
    private CameraEffectArguments f4600h;

    /* renamed from: i  reason: collision with root package name */
    private CameraEffectTextures f4601i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ShareCameraEffectContent createFromParcel(Parcel parcel) {
            return new ShareCameraEffectContent(parcel);
        }

        /* renamed from: b */
        public ShareCameraEffectContent[] newArray(int i10) {
            return new ShareCameraEffectContent[i10];
        }
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        this.f4599g = parcel.readString();
        this.f4600h = new CameraEffectArguments.b().c(parcel).b();
        this.f4601i = new CameraEffectTextures.b().c(parcel).b();
    }

    public CameraEffectArguments h() {
        return this.f4600h;
    }

    public String i() {
        return this.f4599g;
    }

    public CameraEffectTextures j() {
        return this.f4601i;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f4599g);
        parcel.writeParcelable(this.f4600h, 0);
        parcel.writeParcelable(this.f4601i, 0);
    }
}

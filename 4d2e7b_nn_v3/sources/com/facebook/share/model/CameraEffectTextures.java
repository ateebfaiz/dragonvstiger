package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;

public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f4579a;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        /* renamed from: b */
        public CameraEffectTextures[] newArray(int i10) {
            return new CameraEffectTextures[i10];
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Bundle f4580a = new Bundle();

        public CameraEffectTextures b() {
            return new CameraEffectTextures(this, (a) null);
        }

        public b c(Parcel parcel) {
            return d((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }

        public b d(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.f4580a.putAll(cameraEffectTextures.f4579a);
            }
            return this;
        }
    }

    /* synthetic */ CameraEffectTextures(b bVar, a aVar) {
        this(bVar);
    }

    public Bitmap b(String str) {
        Object obj = this.f4579a.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    public Uri c(String str) {
        Object obj = this.f4579a.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    public Set d() {
        return this.f4579a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f4579a);
    }

    private CameraEffectTextures(b bVar) {
        this.f4579a = bVar.f4580a;
    }

    CameraEffectTextures(Parcel parcel) {
        this.f4579a = parcel.readBundle(getClass().getClassLoader());
    }
}

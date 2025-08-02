package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;

public class CameraEffectArguments implements ShareModel {
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f4577a;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        /* renamed from: b */
        public CameraEffectArguments[] newArray(int i10) {
            return new CameraEffectArguments[i10];
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Bundle f4578a = new Bundle();

        public CameraEffectArguments b() {
            return new CameraEffectArguments(this, (a) null);
        }

        public b c(Parcel parcel) {
            return d((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }

        public b d(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.f4578a.putAll(cameraEffectArguments.f4577a);
            }
            return this;
        }
    }

    /* synthetic */ CameraEffectArguments(b bVar, a aVar) {
        this(bVar);
    }

    public Object b(String str) {
        return this.f4577a.get(str);
    }

    public Set c() {
        return this.f4577a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f4577a);
    }

    private CameraEffectArguments(b bVar) {
        this.f4577a = bVar.f4578a;
    }

    CameraEffectArguments(Parcel parcel) {
        this.f4577a = parcel.readBundle(getClass().getClassLoader());
    }
}

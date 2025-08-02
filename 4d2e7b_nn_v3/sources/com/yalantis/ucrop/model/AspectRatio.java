package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f11763a;

    /* renamed from: b  reason: collision with root package name */
    private final float f11764b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11765c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        /* renamed from: b */
        public AspectRatio[] newArray(int i10) {
            return new AspectRatio[i10];
        }
    }

    public AspectRatio(String str, float f10, float f11) {
        this.f11763a = str;
        this.f11764b = f10;
        this.f11765c = f11;
    }

    public String a() {
        return this.f11763a;
    }

    public float b() {
        return this.f11764b;
    }

    public float c() {
        return this.f11765c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f11763a);
        parcel.writeFloat(this.f11764b);
        parcel.writeFloat(this.f11765c);
    }

    protected AspectRatio(Parcel parcel) {
        this.f11763a = parcel.readString();
        this.f11764b = parcel.readFloat();
        this.f11765c = parcel.readFloat();
    }
}

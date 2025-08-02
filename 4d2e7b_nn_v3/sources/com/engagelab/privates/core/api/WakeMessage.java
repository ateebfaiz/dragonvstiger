package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class WakeMessage implements Parcelable {
    public static final Parcelable.Creator<WakeMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f19424a;

    /* renamed from: b  reason: collision with root package name */
    private String f19425b;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public WakeMessage createFromParcel(Parcel parcel) {
            return new WakeMessage(parcel);
        }

        /* renamed from: b */
        public WakeMessage[] newArray(int i10) {
            return new WakeMessage[i10];
        }
    }

    public WakeMessage(Parcel parcel) {
        this.f19424a = parcel.readInt();
        this.f19425b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "\n{\n  type=" + this.f19424a + ",\n  packageName=" + this.f19425b + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19424a);
        parcel.writeString(this.f19425b);
    }
}

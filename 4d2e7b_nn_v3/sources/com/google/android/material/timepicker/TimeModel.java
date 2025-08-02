package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final c f8694a;

    /* renamed from: b  reason: collision with root package name */
    private final c f8695b;

    /* renamed from: c  reason: collision with root package name */
    final int f8696c;

    /* renamed from: d  reason: collision with root package name */
    int f8697d;

    /* renamed from: e  reason: collision with root package name */
    int f8698e;

    /* renamed from: f  reason: collision with root package name */
    int f8699f;

    /* renamed from: g  reason: collision with root package name */
    int f8700g;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* renamed from: b */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
    }

    private static int f(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    public int c() {
        if (this.f8696c == 1) {
            return this.f8697d % 24;
        }
        int i10 = this.f8697d;
        if (i10 % 12 == 0) {
            return 12;
        }
        if (this.f8700g == 1) {
            return i10 - 12;
        }
        return i10;
    }

    public c d() {
        return this.f8695b;
    }

    public int describeContents() {
        return 0;
    }

    public c e() {
        return this.f8694a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f8697d == timeModel.f8697d && this.f8698e == timeModel.f8698e && this.f8696c == timeModel.f8696c && this.f8699f == timeModel.f8699f) {
            return true;
        }
        return false;
    }

    public void g(int i10) {
        if (this.f8696c == 1) {
            this.f8697d = i10;
            return;
        }
        int i11 = 12;
        int i12 = i10 % 12;
        if (this.f8700g != 1) {
            i11 = 0;
        }
        this.f8697d = i12 + i11;
    }

    public void h(int i10) {
        this.f8700g = f(i10);
        this.f8697d = i10;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8696c), Integer.valueOf(this.f8697d), Integer.valueOf(this.f8698e), Integer.valueOf(this.f8699f)});
    }

    public void i(int i10) {
        this.f8698e = i10 % 60;
    }

    public void j(int i10) {
        if (i10 != this.f8700g) {
            this.f8700g = i10;
            int i11 = this.f8697d;
            if (i11 < 12 && i10 == 1) {
                this.f8697d = i11 + 12;
            } else if (i11 >= 12 && i10 == 0) {
                this.f8697d = i11 - 12;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8697d);
        parcel.writeInt(this.f8698e);
        parcel.writeInt(this.f8699f);
        parcel.writeInt(this.f8696c);
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f8697d = i10;
        this.f8698e = i11;
        this.f8699f = i12;
        this.f8696c = i13;
        this.f8700g = f(i10);
        this.f8694a = new c(59);
        this.f8695b = new c(i13 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}

package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationLayout implements Parcelable {
    public static final Parcelable.Creator<NotificationLayout> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f19439a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f19440b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f19441c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f19442d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f19443e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f19444f = 0;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public NotificationLayout createFromParcel(Parcel parcel) {
            return new NotificationLayout(parcel);
        }

        /* renamed from: b */
        public NotificationLayout[] newArray(int i10) {
            return new NotificationLayout[i10];
        }
    }

    public NotificationLayout() {
    }

    public int a() {
        return this.f19443e;
    }

    public int b() {
        return this.f19441c;
    }

    public int c() {
        return this.f19440b;
    }

    public int d() {
        return this.f19439a;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f19444f;
    }

    public int f() {
        return this.f19442d;
    }

    public NotificationLayout g(int i10) {
        this.f19443e = i10;
        return this;
    }

    public NotificationLayout h(int i10) {
        this.f19441c = i10;
        return this;
    }

    public NotificationLayout i(int i10) {
        this.f19440b = i10;
        return this;
    }

    public NotificationLayout j(int i10) {
        this.f19439a = i10;
        return this;
    }

    public NotificationLayout k(int i10) {
        this.f19444f = i10;
        return this;
    }

    public NotificationLayout l(int i10) {
        this.f19442d = i10;
        return this;
    }

    public String toString() {
        return "\n{\n  layoutId=" + this.f19439a + ",\n  iconViewId=" + this.f19440b + ",\n  titleViewId=" + this.f19442d + ",\n  contentViewId=" + this.f19443e + ",\n  timeViewId=" + this.f19444f + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19439a);
        parcel.writeInt(this.f19440b);
        parcel.writeInt(this.f19441c);
        parcel.writeInt(this.f19442d);
        parcel.writeInt(this.f19443e);
        parcel.writeInt(this.f19444f);
    }

    public NotificationLayout(Parcel parcel) {
        this.f19439a = parcel.readInt();
        this.f19440b = parcel.readInt();
        this.f19441c = parcel.readInt();
        this.f19442d = parcel.readInt();
        this.f19443e = parcel.readInt();
        this.f19444f = parcel.readInt();
    }
}

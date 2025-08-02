package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f8149a;

    /* renamed from: b  reason: collision with root package name */
    final int f8150b;

    /* renamed from: c  reason: collision with root package name */
    final int f8151c;

    /* renamed from: d  reason: collision with root package name */
    final int f8152d;

    /* renamed from: e  reason: collision with root package name */
    final int f8153e;

    /* renamed from: f  reason: collision with root package name */
    final long f8154f;

    /* renamed from: g  reason: collision with root package name */
    private String f8155g;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public Month createFromParcel(Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar f10 = k.f(calendar);
        this.f8149a = f10;
        this.f8150b = f10.get(2);
        this.f8151c = f10.get(1);
        this.f8152d = f10.getMaximum(7);
        this.f8153e = f10.getActualMaximum(5);
        this.f8154f = f10.getTimeInMillis();
    }

    static Month b(int i10, int i11) {
        Calendar q10 = k.q();
        q10.set(1, i10);
        q10.set(2, i11);
        return new Month(q10);
    }

    static Month c(long j10) {
        Calendar q10 = k.q();
        q10.setTimeInMillis(j10);
        return new Month(q10);
    }

    static Month d() {
        return new Month(k.o());
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f8149a.compareTo(month.f8149a);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        int firstDayOfWeek = this.f8149a.get(7) - this.f8149a.getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            return firstDayOfWeek + this.f8152d;
        }
        return firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f8150b == month.f8150b && this.f8151c == month.f8151c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f(int i10) {
        Calendar f10 = k.f(this.f8149a);
        f10.set(5, i10);
        return f10.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public int g(long j10) {
        Calendar f10 = k.f(this.f8149a);
        f10.setTimeInMillis(j10);
        return f10.get(5);
    }

    /* access modifiers changed from: package-private */
    public String h() {
        if (this.f8155g == null) {
            this.f8155g = d.i(this.f8149a.getTimeInMillis());
        }
        return this.f8155g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8150b), Integer.valueOf(this.f8151c)});
    }

    /* access modifiers changed from: package-private */
    public long i() {
        return this.f8149a.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public Month j(int i10) {
        Calendar f10 = k.f(this.f8149a);
        f10.add(2, i10);
        return new Month(f10);
    }

    /* access modifiers changed from: package-private */
    public int k(Month month) {
        if (this.f8149a instanceof GregorianCalendar) {
            return ((month.f8151c - this.f8151c) * 12) + (month.f8150b - this.f8150b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8151c);
        parcel.writeInt(this.f8150b);
    }
}

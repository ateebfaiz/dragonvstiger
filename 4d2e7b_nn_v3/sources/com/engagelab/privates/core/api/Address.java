package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    public static final Parcelable.Creator<Address> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String[] f19410a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f19411b;

    /* renamed from: c  reason: collision with root package name */
    private int f19412c;

    /* renamed from: d  reason: collision with root package name */
    private String f19413d;

    /* renamed from: e  reason: collision with root package name */
    private String f19414e;

    /* renamed from: f  reason: collision with root package name */
    private int f19415f;

    /* renamed from: g  reason: collision with root package name */
    private String f19416g;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public Address createFromParcel(Parcel parcel) {
            return new Address(parcel);
        }

        /* renamed from: b */
        public Address[] newArray(int i10) {
            return new Address[i10];
        }
    }

    public Address() {
    }

    public String a() {
        return this.f19413d;
    }

    public String b() {
        return this.f19414e;
    }

    public int c() {
        return this.f19415f;
    }

    public String d() {
        return this.f19416g;
    }

    public int describeContents() {
        return 0;
    }

    public String[] e() {
        return this.f19410a;
    }

    public String[] f() {
        return this.f19411b;
    }

    public int g() {
        return this.f19412c;
    }

    public Address h(String str) {
        this.f19413d = str;
        return this;
    }

    public Address i(String str) {
        this.f19414e = str;
        return this;
    }

    public Address j(int i10) {
        this.f19415f = i10;
        return this;
    }

    public Address k(String str) {
        this.f19416g = str;
        return this;
    }

    public Address l(String... strArr) {
        this.f19410a = strArr;
        return this;
    }

    public Address m(String... strArr) {
        this.f19411b = strArr;
        return this;
    }

    public Address n(int i10) {
        this.f19412c = i10;
        return this;
    }

    public String toString() {
        return "\n{\n  sisHostArray=" + this.f19410a + ",\n  sisIpArray=" + this.f19411b + ",\n  sisPort=" + this.f19412c + ",\n  defaultHost=" + this.f19413d + ",\n  defaultIp=" + this.f19414e + ",\n  defaultHost=" + this.f19413d + ",\n  defaultPort=" + this.f19415f + ",\n  defaultReportUrl=" + this.f19416g + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringArray(this.f19410a);
        parcel.writeStringArray(this.f19411b);
        parcel.writeInt(this.f19412c);
        parcel.writeString(this.f19413d);
        parcel.writeString(this.f19414e);
        parcel.writeInt(this.f19415f);
        parcel.writeString(this.f19416g);
    }

    public Address(Parcel parcel) {
        this.f19410a = parcel.createStringArray();
        this.f19411b = parcel.createStringArray();
        this.f19412c = parcel.readInt();
        this.f19413d = parcel.readString();
        this.f19414e = parcel.readString();
        this.f19415f = parcel.readInt();
        this.f19416g = parcel.readString();
    }
}

package com.engagelab.privates.push.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CustomMessage implements Parcelable {
    public static final Parcelable.Creator<CustomMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f19429a = null;

    /* renamed from: b  reason: collision with root package name */
    private byte f19430b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f19431c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f19432d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f19433e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f19434f = null;

    /* renamed from: g  reason: collision with root package name */
    private Bundle f19435g = null;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public CustomMessage createFromParcel(Parcel parcel) {
            return new CustomMessage(parcel);
        }

        /* renamed from: b */
        public CustomMessage[] newArray(int i10) {
            return new CustomMessage[i10];
        }
    }

    public CustomMessage() {
    }

    public String a() {
        return this.f19429a;
    }

    public byte b() {
        return this.f19430b;
    }

    public String c() {
        return this.f19431c;
    }

    public CustomMessage d(String str) {
        this.f19433e = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CustomMessage e(String str) {
        this.f19434f = str;
        return this;
    }

    public CustomMessage f(Bundle bundle) {
        this.f19435g = bundle;
        return this;
    }

    public CustomMessage g(String str) {
        this.f19429a = str;
        return this;
    }

    public CustomMessage h(byte b10) {
        this.f19430b = b10;
        return this;
    }

    public CustomMessage i(String str) {
        this.f19431c = str;
        return this;
    }

    public CustomMessage j(String str) {
        this.f19432d = str;
        return this;
    }

    public String toString() {
        return "\n{\n  messageId=" + this.f19429a + ",\n  platform=" + this.f19430b + ",\n  platformMessageId=" + this.f19431c + ",\n  title=" + this.f19432d + ",\n  content=" + this.f19433e + ",\n  contentType=" + this.f19434f + ",\n  extras=" + s1.a.f(this.f19435g) + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19429a);
        parcel.writeByte(this.f19430b);
        parcel.writeString(this.f19431c);
        parcel.writeString(this.f19432d);
        parcel.writeString(this.f19433e);
        parcel.writeString(this.f19434f);
        parcel.writeBundle(this.f19435g);
    }

    public CustomMessage(Parcel parcel) {
        this.f19429a = parcel.readString();
        this.f19430b = parcel.readByte();
        this.f19431c = parcel.readString();
        this.f19432d = parcel.readString();
        this.f19433e = parcel.readString();
        this.f19434f = parcel.readString();
        this.f19435g = parcel.readBundle();
    }
}

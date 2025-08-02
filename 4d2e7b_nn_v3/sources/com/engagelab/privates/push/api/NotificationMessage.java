package com.engagelab.privates.push.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class NotificationMessage implements Parcelable {
    public static final Parcelable.Creator<NotificationMessage> CREATOR = new a();
    private int C = 0;
    private int N0 = 0;
    private int O0 = -1;
    private String P0;
    private String Q0 = "";
    private String R0 = "";
    private String S0 = "";
    private String T0 = "";
    private int U0 = 0;
    private String X = "";
    private String[] Y = null;
    private String Z = "";

    /* renamed from: a  reason: collision with root package name */
    private String f19445a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f19446b = "";

    /* renamed from: c  reason: collision with root package name */
    private byte f19447c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f19448d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f19449e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f19450f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f19451g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f19452h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f19453i = "";

    /* renamed from: j  reason: collision with root package name */
    private Bundle f19454j = null;

    /* renamed from: w  reason: collision with root package name */
    private int f19455w;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public NotificationMessage createFromParcel(Parcel parcel) {
            return new NotificationMessage(parcel);
        }

        /* renamed from: b */
        public NotificationMessage[] newArray(int i10) {
            return new NotificationMessage[i10];
        }
    }

    public NotificationMessage() {
    }

    public NotificationMessage A(int i10) {
        this.f19455w = i10;
        return this;
    }

    public NotificationMessage B(String str) {
        this.P0 = str;
        return this;
    }

    public NotificationMessage C(String str) {
        this.R0 = str;
        return this;
    }

    public NotificationMessage D(String str) {
        this.f19453i = str;
        return this;
    }

    public NotificationMessage E(int i10) {
        this.O0 = i10;
        return this;
    }

    public NotificationMessage F(Bundle bundle) {
        this.f19454j = bundle;
        return this;
    }

    public NotificationMessage G(String[] strArr) {
        this.Y = strArr;
        return this;
    }

    public NotificationMessage H(String str) {
        this.T0 = str;
        return this;
    }

    public NotificationMessage I(String str) {
        this.S0 = str;
        return this;
    }

    public NotificationMessage J(String str) {
        this.f19451g = str;
        return this;
    }

    public NotificationMessage K(String str) {
        this.f19445a = str;
        return this;
    }

    public NotificationMessage L(int i10) {
        this.f19449e = i10;
        return this;
    }

    public NotificationMessage M(String str) {
        this.f19446b = str;
        return this;
    }

    public NotificationMessage N(byte b10) {
        this.f19447c = b10;
        return this;
    }

    public NotificationMessage O(String str) {
        this.f19448d = str;
        return this;
    }

    public NotificationMessage P(int i10) {
        this.N0 = i10;
        return this;
    }

    public NotificationMessage Q(String str) {
        this.f19450f = str;
        return this;
    }

    public NotificationMessage R(String str) {
        this.Q0 = str;
        return this;
    }

    public NotificationMessage S(int i10) {
        this.C = i10;
        return this;
    }

    public NotificationMessage T(String str) {
        this.f19452h = str;
        return this;
    }

    public int a() {
        return this.U0;
    }

    public String b() {
        return this.Z;
    }

    public String c() {
        return this.X;
    }

    public int d() {
        return this.f19455w;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.P0;
    }

    public String f() {
        return this.R0;
    }

    public String g() {
        return this.f19453i;
    }

    public int h() {
        return this.O0;
    }

    public Bundle i() {
        return this.f19454j;
    }

    public String[] j() {
        return this.Y;
    }

    public String k() {
        return this.T0;
    }

    public String l() {
        return this.S0;
    }

    public String m() {
        return this.f19451g;
    }

    public String n() {
        return this.f19445a;
    }

    public int o() {
        return this.f19449e;
    }

    public String p() {
        return this.f19446b;
    }

    public byte q() {
        return this.f19447c;
    }

    public String r() {
        return this.f19448d;
    }

    public int s() {
        return this.N0;
    }

    public String t() {
        return this.f19450f;
    }

    public String toString() {
        return "\n{\n  messageId=" + this.f19445a + ",\n  overrideMessageId=" + this.f19446b + ",\n  platform=" + this.f19447c + ",\n  platformMessageId='" + this.f19448d + ",\n  notificationId=" + this.f19449e + ",\n  smallIcon=" + this.f19450f + ",\n  largeIcon=" + this.f19451g + ",\n  title=" + this.f19452h + ",\n  content=" + this.f19453i + ",\n  extras=" + s1.a.f(this.f19454j) + ",\n  layoutId=" + this.f19455w + ",\n  style=" + this.C + ",\n  bigText=" + this.X + ",\n  inbox=" + Arrays.toString(this.Y) + ",\n  bigPicture=" + this.Z + ",\n  priority=" + this.N0 + ",\n  defaults=" + this.O0 + ",\n  category=" + this.P0 + ",\n  sound=" + this.Q0 + ",\n  channelId=" + this.R0 + ",\n  intentUri=" + this.S0 + ",\n  badge=" + this.U0 + ",\n}";
    }

    public String u() {
        return this.Q0;
    }

    public int v() {
        return this.C;
    }

    public String w() {
        return this.f19452h;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19445a);
        parcel.writeString(this.f19446b);
        parcel.writeByte(this.f19447c);
        parcel.writeString(this.f19448d);
        parcel.writeInt(this.f19449e);
        parcel.writeString(this.f19450f);
        parcel.writeString(this.f19451g);
        parcel.writeString(this.f19452h);
        parcel.writeString(this.f19453i);
        parcel.writeBundle(this.f19454j);
        parcel.writeInt(this.f19455w);
        parcel.writeInt(this.C);
        parcel.writeString(this.X);
        parcel.writeStringArray(this.Y);
        parcel.writeString(this.Z);
        parcel.writeInt(this.N0);
        parcel.writeInt(this.O0);
        parcel.writeString(this.P0);
        parcel.writeString(this.Q0);
        parcel.writeString(this.R0);
        parcel.writeString(this.S0);
        parcel.writeInt(this.U0);
    }

    public NotificationMessage x(int i10) {
        this.U0 = i10;
        return this;
    }

    public NotificationMessage y(String str) {
        this.Z = str;
        return this;
    }

    public NotificationMessage z(String str) {
        this.X = str;
        return this;
    }

    public NotificationMessage(Parcel parcel) {
        this.f19445a = parcel.readString();
        this.f19446b = parcel.readString();
        this.f19447c = parcel.readByte();
        this.f19448d = parcel.readString();
        this.f19449e = parcel.readInt();
        this.f19450f = parcel.readString();
        this.f19451g = parcel.readString();
        this.f19452h = parcel.readString();
        this.f19453i = parcel.readString();
        this.f19454j = parcel.readBundle();
        this.f19455w = parcel.readInt();
        this.C = parcel.readInt();
        this.X = parcel.readString();
        this.Y = parcel.createStringArray();
        this.Z = parcel.readString();
        this.N0 = parcel.readInt();
        this.O0 = parcel.readInt();
        this.P0 = parcel.readString();
        this.Q0 = parcel.readString();
        this.R0 = parcel.readString();
        this.S0 = parcel.readString();
        this.U0 = parcel.readInt();
    }
}

package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.List;
import n9.c;

public class LineIdToken implements Parcelable {
    public static final Parcelable.Creator<LineIdToken> CREATOR = new a();
    private final String C;
    private final Address N0;
    private final String O0;
    private final String P0;
    private final String Q0;
    private final String R0;
    private final String S0;
    private final String X;
    private final String Y;
    private final String Z;

    /* renamed from: a  reason: collision with root package name */
    private final String f9956a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9957b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9958c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9959d;

    /* renamed from: e  reason: collision with root package name */
    private final Date f9960e;

    /* renamed from: f  reason: collision with root package name */
    private final Date f9961f;

    /* renamed from: g  reason: collision with root package name */
    private final Date f9962g;

    /* renamed from: h  reason: collision with root package name */
    private final String f9963h;

    /* renamed from: i  reason: collision with root package name */
    private final List f9964i;

    /* renamed from: j  reason: collision with root package name */
    private final String f9965j;

    /* renamed from: w  reason: collision with root package name */
    private final String f9966w;

    public static class Address implements Parcelable {
        public static final Parcelable.Creator<Address> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f9967a;

        /* renamed from: b  reason: collision with root package name */
        private final String f9968b;

        /* renamed from: c  reason: collision with root package name */
        private final String f9969c;

        /* renamed from: d  reason: collision with root package name */
        private final String f9970d;

        /* renamed from: e  reason: collision with root package name */
        private final String f9971e;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Address createFromParcel(Parcel parcel) {
                return new Address(parcel, (a) null);
            }

            /* renamed from: b */
            public Address[] newArray(int i10) {
                return new Address[i10];
            }
        }

        public static final class b {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f9972a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f9973b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public String f9974c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public String f9975d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public String f9976e;

            public Address f() {
                return new Address(this, (a) null);
            }

            public b g(String str) {
                this.f9976e = str;
                return this;
            }

            public b h(String str) {
                this.f9973b = str;
                return this;
            }

            public b i(String str) {
                this.f9975d = str;
                return this;
            }

            public b j(String str) {
                this.f9974c = str;
                return this;
            }

            public b k(String str) {
                this.f9972a = str;
                return this;
            }
        }

        /* synthetic */ Address(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Address address = (Address) obj;
            String str = this.f9967a;
            if (str == null ? address.f9967a != null : !str.equals(address.f9967a)) {
                return false;
            }
            String str2 = this.f9968b;
            if (str2 == null ? address.f9968b != null : !str2.equals(address.f9968b)) {
                return false;
            }
            String str3 = this.f9969c;
            if (str3 == null ? address.f9969c != null : !str3.equals(address.f9969c)) {
                return false;
            }
            String str4 = this.f9970d;
            if (str4 == null ? address.f9970d != null : !str4.equals(address.f9970d)) {
                return false;
            }
            String str5 = this.f9971e;
            String str6 = address.f9971e;
            if (str5 != null) {
                return str5.equals(str6);
            }
            if (str6 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            String str = this.f9967a;
            int i14 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i15 = i10 * 31;
            String str2 = this.f9968b;
            if (str2 != null) {
                i11 = str2.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i15 + i11) * 31;
            String str3 = this.f9969c;
            if (str3 != null) {
                i12 = str3.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (i16 + i12) * 31;
            String str4 = this.f9970d;
            if (str4 != null) {
                i13 = str4.hashCode();
            } else {
                i13 = 0;
            }
            int i18 = (i17 + i13) * 31;
            String str5 = this.f9971e;
            if (str5 != null) {
                i14 = str5.hashCode();
            }
            return i18 + i14;
        }

        public String toString() {
            return "Address{streetAddress='" + this.f9967a + '\'' + ", locality='" + this.f9968b + '\'' + ", region='" + this.f9969c + '\'' + ", postalCode='" + this.f9970d + '\'' + ", country='" + this.f9971e + '\'' + '}';
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f9967a);
            parcel.writeString(this.f9968b);
            parcel.writeString(this.f9969c);
            parcel.writeString(this.f9970d);
            parcel.writeString(this.f9971e);
        }

        /* synthetic */ Address(b bVar, a aVar) {
            this(bVar);
        }

        private Address(b bVar) {
            this.f9967a = bVar.f9972a;
            this.f9968b = bVar.f9973b;
            this.f9969c = bVar.f9974c;
            this.f9970d = bVar.f9975d;
            this.f9971e = bVar.f9976e;
        }

        private Address(Parcel parcel) {
            this.f9967a = parcel.readString();
            this.f9968b = parcel.readString();
            this.f9969c = parcel.readString();
            this.f9970d = parcel.readString();
            this.f9971e = parcel.readString();
        }
    }

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineIdToken createFromParcel(Parcel parcel) {
            return new LineIdToken(parcel, (a) null);
        }

        /* renamed from: b */
        public LineIdToken[] newArray(int i10) {
            return new LineIdToken[i10];
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f9977a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f9978b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f9979c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f9980d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Date f9981e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Date f9982f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public Date f9983g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f9984h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public List f9985i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f9986j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public String f9987k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public String f9988l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public String f9989m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public String f9990n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public String f9991o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public Address f9992p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public String f9993q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public String f9994r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public String f9995s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public String f9996t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public String f9997u;

        public LineIdToken A() {
            return new LineIdToken(this, (a) null);
        }

        public b B(String str) {
            this.f9989m = str;
            return this;
        }

        public b C(Date date) {
            this.f9981e = date;
            return this;
        }

        public b D(String str) {
            this.f9996t = str;
            return this;
        }

        public b E(String str) {
            this.f9997u = str;
            return this;
        }

        public b F(String str) {
            this.f9990n = str;
            return this;
        }

        public b G(String str) {
            this.f9993q = str;
            return this;
        }

        public b H(String str) {
            this.f9994r = str;
            return this;
        }

        public b I(Date date) {
            this.f9982f = date;
            return this;
        }

        public b J(String str) {
            this.f9978b = str;
            return this;
        }

        public b K(String str) {
            this.f9995s = str;
            return this;
        }

        public b L(String str) {
            this.f9986j = str;
            return this;
        }

        public b M(String str) {
            this.f9984h = str;
            return this;
        }

        public b N(String str) {
            this.f9988l = str;
            return this;
        }

        public b O(String str) {
            this.f9987k = str;
            return this;
        }

        public b P(String str) {
            this.f9977a = str;
            return this;
        }

        public b Q(String str) {
            this.f9979c = str;
            return this;
        }

        public b v(Address address) {
            this.f9992p = address;
            return this;
        }

        public b w(List list) {
            this.f9985i = list;
            return this;
        }

        public b x(String str) {
            this.f9980d = str;
            return this;
        }

        public b y(Date date) {
            this.f9983g = date;
            return this;
        }

        public b z(String str) {
            this.f9991o = str;
            return this;
        }
    }

    /* synthetic */ LineIdToken(Parcel parcel, a aVar) {
        this(parcel);
    }

    public String a() {
        return this.f9959d;
    }

    public Date b() {
        return this.f9960e;
    }

    public Date c() {
        return this.f9961f;
    }

    public String d() {
        return this.f9957b;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f9963h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineIdToken lineIdToken = (LineIdToken) obj;
        if (!this.f9956a.equals(lineIdToken.f9956a) || !this.f9957b.equals(lineIdToken.f9957b) || !this.f9958c.equals(lineIdToken.f9958c) || !this.f9959d.equals(lineIdToken.f9959d) || !this.f9960e.equals(lineIdToken.f9960e) || !this.f9961f.equals(lineIdToken.f9961f)) {
            return false;
        }
        Date date = this.f9962g;
        if (date == null ? lineIdToken.f9962g != null : !date.equals(lineIdToken.f9962g)) {
            return false;
        }
        String str = this.f9963h;
        if (str == null ? lineIdToken.f9963h != null : !str.equals(lineIdToken.f9963h)) {
            return false;
        }
        List list = this.f9964i;
        if (list == null ? lineIdToken.f9964i != null : !list.equals(lineIdToken.f9964i)) {
            return false;
        }
        String str2 = this.f9965j;
        if (str2 == null ? lineIdToken.f9965j != null : !str2.equals(lineIdToken.f9965j)) {
            return false;
        }
        String str3 = this.f9966w;
        if (str3 == null ? lineIdToken.f9966w != null : !str3.equals(lineIdToken.f9966w)) {
            return false;
        }
        String str4 = this.C;
        if (str4 == null ? lineIdToken.C != null : !str4.equals(lineIdToken.C)) {
            return false;
        }
        String str5 = this.X;
        if (str5 == null ? lineIdToken.X != null : !str5.equals(lineIdToken.X)) {
            return false;
        }
        String str6 = this.Y;
        if (str6 == null ? lineIdToken.Y != null : !str6.equals(lineIdToken.Y)) {
            return false;
        }
        String str7 = this.Z;
        if (str7 == null ? lineIdToken.Z != null : !str7.equals(lineIdToken.Z)) {
            return false;
        }
        Address address = this.N0;
        if (address == null ? lineIdToken.N0 != null : !address.equals(lineIdToken.N0)) {
            return false;
        }
        String str8 = this.O0;
        if (str8 == null ? lineIdToken.O0 != null : !str8.equals(lineIdToken.O0)) {
            return false;
        }
        String str9 = this.P0;
        if (str9 == null ? lineIdToken.P0 != null : !str9.equals(lineIdToken.P0)) {
            return false;
        }
        String str10 = this.Q0;
        if (str10 == null ? lineIdToken.Q0 != null : !str10.equals(lineIdToken.Q0)) {
            return false;
        }
        String str11 = this.R0;
        if (str11 == null ? lineIdToken.R0 != null : !str11.equals(lineIdToken.R0)) {
            return false;
        }
        String str12 = this.S0;
        String str13 = lineIdToken.S0;
        if (str12 != null) {
            return str12.equals(str13);
        }
        if (str13 == null) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f9956a;
    }

    public String g() {
        return this.f9958c;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int hashCode = ((((((((((this.f9956a.hashCode() * 31) + this.f9957b.hashCode()) * 31) + this.f9958c.hashCode()) * 31) + this.f9959d.hashCode()) * 31) + this.f9960e.hashCode()) * 31) + this.f9961f.hashCode()) * 31;
        Date date = this.f9962g;
        int i24 = 0;
        if (date != null) {
            i10 = date.hashCode();
        } else {
            i10 = 0;
        }
        int i25 = (hashCode + i10) * 31;
        String str = this.f9963h;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i26 = (i25 + i11) * 31;
        List list = this.f9964i;
        if (list != null) {
            i12 = list.hashCode();
        } else {
            i12 = 0;
        }
        int i27 = (i26 + i12) * 31;
        String str2 = this.f9965j;
        if (str2 != null) {
            i13 = str2.hashCode();
        } else {
            i13 = 0;
        }
        int i28 = (i27 + i13) * 31;
        String str3 = this.f9966w;
        if (str3 != null) {
            i14 = str3.hashCode();
        } else {
            i14 = 0;
        }
        int i29 = (i28 + i14) * 31;
        String str4 = this.C;
        if (str4 != null) {
            i15 = str4.hashCode();
        } else {
            i15 = 0;
        }
        int i30 = (i29 + i15) * 31;
        String str5 = this.X;
        if (str5 != null) {
            i16 = str5.hashCode();
        } else {
            i16 = 0;
        }
        int i31 = (i30 + i16) * 31;
        String str6 = this.Y;
        if (str6 != null) {
            i17 = str6.hashCode();
        } else {
            i17 = 0;
        }
        int i32 = (i31 + i17) * 31;
        String str7 = this.Z;
        if (str7 != null) {
            i18 = str7.hashCode();
        } else {
            i18 = 0;
        }
        int i33 = (i32 + i18) * 31;
        Address address = this.N0;
        if (address != null) {
            i19 = address.hashCode();
        } else {
            i19 = 0;
        }
        int i34 = (i33 + i19) * 31;
        String str8 = this.O0;
        if (str8 != null) {
            i20 = str8.hashCode();
        } else {
            i20 = 0;
        }
        int i35 = (i34 + i20) * 31;
        String str9 = this.P0;
        if (str9 != null) {
            i21 = str9.hashCode();
        } else {
            i21 = 0;
        }
        int i36 = (i35 + i21) * 31;
        String str10 = this.Q0;
        if (str10 != null) {
            i22 = str10.hashCode();
        } else {
            i22 = 0;
        }
        int i37 = (i36 + i22) * 31;
        String str11 = this.R0;
        if (str11 != null) {
            i23 = str11.hashCode();
        } else {
            i23 = 0;
        }
        int i38 = (i37 + i23) * 31;
        String str12 = this.S0;
        if (str12 != null) {
            i24 = str12.hashCode();
        }
        return i38 + i24;
    }

    public String toString() {
        return "LineIdToken{rawString='" + this.f9956a + '\'' + ", issuer='" + this.f9957b + '\'' + ", subject='" + this.f9958c + '\'' + ", audience='" + this.f9959d + '\'' + ", expiresAt=" + this.f9960e + ", issuedAt=" + this.f9961f + ", authTime=" + this.f9962g + ", nonce='" + this.f9963h + '\'' + ", amr=" + this.f9964i + ", name='" + this.f9965j + '\'' + ", picture='" + this.f9966w + '\'' + ", phoneNumber='" + this.C + '\'' + ", email='" + this.X + '\'' + ", gender='" + this.Y + '\'' + ", birthdate='" + this.Z + '\'' + ", address=" + this.N0 + ", givenName='" + this.O0 + '\'' + ", givenNamePronunciation='" + this.P0 + '\'' + ", middleName='" + this.Q0 + '\'' + ", familyName='" + this.R0 + '\'' + ", familyNamePronunciation='" + this.S0 + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9956a);
        parcel.writeString(this.f9957b);
        parcel.writeString(this.f9958c);
        parcel.writeString(this.f9959d);
        c.c(parcel, this.f9960e);
        c.c(parcel, this.f9961f);
        c.c(parcel, this.f9962g);
        parcel.writeString(this.f9963h);
        parcel.writeStringList(this.f9964i);
        parcel.writeString(this.f9965j);
        parcel.writeString(this.f9966w);
        parcel.writeString(this.C);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeParcelable(this.N0, i10);
        parcel.writeString(this.O0);
        parcel.writeString(this.P0);
        parcel.writeString(this.Q0);
        parcel.writeString(this.R0);
        parcel.writeString(this.S0);
    }

    /* synthetic */ LineIdToken(b bVar, a aVar) {
        this(bVar);
    }

    private LineIdToken(b bVar) {
        this.f9956a = bVar.f9977a;
        this.f9957b = bVar.f9978b;
        this.f9958c = bVar.f9979c;
        this.f9959d = bVar.f9980d;
        this.f9960e = bVar.f9981e;
        this.f9961f = bVar.f9982f;
        this.f9962g = bVar.f9983g;
        this.f9963h = bVar.f9984h;
        this.f9964i = bVar.f9985i;
        this.f9965j = bVar.f9986j;
        this.f9966w = bVar.f9987k;
        this.C = bVar.f9988l;
        this.X = bVar.f9989m;
        this.Y = bVar.f9990n;
        this.Z = bVar.f9991o;
        this.N0 = bVar.f9992p;
        this.O0 = bVar.f9993q;
        this.P0 = bVar.f9994r;
        this.Q0 = bVar.f9995s;
        this.R0 = bVar.f9996t;
        this.S0 = bVar.f9997u;
    }

    private LineIdToken(Parcel parcel) {
        this.f9956a = parcel.readString();
        this.f9957b = parcel.readString();
        this.f9958c = parcel.readString();
        this.f9959d = parcel.readString();
        this.f9960e = c.a(parcel);
        this.f9961f = c.a(parcel);
        this.f9962g = c.a(parcel);
        this.f9963h = parcel.readString();
        this.f9964i = parcel.createStringArrayList();
        this.f9965j = parcel.readString();
        this.f9966w = parcel.readString();
        this.C = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.N0 = (Address) parcel.readParcelable(Address.class.getClassLoader());
        this.O0 = parcel.readString();
        this.P0 = parcel.readString();
        this.Q0 = parcel.readString();
        this.R0 = parcel.readString();
        this.S0 = parcel.readString();
    }
}

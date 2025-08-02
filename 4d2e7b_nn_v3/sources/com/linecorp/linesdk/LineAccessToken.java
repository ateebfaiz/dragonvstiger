package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;

public class LineAccessToken implements Parcelable {
    public static final Parcelable.Creator<LineAccessToken> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f9945a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9946b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9947c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineAccessToken createFromParcel(Parcel parcel) {
            return new LineAccessToken(parcel, (a) null);
        }

        /* renamed from: b */
        public LineAccessToken[] newArray(int i10) {
            return new LineAccessToken[i10];
        }
    }

    /* synthetic */ LineAccessToken(Parcel parcel, a aVar) {
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
        LineAccessToken lineAccessToken = (LineAccessToken) obj;
        if (this.f9946b == lineAccessToken.f9946b && this.f9947c == lineAccessToken.f9947c) {
            return this.f9945a.equals(lineAccessToken.f9945a);
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f9946b;
        long j11 = this.f9947c;
        return (((this.f9945a.hashCode() * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "LineAccessToken{accessToken='" + g9.a.b(this.f9945a) + '\'' + ", expiresInMillis=" + this.f9946b + ", issuedClientTimeMillis=" + this.f9947c + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9945a);
        parcel.writeLong(this.f9946b);
        parcel.writeLong(this.f9947c);
    }

    public LineAccessToken(String str, long j10, long j11) {
        this.f9945a = str;
        this.f9946b = j10;
        this.f9947c = j11;
    }

    private LineAccessToken(Parcel parcel) {
        this.f9945a = parcel.readString();
        this.f9946b = parcel.readLong();
        this.f9947c = parcel.readLong();
    }
}

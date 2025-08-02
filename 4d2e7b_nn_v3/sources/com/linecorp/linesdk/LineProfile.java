package com.linecorp.linesdk;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class LineProfile implements Parcelable {
    public static final Parcelable.Creator<LineProfile> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f9998a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9999b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f10000c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10001d;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineProfile createFromParcel(Parcel parcel) {
            return new LineProfile(parcel, (a) null);
        }

        /* renamed from: b */
        public LineProfile[] newArray(int i10) {
            return new LineProfile[i10];
        }
    }

    /* synthetic */ LineProfile(Parcel parcel, a aVar) {
        this(parcel);
    }

    public String a() {
        return this.f9998a;
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
        LineProfile lineProfile = (LineProfile) obj;
        if (!this.f9998a.equals(lineProfile.f9998a) || !this.f9999b.equals(lineProfile.f9999b)) {
            return false;
        }
        Uri uri = this.f10000c;
        if (uri == null ? lineProfile.f10000c != null : !uri.equals(lineProfile.f10000c)) {
            return false;
        }
        String str = this.f10001d;
        String str2 = lineProfile.f10001d;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f9998a.hashCode() * 31) + this.f9999b.hashCode()) * 31;
        Uri uri = this.f10000c;
        int i11 = 0;
        if (uri != null) {
            i10 = uri.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (hashCode + i10) * 31;
        String str = this.f10001d;
        if (str != null) {
            i11 = str.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "LineProfile{displayName='" + this.f9999b + '\'' + ", userId='" + this.f9998a + '\'' + ", pictureUrl='" + this.f10000c + '\'' + ", statusMessage='" + this.f10001d + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9998a);
        parcel.writeString(this.f9999b);
        parcel.writeParcelable(this.f10000c, i10);
        parcel.writeString(this.f10001d);
    }

    public LineProfile(String str, String str2, Uri uri, String str3) {
        this.f9998a = str;
        this.f9999b = str2;
        this.f10000c = uri;
        this.f10001d = str3;
    }

    private LineProfile(Parcel parcel) {
        this.f9998a = parcel.readString();
        this.f9999b = parcel.readString();
        this.f10000c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f10001d = parcel.readString();
    }
}

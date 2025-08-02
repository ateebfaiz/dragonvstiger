package com.linecorp.linesdk;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class LineGroup implements Parcelable {
    public static final Parcelable.Creator<LineGroup> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f9953a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9954b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f9955c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineGroup createFromParcel(Parcel parcel) {
            return new LineGroup(parcel, (a) null);
        }

        /* renamed from: b */
        public LineGroup[] newArray(int i10) {
            return new LineGroup[i10];
        }
    }

    /* synthetic */ LineGroup(Parcel parcel, a aVar) {
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
        LineGroup lineGroup = (LineGroup) obj;
        if (!this.f9953a.equals(lineGroup.f9953a) || !this.f9954b.equals(lineGroup.f9954b)) {
            return false;
        }
        Uri uri = this.f9955c;
        Uri uri2 = lineGroup.f9955c;
        if (uri == null ? uri2 == null : uri.equals(uri2)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f9953a.hashCode() * 31) + this.f9954b.hashCode()) * 31;
        Uri uri = this.f9955c;
        if (uri != null) {
            i10 = uri.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "LineProfile{groupName='" + this.f9954b + '\'' + ", groupId='" + this.f9953a + '\'' + ", pictureUrl='" + this.f9955c + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9953a);
        parcel.writeString(this.f9954b);
        parcel.writeParcelable(this.f9955c, i10);
    }

    public LineGroup(String str, String str2, Uri uri) {
        this.f9953a = str;
        this.f9954b = str2;
        this.f9955c = uri;
    }

    private LineGroup(Parcel parcel) {
        this.f9953a = parcel.readString();
        this.f9954b = parcel.readString();
        this.f9955c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}

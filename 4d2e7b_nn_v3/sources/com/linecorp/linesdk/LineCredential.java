package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;
import i9.k;
import java.util.ArrayList;
import java.util.List;

public class LineCredential implements Parcelable {
    public static final Parcelable.Creator<LineCredential> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final LineAccessToken f9951a;

    /* renamed from: b  reason: collision with root package name */
    private final List f9952b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineCredential createFromParcel(Parcel parcel) {
            return new LineCredential(parcel, (a) null);
        }

        /* renamed from: b */
        public LineCredential[] newArray(int i10) {
            return new LineCredential[i10];
        }
    }

    /* synthetic */ LineCredential(Parcel parcel, a aVar) {
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
        LineCredential lineCredential = (LineCredential) obj;
        if (!this.f9951a.equals(lineCredential.f9951a)) {
            return false;
        }
        return this.f9952b.equals(lineCredential.f9952b);
    }

    public int hashCode() {
        return (this.f9951a.hashCode() * 31) + this.f9952b.hashCode();
    }

    public String toString() {
        return "LineCredential{accessToken=" + g9.a.b(this.f9951a) + ", scopes=" + this.f9952b + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f9951a, i10);
        parcel.writeStringList(k.a(this.f9952b));
    }

    public LineCredential(LineAccessToken lineAccessToken, List list) {
        this.f9951a = lineAccessToken;
        this.f9952b = list;
    }

    private LineCredential(Parcel parcel) {
        this.f9951a = (LineAccessToken) parcel.readParcelable(LineAccessToken.class.getClassLoader());
        ArrayList arrayList = new ArrayList(8);
        parcel.readStringList(arrayList);
        this.f9952b = k.b(arrayList);
    }
}

package com.linecorp.linesdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LineApiError implements Parcelable {
    public static final Parcelable.Creator<LineApiError> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final LineApiError f9948c = new LineApiError(-1, "");

    /* renamed from: a  reason: collision with root package name */
    private final int f9949a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9950b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineApiError createFromParcel(Parcel parcel) {
            return new LineApiError(parcel, (a) null);
        }

        /* renamed from: b */
        public LineApiError[] newArray(int i10) {
            return new LineApiError[i10];
        }
    }

    /* synthetic */ LineApiError(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static String b(Exception exc) {
        if (exc == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public int a() {
        return this.f9949a;
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
        LineApiError lineApiError = (LineApiError) obj;
        if (this.f9949a != lineApiError.f9949a) {
            return false;
        }
        String str = this.f9950b;
        String str2 = lineApiError.f9950b;
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
        int i11 = this.f9949a * 31;
        String str = this.f9950b;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return i11 + i10;
    }

    public String toString() {
        return "LineApiError{httpResponseCode=" + this.f9949a + ", message='" + this.f9950b + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9949a);
        parcel.writeString(this.f9950b);
    }

    public LineApiError(Exception exc) {
        this(-1, b(exc));
    }

    public LineApiError(String str) {
        this(-1, str);
    }

    public LineApiError(int i10, Exception exc) {
        this(i10, b(exc));
    }

    public LineApiError(int i10, String str) {
        this.f9949a = i10;
        this.f9950b = str;
    }

    private LineApiError(Parcel parcel) {
        this.f9949a = parcel.readInt();
        this.f9950b = parcel.readString();
    }
}

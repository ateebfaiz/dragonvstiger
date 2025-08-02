package com.linecorp.linesdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.LineIdToken;
import com.linecorp.linesdk.LineProfile;
import i9.c;
import i9.d;

public class LineLoginResult implements Parcelable {
    public static final Parcelable.Creator<LineLoginResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final d f10027a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10028b;

    /* renamed from: c  reason: collision with root package name */
    private final LineProfile f10029c;

    /* renamed from: d  reason: collision with root package name */
    private final LineIdToken f10030d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f10031e;

    /* renamed from: f  reason: collision with root package name */
    private final LineCredential f10032f;

    /* renamed from: g  reason: collision with root package name */
    private final LineApiError f10033g;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineLoginResult createFromParcel(Parcel parcel) {
            return new LineLoginResult(parcel, (a) null);
        }

        /* renamed from: b */
        public LineLoginResult[] newArray(int i10) {
            return new LineLoginResult[i10];
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public d f10034a = d.SUCCESS;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f10035b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public LineProfile f10036c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public LineIdToken f10037d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Boolean f10038e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public LineCredential f10039f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public LineApiError f10040g = LineApiError.f9948c;

        public LineLoginResult h() {
            return new LineLoginResult(this, (a) null);
        }

        public b i(LineApiError lineApiError) {
            this.f10040g = lineApiError;
            return this;
        }

        public b j(Boolean bool) {
            this.f10038e = bool;
            return this;
        }

        public b k(LineCredential lineCredential) {
            this.f10039f = lineCredential;
            return this;
        }

        public b l(LineIdToken lineIdToken) {
            this.f10037d = lineIdToken;
            return this;
        }

        public b m(LineProfile lineProfile) {
            this.f10036c = lineProfile;
            return this;
        }

        public b n(String str) {
            this.f10035b = str;
            return this;
        }

        public b o(d dVar) {
            this.f10034a = dVar;
            return this;
        }
    }

    /* synthetic */ LineLoginResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static LineLoginResult a(LineApiError lineApiError) {
        return d(d.AUTHENTICATION_AGENT_ERROR, lineApiError);
    }

    public static LineLoginResult b() {
        return d(d.CANCEL, LineApiError.f9948c);
    }

    public static LineLoginResult c(c cVar) {
        return d(cVar.d(), cVar.c());
    }

    public static LineLoginResult d(d dVar, LineApiError lineApiError) {
        return new b().o(dVar).i(lineApiError).h();
    }

    public static LineLoginResult h(LineApiError lineApiError) {
        return d(d.INTERNAL_ERROR, lineApiError);
    }

    public static LineLoginResult i(Exception exc) {
        return h(new LineApiError(exc));
    }

    public static LineLoginResult j(String str) {
        return h(new LineApiError(str));
    }

    public int describeContents() {
        return 0;
    }

    public LineApiError e() {
        return this.f10033g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineLoginResult lineLoginResult = (LineLoginResult) obj;
        if (this.f10027a != lineLoginResult.f10027a) {
            return false;
        }
        String str = this.f10028b;
        if (str == null ? lineLoginResult.f10028b != null : !str.equals(lineLoginResult.f10028b)) {
            return false;
        }
        LineProfile lineProfile = this.f10029c;
        if (lineProfile == null ? lineLoginResult.f10029c != null : !lineProfile.equals(lineLoginResult.f10029c)) {
            return false;
        }
        LineIdToken lineIdToken = this.f10030d;
        if (lineIdToken == null ? lineLoginResult.f10030d != null : !lineIdToken.equals(lineLoginResult.f10030d)) {
            return false;
        }
        Boolean bool = this.f10031e;
        if (bool == null ? lineLoginResult.f10031e != null : !bool.equals(lineLoginResult.f10031e)) {
            return false;
        }
        LineCredential lineCredential = this.f10032f;
        if (lineCredential == null ? lineLoginResult.f10032f == null : lineCredential.equals(lineLoginResult.f10032f)) {
            return this.f10033g.equals(lineLoginResult.f10033g);
        }
        return false;
    }

    public LineIdToken f() {
        return this.f10030d;
    }

    public d g() {
        return this.f10027a;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int hashCode = this.f10027a.hashCode() * 31;
        String str = this.f10028b;
        int i14 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i15 = (hashCode + i10) * 31;
        LineProfile lineProfile = this.f10029c;
        if (lineProfile != null) {
            i11 = lineProfile.hashCode();
        } else {
            i11 = 0;
        }
        int i16 = (i15 + i11) * 31;
        LineIdToken lineIdToken = this.f10030d;
        if (lineIdToken != null) {
            i12 = lineIdToken.hashCode();
        } else {
            i12 = 0;
        }
        int i17 = (i16 + i12) * 31;
        Boolean bool = this.f10031e;
        if (bool != null) {
            i13 = bool.hashCode();
        } else {
            i13 = 0;
        }
        int i18 = (i17 + i13) * 31;
        LineCredential lineCredential = this.f10032f;
        if (lineCredential != null) {
            i14 = lineCredential.hashCode();
        }
        return ((i18 + i14) * 31) + this.f10033g.hashCode();
    }

    public String toString() {
        return "LineLoginResult{responseCode=" + this.f10027a + ", nonce='" + this.f10028b + '\'' + ", lineProfile=" + this.f10029c + ", lineIdToken=" + this.f10030d + ", friendshipStatusChanged=" + this.f10031e + ", lineCredential=" + this.f10032f + ", errorData=" + this.f10033g + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        n9.c.d(parcel, this.f10027a);
        parcel.writeString(this.f10028b);
        parcel.writeParcelable(this.f10029c, i10);
        parcel.writeParcelable(this.f10030d, i10);
        parcel.writeValue(this.f10031e);
        parcel.writeParcelable(this.f10032f, i10);
        parcel.writeParcelable(this.f10033g, i10);
    }

    /* synthetic */ LineLoginResult(b bVar, a aVar) {
        this(bVar);
    }

    private LineLoginResult(b bVar) {
        this.f10027a = bVar.f10034a;
        this.f10028b = bVar.f10035b;
        this.f10029c = bVar.f10036c;
        this.f10030d = bVar.f10037d;
        this.f10031e = bVar.f10038e;
        this.f10032f = bVar.f10039f;
        this.f10033g = bVar.f10040g;
    }

    private LineLoginResult(Parcel parcel) {
        this.f10027a = (d) n9.c.b(parcel, d.class);
        this.f10028b = parcel.readString();
        this.f10029c = (LineProfile) parcel.readParcelable(LineProfile.class.getClassLoader());
        this.f10030d = (LineIdToken) parcel.readParcelable(LineIdToken.class.getClassLoader());
        this.f10031e = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.f10032f = (LineCredential) parcel.readParcelable(LineCredential.class.getClassLoader());
        this.f10033g = (LineApiError) parcel.readParcelable(LineApiError.class.getClassLoader());
    }
}

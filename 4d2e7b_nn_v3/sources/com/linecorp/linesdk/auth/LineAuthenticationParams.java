package com.linecorp.linesdk.auth;

import android.os.Parcel;
import android.os.Parcelable;
import i9.k;
import java.util.List;
import java.util.Locale;

public class LineAuthenticationParams implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationParams> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List f10016a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10017b;

    /* renamed from: c  reason: collision with root package name */
    private final b f10018c;

    /* renamed from: d  reason: collision with root package name */
    private final Locale f10019d;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public LineAuthenticationParams createFromParcel(Parcel parcel) {
            return new LineAuthenticationParams(parcel, (a) null);
        }

        /* renamed from: b */
        public LineAuthenticationParams[] newArray(int i10) {
            return new LineAuthenticationParams[i10];
        }
    }

    public enum b {
        normal,
        aggressive
    }

    public static final class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List f10023a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f10024b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public b f10025c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Locale f10026d;

        public LineAuthenticationParams e() {
            return new LineAuthenticationParams(this, (a) null);
        }

        public c f(List list) {
            this.f10023a = list;
            return this;
        }
    }

    /* synthetic */ LineAuthenticationParams(Parcel parcel, a aVar) {
        this(parcel);
    }

    public b a() {
        return this.f10018c;
    }

    public String b() {
        return this.f10017b;
    }

    public List c() {
        return this.f10016a;
    }

    public Locale d() {
        return this.f10019d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(k.a(this.f10016a));
        parcel.writeString(this.f10017b);
        n9.c.d(parcel, this.f10018c);
        parcel.writeSerializable(this.f10019d);
    }

    /* synthetic */ LineAuthenticationParams(c cVar, a aVar) {
        this(cVar);
    }

    private LineAuthenticationParams(c cVar) {
        this.f10016a = cVar.f10023a;
        this.f10017b = cVar.f10024b;
        this.f10018c = cVar.f10025c;
        this.f10019d = cVar.f10026d;
    }

    private LineAuthenticationParams(Parcel parcel) {
        this.f10016a = k.b(parcel.createStringArrayList());
        this.f10017b = parcel.readString();
        this.f10018c = (b) n9.c.b(parcel, b.class);
        this.f10019d = (Locale) parcel.readSerializable();
    }
}

package com.facebook.common.callercontext;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public class ContextChain implements Parcelable {
    public static final Parcelable.Creator<ContextChain> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f19628a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19629b;

    /* renamed from: c  reason: collision with root package name */
    private final ContextChain f19630c;

    /* renamed from: d  reason: collision with root package name */
    private String f19631d;

    /* renamed from: e  reason: collision with root package name */
    private String f19632e;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ContextChain createFromParcel(Parcel parcel) {
            return new ContextChain(parcel);
        }

        /* renamed from: b */
        public ContextChain[] newArray(int i10) {
            return new ContextChain[i10];
        }
    }

    protected ContextChain(Parcel parcel) {
        this.f19628a = parcel.readString();
        this.f19629b = parcel.readString();
        this.f19632e = parcel.readString();
        this.f19630c = (ContextChain) parcel.readParcelable(ContextChain.class.getClassLoader());
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.f19632e;
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
        ContextChain contextChain = (ContextChain) obj;
        if (!Objects.equals(a(), contextChain.a()) || !Objects.equals(this.f19630c, contextChain.f19630c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f19630c, a()});
    }

    public String toString() {
        if (this.f19631d == null) {
            this.f19631d = a();
            if (this.f19630c != null) {
                this.f19631d = this.f19630c.toString() + '/' + this.f19631d;
            }
        }
        return this.f19631d;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19628a);
        parcel.writeString(this.f19629b);
        parcel.writeString(a());
        parcel.writeParcelable(this.f19630c, i10);
    }
}

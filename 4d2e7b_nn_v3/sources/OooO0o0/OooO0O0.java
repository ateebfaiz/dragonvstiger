package OooO0o0;

import android.os.Parcel;
import android.os.Parcelable;

public class OooO0O0 implements Parcelable {
    public static final Parcelable.Creator<OooO0O0> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f13465a;

    /* renamed from: b  reason: collision with root package name */
    public String f13466b;

    /* renamed from: c  reason: collision with root package name */
    public String f13467c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13468d;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public OooO0O0 createFromParcel(Parcel parcel) {
            return new OooO0O0(parcel);
        }

        /* renamed from: b */
        public OooO0O0[] newArray(int i10) {
            return new OooO0O0[i10];
        }
    }

    public OooO0O0() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.f13465a ? (byte) 1 : 0);
        parcel.writeString(this.f13466b);
        parcel.writeString(this.f13467c);
        parcel.writeByte(this.f13468d ? (byte) 1 : 0);
    }

    public OooO0O0(Parcel parcel) {
        boolean z10 = false;
        this.f13465a = parcel.readByte() != 0;
        this.f13466b = parcel.readString();
        this.f13467c = parcel.readString();
        this.f13468d = parcel.readByte() != 0 ? true : z10;
    }
}

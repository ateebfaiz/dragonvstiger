package OooO0o0;

import android.os.Parcel;
import android.os.Parcelable;
import com.mah.sdk.MahProxyOptions;
import java.util.ArrayList;
import java.util.List;

public class OooO0Oo implements Parcelable {
    public static final Parcelable.Creator<OooO0Oo> CREATOR = new a();
    public final boolean C;
    public final List X;
    public final List Y;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f13469a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13470b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13471c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f13472d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13473e;

    /* renamed from: f  reason: collision with root package name */
    public final String f13474f;

    /* renamed from: g  reason: collision with root package name */
    public final long f13475g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f13476h;

    /* renamed from: i  reason: collision with root package name */
    public final String f13477i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f13478j;

    /* renamed from: w  reason: collision with root package name */
    public final int f13479w;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public OooO0Oo createFromParcel(Parcel parcel) {
            return new OooO0Oo(parcel);
        }

        /* renamed from: b */
        public OooO0Oo[] newArray(int i10) {
            return new OooO0Oo[i10];
        }
    }

    public OooO0Oo(int i10, MahProxyOptions mahProxyOptions, long j10, String str) {
        this.f13473e = i10;
        this.f13469a = mahProxyOptions.OooO00o;
        this.f13470b = "";
        this.f13471c = mahProxyOptions.OooO0OO;
        this.f13472d = false;
        this.f13474f = mahProxyOptions.f10168OooO0o0;
        this.f13475g = j10;
        this.f13476h = false;
        this.f13477i = str;
        this.f13478j = mahProxyOptions.OooO;
        this.f13479w = mahProxyOptions.OooOO0;
        this.C = mahProxyOptions.OooOO0O;
        this.X = mahProxyOptions.OooOO0o;
        this.Y = mahProxyOptions.OooOOO0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.f13469a ? (byte) 1 : 0);
        parcel.writeString(this.f13470b);
        parcel.writeByte(this.f13471c ? (byte) 1 : 0);
        parcel.writeByte(this.f13472d ? (byte) 1 : 0);
        parcel.writeInt(this.f13473e);
        parcel.writeString(this.f13474f);
        parcel.writeLong(this.f13475g);
        parcel.writeByte(this.f13476h ? (byte) 1 : 0);
        parcel.writeString(this.f13477i);
        parcel.writeByte(this.f13478j ? (byte) 1 : 0);
        parcel.writeInt(this.f13479w);
        parcel.writeByte(this.C ? (byte) 1 : 0);
        parcel.writeStringList(this.X);
        parcel.writeStringList(this.Y);
    }

    public OooO0Oo(Parcel parcel) {
        boolean z10 = false;
        this.f13469a = parcel.readByte() != 0;
        this.f13470b = parcel.readString();
        this.f13471c = parcel.readByte() != 0;
        this.f13472d = parcel.readByte() != 0;
        this.f13473e = parcel.readInt();
        this.f13474f = parcel.readString();
        this.f13475g = parcel.readLong();
        this.f13476h = parcel.readByte() != 0;
        this.f13477i = parcel.readString();
        this.f13478j = parcel.readByte() != 0;
        this.f13479w = parcel.readInt();
        this.C = parcel.readByte() != 0 ? true : z10;
        ArrayList arrayList = new ArrayList();
        this.X = arrayList;
        parcel.readStringList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        this.Y = arrayList2;
        parcel.readStringList(arrayList2);
    }
}

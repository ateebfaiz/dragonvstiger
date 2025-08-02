package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f13744a;

    /* renamed from: b  reason: collision with root package name */
    public int f13745b;

    /* renamed from: c  reason: collision with root package name */
    public int f13746c;

    /* renamed from: d  reason: collision with root package name */
    public int f13747d;

    /* renamed from: e  reason: collision with root package name */
    public int f13748e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f13744a = parcel.readInt();
        this.f13746c = parcel.readInt();
        this.f13747d = parcel.readInt();
        this.f13748e = parcel.readInt();
        this.f13745b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f13744a);
        parcel.writeInt(this.f13746c);
        parcel.writeInt(this.f13747d);
        parcel.writeInt(this.f13748e);
        parcel.writeInt(this.f13745b);
    }
}

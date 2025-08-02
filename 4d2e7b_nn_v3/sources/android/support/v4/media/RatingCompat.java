package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f13725a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13726b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i10) {
            return new RatingCompat[i10];
        }
    }

    RatingCompat(int i10, float f10) {
        this.f13725a = i10;
        this.f13726b = f10;
    }

    public int describeContents() {
        return this.f13725a;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Rating:style=");
        sb2.append(this.f13725a);
        sb2.append(" rating=");
        float f10 = this.f13726b;
        if (f10 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f10);
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f13725a);
        parcel.writeFloat(this.f13726b);
    }
}

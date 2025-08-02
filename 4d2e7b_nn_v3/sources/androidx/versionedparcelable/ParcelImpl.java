package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    private final VersionedParcelable mParcel;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i10) {
            return new ParcelImpl[i10];
        }
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        new a(parcel).writeVersionedParcelable(this.mParcel);
    }

    protected ParcelImpl(Parcel parcel) {
        this.mParcel = new a(parcel).readVersionedParcelable();
    }
}

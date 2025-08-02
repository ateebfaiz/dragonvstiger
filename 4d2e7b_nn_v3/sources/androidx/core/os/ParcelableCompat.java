package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ParcelableCompat {

    static class a implements Parcelable.ClassLoaderCreator {

        /* renamed from: a  reason: collision with root package name */
        private final ParcelableCompatCreatorCallbacks f15038a;

        a(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
            this.f15038a = parcelableCompatCreatorCallbacks;
        }

        public Object createFromParcel(Parcel parcel) {
            return this.f15038a.createFromParcel(parcel, (ClassLoader) null);
        }

        public Object[] newArray(int i10) {
            return this.f15038a.newArray(i10);
        }

        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f15038a.createFromParcel(parcel, classLoader);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new a(parcelableCompatCreatorCallbacks);
    }
}

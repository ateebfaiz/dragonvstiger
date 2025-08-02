package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();
    public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {
    };
    private final Parcelable mSuperState;

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i10) {
            return new AbsSavedState[i10];
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mSuperState, i10);
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(@NonNull Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(@NonNull Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    protected AbsSavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }
}

package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    final int C;
    Bundle X;

    /* renamed from: a  reason: collision with root package name */
    final String f15621a;

    /* renamed from: b  reason: collision with root package name */
    final String f15622b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15623c;

    /* renamed from: d  reason: collision with root package name */
    final int f15624d;

    /* renamed from: e  reason: collision with root package name */
    final int f15625e;

    /* renamed from: f  reason: collision with root package name */
    final String f15626f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f15627g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f15628h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f15629i;

    /* renamed from: j  reason: collision with root package name */
    final Bundle f15630j;

    /* renamed from: w  reason: collision with root package name */
    final boolean f15631w;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    FragmentState(Fragment fragment) {
        this.f15621a = fragment.getClass().getName();
        this.f15622b = fragment.mWho;
        this.f15623c = fragment.mFromLayout;
        this.f15624d = fragment.mFragmentId;
        this.f15625e = fragment.mContainerId;
        this.f15626f = fragment.mTag;
        this.f15627g = fragment.mRetainInstance;
        this.f15628h = fragment.mRemoving;
        this.f15629i = fragment.mDetached;
        this.f15630j = fragment.mArguments;
        this.f15631w = fragment.mHidden;
        this.C = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f15621a);
        sb2.append(" (");
        sb2.append(this.f15622b);
        sb2.append(")}:");
        if (this.f15623c) {
            sb2.append(" fromLayout");
        }
        if (this.f15625e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f15625e));
        }
        String str = this.f15626f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f15626f);
        }
        if (this.f15627g) {
            sb2.append(" retainInstance");
        }
        if (this.f15628h) {
            sb2.append(" removing");
        }
        if (this.f15629i) {
            sb2.append(" detached");
        }
        if (this.f15631w) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f15621a);
        parcel.writeString(this.f15622b);
        parcel.writeInt(this.f15623c ? 1 : 0);
        parcel.writeInt(this.f15624d);
        parcel.writeInt(this.f15625e);
        parcel.writeString(this.f15626f);
        parcel.writeInt(this.f15627g ? 1 : 0);
        parcel.writeInt(this.f15628h ? 1 : 0);
        parcel.writeInt(this.f15629i ? 1 : 0);
        parcel.writeBundle(this.f15630j);
        parcel.writeInt(this.f15631w ? 1 : 0);
        parcel.writeBundle(this.X);
        parcel.writeInt(this.C);
    }

    FragmentState(Parcel parcel) {
        this.f15621a = parcel.readString();
        this.f15622b = parcel.readString();
        boolean z10 = false;
        this.f15623c = parcel.readInt() != 0;
        this.f15624d = parcel.readInt();
        this.f15625e = parcel.readInt();
        this.f15626f = parcel.readString();
        this.f15627g = parcel.readInt() != 0;
        this.f15628h = parcel.readInt() != 0;
        this.f15629i = parcel.readInt() != 0;
        this.f15630j = parcel.readBundle();
        this.f15631w = parcel.readInt() != 0 ? true : z10;
        this.X = parcel.readBundle();
        this.C = parcel.readInt();
    }
}

package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    final ArrayList C;
    final ArrayList X;
    final boolean Y;

    /* renamed from: a  reason: collision with root package name */
    final int[] f15520a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList f15521b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f15522c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f15523d;

    /* renamed from: e  reason: collision with root package name */
    final int f15524e;

    /* renamed from: f  reason: collision with root package name */
    final String f15525f;

    /* renamed from: g  reason: collision with root package name */
    final int f15526g;

    /* renamed from: h  reason: collision with root package name */
    final int f15527h;

    /* renamed from: i  reason: collision with root package name */
    final CharSequence f15528i;

    /* renamed from: j  reason: collision with root package name */
    final int f15529j;

    /* renamed from: w  reason: collision with root package name */
    final CharSequence f15530w;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    public BackStackState(a aVar) {
        int size = aVar.mOps.size();
        this.f15520a = new int[(size * 5)];
        if (aVar.mAddToBackStack) {
            this.f15521b = new ArrayList(size);
            this.f15522c = new int[size];
            this.f15523d = new int[size];
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                FragmentTransaction.a aVar2 = aVar.mOps.get(i11);
                int i12 = i10 + 1;
                this.f15520a[i10] = aVar2.f15638a;
                ArrayList arrayList = this.f15521b;
                Fragment fragment = aVar2.f15639b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f15520a;
                iArr[i12] = aVar2.f15640c;
                iArr[i10 + 2] = aVar2.f15641d;
                int i13 = i10 + 4;
                iArr[i10 + 3] = aVar2.f15642e;
                i10 += 5;
                iArr[i13] = aVar2.f15643f;
                this.f15522c[i11] = aVar2.f15644g.ordinal();
                this.f15523d[i11] = aVar2.f15645h.ordinal();
            }
            this.f15524e = aVar.mTransition;
            this.f15525f = aVar.mName;
            this.f15526g = aVar.f15662c;
            this.f15527h = aVar.mBreadCrumbTitleRes;
            this.f15528i = aVar.mBreadCrumbTitleText;
            this.f15529j = aVar.mBreadCrumbShortTitleRes;
            this.f15530w = aVar.mBreadCrumbShortTitleText;
            this.C = aVar.mSharedElementSourceNames;
            this.X = aVar.mSharedElementTargetNames;
            this.Y = aVar.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(FragmentManager fragmentManager) {
        a aVar = new a(fragmentManager);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.f15520a.length) {
            FragmentTransaction.a aVar2 = new FragmentTransaction.a();
            int i12 = i10 + 1;
            aVar2.f15638a = this.f15520a[i10];
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f15520a[i12]);
            }
            String str = (String) this.f15521b.get(i11);
            if (str != null) {
                aVar2.f15639b = fragmentManager.findActiveFragment(str);
            } else {
                aVar2.f15639b = null;
            }
            aVar2.f15644g = Lifecycle.State.values()[this.f15522c[i11]];
            aVar2.f15645h = Lifecycle.State.values()[this.f15523d[i11]];
            int[] iArr = this.f15520a;
            int i13 = iArr[i12];
            aVar2.f15640c = i13;
            int i14 = iArr[i10 + 2];
            aVar2.f15641d = i14;
            int i15 = i10 + 4;
            int i16 = iArr[i10 + 3];
            aVar2.f15642e = i16;
            i10 += 5;
            int i17 = iArr[i15];
            aVar2.f15643f = i17;
            aVar.mEnterAnim = i13;
            aVar.mExitAnim = i14;
            aVar.mPopEnterAnim = i16;
            aVar.mPopExitAnim = i17;
            aVar.addOp(aVar2);
            i11++;
        }
        aVar.mTransition = this.f15524e;
        aVar.mName = this.f15525f;
        aVar.f15662c = this.f15526g;
        aVar.mAddToBackStack = true;
        aVar.mBreadCrumbTitleRes = this.f15527h;
        aVar.mBreadCrumbTitleText = this.f15528i;
        aVar.mBreadCrumbShortTitleRes = this.f15529j;
        aVar.mBreadCrumbShortTitleText = this.f15530w;
        aVar.mSharedElementSourceNames = this.C;
        aVar.mSharedElementTargetNames = this.X;
        aVar.mReorderingAllowed = this.Y;
        aVar.b(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f15520a);
        parcel.writeStringList(this.f15521b);
        parcel.writeIntArray(this.f15522c);
        parcel.writeIntArray(this.f15523d);
        parcel.writeInt(this.f15524e);
        parcel.writeString(this.f15525f);
        parcel.writeInt(this.f15526g);
        parcel.writeInt(this.f15527h);
        TextUtils.writeToParcel(this.f15528i, parcel, 0);
        parcel.writeInt(this.f15529j);
        TextUtils.writeToParcel(this.f15530w, parcel, 0);
        parcel.writeStringList(this.C);
        parcel.writeStringList(this.X);
        parcel.writeInt(this.Y ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f15520a = parcel.createIntArray();
        this.f15521b = parcel.createStringArrayList();
        this.f15522c = parcel.createIntArray();
        this.f15523d = parcel.createIntArray();
        this.f15524e = parcel.readInt();
        this.f15525f = parcel.readString();
        this.f15526g = parcel.readInt();
        this.f15527h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f15528i = (CharSequence) creator.createFromParcel(parcel);
        this.f15529j = parcel.readInt();
        this.f15530w = (CharSequence) creator.createFromParcel(parcel);
        this.C = parcel.createStringArrayList();
        this.X = parcel.createStringArrayList();
        this.Y = parcel.readInt() != 0;
    }
}

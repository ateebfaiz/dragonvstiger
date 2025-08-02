package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList f15613a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList f15614b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f15615c;

    /* renamed from: d  reason: collision with root package name */
    int f15616d;

    /* renamed from: e  reason: collision with root package name */
    String f15617e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList f15618f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    ArrayList f15619g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    ArrayList f15620h;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f15613a);
        parcel.writeStringList(this.f15614b);
        parcel.writeTypedArray(this.f15615c, i10);
        parcel.writeInt(this.f15616d);
        parcel.writeString(this.f15617e);
        parcel.writeStringList(this.f15618f);
        parcel.writeTypedList(this.f15619g);
        parcel.writeTypedList(this.f15620h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f15613a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f15614b = parcel.createStringArrayList();
        this.f15615c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f15616d = parcel.readInt();
        this.f15617e = parcel.readString();
        this.f15618f = parcel.createStringArrayList();
        this.f15619g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f15620h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}

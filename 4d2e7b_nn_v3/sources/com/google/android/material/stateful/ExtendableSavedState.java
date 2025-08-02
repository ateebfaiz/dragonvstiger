package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();
    @NonNull
    public final SimpleArrayMap<String, Bundle> extendableStates;

    class a implements Parcelable.ClassLoaderCreator {
        a() {
        }

        /* renamed from: a */
        public ExtendableSavedState createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, (ClassLoader) null, (a) null);
        }

        /* renamed from: b */
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, (a) null);
        }

        /* renamed from: c */
        public ExtendableSavedState[] newArray(int i10) {
            return new ExtendableSavedState[i10];
        }
    }

    /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        int size = this.extendableStates.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = this.extendableStates.keyAt(i11);
            bundleArr[i11] = this.extendableStates.valueAt(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new SimpleArrayMap<>();
    }

    private ExtendableSavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap<>(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.extendableStates.put(strArr[i10], bundleArr[i10]);
        }
    }
}

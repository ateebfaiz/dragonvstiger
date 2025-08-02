package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.m;

public final class ActivityResult$Companion$CREATOR$1 implements Parcelable.Creator<ActivityResult> {
    ActivityResult$Companion$CREATOR$1() {
    }

    public ActivityResult createFromParcel(Parcel parcel) {
        m.f(parcel, "parcel");
        return new ActivityResult(parcel);
    }

    public ActivityResult[] newArray(int i10) {
        return new ActivityResult[i10];
    }
}

package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.m;

public final class IntentSenderRequest$Companion$CREATOR$1 implements Parcelable.Creator<IntentSenderRequest> {
    IntentSenderRequest$Companion$CREATOR$1() {
    }

    public IntentSenderRequest createFromParcel(Parcel parcel) {
        m.f(parcel, "inParcel");
        return new IntentSenderRequest(parcel);
    }

    public IntentSenderRequest[] newArray(int i10) {
        return new IntentSenderRequest[i10];
    }
}

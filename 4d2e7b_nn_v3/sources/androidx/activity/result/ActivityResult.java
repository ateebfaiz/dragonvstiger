package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new ActivityResult$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Intent data;
    private final int resultCode;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        public final String resultCodeToString(int i10) {
            if (i10 == -1) {
                return "RESULT_OK";
            }
            if (i10 != 0) {
                return String.valueOf(i10);
            }
            return "RESULT_CANCELED";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ActivityResult(int i10, Intent intent) {
        this.resultCode = i10;
        this.data = intent;
    }

    public static final String resultCodeToString(int i10) {
        return Companion.resultCodeToString(i10);
    }

    public int describeContents() {
        return 0;
    }

    public final Intent getData() {
        return this.data;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + Companion.resultCodeToString(this.resultCode) + ", data=" + this.data + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        m.f(parcel, "dest");
        parcel.writeInt(this.resultCode);
        if (this.data == null) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        parcel.writeInt(i11);
        Intent intent = this.data;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActivityResult(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        m.f(parcel, "parcel");
    }
}

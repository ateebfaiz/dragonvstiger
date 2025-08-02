package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();
    private final long point;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public DateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), (a) null);
        }

        /* renamed from: b */
        public DateValidatorPointBackward[] newArray(int i10) {
            return new DateValidatorPointBackward[i10];
        }
    }

    /* synthetic */ DateValidatorPointBackward(long j10, a aVar) {
        this(j10);
    }

    @NonNull
    public static DateValidatorPointBackward before(long j10) {
        return new DateValidatorPointBackward(j10);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(k.o().getTimeInMillis());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateValidatorPointBackward)) {
            return false;
        }
        if (this.point == ((DateValidatorPointBackward) obj).point) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long j10) {
        if (j10 <= this.point) {
            return true;
        }
        return false;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeLong(this.point);
    }

    private DateValidatorPointBackward(long j10) {
        this.point = j10;
    }
}

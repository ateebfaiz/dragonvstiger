package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    /* access modifiers changed from: private */
    public static final d ALL_OPERATOR = new b();
    /* access modifiers changed from: private */
    public static final d ANY_OPERATOR = new a();
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();
    @NonNull
    private final d operator;
    @NonNull
    private final List<CalendarConstraints.DateValidator> validators;

    class a implements d {
        a() {
        }

        public boolean a(List list, long j10) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && dateValidator.isValid(j10)) {
                    return true;
                }
            }
            return false;
        }

        public int getId() {
            return 1;
        }
    }

    class b implements d {
        b() {
        }

        public boolean a(List list, long j10) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && !dateValidator.isValid(j10)) {
                    return false;
                }
            }
            return true;
        }

        public int getId() {
            return 2;
        }
    }

    class c implements Parcelable.Creator {
        c() {
        }

        /* renamed from: a */
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            d dVar;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                dVar = CompositeDateValidator.ALL_OPERATOR;
            } else if (readInt == 1) {
                dVar = CompositeDateValidator.ANY_OPERATOR;
            } else {
                dVar = CompositeDateValidator.ALL_OPERATOR;
            }
            return new CompositeDateValidator((List) Preconditions.checkNotNull(readArrayList), dVar, (a) null);
        }

        /* renamed from: b */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    private interface d {
        boolean a(List list, long j10);

        int getId();
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    @NonNull
    public static CalendarConstraints.DateValidator anyOf(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        if (!this.validators.equals(compositeDateValidator.validators) || this.operator.getId() != compositeDateValidator.operator.getId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    public boolean isValid(long j10) {
        return this.operator.a(this.validators, j10);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, d dVar) {
        this.validators = list;
        this.operator = dVar;
    }
}

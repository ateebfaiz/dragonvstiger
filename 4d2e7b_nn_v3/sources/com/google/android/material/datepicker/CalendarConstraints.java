package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    /* access modifiers changed from: private */
    @NonNull
    public final Month end;
    private final int monthSpan;
    /* access modifiers changed from: private */
    @Nullable
    public Month openAt;
    /* access modifiers changed from: private */
    @NonNull
    public final Month start;
    /* access modifiers changed from: private */
    @NonNull
    public final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j10);
    }

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            Class<Month> cls = Month.class;
            return new CalendarConstraints((Month) parcel.readParcelable(cls.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), (a) null);
        }

        /* renamed from: b */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    /* access modifiers changed from: package-private */
    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        if (month.compareTo(this.end) > 0) {
            return this.end;
        }
        return month;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.start.equals(calendarConstraints.start) || !this.end.equals(calendarConstraints.end) || !ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) || !this.validator.equals(calendarConstraints.validator)) {
            return false;
        }
        return true;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month getEnd() {
        return this.end;
    }

    /* access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month getStart() {
        return this.start;
    }

    /* access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    /* access modifiers changed from: package-private */
    public boolean isWithinBounds(long j10) {
        if (this.start.f(1) <= j10) {
            Month month = this.end;
            if (j10 <= month.f(month.f8153e)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.monthSpan = month.k(month2) + 1;
            this.yearSpan = (month2.f8151c - month.f8151c) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = k.a(Month.b(2100, 11).f8154f);
        static final long DEFAULT_START = k.a(Month.b(1900, 0).f8154f);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        @NonNull
        public CalendarConstraints build() {
            Month c10;
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month c11 = Month.c(this.start);
            Month c12 = Month.c(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l10 = this.openAt;
            if (l10 == null) {
                c10 = null;
            } else {
                c10 = Month.c(l10.longValue());
            }
            return new CalendarConstraints(c11, c12, dateValidator, c10, (a) null);
        }

        @NonNull
        public Builder setEnd(long j10) {
            this.end = j10;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j10) {
            this.openAt = Long.valueOf(j10);
            return this;
        }

        @NonNull
        public Builder setStart(long j10) {
            this.start = j10;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.f8154f;
            this.end = calendarConstraints.end.f8154f;
            this.openAt = Long.valueOf(calendarConstraints.openAt.f8154f);
            this.validator = calendarConstraints.validator;
        }
    }
}

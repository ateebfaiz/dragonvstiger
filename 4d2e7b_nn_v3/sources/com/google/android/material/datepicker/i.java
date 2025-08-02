package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class i {

    /* renamed from: c  reason: collision with root package name */
    private static final i f8210c = new i((Long) null, (TimeZone) null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f8211a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f8212b;

    private i(Long l10, TimeZone timeZone) {
        this.f8211a = l10;
        this.f8212b = timeZone;
    }

    static i c() {
        return f8210c;
    }

    /* access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f8212b);
    }

    /* access modifiers changed from: package-private */
    public Calendar b(TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l10 = this.f8211a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}

package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

abstract class d {
    static Pair a(Long l10, Long l11) {
        return b(l10, l11, (SimpleDateFormat) null);
    }

    static Pair b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return Pair.create(null, null);
        }
        if (l10 == null) {
            return Pair.create(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return Pair.create(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar o10 = k.o();
        Calendar q10 = k.q();
        q10.setTimeInMillis(l10.longValue());
        Calendar q11 = k.q();
        q11.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        } else if (q10.get(1) != q11.get(1)) {
            return Pair.create(k(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault()));
        } else {
            if (q10.get(1) == o10.get(1)) {
                return Pair.create(f(l10.longValue(), Locale.getDefault()), f(l11.longValue(), Locale.getDefault()));
            }
            return Pair.create(f(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault()));
        }
    }

    static String c(long j10) {
        return d(j10, (SimpleDateFormat) null);
    }

    static String d(long j10, SimpleDateFormat simpleDateFormat) {
        Calendar o10 = k.o();
        Calendar q10 = k.q();
        q10.setTimeInMillis(j10);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j10));
        }
        if (o10.get(1) == q10.get(1)) {
            return e(j10);
        }
        return j(j10);
    }

    static String e(long j10) {
        return f(j10, Locale.getDefault());
    }

    static String f(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return k.c(locale).format(new Date(j10));
        }
        return k.j(locale).format(new Date(j10));
    }

    static String g(long j10) {
        return h(j10, Locale.getDefault());
    }

    static String h(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return k.d(locale).format(new Date(j10));
        }
        return k.h(locale).format(new Date(j10));
    }

    static String i(long j10) {
        return DateUtils.formatDateTime((Context) null, j10, 8228);
    }

    static String j(long j10) {
        return k(j10, Locale.getDefault());
    }

    static String k(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return k.s(locale).format(new Date(j10));
        }
        return k.i(locale).format(new Date(j10));
    }

    static String l(long j10) {
        return m(j10, Locale.getDefault());
    }

    static String m(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return k.t(locale).format(new Date(j10));
        }
        return k.h(locale).format(new Date(j10));
    }
}

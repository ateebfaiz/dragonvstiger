package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

abstract class k {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference f8213a = new AtomicReference();

    static long a(long j10) {
        Calendar q10 = q();
        q10.setTimeInMillis(j10);
        return f(q10).getTimeInMillis();
    }

    private static int b(String str, String str2, int i10, int i11) {
        while (i11 >= 0 && i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            if (str.charAt(i11) == '\'') {
                do {
                    i11 += i10;
                    if (i11 < 0) {
                        break;
                    } else if (i11 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i11) == '\'');
            }
            i11 += i10;
        }
        return i11;
    }

    static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    private static DateFormat e(String str, Locale locale) {
        DateFormat a10 = DateFormat.getInstanceForSkeleton(str, locale);
        a10.setTimeZone(p());
        return a10;
    }

    static Calendar f(Calendar calendar) {
        Calendar r10 = r(calendar);
        Calendar q10 = q();
        q10.set(r10.get(1), r10.get(2), r10.get(5));
        return q10;
    }

    private static java.text.DateFormat g(int i10, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i10, locale);
        dateInstance.setTimeZone(n());
        return dateInstance;
    }

    static java.text.DateFormat h(Locale locale) {
        return g(0, locale);
    }

    static java.text.DateFormat i(Locale locale) {
        return g(2, locale);
    }

    static java.text.DateFormat j(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) i(locale);
        simpleDateFormat.applyPattern(u(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(n());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String l(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", "yyyy");
        }
        return pattern.replace(DomainUhfReportModel.ENCRYPTDATA, string3).replace("M", string2).replace("y", string);
    }

    static i m() {
        i iVar = (i) f8213a.get();
        if (iVar == null) {
            return i.c();
        }
        return iVar;
    }

    private static TimeZone n() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar o() {
        Calendar a10 = m().a();
        a10.set(11, 0);
        a10.set(12, 0);
        a10.set(13, 0);
        a10.set(14, 0);
        a10.setTimeZone(n());
        return a10;
    }

    private static android.icu.util.TimeZone p() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar q() {
        return r((Calendar) null);
    }

    static Calendar r(Calendar calendar) {
        Calendar instance = Calendar.getInstance(n());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    static DateFormat s(Locale locale) {
        return e("yMMMd", locale);
    }

    static DateFormat t(Locale locale) {
        return e("yMMMEd", locale);
    }

    private static String u(String str) {
        int b10 = b(str, "yY", 1, 0);
        if (b10 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b11 = b(str, str2, 1, b10);
        if (b11 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(b(str, str2, -1, b10) + 1, b11), " ").trim();
    }
}

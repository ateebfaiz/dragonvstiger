package com.facebook.hermes.unicode;

import d6.a;
import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.jvm.internal.m;

@a
public final class AndroidUnicodeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AndroidUnicodeUtils f19958a = new AndroidUnicodeUtils();

    private AndroidUnicodeUtils() {
    }

    @a
    public static final String convertToCase(String str, int i10, boolean z10) {
        Locale locale;
        m.f(str, "input");
        if (z10) {
            locale = Locale.getDefault();
        } else {
            locale = Locale.ENGLISH;
        }
        if (i10 == 0) {
            m.c(locale);
            String upperCase = str.toUpperCase(locale);
            m.e(upperCase, "toUpperCase(...)");
            return upperCase;
        } else if (i10 == 1) {
            m.c(locale);
            String lowerCase = str.toLowerCase(locale);
            m.e(lowerCase, "toLowerCase(...)");
            return lowerCase;
        } else {
            throw new IllegalStateException("Invalid target case".toString());
        }
    }

    @a
    public static final String dateFormat(double d10, boolean z10, boolean z11) {
        DateFormat dateFormat;
        if (z10 && z11) {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        } else if (z10) {
            dateFormat = DateFormat.getDateInstance(2);
        } else if (z11) {
            dateFormat = DateFormat.getTimeInstance(2);
        } else {
            throw new IllegalStateException("Bad dateFormat configuration".toString());
        }
        return dateFormat.format(Long.valueOf((long) d10)).toString();
    }

    @a
    public static final int localeCompare(String str, String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    @a
    public static final String normalize(String str, int i10) {
        if (i10 == 0) {
            String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
            m.e(normalize, "normalize(...)");
            return normalize;
        } else if (i10 == 1) {
            String normalize2 = Normalizer.normalize(str, Normalizer.Form.NFD);
            m.e(normalize2, "normalize(...)");
            return normalize2;
        } else if (i10 == 2) {
            String normalize3 = Normalizer.normalize(str, Normalizer.Form.NFKC);
            m.e(normalize3, "normalize(...)");
            return normalize3;
        } else if (i10 == 3) {
            String normalize4 = Normalizer.normalize(str, Normalizer.Form.NFKD);
            m.e(normalize4, "normalize(...)");
            return normalize4;
        } else {
            throw new IllegalStateException("Invalid form".toString());
        }
    }
}

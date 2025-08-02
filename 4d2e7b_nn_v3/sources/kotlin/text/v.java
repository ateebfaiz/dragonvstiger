package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

class v extends u {
    public static String R0(String str, int i10) {
        m.f(str, "<this>");
        if (i10 >= 0) {
            String substring = str.substring(l.f(i10, str.length()));
            m.e(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char S0(CharSequence charSequence) {
        m.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(t.P(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String T0(String str, int i10) {
        m.f(str, "<this>");
        if (i10 >= 0) {
            String substring = str.substring(0, l.f(i10, str.length()));
            m.e(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}

package okhttp3;

import java.util.Comparator;
import kotlin.jvm.internal.m;

public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    CipherSuite$Companion$ORDER_BY_NAME$1() {
    }

    public int compare(String str, String str2) {
        m.f(str, "a");
        m.f(str2, "b");
        int min = Math.min(str.length(), str2.length());
        int i10 = 4;
        while (i10 < min) {
            char charAt = str.charAt(i10);
            char charAt2 = str2.charAt(i10);
            if (charAt == charAt2) {
                i10++;
            } else if (m.g(charAt, charAt2) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return -1;
        }
        return 1;
    }
}

package kotlin.ranges;

import io.jsonwebtoken.JwtParser;

class m {
    public static final void a(boolean z10, Number number) {
        kotlin.jvm.internal.m.f(number, "step");
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + JwtParser.SEPARATOR_CHAR);
        }
    }
}

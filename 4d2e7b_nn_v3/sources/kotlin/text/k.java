package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

class k {
    public static void a(Appendable appendable, Object obj, Function1 function1) {
        boolean z10;
        m.f(appendable, "<this>");
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null) {
            z10 = true;
        } else {
            z10 = obj instanceof CharSequence;
        }
        if (z10) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}

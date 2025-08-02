package okio;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.text.d;

/* renamed from: okio.-Platform  reason: invalid class name */
public final class Platform {
    public static final byte[] asUtf8ToByteArray(String str) {
        m.f(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(d.f797b);
        m.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m134synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        m.f(obj, "lock");
        m.f(function0, "block");
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                k.b(1);
            } catch (Throwable th) {
                k.b(1);
                k.a(1);
                throw th;
            }
        }
        k.a(1);
        return invoke;
    }

    public static final String toUtf8String(byte[] bArr) {
        m.f(bArr, "$this$toUtf8String");
        return new String(bArr, d.f797b);
    }
}

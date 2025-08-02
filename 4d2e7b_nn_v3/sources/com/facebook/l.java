package com.facebook;

import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import q5.n;

public class l extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public static final b f20373a = new b((DefaultConstructorMarker) null);

    static final class a implements n.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20374a;

        a(String str) {
            this.f20374a = str;
        }

        public final void a(boolean z10) {
            if (z10) {
                try {
                    w5.b.c(this.f20374a);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l() {
    }

    public String toString() {
        String message = getMessage();
        if (message != null) {
            return message;
        }
        return "";
    }

    public l(String str) {
        super(str);
        Random random = new Random();
        if (str != null && o.A() && random.nextInt(100) > 50) {
            n.a(n.b.ErrorReport, new a(str));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(java.lang.String r2, java.lang.Object... r3) {
        /*
            r1 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.m.f(r3, r0)
            if (r2 == 0) goto L_0x001d
            kotlin.jvm.internal.b0 r0 = kotlin.jvm.internal.b0.f709a
            int r0 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            int r0 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.String r3 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.m.e(r2, r3)
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            r1.<init>((java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.l.<init>(java.lang.String, java.lang.Object[]):void");
    }

    public l(String str, Throwable th) {
        super(str, th);
    }

    public l(Throwable th) {
        super(th);
    }
}

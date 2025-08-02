package com.bugsnag.android.ndk;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.d;

public final class OpaqueValue {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18886b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f18887a;

    public static final class a {
        private a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
            tb.c.a(r0, r4);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.Object r4) {
            /*
                r3 = this;
                java.io.StringWriter r0 = new java.io.StringWriter
                r1 = 256(0x100, float:3.59E-43)
                r0.<init>(r1)
                com.bugsnag.android.k2 r1 = new com.bugsnag.android.k2     // Catch:{ all -> 0x001b }
                r1.<init>(r0)     // Catch:{ all -> 0x001b }
                r2 = 0
                r1.Q(r4, r2)     // Catch:{ all -> 0x001b }
                kotlin.Unit r4 = kotlin.Unit.f12577a     // Catch:{ all -> 0x001b }
                r4 = 0
                tb.c.a(r0, r4)
                java.lang.String r4 = r0.toString()
                return r4
            L_0x001b:
                r4 = move-exception
                throw r4     // Catch:{ all -> 0x001d }
            L_0x001d:
                r1 = move-exception
                tb.c.a(r0, r4)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ndk.OpaqueValue.a.a(java.lang.Object):java.lang.String");
        }

        public final boolean b(String str) {
            if (str.length() >= 64) {
                return false;
            }
            int i10 = 0;
            while (i10 < str.length()) {
                char charAt = str.charAt(i10);
                i10++;
                if (charAt > 127) {
                    byte[] bytes = str.getBytes(d.f797b);
                    m.e(bytes, "this as java.lang.String).getBytes(charset)");
                    if (bytes.length < 64) {
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }

        public final Object c(Object obj) {
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj;
            }
            boolean z10 = obj instanceof String;
            if (z10 && b((String) obj)) {
                return obj;
            }
            if (z10 || (obj instanceof Map) || (obj instanceof Collection) || (obj instanceof Object[])) {
                return new OpaqueValue(a(obj));
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OpaqueValue(String str) {
        this.f18887a = str;
    }

    public static final Object makeSafe(Object obj) {
        return f18886b.c(obj);
    }

    public final String getJson() {
        return this.f18887a;
    }
}

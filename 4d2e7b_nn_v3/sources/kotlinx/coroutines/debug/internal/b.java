package kotlinx.coroutines.debug.internal;

import cc.c0;
import kotlin.jvm.internal.m;

public abstract class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f958a = new c0("REHASH");

    /* renamed from: b  reason: collision with root package name */
    private static final e f959b = new e((Object) null);

    /* renamed from: c  reason: collision with root package name */
    private static final e f960c = new e(Boolean.TRUE);

    /* access modifiers changed from: private */
    public static final e d(Object obj) {
        if (obj == null) {
            return f959b;
        }
        if (m.b(obj, Boolean.TRUE)) {
            return f960c;
        }
        return new e(obj);
    }

    /* access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}

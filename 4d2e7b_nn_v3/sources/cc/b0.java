package cc;

import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.o;
import kotlin.p;
import y.a;

public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement f56a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f57b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f58c;

    static {
        Object obj;
        Object obj2;
        try {
            o.a aVar = o.f12592b;
            obj = o.b(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (o.d(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f57b = (String) obj;
        try {
            obj2 = o.b(b0.class.getCanonicalName());
        } catch (Throwable th2) {
            o.a aVar3 = o.f12592b;
            obj2 = o.b(p.a(th2));
        }
        if (o.d(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f58c = (String) obj2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}

package bc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final e f30a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        e eVar = null;
        try {
            o.a aVar = o.f12592b;
            obj = o.b(new d(a(Looper.getMainLooper(), true), (String) null, 2, (DefaultConstructorMarker) null));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        if (!o.f(obj)) {
            eVar = obj;
        }
        f30a = eVar;
    }

    public static final Handler a(Looper looper, boolean z10) {
        if (!z10) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            m.d(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}

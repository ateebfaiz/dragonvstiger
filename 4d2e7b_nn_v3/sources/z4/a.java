package z4;

import android.util.Log;
import c3.a;
import c3.h;
import c3.i;
import java.io.Closeable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final a.c f25011a;

    /* renamed from: z4.a$a  reason: collision with other inner class name */
    class C0363a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b5.a f25012a;

        C0363a(b5.a aVar) {
            this.f25012a = aVar;
        }

        public boolean a() {
            return this.f25012a.b();
        }

        public void b(i iVar, Throwable th) {
            String str;
            this.f25012a.a(iVar, th);
            Object f10 = iVar.f();
            if (f10 != null) {
                str = f10.getClass().getName();
            } else {
                str = "<value is null>";
            }
            z2.a.I("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(iVar)), str, a.d(th));
        }
    }

    public a(b5.a aVar) {
        this.f25011a = new C0363a(aVar);
    }

    /* access modifiers changed from: private */
    public static String d(Throwable th) {
        if (th == null) {
            return "";
        }
        return Log.getStackTraceString(th);
    }

    public c3.a b(Closeable closeable) {
        return c3.a.A(closeable, this.f25011a);
    }

    public c3.a c(Object obj, h hVar) {
        return c3.a.C(obj, hVar, this.f25011a);
    }
}

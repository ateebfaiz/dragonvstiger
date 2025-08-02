package ob;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public abstract class a {

    /* renamed from: ob.a$a  reason: collision with other inner class name */
    public static final class C0022a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0 f1342a;

        C0022a(Function0 function0) {
            this.f1342a = function0;
        }

        public void run() {
            this.f1342a.invoke();
        }
    }

    public static final Thread a(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, Function0 function0) {
        m.f(function0, "block");
        C0022a aVar = new C0022a(function0);
        if (z11) {
            aVar.setDaemon(true);
        }
        if (i10 > 0) {
            aVar.setPriority(i10);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z10) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread b(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, Function0 function0, int i11, Object obj) {
        ClassLoader classLoader2;
        String str2;
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        boolean z12 = z10;
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        if ((i11 & 4) != 0) {
            classLoader2 = null;
        } else {
            classLoader2 = classLoader;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i11 & 16) != 0) {
            i10 = -1;
        }
        return a(z12, z13, classLoader2, str2, i10, function0);
    }
}

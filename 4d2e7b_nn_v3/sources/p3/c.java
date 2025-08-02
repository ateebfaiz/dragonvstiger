package p3;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import l5.b;
import z4.k;
import z4.l;
import z4.o;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f23112a = c.class;

    /* renamed from: b  reason: collision with root package name */
    private static f f23113b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f23114c;

    public static k a() {
        return b().l();
    }

    public static o b() {
        return o.n();
    }

    public static void c(Context context, l lVar) {
        d(context, lVar, (b) null);
    }

    public static void d(Context context, l lVar, b bVar) {
        e(context, lVar, bVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (l5.b.d() != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        l5.b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        a8.a.b(new a8.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (l5.b.d() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        a8.a.b(new a8.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (l5.b.d() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        a8.a.b(new a8.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (l5.b.d() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        a8.a.b(new a8.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        if (l5.b.d() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (l5.b.d() != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        l5.b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x0055, B:23:0x0064, B:27:0x0073, B:31:0x0082] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0082 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0082=Splitter:B:31:0x0082, B:27:0x0073=Splitter:B:27:0x0073, B:23:0x0064=Splitter:B:23:0x0064, B:19:0x0055=Splitter:B:19:0x0055} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(android.content.Context r5, z4.l r6, p3.b r7, boolean r8) {
        /*
            r0 = 0
            r1 = 1
            boolean r2 = l5.b.d()
            if (r2 == 0) goto L_0x000d
            java.lang.String r2 = "Fresco#initialize"
            l5.b.a(r2)
        L_0x000d:
            boolean r2 = f23114c
            if (r2 == 0) goto L_0x0019
            java.lang.Class r2 = f23112a
            java.lang.String r3 = "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!"
            z2.a.C(r2, r3)
            goto L_0x001b
        L_0x0019:
            f23114c = r1
        L_0x001b:
            z4.p.b(r8)
            boolean r8 = a8.a.c()
            if (r8 != 0) goto L_0x009b
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x002f
            java.lang.String r8 = "Fresco.initialize->SoLoader.init"
            l5.b.a(r8)
        L_0x002f:
            java.lang.String r8 = "com.facebook.imagepipeline.nativecode.NativeCodeInitializer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            java.lang.String r2 = "init"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r0] = r4     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            java.lang.reflect.Method r8 = r8.getMethod(r2, r3)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            r1[r0] = r5     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            r0 = 0
            r8.invoke(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0082, IllegalAccessException -> 0x0073, InvocationTargetException -> 0x0064, NoSuchMethodException -> 0x0055 }
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x009b
        L_0x004f:
            l5.b.b()
            goto L_0x009b
        L_0x0053:
            r5 = move-exception
            goto L_0x0091
        L_0x0055:
            a8.c r8 = new a8.c     // Catch:{ all -> 0x0053 }
            r8.<init>()     // Catch:{ all -> 0x0053 }
            a8.a.b(r8)     // Catch:{ all -> 0x0053 }
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x009b
            goto L_0x004f
        L_0x0064:
            a8.c r8 = new a8.c     // Catch:{ all -> 0x0053 }
            r8.<init>()     // Catch:{ all -> 0x0053 }
            a8.a.b(r8)     // Catch:{ all -> 0x0053 }
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x009b
            goto L_0x004f
        L_0x0073:
            a8.c r8 = new a8.c     // Catch:{ all -> 0x0053 }
            r8.<init>()     // Catch:{ all -> 0x0053 }
            a8.a.b(r8)     // Catch:{ all -> 0x0053 }
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x009b
            goto L_0x004f
        L_0x0082:
            a8.c r8 = new a8.c     // Catch:{ all -> 0x0053 }
            r8.<init>()     // Catch:{ all -> 0x0053 }
            a8.a.b(r8)     // Catch:{ all -> 0x0053 }
            boolean r8 = l5.b.d()
            if (r8 == 0) goto L_0x009b
            goto L_0x004f
        L_0x0091:
            boolean r6 = l5.b.d()
            if (r6 == 0) goto L_0x009a
            l5.b.b()
        L_0x009a:
            throw r5
        L_0x009b:
            android.content.Context r5 = r5.getApplicationContext()
            if (r6 != 0) goto L_0x00a5
            z4.o.w(r5)
            goto L_0x00a8
        L_0x00a5:
            z4.o.x(r6)
        L_0x00a8:
            f(r5, r7)
            boolean r5 = l5.b.d()
            if (r5 == 0) goto L_0x00b4
            l5.b.b()
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.c.e(android.content.Context, z4.l, p3.b, boolean):void");
    }

    private static void f(Context context, b bVar) {
        if (b.d()) {
            b.a("Fresco.initializeDrawee");
        }
        f fVar = new f(context, bVar);
        f23113b = fVar;
        SimpleDraweeView.i(fVar);
        if (b.d()) {
            b.b();
        }
    }

    public static e g() {
        return f23113b.get();
    }
}

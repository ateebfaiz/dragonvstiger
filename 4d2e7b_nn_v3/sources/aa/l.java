package aa;

import c.d;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import y9.o;

public abstract class l {

    private static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f2323a;

        class a extends b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Method f2324b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f2324b = method;
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f2324b.invoke(accessibleObject, new Object[]{obj})).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* renamed from: aa.l$b$b  reason: collision with other inner class name */
        class C0041b extends b {
            C0041b() {
                super();
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
        static {
            /*
                boolean r0 = aa.e.d()
                if (r0 == 0) goto L_0x001c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 0
                r2[r4] = r3     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
                aa.l$b$a r1 = new aa.l$b$a     // Catch:{ NoSuchMethodException -> 0x001c }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x001c }
                goto L_0x001d
            L_0x001c:
                r1 = 0
            L_0x001d:
                if (r1 != 0) goto L_0x0024
                aa.l$b$b r1 = new aa.l$b$b
                r1.<init>()
            L_0x0024:
                f2323a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: aa.l.b.<clinit>():void");
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f2323a.a(accessibleObject, obj);
    }

    public static o b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return o.ALLOW;
        }
        d.a(it.next());
        throw null;
    }
}

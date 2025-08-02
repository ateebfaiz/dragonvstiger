package q8;

import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.d;
import i8.b;
import j8.l;

public abstract class g {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12914a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.c0$a[] r0 = com.fasterxml.jackson.annotation.c0.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12914a = r0
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.EXISTING_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12914a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.EXTERNAL_PROPERTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12914a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.PROPERTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12914a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12914a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q8.g.a.<clinit>():void");
        }
    }

    public abstract g a(d dVar);

    public abstract String b();

    public abstract c0.a c();

    public b d(Object obj, k kVar) {
        b bVar = new b(obj, kVar);
        int i10 = a.f12914a[c().ordinal()];
        if (i10 == 1) {
            bVar.f12334e = b.a.PAYLOAD_PROPERTY;
            bVar.f12333d = b();
        } else if (i10 == 2) {
            bVar.f12334e = b.a.PARENT_PROPERTY;
            bVar.f12333d = b();
        } else if (i10 == 3) {
            bVar.f12334e = b.a.METADATA_PROPERTY;
            bVar.f12333d = b();
        } else if (i10 == 4) {
            bVar.f12334e = b.a.WRAPPER_ARRAY;
        } else if (i10 != 5) {
            l.a();
        } else {
            bVar.f12334e = b.a.WRAPPER_OBJECT;
        }
        return bVar;
    }

    public b e(Object obj, k kVar, Object obj2) {
        b d10 = d(obj, kVar);
        d10.f12332c = obj2;
        return d10;
    }

    public b f(Object obj, Class cls, k kVar) {
        b d10 = d(obj, kVar);
        d10.f12331b = cls;
        return d10;
    }

    public abstract b g(f fVar, b bVar);

    public abstract b h(f fVar, b bVar);
}

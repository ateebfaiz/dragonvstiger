package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

class j {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12586a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.l[] r0 = kotlin.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.l r1 = kotlin.l.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.l r1 = kotlin.l.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.l r1 = kotlin.l.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f12586a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.j.a.<clinit>():void");
        }
    }

    public static Lazy a(l lVar, Function0 function0) {
        m.f(lVar, "mode");
        m.f(function0, "initializer");
        int i10 = a.f12586a[lVar.ordinal()];
        if (i10 == 1) {
            return new r(function0, (Object) null, 2, (DefaultConstructorMarker) null);
        }
        if (i10 == 2) {
            return new q(function0);
        }
        if (i10 == 3) {
            return new x(function0);
        }
        throw new n();
    }

    public static Lazy b(Function0 function0) {
        m.f(function0, "initializer");
        return new r(function0, (Object) null, 2, (DefaultConstructorMarker) null);
    }
}

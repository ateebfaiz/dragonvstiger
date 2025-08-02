package l7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;

public enum g {
    CREATE,
    UPDATE,
    DELETE;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f12637a = null;

    public static final class a {

        /* renamed from: l7.g$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0149a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f12643a = null;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    l7.g[] r0 = l7.g.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    l7.g r1 = l7.g.CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    l7.g r1 = l7.g.UPDATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    l7.g r1 = l7.g.DELETE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    f12643a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: l7.g.a.C0149a.<clinit>():void");
            }
        }

        private a() {
        }

        public final String a(g gVar) {
            m.f(gVar, "type");
            int i10 = C0149a.f12643a[gVar.ordinal()];
            if (i10 == 1) {
                return "create";
            }
            if (i10 == 2) {
                return "update";
            }
            if (i10 == 3) {
                return "delete";
            }
            throw new n();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        g[] a10;
        f12642f = pb.a.a(a10);
        f12637a = new a((DefaultConstructorMarker) null);
    }

    public static final String b(g gVar) {
        return f12637a.a(gVar);
    }
}

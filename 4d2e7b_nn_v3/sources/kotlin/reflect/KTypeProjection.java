package kotlin.reflect;

import androidx.webkit.ProxyConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;
import zb.k;
import zb.l;

public final class KTypeProjection {

    /* renamed from: b  reason: collision with root package name */
    public static final a f762b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    public static final KTypeProjection f763c = new KTypeProjection((l) null, (k) null);

    /* renamed from: a  reason: collision with root package name */
    private final l f764a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f765a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                zb.l[] r0 = zb.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                zb.l r1 = zb.l.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                zb.l r1 = zb.l.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                zb.l r1 = zb.l.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f765a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KTypeProjection.b.<clinit>():void");
        }
    }

    public KTypeProjection(l lVar, k kVar) {
        String str;
        this.f764a = lVar;
        if (lVar != null) {
            if (lVar == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + lVar + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KTypeProjection) && this.f764a == ((KTypeProjection) obj).f764a && m.b((Object) null, (Object) null);
    }

    public int hashCode() {
        l lVar = this.f764a;
        return (lVar == null ? 0 : lVar.hashCode()) * 31;
    }

    public String toString() {
        int i10;
        l lVar = this.f764a;
        if (lVar == null) {
            i10 = -1;
        } else {
            i10 = b.f765a[lVar.ordinal()];
        }
        if (i10 == -1) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        if (i10 == 1) {
            return "null";
        }
        if (i10 == 2) {
            return "in " + null;
        } else if (i10 == 3) {
            return "out " + null;
        } else {
            throw new n();
        }
    }
}

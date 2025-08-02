package t0;

import android.graphics.Paint;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import java.util.List;
import n0.t;
import s0.d;

public class s implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f24035a;

    /* renamed from: b  reason: collision with root package name */
    private final s0.b f24036b;

    /* renamed from: c  reason: collision with root package name */
    private final List f24037c;

    /* renamed from: d  reason: collision with root package name */
    private final s0.a f24038d;

    /* renamed from: e  reason: collision with root package name */
    private final d f24039e;

    /* renamed from: f  reason: collision with root package name */
    private final s0.b f24040f;

    /* renamed from: g  reason: collision with root package name */
    private final b f24041g;

    /* renamed from: h  reason: collision with root package name */
    private final c f24042h;

    /* renamed from: i  reason: collision with root package name */
    private final float f24043i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f24044j;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24045a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f24046b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                t0.s$c[] r0 = t0.s.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24046b = r0
                r1 = 1
                t0.s$c r2 = t0.s.c.BEVEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f24046b     // Catch:{ NoSuchFieldError -> 0x001d }
                t0.s$c r3 = t0.s.c.MITER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f24046b     // Catch:{ NoSuchFieldError -> 0x0028 }
                t0.s$c r4 = t0.s.c.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                t0.s$b[] r3 = t0.s.b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f24045a = r3
                t0.s$b r4 = t0.s.b.BUTT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f24045a     // Catch:{ NoSuchFieldError -> 0x0043 }
                t0.s$b r3 = t0.s.b.ROUND     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f24045a     // Catch:{ NoSuchFieldError -> 0x004d }
                t0.s$b r1 = t0.s.b.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t0.s.a.<clinit>():void");
        }
    }

    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap b() {
            int i10 = a.f24045a[ordinal()];
            if (i10 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join b() {
            int i10 = a.f24046b[ordinal()];
            if (i10 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i10 == 2) {
                return Paint.Join.MITER;
            }
            if (i10 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public s(String str, s0.b bVar, List list, s0.a aVar, d dVar, s0.b bVar2, b bVar3, c cVar, float f10, boolean z10) {
        this.f24035a = str;
        this.f24036b = bVar;
        this.f24037c = list;
        this.f24038d = aVar;
        this.f24039e = dVar;
        this.f24040f = bVar2;
        this.f24041g = bVar3;
        this.f24042h = cVar;
        this.f24043i = f10;
        this.f24044j = z10;
    }

    public n0.c a(k0 k0Var, j jVar, u0.b bVar) {
        return new t(k0Var, bVar, this);
    }

    public b b() {
        return this.f24041g;
    }

    public s0.a c() {
        return this.f24038d;
    }

    public s0.b d() {
        return this.f24036b;
    }

    public c e() {
        return this.f24042h;
    }

    public List f() {
        return this.f24037c;
    }

    public float g() {
        return this.f24043i;
    }

    public String h() {
        return this.f24035a;
    }

    public d i() {
        return this.f24039e;
    }

    public s0.b j() {
        return this.f24040f;
    }

    public boolean k() {
        return this.f24044j;
    }
}

package t0;

import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import n0.c;
import n0.n;
import s0.b;
import s0.o;

public class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f23992a;

    /* renamed from: b  reason: collision with root package name */
    private final a f23993b;

    /* renamed from: c  reason: collision with root package name */
    private final b f23994c;

    /* renamed from: d  reason: collision with root package name */
    private final o f23995d;

    /* renamed from: e  reason: collision with root package name */
    private final b f23996e;

    /* renamed from: f  reason: collision with root package name */
    private final b f23997f;

    /* renamed from: g  reason: collision with root package name */
    private final b f23998g;

    /* renamed from: h  reason: collision with root package name */
    private final b f23999h;

    /* renamed from: i  reason: collision with root package name */
    private final b f24000i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f24001j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f24002k;

    public enum a {
        STAR(1),
        POLYGON(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f24006a;

        private a(int i10) {
            this.f24006a = i10;
        }

        public static a b(int i10) {
            for (a aVar : values()) {
                if (aVar.f24006a == i10) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public k(String str, a aVar, b bVar, o oVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z10, boolean z11) {
        this.f23992a = str;
        this.f23993b = aVar;
        this.f23994c = bVar;
        this.f23995d = oVar;
        this.f23996e = bVar2;
        this.f23997f = bVar3;
        this.f23998g = bVar4;
        this.f23999h = bVar5;
        this.f24000i = bVar6;
        this.f24001j = z10;
        this.f24002k = z11;
    }

    public c a(k0 k0Var, j jVar, u0.b bVar) {
        return new n(k0Var, bVar, this);
    }

    public b b() {
        return this.f23997f;
    }

    public b c() {
        return this.f23999h;
    }

    public String d() {
        return this.f23992a;
    }

    public b e() {
        return this.f23998g;
    }

    public b f() {
        return this.f24000i;
    }

    public b g() {
        return this.f23994c;
    }

    public o h() {
        return this.f23995d;
    }

    public b i() {
        return this.f23996e;
    }

    public a j() {
        return this.f23993b;
    }

    public boolean k() {
        return this.f24001j;
    }

    public boolean l() {
        return this.f24002k;
    }
}

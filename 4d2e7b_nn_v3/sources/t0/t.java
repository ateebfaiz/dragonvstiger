package t0;

import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import n0.c;
import n0.u;
import s0.b;

public class t implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f24055a;

    /* renamed from: b  reason: collision with root package name */
    private final a f24056b;

    /* renamed from: c  reason: collision with root package name */
    private final b f24057c;

    /* renamed from: d  reason: collision with root package name */
    private final b f24058d;

    /* renamed from: e  reason: collision with root package name */
    private final b f24059e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24060f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a b(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i10);
        }
    }

    public t(String str, a aVar, b bVar, b bVar2, b bVar3, boolean z10) {
        this.f24055a = str;
        this.f24056b = aVar;
        this.f24057c = bVar;
        this.f24058d = bVar2;
        this.f24059e = bVar3;
        this.f24060f = z10;
    }

    public c a(k0 k0Var, j jVar, u0.b bVar) {
        return new u(bVar, this);
    }

    public b b() {
        return this.f24058d;
    }

    public String c() {
        return this.f24055a;
    }

    public b d() {
        return this.f24059e;
    }

    public b e() {
        return this.f24057c;
    }

    public a f() {
        return this.f24056b;
    }

    public boolean g() {
        return this.f24060f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f24057c + ", end: " + this.f24058d + ", offset: " + this.f24059e + "}";
    }
}

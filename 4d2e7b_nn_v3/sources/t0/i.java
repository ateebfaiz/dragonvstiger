package t0;

import s0.d;
import s0.h;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final a f23974a;

    /* renamed from: b  reason: collision with root package name */
    private final h f23975b;

    /* renamed from: c  reason: collision with root package name */
    private final d f23976c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23977d;

    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public i(a aVar, h hVar, d dVar, boolean z10) {
        this.f23974a = aVar;
        this.f23975b = hVar;
        this.f23976c = dVar;
        this.f23977d = z10;
    }

    public a a() {
        return this.f23974a;
    }

    public h b() {
        return this.f23975b;
    }

    public d c() {
        return this.f23976c;
    }

    public boolean d() {
        return this.f23977d;
    }
}

package s9;

import ha.c;
import ha.f;
import io.jsonwebtoken.JwtParser;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicReference;

public abstract class j extends e {

    /* renamed from: c  reason: collision with root package name */
    private final i f13035c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13036d;

    /* renamed from: e  reason: collision with root package name */
    private c f13037e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference f13038f;

    public enum a {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    public j(c cVar, c cVar2, c cVar3) {
        this(cVar, new l(cVar2), cVar3);
    }

    private String f() {
        if (this.f13035c.j()) {
            return i().d().toString() + JwtParser.SEPARATOR_CHAR + b().c().toString();
        }
        return i().d().toString() + JwtParser.SEPARATOR_CHAR + b().toString();
    }

    private void h() {
        if (this.f13038f.get() != a.SIGNED && this.f13038f.get() != a.VERIFIED) {
            throw new IllegalStateException("The JWS object must be in a signed or verified state");
        }
    }

    public i i() {
        return this.f13035c;
    }

    public c j() {
        return this.f13037e;
    }

    public byte[] k() {
        return this.f13036d.getBytes(f.f12313a);
    }

    public String l() {
        return m(false);
    }

    public String m(boolean z10) {
        h();
        if (z10) {
            return this.f13035c.d().toString() + JwtParser.SEPARATOR_CHAR + JwtParser.SEPARATOR_CHAR + this.f13037e.toString();
        }
        return this.f13036d + JwtParser.SEPARATOR_CHAR + this.f13037e.toString();
    }

    public synchronized boolean n(k kVar) {
        boolean a10;
        h();
        try {
            a10 = kVar.a(i(), k(), j());
            if (a10) {
                this.f13038f.set(a.VERIFIED);
            }
        } catch (d e10) {
            throw e10;
        } catch (Exception e11) {
            throw new d(e11.getMessage(), e11);
        }
        return a10;
    }

    public j(c cVar, l lVar, c cVar2) {
        AtomicReference atomicReference = new AtomicReference();
        this.f13038f = atomicReference;
        if (cVar != null) {
            try {
                this.f13035c = i.k(cVar);
                if (lVar != null) {
                    d(lVar);
                    this.f13036d = f();
                    if (cVar2 == null) {
                        throw new IllegalArgumentException("The third part must not be null");
                    } else if (!cVar2.toString().trim().isEmpty()) {
                        this.f13037e = cVar2;
                        atomicReference.set(a.SIGNED);
                        if (i().j()) {
                            c(cVar, lVar.c(), cVar2);
                            return;
                        }
                        c(cVar, new c(""), cVar2);
                    } else {
                        throw new ParseException("The signature must not be empty", 0);
                    }
                } else {
                    throw new IllegalArgumentException("The payload (second part) must not be null");
                }
            } catch (ParseException e10) {
                throw new ParseException("Invalid JWS header: " + e10.getMessage(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }
}

package ba;

import ga.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import y9.g;
import y9.i;
import y9.j;
import y9.l;

public final class f extends c {
    private static final Writer N0 = new a();
    private static final l O0 = new l("closed");
    private final List X = new ArrayList();
    private String Y;
    private g Z = i.f13423a;

    class a extends Writer {
        a() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public f() {
        super(N0);
    }

    private g V() {
        List list = this.X;
        return (g) list.get(list.size() - 1);
    }

    private void W(g gVar) {
        if (this.Y != null) {
            if (!gVar.f() || p()) {
                ((j) V()).j(this.Y, gVar);
            }
            this.Y = null;
        } else if (this.X.isEmpty()) {
            this.Z = gVar;
        } else {
            g V = V();
            if (V instanceof y9.f) {
                ((y9.f) V).j(gVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public c B() {
        W(i.f13423a);
        return this;
    }

    public c N(double d10) {
        if (w() || (!Double.isNaN(d10) && !Double.isInfinite(d10))) {
            W(new l((Number) Double.valueOf(d10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
    }

    public c O(long j10) {
        W(new l((Number) Long.valueOf(j10)));
        return this;
    }

    public c P(Boolean bool) {
        if (bool == null) {
            return B();
        }
        W(new l(bool));
        return this;
    }

    public c Q(Number number) {
        if (number == null) {
            return B();
        }
        if (!w()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        W(new l(number));
        return this;
    }

    public c R(String str) {
        if (str == null) {
            return B();
        }
        W(new l(str));
        return this;
    }

    public c S(boolean z10) {
        W(new l(Boolean.valueOf(z10)));
        return this;
    }

    public g U() {
        if (this.X.isEmpty()) {
            return this.Z;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.X);
    }

    public void close() {
        if (this.X.isEmpty()) {
            this.X.add(O0);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() {
    }

    public c h() {
        y9.f fVar = new y9.f();
        W(fVar);
        this.X.add(fVar);
        return this;
    }

    public c j() {
        j jVar = new j();
        W(jVar);
        this.X.add(jVar);
        return this;
    }

    public c m() {
        if (this.X.isEmpty() || this.Y != null) {
            throw new IllegalStateException();
        } else if (V() instanceof y9.f) {
            List list = this.X;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c n() {
        if (this.X.isEmpty() || this.Y != null) {
            throw new IllegalStateException();
        } else if (V() instanceof j) {
            List list = this.X;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c z(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.X.isEmpty() || this.Y != null) {
            throw new IllegalStateException();
        } else if (V() instanceof j) {
            this.Y = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }
}

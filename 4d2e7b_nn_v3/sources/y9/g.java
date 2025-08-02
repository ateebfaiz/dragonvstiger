package y9;

import aa.m;
import ga.c;
import java.io.IOException;
import java.io.StringWriter;

public abstract class g {
    public f a() {
        if (e()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public j c() {
        if (g()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public l d() {
        if (i()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean e() {
        return this instanceof f;
    }

    public boolean f() {
        return this instanceof i;
    }

    public boolean g() {
        return this instanceof j;
    }

    public boolean i() {
        return this instanceof l;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.K(true);
            m.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}

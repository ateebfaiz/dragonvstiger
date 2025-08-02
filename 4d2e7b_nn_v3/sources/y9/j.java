package y9;

import aa.h;
import java.util.Set;

public final class j extends g {

    /* renamed from: a  reason: collision with root package name */
    private final h f13424a = new h(false);

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof j) && ((j) obj).f13424a.equals(this.f13424a))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f13424a.hashCode();
    }

    public void j(String str, g gVar) {
        h hVar = this.f13424a;
        if (gVar == null) {
            gVar = i.f13423a;
        }
        hVar.put(str, gVar);
    }

    public Set k() {
        return this.f13424a.entrySet();
    }
}

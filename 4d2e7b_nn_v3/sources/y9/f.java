package y9;

import java.util.ArrayList;
import java.util.Iterator;

public final class f extends g implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f13422a = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof f) && ((f) obj).f13422a.equals(this.f13422a))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f13422a.hashCode();
    }

    public Iterator iterator() {
        return this.f13422a.iterator();
    }

    public void j(g gVar) {
        if (gVar == null) {
            gVar = i.f13423a;
        }
        this.f13422a.add(gVar);
    }
}

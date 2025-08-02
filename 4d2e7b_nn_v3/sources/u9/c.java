package u9;

import java.util.Collections;
import java.util.Set;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Set f13161a = Collections.emptySet();

    public Set a() {
        return Collections.unmodifiableSet(this.f13161a);
    }

    public Set b() {
        return Collections.singleton("b64");
    }

    public boolean c(s9.c cVar) {
        if (cVar.b() == null) {
            return true;
        }
        for (String str : cVar.b()) {
            if (!b().contains(str) && !a().contains(str)) {
                return false;
            }
        }
        return true;
    }

    public void d(Set set) {
        if (set == null) {
            this.f13161a = Collections.emptySet();
        } else {
            this.f13161a = set;
        }
    }
}

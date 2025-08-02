package u9;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import s9.h;

public abstract class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final Set f13162c;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(h.f13016g);
        linkedHashSet.add(h.f13017h);
        linkedHashSet.add(h.f13018i);
        linkedHashSet.add(h.Y);
        linkedHashSet.add(h.Z);
        linkedHashSet.add(h.N0);
        f13162c = Collections.unmodifiableSet(linkedHashSet);
    }

    protected e() {
        super(f13162c);
    }
}

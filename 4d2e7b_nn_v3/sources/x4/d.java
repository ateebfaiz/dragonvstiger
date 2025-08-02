package x4;

import java.util.LinkedHashSet;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f24771a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashSet f24772b;

    public d(int i10) {
        this.f24771a = i10;
        this.f24772b = new LinkedHashSet(i10);
    }

    public final synchronized boolean a(Object obj) {
        try {
            if (this.f24772b.size() == this.f24771a) {
                LinkedHashSet linkedHashSet = this.f24772b;
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            this.f24772b.remove(obj);
        } catch (Throwable th) {
            throw th;
        }
        return this.f24772b.add(obj);
    }

    public final synchronized boolean b(Object obj) {
        return this.f24772b.contains(obj);
    }
}

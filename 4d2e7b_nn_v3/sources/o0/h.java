package o0;

import java.util.ArrayList;
import java.util.List;
import t0.i;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final List f22907a;

    /* renamed from: b  reason: collision with root package name */
    private final List f22908b;

    /* renamed from: c  reason: collision with root package name */
    private final List f22909c;

    public h(List list) {
        this.f22909c = list;
        this.f22907a = new ArrayList(list.size());
        this.f22908b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f22907a.add(((i) list.get(i10)).b().a());
            this.f22908b.add(((i) list.get(i10)).c().a());
        }
    }

    public List a() {
        return this.f22907a;
    }

    public List b() {
        return this.f22909c;
    }

    public List c() {
        return this.f22908b;
    }
}

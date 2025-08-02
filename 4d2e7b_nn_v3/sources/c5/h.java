package c5;

import e5.n;
import e5.o;
import java.util.Collections;
import java.util.List;
import y2.l;

public class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f17330a;

    private static class a implements b {
        private a() {
        }

        public List a() {
            return Collections.EMPTY_LIST;
        }

        public int b() {
            return 0;
        }
    }

    public interface b {
        List a();

        int b();
    }

    public h() {
        this(new a());
    }

    public o a(int i10) {
        boolean z10;
        if (i10 >= this.f17330a.b()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return n.d(i10, z10, false);
    }

    public int b(int i10) {
        List a10 = this.f17330a.a();
        if (a10 == null || a10.isEmpty()) {
            return i10 + 1;
        }
        for (int i11 = 0; i11 < a10.size(); i11++) {
            if (((Integer) a10.get(i11)).intValue() > i10) {
                return ((Integer) a10.get(i11)).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean c() {
        return true;
    }

    public h(b bVar) {
        this.f17330a = (b) l.g(bVar);
    }
}

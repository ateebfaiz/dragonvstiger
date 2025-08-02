package n0;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import t0.j;

public class l implements m, j {

    /* renamed from: a  reason: collision with root package name */
    private final Path f22741a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f22742b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f22743c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final String f22744d;

    /* renamed from: e  reason: collision with root package name */
    private final List f22745e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final j f22746f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22747a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                t0.j$a[] r0 = t0.j.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22747a = r0
                t0.j$a r1 = t0.j.a.MERGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22747a     // Catch:{ NoSuchFieldError -> 0x001d }
                t0.j$a r1 = t0.j.a.ADD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22747a     // Catch:{ NoSuchFieldError -> 0x0028 }
                t0.j$a r1 = t0.j.a.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22747a     // Catch:{ NoSuchFieldError -> 0x0033 }
                t0.j$a r1 = t0.j.a.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22747a     // Catch:{ NoSuchFieldError -> 0x003e }
                t0.j$a r1 = t0.j.a.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n0.l.a.<clinit>():void");
        }
    }

    public l(j jVar) {
        this.f22744d = jVar.c();
        this.f22746f = jVar;
    }

    private void a() {
        for (int i10 = 0; i10 < this.f22745e.size(); i10++) {
            this.f22743c.addPath(((m) this.f22745e.get(i10)).getPath());
        }
    }

    private void c(Path.Op op) {
        this.f22742b.reset();
        this.f22741a.reset();
        for (int size = this.f22745e.size() - 1; size >= 1; size--) {
            m mVar = (m) this.f22745e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List k10 = dVar.k();
                for (int size2 = k10.size() - 1; size2 >= 0; size2--) {
                    Path path = ((m) k10.get(size2)).getPath();
                    path.transform(dVar.l());
                    this.f22742b.addPath(path);
                }
            } else {
                this.f22742b.addPath(mVar.getPath());
            }
        }
        m mVar2 = (m) this.f22745e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List k11 = dVar2.k();
            for (int i10 = 0; i10 < k11.size(); i10++) {
                Path path2 = ((m) k11.get(i10)).getPath();
                path2.transform(dVar2.l());
                this.f22741a.addPath(path2);
            }
        } else {
            this.f22741a.set(mVar2.getPath());
        }
        this.f22743c.op(this.f22741a, this.f22742b, op);
    }

    public void b(List list, List list2) {
        for (int i10 = 0; i10 < this.f22745e.size(); i10++) {
            ((m) this.f22745e.get(i10)).b(list, list2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.ListIterator r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            n0.c r0 = (n0.c) r0
            boolean r1 = r0 instanceof n0.m
            if (r1 == 0) goto L_0x000d
            java.util.List r1 = r2.f22745e
            n0.m r0 = (n0.m) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.l.f(java.util.ListIterator):void");
    }

    public Path getPath() {
        this.f22743c.reset();
        if (this.f22746f.d()) {
            return this.f22743c;
        }
        int i10 = a.f22747a[this.f22746f.b().ordinal()];
        if (i10 == 1) {
            a();
        } else if (i10 == 2) {
            c(Path.Op.UNION);
        } else if (i10 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i10 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i10 == 5) {
            c(Path.Op.XOR);
        }
        return this.f22743c;
    }
}

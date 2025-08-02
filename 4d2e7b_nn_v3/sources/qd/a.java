package qd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import qd.f;
import qd.h;
import qd.i;

public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private transient j f1857a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1858b;

    /* renamed from: c  reason: collision with root package name */
    private final List f1859c;

    /* renamed from: d  reason: collision with root package name */
    private int f1860d;

    /* renamed from: e  reason: collision with root package name */
    private r f1861e;

    /* renamed from: f  reason: collision with root package name */
    private List f1862f;

    /* renamed from: g  reason: collision with root package name */
    private Map f1863g;

    /* renamed from: h  reason: collision with root package name */
    private Stack f1864h;

    /* renamed from: i  reason: collision with root package name */
    private Map f1865i;

    /* renamed from: j  reason: collision with root package name */
    private int f1866j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1867w;

    a(u uVar, int i10) {
        this(uVar.f(), uVar.d(), uVar.e());
        this.f1866j = i10;
        this.f1867w = true;
    }

    private c a() {
        c cVar = null;
        for (c cVar2 : this.f1859c) {
            if (!cVar2.e() && cVar2.f()) {
                if (cVar == null || cVar2.a() < cVar.a() || (cVar2.a() == cVar.a() && cVar2.b() < cVar.b())) {
                    cVar = cVar2;
                }
            }
        }
        return cVar;
    }

    private void d(byte[] bArr, byte[] bArr2, i iVar) {
        if (iVar != null) {
            h hVar = (h) ((h.b) ((h.b) new h.b().g(iVar.b())).h(iVar.c())).l();
            f fVar = (f) ((f.b) ((f.b) new f.b().g(iVar.b())).h(iVar.c())).k();
            for (int i10 = 0; i10 < (1 << this.f1858b); i10++) {
                iVar = (i) ((i.b) ((i.b) ((i.b) new i.b().g(iVar.b())).h(iVar.c())).p(i10).n(iVar.e()).o(iVar.f()).f(iVar.a())).l();
                j jVar = this.f1857a;
                jVar.h(jVar.g(bArr2, iVar), bArr);
                m e10 = this.f1857a.e(iVar);
                hVar = (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar.b())).h(hVar.c())).n(i10).o(hVar.f()).p(hVar.g()).f(hVar.a())).l();
                r a10 = s.a(this.f1857a, e10, hVar);
                fVar = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar.b())).h(fVar.c())).n(i10).f(fVar.a())).k();
                while (!this.f1864h.isEmpty() && ((r) this.f1864h.peek()).b() == a10.b()) {
                    int floor = (int) Math.floor((double) (i10 / (1 << a10.b())));
                    if (floor == 1) {
                        this.f1862f.add(a10.clone());
                    }
                    if (floor == 3 && a10.b() < this.f1858b - this.f1860d) {
                        ((c) this.f1859c.get(a10.b())).h(a10.clone());
                    }
                    if (floor >= 3 && (floor & 1) == 1 && a10.b() >= this.f1858b - this.f1860d && a10.b() <= this.f1858b - 2) {
                        if (this.f1863g.get(Integer.valueOf(a10.b())) == null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(a10.clone());
                            this.f1863g.put(Integer.valueOf(a10.b()), linkedList);
                        } else {
                            ((LinkedList) this.f1863g.get(Integer.valueOf(a10.b()))).add(a10.clone());
                        }
                    }
                    f fVar2 = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar.b())).h(fVar.c())).m(fVar.e()).n((fVar.f() - 1) / 2).f(fVar.a())).k();
                    r b10 = s.b(this.f1857a, (r) this.f1864h.pop(), a10, fVar2);
                    r rVar = new r(b10.b() + 1, b10.c());
                    fVar = (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar2.b())).h(fVar2.c())).m(fVar2.e() + 1).n(fVar2.f()).f(fVar2.a())).k();
                    a10 = rVar;
                }
                this.f1864h.push(a10);
            }
            this.f1861e = (r) this.f1864h.pop();
            return;
        }
        throw new NullPointerException("otsHashAddress == null");
    }

    private void e(byte[] bArr, byte[] bArr2, i iVar) {
        if (iVar == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (this.f1867w) {
            throw new IllegalStateException("index already used");
        } else if (this.f1866j <= (1 << this.f1858b) - 2) {
            h hVar = (h) ((h.b) ((h.b) new h.b().g(iVar.b())).h(iVar.c())).l();
            f fVar = (f) ((f.b) ((f.b) new f.b().g(iVar.b())).h(iVar.c())).k();
            int b10 = x.b(this.f1866j, this.f1858b);
            if (((this.f1866j >> (b10 + 1)) & 1) == 0 && b10 < this.f1858b - 1) {
                this.f1865i.put(Integer.valueOf(b10), ((r) this.f1862f.get(b10)).clone());
            }
            if (b10 == 0) {
                iVar = (i) ((i.b) ((i.b) ((i.b) new i.b().g(iVar.b())).h(iVar.c())).p(this.f1866j).n(iVar.e()).o(iVar.f()).f(iVar.a())).l();
                j jVar = this.f1857a;
                jVar.h(jVar.g(bArr2, iVar), bArr);
                this.f1862f.set(0, s.a(this.f1857a, this.f1857a.e(iVar), (h) ((h.b) ((h.b) ((h.b) new h.b().g(hVar.b())).h(hVar.c())).n(this.f1866j).o(hVar.f()).p(hVar.g()).f(hVar.a())).l()));
            } else {
                int i10 = b10 - 1;
                r b11 = s.b(this.f1857a, (r) this.f1862f.get(i10), (r) this.f1865i.get(Integer.valueOf(i10)), (f) ((f.b) ((f.b) ((f.b) new f.b().g(fVar.b())).h(fVar.c())).m(i10).n(this.f1866j >> b10).f(fVar.a())).k());
                this.f1862f.set(b10, new r(b11.b() + 1, b11.c()));
                this.f1865i.remove(Integer.valueOf(i10));
                for (int i11 = 0; i11 < b10; i11++) {
                    if (i11 < this.f1858b - this.f1860d) {
                        this.f1862f.set(i11, ((c) this.f1859c.get(i11)).c());
                    } else {
                        this.f1862f.set(i11, ((LinkedList) this.f1863g.get(Integer.valueOf(i11))).removeFirst());
                    }
                }
                int min = Math.min(b10, this.f1858b - this.f1860d);
                for (int i12 = 0; i12 < min; i12++) {
                    int i13 = this.f1866j + 1 + ((1 << i12) * 3);
                    if (i13 < (1 << this.f1858b)) {
                        ((c) this.f1859c.get(i12)).d(i13);
                    }
                }
            }
            for (int i14 = 0; i14 < ((this.f1858b - this.f1860d) >> 1); i14++) {
                c a10 = a();
                if (a10 != null) {
                    a10.i(this.f1864h, this.f1857a, bArr, bArr2, iVar);
                }
            }
            this.f1866j++;
        } else {
            throw new IllegalStateException("index out of bounds");
        }
    }

    /* access modifiers changed from: protected */
    public int b() {
        return this.f1866j;
    }

    public a c(byte[] bArr, byte[] bArr2, i iVar) {
        return new a(this, bArr, bArr2, iVar);
    }

    /* access modifiers changed from: protected */
    public void f(u uVar) {
        if (this.f1858b == uVar.d()) {
            this.f1857a = uVar.f();
            return;
        }
        throw new IllegalStateException("wrong height");
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (this.f1862f == null) {
            throw new IllegalStateException("authenticationPath == null");
        } else if (this.f1863g == null) {
            throw new IllegalStateException("retain == null");
        } else if (this.f1864h == null) {
            throw new IllegalStateException("stack == null");
        } else if (this.f1859c == null) {
            throw new IllegalStateException("treeHashInstances == null");
        } else if (this.f1865i == null) {
            throw new IllegalStateException("keep == null");
        } else if (!x.l(this.f1858b, (long) this.f1866j)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    a(u uVar, byte[] bArr, byte[] bArr2, i iVar) {
        this(uVar.f(), uVar.d(), uVar.e());
        d(bArr, bArr2, iVar);
    }

    a(u uVar, byte[] bArr, byte[] bArr2, i iVar, int i10) {
        this(uVar.f(), uVar.d(), uVar.e());
        d(bArr, bArr2, iVar);
        while (this.f1866j < i10) {
            e(bArr, bArr2, iVar);
            this.f1867w = false;
        }
    }

    private a(j jVar, int i10, int i11) {
        this.f1857a = jVar;
        this.f1858b = i10;
        this.f1860d = i11;
        if (i11 <= i10 && i11 >= 2) {
            int i12 = i10 - i11;
            if (i12 % 2 == 0) {
                this.f1862f = new ArrayList();
                this.f1863g = new TreeMap();
                this.f1864h = new Stack();
                this.f1859c = new ArrayList();
                for (int i13 = 0; i13 < i12; i13++) {
                    this.f1859c.add(new c(i13));
                }
                this.f1865i = new TreeMap();
                this.f1866j = 0;
                this.f1867w = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    private a(a aVar, byte[] bArr, byte[] bArr2, i iVar) {
        this.f1857a = aVar.f1857a;
        this.f1858b = aVar.f1858b;
        this.f1860d = aVar.f1860d;
        this.f1861e = aVar.f1861e;
        this.f1862f = new ArrayList(aVar.f1862f);
        this.f1863g = aVar.f1863g;
        this.f1864h = (Stack) aVar.f1864h.clone();
        this.f1859c = aVar.f1859c;
        this.f1865i = new TreeMap(aVar.f1865i);
        this.f1866j = aVar.f1866j;
        e(bArr, bArr2, iVar);
        aVar.f1867w = true;
    }
}

package i3;

public abstract class b implements e {
    public void a(c cVar) {
    }

    public void b(c cVar) {
        try {
            e(cVar);
        } finally {
            cVar.close();
        }
    }

    public void c(c cVar) {
    }

    public void d(c cVar) {
        boolean b10 = cVar.b();
        try {
            f(cVar);
        } finally {
            if (b10) {
                cVar.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void e(c cVar);

    /* access modifiers changed from: protected */
    public abstract void f(c cVar);
}

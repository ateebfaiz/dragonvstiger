package a5;

import c3.a;
import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.e1;
import com.facebook.imagepipeline.producers.l1;
import g5.d;
import l5.b;

public class c extends a {
    private c(d1 d1Var, l1 l1Var, d dVar) {
        super(d1Var, l1Var, dVar);
    }

    public static i3.c F(d1 d1Var, l1 l1Var, d dVar) {
        if (b.d()) {
            b.a("CloseableProducerToDataSourceAdapter#create");
        }
        c cVar = new c(d1Var, l1Var, dVar);
        if (b.d()) {
            b.b();
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public void f(a aVar) {
        a.m(aVar);
    }

    /* renamed from: G */
    public a getResult() {
        return a.j((a) super.getResult());
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public void D(a aVar, int i10, e1 e1Var) {
        super.D(a.j(aVar), i10, e1Var);
    }
}

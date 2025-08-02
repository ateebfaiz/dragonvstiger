package z4;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import s2.g;
import s2.i;
import s2.j;
import s2.n;

public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    private d f25020a;

    public c(d dVar) {
        this.f25020a = dVar;
    }

    public static j b(g gVar, i iVar) {
        return c(gVar, iVar, Executors.newSingleThreadExecutor());
    }

    public static j c(g gVar, i iVar, Executor executor) {
        return new j(iVar, gVar.h(), new j.c(gVar.k(), gVar.j(), gVar.f()), gVar.e(), gVar.d(), gVar.g(), executor, gVar.i());
    }

    public n a(g gVar) {
        return b(gVar, this.f25020a.a(gVar));
    }
}

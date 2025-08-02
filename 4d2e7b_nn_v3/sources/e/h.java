package e;

public class h implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f21058a;

    public h(i iVar) {
        this.f21058a = iVar;
    }

    public void a(k kVar, int i10, String str) {
        this.f21058a.f21071l.post(new f(this, kVar, i10));
    }

    public void b(k kVar, j jVar) {
        this.f21058a.w();
        this.f21058a.f21071l.post(new g(this, kVar, jVar));
    }

    public void c(k kVar, j jVar) {
        this.f21058a.w();
        this.f21058a.f21071l.post(new e(this, kVar, jVar));
    }

    public final /* synthetic */ void d(k kVar, int i10) {
        this.f21058a.h(kVar, i10);
    }

    public final /* synthetic */ void e(k kVar, j jVar) {
        boolean unused = this.f21058a.f21068i = true;
        this.f21058a.f21061b.i();
        this.f21058a.f21060a.v(kVar.f21093a, jVar.h(), 2);
    }

    public final /* synthetic */ void f(k kVar, j jVar) {
        boolean unused = this.f21058a.f21068i = true;
        this.f21058a.f21061b.h();
        this.f21058a.f21060a.j(kVar.f21093a, jVar.e(), jVar.f21082d);
    }
}

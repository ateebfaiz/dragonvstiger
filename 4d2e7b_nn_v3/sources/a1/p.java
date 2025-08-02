package a1;

import a1.b;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final Object f13650a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f13651b;

    /* renamed from: c  reason: collision with root package name */
    public final u f13652c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13653d;

    public interface a {
        void a(u uVar);
    }

    public interface b {
        void a(Object obj);
    }

    private p(Object obj, b.a aVar) {
        this.f13653d = false;
        this.f13650a = obj;
        this.f13651b = aVar;
        this.f13652c = null;
    }

    public static p a(u uVar) {
        return new p(uVar);
    }

    public static p c(Object obj, b.a aVar) {
        return new p(obj, aVar);
    }

    public boolean b() {
        if (this.f13652c == null) {
            return true;
        }
        return false;
    }

    private p(u uVar) {
        this.f13653d = false;
        this.f13650a = null;
        this.f13651b = null;
        this.f13652c = uVar;
    }
}

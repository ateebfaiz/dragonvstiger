package o0;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final List f22878a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f22879b = false;

    /* renamed from: c  reason: collision with root package name */
    private final d f22880c;

    /* renamed from: d  reason: collision with root package name */
    protected float f22881d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected z0.c f22882e;

    /* renamed from: f  reason: collision with root package name */
    private Object f22883f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f22884g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f22885h = -1.0f;

    public interface b {
        void a();
    }

    private static final class c implements d {
        private c() {
        }

        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        public z0.a b() {
            throw new IllegalStateException("not implemented");
        }

        public boolean c(float f10) {
            return false;
        }

        public float d() {
            return 1.0f;
        }

        public float e() {
            return 0.0f;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    private interface d {
        boolean a(float f10);

        z0.a b();

        boolean c(float f10);

        float d();

        float e();

        boolean isEmpty();
    }

    private static final class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final List f22886a;

        /* renamed from: b  reason: collision with root package name */
        private z0.a f22887b;

        /* renamed from: c  reason: collision with root package name */
        private z0.a f22888c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f22889d = -1.0f;

        e(List list) {
            this.f22886a = list;
            this.f22887b = f(0.0f);
        }

        private z0.a f(float f10) {
            List list = this.f22886a;
            z0.a aVar = (z0.a) list.get(list.size() - 1);
            if (f10 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f22886a.size() - 2; size >= 1; size--) {
                z0.a aVar2 = (z0.a) this.f22886a.get(size);
                if (this.f22887b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return (z0.a) this.f22886a.get(0);
        }

        public boolean a(float f10) {
            z0.a aVar = this.f22888c;
            z0.a aVar2 = this.f22887b;
            if (aVar == aVar2 && this.f22889d == f10) {
                return true;
            }
            this.f22888c = aVar2;
            this.f22889d = f10;
            return false;
        }

        public z0.a b() {
            return this.f22887b;
        }

        public boolean c(float f10) {
            if (this.f22887b.a(f10)) {
                return !this.f22887b.i();
            }
            this.f22887b = f(f10);
            return true;
        }

        public float d() {
            List list = this.f22886a;
            return ((z0.a) list.get(list.size() - 1)).c();
        }

        public float e() {
            return ((z0.a) this.f22886a.get(0)).f();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private static final class f implements d {

        /* renamed from: a  reason: collision with root package name */
        private final z0.a f22890a;

        /* renamed from: b  reason: collision with root package name */
        private float f22891b = -1.0f;

        f(List list) {
            this.f22890a = (z0.a) list.get(0);
        }

        public boolean a(float f10) {
            if (this.f22891b == f10) {
                return true;
            }
            this.f22891b = f10;
            return false;
        }

        public z0.a b() {
            return this.f22890a;
        }

        public boolean c(float f10) {
            return !this.f22890a.i();
        }

        public float d() {
            return this.f22890a.c();
        }

        public float e() {
            return this.f22890a.f();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    a(List list) {
        this.f22880c = p(list);
    }

    private float g() {
        if (this.f22884g == -1.0f) {
            this.f22884g = this.f22880c.e();
        }
        return this.f22884g;
    }

    private static d p(List list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f22878a.add(bVar);
    }

    /* access modifiers changed from: protected */
    public z0.a b() {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        z0.a b10 = this.f22880c.b();
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return b10;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        if (this.f22885h == -1.0f) {
            this.f22885h = this.f22880c.d();
        }
        return this.f22885h;
    }

    /* access modifiers changed from: protected */
    public float d() {
        Interpolator interpolator;
        z0.a b10 = b();
        if (b10 == null || b10.i() || (interpolator = b10.f24972d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.f22879b) {
            return 0.0f;
        }
        z0.a b10 = b();
        if (b10.i()) {
            return 0.0f;
        }
        return (this.f22881d - b10.f()) / (b10.c() - b10.f());
    }

    public float f() {
        return this.f22881d;
    }

    public Object h() {
        Object obj;
        float e10 = e();
        if (this.f22882e == null && this.f22880c.a(e10)) {
            return this.f22883f;
        }
        z0.a b10 = b();
        Interpolator interpolator = b10.f24973e;
        if (interpolator == null || b10.f24974f == null) {
            obj = i(b10, d());
        } else {
            obj = j(b10, e10, interpolator.getInterpolation(e10), b10.f24974f.getInterpolation(e10));
        }
        this.f22883f = obj;
        return obj;
    }

    /* access modifiers changed from: package-private */
    public abstract Object i(z0.a aVar, float f10);

    /* access modifiers changed from: protected */
    public Object j(z0.a aVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        if (this.f22882e != null) {
            return true;
        }
        return false;
    }

    public void l() {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i10 = 0; i10 < this.f22878a.size(); i10++) {
            ((b) this.f22878a.get(i10)).a();
        }
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.f22879b = true;
    }

    public void n(float f10) {
        if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.b("BaseKeyframeAnimation#setProgress");
        }
        if (!this.f22880c.isEmpty()) {
            if (f10 < g()) {
                f10 = g();
            } else if (f10 > c()) {
                f10 = c();
            }
            if (f10 != this.f22881d) {
                this.f22881d = f10;
                if (this.f22880c.c(f10)) {
                    l();
                }
                if (com.airbnb.lottie.e.h()) {
                    com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
                }
            } else if (com.airbnb.lottie.e.h()) {
                com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
            }
        } else if (com.airbnb.lottie.e.h()) {
            com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
        }
    }

    public void o(z0.c cVar) {
        z0.c cVar2 = this.f22882e;
        if (cVar2 != null) {
            cVar2.c((a) null);
        }
        this.f22882e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}

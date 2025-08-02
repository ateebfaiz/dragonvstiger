package t3;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final List f24128a = new ArrayList(2);

    private synchronized void d(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    public void a(String str, Object obj) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.a(str, obj);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onIntermediateImageSet", e10);
            }
        }
    }

    public synchronized void b(d dVar) {
        this.f24128a.add(dVar);
    }

    public synchronized void c() {
        this.f24128a.clear();
    }

    public synchronized void f(String str, Object obj, Animatable animatable) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.f(str, obj, animatable);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onFinalImageSet", e10);
            }
        }
    }

    public synchronized void i(String str, Throwable th) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.i(str, th);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onFailure", e10);
            }
        }
    }

    public synchronized void k(String str) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.k(str);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onRelease", e10);
            }
        }
    }

    public synchronized void o(String str, Object obj) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.o(str, obj);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onSubmit", e10);
            }
        }
    }

    public void p(String str, Throwable th) {
        int size = this.f24128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                d dVar = (d) this.f24128a.get(i10);
                if (dVar != null) {
                    dVar.p(str, th);
                }
            } catch (Exception e10) {
                d("InternalListener exception in onIntermediateImageFailed", e10);
            }
        }
    }
}

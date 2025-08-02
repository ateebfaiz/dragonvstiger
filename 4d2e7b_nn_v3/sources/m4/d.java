package m4;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import m4.b;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f22548c = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final List f22549b = new ArrayList(2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void a(String str, Object obj) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).a(str, obj);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onIntermediateImageSet", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public void h(String str, Object obj, b.a aVar) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).h(str, obj, aVar);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onFinalImageSet", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public void j(String str, Throwable th, b.a aVar) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).j(str, th, aVar);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onFailure", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public void k(String str, b.a aVar) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).k(str, aVar);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onRelease", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public void m(String str) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).m(str);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onIntermediateImageFailed", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public void n(String str, Object obj, b.a aVar) {
        m.f(str, "id");
        int size = this.f22549b.size();
        int i10 = 0;
        while (i10 < size) {
            try {
                try {
                    ((b) this.f22549b.get(i10)).n(str, obj, aVar);
                } catch (Exception e10) {
                    Log.e("FwdControllerListener2", "InternalListener exception in " + "onSubmit", e10);
                }
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public final synchronized void p(b bVar) {
        m.f(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f22549b.add(bVar);
    }

    public final synchronized void v(b bVar) {
        m.f(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f22549b.remove(bVar);
    }
}

package d4;

import android.graphics.Bitmap;
import c4.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21042c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private int f21043a = -1;

    /* renamed from: b  reason: collision with root package name */
    private c3.a f21044b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final synchronized void a() {
        c3.a.m(this.f21044b);
        this.f21044b = null;
        this.f21043a = -1;
    }

    public synchronized boolean b(int i10) {
        boolean z10;
        if (i10 != this.f21043a || !c3.a.y(this.f21044b)) {
            z10 = false;
        } else {
            z10 = true;
        }
        return z10;
    }

    public synchronized c3.a c(int i10, int i11, int i12) {
        c3.a j10;
        try {
            j10 = c3.a.j(this.f21044b);
            a();
        } catch (Throwable th) {
            a();
            throw th;
        }
        return j10;
    }

    public synchronized void clear() {
        a();
    }

    public synchronized c3.a d(int i10) {
        c3.a aVar;
        if (this.f21043a == i10) {
            aVar = c3.a.j(this.f21044b);
        } else {
            aVar = null;
        }
        return aVar;
    }

    public synchronized void e(int i10, c3.a aVar, int i11) {
        Bitmap bitmap;
        try {
            m.f(aVar, "bitmapReference");
            if (this.f21044b != null) {
                Object p10 = aVar.p();
                c3.a aVar2 = this.f21044b;
                if (aVar2 != null) {
                    bitmap = (Bitmap) aVar2.p();
                } else {
                    bitmap = null;
                }
                if (m.b(p10, bitmap)) {
                    return;
                }
            }
            c3.a.m(this.f21044b);
            this.f21044b = c3.a.j(aVar);
            this.f21043a = i10;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized c3.a f(int i10) {
        return c3.a.j(this.f21044b);
    }

    public void g(int i10, c3.a aVar, int i11) {
        m.f(aVar, "bitmapReference");
    }
}

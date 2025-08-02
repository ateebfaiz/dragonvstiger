package h4;

import android.graphics.Bitmap;
import android.graphics.Rect;
import c4.c;
import t4.d;

public class b implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final Class f21899f = b.class;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c4.b f21900a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21901b;

    /* renamed from: c  reason: collision with root package name */
    private r4.a f21902c;

    /* renamed from: d  reason: collision with root package name */
    private d f21903d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f21904e;

    class a implements d.b {
        a() {
        }

        public void a(int i10, Bitmap bitmap) {
        }

        public c3.a b(int i10) {
            return b.this.f21900a.d(i10);
        }
    }

    public b(c4.b bVar, r4.a aVar, boolean z10) {
        a aVar2 = new a();
        this.f21904e = aVar2;
        this.f21900a = bVar;
        this.f21902c = aVar;
        this.f21901b = z10;
        this.f21903d = new d(aVar, z10, aVar2);
    }

    public int a() {
        return this.f21902c.getHeight();
    }

    public void b(Rect rect) {
        r4.a e10 = this.f21902c.e(rect);
        if (e10 != this.f21902c) {
            this.f21902c = e10;
            this.f21903d = new d(e10, this.f21901b, this.f21904e);
        }
    }

    public int c() {
        return this.f21902c.getWidth();
    }

    public boolean d(int i10, Bitmap bitmap) {
        try {
            this.f21903d.h(i10, bitmap);
            return true;
        } catch (IllegalStateException e10) {
            z2.a.i(f21899f, e10, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i10));
            return false;
        }
    }
}

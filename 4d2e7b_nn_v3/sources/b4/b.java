package b4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b4.a;

public abstract class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private a f17173a;

    /* renamed from: b  reason: collision with root package name */
    private int f17174b = -1;

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f17175c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f17176d;

    public b(a aVar) {
        this.f17173a = aVar;
    }

    public int a() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return -1;
        }
        return aVar.a();
    }

    public void b(Rect rect) {
        a aVar = this.f17173a;
        if (aVar != null) {
            aVar.b(rect);
        }
        this.f17176d = rect;
    }

    public int c() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return -1;
        }
        return aVar.c();
    }

    public void clear() {
        a aVar = this.f17173a;
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void e(ColorFilter colorFilter) {
        a aVar = this.f17173a;
        if (aVar != null) {
            aVar.e(colorFilter);
        }
        this.f17175c = colorFilter;
    }

    public int f() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.f();
    }

    public int g() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.g();
    }

    public int getFrameCount() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.getFrameCount();
    }

    public int getLoopCount() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.getLoopCount();
    }

    public void h(a.C0221a aVar) {
        a aVar2 = this.f17173a;
        if (aVar2 != null) {
            aVar2.h(aVar);
        }
    }

    public int i(int i10) {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.i(i10);
    }

    public void j(int i10) {
        a aVar = this.f17173a;
        if (aVar != null) {
            aVar.j(i10);
        }
        this.f17174b = i10;
    }

    public int k() {
        a aVar = this.f17173a;
        if (aVar == null) {
            return 0;
        }
        return aVar.k();
    }

    public boolean l(Drawable drawable, Canvas canvas, int i10) {
        a aVar = this.f17173a;
        if (aVar == null || !aVar.l(drawable, canvas, i10)) {
            return false;
        }
        return true;
    }
}

package w3;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class p {

    public static abstract class a implements b {
        public Matrix a(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11) {
            int i12 = i10;
            int i13 = i11;
            b(matrix, rect, i12, i13, f10, f11, ((float) rect.width()) / ((float) i12), ((float) rect.height()) / ((float) i13));
            return matrix;
        }

        public abstract void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13);
    }

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24582a = k.f24601l;

        /* renamed from: b  reason: collision with root package name */
        public static final b f24583b = j.f24600l;

        /* renamed from: c  reason: collision with root package name */
        public static final b f24584c = l.f24602l;

        /* renamed from: d  reason: collision with root package name */
        public static final b f24585d = i.f24599l;

        /* renamed from: e  reason: collision with root package name */
        public static final b f24586e = g.f24597l;

        /* renamed from: f  reason: collision with root package name */
        public static final b f24587f = h.f24598l;

        /* renamed from: g  reason: collision with root package name */
        public static final b f24588g = c.f24593l;

        /* renamed from: h  reason: collision with root package name */
        public static final b f24589h = e.f24595l;

        /* renamed from: i  reason: collision with root package name */
        public static final b f24590i = d.f24594l;

        /* renamed from: j  reason: collision with root package name */
        public static final b f24591j = m.f24603l;

        /* renamed from: k  reason: collision with root package name */
        public static final b f24592k = f.f24596l;

        Matrix a(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11);
    }

    private static class c extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24593l = new c();

        private c() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            matrix.setTranslate((float) ((int) (((float) rect.left) + (((float) (rect.width() - i10)) * 0.5f) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) (rect.height() - i11)) * 0.5f) + 0.5f)));
        }

        public String toString() {
            return "center";
        }
    }

    private static class d extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24594l = new d();

        private d() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float f14;
            float f15;
            if (f13 > f12) {
                f14 = ((float) rect.left) + ((((float) rect.width()) - (((float) i10) * f13)) * 0.5f);
                f15 = (float) rect.top;
                f12 = f13;
            } else {
                f15 = ((((float) rect.height()) - (((float) i11) * f12)) * 0.5f) + ((float) rect.top);
                f14 = (float) rect.left;
            }
            matrix.setScale(f12, f12);
            matrix.postTranslate((float) ((int) (f14 + 0.5f)), (float) ((int) (f15 + 0.5f)));
        }

        public String toString() {
            return "center_crop";
        }
    }

    private static class e extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24595l = new e();

        private e() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float min = Math.min(Math.min(f12, f13), 1.0f);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i10) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i11) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "center_inside";
        }
    }

    private static class f extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24596l = new f();

        private f() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float min = Math.min(f12, f13);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i11) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    private static class g extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24597l = new g();

        private g() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float min = Math.min(f12, f13);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i10) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i11) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "fit_center";
        }
    }

    private static class h extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24598l = new h();

        private h() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float min = Math.min(f12, f13);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + (((float) rect.width()) - (((float) i10) * min)) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i11) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_end";
        }
    }

    private static class i extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24599l = new i();

        private i() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float min = Math.min(f12, f13);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_start";
        }
    }

    private static class j extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24600l = new j();

        private j() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i11) * f12)) * 0.5f);
            matrix.setScale(f12, f12);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "fit_x";
        }
    }

    private static class k extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24601l = new k();

        private k() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            matrix.setScale(f12, f13);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    private static class l extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24602l = new l();

        private l() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            matrix.setScale(f13, f13);
            matrix.postTranslate((float) ((int) (((float) rect.left) + ((((float) rect.width()) - (((float) i10) * f13)) * 0.5f) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_y";
        }
    }

    private static class m extends a {

        /* renamed from: l  reason: collision with root package name */
        public static final b f24603l = new m();

        private m() {
        }

        public void b(Matrix matrix, Rect rect, int i10, int i11, float f10, float f11, float f12, float f13) {
            float f14;
            float f15;
            if (f13 > f12) {
                float f16 = ((float) i10) * f13;
                f14 = ((float) rect.left) + Math.max(Math.min((((float) rect.width()) * 0.5f) - (f10 * f16), 0.0f), ((float) rect.width()) - f16);
                f15 = (float) rect.top;
                f12 = f13;
            } else {
                f14 = (float) rect.left;
                float f17 = ((float) i11) * f12;
                f15 = Math.max(Math.min((((float) rect.height()) * 0.5f) - (f11 * f17), 0.0f), ((float) rect.height()) - f17) + ((float) rect.top);
            }
            matrix.setScale(f12, f12);
            matrix.postTranslate((float) ((int) (f14 + 0.5f)), (float) ((int) (f15 + 0.5f)));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    public static o a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof o) {
            return (o) drawable;
        }
        if (drawable instanceof c) {
            return a(((c) drawable).r());
        }
        if (drawable instanceof a) {
            a aVar = (a) drawable;
            int e10 = aVar.e();
            for (int i10 = 0; i10 < e10; i10++) {
                o a10 = a(aVar.b(i10));
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }
}

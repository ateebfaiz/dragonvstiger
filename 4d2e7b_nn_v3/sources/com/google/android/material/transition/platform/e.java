package com.google.android.material.transition.platform;

import android.graphics.RectF;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final d f8929a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final d f8930b = new b();

    class a implements d {
        a() {
        }

        public f a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float m10 = j.m(f13, f15, f11, f12, f10, true);
            float f17 = m10 / f13;
            float f18 = m10 / f15;
            return new f(f17, f18, m10, f14 * f17, m10, f16 * f18);
        }

        public boolean b(f fVar) {
            if (fVar.f8934d > fVar.f8936f) {
                return true;
            }
            return false;
        }

        public void c(RectF rectF, float f10, f fVar) {
            rectF.bottom -= Math.abs(fVar.f8936f - fVar.f8934d) * f10;
        }
    }

    class b implements d {
        b() {
        }

        public f a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float m10 = j.m(f14, f16, f11, f12, f10, true);
            float f17 = m10 / f14;
            float f18 = m10 / f16;
            return new f(f17, f18, f13 * f17, m10, f15 * f18, m10);
        }

        public boolean b(f fVar) {
            if (fVar.f8933c > fVar.f8935e) {
                return true;
            }
            return false;
        }

        public void c(RectF rectF, float f10, f fVar) {
            float abs = (Math.abs(fVar.f8935e - fVar.f8933c) / 2.0f) * f10;
            rectF.left += abs;
            rectF.right -= abs;
        }
    }

    static d a(int i10, boolean z10, RectF rectF, RectF rectF2) {
        if (i10 != 0) {
            if (i10 == 1) {
                return f8929a;
            }
            if (i10 == 2) {
                return f8930b;
            }
            throw new IllegalArgumentException("Invalid fit mode: " + i10);
        } else if (b(z10, rectF, rectF2)) {
            return f8929a;
        } else {
            return f8930b;
        }
    }

    private static boolean b(boolean z10, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f10 = (height2 * width) / width2;
        float f11 = (width2 * height) / width;
        if (z10) {
            if (f10 < height) {
                return false;
            }
        } else if (f11 < height2) {
            return false;
        }
        return true;
    }
}

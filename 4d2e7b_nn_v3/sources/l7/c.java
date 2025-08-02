package l7;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.s;

abstract class c extends a {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12622a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                l7.b[] r0 = l7.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12622a = r0
                l7.b r1 = l7.b.OPACITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12622a     // Catch:{ NoSuchFieldError -> 0x001d }
                l7.b r1 = l7.b.SCALE_XY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12622a     // Catch:{ NoSuchFieldError -> 0x0028 }
                l7.b r1 = l7.b.SCALE_X     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12622a     // Catch:{ NoSuchFieldError -> 0x0033 }
                l7.b r1 = l7.b.SCALE_Y     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l7.c.a.<clinit>():void");
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public Animation b(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        b bVar = this.f12613c;
        if (bVar != null) {
            int i14 = a.f12622a[bVar.ordinal()];
            float f17 = 0.0f;
            if (i14 == 1) {
                if (g()) {
                    f10 = view.getAlpha();
                } else {
                    f10 = 0.0f;
                }
                if (!g()) {
                    f17 = view.getAlpha();
                }
                return new l(view, f10, f17);
            } else if (i14 == 2) {
                if (g()) {
                    f11 = 1.0f;
                } else {
                    f11 = 0.0f;
                }
                if (g()) {
                    f12 = 0.0f;
                } else {
                    f12 = 1.0f;
                }
                return new ScaleAnimation(f11, f12, f11, f12, 1, 0.5f, 1, 0.5f);
            } else if (i14 == 3) {
                if (g()) {
                    f13 = 1.0f;
                } else {
                    f13 = 0.0f;
                }
                if (g()) {
                    f14 = 0.0f;
                } else {
                    f14 = 1.0f;
                }
                return new ScaleAnimation(f13, f14, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
            } else if (i14 == 4) {
                if (g()) {
                    f15 = 1.0f;
                } else {
                    f15 = 0.0f;
                }
                if (g()) {
                    f16 = 0.0f;
                } else {
                    f16 = 1.0f;
                }
                return new ScaleAnimation(1.0f, 1.0f, f15, f16, 1, 0.0f, 1, 0.5f);
            } else {
                throw new s("Missing animation for property : " + this.f12613c);
            }
        } else {
            throw new s("Missing animated property from animation config");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        if (this.f12614d <= 0 || this.f12613c == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean g();
}

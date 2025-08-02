package w3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
import m4.k;
import y2.l;

public class f extends a {
    private final int C;
    int[] N0;
    int[] O0;
    int P0;
    boolean[] Q0;
    int R0;
    private k S0;
    private boolean T0;
    private boolean U0;
    private boolean V0 = true;
    int X;
    int Y;
    long Z;

    /* renamed from: i  reason: collision with root package name */
    private final Drawable[] f24522i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f24523j;

    /* renamed from: w  reason: collision with root package name */
    private final int f24524w;

    public f(Drawable[] drawableArr, boolean z10, int i10) {
        super(drawableArr);
        boolean z11 = true;
        int i11 = 0;
        l.j(drawableArr.length < 1 ? false : z11, "At least one layer required!");
        this.f24522i = drawableArr;
        this.N0 = new int[drawableArr.length];
        this.O0 = new int[drawableArr.length];
        this.P0 = 255;
        this.Q0 = new boolean[drawableArr.length];
        this.R0 = 0;
        this.f24523j = z10;
        this.f24524w = z10 ? 255 : i11;
        this.C = i10;
        t();
    }

    private void i(Canvas canvas, Drawable drawable, int i10) {
        if (drawable != null && i10 > 0) {
            this.R0++;
            if (this.V0) {
                drawable.mutate();
            }
            drawable.setAlpha(i10);
            this.R0--;
            drawable.draw(canvas);
        }
    }

    private void q() {
        if (this.T0) {
            this.T0 = false;
            k kVar = this.S0;
            if (kVar != null) {
                kVar.c();
            }
        }
    }

    private void r() {
        int i10;
        if (!this.T0 && (i10 = this.C) >= 0) {
            boolean[] zArr = this.Q0;
            if (i10 < zArr.length && zArr[i10]) {
                this.T0 = true;
                k kVar = this.S0;
                if (kVar != null) {
                    kVar.a();
                }
            }
        }
    }

    private void s() {
        if (this.U0 && this.X == 2 && this.Q0[this.C]) {
            k kVar = this.S0;
            if (kVar != null) {
                kVar.b();
            }
            this.U0 = false;
        }
    }

    private void t() {
        this.X = 2;
        Arrays.fill(this.N0, this.f24524w);
        this.N0[0] = 255;
        Arrays.fill(this.O0, this.f24524w);
        this.O0[0] = 255;
        Arrays.fill(this.Q0, this.f24523j);
        this.Q0[0] = true;
    }

    private boolean v(float f10) {
        int i10;
        boolean z10 = true;
        for (int i11 = 0; i11 < this.f24522i.length; i11++) {
            boolean z11 = this.Q0[i11];
            if (z11) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            int[] iArr = this.O0;
            int i12 = (int) (((float) this.N0[i11]) + (((float) (i10 * 255)) * f10));
            iArr[i11] = i12;
            if (i12 < 0) {
                iArr[i11] = 0;
            }
            if (iArr[i11] > 255) {
                iArr[i11] = 255;
            }
            if (z11 && iArr[i11] < 255) {
                z10 = false;
            }
            if (!z11 && iArr[i11] > 0) {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057 A[LOOP:0: B:20:0x0052->B:22:0x0057, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[EDGE_INSN: B:26:0x0072->B:23:0x0072 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.X
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x002c
            if (r0 == r3) goto L_0x000a
            goto L_0x0052
        L_0x000a:
            int r0 = r8.Y
            if (r0 <= 0) goto L_0x0010
            r0 = r3
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            y2.l.i(r0)
            long r4 = r8.p()
            long r6 = r8.Z
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.Y
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.v(r0)
            if (r0 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r1 = r3
        L_0x0028:
            r8.X = r1
        L_0x002a:
            r3 = r0
            goto L_0x0052
        L_0x002c:
            int[] r0 = r8.O0
            int[] r4 = r8.N0
            android.graphics.drawable.Drawable[] r5 = r8.f24522i
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.p()
            r8.Z = r4
            int r0 = r8.Y
            if (r0 != 0) goto L_0x0043
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            boolean r0 = r8.v(r0)
            r8.r()
            if (r0 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = r3
        L_0x004f:
            r8.X = r1
            goto L_0x002a
        L_0x0052:
            android.graphics.drawable.Drawable[] r0 = r8.f24522i
            int r1 = r0.length
            if (r2 >= r1) goto L_0x0072
            r0 = r0[r2]
            int[] r1 = r8.O0
            r1 = r1[r2]
            int r4 = r8.P0
            int r1 = r1 * r4
            double r4 = (double) r1
            r6 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r4 = r4 / r6
            double r4 = java.lang.Math.ceil(r4)
            int r1 = (int) r4
            r8.i(r9, r0, r1)
            int r2 = r2 + 1
            goto L_0x0052
        L_0x0072:
            if (r3 == 0) goto L_0x007b
            r8.q()
            r8.s()
            goto L_0x007e
        L_0x007b:
            r8.invalidateSelf()
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.f.draw(android.graphics.Canvas):void");
    }

    public int getAlpha() {
        return this.P0;
    }

    public void h() {
        this.R0++;
    }

    public void invalidateSelf() {
        if (this.R0 == 0) {
            super.invalidateSelf();
        }
    }

    public void j() {
        this.R0--;
        invalidateSelf();
    }

    public void k() {
        this.X = 0;
        Arrays.fill(this.Q0, true);
        invalidateSelf();
    }

    public void m(int i10) {
        this.X = 0;
        this.Q0[i10] = true;
        invalidateSelf();
    }

    public void n(int i10) {
        this.X = 0;
        this.Q0[i10] = false;
        invalidateSelf();
    }

    public void o() {
        int i10;
        this.X = 2;
        for (int i11 = 0; i11 < this.f24522i.length; i11++) {
            int[] iArr = this.O0;
            if (this.Q0[i11]) {
                i10 = 255;
            } else {
                i10 = 0;
            }
            iArr[i11] = i10;
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public long p() {
        return SystemClock.uptimeMillis();
    }

    public void setAlpha(int i10) {
        if (this.P0 != i10) {
            this.P0 = i10;
            invalidateSelf();
        }
    }

    public void u(int i10) {
        this.Y = i10;
        if (this.X == 1) {
            this.X = 0;
        }
    }
}

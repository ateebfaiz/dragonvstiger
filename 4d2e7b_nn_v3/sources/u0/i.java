package u0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.r0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o0.o;
import s0.k;
import s0.l;
import s0.m;
import t0.q;
import t0.u;

public class i extends b {
    private final StringBuilder E = new StringBuilder(2);
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private final Paint H = new a(1);
    private final Paint I = new b(1);
    private final Map J = new HashMap();
    private final LongSparseArray K = new LongSparseArray();
    private final List L = new ArrayList();
    private final o M;
    private final k0 N;
    private final j O;
    private u P = u.INDEX;
    private o0.a Q;
    private o0.a R;
    private o0.a S;
    private o0.a T;
    private o0.a U;
    private o0.a V;
    private o0.a W;
    private o0.a X;
    private o0.a Y;
    private o0.a Z;

    /* renamed from: a0  reason: collision with root package name */
    private o0.a f24244a0;

    /* renamed from: b0  reason: collision with root package name */
    private o0.a f24245b0;

    /* renamed from: c0  reason: collision with root package name */
    private o0.a f24246c0;

    /* renamed from: d0  reason: collision with root package name */
    private o0.a f24247d0;

    class a extends Paint {
        a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24250a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                r0.b$a[] r0 = r0.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24250a = r0
                r0.b$a r1 = r0.b.a.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24250a     // Catch:{ NoSuchFieldError -> 0x001d }
                r0.b$a r1 = r0.b.a.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24250a     // Catch:{ NoSuchFieldError -> 0x0028 }
                r0.b$a r1 = r0.b.a.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: u0.i.c.<clinit>():void");
        }
    }

    i(k0 k0Var, e eVar) {
        super(k0Var, eVar);
        l lVar;
        l lVar2;
        s0.d dVar;
        l lVar3;
        s0.d dVar2;
        l lVar4;
        s0.d dVar3;
        m mVar;
        s0.d dVar4;
        m mVar2;
        s0.b bVar;
        m mVar3;
        s0.b bVar2;
        m mVar4;
        s0.a aVar;
        m mVar5;
        s0.a aVar2;
        this.N = k0Var;
        this.O = eVar.c();
        o d10 = eVar.t().a();
        this.M = d10;
        d10.a(this);
        i(d10);
        k u10 = eVar.u();
        if (!(u10 == null || (mVar5 = u10.f23732a) == null || (aVar2 = mVar5.f23738a) == null)) {
            o0.a a10 = aVar2.a();
            this.Q = a10;
            a10.a(this);
            i(this.Q);
        }
        if (!(u10 == null || (mVar4 = u10.f23732a) == null || (aVar = mVar4.f23739b) == null)) {
            o0.a a11 = aVar.a();
            this.S = a11;
            a11.a(this);
            i(this.S);
        }
        if (!(u10 == null || (mVar3 = u10.f23732a) == null || (bVar2 = mVar3.f23740c) == null)) {
            o0.d d11 = bVar2.a();
            this.U = d11;
            d11.a(this);
            i(this.U);
        }
        if (!(u10 == null || (mVar2 = u10.f23732a) == null || (bVar = mVar2.f23741d) == null)) {
            o0.d d12 = bVar.a();
            this.W = d12;
            d12.a(this);
            i(this.W);
        }
        if (!(u10 == null || (mVar = u10.f23732a) == null || (dVar4 = mVar.f23742e) == null)) {
            o0.a a12 = dVar4.a();
            this.Y = a12;
            a12.a(this);
            i(this.Y);
        }
        if (!(u10 == null || (lVar4 = u10.f23733b) == null || (dVar3 = lVar4.f23734a) == null)) {
            o0.a a13 = dVar3.a();
            this.f24245b0 = a13;
            a13.a(this);
            i(this.f24245b0);
        }
        if (!(u10 == null || (lVar3 = u10.f23733b) == null || (dVar2 = lVar3.f23735b) == null)) {
            o0.a a14 = dVar2.a();
            this.f24246c0 = a14;
            a14.a(this);
            i(this.f24246c0);
        }
        if (!(u10 == null || (lVar2 = u10.f23733b) == null || (dVar = lVar2.f23736c) == null)) {
            o0.a a15 = dVar.a();
            this.f24247d0 = a15;
            a15.a(this);
            i(this.f24247d0);
        }
        if (u10 != null && (lVar = u10.f23733b) != null) {
            this.P = lVar.f23737d;
        }
    }

    private String P(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!e0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = (long) codePointAt;
        if (this.K.containsKey(j10)) {
            return (String) this.K.get(j10);
        }
        this.E.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.E.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb2 = this.E.toString();
        this.K.put(j10, sb2);
        return sb2;
    }

    private void Q(r0.b bVar, int i10, int i11) {
        int i12;
        o0.a aVar = this.R;
        if (aVar != null) {
            this.H.setColor(((Integer) aVar.h()).intValue());
        } else if (this.Q == null || !d0(i11)) {
            this.H.setColor(bVar.f23602h);
        } else {
            this.H.setColor(((Integer) this.Q.h()).intValue());
        }
        o0.a aVar2 = this.T;
        if (aVar2 != null) {
            this.I.setColor(((Integer) aVar2.h()).intValue());
        } else if (this.S == null || !d0(i11)) {
            this.I.setColor(bVar.f23603i);
        } else {
            this.I.setColor(((Integer) this.S.h()).intValue());
        }
        int i13 = 100;
        if (this.f24198x.h() == null) {
            i12 = 100;
        } else {
            i12 = ((Integer) this.f24198x.h().h()).intValue();
        }
        if (this.Y != null && d0(i11)) {
            i13 = ((Integer) this.Y.h()).intValue();
        }
        int round = Math.round(((((((float) i12) * 255.0f) / 100.0f) * (((float) i13) / 100.0f)) * ((float) i10)) / 255.0f);
        this.H.setAlpha(round);
        this.I.setAlpha(round);
        o0.a aVar3 = this.V;
        if (aVar3 != null) {
            this.I.setStrokeWidth(((Float) aVar3.h()).floatValue());
        } else if (this.U == null || !d0(i11)) {
            this.I.setStrokeWidth(bVar.f23604j * y0.l.e());
        } else {
            this.I.setStrokeWidth(((Float) this.U.h()).floatValue());
        }
    }

    private void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void S(r0.d dVar, float f10, r0.b bVar, Canvas canvas, int i10, int i11) {
        Q(bVar, i11, i10);
        List a02 = a0(dVar);
        for (int i12 = 0; i12 < a02.size(); i12++) {
            Path path = ((n0.d) a02.get(i12)).getPath();
            path.computeBounds(this.F, false);
            this.G.reset();
            this.G.preTranslate(0.0f, (-bVar.f23601g) * y0.l.e());
            this.G.preScale(f10, f10);
            path.transform(this.G);
            if (bVar.f23605k) {
                V(path, this.H, canvas);
                V(path, this.I, canvas);
            } else {
                V(path, this.I, canvas);
                V(path, this.H, canvas);
            }
        }
    }

    private void T(String str, r0.b bVar, Canvas canvas, int i10, int i11) {
        Q(bVar, i11, i10);
        if (bVar.f23605k) {
            R(str, this.H, canvas);
            R(str, this.I, canvas);
            return;
        }
        R(str, this.I, canvas);
        R(str, this.H, canvas);
    }

    private void U(String str, r0.b bVar, Canvas canvas, float f10, int i10, int i11) {
        int i12 = 0;
        while (i12 < str.length()) {
            String P2 = P(str, i12);
            T(P2, bVar, canvas, i10 + i12, i11);
            canvas.translate(this.H.measureText(P2) + f10, 0.0f);
            i12 += P2.length();
        }
    }

    private void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void W(String str, r0.b bVar, r0.c cVar, Canvas canvas, float f10, float f11, float f12, int i10) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            String str2 = str;
            r0.d dVar = (r0.d) this.O.c().get(r0.d.c(str.charAt(i11), cVar.a(), cVar.c()));
            if (dVar == null) {
                Canvas canvas2 = canvas;
            } else {
                S(dVar, f11, bVar, canvas, i11, i10);
                Canvas canvas3 = canvas;
                canvas.translate((((float) dVar.b()) * f11 * y0.l.e()) + f12, 0.0f);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void X(r0.b r21, r0.c r22, android.graphics.Canvas r23, int r24) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r9 = r22
            android.graphics.Typeface r0 = r7.c0(r9)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r1 = r8.f23595a
            com.airbnb.lottie.k0 r2 = r7.N
            com.airbnb.lottie.a1 r2 = r2.a0()
            if (r2 == 0) goto L_0x001f
            java.lang.String r3 = r20.getName()
            java.lang.String r1 = r2.c(r3, r1)
        L_0x001f:
            android.graphics.Paint r2 = r7.H
            r2.setTypeface(r0)
            o0.a r0 = r7.Z
            if (r0 == 0) goto L_0x0033
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x0035
        L_0x0033:
            float r0 = r8.f23597c
        L_0x0035:
            android.graphics.Paint r2 = r7.H
            float r3 = y0.l.e()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.I
            android.graphics.Paint r3 = r7.H
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.I
            android.graphics.Paint r3 = r7.H
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.f23599e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            o0.a r3 = r7.X
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L_0x0069:
            float r2 = r2 + r3
            goto L_0x007a
        L_0x006b:
            o0.a r3 = r7.W
            if (r3 == 0) goto L_0x007a
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L_0x0069
        L_0x007a:
            float r3 = y0.l.e()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r10 = r2 / r0
            java.util.List r11 = r7.b0(r1)
            int r12 = r11.size()
            r13 = 0
            r0 = -1
            r14 = r0
            r15 = r13
            r16 = r15
        L_0x0092:
            if (r15 >= r12) goto L_0x0100
            java.lang.Object r0 = r11.get(r15)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.f23607m
            if (r0 != 0) goto L_0x00a2
            r0 = 0
        L_0x00a0:
            r2 = r0
            goto L_0x00a5
        L_0x00a2:
            float r0 = r0.x
            goto L_0x00a0
        L_0x00a5:
            r4 = 0
            r6 = 0
            r0 = r20
            r3 = r22
            r5 = r10
            java.util.List r6 = r0.g0(r1, r2, r3, r4, r5, r6)
            r5 = r13
        L_0x00b1:
            int r0 = r6.size()
            if (r5 >= r0) goto L_0x00fd
            java.lang.Object r0 = r6.get(r5)
            r17 = r0
            u0.i$d r17 = (u0.i.d) r17
            int r14 = r14 + 1
            r23.save()
            float r0 = r17.f24252b
            r4 = r23
            boolean r0 = r7.f0(r4, r8, r14, r0)
            if (r0 == 0) goto L_0x00e7
            java.lang.String r1 = r17.f24251a
            r0 = r20
            r2 = r21
            r3 = r23
            r4 = r10
            r18 = r5
            r5 = r16
            r19 = r6
            r6 = r24
            r0.U(r1, r2, r3, r4, r5, r6)
            goto L_0x00eb
        L_0x00e7:
            r18 = r5
            r19 = r6
        L_0x00eb:
            java.lang.String r0 = r17.f24251a
            int r0 = r0.length()
            int r16 = r16 + r0
            r23.restore()
            int r5 = r18 + 1
            r6 = r19
            goto L_0x00b1
        L_0x00fd:
            int r15 = r15 + 1
            goto L_0x0092
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.i.X(r0.b, r0.c, android.graphics.Canvas, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Y(r0.b r22, android.graphics.Matrix r23, r0.c r24, android.graphics.Canvas r25, int r26) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            o0.a r0 = r9.Z
            if (r0 == 0) goto L_0x0013
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x0015
        L_0x0013:
            float r0 = r10.f23597c
        L_0x0015:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r11 = r0 / r1
            float r12 = y0.l.g(r23)
            java.lang.String r0 = r10.f23595a
            java.util.List r13 = r9.b0(r0)
            int r14 = r13.size()
            int r0 = r10.f23599e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            o0.a r1 = r9.X
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L_0x003b:
            float r0 = r0 + r1
        L_0x003c:
            r15 = r0
            goto L_0x004d
        L_0x003e:
            o0.a r1 = r9.W
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L_0x003b
        L_0x004d:
            r16 = 0
            r0 = -1
            r7 = r0
            r8 = r16
        L_0x0053:
            if (r8 >= r14) goto L_0x00c6
            java.lang.Object r0 = r13.get(r8)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r10.f23607m
            if (r0 != 0) goto L_0x0063
            r0 = 0
        L_0x0061:
            r2 = r0
            goto L_0x0066
        L_0x0063:
            float r0 = r0.x
            goto L_0x0061
        L_0x0066:
            r6 = 1
            r0 = r21
            r3 = r24
            r4 = r11
            r5 = r15
            java.util.List r6 = r0.g0(r1, r2, r3, r4, r5, r6)
            r5 = r16
        L_0x0073:
            int r0 = r6.size()
            if (r5 >= r0) goto L_0x00c1
            java.lang.Object r0 = r6.get(r5)
            u0.i$d r0 = (u0.i.d) r0
            int r7 = r7 + 1
            r25.save()
            float r1 = r0.f24252b
            r4 = r25
            boolean r1 = r9.f0(r4, r10, r7, r1)
            if (r1 == 0) goto L_0x00ad
            java.lang.String r1 = r0.f24251a
            r0 = r21
            r2 = r22
            r3 = r24
            r4 = r25
            r17 = r5
            r5 = r12
            r18 = r6
            r6 = r11
            r19 = r7
            r7 = r15
            r20 = r8
            r8 = r26
            r0.W(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00b5
        L_0x00ad:
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        L_0x00b5:
            r25.restore()
            int r5 = r17 + 1
            r6 = r18
            r7 = r19
            r8 = r20
            goto L_0x0073
        L_0x00c1:
            r20 = r8
            int r8 = r20 + 1
            goto L_0x0053
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.i.Y(r0.b, android.graphics.Matrix, r0.c, android.graphics.Canvas, int):void");
    }

    private d Z(int i10) {
        for (int size = this.L.size(); size < i10; size++) {
            this.L.add(new d((a) null));
        }
        return (d) this.L.get(i10 - 1);
    }

    private List a0(r0.d dVar) {
        if (this.J.containsKey(dVar)) {
            return (List) this.J.get(dVar);
        }
        List a10 = dVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new n0.d(this.N, this, (q) a10.get(i10), this.O));
        }
        this.J.put(dVar, arrayList);
        return arrayList;
    }

    private List b0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface c0(r0.c cVar) {
        Typeface typeface;
        o0.a aVar = this.f24244a0;
        if (aVar != null && (typeface = (Typeface) aVar.h()) != null) {
            return typeface;
        }
        Typeface b02 = this.N.b0(cVar);
        if (b02 != null) {
            return b02;
        }
        return cVar.d();
    }

    private boolean d0(int i10) {
        int length = ((r0.b) this.M.h()).f23595a.length();
        o0.a aVar = this.f24245b0;
        if (aVar == null || this.f24246c0 == null) {
            return true;
        }
        int min = Math.min(((Integer) aVar.h()).intValue(), ((Integer) this.f24246c0.h()).intValue());
        int max = Math.max(((Integer) this.f24245b0.h()).intValue(), ((Integer) this.f24246c0.h()).intValue());
        o0.a aVar2 = this.f24247d0;
        if (aVar2 != null) {
            int intValue = ((Integer) aVar2.h()).intValue();
            min += intValue;
            max += intValue;
        }
        if (this.P != u.INDEX) {
            float f10 = (((float) i10) / ((float) length)) * 100.0f;
            if (f10 < ((float) min) || f10 >= ((float) max)) {
                return false;
            }
            return true;
        } else if (i10 < min || i10 >= max) {
            return false;
        } else {
            return true;
        }
    }

    private boolean e0(int i10) {
        if (Character.getType(i10) == 16 || Character.getType(i10) == 27 || Character.getType(i10) == 6 || Character.getType(i10) == 28 || Character.getType(i10) == 8 || Character.getType(i10) == 19) {
            return true;
        }
        return false;
    }

    private boolean f0(Canvas canvas, r0.b bVar, int i10, float f10) {
        float f11;
        float f12;
        PointF pointF = bVar.f23606l;
        PointF pointF2 = bVar.f23607m;
        float e10 = y0.l.e();
        float f13 = 0.0f;
        if (pointF == null) {
            f11 = 0.0f;
        } else {
            f11 = (bVar.f23600f * e10) + pointF.y;
        }
        float f14 = (((float) i10) * bVar.f23600f * e10) + f11;
        if (this.N.H() && pointF2 != null && pointF != null && f14 >= pointF.y + pointF2.y + bVar.f23597c) {
            return false;
        }
        if (pointF == null) {
            f12 = 0.0f;
        } else {
            f12 = pointF.x;
        }
        if (pointF2 != null) {
            f13 = pointF2.x;
        }
        int i11 = c.f24250a[bVar.f23598d.ordinal()];
        if (i11 == 1) {
            canvas.translate(f12, f14);
        } else if (i11 == 2) {
            canvas.translate((f12 + f13) - f10, f14);
        } else if (i11 == 3) {
            canvas.translate((f12 + (f13 / 2.0f)) - (f10 / 2.0f), f14);
        }
        return true;
    }

    private List g0(String str, float f10, r0.c cVar, float f11, float f12, boolean z10) {
        float measureText;
        String str2 = str;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char charAt = str2.charAt(i13);
            if (z10) {
                r0.d dVar = (r0.d) this.O.c().get(r0.d.c(charAt, cVar.a(), cVar.c()));
                if (dVar == null) {
                } else {
                    measureText = ((float) dVar.b()) * f11 * y0.l.e();
                }
            } else {
                measureText = this.H.measureText(str2.substring(i13, i13 + 1));
            }
            float f16 = measureText + f12;
            if (charAt == ' ') {
                z11 = true;
                f15 = f16;
            } else if (z11) {
                z11 = false;
                i12 = i13;
                f14 = f16;
            } else {
                f14 += f16;
            }
            f13 += f16;
            if (f10 > 0.0f && f13 >= f10 && charAt != ' ') {
                i10++;
                d Z2 = Z(i10);
                if (i12 == i11) {
                    String substring = str2.substring(i11, i13);
                    String trim = substring.trim();
                    Z2.c(trim, (f13 - f16) - (((float) (trim.length() - substring.length())) * f15));
                    i11 = i13;
                    i12 = i11;
                    f13 = f16;
                    f14 = f13;
                } else {
                    String substring2 = str2.substring(i11, i12 - 1);
                    String trim2 = substring2.trim();
                    Z2.c(trim2, ((f13 - f14) - (((float) (substring2.length() - trim2.length())) * f15)) - f15);
                    f13 = f14;
                    i11 = i12;
                }
            }
        }
        if (f13 > 0.0f) {
            i10++;
            Z(i10).c(str2.substring(i11), f13);
        }
        return this.L.subList(0, i10);
    }

    public void c(Object obj, z0.c cVar) {
        super.c(obj, cVar);
        if (obj == r0.f17738a) {
            o0.a aVar = this.R;
            if (aVar != null) {
                H(aVar);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            o0.q qVar = new o0.q(cVar);
            this.R = qVar;
            qVar.a(this);
            i(this.R);
        } else if (obj == r0.f17739b) {
            o0.a aVar2 = this.T;
            if (aVar2 != null) {
                H(aVar2);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            o0.q qVar2 = new o0.q(cVar);
            this.T = qVar2;
            qVar2.a(this);
            i(this.T);
        } else if (obj == r0.f17756s) {
            o0.a aVar3 = this.V;
            if (aVar3 != null) {
                H(aVar3);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            o0.q qVar3 = new o0.q(cVar);
            this.V = qVar3;
            qVar3.a(this);
            i(this.V);
        } else if (obj == r0.f17757t) {
            o0.a aVar4 = this.X;
            if (aVar4 != null) {
                H(aVar4);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            o0.q qVar4 = new o0.q(cVar);
            this.X = qVar4;
            qVar4.a(this);
            i(this.X);
        } else if (obj == r0.F) {
            o0.a aVar5 = this.Z;
            if (aVar5 != null) {
                H(aVar5);
            }
            if (cVar == null) {
                this.Z = null;
                return;
            }
            o0.q qVar5 = new o0.q(cVar);
            this.Z = qVar5;
            qVar5.a(this);
            i(this.Z);
        } else if (obj == r0.M) {
            o0.a aVar6 = this.f24244a0;
            if (aVar6 != null) {
                H(aVar6);
            }
            if (cVar == null) {
                this.f24244a0 = null;
                return;
            }
            o0.q qVar6 = new o0.q(cVar);
            this.f24244a0 = qVar6;
            qVar6.a(this);
            i(this.f24244a0);
        } else if (obj == r0.O) {
            this.M.r(cVar);
        }
    }

    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, (float) this.O.b().width(), (float) this.O.b().height());
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i10) {
        r0.b bVar = (r0.b) this.M.h();
        r0.c cVar = (r0.c) this.O.g().get(bVar.f23596b);
        if (cVar != null) {
            canvas.save();
            canvas.concat(matrix);
            Q(bVar, i10, 0);
            if (this.N.k1()) {
                Y(bVar, matrix, cVar, canvas, i10);
            } else {
                X(bVar, cVar, canvas, i10);
            }
            canvas.restore();
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f24251a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f24252b;

        private d() {
            this.f24251a = "";
            this.f24252b = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void c(String str, float f10) {
            this.f24251a = str;
            this.f24252b = f10;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}

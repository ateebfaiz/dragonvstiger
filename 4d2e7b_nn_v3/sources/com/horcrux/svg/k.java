package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;

class k {
    private double[] A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final float M;
    private final float N;
    private final float O;

    /* renamed from: a  reason: collision with root package name */
    final ArrayList f9873a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f9874b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f9875c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f9876d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList f9877e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList f9878f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f9879g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList f9880h;

    /* renamed from: i  reason: collision with root package name */
    private final ArrayList f9881i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList f9882j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList f9883k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList f9884l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList f9885m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private final ArrayList f9886n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList f9887o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList f9888p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private double f9889q = 12.0d;

    /* renamed from: r  reason: collision with root package name */
    private j f9890r = j.f9852p;

    /* renamed from: s  reason: collision with root package name */
    private double f9891s;

    /* renamed from: t  reason: collision with root package name */
    private double f9892t;

    /* renamed from: u  reason: collision with root package name */
    private double f9893u;

    /* renamed from: v  reason: collision with root package name */
    private double f9894v;

    /* renamed from: w  reason: collision with root package name */
    private SVGLength[] f9895w;

    /* renamed from: x  reason: collision with root package name */
    private SVGLength[] f9896x;

    /* renamed from: y  reason: collision with root package name */
    private SVGLength[] f9897y;

    /* renamed from: z  reason: collision with root package name */
    private SVGLength[] f9898z;

    k(float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        this.f9873a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f9874b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f9875c = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.f9876d = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.f9877e = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.f9878f = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.f9879g = arrayList7;
        ArrayList arrayList8 = new ArrayList();
        this.f9880h = arrayList8;
        ArrayList arrayList9 = new ArrayList();
        this.f9881i = arrayList9;
        ArrayList arrayList10 = new ArrayList();
        this.f9882j = arrayList10;
        ArrayList arrayList11 = new ArrayList();
        this.f9883k = arrayList11;
        SVGLength[] sVGLengthArr = new SVGLength[0];
        this.f9895w = sVGLengthArr;
        this.f9896x = new SVGLength[0];
        this.f9897y = new SVGLength[0];
        this.f9898z = new SVGLength[0];
        this.A = new double[]{0.0d};
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.M = f10;
        this.N = f11;
        this.O = f12;
        arrayList2.add(sVGLengthArr);
        arrayList3.add(this.f9896x);
        arrayList4.add(this.f9897y);
        arrayList5.add(this.f9898z);
        arrayList6.add(this.A);
        arrayList7.add(Integer.valueOf(this.G));
        arrayList8.add(Integer.valueOf(this.H));
        arrayList9.add(Integer.valueOf(this.I));
        arrayList10.add(Integer.valueOf(this.J));
        arrayList11.add(Integer.valueOf(this.K));
        arrayList.add(this.f9890r);
        q();
    }

    private double[] a(ArrayList arrayList) {
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((SVGLength) arrayList.get(i10)).f9683a;
        }
        return dArr;
    }

    private SVGLength[] e(ArrayList arrayList) {
        int size = arrayList.size();
        SVGLength[] sVGLengthArr = new SVGLength[size];
        for (int i10 = 0; i10 < size; i10++) {
            sVGLengthArr[i10] = (SVGLength) arrayList.get(i10);
        }
        return sVGLengthArr;
    }

    private j f(GroupView groupView) {
        if (this.L > 0) {
            return this.f9890r;
        }
        for (GroupView parentTextRoot = groupView.getParentTextRoot(); parentTextRoot != null; parentTextRoot = parentTextRoot.getParentTextRoot()) {
            j b10 = parentTextRoot.r().b();
            if (b10 != j.f9852p) {
                return b10;
            }
        }
        return j.f9852p;
    }

    private static void h(ArrayList arrayList, int i10) {
        while (i10 >= 0) {
            arrayList.set(i10, Integer.valueOf(((Integer) arrayList.get(i10)).intValue() + 1));
            i10--;
        }
    }

    private void q() {
        this.f9884l.add(Integer.valueOf(this.B));
        this.f9885m.add(Integer.valueOf(this.C));
        this.f9886n.add(Integer.valueOf(this.D));
        this.f9887o.add(Integer.valueOf(this.E));
        this.f9888p.add(Integer.valueOf(this.F));
    }

    private void r(GroupView groupView, ReadableMap readableMap) {
        j f10 = f(groupView);
        this.L++;
        if (readableMap == null) {
            this.f9873a.add(f10);
            return;
        }
        j jVar = new j(readableMap, f10, (double) this.M);
        this.f9889q = jVar.f9853a;
        this.f9873a.add(jVar);
        this.f9890r = jVar;
    }

    private void s() {
        this.F = 0;
        this.E = 0;
        this.D = 0;
        this.C = 0;
        this.B = 0;
        this.K = -1;
        this.J = -1;
        this.I = -1;
        this.H = -1;
        this.G = -1;
        this.f9894v = 0.0d;
        this.f9893u = 0.0d;
        this.f9892t = 0.0d;
        this.f9891s = 0.0d;
    }

    /* access modifiers changed from: package-private */
    public j b() {
        return this.f9890r;
    }

    /* access modifiers changed from: package-private */
    public double c() {
        return this.f9889q;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.O;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.N;
    }

    /* access modifiers changed from: package-private */
    public double i() {
        h(this.f9881i, this.D);
        int i10 = this.I + 1;
        SVGLength[] sVGLengthArr = this.f9897y;
        if (i10 < sVGLengthArr.length) {
            this.I = i10;
            this.f9893u += p.a(sVGLengthArr[i10], (double) this.N, 0.0d, (double) this.M, this.f9889q);
        }
        return this.f9893u;
    }

    /* access modifiers changed from: package-private */
    public double j() {
        h(this.f9882j, this.E);
        int i10 = this.J + 1;
        SVGLength[] sVGLengthArr = this.f9898z;
        if (i10 < sVGLengthArr.length) {
            this.J = i10;
            this.f9894v += p.a(sVGLengthArr[i10], (double) this.O, 0.0d, (double) this.M, this.f9889q);
        }
        return this.f9894v;
    }

    /* access modifiers changed from: package-private */
    public double k() {
        h(this.f9883k, this.F);
        int min = Math.min(this.K + 1, this.A.length - 1);
        this.K = min;
        return this.A[min];
    }

    /* access modifiers changed from: package-private */
    public double l(double d10) {
        h(this.f9879g, this.B);
        int i10 = this.G + 1;
        SVGLength[] sVGLengthArr = this.f9895w;
        if (i10 < sVGLengthArr.length) {
            this.f9893u = 0.0d;
            this.G = i10;
            this.f9891s = p.a(sVGLengthArr[i10], (double) this.N, 0.0d, (double) this.M, this.f9889q);
        }
        double d11 = this.f9891s + d10;
        this.f9891s = d11;
        return d11;
    }

    /* access modifiers changed from: package-private */
    public double m() {
        h(this.f9880h, this.C);
        int i10 = this.H + 1;
        SVGLength[] sVGLengthArr = this.f9896x;
        if (i10 < sVGLengthArr.length) {
            this.f9894v = 0.0d;
            this.H = i10;
            this.f9892t = p.a(sVGLengthArr[i10], (double) this.O, 0.0d, (double) this.M, this.f9889q);
        }
        return this.f9892t;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f9873a.remove(this.L);
        this.f9884l.remove(this.L);
        this.f9885m.remove(this.L);
        this.f9886n.remove(this.L);
        this.f9887o.remove(this.L);
        this.f9888p.remove(this.L);
        int i10 = this.L - 1;
        this.L = i10;
        int i11 = this.B;
        int i12 = this.C;
        int i13 = this.D;
        int i14 = this.E;
        int i15 = this.F;
        this.f9890r = (j) this.f9873a.get(i10);
        this.B = ((Integer) this.f9884l.get(this.L)).intValue();
        this.C = ((Integer) this.f9885m.get(this.L)).intValue();
        this.D = ((Integer) this.f9886n.get(this.L)).intValue();
        this.E = ((Integer) this.f9887o.get(this.L)).intValue();
        this.F = ((Integer) this.f9888p.get(this.L)).intValue();
        if (i11 != this.B) {
            this.f9874b.remove(i11);
            this.f9895w = (SVGLength[]) this.f9874b.get(this.B);
            this.G = ((Integer) this.f9879g.get(this.B)).intValue();
        }
        if (i12 != this.C) {
            this.f9875c.remove(i12);
            this.f9896x = (SVGLength[]) this.f9875c.get(this.C);
            this.H = ((Integer) this.f9880h.get(this.C)).intValue();
        }
        if (i13 != this.D) {
            this.f9876d.remove(i13);
            this.f9897y = (SVGLength[]) this.f9876d.get(this.D);
            this.I = ((Integer) this.f9881i.get(this.D)).intValue();
        }
        if (i14 != this.E) {
            this.f9877e.remove(i14);
            this.f9898z = (SVGLength[]) this.f9877e.get(this.E);
            this.J = ((Integer) this.f9882j.get(this.E)).intValue();
        }
        if (i15 != this.F) {
            this.f9878f.remove(i15);
            this.A = (double[]) this.f9878f.get(this.F);
            this.K = ((Integer) this.f9883k.get(this.F)).intValue();
        }
    }

    /* access modifiers changed from: package-private */
    public void o(GroupView groupView, ReadableMap readableMap) {
        r(groupView, readableMap);
        q();
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z10, TextView textView, ReadableMap readableMap, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        if (z10) {
            s();
        }
        r(textView, readableMap);
        if (!(arrayList == null || arrayList.size() == 0)) {
            this.B++;
            this.G = -1;
            this.f9879g.add(-1);
            SVGLength[] e10 = e(arrayList);
            this.f9895w = e10;
            this.f9874b.add(e10);
        }
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            this.C++;
            this.H = -1;
            this.f9880h.add(-1);
            SVGLength[] e11 = e(arrayList2);
            this.f9896x = e11;
            this.f9875c.add(e11);
        }
        if (!(arrayList3 == null || arrayList3.size() == 0)) {
            this.D++;
            this.I = -1;
            this.f9881i.add(-1);
            SVGLength[] e12 = e(arrayList3);
            this.f9897y = e12;
            this.f9876d.add(e12);
        }
        if (!(arrayList4 == null || arrayList4.size() == 0)) {
            this.E++;
            this.J = -1;
            this.f9882j.add(-1);
            SVGLength[] e13 = e(arrayList4);
            this.f9898z = e13;
            this.f9877e.add(e13);
        }
        if (!(arrayList5 == null || arrayList5.size() == 0)) {
            this.F++;
            this.K = -1;
            this.f9883k.add(-1);
            double[] a10 = a(arrayList5);
            this.A = a10;
            this.f9878f.add(a10);
        }
        q();
    }
}

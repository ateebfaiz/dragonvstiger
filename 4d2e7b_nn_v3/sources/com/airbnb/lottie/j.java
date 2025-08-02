package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import r0.h;
import u0.e;
import y0.f;
import y0.k;
import y0.l;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final v0 f17656a = new v0();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet f17657b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private Map f17658c;

    /* renamed from: d  reason: collision with root package name */
    private Map f17659d;

    /* renamed from: e  reason: collision with root package name */
    private float f17660e;

    /* renamed from: f  reason: collision with root package name */
    private Map f17661f;

    /* renamed from: g  reason: collision with root package name */
    private List f17662g;

    /* renamed from: h  reason: collision with root package name */
    private SparseArrayCompat f17663h;

    /* renamed from: i  reason: collision with root package name */
    private LongSparseArray f17664i;

    /* renamed from: j  reason: collision with root package name */
    private List f17665j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f17666k;

    /* renamed from: l  reason: collision with root package name */
    private float f17667l;

    /* renamed from: m  reason: collision with root package name */
    private float f17668m;

    /* renamed from: n  reason: collision with root package name */
    private float f17669n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17670o;

    /* renamed from: p  reason: collision with root package name */
    private int f17671p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f17672q;

    /* renamed from: r  reason: collision with root package name */
    private int f17673r;

    public void a(String str) {
        f.c(str);
        this.f17657b.add(str);
    }

    public Rect b() {
        return this.f17666k;
    }

    public SparseArrayCompat c() {
        return this.f17663h;
    }

    public float d() {
        return (float) ((long) ((e() / this.f17669n) * 1000.0f));
    }

    public float e() {
        return this.f17668m - this.f17667l;
    }

    public float f() {
        return this.f17668m;
    }

    public Map g() {
        return this.f17661f;
    }

    public float h(float f10) {
        return k.i(this.f17667l, this.f17668m, f10);
    }

    public float i() {
        return this.f17669n;
    }

    public Map j() {
        float e10 = l.e();
        if (e10 != this.f17660e) {
            for (Map.Entry entry : this.f17659d.entrySet()) {
                this.f17659d.put((String) entry.getKey(), ((n0) entry.getValue()).a(this.f17660e / e10));
            }
        }
        this.f17660e = e10;
        return this.f17659d;
    }

    public List k() {
        return this.f17665j;
    }

    public h l(String str) {
        int size = this.f17662g.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = (h) this.f17662g.get(i10);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f17671p;
    }

    public v0 n() {
        return this.f17656a;
    }

    public List o(String str) {
        return (List) this.f17658c.get(str);
    }

    public float p() {
        return this.f17667l;
    }

    public boolean q() {
        return this.f17670o;
    }

    public void r(int i10) {
        this.f17671p += i10;
    }

    public void s(Rect rect, float f10, float f11, float f12, List list, LongSparseArray longSparseArray, Map map, Map map2, float f13, SparseArrayCompat sparseArrayCompat, Map map3, List list2, int i10, int i11) {
        this.f17666k = rect;
        this.f17667l = f10;
        this.f17668m = f11;
        this.f17669n = f12;
        this.f17665j = list;
        this.f17664i = longSparseArray;
        this.f17658c = map;
        this.f17659d = map2;
        this.f17660e = f13;
        this.f17663h = sparseArrayCompat;
        this.f17661f = map3;
        this.f17662g = list2;
        this.f17672q = i10;
        this.f17673r = i11;
    }

    public e t(long j10) {
        return (e) this.f17664i.get(j10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        for (e z10 : this.f17665j) {
            sb2.append(z10.z("\t"));
        }
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f17670o = z10;
    }

    public void v(boolean z10) {
        this.f17656a.b(z10);
    }
}

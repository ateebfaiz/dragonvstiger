package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.common.time.RealtimeSinceBootClock;
import e5.e;
import e5.j;
import e5.o;
import java.util.concurrent.ExecutorService;
import w2.i;
import x4.n;
import y2.d;
import y2.p;
import z4.g;

@d
public class AnimatedFactoryV2Impl implements s4.a {

    /* renamed from: a  reason: collision with root package name */
    private final w4.d f19684a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19685b;

    /* renamed from: c  reason: collision with root package name */
    private final n f19686c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f19687d;

    /* renamed from: e  reason: collision with root package name */
    private s4.d f19688e;

    /* renamed from: f  reason: collision with root package name */
    private t4.b f19689f;

    /* renamed from: g  reason: collision with root package name */
    private u4.a f19690g;

    /* renamed from: h  reason: collision with root package name */
    private d5.a f19691h;

    /* renamed from: i  reason: collision with root package name */
    private w2.g f19692i;

    /* renamed from: j  reason: collision with root package name */
    private int f19693j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f19694k;

    class a implements c5.c {
        a() {
        }

        public e a(j jVar, int i10, o oVar, y4.c cVar) {
            return AnimatedFactoryV2Impl.this.n().b(jVar, cVar, cVar.f24904i);
        }
    }

    class b implements t4.b {
        b() {
        }

        public r4.a a(r4.e eVar, Rect rect) {
            return new t4.a(AnimatedFactoryV2Impl.this.m(), eVar, rect, AnimatedFactoryV2Impl.this.f19687d);
        }
    }

    class c implements t4.b {
        c() {
        }

        public r4.a a(r4.e eVar, Rect rect) {
            return new t4.a(AnimatedFactoryV2Impl.this.m(), eVar, rect, AnimatedFactoryV2Impl.this.f19687d);
        }
    }

    @d
    public AnimatedFactoryV2Impl(w4.d dVar, g gVar, n nVar, boolean z10, boolean z11, int i10, w2.g gVar2) {
        this.f19684a = dVar;
        this.f19685b = gVar;
        this.f19686c = nVar;
        this.f19693j = i10;
        this.f19694k = z11;
        this.f19687d = z10;
        this.f19692i = gVar2;
    }

    private s4.d j() {
        return new s4.e(new c(), this.f19684a, this.f19694k);
    }

    private j4.d k() {
        j4.b bVar = new j4.b();
        ExecutorService executorService = this.f19692i;
        if (executorService == null) {
            executorService = new w2.d(this.f19685b.a());
        }
        j4.c cVar = new j4.c();
        y2.o oVar = p.f24881b;
        return new j4.d(l(), i.g(), executorService, RealtimeSinceBootClock.get(), this.f19684a, this.f19686c, bVar, cVar, oVar, p.a(Boolean.valueOf(this.f19694k)), p.a(Boolean.valueOf(this.f19687d)), p.a(Integer.valueOf(this.f19693j)));
    }

    private t4.b l() {
        if (this.f19689f == null) {
            this.f19689f = new b();
        }
        return this.f19689f;
    }

    /* access modifiers changed from: private */
    public u4.a m() {
        if (this.f19690g == null) {
            this.f19690g = new u4.a();
        }
        return this.f19690g;
    }

    /* access modifiers changed from: private */
    public s4.d n() {
        if (this.f19688e == null) {
            this.f19688e = j();
        }
        return this.f19688e;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer o() {
        return 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer p() {
        return 3;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ e q(j jVar, int i10, o oVar, y4.c cVar) {
        return n().a(jVar, cVar, cVar.f24904i);
    }

    public d5.a a(Context context) {
        if (this.f19691h == null) {
            this.f19691h = k();
        }
        return this.f19691h;
    }

    public c5.c b() {
        return new a();
    }

    public c5.c c() {
        return new j4.a(this);
    }
}

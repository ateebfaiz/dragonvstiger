package j4;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import d5.a;
import f3.c;
import i4.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import r4.e;
import t4.b;
import x4.n;
import y2.l;
import y2.o;
import y2.p;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final b f22209a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f22210b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f22211c;

    /* renamed from: d  reason: collision with root package name */
    private final c f22212d;

    /* renamed from: e  reason: collision with root package name */
    private final w4.d f22213e;

    /* renamed from: f  reason: collision with root package name */
    private final n f22214f;

    /* renamed from: g  reason: collision with root package name */
    private final o f22215g;

    /* renamed from: h  reason: collision with root package name */
    private final o f22216h;

    /* renamed from: i  reason: collision with root package name */
    private final o f22217i;

    /* renamed from: j  reason: collision with root package name */
    private final o f22218j;

    /* renamed from: k  reason: collision with root package name */
    private final o f22219k;

    /* renamed from: l  reason: collision with root package name */
    private final o f22220l;

    /* renamed from: m  reason: collision with root package name */
    private final o f22221m = p.f24881b;

    public d(b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, c cVar, w4.d dVar, n nVar, o oVar, o oVar2, o oVar3, o oVar4, o oVar5, o oVar6) {
        this.f22209a = bVar;
        this.f22210b = scheduledExecutorService;
        this.f22211c = executorService;
        this.f22212d = cVar;
        this.f22213e = dVar;
        this.f22214f = nVar;
        this.f22215g = oVar;
        this.f22216h = oVar2;
        this.f22217i = oVar3;
        this.f22218j = oVar4;
        this.f22220l = oVar6;
        this.f22219k = oVar5;
    }

    private r4.a c(e eVar) {
        r4.c d10 = eVar.d();
        return this.f22209a.a(eVar, new Rect(0, 0, d10.getWidth(), d10.getHeight()));
    }

    private t4.c d(e eVar) {
        return new t4.c(new d4.a(eVar.hashCode(), ((Boolean) this.f22217i.get()).booleanValue()), this.f22214f);
    }

    /* JADX WARNING: type inference failed for: r0v15, types: [e4.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b4.a e(r4.e r11, android.graphics.Bitmap.Config r12, n4.c r13) {
        /*
            r10 = this;
            r4.a r13 = r10.c(r11)
            h4.a r6 = new h4.a
            r6.<init>(r13)
            c4.b r7 = r10.f(r11)
            h4.b r8 = new h4.b
            y2.o r0 = r10.f22218j
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r8.<init>(r7, r13, r0)
            y2.o r13 = r10.f22216h
            java.lang.Object r13 = r13.get()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 <= 0) goto L_0x0036
            e4.d r0 = new e4.d
            r0.<init>(r13)
            e4.b r12 = r10.g(r8, r12)
            goto L_0x0038
        L_0x0036:
            r0 = 0
            r12 = r0
        L_0x0038:
            y2.o r13 = r10.f22218j
            java.lang.Object r13 = r13.get()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0072
            e4.e r13 = new e4.e
            java.lang.String r1 = r11.e()
            g4.j r4 = new g4.j
            w4.d r11 = r10.f22213e
            y2.o r0 = r10.f22220l
            java.lang.Object r0 = r0.get()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r4.<init>(r11, r0)
            y2.o r11 = r10.f22219k
            java.lang.Object r11 = r11.get()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r5 = r11.booleanValue()
            r0 = r13
            r2 = r6
            r3 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0073
        L_0x0072:
            r13 = r0
        L_0x0073:
            c4.a r11 = new c4.a
            w4.d r1 = r10.f22213e
            y2.o r0 = r10.f22218j
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            r9 = 0
            r0 = r11
            r2 = r7
            r3 = r6
            r4 = r8
            r6 = r13
            r7 = r12
            r8 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            f3.c r12 = r10.f22212d
            java.util.concurrent.ScheduledExecutorService r13 = r10.f22210b
            b4.b r11 = b4.c.q(r11, r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.d.e(r4.e, android.graphics.Bitmap$Config, n4.c):b4.a");
    }

    private c4.b f(e eVar) {
        int intValue = ((Integer) this.f22215g.get()).intValue();
        if (intValue == 1) {
            return new d4.b(d(eVar), true);
        }
        if (intValue == 2) {
            return new d4.b(d(eVar), false);
        }
        if (intValue != 3) {
            return new d4.d();
        }
        return new d4.c();
    }

    private e4.b g(c4.c cVar, Bitmap.Config config) {
        w4.d dVar = this.f22213e;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return new e4.c(dVar, cVar, config, this.f22211c);
    }

    public boolean a(e5.e eVar) {
        return eVar instanceof e5.c;
    }

    public Drawable b(e5.e eVar) {
        Bitmap.Config config;
        e5.c cVar = (e5.c) eVar;
        r4.c C = cVar.C();
        e eVar2 = (e) l.g(cVar.E());
        if (C != null) {
            config = C.d();
        } else {
            config = null;
        }
        b4.a e10 = e(eVar2, config, (n4.c) null);
        if (((Boolean) this.f22221m.get()).booleanValue()) {
            return new f(e10);
        }
        return new i4.b(e10);
    }
}

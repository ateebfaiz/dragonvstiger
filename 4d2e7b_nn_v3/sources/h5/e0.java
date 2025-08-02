package h5;

import b3.a;
import b3.i;
import b3.l;
import com.facebook.imagepipeline.memory.AshmemMemoryChunkPool;
import com.facebook.imagepipeline.memory.BufferMemoryChunkPool;
import com.facebook.imagepipeline.memory.NativeMemoryChunkPool;
import com.facebook.imagepipeline.memory.d;
import com.facebook.imagepipeline.memory.e;
import com.facebook.imagepipeline.memory.f;
import java.lang.reflect.InvocationTargetException;
import z4.p;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f21932a;

    /* renamed from: b  reason: collision with root package name */
    private f f21933b;

    /* renamed from: c  reason: collision with root package name */
    private i f21934c;

    /* renamed from: d  reason: collision with root package name */
    private f f21935d;

    /* renamed from: e  reason: collision with root package name */
    private d f21936e;

    /* renamed from: f  reason: collision with root package name */
    private f f21937f;

    /* renamed from: g  reason: collision with root package name */
    private i f21938g;

    /* renamed from: h  reason: collision with root package name */
    private l f21939h;

    /* renamed from: i  reason: collision with root package name */
    private a f21940i;

    public e0(c0 c0Var) {
        this.f21932a = (c0) y2.l.g(c0Var);
    }

    private f a() {
        if (this.f21933b == null) {
            try {
                this.f21933b = AshmemMemoryChunkPool.class.getConstructor(new Class[]{b3.d.class, f0.class, g0.class}).newInstance(new Object[]{this.f21932a.i(), this.f21932a.g(), this.f21932a.h()});
            } catch (ClassNotFoundException unused) {
                this.f21933b = null;
            } catch (IllegalAccessException unused2) {
                this.f21933b = null;
            } catch (InstantiationException unused3) {
                this.f21933b = null;
            } catch (NoSuchMethodException unused4) {
                this.f21933b = null;
            } catch (InvocationTargetException unused5) {
                this.f21933b = null;
            }
        }
        return this.f21933b;
    }

    private f f(int i10) {
        if (i10 == 0) {
            return g();
        }
        if (i10 == 1) {
            return c();
        }
        if (i10 == 2) {
            return a();
        }
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h5.i b() {
        /*
            r5 = this;
            h5.i r0 = r5.f21934c
            if (r0 != 0) goto L_0x00c5
            h5.c0 r0 = r5.f21932a
            java.lang.String r0 = r0.e()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1868884870: goto L_0x003d;
                case -1106578487: goto L_0x0033;
                case -404562712: goto L_0x0029;
                case -402149703: goto L_0x001f;
                case 95945896: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0047
        L_0x0015:
            java.lang.String r1 = "dummy"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0047
            r0 = 0
            goto L_0x0048
        L_0x001f:
            java.lang.String r1 = "dummy_with_tracking"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0047
            r0 = r4
            goto L_0x0048
        L_0x0029:
            java.lang.String r1 = "experimental"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0047
            r0 = r3
            goto L_0x0048
        L_0x0033:
            java.lang.String r1 = "legacy"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0047
            r0 = 4
            goto L_0x0048
        L_0x003d:
            java.lang.String r1 = "legacy_default_params"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0047
            r0 = r2
            goto L_0x0048
        L_0x0047:
            r0 = -1
        L_0x0048:
            if (r0 == 0) goto L_0x00be
            if (r0 == r4) goto L_0x00b6
            if (r0 == r3) goto L_0x008e
            if (r0 == r2) goto L_0x0070
            com.facebook.imagepipeline.memory.c r0 = new com.facebook.imagepipeline.memory.c
            h5.c0 r1 = r5.f21932a
            b3.d r1 = r1.i()
            h5.c0 r2 = r5.f21932a
            h5.f0 r2 = r2.c()
            h5.c0 r3 = r5.f21932a
            h5.g0 r3 = r3.d()
            h5.c0 r4 = r5.f21932a
            boolean r4 = r4.l()
            r0.<init>(r1, r2, r3, r4)
            r5.f21934c = r0
            goto L_0x00c5
        L_0x0070:
            com.facebook.imagepipeline.memory.c r0 = new com.facebook.imagepipeline.memory.c
            h5.c0 r1 = r5.f21932a
            b3.d r1 = r1.i()
            h5.f0 r2 = h5.n.a()
            h5.c0 r3 = r5.f21932a
            h5.g0 r3 = r3.d()
            h5.c0 r4 = r5.f21932a
            boolean r4 = r4.l()
            r0.<init>(r1, r2, r3, r4)
            r5.f21934c = r0
            goto L_0x00c5
        L_0x008e:
            h5.t r0 = new h5.t
            h5.c0 r1 = r5.f21932a
            int r1 = r1.b()
            h5.c0 r2 = r5.f21932a
            int r2 = r2.a()
            h5.z r3 = h5.z.h()
            h5.c0 r4 = r5.f21932a
            boolean r4 = r4.m()
            if (r4 == 0) goto L_0x00af
            h5.c0 r4 = r5.f21932a
            b3.d r4 = r4.i()
            goto L_0x00b0
        L_0x00af:
            r4 = 0
        L_0x00b0:
            r0.<init>(r1, r2, r3, r4)
            r5.f21934c = r0
            goto L_0x00c5
        L_0x00b6:
            h5.s r0 = new h5.s
            r0.<init>()
            r5.f21934c = r0
            goto L_0x00c5
        L_0x00be:
            h5.r r0 = new h5.r
            r0.<init>()
            r5.f21934c = r0
        L_0x00c5:
            h5.i r0 = r5.f21934c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.e0.b():h5.i");
    }

    public f c() {
        if (this.f21935d == null) {
            try {
                this.f21935d = BufferMemoryChunkPool.class.getConstructor(new Class[]{b3.d.class, f0.class, g0.class}).newInstance(new Object[]{this.f21932a.i(), this.f21932a.g(), this.f21932a.h()});
            } catch (ClassNotFoundException unused) {
                this.f21935d = null;
            } catch (IllegalAccessException unused2) {
                this.f21935d = null;
            } catch (InstantiationException unused3) {
                this.f21935d = null;
            } catch (NoSuchMethodException unused4) {
                this.f21935d = null;
            } catch (InvocationTargetException unused5) {
                this.f21935d = null;
            }
        }
        return this.f21935d;
    }

    public d d() {
        if (this.f21936e == null) {
            this.f21936e = new d(this.f21932a.i(), this.f21932a.f());
        }
        return this.f21936e;
    }

    public int e() {
        return this.f21932a.f().f21950g;
    }

    public f g() {
        if (this.f21937f == null) {
            try {
                this.f21937f = NativeMemoryChunkPool.class.getConstructor(new Class[]{b3.d.class, f0.class, g0.class}).newInstance(new Object[]{this.f21932a.i(), this.f21932a.g(), this.f21932a.h()});
            } catch (ClassNotFoundException e10) {
                z2.a.k("PoolFactory", "", e10);
                this.f21937f = null;
            } catch (IllegalAccessException e11) {
                z2.a.k("PoolFactory", "", e11);
                this.f21937f = null;
            } catch (InstantiationException e12) {
                z2.a.k("PoolFactory", "", e12);
                this.f21937f = null;
            } catch (NoSuchMethodException e13) {
                z2.a.k("PoolFactory", "", e13);
                this.f21937f = null;
            } catch (InvocationTargetException e14) {
                z2.a.k("PoolFactory", "", e14);
                this.f21937f = null;
            }
        }
        return this.f21937f;
    }

    public i h() {
        return i(p.a() ^ true ? 1 : 0);
    }

    public i i(int i10) {
        if (this.f21938g == null) {
            f f10 = f(i10);
            y2.l.h(f10, "failed to get pool for chunk type: " + i10);
            this.f21938g = new y(f10, j());
        }
        return this.f21938g;
    }

    public l j() {
        if (this.f21939h == null) {
            this.f21939h = new l(k());
        }
        return this.f21939h;
    }

    public a k() {
        if (this.f21940i == null) {
            this.f21940i = new e(this.f21932a.i(), this.f21932a.j(), this.f21932a.k());
        }
        return this.f21940i;
    }
}

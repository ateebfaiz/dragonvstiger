package t8;

import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import java.util.Arrays;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    protected final boolean f13090a;

    private static final class a extends k {

        /* renamed from: b  reason: collision with root package name */
        private final Class f13091b;

        /* renamed from: c  reason: collision with root package name */
        private final Class f13092c;

        /* renamed from: d  reason: collision with root package name */
        private final o f13093d;

        /* renamed from: e  reason: collision with root package name */
        private final o f13094e;

        public a(k kVar, Class cls, o oVar, Class cls2, o oVar2) {
            super(kVar);
            this.f13091b = cls;
            this.f13093d = oVar;
            this.f13092c = cls2;
            this.f13094e = oVar2;
        }

        public k i(Class cls, o oVar) {
            return new c(this, new f[]{new f(this.f13091b, this.f13093d), new f(this.f13092c, this.f13094e), new f(cls, oVar)});
        }

        public o j(Class cls) {
            if (cls == this.f13091b) {
                return this.f13093d;
            }
            if (cls == this.f13092c) {
                return this.f13094e;
            }
            return null;
        }
    }

    private static final class b extends k {

        /* renamed from: b  reason: collision with root package name */
        public static final b f13095b = new b(false);

        /* renamed from: c  reason: collision with root package name */
        public static final b f13096c = new b(true);

        protected b(boolean z10) {
            super(z10);
        }

        public k i(Class cls, o oVar) {
            return new e(this, cls, oVar);
        }

        public o j(Class cls) {
            return null;
        }
    }

    private static final class c extends k {

        /* renamed from: b  reason: collision with root package name */
        private final f[] f13097b;

        public c(k kVar, f[] fVarArr) {
            super(kVar);
            this.f13097b = fVarArr;
        }

        public k i(Class cls, o oVar) {
            f[] fVarArr = this.f13097b;
            int length = fVarArr.length;
            if (length != 8) {
                f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
                fVarArr2[length] = new f(cls, oVar);
                return new c(this, fVarArr2);
            } else if (this.f13090a) {
                return new e(this, cls, oVar);
            } else {
                return this;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
            r1 = r0[6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            if (r1.f13102a != r4) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            return r1.f13103b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            r1 = r0[5];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            if (r1.f13102a != r4) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
            return r1.f13103b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
            r1 = r0[4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
            if (r1.f13102a != r4) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
            return r1.f13103b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
            r0 = r0[3];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0052, code lost:
            if (r0.f13102a != r4) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0056, code lost:
            return r0.f13103b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.fasterxml.jackson.databind.o j(java.lang.Class r4) {
            /*
                r3 = this;
                t8.k$f[] r0 = r3.f13097b
                r1 = 0
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x000c
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x000c:
                r1 = 1
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x0016
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x0016:
                r1 = 2
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x0020
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x0020:
                int r1 = r0.length
                switch(r1) {
                    case 4: goto L_0x004d;
                    case 5: goto L_0x0043;
                    case 6: goto L_0x0039;
                    case 7: goto L_0x002f;
                    case 8: goto L_0x0025;
                    default: goto L_0x0024;
                }
            L_0x0024:
                goto L_0x0057
            L_0x0025:
                r1 = 7
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x002f
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x002f:
                r1 = 6
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x0039
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x0039:
                r1 = 5
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x0043
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x0043:
                r1 = 4
                r1 = r0[r1]
                java.lang.Class r2 = r1.f13102a
                if (r2 != r4) goto L_0x004d
                com.fasterxml.jackson.databind.o r4 = r1.f13103b
                return r4
            L_0x004d:
                r1 = 3
                r0 = r0[r1]
                java.lang.Class r1 = r0.f13102a
                if (r1 != r4) goto L_0x0057
                com.fasterxml.jackson.databind.o r4 = r0.f13103b
                return r4
            L_0x0057:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: t8.k.c.j(java.lang.Class):com.fasterxml.jackson.databind.o");
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final o f13098a;

        /* renamed from: b  reason: collision with root package name */
        public final k f13099b;

        public d(o oVar, k kVar) {
            this.f13098a = oVar;
            this.f13099b = kVar;
        }
    }

    private static final class e extends k {

        /* renamed from: b  reason: collision with root package name */
        private final Class f13100b;

        /* renamed from: c  reason: collision with root package name */
        private final o f13101c;

        public e(k kVar, Class cls, o oVar) {
            super(kVar);
            this.f13100b = cls;
            this.f13101c = oVar;
        }

        public k i(Class cls, o oVar) {
            return new a(this, this.f13100b, this.f13101c, cls, oVar);
        }

        public o j(Class cls) {
            if (cls == this.f13100b) {
                return this.f13101c;
            }
            return null;
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final Class f13102a;

        /* renamed from: b  reason: collision with root package name */
        public final o f13103b;

        public f(Class cls, o oVar) {
            this.f13102a = cls;
            this.f13103b = oVar;
        }
    }

    protected k(boolean z10) {
        this.f13090a = z10;
    }

    public static k c() {
        return b.f13095b;
    }

    public final d a(j jVar, o oVar) {
        return new d(oVar, i(jVar.s(), oVar));
    }

    public final d b(Class cls, o oVar) {
        return new d(oVar, i(cls, oVar));
    }

    public final d d(Class cls, b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        o B = b0Var.B(cls, dVar);
        return new d(B, i(cls, B));
    }

    public final d e(j jVar, b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        o F = b0Var.F(jVar, dVar);
        return new d(F, i(jVar.s(), F));
    }

    public final d f(Class cls, b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        o G = b0Var.G(cls, dVar);
        return new d(G, i(cls, G));
    }

    public final d g(j jVar, b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        o y10 = b0Var.y(jVar, dVar);
        return new d(y10, i(jVar.s(), y10));
    }

    public final d h(Class cls, b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        o z10 = b0Var.z(cls, dVar);
        return new d(z10, i(cls, z10));
    }

    public abstract k i(Class cls, o oVar);

    public abstract o j(Class cls);

    protected k(k kVar) {
        this.f13090a = kVar.f13090a;
    }
}

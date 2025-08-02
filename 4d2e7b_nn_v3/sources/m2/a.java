package m2;

import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0304a f22485d = new C0304a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private int f22486a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f22487b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f22488c;

    /* renamed from: m2.a$a  reason: collision with other inner class name */
    public static final class C0304a {
        private C0304a() {
        }

        /* access modifiers changed from: private */
        public final int b(int[] iArr) {
            if (iArr.length != 0) {
                int i10 = iArr[0];
                int z10 = j.z(iArr);
                int i11 = 1;
                if (1 <= z10) {
                    while (true) {
                        i10 *= iArr[i11];
                        if (i11 == z10) {
                            break;
                        }
                        i11++;
                    }
                }
                return i10;
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }

        public /* synthetic */ C0304a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int[] iArr) {
        m.f(iArr, "shape");
        this.f22488c = iArr;
        int a10 = f22485d.b(iArr);
        this.f22486a = a10;
        this.f22487b = new float[a10];
    }

    public final float[] a() {
        return this.f22487b;
    }

    public final int b(int i10) {
        return this.f22488c[i10];
    }

    public final int c() {
        return this.f22488c.length;
    }

    public final void d(int[] iArr) {
        m.f(iArr, "shape");
        this.f22488c = iArr;
        int a10 = f22485d.b(iArr);
        float[] fArr = new float[a10];
        System.arraycopy(this.f22487b, 0, fArr, 0, Math.min(this.f22486a, a10));
        this.f22487b = fArr;
        this.f22486a = a10;
    }
}

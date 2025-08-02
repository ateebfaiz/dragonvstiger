package u4;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0341a f24343a = new C0341a((DefaultConstructorMarker) null);

    /* renamed from: u4.a$a  reason: collision with other inner class name */
    public static final class C0341a {
        private C0341a() {
        }

        public /* synthetic */ C0341a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(int[] iArr) {
        m.f(iArr, "frameDurationMs");
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (iArr[i10] < 11) {
                iArr[i10] = 100;
            }
        }
    }

    public final int[] b(int[] iArr) {
        m.f(iArr, "frameDurationsMs");
        int[] iArr2 = new int[iArr.length];
        int length = iArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = i10;
            i10 += iArr[i11];
        }
        return iArr2;
    }

    public final int c(int[] iArr) {
        m.f(iArr, "frameDurationMs");
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        return i10;
    }
}

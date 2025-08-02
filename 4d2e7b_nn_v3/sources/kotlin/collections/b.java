package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class b implements Iterator, wb.a {

    /* renamed from: a  reason: collision with root package name */
    private v0 f626a = v0.NotReady;

    /* renamed from: b  reason: collision with root package name */
    private Object f627b;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f628a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlin.collections.v0[] r0 = kotlin.collections.v0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.collections.v0 r1 = kotlin.collections.v0.Done     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.collections.v0 r1 = kotlin.collections.v0.Ready     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f628a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.b.a.<clinit>():void");
        }
    }

    private final boolean e() {
        this.f626a = v0.Failed;
        a();
        if (this.f626a == v0.Ready) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final void c() {
        this.f626a = v0.Done;
    }

    /* access modifiers changed from: protected */
    public final void d(Object obj) {
        this.f627b = obj;
        this.f626a = v0.Ready;
    }

    public boolean hasNext() {
        v0 v0Var = this.f626a;
        if (v0Var != v0.Failed) {
            int i10 = a.f628a[v0Var.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 != 2) {
                return e();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object next() {
        if (hasNext()) {
            this.f626a = v0.NotReady;
            return this.f627b;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

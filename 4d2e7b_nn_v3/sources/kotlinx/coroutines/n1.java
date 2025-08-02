package kotlinx.coroutines;

import cc.l;

public abstract class n1 extends y {
    public abstract n1 G();

    /* access modifiers changed from: protected */
    public final String H() {
        n1 n1Var;
        n1 c10 = l0.c();
        if (this == c10) {
            return "Dispatchers.Main";
        }
        try {
            n1Var = c10.G();
        } catch (UnsupportedOperationException unused) {
            n1Var = null;
        }
        if (this == n1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public y limitedParallelism(int i10) {
        l.a(i10);
        return this;
    }
}

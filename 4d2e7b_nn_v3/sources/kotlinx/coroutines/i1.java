package kotlinx.coroutines;

public class i1 extends JobSupport implements q {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1091a = I0();

    public i1(f1 f1Var) {
        super(true);
        f0(f1Var);
    }

    private final boolean I0() {
        n nVar;
        JobSupport t10;
        n nVar2;
        m b02 = b0();
        if (b02 instanceof n) {
            nVar = (n) b02;
        } else {
            nVar = null;
        }
        if (!(nVar == null || (t10 = nVar.t()) == null)) {
            while (!t10.Y()) {
                m b03 = t10.b0();
                if (b03 instanceof n) {
                    nVar2 = (n) b03;
                } else {
                    nVar2 = null;
                }
                if (nVar2 != null) {
                    t10 = nVar2.t();
                    if (t10 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean Y() {
        return this.f1091a;
    }

    public boolean Z() {
        return true;
    }
}

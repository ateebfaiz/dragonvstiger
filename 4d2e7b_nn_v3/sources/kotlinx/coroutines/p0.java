package kotlinx.coroutines;

final class p0 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1109a;

    public p0(boolean z10) {
        this.f1109a = z10;
    }

    public boolean a() {
        return this.f1109a;
    }

    public o1 c() {
        return null;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        if (a()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb2.append(str);
        sb2.append('}');
        return sb2.toString();
    }
}

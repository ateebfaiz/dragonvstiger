package j8;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    protected int f12418a;

    protected h(int i10) {
        this.f12418a = i10;
    }

    public static h a(g[] gVarArr) {
        if (gVarArr.length <= 31) {
            int i10 = 0;
            for (g gVar : gVarArr) {
                if (gVar.a()) {
                    i10 |= gVar.b();
                }
            }
            return new h(i10);
        }
        throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{gVarArr[0].getClass().getName(), Integer.valueOf(gVarArr.length)}));
    }

    public h b(g gVar) {
        int b10 = gVar.b() | this.f12418a;
        if (b10 == this.f12418a) {
            return this;
        }
        return new h(b10);
    }
}

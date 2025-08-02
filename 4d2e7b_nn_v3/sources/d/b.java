package d;

public enum b {
    ADDRESS_TYPE_SOURCE(0, "source"),
    ADDRESS_TYPE_PROXY_HANDSHAKE(1, "proxy handshake"),
    ADDRESS_TYPE_PROXY_NORMAL(2, "proxy normal");
    

    /* renamed from: a  reason: collision with root package name */
    public final int f20988a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20989b;

    /* access modifiers changed from: public */
    b(int i10, String str) {
        this.f20988a = i10;
        this.f20989b = str;
    }

    public static b a(int i10) {
        for (b bVar : values()) {
            if (bVar.f20988a == i10) {
                return bVar;
            }
        }
        throw new IllegalArgumentException(Integer.toString(i10));
    }
}

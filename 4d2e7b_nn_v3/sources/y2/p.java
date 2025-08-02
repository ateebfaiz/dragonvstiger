package y2;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f24880a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final o f24881b = new c();

    class a implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f24882a;

        a(Object obj) {
            this.f24882a = obj;
        }

        public Object get() {
            return this.f24882a;
        }
    }

    class b implements o {
        b() {
        }

        /* renamed from: a */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    class c implements o {
        c() {
        }

        /* renamed from: a */
        public Boolean get() {
            return Boolean.FALSE;
        }
    }

    public static o a(Object obj) {
        return new a(obj);
    }
}

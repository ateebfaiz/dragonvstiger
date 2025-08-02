package i3;

import y2.o;

public abstract class d {

    class a implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f22071a;

        a(Throwable th) {
            this.f22071a = th;
        }

        /* renamed from: a */
        public c get() {
            return d.b(this.f22071a);
        }
    }

    public static o a(Throwable th) {
        return new a(th);
    }

    public static c b(Throwable th) {
        i v10 = i.v();
        v10.n(th);
        return v10;
    }
}

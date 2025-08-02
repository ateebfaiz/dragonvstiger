package q;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArrayList f23132a = new CopyOnWriteArrayList();

    /* renamed from: q.a$a  reason: collision with other inner class name */
    public static class C0320a {

        /* renamed from: a  reason: collision with root package name */
        public final String f23133a;

        /* renamed from: b  reason: collision with root package name */
        public final long f23134b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23135c;

        public C0320a(String str, long j10, long j11) {
            this.f23133a = str;
            this.f23134b = j10;
            this.f23135c = j11;
        }
    }

    public static void a(String str, long j10, long j11) {
        f23132a.add(new C0320a(str, j10, j11));
    }
}

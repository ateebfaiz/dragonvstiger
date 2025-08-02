package q4;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.l;
import q4.c;
import y2.q;

public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final b f23233d = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Lazy f23234e = i.a(l.SYNCHRONIZED, a.f23238a);

    /* renamed from: a  reason: collision with root package name */
    private int f23235a;

    /* renamed from: b  reason: collision with root package name */
    private List f23236b;

    /* renamed from: c  reason: collision with root package name */
    private final a f23237c;

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f23238a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final d invoke() {
            return new d((DefaultConstructorMarker) null);
        }
    }

    public static final class b {
        private b() {
        }

        /* access modifiers changed from: private */
        public final int e(int i10, InputStream inputStream, byte[] bArr) {
            if (bArr.length < i10) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!inputStream.markSupported()) {
                return y2.a.b(inputStream, bArr, 0, i10);
            } else {
                try {
                    inputStream.mark(i10);
                    return y2.a.b(inputStream, bArr, 0, i10);
                } finally {
                    inputStream.reset();
                }
            }
        }

        public final c b(InputStream inputStream) {
            m.f(inputStream, "is");
            return d().b(inputStream);
        }

        public final c c(InputStream inputStream) {
            m.f(inputStream, "is");
            try {
                return b(inputStream);
            } catch (IOException e10) {
                RuntimeException a10 = q.a(e10);
                m.e(a10, "propagate(ioe)");
                throw a10;
            }
        }

        public final d d() {
            return (d) d.f23234e.getValue();
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final c c(InputStream inputStream) {
        return f23233d.c(inputStream);
    }

    private final void d() {
        this.f23235a = this.f23237c.a();
        List<c.b> list = this.f23236b;
        if (list != null) {
            m.c(list);
            for (c.b a10 : list) {
                this.f23235a = Math.max(this.f23235a, a10.a());
            }
        }
    }

    public final c b(InputStream inputStream) {
        m.f(inputStream, "is");
        int i10 = this.f23235a;
        byte[] bArr = new byte[i10];
        int a10 = f23233d.e(i10, inputStream, bArr);
        c b10 = this.f23237c.b(bArr, a10);
        if (b10 != c.f23230d) {
            return b10;
        }
        List<c.b> list = this.f23236b;
        if (list != null) {
            for (c.b b11 : list) {
                c b12 = b11.b(bArr, a10);
                if (b12 != c.f23230d) {
                    return b12;
                }
            }
        }
        return c.f23230d;
    }

    private d() {
        this.f23237c = new a();
        d();
    }
}

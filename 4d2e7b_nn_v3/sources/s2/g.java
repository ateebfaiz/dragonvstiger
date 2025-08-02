package s2;

import android.content.Context;
import java.io.File;
import r2.c;
import r2.h;
import y2.l;
import y2.o;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f23776a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23777b;

    /* renamed from: c  reason: collision with root package name */
    private final o f23778c;

    /* renamed from: d  reason: collision with root package name */
    private final long f23779d;

    /* renamed from: e  reason: collision with root package name */
    private final long f23780e;

    /* renamed from: f  reason: collision with root package name */
    private final long f23781f;

    /* renamed from: g  reason: collision with root package name */
    private final m f23782g;

    /* renamed from: h  reason: collision with root package name */
    private final r2.a f23783h;

    /* renamed from: i  reason: collision with root package name */
    private final c f23784i;

    /* renamed from: j  reason: collision with root package name */
    private final v2.b f23785j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Context f23786k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f23787l;

    class a implements o {
        a() {
        }

        /* renamed from: a */
        public File get() {
            l.g(g.this.f23786k);
            return g.this.f23786k.getApplicationContext().getCacheDir();
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f23789a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f23790b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public o f23791c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public long f23792d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public long f23793e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f23794f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public m f23795g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public r2.a f23796h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public c f23797i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public v2.b f23798j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f23799k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public final Context f23800l;

        public g n() {
            return new g(this);
        }

        private b(Context context) {
            this.f23789a = 1;
            this.f23790b = "image_cache";
            this.f23792d = 41943040;
            this.f23793e = 10485760;
            this.f23794f = 2097152;
            this.f23795g = new f();
            this.f23800l = context;
        }
    }

    protected g(b bVar) {
        boolean z10;
        r2.a aVar;
        c cVar;
        v2.b bVar2;
        Context e10 = bVar.f23800l;
        this.f23786k = e10;
        if (bVar.f23791c == null && e10 == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        l.j(z10, "Either a non-null context or a base directory path or supplier must be provided.");
        if (bVar.f23791c == null && e10 != null) {
            bVar.f23791c = new a();
        }
        this.f23776a = bVar.f23789a;
        this.f23777b = (String) l.g(bVar.f23790b);
        this.f23778c = (o) l.g(bVar.f23791c);
        this.f23779d = bVar.f23792d;
        this.f23780e = bVar.f23793e;
        this.f23781f = bVar.f23794f;
        this.f23782g = (m) l.g(bVar.f23795g);
        if (bVar.f23796h == null) {
            aVar = r2.g.b();
        } else {
            aVar = bVar.f23796h;
        }
        this.f23783h = aVar;
        if (bVar.f23797i == null) {
            cVar = h.i();
        } else {
            cVar = bVar.f23797i;
        }
        this.f23784i = cVar;
        if (bVar.f23798j == null) {
            bVar2 = v2.c.b();
        } else {
            bVar2 = bVar.f23798j;
        }
        this.f23785j = bVar2;
        this.f23787l = bVar.f23799k;
    }

    public static b m(Context context) {
        return new b(context);
    }

    public String b() {
        return this.f23777b;
    }

    public o c() {
        return this.f23778c;
    }

    public r2.a d() {
        return this.f23783h;
    }

    public c e() {
        return this.f23784i;
    }

    public long f() {
        return this.f23779d;
    }

    public v2.b g() {
        return this.f23785j;
    }

    public m h() {
        return this.f23782g;
    }

    public boolean i() {
        return this.f23787l;
    }

    public long j() {
        return this.f23780e;
    }

    public long k() {
        return this.f23781f;
    }

    public int l() {
        return this.f23776a;
    }
}

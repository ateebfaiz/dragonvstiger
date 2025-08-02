package a1;

import a1.b;
import a1.p;
import a1.v;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class n implements Comparable {
    private boolean C;
    private r X;
    private b.a Y;
    private b Z;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v.a f13621a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13622b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13623c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13624d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f13625e;

    /* renamed from: f  reason: collision with root package name */
    private p.a f13626f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f13627g;

    /* renamed from: h  reason: collision with root package name */
    private o f13628h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13629i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13630j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13631w;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13632a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f13633b;

        a(String str, long j10) {
            this.f13632a = str;
            this.f13633b = j10;
        }

        public void run() {
            n.this.f13621a.a(this.f13632a, this.f13633b);
            n.this.f13621a.b(toString());
        }
    }

    interface b {
        void a(n nVar);

        void b(n nVar, p pVar);
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public n(int i10, String str, p.a aVar) {
        v.a aVar2;
        if (v.a.f13658c) {
            aVar2 = new v.a();
        } else {
            aVar2 = null;
        }
        this.f13621a = aVar2;
        this.f13625e = new Object();
        this.f13629i = true;
        this.f13630j = false;
        this.f13631w = false;
        this.C = false;
        this.Y = null;
        this.f13622b = i10;
        this.f13623c = str;
        this.f13626f = aVar;
        D(new e());
        this.f13624d = f(str);
    }

    private static int f(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public n A(b.a aVar) {
        this.Y = aVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void B(b bVar) {
        synchronized (this.f13625e) {
            this.Z = bVar;
        }
    }

    public n C(o oVar) {
        this.f13628h = oVar;
        return this;
    }

    public n D(r rVar) {
        this.X = rVar;
        return this;
    }

    public final n E(int i10) {
        this.f13627g = Integer.valueOf(i10);
        return this;
    }

    public final boolean F() {
        return this.f13629i;
    }

    public final boolean G() {
        return this.C;
    }

    public void b(String str) {
        if (v.a.f13658c) {
            this.f13621a.a(str, Thread.currentThread().getId());
        }
    }

    /* renamed from: c */
    public int compareTo(n nVar) {
        c o10 = o();
        c o11 = nVar.o();
        if (o10 == o11) {
            return this.f13627g.intValue() - nVar.f13627g.intValue();
        }
        return o11.ordinal() - o10.ordinal();
    }

    public void d(u uVar) {
        p.a aVar;
        synchronized (this.f13625e) {
            aVar = this.f13626f;
        }
        if (aVar != null) {
            aVar.a(uVar);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void e(Object obj);

    /* access modifiers changed from: package-private */
    public void g(String str) {
        o oVar = this.f13628h;
        if (oVar != null) {
            oVar.b(this);
        }
        if (v.a.f13658c) {
            long id2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id2));
                return;
            }
            this.f13621a.a(str, id2);
            this.f13621a.b(toString());
        }
    }

    public abstract byte[] h();

    public abstract String i();

    public b.a j() {
        return this.Y;
    }

    public String k() {
        return s();
    }

    public Map l() {
        return Collections.emptyMap();
    }

    public int m() {
        return this.f13622b;
    }

    public abstract byte[] n();

    public c o() {
        return c.NORMAL;
    }

    public r p() {
        return this.X;
    }

    public final int q() {
        return this.X.a();
    }

    public int r() {
        return this.f13624d;
    }

    public String s() {
        return this.f13623c;
    }

    public boolean t() {
        boolean z10;
        synchronized (this.f13625e) {
            z10 = this.f13631w;
        }
        return z10;
    }

    public String toString() {
        String str;
        String str2 = "0x" + Integer.toHexString(r());
        StringBuilder sb2 = new StringBuilder();
        if (this.f13630j) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb2.append(str);
        sb2.append(s());
        sb2.append(" ");
        sb2.append(str2);
        sb2.append(" ");
        sb2.append(o());
        sb2.append(" ");
        sb2.append(this.f13627g);
        return sb2.toString();
    }

    public boolean u() {
        boolean z10;
        synchronized (this.f13625e) {
            z10 = this.f13630j;
        }
        return z10;
    }

    public void v() {
        synchronized (this.f13625e) {
            this.f13631w = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        b bVar;
        synchronized (this.f13625e) {
            bVar = this.Z;
        }
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void x(p pVar) {
        b bVar;
        synchronized (this.f13625e) {
            bVar = this.Z;
        }
        if (bVar != null) {
            bVar.b(this, pVar);
        }
    }

    /* access modifiers changed from: protected */
    public u y(u uVar) {
        return uVar;
    }

    /* access modifiers changed from: protected */
    public abstract p z(k kVar);
}

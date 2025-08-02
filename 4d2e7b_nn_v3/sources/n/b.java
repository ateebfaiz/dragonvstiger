package n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import g.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import n.d;
import w.d;

public class b implements l.b {

    /* renamed from: m  reason: collision with root package name */
    public static final String f22628m = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public int f22629a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f22630b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f22631c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final Map f22632d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final StringBuilder f22633e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    public int f22634f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22635g = true;

    /* renamed from: h  reason: collision with root package name */
    public Handler f22636h;

    /* renamed from: i  reason: collision with root package name */
    public String f22637i = "";

    /* renamed from: j  reason: collision with root package name */
    public c f22638j;

    /* renamed from: k  reason: collision with root package name */
    public a f22639k;

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f22640l = new AtomicBoolean(false);

    /* renamed from: n.b$b  reason: collision with other inner class name */
    public class C0309b implements Handler.Callback {
        public C0309b(a aVar) {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                b.this.l((String) message.obj);
            } else if (i10 == 1) {
                b.this.t((String) message.obj);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    b.this.s();
                }
            } else if (b.this.f22635g) {
                b bVar = b.this;
                if (bVar.f22634f > 0) {
                    bVar.q();
                }
            }
            return true;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f22642a = new b();
    }

    public static boolean f(int i10, int i11, int i12) {
        if (i10 == 0) {
            return false;
        }
        if (i12 < 0 || i12 > i11) {
            return true;
        }
        return false;
    }

    public static boolean g(String str, Map map) {
        try {
            String[] split = str.split("\t");
            if (!i(split)) {
                for (Map.Entry value : map.entrySet()) {
                    if (((d.a) value.getValue()).d(split)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean i(String[] strArr) {
        for (Map.Entry value : d.f22658b.entrySet()) {
            if (((d.a) value.getValue()).d(strArr)) {
                return true;
            }
        }
        return false;
    }

    public static Map j(String[] strArr) {
        HashMap hashMap = new HashMap(d.f22657a);
        if (strArr != null && strArr.length > 0) {
            for (String remove : strArr) {
                hashMap.remove(remove);
            }
        }
        return hashMap;
    }

    public static b k() {
        return c.f22642a;
    }

    public void a(l.c cVar) {
        Message obtainMessage = this.f22636h.obtainMessage(0);
        obtainMessage.obj = cVar.f22343a;
        this.f22636h.sendMessage(obtainMessage);
    }

    public final void b(int i10) {
        int i11 = this.f22631c + i10;
        this.f22631c = i11;
        int i12 = this.f22629a;
        if (i12 != -1) {
            int i13 = i12 - i11;
            if (i13 <= 0) {
                this.f22635g = false;
            } else if (i13 < this.f22630b) {
                this.f22630b = i13;
            }
        }
    }

    public final void c(String str) {
        this.f22634f++;
        StringBuilder sb2 = this.f22633e;
        sb2.append(str);
        sb2.append("\n");
        this.f22639k.c(str + "\n");
        if (this.f22634f >= this.f22630b) {
            q();
        }
    }

    public void d(String str, Context context, d.c cVar) {
        if (this.f22640l.compareAndSet(false, true)) {
            this.f22636h = new l("AbnormalAccessLog-Dispatcher", new C0309b((a) null)).f21566b;
            this.f22638j = new c(context, cVar);
            this.f22639k = new a(cVar.j());
            l.a.a().c(this);
            t(str);
            this.f22636h.sendEmptyMessage(3);
        }
    }

    public final void l(String str) {
        if (this.f22635g && g(str, this.f22632d)) {
            c(str);
        }
    }

    public final void n(String str) {
        String[] strArr;
        String[] split = str.split(DomExceptionUtils.SEPARATOR);
        this.f22630b = Integer.parseInt(split[0]);
        this.f22629a = Integer.parseInt(split[1]);
        if (split.length <= 2 || TextUtils.isEmpty(split[2])) {
            strArr = null;
        } else {
            strArr = split[2].split(",");
        }
        this.f22635g = f(this.f22630b, this.f22631c, this.f22629a);
        this.f22632d.clear();
        this.f22632d.putAll(j(strArr));
    }

    public void o() {
        if (this.f22640l.get()) {
            this.f22636h.obtainMessage(2).sendToTarget();
        }
    }

    public final void q() {
        this.f22638j.b(this.f22633e.toString(), false);
        b(this.f22634f);
        u();
    }

    public void r(String str) {
        if (this.f22640l.get()) {
            this.f22636h.obtainMessage(1, str).sendToTarget();
        }
    }

    public final void s() {
        String d10 = this.f22639k.d();
        if (!TextUtils.isEmpty(d10)) {
            this.f22638j.b(d10, true);
            this.f22639k.a();
        }
    }

    public final void t(String str) {
        if (!this.f22637i.equals(str)) {
            this.f22637i = str;
            n(str);
        }
    }

    public final void u() {
        this.f22634f = 0;
        StringBuilder sb2 = this.f22633e;
        sb2.delete(0, sb2.length());
        this.f22639k.a();
    }
}

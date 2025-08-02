package c1;

import com.bugsnag.android.c3;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.ranges.l;
import kotlin.t;

public final class m implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Map f17260a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f17261b;

    /* renamed from: c  reason: collision with root package name */
    private int f17262c;

    /* renamed from: d  reason: collision with root package name */
    private int f17263d;

    /* renamed from: e  reason: collision with root package name */
    private int f17264e;

    /* renamed from: f  reason: collision with root package name */
    private int f17265f;

    public m() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    private final Map g() {
        Integer num;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f17261b);
        c3 c3Var = c3.f18655a;
        Map a10 = c3Var.a();
        if (!(a10 == null || (num = (Integer) a10.get("ndkOnError")) == null)) {
            hashMap.put("ndkOnError", num);
        }
        Map b10 = c3Var.b();
        if (b10 != null) {
            hashMap.putAll(b10);
        }
        return hashMap;
    }

    private final void h(String str, int i10) {
        int i11;
        Integer num = (Integer) this.f17261b.get(str);
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.intValue();
        }
        this.f17261b.put(str, Integer.valueOf(l.c(i11 + i10, 0)));
    }

    public void a(Map map) {
        this.f17260a.clear();
        this.f17260a.putAll(map);
        c3.f18655a.h(i0.d(t.a("config", this.f17260a)));
    }

    public void b(String str) {
        h(str, 1);
        c3.f18655a.e(str);
    }

    public void c(int i10, int i11) {
        this.f17264e = i10;
        this.f17265f = i11;
    }

    public Map d() {
        Pair pair;
        Pair pair2;
        Pair pair3;
        Pair pair4;
        Pair pair5;
        Pair pair6;
        Map g10 = g();
        int i10 = this.f17262c;
        Pair pair7 = null;
        if (i10 > 0) {
            pair = t.a("stringsTruncated", Integer.valueOf(i10));
        } else {
            pair = null;
        }
        int i11 = this.f17263d;
        if (i11 > 0) {
            pair2 = t.a("stringCharsTruncated", Integer.valueOf(i11));
        } else {
            pair2 = null;
        }
        int i12 = this.f17264e;
        if (i12 > 0) {
            pair3 = t.a("breadcrumbsRemoved", Integer.valueOf(i12));
        } else {
            pair3 = null;
        }
        int i13 = this.f17265f;
        if (i13 > 0) {
            pair4 = t.a("breadcrumbBytesRemoved", Integer.valueOf(i13));
        } else {
            pair4 = null;
        }
        Map n10 = i0.n(r.p(pair, pair2, pair3, pair4));
        if (!this.f17260a.isEmpty()) {
            pair5 = t.a("config", this.f17260a);
        } else {
            pair5 = null;
        }
        if (!g10.isEmpty()) {
            pair6 = t.a("callbacks", g10);
        } else {
            pair6 = null;
        }
        if (!n10.isEmpty()) {
            pair7 = t.a("system", n10);
        }
        return i0.n(r.p(pair5, pair6, pair7));
    }

    public void e(Map map) {
        this.f17261b.clear();
        this.f17261b.putAll(map);
        c3.f18655a.d(map);
    }

    public void f(int i10, int i11) {
        this.f17262c = i10;
        this.f17263d = i11;
    }

    public m(Map map) {
        if (map != null) {
            Map d10 = c0.d(map.get("config"));
            this.f17260a = d10 == null ? new HashMap() : d10;
            Map d11 = c0.d(map.get("callbacks"));
            this.f17261b = d11 == null ? new HashMap() : d11;
            Map d12 = c0.d(map.get("system"));
            if (d12 != null) {
                Number number = (Number) d12.get("stringsTruncated");
                int i10 = 0;
                this.f17262c = number == null ? 0 : number.intValue();
                Number number2 = (Number) d12.get("stringCharsTruncated");
                this.f17263d = number2 == null ? 0 : number2.intValue();
                Number number3 = (Number) d12.get("breadcrumbsRemovedCount");
                this.f17264e = number3 == null ? 0 : number3.intValue();
                Number number4 = (Number) d12.get("breadcrumbBytesRemoved");
                this.f17265f = number4 != null ? number4.intValue() : i10;
                return;
            }
            return;
        }
        this.f17260a = new HashMap();
        this.f17261b = new HashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : map);
    }
}

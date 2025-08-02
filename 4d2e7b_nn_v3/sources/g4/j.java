package g4;

import c4.c;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import w4.d;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21724c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap f21725d = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final d f21726a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21727b;

    public static final class a {
        private a() {
        }

        public final void a(Date date) {
            m.f(date, "until");
            synchronized (j.f21725d) {
                try {
                    ConcurrentHashMap a10 = j.f21725d;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : a10.entrySet()) {
                        if (((l) entry.getValue()).b().compareTo(date) < 0) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        ((l) entry2.getValue()).a().clear();
                        j.f21725d.remove(entry2.getKey());
                    }
                    Unit unit = Unit.f12577a;
                } finally {
                }
            }
        }

        public final void b(String str, i iVar) {
            m.f(str, "cacheKey");
            m.f(iVar, "frameLoader");
            j.f21725d.put(str, new l(iVar, new Date()));
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(d dVar, int i10) {
        m.f(dVar, "platformBitmapFactory");
        this.f21726a = dVar;
        this.f21727b = i10;
    }

    public final i b(String str, c cVar, b4.d dVar) {
        m.f(str, "cacheKey");
        m.f(cVar, "bitmapFrameRenderer");
        m.f(dVar, "animationInformation");
        ConcurrentHashMap concurrentHashMap = f21725d;
        synchronized (concurrentHashMap) {
            l lVar = (l) concurrentHashMap.get(str);
            if (lVar != null) {
                concurrentHashMap.remove(str);
                i a10 = lVar.a();
                return a10;
            }
            Unit unit = Unit.f12577a;
            return new f(this.f21726a, cVar, new f4.c(this.f21727b), dVar);
        }
    }
}

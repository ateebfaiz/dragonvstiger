package r5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap f23693a = new ConcurrentHashMap();

    public final List a(String str) {
        m.f(str, "appId");
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f23693a.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        for (Map.Entry value : concurrentHashMap.entrySet()) {
            arrayList.add((a) value.getValue());
        }
        return arrayList;
    }

    public final void b(String str, List list) {
        m.f(str, "appId");
        m.f(list, "gateKeeperList");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            concurrentHashMap.put(aVar.a(), aVar);
        }
        this.f23693a.put(str, concurrentHashMap);
    }
}

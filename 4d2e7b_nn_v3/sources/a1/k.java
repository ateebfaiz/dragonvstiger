package a1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f13615a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f13616b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f13617c;

    /* renamed from: d  reason: collision with root package name */
    public final List f13618d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f13619e;

    /* renamed from: f  reason: collision with root package name */
    public final long f13620f;

    public k(int i10, byte[] bArr, Map map, boolean z10, long j10) {
        this(i10, bArr, map, a(map), z10, j10);
    }

    private static List a(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    private static Map b(List list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }

    public k(int i10, byte[] bArr, boolean z10, long j10, List list) {
        this(i10, bArr, b(list), list, z10, j10);
    }

    public k(byte[] bArr, Map map) {
        this(200, bArr, map, false, 0);
    }

    private k(int i10, byte[] bArr, Map map, List list, boolean z10, long j10) {
        this.f13615a = i10;
        this.f13616b = bArr;
        this.f13617c = map;
        if (list == null) {
            this.f13618d = null;
        } else {
            this.f13618d = Collections.unmodifiableList(list);
        }
        this.f13619e = z10;
        this.f13620f = j10;
    }
}

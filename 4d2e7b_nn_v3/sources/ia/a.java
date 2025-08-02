package ia;

import ha.d;
import ha.e;
import io.jsonwebtoken.Claims;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final Set f12381b;

    /* renamed from: a  reason: collision with root package name */
    private final Map f12382a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Map f12383a = new LinkedHashMap();

        public b a(String str) {
            if (str == null) {
                this.f12383a.put(Claims.AUDIENCE, (Object) null);
            } else {
                this.f12383a.put(Claims.AUDIENCE, Collections.singletonList(str));
            }
            return this;
        }

        public b b(List list) {
            this.f12383a.put(Claims.AUDIENCE, list);
            return this;
        }

        public a c() {
            return new a(this.f12383a);
        }

        public b d(String str, Object obj) {
            this.f12383a.put(str, obj);
            return this;
        }

        public b e(Date date) {
            this.f12383a.put(Claims.EXPIRATION, date);
            return this;
        }

        public b f(Date date) {
            this.f12383a.put(Claims.ISSUED_AT, date);
            return this;
        }

        public b g(String str) {
            this.f12383a.put(Claims.ISSUER, str);
            return this;
        }

        public b h(String str) {
            this.f12383a.put(Claims.ID, str);
            return this;
        }

        public b i(Date date) {
            this.f12383a.put(Claims.NOT_BEFORE, date);
            return this;
        }

        public b j(String str) {
            this.f12383a.put(Claims.SUBJECT, str);
            return this;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(Claims.ISSUER);
        hashSet.add(Claims.SUBJECT);
        hashSet.add(Claims.AUDIENCE);
        hashSet.add(Claims.EXPIRATION);
        hashSet.add(Claims.NOT_BEFORE);
        hashSet.add(Claims.ISSUED_AT);
        hashSet.add(Claims.ID);
        f12381b = Collections.unmodifiableSet(hashSet);
    }

    public static a h(Map map) {
        Map map2 = map;
        b bVar = new b();
        for (String str : map.keySet()) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case 96944:
                    if (str.equals(Claims.AUDIENCE)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 100893:
                    if (str.equals(Claims.EXPIRATION)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 104028:
                    if (str.equals(Claims.ISSUED_AT)) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 104585:
                    if (str.equals(Claims.ISSUER)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 105567:
                    if (str.equals(Claims.ID)) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 108850:
                    if (str.equals(Claims.NOT_BEFORE)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 114240:
                    if (str.equals(Claims.SUBJECT)) {
                        c10 = 6;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    Object obj = map2.get(Claims.AUDIENCE);
                    if (obj instanceof String) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(e.g(map2, Claims.AUDIENCE));
                        bVar.b(arrayList);
                        break;
                    } else if (obj instanceof List) {
                        bVar.b(e.i(map2, Claims.AUDIENCE));
                        break;
                    } else if (obj == null) {
                        bVar.a((String) null);
                        break;
                    } else {
                        throw new ParseException("Unexpected type of aud claim", 0);
                    }
                case 1:
                    bVar.e(new Date(e.f(map2, Claims.EXPIRATION) * 1000));
                    break;
                case 2:
                    bVar.f(new Date(e.f(map2, Claims.ISSUED_AT) * 1000));
                    break;
                case 3:
                    bVar.g(e.g(map2, Claims.ISSUER));
                    break;
                case 4:
                    bVar.h(e.g(map2, Claims.ID));
                    break;
                case 5:
                    bVar.i(new Date(e.f(map2, Claims.NOT_BEFORE) * 1000));
                    break;
                case 6:
                    Object obj2 = map2.get(Claims.SUBJECT);
                    if (obj2 instanceof String) {
                        bVar.j(e.g(map2, Claims.SUBJECT));
                        break;
                    } else if (obj2 instanceof Number) {
                        bVar.j(String.valueOf(obj2));
                        break;
                    } else if (obj2 == null) {
                        bVar.j((String) null);
                        break;
                    } else {
                        throw new ParseException("Unexpected type of sub claim", 0);
                    }
                default:
                    bVar.d(str, map2.get(str));
                    break;
            }
        }
        return bVar.c();
    }

    public List a() {
        Object b10 = b(Claims.AUDIENCE);
        if (b10 instanceof String) {
            return Collections.singletonList((String) b10);
        }
        try {
            List f10 = f(Claims.AUDIENCE);
            if (f10 != null) {
                return f10;
            }
            return Collections.emptyList();
        } catch (ParseException unused) {
            return Collections.emptyList();
        }
    }

    public Object b(String str) {
        return this.f12382a.get(str);
    }

    public Map c() {
        return Collections.unmodifiableMap(this.f12382a);
    }

    public List d(String str) {
        if (b(str) == null) {
            return null;
        }
        try {
            return (List) b(str);
        } catch (ClassCastException unused) {
            throw new ParseException("The " + str + " claim is not a list / JSON array", 0);
        }
    }

    public String[] e(String str) {
        List d10 = d(str);
        if (d10 == null) {
            return null;
        }
        int size = d10.size();
        String[] strArr = new String[size];
        int i10 = 0;
        while (i10 < size) {
            try {
                strArr[i10] = (String) d10.get(i10);
                i10++;
            } catch (ClassCastException unused) {
                throw new ParseException("The " + str + " claim is not a list / JSON array of strings", 0);
            }
        }
        return strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Objects.equals(this.f12382a, ((a) obj).f12382a);
    }

    public List f(String str) {
        String[] e10 = e(str);
        if (e10 == null) {
            return null;
        }
        return Collections.unmodifiableList(Arrays.asList(e10));
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f12382a});
    }

    public Map i() {
        return j(false);
    }

    public Map j(boolean z10) {
        Map k10 = e.k();
        for (Map.Entry entry : this.f12382a.entrySet()) {
            if (entry.getValue() instanceof Date) {
                k10.put(entry.getKey(), Long.valueOf(ja.a.b((Date) entry.getValue())));
            } else if (Claims.AUDIENCE.equals(entry.getKey())) {
                List a10 = a();
                if (a10 == null || a10.isEmpty()) {
                    if (z10) {
                        k10.put(Claims.AUDIENCE, (Object) null);
                    }
                } else if (a10.size() == 1) {
                    k10.put(Claims.AUDIENCE, a10.get(0));
                } else {
                    List a11 = d.a();
                    a11.addAll(a10);
                    k10.put(Claims.AUDIENCE, a11);
                }
            } else if (entry.getValue() != null) {
                k10.put(entry.getKey(), entry.getValue());
            } else if (z10) {
                k10.put(entry.getKey(), (Object) null);
            }
        }
        return k10;
    }

    public String toString() {
        return e.n(i());
    }

    private a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f12382a = linkedHashMap;
        linkedHashMap.putAll(map);
    }
}

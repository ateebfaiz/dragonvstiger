package b1;

import a1.b;
import a1.g;
import a1.k;
import a1.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public abstract class e {
    static String a(long j10) {
        return b().format(new Date(j10));
    }

    private static SimpleDateFormat b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static b.a c(k kVar) {
        long j10;
        long j11;
        long j12;
        boolean z10;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        k kVar2 = kVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = kVar2.f13617c;
        String str = (String) map.get("Date");
        if (str != null) {
            j10 = e(str);
        } else {
            j10 = 0;
        }
        String str2 = (String) map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            z10 = false;
            j12 = 0;
            j11 = 0;
            while (i10 < split.length) {
                String trim = split[i10].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j12 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j11 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i10++;
            }
            i10 = 1;
        } else {
            z10 = false;
            j12 = 0;
            j11 = 0;
        }
        String str3 = (String) map.get("Expires");
        if (str3 != null) {
            j13 = e(str3);
        } else {
            j13 = 0;
        }
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j14 = e(str4);
        } else {
            j14 = 0;
        }
        String str5 = (String) map.get("ETag");
        if (i10 != 0) {
            j16 = currentTimeMillis + (j12 * 1000);
            if (z10) {
                j17 = j16;
            } else {
                Long.signum(j11);
                j17 = (j11 * 1000) + j16;
            }
            j15 = j17;
        } else {
            j15 = 0;
            if (j10 <= 0 || j13 < j10) {
                j16 = 0;
            } else {
                j16 = currentTimeMillis + (j13 - j10);
                j15 = j16;
            }
        }
        b.a aVar = new b.a();
        aVar.f13578a = kVar2.f13616b;
        aVar.f13579b = str5;
        aVar.f13583f = j16;
        aVar.f13582e = j15;
        aVar.f13580c = j10;
        aVar.f13581d = j14;
        aVar.f13584g = map;
        aVar.f13585h = kVar2.f13618d;
        return aVar;
    }

    public static String d(Map map, String str) {
        String str2 = (String) map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i10 = 1; i10 < split.length; i10++) {
                String[] split2 = split[i10].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long e(String str) {
        try {
            return b().parse(str).getTime();
        } catch (ParseException e10) {
            v.d(e10, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    static List f(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map g(List list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}

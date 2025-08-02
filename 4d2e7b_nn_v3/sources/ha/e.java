package ha;

import fa.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y9.d;
import y9.p;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final d f12312a = new y9.e().d().e(p.LONG_OR_DOUBLE).c().b();

    public static c a(Map map, String str) {
        String g10 = g(map, str);
        if (g10 == null) {
            return null;
        }
        return new c(g10);
    }

    public static boolean b(Map map, String str) {
        Boolean bool = (Boolean) c(map, str, Boolean.class);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    private static Object c(Map map, String str, Class cls) {
        if (map.get(str) == null) {
            return null;
        }
        Object obj = map.get(str);
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        throw new ParseException("Unexpected type of JSON object member with key " + str + "", 0);
    }

    public static List d(Map map, String str) {
        return (List) c(map, str, List.class);
    }

    public static Map e(Map map, String str) {
        Map map2 = (Map) c(map, str, Map.class);
        if (map2 == null) {
            return null;
        }
        for (Object obj : map2.keySet()) {
            if (!(obj instanceof String)) {
                throw new ParseException("JSON object member with key " + str + " not a JSON object", 0);
            }
        }
        return map2;
    }

    public static long f(Map map, String str) {
        Number number = (Number) c(map, str, Number.class);
        if (number != null) {
            return number.longValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static String g(Map map, String str) {
        return (String) c(map, str, String.class);
    }

    public static String[] h(Map map, String str) {
        List d10 = d(map, str);
        if (d10 == null) {
            return null;
        }
        try {
            return (String[]) d10.toArray(new String[0]);
        } catch (ArrayStoreException unused) {
            throw new ParseException("JSON object member with key \"" + str + "\" is not an array of strings", 0);
        }
    }

    public static List i(Map map, String str) {
        String[] h10 = h(map, str);
        if (h10 == null) {
            return null;
        }
        return Arrays.asList(h10);
    }

    public static URI j(Map map, String str) {
        String g10 = g(map, str);
        if (g10 == null) {
            return null;
        }
        try {
            return new URI(g10);
        } catch (URISyntaxException e10) {
            throw new ParseException(e10.getMessage(), 0);
        }
    }

    public static Map k() {
        return new HashMap();
    }

    public static Map l(String str) {
        return m(str, -1);
    }

    public static Map m(String str, int i10) {
        if (str.trim().isEmpty()) {
            throw new ParseException("Invalid JSON object", 0);
        } else if (i10 < 0 || str.length() <= i10) {
            try {
                return (Map) f12312a.j(str, a.c(Map.class, String.class, Object.class).e());
            } catch (Exception e10) {
                throw new ParseException("Invalid JSON: " + e10.getMessage(), 0);
            } catch (StackOverflowError unused) {
                throw new ParseException("Excessive JSON object and / or array nesting", 0);
            }
        } else {
            throw new ParseException("The parsed string is longer than the max accepted size of " + i10 + " characters", 0);
        }
    }

    public static String n(Map map) {
        return f12312a.q(map);
    }
}

package o4;

import android.icu.text.NumberingSystem;
import android.icu.text.RuleBasedCollator;
import android.icu.util.Calendar;
import android.icu.util.ULocale;
import android.os.Build;
import androidx.core.text.util.LocalePreferences;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class z3 {

    /* renamed from: a  reason: collision with root package name */
    public static String f22995a = "calendar";

    /* renamed from: b  reason: collision with root package name */
    public static String f22996b = "ca";

    /* renamed from: c  reason: collision with root package name */
    public static String f22997c = "numbers";

    /* renamed from: d  reason: collision with root package name */
    public static String f22998d = "nu";

    /* renamed from: e  reason: collision with root package name */
    public static String f22999e = "hours";

    /* renamed from: f  reason: collision with root package name */
    public static String f23000f = "hc";

    /* renamed from: g  reason: collision with root package name */
    public static String f23001g = "collation";

    /* renamed from: h  reason: collision with root package name */
    public static String f23002h = "co";

    /* renamed from: i  reason: collision with root package name */
    public static String f23003i = "colnumeric";

    /* renamed from: j  reason: collision with root package name */
    public static String f23004j = "kn";

    /* renamed from: k  reason: collision with root package name */
    public static String f23005k = "colcasefirst";

    /* renamed from: l  reason: collision with root package name */
    public static String f23006l = "kf";

    /* renamed from: m  reason: collision with root package name */
    private static HashMap f23007m = new a();

    /* renamed from: n  reason: collision with root package name */
    private static HashMap f23008n = new b();

    /* renamed from: o  reason: collision with root package name */
    private static final Map f23009o = new c();

    /* renamed from: p  reason: collision with root package name */
    private static Map f23010p = new d();

    /* renamed from: q  reason: collision with root package name */
    private static Map f23011q = new e();

    /* renamed from: r  reason: collision with root package name */
    private static Map f23012r = new f();

    class a extends HashMap {
        a() {
            put(z3.f22996b, z3.f22995a);
            put(z3.f22998d, z3.f22997c);
            put(z3.f23000f, z3.f22999e);
            put(z3.f23002h, z3.f23001g);
            put(z3.f23004j, z3.f23003i);
            put(z3.f23006l, z3.f23005k);
        }
    }

    class b extends HashMap {
        b() {
            put(z3.f22995a, z3.f22996b);
            put(z3.f22997c, z3.f22998d);
            put(z3.f22999e, z3.f23000f);
            put(z3.f23001g, z3.f23002h);
            put(z3.f23003i, z3.f23004j);
            put(z3.f23005k, z3.f23006l);
        }
    }

    class c extends HashMap {
        c() {
            put("dictionary", "dict");
            put("phonebook", "phonebk");
            put("traditional", "trad");
            put("gb2312han", "gb2312");
        }
    }

    class d extends HashMap {
        d() {
            put(LocalePreferences.CalendarType.GREGORIAN, "gregory");
        }
    }

    class e extends HashMap {
        e() {
            put("traditional", "traditio");
        }
    }

    class f extends HashMap {
        f() {
            put("nu", new String[]{"adlm", "ahom", "arab", "arabext", "bali", "beng", "bhks", "brah", "cakm", "cham", "deva", "diak", "fullwide", "gong", "gonm", "gujr", "guru", "hanidec", "hmng", "hmnp", "java", "kali", "khmr", "knda", "lana", "lanatham", "laoo", "latn", "lepc", "limb", "mathbold", "mathdbl", "mathmono", "mathsanb", "mathsans", "mlym", "modi", "mong", "mroo", "mtei", "mymr", "mymrshan", "mymrtlng", "newa", "nkoo", "olck", "orya", "osma", "rohg", "saur", "segment", "shrd", "sind", "sinh", "sora", "sund", "takr", "talu", "tamldec", "telu", "thai", "tibt", "tirh", "vaii", "wara", "wcho"});
            put("co", new String[]{"big5han", "compat", "dict", DevicePublicKeyStringDef.DIRECT, "ducet", "emoji", "eor", "gb2312", "phonebk", "phonetic", "pinyin", "reformed", "searchjl", "stroke", "trad", "unihan", "zhuyin"});
            put("ca", new String[]{"buddhist", LocalePreferences.CalendarType.CHINESE, "coptic", LocalePreferences.CalendarType.DANGI, "ethioaa", "ethiopic", "gregory", LocalePreferences.CalendarType.HEBREW, LocalePreferences.CalendarType.INDIAN, LocalePreferences.CalendarType.ISLAMIC, LocalePreferences.CalendarType.ISLAMIC_UMALQURA, LocalePreferences.CalendarType.ISLAMIC_TBLA, LocalePreferences.CalendarType.ISLAMIC_CIVIL, LocalePreferences.CalendarType.ISLAMIC_RGSA, "iso8601", "japanese", LocalePreferences.CalendarType.PERSIAN, "roc"});
        }
    }

    public static String a(String str) {
        if (f23007m.containsKey(str)) {
            return (String) f23007m.get(str);
        }
        return str;
    }

    public static String b(String str) {
        if (f23008n.containsKey(str)) {
            return (String) f23008n.get(str);
        }
        return str;
    }

    public static boolean c(String str, String str2, b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            ULocale a10 = f.a(bVar.h());
            String[] strArr = new String[0];
            if (str.equals("co")) {
                if (str2.equals("standard") || str2.equals(FirebaseAnalytics.Event.SEARCH)) {
                    return false;
                }
                strArr = RuleBasedCollator.getKeywordValuesForLocale("co", a10, false);
            } else if (str.equals("ca")) {
                strArr = Calendar.getKeywordValuesForLocale("ca", a10, false);
            } else if (str.equals("nu")) {
                strArr = NumberingSystem.getAvailableNames();
            }
            if (strArr.length == 0) {
                return true;
            }
            return Arrays.asList(strArr).contains(str2);
        } else if (f23012r.containsKey(str)) {
            return Arrays.asList((String[]) f23012r.get(str)).contains(str2);
        } else {
            return true;
        }
    }

    public static String d(String str) {
        if (!f23010p.containsKey(str)) {
            return str;
        }
        return (String) f23010p.get(str);
    }

    public static String e(String str) {
        Map map = f23009o;
        if (!map.containsKey(str)) {
            return str;
        }
        return (String) map.get(str);
    }

    public static Object f(String str, Object obj) {
        if (str.equals("ca") && j.m(obj)) {
            return d((String) obj);
        }
        if (str.equals("nu") && j.m(obj)) {
            return g((String) obj);
        }
        if (str.equals("co") && j.m(obj)) {
            return e((String) obj);
        }
        if (str.equals("kn") && j.m(obj) && obj.equals("yes")) {
            return j.r("true");
        }
        if ((str.equals("kn") || str.equals("kf")) && j.m(obj) && obj.equals("no")) {
            return j.r("false");
        }
        return obj;
    }

    public static String g(String str) {
        if (!f23011q.containsKey(str)) {
            return str;
        }
        return (String) f23011q.get(str);
    }
}

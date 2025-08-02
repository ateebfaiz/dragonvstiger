package n;

import androidx.exifinterface.media.ExifInterface;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.HashMap;
import java.util.Map;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f22657a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map f22658b;

    public interface a {
        boolean d(String[] strArr);
    }

    public static class b implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 21) {
                return true;
            }
            String str = strArr[20];
            String str2 = b.f22628m;
            if ("\"-\"".equals(str) || "\"LOCAL_IP\"".equals(str) || "\"URL_FILTERED\"".equals(str) || "\"PRE_ESTABLISH_CONNECTION\"".equals(str) || "\"NORMAL_BYPASS\"".equals(str)) {
                return false;
            }
            return true;
        }
    }

    public static class c implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 49) {
                return true;
            }
            String str = strArr[48];
            String str2 = b.f22628m;
            return !"\"-\"".equals(str);
        }
    }

    /* renamed from: n.d$d  reason: collision with other inner class name */
    public static class C0310d implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 50) {
                return true;
            }
            String str = strArr[49];
            String str2 = b.f22628m;
            return !"\"-\"".equals(str);
        }
    }

    public static class e implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 54) {
                return true;
            }
            String str = strArr[53];
            String str2 = b.f22628m;
            return !"\"-\"".equals(str);
        }
    }

    public static class f implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 54) {
                return false;
            }
            String str = strArr[2];
            String str2 = strArr[33];
            String str3 = strArr[37];
            String str4 = strArr[39];
            String str5 = strArr[45];
            String str6 = strArr[47];
            String str7 = strArr[49];
            String str8 = strArr[53];
            if (!"\"<unknown>\"".equals(str) || !"\"-1:client_READ|0|0|ERROR|0|0x0\"".equals(str2) || "\"\"".equals(str3) || "\"\"".equals(str4) || "\"\"".equals(str5) || "\"\"".equals(str6) || !"\"-\"".equals(str7) || !"\"-\"".equals(str8)) {
                return false;
            }
            return true;
        }
    }

    public static class g implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 6) {
                return false;
            }
            String str = strArr[5];
            String str2 = strArr[2];
            if (!"DS".equals(strArr[1]) || !"\"CONNECT\"".equals(str2) || !"200".equals(str)) {
                return false;
            }
            return true;
        }
    }

    public static class h implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 6) {
                return false;
            }
            String str = strArr[5];
            if (!"WPS".equals(strArr[1]) || !"101".equals(str)) {
                return false;
            }
            return true;
        }
    }

    public static class i implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 2) {
                return true;
            }
            String str = strArr[1];
            String str2 = b.f22628m;
            if ("-".equals(str) || "RJ".equals(str)) {
                return true;
            }
            return false;
        }
    }

    public static class j implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 3) {
                return true;
            }
            String str = strArr[2];
            String str2 = b.f22628m;
            return "\"<unknown>\"".equals(str);
        }
    }

    public static class k implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 4) {
                return true;
            }
            String str = strArr[3];
            String str2 = b.f22628m;
            return "\"\"".equals(str);
        }
    }

    public static class l implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 5) {
                return true;
            }
            String str = strArr[4];
            String str2 = b.f22628m;
            return "\"\"".equals(str);
        }
    }

    public static class m implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 6) {
                return true;
            }
            String str = strArr[5];
            String str2 = b.f22628m;
            if (str.startsWith(ExifInterface.GPS_MEASUREMENT_2D) || str.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
                return false;
            }
            return true;
        }
    }

    public static class n implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 21) {
                return true;
            }
            String str = strArr[5];
            String str2 = strArr[20];
            String str3 = b.f22628m;
            if (!str.startsWith(ExifInterface.GPS_MEASUREMENT_2D) && !str.startsWith(ExifInterface.GPS_MEASUREMENT_3D)) {
                if (!"\"URL_FILTERED\"".equals(str2) && !"\"NORMAL_BYPASS\"".equals(str2)) {
                    return true;
                }
                if (str.startsWith("4") || str.startsWith("5")) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    public static class o implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 25) {
                return true;
            }
            String str = strArr[5];
            String str2 = strArr[20];
            String str3 = strArr[24];
            String str4 = b.f22628m;
            if (str.startsWith(ExifInterface.GPS_MEASUREMENT_2D) || str.startsWith(ExifInterface.GPS_MEASUREMENT_3D) || ((("\"URL_FILTERED\"".equals(str2) || "\"NORMAL_BYPASS\"".equals(str2)) && (str.startsWith("4") || str.startsWith("5"))) || "\"\"".equals(str3))) {
                return false;
            }
            return true;
        }
    }

    public static class p implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 11) {
                return true;
            }
            String str = strArr[10];
            String str2 = b.f22628m;
            return "-1".equals(str);
        }
    }

    public static class q implements a {
        public boolean d(String[] strArr) {
            if (strArr.length < 16) {
                return true;
            }
            int parseInt = Integer.parseInt(strArr[13]);
            int parseInt2 = Integer.parseInt(strArr[14]);
            int parseInt3 = Integer.parseInt(strArr[15]);
            String str = b.f22628m;
            if (parseInt3 > 0 && parseInt != parseInt3) {
                return true;
            }
            if (parseInt3 > 0 || parseInt == parseInt2) {
                return false;
            }
            return true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f22657a = hashMap;
        HashMap hashMap2 = new HashMap();
        f22658b = hashMap2;
        hashMap.put("1", new i());
        hashMap.put(ExifInterface.GPS_MEASUREMENT_2D, new j());
        hashMap.put(ExifInterface.GPS_MEASUREMENT_3D, new k());
        hashMap.put("4", new l());
        hashMap.put("5", new m());
        hashMap.put("6", new n());
        hashMap.put("7", new o());
        hashMap.put("8", new p());
        hashMap.put(DbParams.GZIP_DATA_ENCRYPT, new q());
        hashMap.put("10", new b());
        hashMap.put("11", new c());
        hashMap.put("12", new C0310d());
        hashMap.put(DbParams.GZIP_TRANSPORT_ENCRYPT, new e());
        hashMap2.put("14", new f());
        hashMap2.put("15", new g());
        hashMap2.put("16", new h());
    }
}

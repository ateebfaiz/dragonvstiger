package m3;

import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.alibaba.pdns.f;
import com.facebook.o;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import io.jsonwebtoken.JwtParser;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import q5.j0;
import q5.p0;
import q5.r;
import q5.s;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22530a = "m3.a";

    /* renamed from: b  reason: collision with root package name */
    private static HashMap f22531b = new HashMap();

    /* renamed from: m3.a$a  reason: collision with other inner class name */
    static class C0308a implements NsdManager.RegistrationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22532a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22533b;

        C0308a(String str, String str2) {
            this.f22532a = str;
            this.f22533b = str2;
        }

        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
            a.a(this.f22533b);
        }

        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            if (!this.f22532a.equals(nsdServiceInfo.getServiceName())) {
                a.a(this.f22533b);
            }
        }

        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        }

        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        }
    }

    public static void a(String str) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                b(str);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void b(String str) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                NsdManager.RegistrationListener registrationListener = (NsdManager.RegistrationListener) f22531b.get(str);
                if (registrationListener != null) {
                    ((NsdManager) o.f().getSystemService("servicediscovery")).unregisterService(registrationListener);
                    f22531b.remove(str);
                }
            } catch (IllegalArgumentException e10) {
                p0.e0(f22530a, e10);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static Bitmap c(String str) {
        int i10;
        Class<a> cls = a.class;
        Bitmap bitmap = null;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.MARGIN, 2);
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                int height = encode.getHeight();
                int width = encode.getWidth();
                int[] iArr = new int[(height * width)];
                for (int i11 = 0; i11 < height; i11++) {
                    int i12 = i11 * width;
                    for (int i13 = 0; i13 < width; i13++) {
                        int i14 = i12 + i13;
                        if (encode.get(i13, i11)) {
                            i10 = ViewCompat.MEASURED_STATE_MASK;
                        } else {
                            i10 = -1;
                        }
                        iArr[i14] = i10;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                try {
                    createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                    return createBitmap;
                } catch (WriterException unused) {
                    bitmap = createBitmap;
                }
            } catch (WriterException unused2) {
                return bitmap;
            }
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static String d() {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return e((Map) null);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static String e(Map map) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (map == null) {
            try {
                map = new HashMap();
            } catch (Throwable th) {
                v5.a.b(th, cls);
                return null;
            }
        }
        map.put("device", Build.DEVICE);
        map.put("model", Build.MODEL);
        return new JSONObject(map).toString();
    }

    public static boolean f() {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            r j10 = s.j(o.g());
            if (j10 == null || !j10.m().contains(j0.Enabled)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static boolean g(String str) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            if (f()) {
                return h(str);
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    private static boolean h(String str) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            if (f22531b.containsKey(str)) {
                return true;
            }
            String format = String.format("%s_%s_%s", new Object[]{"fbsdk", String.format("%s-%s", new Object[]{f.f17924q, o.w().replace(JwtParser.SEPARATOR_CHAR, '|')}), str});
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType("_fb._tcp.");
            nsdServiceInfo.setServiceName(format);
            nsdServiceInfo.setPort(80);
            C0308a aVar = new C0308a(format, str);
            f22531b.put(str, aVar);
            ((NsdManager) o.f().getSystemService("servicediscovery")).registerService(nsdServiceInfo, 1, aVar);
            return true;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }
}

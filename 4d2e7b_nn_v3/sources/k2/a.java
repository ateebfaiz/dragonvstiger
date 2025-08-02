package k2;

import com.facebook.o;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import m2.d;
import org.json.JSONObject;
import q5.q;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f22273a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f22274b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f22275c = new a();

    private a() {
    }

    public static final void a() {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f22273a = true;
                f22274b = q.f("FBSDKFeatureIntegritySample", o.g(), false);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final String b(String str) {
        String str2;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            String[] o10 = d.o(d.a.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
            if (o10 == null || (str2 = o10[0]) == null) {
                return DevicePublicKeyStringDef.NONE;
            }
            return str2;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final void c(Map map) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(map, "parameters");
                if (f22273a && !map.isEmpty()) {
                    try {
                        List<String> w02 = r.w0(map.keySet());
                        JSONObject jSONObject = new JSONObject();
                        for (String str : w02) {
                            Object obj = map.get(str);
                            if (obj != null) {
                                String str2 = (String) obj;
                                a aVar = f22275c;
                                if (!aVar.d(str)) {
                                    if (aVar.d(str2)) {
                                    }
                                }
                                map.remove(str);
                                if (!f22274b) {
                                    str2 = "";
                                }
                                jSONObject.put(str, str2);
                            } else {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                        }
                        if (jSONObject.length() != 0) {
                            String jSONObject2 = jSONObject.toString();
                            m.e(jSONObject2, "restrictiveParamJson.toString()");
                            map.put("_onDeviceParams", jSONObject2);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final boolean d(String str) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            return !m.b(DevicePublicKeyStringDef.NONE, b(str));
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }
}

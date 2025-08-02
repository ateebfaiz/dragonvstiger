package h2;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21882a = e.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private static Class f21883b;

    /* renamed from: c  reason: collision with root package name */
    public static final e f21884c = new e();

    private e() {
    }

    public static final void a() {
        d("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    private final Class b() {
        Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
        m.e(cls, "Class.forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    public static final void c(String str) {
        d("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }

    public static final void d(String str, String str2, String str3) {
        try {
            if (f21883b == null) {
                f21883b = f21884c.b();
            }
            Class cls = f21883b;
            if (cls == null) {
                m.u("unityPlayer");
            }
            Class<String> cls2 = String.class;
            Method method = cls.getMethod("UnitySendMessage", new Class[]{cls2, cls2, cls2});
            m.e(method, "unityPlayer.getMethod(\n …java, String::class.java)");
            Class cls3 = f21883b;
            if (cls3 == null) {
                m.u("unityPlayer");
            }
            method.invoke(cls3, new Object[]{str, str2, str3});
        } catch (Exception e10) {
            Log.e(f21882a, "Failed to send message to Unity", e10);
        }
    }
}

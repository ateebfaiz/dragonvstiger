package y8;

import c.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.cocos2dx.javascript.aop.HideModalVirtualBtn$$AndroidAopClass;
import v8.a;
import v8.c;

abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f13356a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f13357b = new ConcurrentHashMap();

    static {
        c();
        f();
        d();
    }

    public static a a(String str) {
        Map map = f13356a;
        d.a(map.get("@" + str));
        return null;
    }

    public static c b(String str) {
        return (c) f13357b.get(str);
    }

    private static void c() {
    }

    private static void d() {
        if (f13356a.isEmpty() || f13357b.isEmpty()) {
            try {
                Class.forName("com.flyjingfish.android_aop_annotation.utils.DebugAndroidAopInit");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    static void e(String str, c cVar) {
        f13357b.put(str, cVar);
    }

    private static void f() {
        e("org.cocos2dx.javascript.aop.HideModalVirtualBtn", new HideModalVirtualBtn$$AndroidAopClass());
    }
}

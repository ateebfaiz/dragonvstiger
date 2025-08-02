package l4;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import java.util.Map;
import kotlin.jvm.internal.m;
import m4.b;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f22457a = new b();

    private b() {
    }

    public static final b.a a(Map map, Map map2, Map map3, Map map4, Rect rect, String str, PointF pointF, Map map5, Object obj, boolean z10, Uri uri) {
        m.f(map, "componentAttribution");
        m.f(map2, "shortcutAttribution");
        b.a aVar = new b.a();
        if (rect != null) {
            aVar.f22542h = rect.width();
            aVar.f22543i = rect.height();
        }
        aVar.f22544j = str;
        if (pointF != null) {
            aVar.f22545k = Float.valueOf(pointF.x);
            aVar.f22546l = Float.valueOf(pointF.y);
        }
        aVar.f22540f = obj;
        aVar.f22547m = z10;
        aVar.f22541g = uri;
        aVar.f22537c = map3;
        aVar.f22538d = map5;
        aVar.f22536b = map2;
        aVar.f22535a = map;
        aVar.f22539e = map4;
        return aVar;
    }
}

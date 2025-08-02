package qa;

import com.appsflyer.AppsFlyerProperties;
import kotlin.jvm.internal.m;
import na.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f12916a;

    /* renamed from: b  reason: collision with root package name */
    private final b f12917b;

    public a(String str, b bVar) {
        m.f(str, "influenceId");
        m.f(bVar, AppsFlyerProperties.CHANNEL);
        this.f12916a = str;
        this.f12917b = bVar;
    }

    public b a() {
        return this.f12917b;
    }

    public String b() {
        return this.f12916a;
    }
}

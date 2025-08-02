package e2;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    private static final String f21165b = g.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    public static final a f21166c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final h f21167a;

    public static final class a {
        private a() {
        }

        public final void a(Application application, String str) {
            m.f(application, "application");
            h.f21178j.d(application, str);
        }

        public final String b(Context context) {
            m.f(context, "context");
            return h.f21178j.g(context);
        }

        public final b c() {
            return h.f21178j.h();
        }

        public final String d() {
            return b.b();
        }

        public final void e(Context context, String str) {
            m.f(context, "context");
            h.f21178j.k(context, str);
        }

        public final g f(Context context) {
            m.f(context, "context");
            return new g(context, (String) null, (AccessToken) null, (DefaultConstructorMarker) null);
        }

        public final void g() {
            h.f21178j.o();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum b {
        AUTO,
        EXPLICIT_ONLY
    }

    public /* synthetic */ g(Context context, String str, AccessToken accessToken, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, accessToken);
    }

    public static final g c(Context context) {
        return f21166c.f(context);
    }

    public final void a() {
        this.f21167a.j();
    }

    public final void b(String str, Bundle bundle) {
        this.f21167a.l(str, bundle);
    }

    private g(Context context, String str, AccessToken accessToken) {
        this.f21167a = new h(context, str, accessToken);
    }
}

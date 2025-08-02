package q5;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f23288b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Uri f23289a;

    public static final class a {
        private a() {
        }

        public Uri a(String str, Bundle bundle) {
            m.f(str, "action");
            String b10 = i0.b();
            return p0.f(b10, o.r() + DomExceptionUtils.SEPARATOR + "dialog/" + str, bundle);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(String str, Bundle bundle) {
        m.f(str, "action");
        this.f23289a = f23288b.a(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri a(String str, Bundle bundle) {
        Class<e> cls = e.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23288b.a(str, bundle);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public final boolean b(Activity activity, String str) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            m.f(activity, "activity");
            CustomTabsIntent build = new CustomTabsIntent.Builder(com.facebook.login.a.f20478d.b()).build();
            build.intent.setPackage(str);
            try {
                build.launchUrl(activity, this.f23289a);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void c(Uri uri) {
        if (!v5.a.d(this)) {
            try {
                m.f(uri, "<set-?>");
                this.f23289a = uri;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}

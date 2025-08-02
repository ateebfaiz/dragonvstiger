package t7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f13069b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f13070c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Map f13071a = new HashMap();

    public static final class a {
        private a() {
        }

        public final c a() {
            return c.f13070c;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private c() {
    }

    private final int b(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        this.f13071a.put(str, Integer.valueOf(identifier));
        return identifier;
    }

    public static final c d() {
        return f13069b.a();
    }

    public final synchronized void c() {
        this.f13071a.clear();
    }

    public final Drawable e(Context context, String str) {
        m.f(context, "context");
        int f10 = f(context, str);
        if (f10 > 0) {
            return ResourcesCompat.getDrawable(context.getResources(), f10, (Resources.Theme) null);
        }
        return null;
    }

    public final int f(Context context, String str) {
        int i10;
        m.f(context, "context");
        if (str == null || str.length() == 0) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        m.e(lowerCase, "toLowerCase(...)");
        String z10 = j.z(lowerCase, "-", "_", false, 4, (Object) null);
        try {
            return Integer.parseInt(z10);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                Integer num = (Integer) this.f13071a.get(z10);
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = b(context, z10);
                }
                return i10;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Uri g(Context context, String str) {
        m.f(context, "context");
        int f10 = f(context, str);
        if (f10 > 0) {
            Uri build = new Uri.Builder().scheme("res").path(String.valueOf(f10)).build();
            m.c(build);
            return build;
        }
        Uri uri = Uri.EMPTY;
        m.c(uri);
        return uri;
    }
}

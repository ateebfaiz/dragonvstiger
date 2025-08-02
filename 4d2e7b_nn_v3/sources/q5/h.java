package q5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.FacebookActivity;
import com.facebook.g;
import com.facebook.l;
import com.facebook.o;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import q5.f0;
import q5.r;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f23326a = new h();

    public interface a {
        Bundle a();

        Bundle getParameters();
    }

    public static final class b extends ActivityResultContract {
        b() {
        }

        /* renamed from: a */
        public Pair parseResult(int i10, Intent intent) {
            Pair create = Pair.create(Integer.valueOf(i10), intent);
            m.e(create, "Pair.create(resultCode, intent)");
            return create;
        }

        public Intent createIntent(Context context, Intent intent) {
            m.f(context, "context");
            m.f(intent, "input");
            return intent;
        }
    }

    static final class c implements ActivityResultCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f23327a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23328b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f23329c;

        c(g gVar, int i10, y yVar) {
            this.f23327a = gVar;
            this.f23328b = i10;
            this.f23329c = yVar;
        }

        /* renamed from: a */
        public final void onActivityResult(Pair pair) {
            g gVar = this.f23327a;
            if (gVar == null) {
                gVar = new d();
            }
            int i10 = this.f23328b;
            Object obj = pair.first;
            m.e(obj, "result.first");
            gVar.a(i10, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f23329c.f725a;
            if (activityResultLauncher != null) {
                synchronized (activityResultLauncher) {
                    activityResultLauncher.unregister();
                    this.f23329c.f725a = null;
                    Unit unit = Unit.f12577a;
                }
            }
        }
    }

    private h() {
    }

    public static final boolean a(g gVar) {
        m.f(gVar, "feature");
        if (c(gVar).d() != -1) {
            return true;
        }
        return false;
    }

    private final Uri b(g gVar) {
        String name = gVar.name();
        String b10 = gVar.b();
        r.b a10 = r.f23420t.a(o.g(), b10, name);
        if (a10 != null) {
            return a10.b();
        }
        return null;
    }

    public static final f0.g c(g gVar) {
        m.f(gVar, "feature");
        String g10 = o.g();
        String b10 = gVar.b();
        return f0.w(b10, f23326a.d(g10, b10, gVar));
    }

    private final int[] d(String str, String str2, g gVar) {
        int[] d10;
        r.b a10 = r.f23420t.a(str, str2, gVar.name());
        if (a10 != null && (d10 = a10.d()) != null) {
            return d10;
        }
        return new int[]{gVar.a()};
    }

    public static final void e(a aVar, Activity activity) {
        m.f(aVar, "appCall");
        m.f(activity, "activity");
        activity.startActivityForResult(aVar.f(), aVar.e());
        aVar.g();
    }

    public static final void f(a aVar, ActivityResultRegistry activityResultRegistry, g gVar) {
        m.f(aVar, "appCall");
        m.f(activityResultRegistry, "registry");
        Intent f10 = aVar.f();
        if (f10 != null) {
            n(activityResultRegistry, gVar, f10, aVar.e());
            aVar.g();
        }
    }

    public static final void g(a aVar, u uVar) {
        m.f(aVar, "appCall");
        m.f(uVar, "fragmentWrapper");
        uVar.d(aVar.f(), aVar.e());
        aVar.g();
    }

    public static final void h(a aVar) {
        m.f(aVar, "appCall");
        k(aVar, new l("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static final void i(a aVar, l lVar) {
        m.f(aVar, "appCall");
        if (lVar != null) {
            q0.f(o.f());
            Intent intent = new Intent();
            intent.setClass(o.f(), FacebookActivity.class);
            intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
            f0.F(intent, aVar.d().toString(), (String) null, f0.z(), f0.j(lVar));
            aVar.h(intent);
        }
    }

    public static final void j(a aVar, a aVar2, g gVar) {
        Bundle bundle;
        m.f(aVar, "appCall");
        m.f(aVar2, "parameterProvider");
        m.f(gVar, "feature");
        Context f10 = o.f();
        String b10 = gVar.b();
        f0.g c10 = c(gVar);
        int d10 = c10.d();
        if (d10 != -1) {
            if (f0.E(d10)) {
                bundle = aVar2.getParameters();
            } else {
                bundle = aVar2.a();
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Intent n10 = f0.n(f10, aVar.d().toString(), b10, c10, bundle);
            if (n10 != null) {
                aVar.h(n10);
                return;
            }
            throw new l("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new l("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    public static final void k(a aVar, l lVar) {
        m.f(aVar, "appCall");
        i(aVar, lVar);
    }

    public static final void l(a aVar, String str, Bundle bundle) {
        m.f(aVar, "appCall");
        q0.f(o.f());
        q0.h(o.f());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        f0.F(intent, aVar.d().toString(), str, f0.z(), bundle2);
        intent.setClass(o.f(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        aVar.h(intent);
    }

    public static final void m(a aVar, Bundle bundle, g gVar) {
        Uri uri;
        m.f(aVar, "appCall");
        m.f(gVar, "feature");
        q0.f(o.f());
        q0.h(o.f());
        String name = gVar.name();
        Uri b10 = f23326a.b(gVar);
        if (b10 != null) {
            int z10 = f0.z();
            String uuid = aVar.d().toString();
            m.e(uuid, "appCall.callId.toString()");
            Bundle k10 = i0.k(uuid, z10, bundle);
            if (k10 != null) {
                if (b10.isRelative()) {
                    uri = p0.f(i0.b(), b10.toString(), k10);
                } else {
                    uri = p0.f(b10.getAuthority(), b10.getPath(), k10);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(ImagesContract.URL, uri.toString());
                bundle2.putBoolean("is_fallback", true);
                Intent intent = new Intent();
                f0.F(intent, aVar.d().toString(), gVar.b(), f0.z(), bundle2);
                intent.setClass(o.f(), FacebookActivity.class);
                intent.setAction("FacebookDialogFragment");
                aVar.h(intent);
                return;
            }
            throw new l("Unable to fetch the app's key-hash");
        }
        throw new l("Unable to fetch the Url for the DialogFeature : '" + name + '\'');
    }

    public static final void n(ActivityResultRegistry activityResultRegistry, g gVar, Intent intent, int i10) {
        m.f(activityResultRegistry, "registry");
        m.f(intent, "intent");
        y yVar = new y();
        yVar.f725a = null;
        ActivityResultLauncher register = activityResultRegistry.register("facebook-dialog-request-" + i10, new b(), new c(gVar, i10, yVar));
        yVar.f725a = register;
        if (register != null) {
            register.launch(intent);
        }
    }
}

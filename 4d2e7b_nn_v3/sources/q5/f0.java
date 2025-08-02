package q5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.l;
import com.facebook.login.k;
import com.facebook.n;
import com.facebook.o;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23302a;

    /* renamed from: b  reason: collision with root package name */
    private static final List f23303b;

    /* renamed from: c  reason: collision with root package name */
    private static final List f23304c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map f23305d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f23306e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private static final Integer[] f23307f = {20210906, 20170417, 20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101};

    /* renamed from: g  reason: collision with root package name */
    public static final f0 f23308g;

    private static final class a extends f {
        public /* bridge */ /* synthetic */ String c() {
            return (String) g();
        }

        public String d() {
            return "com.facebook.arstudio.player";
        }

        public Void g() {
            return null;
        }
    }

    private static final class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f23309b = new a((DefaultConstructorMarker) null);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public String c() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        public String d() {
            return "com.facebook.lite";
        }
    }

    private static final class c extends f {
        public String c() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        public String d() {
            return "com.instagram.android";
        }

        public String e() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    private static final class d extends f {
        private final boolean g() {
            if (o.f().getApplicationInfo().targetSdkVersion >= 30) {
                return true;
            }
            return false;
        }

        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        public String d() {
            return "com.facebook.katana";
        }

        public void f() {
            if (g()) {
                Log.w(f0.d(f0.f23308g), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    private static final class e extends f {
        public /* bridge */ /* synthetic */ String c() {
            return (String) g();
        }

        public String d() {
            return "com.facebook.orca";
        }

        public Void g() {
            return null;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private TreeSet f23310a;

        public final synchronized void a(boolean z10) {
            if (!z10) {
                try {
                    TreeSet treeSet = this.f23310a;
                    if (!(treeSet == null || treeSet == null)) {
                        if (treeSet.isEmpty()) {
                        }
                        TreeSet treeSet2 = this.f23310a;
                        if (treeSet2 == null || treeSet2.isEmpty()) {
                            f();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f23310a = f0.a(f0.f23308g, this);
            TreeSet treeSet22 = this.f23310a;
            f();
        }

        public final TreeSet b() {
            TreeSet treeSet = this.f23310a;
            if (treeSet == null || treeSet == null || treeSet.isEmpty()) {
                a(false);
            }
            return this.f23310a;
        }

        public abstract String c();

        public abstract String d();

        public String e() {
            return "id_token,token,signed_request,graph_domain";
        }

        public void f() {
        }
    }

    public static final class g {

        /* renamed from: c  reason: collision with root package name */
        public static final a f23311c = new a((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public f f23312a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f23313b;

        public static final class a {
            private a() {
            }

            public final g a(f fVar, int i10) {
                g gVar = new g((DefaultConstructorMarker) null);
                gVar.f23312a = fVar;
                gVar.f23313b = i10;
                return gVar;
            }

            public final g b() {
                g gVar = new g((DefaultConstructorMarker) null);
                gVar.f23313b = -1;
                return gVar;
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private g() {
        }

        public final f c() {
            return this.f23312a;
        }

        public final int d() {
            return this.f23313b;
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class h extends f {
        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        public String d() {
            return "com.facebook.wakizashi";
        }
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final i f23314a = new i();

        i() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    for (f a10 : f0.b(f0.f23308g)) {
                        a10.a(true);
                    }
                    f0.c(f0.f23308g).set(false);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        f0 f0Var = new f0();
        f23308g = f0Var;
        String name = f0.class.getName();
        m.e(name, "NativeProtocol::class.java.name");
        f23302a = name;
        f23303b = f0Var.g();
        f23304c = f0Var.f();
        f23305d = f0Var.e();
    }

    private f0() {
    }

    public static final Bundle A(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(intent, "intent");
            if (!E(B(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final int B(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return 0;
        }
        try {
            m.f(intent, "intent");
            return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return 0;
        }
    }

    public static final Bundle C(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(intent, "resultIntent");
            int B = B(intent);
            Bundle extras = intent.getExtras();
            if (!E(B)) {
                return extras;
            }
            if (extras == null) {
                return extras;
            }
            return extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final boolean D(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            m.f(intent, "resultIntent");
            Bundle s10 = s(intent);
            if (s10 != null) {
                return s10.containsKey(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            }
            return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final boolean E(int i10) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            if (!j.s(f23307f, Integer.valueOf(i10)) || i10 < 20140701) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final void F(Intent intent, String str, String str2, int i10, Bundle bundle) {
        Class<f0> cls = f0.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(intent, "intent");
                String g10 = o.g();
                String h10 = o.h();
                intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i10).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", g10);
                if (E(i10)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("action_id", str);
                    p0.n0(bundle2, "app_name", h10);
                    intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    m.e(intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle), "intent.putExtra(EXTRA_PR…OD_ARGS, methodArguments)");
                    return;
                }
                intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
                if (!p0.Y(h10)) {
                    intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", h10);
                }
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final void G() {
        Class<f0> cls = f0.class;
        if (!v5.a.d(cls)) {
            try {
                if (f23306e.compareAndSet(false, true)) {
                    o.p().execute(i.f23314a);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final Intent H(Context context, Intent intent, f fVar) {
        ResolveInfo resolveActivity;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            String str = resolveActivity.activityInfo.packageName;
            m.e(str, "resolveInfo.activityInfo.packageName");
            if (!m.a(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Intent I(Context context, Intent intent, f fVar) {
        ResolveInfo resolveService;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            String str = resolveService.serviceInfo.packageName;
            m.e(str, "resolveInfo.serviceInfo.packageName");
            if (!m.a(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ TreeSet a(f0 f0Var, f fVar) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f0Var.r(fVar);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ List b(f0 f0Var) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23303b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean c(f0 f0Var) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23306e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String d(f0 f0Var) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23302a;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final Map e() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new e());
            List list = f23303b;
            hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", f23304c);
            hashMap.put("com.facebook.platform.action.request.SHARE_STORY", list);
            return hashMap;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final List f() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            ArrayList g10 = r.g(new a());
            g10.addAll(g());
            return g10;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final List g() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return r.g(new d(), new h());
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final Uri h(f fVar) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse("content://" + fVar.d() + ".provider.PlatformProvider/versions");
            m.e(parse, "Uri.parse(CONTENT_SCHEME…ATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final int i(TreeSet treeSet, int i10, int[] iArr) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return 0;
        }
        try {
            m.f(iArr, "versionSpec");
            if (treeSet == null) {
                return -1;
            }
            int length = iArr.length - 1;
            Iterator descendingIterator = treeSet.descendingIterator();
            int i11 = -1;
            while (descendingIterator.hasNext()) {
                Integer num = (Integer) descendingIterator.next();
                m.e(num, "fbAppVersion");
                i11 = Math.max(i11, num.intValue());
                while (length >= 0 && iArr[length] > num.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == num.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(i11, i10);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return 0;
        }
    }

    public static final Bundle j(l lVar) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls) || lVar == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("error_description", lVar.toString());
            if (lVar instanceof n) {
                bundle.putString("error_type", "UserCanceled");
            }
            return bundle;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Intent k(Context context, String str, Collection collection, String str2, boolean z10, boolean z11, com.facebook.login.b bVar, String str3, String str4, String str5, boolean z12, boolean z13, boolean z14) {
        Context context2 = context;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context2, "context");
            m.f(str, "applicationId");
            m.f(collection, "permissions");
            m.f(str2, "e2e");
            m.f(bVar, "defaultAudience");
            m.f(str3, "clientState");
            m.f(str4, "authType");
            b bVar2 = new b();
            return H(context2, f23308g.m(bVar2, str, collection, str2, z11, bVar, str3, str4, false, str5, z12, k.FACEBOOK, z13, z14, ""), bVar2);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Intent l(Context context, String str, Collection collection, String str2, boolean z10, boolean z11, com.facebook.login.b bVar, String str3, String str4, String str5, boolean z12, boolean z13, boolean z14) {
        Context context2 = context;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context2, "context");
            m.f(str, "applicationId");
            m.f(collection, "permissions");
            m.f(str2, "e2e");
            m.f(bVar, "defaultAudience");
            m.f(str3, "clientState");
            m.f(str4, "authType");
            c cVar = new c();
            return H(context2, f23308g.m(cVar, str, collection, str2, z11, bVar, str3, str4, false, str5, z12, k.INSTAGRAM, z13, z14, ""), cVar);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final Intent m(f fVar, String str, Collection collection, String str2, boolean z10, com.facebook.login.b bVar, String str3, String str4, boolean z11, String str5, boolean z12, k kVar, boolean z13, boolean z14, String str6) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            String c10 = fVar.c();
            if (c10 == null) {
                return null;
            }
            String str7 = str;
            Intent putExtra = new Intent().setClassName(fVar.d(), c10).putExtra("client_id", str);
            m.e(putExtra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
            putExtra.putExtra("facebook_sdk_version", o.w());
            if (!p0.Z(collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!p0.Y(str2)) {
                String str8 = str2;
                putExtra.putExtra("e2e", str2);
            }
            String str9 = str3;
            putExtra.putExtra("state", str3);
            putExtra.putExtra("response_type", fVar.e());
            putExtra.putExtra("nonce", str6);
            putExtra.putExtra("return_scopes", "true");
            if (z10) {
                putExtra.putExtra("default_audience", bVar.a());
            }
            putExtra.putExtra("legacy_override", o.r());
            String str10 = str4;
            putExtra.putExtra("auth_type", str4);
            if (z11) {
                putExtra.putExtra("fail_on_logged_out", true);
            }
            String str11 = str5;
            putExtra.putExtra("messenger_page_id", str5);
            putExtra.putExtra("reset_messenger_state", z12);
            if (z13) {
                putExtra.putExtra("fx_app", kVar.toString());
            }
            if (z14) {
                putExtra.putExtra("skip_dedupe", true);
            }
            return putExtra;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final Intent n(Context context, String str, String str2, g gVar, Bundle bundle) {
        f c10;
        Intent H;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            if (gVar == null || (c10 = gVar.c()) == null || (H = H(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(c10.d()).addCategory("android.intent.category.DEFAULT"), c10)) == null) {
                return null;
            }
            F(H, str, str2, gVar.d(), bundle);
            return H;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Intent o(Context context) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(context, "context");
            for (f fVar : f23303b) {
                Intent I = I(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(fVar.d()).addCategory("android.intent.category.DEFAULT"), fVar);
                if (I != null) {
                    return I;
                }
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Intent p(Intent intent, Bundle bundle, l lVar) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(intent, "requestIntent");
            UUID t10 = t(intent);
            if (t10 == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", B(intent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", t10.toString());
            if (lVar != null) {
                bundle2.putBundle(Constants.IPC_BUNDLE_KEY_SEND_ERROR, j(lVar));
            }
            intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            if (bundle != null) {
                intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
            }
            return intent2;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final List q(Context context, String str, Collection collection, String str2, boolean z10, boolean z11, com.facebook.login.b bVar, String str3, String str4, boolean z12, String str5, boolean z13, boolean z14, boolean z15, String str6) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "applicationId");
            m.f(collection, "permissions");
            m.f(str2, "e2e");
            m.f(bVar, "defaultAudience");
            m.f(str3, "clientState");
            m.f(str4, "authType");
            ArrayList arrayList = new ArrayList();
            for (f m10 : f23303b) {
                ArrayList arrayList2 = arrayList;
                Intent m11 = f23308g.m(m10, str, collection, str2, z11, bVar, str3, str4, z12, str5, z13, k.FACEBOOK, z14, z15, str6);
                if (m11 != null) {
                    arrayList2.add(m11);
                }
                String str7 = str;
                Collection collection2 = collection;
                String str8 = str2;
                com.facebook.login.b bVar2 = bVar;
                String str9 = str3;
                String str10 = str4;
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[LOOP:0: B:28:0x006d->B:31:0x0073, LOOP_START, SYNTHETIC, Splitter:B:28:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[SYNTHETIC, Splitter:B:36:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[Catch:{ all -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.TreeSet r(q5.f0.f r13) {
        /*
            r12 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = "Failed to query content resolver."
            boolean r2 = v5.a.d(r12)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.util.TreeSet r2 = new java.util.TreeSet     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            android.content.Context r4 = com.facebook.o.f()     // Catch:{ all -> 0x008f }
            android.content.ContentResolver r5 = r4.getContentResolver()     // Catch:{ all -> 0x008f }
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch:{ all -> 0x008f }
            android.net.Uri r6 = r12.h(r13)     // Catch:{ all -> 0x008f }
            android.content.Context r4 = com.facebook.o.f()     // Catch:{ all -> 0x0044 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r8.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r13 = r13.d()     // Catch:{ all -> 0x0044 }
            r8.append(r13)     // Catch:{ all -> 0x0044 }
            java.lang.String r13 = ".provider.PlatformProvider"
            r8.append(r13)     // Catch:{ all -> 0x0044 }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x0044 }
            r8 = 0
            android.content.pm.ProviderInfo r13 = r4.resolveContentProvider(r13, r8)     // Catch:{ RuntimeException -> 0x0047 }
            goto L_0x004e
        L_0x0044:
            r13 = move-exception
            r0 = r3
            goto L_0x0092
        L_0x0047:
            r13 = move-exception
            java.lang.String r4 = f23302a     // Catch:{ all -> 0x0044 }
            android.util.Log.e(r4, r1, r13)     // Catch:{ all -> 0x0044 }
            r13 = r3
        L_0x004e:
            if (r13 == 0) goto L_0x0088
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ NullPointerException -> 0x0065, SecurityException -> 0x005f, IllegalArgumentException -> 0x0058 }
            goto L_0x006b
        L_0x0058:
            java.lang.String r13 = f23302a     // Catch:{ all -> 0x0044 }
            android.util.Log.e(r13, r1)     // Catch:{ all -> 0x0044 }
        L_0x005d:
            r13 = r3
            goto L_0x006b
        L_0x005f:
            java.lang.String r13 = f23302a     // Catch:{ all -> 0x0044 }
            android.util.Log.e(r13, r1)     // Catch:{ all -> 0x0044 }
            goto L_0x005d
        L_0x0065:
            java.lang.String r13 = f23302a     // Catch:{ all -> 0x0044 }
            android.util.Log.e(r13, r1)     // Catch:{ all -> 0x0044 }
            goto L_0x005d
        L_0x006b:
            if (r13 == 0) goto L_0x0089
        L_0x006d:
            boolean r1 = r13.moveToNext()     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0089
            int r1 = r13.getColumnIndex(r0)     // Catch:{ all -> 0x0083 }
            int r1 = r13.getInt(r1)     // Catch:{ all -> 0x0083 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0083 }
            r2.add(r1)     // Catch:{ all -> 0x0083 }
            goto L_0x006d
        L_0x0083:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x0092
        L_0x0088:
            r13 = r3
        L_0x0089:
            if (r13 == 0) goto L_0x0091
            r13.close()     // Catch:{ all -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r13 = move-exception
            goto L_0x0098
        L_0x0091:
            return r2
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()     // Catch:{ all -> 0x008f }
        L_0x0097:
            throw r13     // Catch:{ all -> 0x008f }
        L_0x0098:
            v5.a.b(r13, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.f0.r(q5.f0$f):java.util.TreeSet");
    }

    public static final Bundle s(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(intent, "intent");
            if (!E(B(intent))) {
                return null;
            }
            return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final UUID t(Intent intent) {
        String str;
        Class<f0> cls = f0.class;
        if (v5.a.d(cls) || intent == null) {
            return null;
        }
        try {
            if (E(B(intent))) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                if (bundleExtra != null) {
                    str = bundleExtra.getString("action_id");
                } else {
                    str = null;
                }
            } else {
                str = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (str == null) {
                return null;
            }
            try {
                return UUID.fromString(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final Bundle u(Intent intent) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(intent, "resultIntent");
            if (!D(intent)) {
                return null;
            }
            Bundle s10 = s(intent);
            if (s10 != null) {
                return s10.getBundle(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            }
            return intent.getExtras();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final l v(Bundle bundle) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
            }
            String string2 = bundle.getString("error_description");
            if (string2 == null) {
                string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            }
            if (string == null || !kotlin.text.j.q(string, "UserCanceled", true)) {
                return new l(string2);
            }
            return new n(string2);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final g w(String str, int[] iArr) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "action");
            m.f(iArr, "versionSpec");
            List list = (List) f23305d.get(str);
            if (list == null) {
                list = r.l();
            }
            return f23308g.x(list, iArr);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final g x(List list, int[] iArr) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            G();
            if (list == null) {
                return g.f23311c.b();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                int i10 = i(fVar.b(), z(), iArr);
                if (i10 != -1) {
                    return g.f23311c.a(fVar, i10);
                }
            }
            return g.f23311c.b();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final int y(int i10) {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return 0;
        }
        try {
            return f23308g.x(f23303b, new int[]{i10}).d();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return 0;
        }
    }

    public static final int z() {
        Class<f0> cls = f0.class;
        if (v5.a.d(cls)) {
            return 0;
        }
        try {
            return f23307f[0].intValue();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return 0;
        }
    }
}

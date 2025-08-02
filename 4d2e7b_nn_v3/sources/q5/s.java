package q5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.r;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.k;
import q5.r;

public final class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f23446a;

    /* renamed from: b  reason: collision with root package name */
    private static final List f23447b = r.o("supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Map f23448c = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference f23449d = new AtomicReference(a.NOT_LOADED);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentLinkedQueue f23450e = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f23451f;

    /* renamed from: g  reason: collision with root package name */
    private static JSONArray f23452g;

    /* renamed from: h  reason: collision with root package name */
    public static final s f23453h = new s();

    public enum a {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    public interface b {
        void a();

        void b(r rVar);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f23459a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23460b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23461c;

        c(Context context, String str, String str2) {
            this.f23459a = context;
            this.f23460b = str;
            this.f23461c = str2;
        }

        public final void run() {
            SharedPreferences sharedPreferences;
            r rVar;
            a aVar;
            JSONObject jSONObject;
            if (!v5.a.d(this)) {
                try {
                    sharedPreferences = this.f23459a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                    rVar = null;
                    String string = sharedPreferences.getString(this.f23460b, (String) null);
                    if (!p0.Y(string)) {
                        if (string != null) {
                            jSONObject = new JSONObject(string);
                            if (jSONObject != null) {
                                rVar = s.f23453h.l(this.f23461c, jSONObject);
                            }
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                } catch (JSONException e10) {
                    p0.e0("FacebookSDK", e10);
                    jSONObject = null;
                } catch (Throwable th) {
                    v5.a.b(th, this);
                    return;
                }
                s sVar = s.f23453h;
                JSONObject a10 = sVar.i(this.f23461c);
                if (a10 != null) {
                    sVar.l(this.f23461c, a10);
                    sharedPreferences.edit().putString(this.f23460b, a10.toString()).apply();
                }
                if (rVar != null) {
                    String k10 = rVar.k();
                    if (!s.f23451f && k10 != null && k10.length() > 0) {
                        s.f23451f = true;
                        Log.w(s.f23446a, k10);
                    }
                }
                q.m(this.f23461c, true);
                l2.d.d();
                AtomicReference c10 = s.f23449d;
                if (s.f23448c.containsKey(this.f23461c)) {
                    aVar = a.SUCCESS;
                } else {
                    aVar = a.ERROR;
                }
                c10.set(aVar);
                sVar.n();
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23462a;

        d(b bVar) {
            this.f23462a = bVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23462a.a();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23463a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f23464b;

        e(b bVar, r rVar) {
            this.f23463a = bVar;
            this.f23464b = rVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f23463a.b(this.f23464b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String simpleName = s.class.getSimpleName();
        m.e(simpleName, "FetchedAppSettingsManager::class.java.simpleName");
        f23446a = simpleName;
    }

    private s() {
    }

    public static final void h(b bVar) {
        m.f(bVar, "callback");
        f23450e.add(bVar);
        k();
    }

    /* access modifiers changed from: private */
    public final JSONObject i(String str) {
        GraphRequest graphRequest;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f23447b);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        if (p0.Y(o.n())) {
            graphRequest = GraphRequest.f19541t.v((AccessToken) null, str, (GraphRequest.b) null);
            graphRequest.C(true);
            graphRequest.G(true);
            graphRequest.F(bundle);
        } else {
            graphRequest = GraphRequest.f19541t.v((AccessToken) null, "app", (GraphRequest.b) null);
            graphRequest.C(true);
            graphRequest.F(bundle);
        }
        JSONObject d10 = graphRequest.i().d();
        if (d10 != null) {
            return d10;
        }
        return new JSONObject();
    }

    public static final r j(String str) {
        if (str != null) {
            return (r) f23448c.get(str);
        }
        return null;
    }

    public static final void k() {
        Context f10 = o.f();
        String g10 = o.g();
        if (p0.Y(g10)) {
            f23449d.set(a.ERROR);
            f23453h.n();
        } else if (f23448c.containsKey(g10)) {
            f23449d.set(a.SUCCESS);
            f23453h.n();
        } else {
            AtomicReference atomicReference = f23449d;
            a aVar = a.NOT_LOADED;
            a aVar2 = a.LOADING;
            if (d.a.a(atomicReference, aVar, aVar2) || d.a.a(atomicReference, a.ERROR, aVar2)) {
                b0 b0Var = b0.f709a;
                String format = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{g10}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                o.p().execute(new c(f10, format, g10));
                return;
            }
            f23453h.n();
        }
    }

    private final Map m(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null)) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                r.b.a aVar = r.b.f23440e;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                m.e(optJSONObject, "dialogConfigData.optJSONObject(i)");
                r.b a10 = aVar.a(optJSONObject);
                if (a10 != null) {
                    String a11 = a10.a();
                    Map map = (Map) hashMap.get(a11);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(a11, map);
                    }
                    map.put(a10.c(), a10);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void n() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference r0 = f23449d     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0042 }
            q5.s$a r0 = (q5.s.a) r0     // Catch:{ all -> 0x0042 }
            q5.s$a r1 = q5.s.a.NOT_LOADED     // Catch:{ all -> 0x0042 }
            if (r1 == r0) goto L_0x005f
            q5.s$a r1 = q5.s.a.LOADING     // Catch:{ all -> 0x0042 }
            if (r1 != r0) goto L_0x0012
            goto L_0x005f
        L_0x0012:
            java.lang.String r1 = com.facebook.o.g()     // Catch:{ all -> 0x0042 }
            java.util.Map r2 = f23448c     // Catch:{ all -> 0x0042 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0042 }
            q5.r r1 = (q5.r) r1     // Catch:{ all -> 0x0042 }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0042 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0042 }
            r2.<init>(r3)     // Catch:{ all -> 0x0042 }
            q5.s$a r3 = q5.s.a.ERROR     // Catch:{ all -> 0x0042 }
            if (r3 != r0) goto L_0x0046
        L_0x002b:
            java.util.concurrent.ConcurrentLinkedQueue r0 = f23450e     // Catch:{ all -> 0x0042 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0044
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0042 }
            q5.s$b r0 = (q5.s.b) r0     // Catch:{ all -> 0x0042 }
            q5.s$d r1 = new q5.s$d     // Catch:{ all -> 0x0042 }
            r1.<init>(r0)     // Catch:{ all -> 0x0042 }
            r2.post(r1)     // Catch:{ all -> 0x0042 }
            goto L_0x002b
        L_0x0042:
            r0 = move-exception
            goto L_0x0061
        L_0x0044:
            monitor-exit(r4)
            return
        L_0x0046:
            java.util.concurrent.ConcurrentLinkedQueue r0 = f23450e     // Catch:{ all -> 0x0042 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r3 != 0) goto L_0x005d
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0042 }
            q5.s$b r0 = (q5.s.b) r0     // Catch:{ all -> 0x0042 }
            q5.s$e r3 = new q5.s$e     // Catch:{ all -> 0x0042 }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x0042 }
            r2.post(r3)     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x005d:
            monitor-exit(r4)
            return
        L_0x005f:
            monitor-exit(r4)
            return
        L_0x0061:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.s.n():void");
    }

    public static final r o(String str, boolean z10) {
        m.f(str, "applicationId");
        if (!z10) {
            Map map = f23448c;
            if (map.containsKey(str)) {
                return (r) map.get(str);
            }
        }
        s sVar = f23453h;
        JSONObject i10 = sVar.i(str);
        if (i10 == null) {
            return null;
        }
        r l10 = sVar.l(str, i10);
        if (m.b(str, o.g())) {
            f23449d.set(a.SUCCESS);
            sVar.n();
        }
        return l10;
    }

    public final r l(String str, JSONObject jSONObject) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2;
        JSONObject jSONObject2 = jSONObject;
        m.f(str, "applicationId");
        m.f(jSONObject2, "settingsJSON");
        JSONArray optJSONArray = jSONObject2.optJSONArray("android_sdk_error_categories");
        k.a aVar = k.f23358h;
        k a10 = aVar.a(optJSONArray);
        if (a10 == null) {
            a10 = aVar.b();
        }
        k kVar = a10;
        int optInt = jSONObject2.optInt("app_events_feature_bitmask", 0);
        if ((optInt & 8) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((optInt & 16) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((optInt & 32) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if ((optInt & 256) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if ((optInt & 16384) != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("auto_event_mapping_android");
        f23452g = optJSONArray2;
        if (optJSONArray2 != null && b0.b()) {
            if (optJSONArray2 != null) {
                str2 = optJSONArray2.toString();
            } else {
                str2 = null;
            }
            h2.e.c(str2);
        }
        boolean optBoolean = jSONObject2.optBoolean("supports_implicit_sdk_logging", false);
        String optString = jSONObject2.optString("gdpv4_nux_content", "");
        String str3 = optString;
        m.e(optString, "settingsJSON.optString(A…_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = jSONObject2.optBoolean("gdpv4_nux_enabled", false);
        int optInt2 = jSONObject2.optInt("app_events_session_timeout", l2.e.a());
        EnumSet a11 = j0.f23355g.a(jSONObject2.optLong("seamless_login"));
        Map m10 = m(jSONObject2.optJSONObject("android_dialog_configs"));
        String optString2 = jSONObject2.optString("smart_login_bookmark_icon_url");
        m.e(optString2, "settingsJSON.optString(S…_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = jSONObject2.optString("smart_login_menu_icon_url");
        String str4 = optString3;
        r rVar = r3;
        m.e(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = jSONObject2.optString("sdk_update_message");
        m.e(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        r rVar2 = new r(optBoolean, str3, optBoolean2, optInt2, a11, m10, z10, kVar, optString2, str4, z11, z12, optJSONArray2, optString4, z13, z14, jSONObject2.optString("aam_rules"), jSONObject2.optString("suggested_events_setting"), jSONObject2.optString("restrictive_data_filter_params"));
        r rVar3 = rVar;
        f23448c.put(str, rVar3);
        return rVar3;
    }
}

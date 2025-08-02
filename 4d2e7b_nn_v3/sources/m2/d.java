package m2;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.o;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.g0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.j;
import l2.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.n;
import q5.p0;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f22505a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final List f22506b = r.o("other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout");

    /* renamed from: c  reason: collision with root package name */
    private static final List f22507c = r.o(DevicePublicKeyStringDef.NONE, "address", "health");

    /* renamed from: d  reason: collision with root package name */
    public static final d f22508d = new d();

    public enum a {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public final String a() {
            int i10 = c.f22503a[ordinal()];
            if (i10 == 1) {
                return "integrity_detect";
            }
            if (i10 == 2) {
                return "app_event_pred";
            }
            throw new n();
        }

        public final String b() {
            int i10 = c.f22504b[ordinal()];
            if (i10 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i10 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new n();
        }
    }

    private static final class b {

        /* renamed from: i  reason: collision with root package name */
        public static final a f22512i = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private File f22513a;

        /* renamed from: b  reason: collision with root package name */
        private b f22514b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Runnable f22515c;

        /* renamed from: d  reason: collision with root package name */
        private String f22516d;

        /* renamed from: e  reason: collision with root package name */
        private String f22517e;

        /* renamed from: f  reason: collision with root package name */
        private String f22518f;

        /* renamed from: g  reason: collision with root package name */
        private int f22519g;

        /* renamed from: h  reason: collision with root package name */
        private float[] f22520h;

        public static final class a {

            /* renamed from: m2.d$b$a$a  reason: collision with other inner class name */
            static final class C0305a implements f.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ List f22521a;

                /* renamed from: m2.d$b$a$a$a  reason: collision with other inner class name */
                static final class C0306a implements f.a {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f22522a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ b f22523b;

                    C0306a(b bVar, b bVar2) {
                        this.f22522a = bVar;
                        this.f22523b = bVar2;
                    }

                    public final void a(File file) {
                        m.f(file, "file");
                        this.f22522a.i(this.f22523b);
                        this.f22522a.k(file);
                        Runnable a10 = this.f22522a.f22515c;
                        if (a10 != null) {
                            a10.run();
                        }
                    }
                }

                C0305a(List list) {
                    this.f22521a = list;
                }

                public final void a(File file) {
                    m.f(file, "file");
                    b a10 = b.f22490n.a(file);
                    if (a10 != null) {
                        for (b bVar : this.f22521a) {
                            b.f22512i.d(bVar.e(), bVar.g() + "_" + bVar.h() + "_rule", new C0306a(bVar, a10));
                        }
                    }
                }
            }

            private a() {
            }

            private final void c(String str, int i10) {
                File[] listFiles;
                File a10 = g.a();
                if (a10 != null && (listFiles = a10.listFiles()) != null && listFiles.length != 0) {
                    String str2 = str + "_" + i10;
                    for (File file : listFiles) {
                        m.e(file, "f");
                        String name = file.getName();
                        m.e(name, "name");
                        if (j.F(name, str, false, 2, (Object) null) && !j.F(name, str2, false, 2, (Object) null)) {
                            file.delete();
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            public final void d(String str, String str2, f.a aVar) {
                File file = new File(g.a(), str2);
                if (str == null || file.exists()) {
                    aVar.a(file);
                } else {
                    new f(str, file, aVar).execute(new String[0]);
                }
            }

            public final b b(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    String string = jSONObject.getString("use_case");
                    String string2 = jSONObject.getString("asset_uri");
                    String optString = jSONObject.optString("rules_uri", (String) null);
                    int i10 = jSONObject.getInt("version_id");
                    float[] e10 = d.e(d.f22508d, jSONObject.getJSONArray("thresholds"));
                    m.e(string, "useCase");
                    m.e(string2, "assetUri");
                    return new b(string, string2, optString, i10, e10);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void e(b bVar, List list) {
                m.f(bVar, "master");
                m.f(list, "slaves");
                c(bVar.g(), bVar.h());
                d(bVar.b(), bVar.g() + "_" + bVar.h(), new C0305a(list));
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str, String str2, String str3, int i10, float[] fArr) {
            m.f(str, "useCase");
            m.f(str2, "assetUri");
            this.f22516d = str;
            this.f22517e = str2;
            this.f22518f = str3;
            this.f22519g = i10;
            this.f22520h = fArr;
        }

        public final String b() {
            return this.f22517e;
        }

        public final b c() {
            return this.f22514b;
        }

        public final File d() {
            return this.f22513a;
        }

        public final String e() {
            return this.f22518f;
        }

        public final float[] f() {
            return this.f22520h;
        }

        public final String g() {
            return this.f22516d;
        }

        public final int h() {
            return this.f22519g;
        }

        public final void i(b bVar) {
            this.f22514b = bVar;
        }

        public final b j(Runnable runnable) {
            this.f22515c = runnable;
            return this;
        }

        public final void k(File file) {
            this.f22513a = file;
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final c f22524a = new c();

        c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0055 A[Catch:{ Exception -> 0x0079, all -> 0x002a }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r7 = this;
                java.lang.String r0 = "model_request_timestamp"
                java.lang.String r1 = "models"
                boolean r2 = v5.a.d(r7)
                if (r2 == 0) goto L_0x000b
                return
            L_0x000b:
                android.content.Context r2 = com.facebook.o.f()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                r4 = 0
                android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                r3 = 0
                java.lang.String r3 = r2.getString(r1, r3)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r3 == 0) goto L_0x002c
                int r4 = r3.length()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r4 != 0) goto L_0x0024
                goto L_0x002c
            L_0x0024:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                r4.<init>(r3)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                goto L_0x0031
            L_0x002a:
                r0 = move-exception
                goto L_0x0076
            L_0x002c:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                r4.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
            L_0x0031:
                r5 = 0
                long r5 = r2.getLong(r0, r5)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                q5.n$b r3 = q5.n.b.ModelRequest     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                boolean r3 = q5.n.g(r3)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r3 == 0) goto L_0x004d
                int r3 = r4.length()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r3 == 0) goto L_0x004d
                m2.d r3 = m2.d.f22508d     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                boolean r3 = m2.d.d(r3, r5)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r3 != 0) goto L_0x006c
            L_0x004d:
                m2.d r3 = m2.d.f22508d     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                org.json.JSONObject r4 = m2.d.c(r3)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                if (r4 == 0) goto L_0x0075
                android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                r0.apply()     // Catch:{ Exception -> 0x0079, all -> 0x002a }
            L_0x006c:
                m2.d r0 = m2.d.f22508d     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                m2.d.a(r0, r4)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                m2.d.b(r0)     // Catch:{ Exception -> 0x0079, all -> 0x002a }
                goto L_0x0079
            L_0x0075:
                return
            L_0x0076:
                v5.a.b(r0, r7)
            L_0x0079:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m2.d.c.run():void");
        }
    }

    /* renamed from: m2.d$d  reason: collision with other inner class name */
    static final class C0307d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C0307d f22525a = new C0307d();

        C0307d() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    p2.d.c();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final e f22526a = new e();

        e() {
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    k2.a.a();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private d() {
    }

    public static final /* synthetic */ void a(d dVar, JSONObject jSONObject) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                dVar.f(jSONObject);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                dVar.h();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ JSONObject c(d dVar) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return dVar.i();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ boolean d(d dVar, long j10) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            return dVar.l(j10);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    public static final /* synthetic */ float[] e(d dVar, JSONArray jSONArray) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return dVar.m(jSONArray);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final void f(JSONObject jSONObject) {
        if (!v5.a.d(this)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        b b10 = b.f22512i.b(jSONObject.getJSONObject(keys.next()));
                        if (b10 != null) {
                            f22505a.put(b10.g(), b10);
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public static final void g() {
        Class<d> cls = d.class;
        if (!v5.a.d(cls)) {
            try {
                p0.x0(c.f22524a);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void h() {
        if (!v5.a.d(this)) {
            try {
                ArrayList arrayList = new ArrayList();
                String str = null;
                int i10 = 0;
                for (Map.Entry entry : f22505a.entrySet()) {
                    String str2 = (String) entry.getKey();
                    b bVar = (b) entry.getValue();
                    if (m.b(str2, a.MTML_APP_EVENT_PREDICTION.b())) {
                        str = bVar.b();
                        i10 = Math.max(i10, bVar.h());
                        if (q5.n.g(n.b.SuggestedEvents) && k()) {
                            arrayList.add(bVar.j(C0307d.f22525a));
                        }
                    }
                    if (m.b(str2, a.MTML_INTEGRITY_DETECT.b())) {
                        String b10 = bVar.b();
                        int max = Math.max(i10, bVar.h());
                        if (q5.n.g(n.b.IntelligentIntegrity)) {
                            arrayList.add(bVar.j(e.f22526a));
                        }
                        str = b10;
                        i10 = max;
                    }
                }
                if (str != null && i10 > 0 && !arrayList.isEmpty()) {
                    b.f22512i.e(new b("MTML", str, (String) null, i10, (float[]) null), arrayList);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final JSONObject i() {
        JSONObject jSONObject;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
            if (p0.Y(o.n())) {
                GraphRequest.c cVar = GraphRequest.f19541t;
                b0 b0Var = b0.f709a;
                String format = String.format("%s/model_asset", Arrays.copyOf(new Object[]{o.g()}, 1));
                m.e(format, "java.lang.String.format(format, *args)");
                GraphRequest v10 = cVar.v((AccessToken) null, format, (GraphRequest.b) null);
                v10.G(true);
                v10.F(bundle);
                jSONObject = v10.i().c();
                if (jSONObject == null) {
                    return null;
                }
            } else {
                GraphRequest v11 = GraphRequest.f19541t.v((AccessToken) null, "app/model_asset", (GraphRequest.b) null);
                v11.F(bundle);
                jSONObject = v11.i().c();
                if (jSONObject == null) {
                    return null;
                }
            }
            return n(jSONObject);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public static final File j(a aVar) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "task");
            b bVar = (b) f22505a.get(aVar.b());
            if (bVar != null) {
                return bVar.d();
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final boolean k() {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            Locale I = p0.I();
            if (I != null) {
                String language = I.getLanguage();
                m.e(language, "locale.language");
                if (j.K(language, "en", false, 2, (Object) null)) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    private final boolean l(long j10) {
        if (v5.a.d(this) || j10 == 0) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - j10 < ((long) 259200000)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    private final float[] m(JSONArray jSONArray) {
        if (v5.a.d(this) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    String string = jSONArray.getString(i10);
                    m.e(string, "jsonArray.getString(i)");
                    fArr[i10] = Float.parseFloat(string);
                } catch (JSONException unused) {
                }
            }
            return fArr;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return new org.json.JSONObject();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject n(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "asset_uri"
            java.lang.String r1 = "thresholds"
            java.lang.String r2 = "version_id"
            java.lang.String r3 = "rules_uri"
            java.lang.String r4 = "use_case"
            boolean r5 = v5.a.d(r12)
            r6 = 0
            if (r5 == 0) goto L_0x0012
            return r6
        L_0x0012:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0057 }
            r5.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r7 = "data"
            org.json.JSONArray r13 = r13.getJSONArray(r7)     // Catch:{ JSONException -> 0x0063 }
            int r7 = r13.length()     // Catch:{ JSONException -> 0x0063 }
            r8 = 0
        L_0x0022:
            if (r8 >= r7) goto L_0x0068
            org.json.JSONObject r9 = r13.getJSONObject(r8)     // Catch:{ JSONException -> 0x0063 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0063 }
            r10.<init>()     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r11 = r9.getString(r2)     // Catch:{ JSONException -> 0x0063 }
            r10.put(r2, r11)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r11 = r9.getString(r4)     // Catch:{ JSONException -> 0x0063 }
            r10.put(r4, r11)     // Catch:{ JSONException -> 0x0063 }
            org.json.JSONArray r11 = r9.getJSONArray(r1)     // Catch:{ JSONException -> 0x0063 }
            r10.put(r1, r11)     // Catch:{ JSONException -> 0x0063 }
            java.lang.String r11 = r9.getString(r0)     // Catch:{ JSONException -> 0x0063 }
            r10.put(r0, r11)     // Catch:{ JSONException -> 0x0063 }
            boolean r11 = r9.has(r3)     // Catch:{ JSONException -> 0x0063 }
            if (r11 == 0) goto L_0x0059
            java.lang.String r11 = r9.getString(r3)     // Catch:{ JSONException -> 0x0063 }
            r10.put(r3, r11)     // Catch:{ JSONException -> 0x0063 }
            goto L_0x0059
        L_0x0057:
            r13 = move-exception
            goto L_0x0069
        L_0x0059:
            java.lang.String r9 = r9.getString(r4)     // Catch:{ JSONException -> 0x0063 }
            r5.put(r9, r10)     // Catch:{ JSONException -> 0x0063 }
            int r8 = r8 + 1
            goto L_0x0022
        L_0x0063:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0057 }
            r5.<init>()     // Catch:{ all -> 0x0057 }
        L_0x0068:
            return r5
        L_0x0069:
            v5.a.b(r13, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.d.n(org.json.JSONObject):org.json.JSONObject");
    }

    public static final String[] o(a aVar, float[][] fArr, String[] strArr) {
        b c10;
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "task");
            m.f(fArr, "denses");
            m.f(strArr, "texts");
            b bVar = (b) f22505a.get(aVar.b());
            if (bVar == null || (c10 = bVar.c()) == null) {
                return null;
            }
            float[] f10 = bVar.f();
            int length = strArr.length;
            int length2 = fArr[0].length;
            a aVar2 = new a(new int[]{length, length2});
            for (int i10 = 0; i10 < length; i10++) {
                System.arraycopy(fArr[i10], 0, aVar2.a(), i10 * length2, length2);
            }
            a b10 = c10.b(aVar2, strArr, aVar.a());
            if (b10 == null || f10 == null) {
                return null;
            }
            if (b10.a().length == 0) {
                return null;
            }
            if (f10.length == 0) {
                return null;
            }
            int i11 = e.f22527a[aVar.ordinal()];
            if (i11 == 1) {
                return f22508d.q(b10, f10);
            }
            if (i11 == 2) {
                return f22508d.p(b10, f10);
            }
            throw new kotlin.n();
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final String[] p(a aVar, float[] fArr) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            int b10 = aVar.b(0);
            int b11 = aVar.b(1);
            float[] a10 = aVar.a();
            if (b11 != fArr.length) {
                return null;
            }
            IntRange l10 = l.l(0, b10);
            ArrayList arrayList = new ArrayList(r.v(l10, 10));
            Iterator it = l10.iterator();
            while (it.hasNext()) {
                int nextInt = ((g0) it).nextInt();
                String str = DevicePublicKeyStringDef.NONE;
                int length = fArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    if (a10[(nextInt * b11) + i11] >= fArr[i10]) {
                        str = (String) f22507c.get(i11);
                    }
                    i10++;
                    i11 = i12;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final String[] q(a aVar, float[] fArr) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            int b10 = aVar.b(0);
            int b11 = aVar.b(1);
            float[] a10 = aVar.a();
            if (b11 != fArr.length) {
                return null;
            }
            IntRange l10 = l.l(0, b10);
            ArrayList arrayList = new ArrayList(r.v(l10, 10));
            Iterator it = l10.iterator();
            while (it.hasNext()) {
                int nextInt = ((g0) it).nextInt();
                String str = "other";
                int length = fArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    if (a10[(nextInt * b11) + i11] >= fArr[i10]) {
                        str = (String) f22506b.get(i11);
                    }
                    i10++;
                    i11 = i12;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }
}

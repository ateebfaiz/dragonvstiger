package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.s;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d;
import q5.d0;
import q5.f0;
import q5.g0;
import q5.p0;
import q5.s0;
import q5.t;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final String f4419o = "d";
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static q5.t f4420p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final ConcurrentHashMap f4421q = new ConcurrentHashMap();

    /* renamed from: r  reason: collision with root package name */
    private static s0 f4422r = new s0(1);

    /* renamed from: s  reason: collision with root package name */
    private static s0 f4423s = new s0(1);

    /* renamed from: t  reason: collision with root package name */
    private static Handler f4424t;

    /* renamed from: u  reason: collision with root package name */
    private static String f4425u;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f4426v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static volatile int f4427w;

    /* renamed from: x  reason: collision with root package name */
    private static com.facebook.e f4428x;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f4429a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LikeView.g f4430b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f4431c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f4432d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f4433e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f4434f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f4435g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f4436h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f4437i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f4438j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f4439k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f4440l;

    /* renamed from: m  reason: collision with root package name */
    private Bundle f4441m;

    /* renamed from: n  reason: collision with root package name */
    private e2.m f4442n;

    class a implements g0.b {
        a() {
        }

        public void completed(Bundle bundle) {
            String C;
            String D;
            String E;
            String c10;
            String d10;
            if (bundle != null && bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                boolean z10 = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                    C = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
                } else {
                    C = d.this.f4432d;
                }
                String str = C;
                if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                    D = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
                } else {
                    D = d.this.f4433e;
                }
                String str2 = D;
                if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                    E = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
                } else {
                    E = d.this.f4434f;
                }
                String str3 = E;
                if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                    c10 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
                } else {
                    c10 = d.this.f4435g;
                }
                String str4 = c10;
                if (bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                    d10 = bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
                } else {
                    d10 = d.this.f4436h;
                }
                d.this.u0(z10, str, str2, str3, str4, d10);
            }
        }
    }

    private static class a0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f4444a;

        /* renamed from: b  reason: collision with root package name */
        private String f4445b;

        a0(String str, String str2) {
            this.f4444a = str;
            this.f4445b = str2;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    d.o0(this.f4444a, this.f4445b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class b implements s.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f4446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f4447b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f4448c;

        b(q qVar, s sVar, y yVar) {
            this.f4446a = qVar;
            this.f4447b = sVar;
            this.f4448c = yVar;
        }

        public void a(com.facebook.s sVar) {
            FacebookRequestError facebookRequestError;
            String unused = d.this.f4437i = this.f4446a.f4485f;
            if (p0.Y(d.this.f4437i)) {
                String unused2 = d.this.f4437i = this.f4447b.f4492f;
                boolean unused3 = d.this.f4438j = this.f4447b.f4493g;
            }
            if (p0.Y(d.this.f4437i)) {
                d0.g(com.facebook.w.DEVELOPER_ERRORS, d.f4419o, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", d.this.f4429a);
                d dVar = d.this;
                if (this.f4447b.d() != null) {
                    facebookRequestError = this.f4447b.d();
                } else {
                    facebookRequestError = this.f4446a.d();
                }
                dVar.Z("get_verified_id", facebookRequestError);
            }
            y yVar = this.f4448c;
            if (yVar != null) {
                yVar.onComplete();
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4450a;

        static {
            int[] iArr = new int[LikeView.g.values().length];
            f4450a = iArr;
            try {
                iArr[LikeView.g.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.facebook.share.internal.d$d  reason: collision with other inner class name */
    static class C0063d implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4451a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4452b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Intent f4453c;

        C0063d(int i10, int i11, Intent intent) {
            this.f4451a = i10;
            this.f4452b = i11;
            this.f4453c = intent;
        }

        public void a(d dVar, com.facebook.l lVar) {
            if (lVar == null) {
                dVar.a0(this.f4451a, this.f4452b, this.f4453c);
            } else {
                p0.e0(d.f4419o, lVar);
            }
        }
    }

    static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f4454a;

        e(d dVar) {
            this.f4454a = dVar;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f4454a.j0();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static class f implements d.a {
        f() {
        }

        public boolean a(int i10, Intent intent) {
            return d.V(d.c.Like.a(), i10, intent);
        }
    }

    static class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f4455a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f4456b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.facebook.l f4457c;

        g(o oVar, d dVar, com.facebook.l lVar) {
            this.f4455a = oVar;
            this.f4456b = dVar;
            this.f4457c = lVar;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    this.f4455a.a(this.f4456b, this.f4457c);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static class h extends com.facebook.e {
        h() {
        }

        /* access modifiers changed from: protected */
        public void d(AccessToken accessToken, AccessToken accessToken2) {
            Context f10 = com.facebook.o.f();
            if (accessToken2 == null) {
                int unused = d.f4427w = (d.f4427w + 1) % 1000;
                f10.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", d.f4427w).apply();
                d.f4421q.clear();
                d.f4420p.f();
            }
            d.F((d) null, "com.facebook.sdk.LikeActionController.DID_RESET");
        }
    }

    class i extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f4458b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(com.facebook.j jVar, Bundle bundle) {
            super(jVar);
            this.f4458b = bundle;
        }

        public void a(q5.a aVar) {
            b(aVar, new com.facebook.n());
        }

        public void b(q5.a aVar, com.facebook.l lVar) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Like Dialog failed with error : %s", lVar);
            Bundle bundle = this.f4458b;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("call_id", aVar.d().toString());
            d.this.Y("present_dialog", bundle);
            d.G(d.this, "com.facebook.sdk.LikeActionController.DID_ERROR", f0.j(lVar));
        }

        public void c(q5.a aVar, Bundle bundle) {
            String str;
            String str2;
            String str3;
            String str4;
            String d10;
            if (bundle != null && bundle.containsKey("object_is_liked")) {
                boolean z10 = bundle.getBoolean("object_is_liked");
                String C = d.this.f4432d;
                String D = d.this.f4433e;
                if (bundle.containsKey("like_count_string")) {
                    str2 = bundle.getString("like_count_string");
                    str = str2;
                } else {
                    str2 = C;
                    str = D;
                }
                String E = d.this.f4434f;
                String c10 = d.this.f4435g;
                if (bundle.containsKey("social_sentence")) {
                    str4 = bundle.getString("social_sentence");
                    str3 = str4;
                } else {
                    str4 = E;
                    str3 = c10;
                }
                if (bundle.containsKey("object_is_liked")) {
                    d10 = bundle.getString("unlike_token");
                } else {
                    d10 = d.this.f4436h;
                }
                String str5 = d10;
                Bundle bundle2 = this.f4458b;
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putString("call_id", aVar.d().toString());
                d.this.N().g("fb_like_control_dialog_did_succeed", bundle2);
                d.this.u0(z10, str2, str, str4, str3, str5);
            }
        }
    }

    class j implements y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f4460a;

        class a implements s.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ w f4462a;

            a(w wVar) {
                this.f4462a = wVar;
            }

            public void a(com.facebook.s sVar) {
                boolean unused = d.this.f4440l = false;
                if (this.f4462a.d() != null) {
                    d.this.e0(false);
                    return;
                }
                String unused2 = d.this.f4436h = p0.j(this.f4462a.f4501f, (String) null);
                boolean unused3 = d.this.f4439k = true;
                d.this.N().h("fb_like_control_did_like", (Double) null, j.this.f4460a);
                j jVar = j.this;
                d.this.d0(jVar.f4460a);
            }
        }

        j(Bundle bundle) {
            this.f4460a = bundle;
        }

        public void onComplete() {
            if (p0.Y(d.this.f4437i)) {
                Bundle bundle = new Bundle();
                bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                d.G(d.this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
                return;
            }
            com.facebook.s sVar = new com.facebook.s();
            d dVar = d.this;
            w wVar = new w(dVar.f4437i, d.this.f4430b);
            wVar.a(sVar);
            sVar.d(new a(wVar));
            sVar.i();
        }
    }

    class k implements s.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f4464a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f4465b;

        k(x xVar, Bundle bundle) {
            this.f4464a = xVar;
            this.f4465b = bundle;
        }

        public void a(com.facebook.s sVar) {
            boolean unused = d.this.f4440l = false;
            if (this.f4464a.d() != null) {
                d.this.e0(true);
                return;
            }
            String unused2 = d.this.f4436h = null;
            boolean unused3 = d.this.f4439k = false;
            d.this.N().h("fb_like_control_did_unlike", (Double) null, this.f4465b);
            d.this.d0(this.f4465b);
        }
    }

    class l implements y {

        class a implements s.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ u f4468a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ p f4469b;

            a(u uVar, p pVar) {
                this.f4468a = uVar;
                this.f4469b = pVar;
            }

            public void a(com.facebook.s sVar) {
                if (this.f4468a.d() == null && this.f4469b.d() == null) {
                    d dVar = d.this;
                    boolean b10 = this.f4468a.b();
                    p pVar = this.f4469b;
                    dVar.u0(b10, pVar.f4480f, pVar.f4481g, pVar.f4482h, pVar.f4483i, this.f4468a.c());
                    return;
                }
                d0.g(com.facebook.w.REQUESTS, d.f4419o, "Unable to refresh like state for id: '%s'", d.this.f4429a);
            }
        }

        l() {
        }

        public void onComplete() {
            u uVar;
            if (c.f4450a[d.this.f4430b.ordinal()] != 1) {
                d dVar = d.this;
                uVar = new r(dVar.f4437i, d.this.f4430b);
            } else {
                d dVar2 = d.this;
                uVar = new t(dVar2.f4437i);
            }
            d dVar3 = d.this;
            p pVar = new p(dVar3.f4437i, d.this.f4430b);
            com.facebook.s sVar = new com.facebook.s();
            uVar.a(sVar);
            pVar.a(sVar);
            sVar.d(new a(uVar, pVar));
            sVar.i();
        }
    }

    private abstract class m implements z {

        /* renamed from: a  reason: collision with root package name */
        private GraphRequest f4471a;

        /* renamed from: b  reason: collision with root package name */
        protected String f4472b;

        /* renamed from: c  reason: collision with root package name */
        protected LikeView.g f4473c;

        /* renamed from: d  reason: collision with root package name */
        protected FacebookRequestError f4474d;

        class a implements GraphRequest.b {
            a() {
            }

            public void a(com.facebook.t tVar) {
                m.this.f4474d = tVar.b();
                m mVar = m.this;
                FacebookRequestError facebookRequestError = mVar.f4474d;
                if (facebookRequestError != null) {
                    mVar.e(facebookRequestError);
                } else {
                    mVar.f(tVar);
                }
            }
        }

        protected m(String str, LikeView.g gVar) {
            this.f4472b = str;
            this.f4473c = gVar;
        }

        public void a(com.facebook.s sVar) {
            sVar.add(this.f4471a);
        }

        public FacebookRequestError d() {
            return this.f4474d;
        }

        /* access modifiers changed from: protected */
        public abstract void e(FacebookRequestError facebookRequestError);

        /* access modifiers changed from: protected */
        public abstract void f(com.facebook.t tVar);

        /* access modifiers changed from: protected */
        public void g(GraphRequest graphRequest) {
            this.f4471a = graphRequest;
            graphRequest.I(com.facebook.o.r());
            graphRequest.B(new a());
        }
    }

    private static class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f4477a;

        /* renamed from: b  reason: collision with root package name */
        private LikeView.g f4478b;

        /* renamed from: c  reason: collision with root package name */
        private o f4479c;

        n(String str, LikeView.g gVar, o oVar) {
            this.f4477a = str;
            this.f4478b = gVar;
            this.f4479c = oVar;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    d.J(this.f4477a, this.f4478b, this.f4479c);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public interface o {
        void a(d dVar, com.facebook.l lVar);
    }

    private class p extends m {

        /* renamed from: f  reason: collision with root package name */
        String f4480f;

        /* renamed from: g  reason: collision with root package name */
        String f4481g;

        /* renamed from: h  reason: collision with root package name */
        String f4482h;

        /* renamed from: i  reason: collision with root package name */
        String f4483i;

        p(String str, LikeView.g gVar) {
            super(str, gVar);
            this.f4480f = d.this.f4432d;
            this.f4481g = d.this.f4433e;
            this.f4482h = d.this.f4434f;
            this.f4483i = d.this.f4435g;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            g(new GraphRequest(AccessToken.d(), str, bundle, com.facebook.u.GET));
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error fetching engagement for object '%s' with type '%s' : %s", this.f4472b, this.f4473c, facebookRequestError);
            d.this.Z("get_engagement", facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            JSONObject E0 = p0.E0(tVar.c(), "engagement");
            if (E0 != null) {
                this.f4480f = E0.optString("count_string_with_like", this.f4480f);
                this.f4481g = E0.optString("count_string_without_like", this.f4481g);
                this.f4482h = E0.optString("social_sentence_with_like", this.f4482h);
                this.f4483i = E0.optString("social_sentence_without_like", this.f4483i);
            }
        }
    }

    private class q extends m {

        /* renamed from: f  reason: collision with root package name */
        String f4485f;

        q(String str, LikeView.g gVar) {
            super(str, gVar);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            g(new GraphRequest(AccessToken.d(), "", bundle, com.facebook.u.GET));
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.c().contains("og_object")) {
                this.f4474d = null;
                return;
            }
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error getting the FB id for object '%s' with type '%s' : %s", this.f4472b, this.f4473c, facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            JSONObject optJSONObject;
            JSONObject E0 = p0.E0(tVar.c(), this.f4472b);
            if (E0 != null && (optJSONObject = E0.optJSONObject("og_object")) != null) {
                this.f4485f = optJSONObject.optString("id");
            }
        }
    }

    private class r extends m implements u {

        /* renamed from: f  reason: collision with root package name */
        private boolean f4487f;

        /* renamed from: g  reason: collision with root package name */
        private String f4488g;

        /* renamed from: h  reason: collision with root package name */
        private final String f4489h;

        /* renamed from: i  reason: collision with root package name */
        private final LikeView.g f4490i;

        r(String str, LikeView.g gVar) {
            super(str, gVar);
            this.f4487f = d.this.f4431c;
            this.f4489h = str;
            this.f4490i = gVar;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", str);
            g(new GraphRequest(AccessToken.d(), "me/og.likes", bundle, com.facebook.u.GET));
        }

        public boolean b() {
            return this.f4487f;
        }

        public String c() {
            return this.f4488g;
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error fetching like status for object '%s' with type '%s' : %s", this.f4489h, this.f4490i, facebookRequestError);
            d.this.Z("get_og_object_like", facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            JSONArray D0 = p0.D0(tVar.c(), "data");
            if (D0 != null) {
                for (int i10 = 0; i10 < D0.length(); i10++) {
                    JSONObject optJSONObject = D0.optJSONObject(i10);
                    if (optJSONObject != null) {
                        this.f4487f = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken d10 = AccessToken.d();
                        if (optJSONObject2 != null && AccessToken.o() && p0.c(d10.c(), optJSONObject2.optString("id"))) {
                            this.f4488g = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }
    }

    private class s extends m {

        /* renamed from: f  reason: collision with root package name */
        String f4492f;

        /* renamed from: g  reason: collision with root package name */
        boolean f4493g;

        s(String str, LikeView.g gVar) {
            super(str, gVar);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            g(new GraphRequest(AccessToken.d(), "", bundle, com.facebook.u.GET));
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error getting the FB id for object '%s' with type '%s' : %s", this.f4472b, this.f4473c, facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            JSONObject E0 = p0.E0(tVar.c(), this.f4472b);
            if (E0 != null) {
                String optString = E0.optString("id");
                this.f4492f = optString;
                this.f4493g = !p0.Y(optString);
            }
        }
    }

    private class t extends m implements u {

        /* renamed from: f  reason: collision with root package name */
        private boolean f4495f;

        /* renamed from: g  reason: collision with root package name */
        private String f4496g;

        t(String str) {
            super(str, LikeView.g.PAGE);
            this.f4495f = d.this.f4431c;
            this.f4496g = str;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            AccessToken d10 = AccessToken.d();
            g(new GraphRequest(d10, "me/likes/" + str, bundle, com.facebook.u.GET));
        }

        public boolean b() {
            return this.f4495f;
        }

        public String c() {
            return null;
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error fetching like status for page id '%s': %s", this.f4496g, facebookRequestError);
            d.this.Z("get_page_like", facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            JSONArray D0 = p0.D0(tVar.c(), "data");
            if (D0 != null && D0.length() > 0) {
                this.f4495f = true;
            }
        }
    }

    private interface u extends z {
        boolean b();

        String c();
    }

    private static class v implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private static ArrayList f4498c = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        private String f4499a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4500b;

        v(String str, boolean z10) {
            this.f4499a = str;
            this.f4500b = z10;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    String str = this.f4499a;
                    if (str != null) {
                        f4498c.remove(str);
                        f4498c.add(0, this.f4499a);
                    }
                    if (this.f4500b && f4498c.size() >= 128) {
                        while (64 < f4498c.size()) {
                            ArrayList arrayList = f4498c;
                            d.f4421q.remove((String) arrayList.remove(arrayList.size() - 1));
                        }
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private class w extends m {

        /* renamed from: f  reason: collision with root package name */
        String f4501f;

        w(String str, LikeView.g gVar) {
            super(str, gVar);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            g(new GraphRequest(AccessToken.d(), "me/og.likes", bundle, com.facebook.u.POST));
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.b() == 3501) {
                this.f4474d = null;
                return;
            }
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error liking object '%s' with type '%s' : %s", this.f4472b, this.f4473c, facebookRequestError);
            d.this.Z("publish_like", facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
            this.f4501f = p0.y0(tVar.c(), "id");
        }
    }

    private class x extends m {

        /* renamed from: f  reason: collision with root package name */
        private String f4503f;

        x(String str) {
            super((String) null, (LikeView.g) null);
            this.f4503f = str;
            g(new GraphRequest(AccessToken.d(), str, (Bundle) null, com.facebook.u.DELETE));
        }

        /* access modifiers changed from: protected */
        public void e(FacebookRequestError facebookRequestError) {
            d0.g(com.facebook.w.REQUESTS, d.f4419o, "Error unliking object with unlike token '%s' : %s", this.f4503f, facebookRequestError);
            d.this.Z("publish_unlike", facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void f(com.facebook.t tVar) {
        }
    }

    private interface y {
        void onComplete();
    }

    private interface z {
        void a(com.facebook.s sVar);

        FacebookRequestError d();
    }

    private d(String str, LikeView.g gVar) {
        this.f4429a = str;
        this.f4430b = gVar;
    }

    /* access modifiers changed from: private */
    public static void F(d dVar, String str) {
        G(dVar, str, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static void G(d dVar, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (dVar != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", dVar.S());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(com.facebook.o.f()).sendBroadcast(intent);
    }

    private boolean H() {
        AccessToken d10 = AccessToken.d();
        if (this.f4438j || this.f4437i == null || !AccessToken.o() || d10.k() == null || !d10.k().contains("publish_actions")) {
            return false;
        }
        return true;
    }

    private void I() {
        this.f4441m = null;
        r0((String) null);
    }

    /* access modifiers changed from: private */
    public static void J(String str, LikeView.g gVar, o oVar) {
        d Q = Q(str);
        if (Q != null) {
            v0(Q, gVar, oVar);
            return;
        }
        d K = K(str);
        if (K == null) {
            K = new d(str, gVar);
            n0(K);
        }
        i0(str, K);
        f4424t.post(new e(K));
        W(oVar, K, (com.facebook.l) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r5 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        q5.p0.i(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r5 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.facebook.share.internal.d K(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.String r5 = O(r5)     // Catch:{ IOException -> 0x002b, all -> 0x0026 }
            q5.t r1 = f4420p     // Catch:{ IOException -> 0x002b, all -> 0x0026 }
            java.io.InputStream r5 = r1.g(r5)     // Catch:{ IOException -> 0x002b, all -> 0x0026 }
            if (r5 == 0) goto L_0x0020
            java.lang.String r1 = q5.p0.p0(r5)     // Catch:{ IOException -> 0x001e }
            boolean r2 = q5.p0.Y(r1)     // Catch:{ IOException -> 0x001e }
            if (r2 != 0) goto L_0x0020
            com.facebook.share.internal.d r0 = L(r1)     // Catch:{ IOException -> 0x001e }
            goto L_0x0020
        L_0x001c:
            r0 = move-exception
            goto L_0x0038
        L_0x001e:
            r1 = move-exception
            goto L_0x002d
        L_0x0020:
            if (r5 == 0) goto L_0x0037
        L_0x0022:
            q5.p0.i(r5)
            goto L_0x0037
        L_0x0026:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0038
        L_0x002b:
            r1 = move-exception
            r5 = r0
        L_0x002d:
            java.lang.String r2 = f4419o     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "Unable to deserialize controller from disk"
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x001c }
            if (r5 == 0) goto L_0x0037
            goto L_0x0022
        L_0x0037:
            return r0
        L_0x0038:
            if (r5 == 0) goto L_0x003d
            q5.p0.i(r5)
        L_0x003d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.d.K(java.lang.String):com.facebook.share.internal.d");
    }

    private static d L(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            d dVar = new d(jSONObject.getString("object_id"), LikeView.g.a(jSONObject.optInt("object_type", LikeView.g.UNKNOWN.b())));
            dVar.f4432d = jSONObject.optString("like_count_string_with_like", (String) null);
            dVar.f4433e = jSONObject.optString("like_count_string_without_like", (String) null);
            dVar.f4434f = jSONObject.optString("social_sentence_with_like", (String) null);
            dVar.f4435g = jSONObject.optString("social_sentence_without_like", (String) null);
            dVar.f4431c = jSONObject.optBoolean("is_object_liked");
            dVar.f4436h = jSONObject.optString("unlike_token", (String) null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                dVar.f4441m = q5.c.a(optJSONObject);
            }
            return dVar;
        } catch (JSONException e10) {
            Log.e(f4419o, "Unable to deserialize controller from JSON", e10);
            return null;
        }
    }

    private void M(y yVar) {
        if (p0.Y(this.f4437i)) {
            q qVar = new q(this.f4429a, this.f4430b);
            s sVar = new s(this.f4429a, this.f4430b);
            com.facebook.s sVar2 = new com.facebook.s();
            qVar.a(sVar2);
            sVar.a(sVar2);
            sVar2.d(new b(qVar, sVar, yVar));
            sVar2.i();
        } else if (yVar != null) {
            yVar.onComplete();
        }
    }

    /* access modifiers changed from: private */
    public e2.m N() {
        if (this.f4442n == null) {
            this.f4442n = new e2.m(com.facebook.o.f());
        }
        return this.f4442n;
    }

    private static String O(String str) {
        String str2;
        AccessToken d10 = AccessToken.d();
        if (AccessToken.o()) {
            str2 = d10.m();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str2 = p0.j0(str2);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{str, p0.j(str2, ""), Integer.valueOf(f4427w)});
    }

    public static void P(String str, LikeView.g gVar, o oVar) {
        if (!f4426v) {
            b0();
        }
        d Q = Q(str);
        if (Q != null) {
            v0(Q, gVar, oVar);
        } else {
            f4423s.e(new n(str, gVar, oVar));
        }
    }

    private static d Q(String str) {
        String O = O(str);
        d dVar = (d) f4421q.get(O);
        if (dVar != null) {
            f4422r.e(new v(O, false));
        }
        return dVar;
    }

    private m T(Bundle bundle) {
        return new i((com.facebook.j) null, bundle);
    }

    public static boolean V(int i10, int i11, Intent intent) {
        if (p0.Y(f4425u)) {
            f4425u = com.facebook.o.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", (String) null);
        }
        if (p0.Y(f4425u)) {
            return false;
        }
        P(f4425u, LikeView.g.UNKNOWN, new C0063d(i10, i11, intent));
        return true;
    }

    private static void W(o oVar, d dVar, com.facebook.l lVar) {
        if (oVar != null) {
            f4424t.post(new g(oVar, dVar, lVar));
        }
    }

    /* access modifiers changed from: private */
    public void Y(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.f4429a);
        bundle2.putString("object_type", this.f4430b.toString());
        bundle2.putString("current_action", str);
        N().h("fb_like_control_error", (Double) null, bundle2);
    }

    /* access modifiers changed from: private */
    public void Z(String str, FacebookRequestError facebookRequestError) {
        JSONObject f10;
        Bundle bundle = new Bundle();
        if (!(facebookRequestError == null || (f10 = facebookRequestError.f()) == null)) {
            bundle.putString(Constants.IPC_BUNDLE_KEY_SEND_ERROR, f10.toString());
        }
        Y(str, bundle);
    }

    /* access modifiers changed from: private */
    public void a0(int i10, int i11, Intent intent) {
        p.q(i10, i11, intent, T(this.f4441m));
        I();
    }

    private static synchronized void b0() {
        synchronized (d.class) {
            if (!f4426v) {
                f4424t = new Handler(Looper.getMainLooper());
                f4427w = com.facebook.o.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                f4420p = new q5.t(f4419o, new t.e());
                l0();
                q5.d.d(d.c.Like.a(), new f());
                f4426v = true;
            }
        }
    }

    private void c0(Activity activity, q5.u uVar, Bundle bundle) {
        String str;
        String str2;
        if (e.r()) {
            str = "fb_like_control_did_present_dialog";
        } else if (e.s()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            Y("present_dialog", bundle);
            p0.f0(f4419o, "Cannot show the Like Dialog on this device.");
            F((d) null, "com.facebook.sdk.LikeActionController.UPDATED");
            str = null;
        }
        if (str != null) {
            LikeView.g gVar = this.f4430b;
            if (gVar != null) {
                str2 = gVar.toString();
            } else {
                str2 = LikeView.g.UNKNOWN.toString();
            }
            LikeContent c10 = new LikeContent.b().d(this.f4429a).e(str2).c();
            if (uVar != null) {
                new e(uVar).m(c10);
            } else {
                new e(activity).m(c10);
            }
            m0(bundle);
            N().g("fb_like_control_did_present_dialog", bundle);
        }
    }

    /* access modifiers changed from: private */
    public void d0(Bundle bundle) {
        boolean z10 = this.f4431c;
        if (z10 != this.f4439k && !g0(z10, bundle)) {
            e0(!this.f4431c);
        }
    }

    /* access modifiers changed from: private */
    public void e0(boolean z10) {
        t0(z10);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        G(this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    private void f0(Bundle bundle) {
        this.f4440l = true;
        M(new j(bundle));
    }

    private boolean g0(boolean z10, Bundle bundle) {
        if (H()) {
            if (z10) {
                f0(bundle);
                return true;
            } else if (!p0.Y(this.f4436h)) {
                h0(bundle);
                return true;
            }
        }
        return false;
    }

    private void h0(Bundle bundle) {
        this.f4440l = true;
        com.facebook.s sVar = new com.facebook.s();
        x xVar = new x(this.f4436h);
        xVar.a(sVar);
        sVar.d(new k(xVar, bundle));
        sVar.i();
    }

    private static void i0(String str, d dVar) {
        String O = O(str);
        f4422r.e(new v(O, true));
        f4421q.put(O, dVar);
    }

    /* access modifiers changed from: private */
    public void j0() {
        if (!AccessToken.o()) {
            k0();
        } else {
            M(new l());
        }
    }

    private void k0() {
        g gVar = new g(com.facebook.o.f(), com.facebook.o.g(), this.f4429a);
        if (gVar.g()) {
            gVar.f(new a());
        }
    }

    private static void l0() {
        f4428x = new h();
    }

    private void m0(Bundle bundle) {
        r0(this.f4429a);
        this.f4441m = bundle;
        n0(this);
    }

    private static void n0(d dVar) {
        String p02 = p0(dVar);
        String O = O(dVar.f4429a);
        if (!p0.Y(p02) && !p0.Y(O)) {
            f4423s.e(new a0(O, p02));
        }
    }

    /* access modifiers changed from: private */
    public static void o0(String str, String str2) {
        OutputStream outputStream = null;
        try {
            outputStream = f4420p.k(str);
            outputStream.write(str2.getBytes());
        } catch (IOException e10) {
            Log.e(f4419o, "Unable to serialize controller to disk", e10);
            if (outputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                p0.i(outputStream);
            }
            throw th;
        }
        p0.i(outputStream);
    }

    private static String p0(d dVar) {
        JSONObject b10;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", dVar.f4429a);
            jSONObject.put("object_type", dVar.f4430b.b());
            jSONObject.put("like_count_string_with_like", dVar.f4432d);
            jSONObject.put("like_count_string_without_like", dVar.f4433e);
            jSONObject.put("social_sentence_with_like", dVar.f4434f);
            jSONObject.put("social_sentence_without_like", dVar.f4435g);
            jSONObject.put("is_object_liked", dVar.f4431c);
            jSONObject.put("unlike_token", dVar.f4436h);
            Bundle bundle = dVar.f4441m;
            if (!(bundle == null || (b10 = q5.c.b(bundle)) == null)) {
                jSONObject.put("facebook_dialog_analytics_bundle", b10);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            Log.e(f4419o, "Unable to serialize controller to JSON", e10);
            return null;
        }
    }

    private static void r0(String str) {
        f4425u = str;
        com.facebook.o.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", f4425u).apply();
    }

    private void t0(boolean z10) {
        u0(z10, this.f4432d, this.f4433e, this.f4434f, this.f4435g, this.f4436h);
    }

    /* access modifiers changed from: private */
    public void u0(boolean z10, String str, String str2, String str3, String str4, String str5) {
        String j10 = p0.j(str, (String) null);
        String j11 = p0.j(str2, (String) null);
        String j12 = p0.j(str3, (String) null);
        String j13 = p0.j(str4, (String) null);
        String j14 = p0.j(str5, (String) null);
        if (z10 != this.f4431c || !p0.c(j10, this.f4432d) || !p0.c(j11, this.f4433e) || !p0.c(j12, this.f4434f) || !p0.c(j13, this.f4435g) || !p0.c(j14, this.f4436h)) {
            this.f4431c = z10;
            this.f4432d = j10;
            this.f4433e = j11;
            this.f4434f = j12;
            this.f4435g = j13;
            this.f4436h = j14;
            n0(this);
            F(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private static void v0(d dVar, LikeView.g gVar, o oVar) {
        LikeView.g h10 = p.h(gVar, dVar.f4430b);
        com.facebook.l lVar = null;
        if (h10 == null) {
            Object[] objArr = {dVar.f4429a, dVar.f4430b.toString(), gVar.toString()};
            dVar = null;
            lVar = new com.facebook.l("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", objArr);
        } else {
            dVar.f4430b = h10;
        }
        W(oVar, dVar, lVar);
    }

    public String R() {
        if (this.f4431c) {
            return this.f4432d;
        }
        return this.f4433e;
    }

    public String S() {
        return this.f4429a;
    }

    public String U() {
        if (this.f4431c) {
            return this.f4434f;
        }
        return this.f4435g;
    }

    public boolean X() {
        return this.f4431c;
    }

    public boolean q0() {
        return false;
    }

    public void s0(Activity activity, q5.u uVar, Bundle bundle) {
        boolean z10 = this.f4431c;
        boolean z11 = !z10;
        if (H()) {
            t0(z11);
            if (this.f4440l) {
                N().g("fb_like_control_did_undo_quickly", bundle);
            } else if (!g0(z11, bundle)) {
                t0(z10);
                c0(activity, uVar, bundle);
            }
        } else {
            c0(activity, uVar, bundle);
        }
    }
}

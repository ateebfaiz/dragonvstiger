package com.linecorp.linesdk.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.linecorp.linesdk.LineAccessToken;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.LineIdToken;
import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.linecorp.linesdk.auth.internal.LineAuthenticationStatus;
import com.linecorp.linesdk.auth.internal.a;
import i9.k;
import java.util.List;
import k9.f;
import k9.h;
import l9.b;
import l9.e;
import l9.i;

class c {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static Intent f10071i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final LineAuthenticationActivity f10072a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final LineAuthenticationConfig f10073b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final e f10074c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final i f10075d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f10076e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final k9.a f10077f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final LineAuthenticationParams f10078g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final LineAuthenticationStatus f10079h;

    private class b extends AsyncTask {
        private b() {
        }

        private void c(LineIdToken lineIdToken, String str) {
            i9.c d10 = c.this.f10074c.d();
            if (d10.g()) {
                new b.C0150b().k(lineIdToken).h(((k9.i) d10.e()).a()).j(str).g(c.this.f10073b.b()).i(c.this.f10079h.f()).f().b();
                return;
            }
            throw new RuntimeException("Failed to get OpenId Discovery Document.  Response Code: " + d10.d() + " Error Data: " + d10.c());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public LineLoginResult doInBackground(a.c... cVarArr) {
            String str;
            LineProfile lineProfile;
            a.c cVar = cVarArr[0];
            String g10 = cVar.g();
            h e10 = c.this.f10079h.e();
            String g11 = c.this.f10079h.g();
            if (TextUtils.isEmpty(g10) || e10 == null || TextUtils.isEmpty(g11)) {
                return LineLoginResult.j("Requested data is missing.");
            }
            i9.c e11 = c.this.f10074c.e(c.this.f10073b.b(), g10, e10, g11);
            if (!e11.g()) {
                return LineLoginResult.c(e11);
            }
            f fVar = (f) e11.e();
            k9.e a10 = fVar.a();
            List c10 = fVar.c();
            if (c10.contains(k.f12368c)) {
                i9.c b10 = c.this.f10075d.b(a10);
                if (!b10.g()) {
                    return LineLoginResult.c(b10);
                }
                lineProfile = (LineProfile) b10.e();
                str = lineProfile.a();
            } else {
                lineProfile = null;
                str = null;
            }
            c.this.f10077f.g(a10);
            LineIdToken b11 = fVar.b();
            if (b11 != null) {
                try {
                    c(b11, str);
                } catch (Exception e12) {
                    return LineLoginResult.j(e12.getMessage());
                }
            }
            return new LineLoginResult.b().n(c.this.f10079h.f()).m(lineProfile).l(b11).j(cVar.e()).k(new LineCredential(new LineAccessToken(a10.a(), a10.b(), a10.c()), c10)).h();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(LineLoginResult lineLoginResult) {
            c.this.f10079h.a();
            c.this.f10072a.b(lineLoginResult);
        }
    }

    /* renamed from: com.linecorp.linesdk.auth.internal.c$c  reason: collision with other inner class name */
    private class C0115c implements Runnable {
        private C0115c() {
        }

        public void run() {
            if (c.this.f10079h.h() != LineAuthenticationStatus.b.INTENT_RECEIVED && !c.this.f10072a.isFinishing()) {
                if (c.f10071i != null) {
                    c.this.l(c.f10071i);
                    Intent unused = c.f10071i = null;
                    return;
                }
                c.this.f10072a.b(LineLoginResult.b());
            }
        }
    }

    private class d extends AsyncTask {
        private d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public i9.c doInBackground(Void... voidArr) {
            return c.this.f10074c.c(c.this.f10073b.b());
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(i9.c cVar) {
            if (!cVar.g()) {
                c.this.f10079h.a();
                c.this.f10072a.b(LineLoginResult.c(cVar));
                return;
            }
            h hVar = (h) cVar.e();
            c.this.f10079h.j(hVar);
            try {
                a.b f10 = c.this.f10076e.f(c.this.f10072a, c.this.f10073b, hVar, c.this.f10078g);
                if (f10.d()) {
                    c.this.f10072a.startActivity(f10.a(), f10.c());
                } else {
                    c.this.f10072a.startActivityForResult(f10.a(), 3, f10.c());
                }
                c.this.f10079h.l(f10.b());
            } catch (ActivityNotFoundException e10) {
                c.this.f10079h.a();
                c.this.f10072a.b(LineLoginResult.i(e10));
            }
        }
    }

    c(LineAuthenticationActivity lineAuthenticationActivity, LineAuthenticationConfig lineAuthenticationConfig, LineAuthenticationStatus lineAuthenticationStatus, LineAuthenticationParams lineAuthenticationParams) {
        this(lineAuthenticationActivity, lineAuthenticationConfig, new e(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.c(), lineAuthenticationConfig.a()), new i(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.a()), new a(lineAuthenticationStatus), new k9.a(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.b()), lineAuthenticationStatus, lineAuthenticationParams);
    }

    public static void n(Intent intent) {
        f10071i = intent;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        new Handler(Looper.getMainLooper()).postDelayed(new C0115c(), 1000);
    }

    /* access modifiers changed from: package-private */
    public void l(Intent intent) {
        LineLoginResult lineLoginResult;
        this.f10079h.b();
        a.c e10 = this.f10076e.e(intent);
        if (!e10.i()) {
            this.f10079h.a();
            if (e10.h()) {
                lineLoginResult = LineLoginResult.a(e10.f());
            } else {
                lineLoginResult = LineLoginResult.h(e10.f());
            }
            this.f10072a.b(lineLoginResult);
            return;
        }
        new b().execute(new a.c[]{e10});
    }

    /* access modifiers changed from: package-private */
    public void m(int i10, int i11, Intent intent) {
        if (i10 == 3 && this.f10079h.h() != LineAuthenticationStatus.b.INTENT_RECEIVED) {
            new Handler(Looper.getMainLooper()).postDelayed(new C0115c(), 1000);
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f10079h.c();
        new d().execute(new Void[0]);
    }

    c(LineAuthenticationActivity lineAuthenticationActivity, LineAuthenticationConfig lineAuthenticationConfig, e eVar, i iVar, a aVar, k9.a aVar2, LineAuthenticationStatus lineAuthenticationStatus, LineAuthenticationParams lineAuthenticationParams) {
        this.f10072a = lineAuthenticationActivity;
        this.f10073b = lineAuthenticationConfig;
        this.f10074c = eVar;
        this.f10075d = iVar;
        this.f10076e = aVar;
        this.f10077f = aVar2;
        this.f10079h = lineAuthenticationStatus;
        this.f10078g = lineAuthenticationParams;
    }
}

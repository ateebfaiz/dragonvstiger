package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.l;
import com.facebook.login.k;
import com.facebook.n;
import com.facebook.o;
import com.facebook.t;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.i0;
import q5.p0;
import q5.q0;
import q5.r0;

public class WebDialog extends Dialog {
    /* access modifiers changed from: private */
    public static final int X = u2.g.f24300a;
    /* access modifiers changed from: private */
    public static volatile int Y;
    public static final b Z = new b((DefaultConstructorMarker) null);
    private WindowManager.LayoutParams C;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f20338a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f20339b;

    /* renamed from: c  reason: collision with root package name */
    private d f20340c;

    /* renamed from: d  reason: collision with root package name */
    private WebView f20341d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ProgressDialog f20342e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20343f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20344g;

    /* renamed from: h  reason: collision with root package name */
    private e f20345h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20346i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f20347j;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f20348w;

    public static final class b {
        private b() {
        }

        public final int a() {
            q0.o();
            return WebDialog.Y;
        }

        /* access modifiers changed from: protected */
        public final void b(Context context) {
            Bundle bundle;
            if (context != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null) {
                        bundle = applicationInfo.metaData;
                    } else {
                        bundle = null;
                    }
                    if (bundle != null && WebDialog.Y == 0) {
                        e(applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }

        public final WebDialog c(Context context, String str, Bundle bundle, int i10, d dVar) {
            m.f(context, "context");
            b(context);
            return new WebDialog(context, str, bundle, i10, k.FACEBOOK, dVar, (DefaultConstructorMarker) null);
        }

        public final WebDialog d(Context context, String str, Bundle bundle, int i10, k kVar, d dVar) {
            m.f(context, "context");
            m.f(kVar, "targetApp");
            b(context);
            return new WebDialog(context, str, bundle, i10, kVar, dVar, (DefaultConstructorMarker) null);
        }

        public final void e(int i10) {
            if (i10 == 0) {
                i10 = WebDialog.X;
            }
            WebDialog.Y = i10;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class c extends WebViewClient {
        public c() {
        }

        public void onPageFinished(WebView webView, String str) {
            ProgressDialog e10;
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            super.onPageFinished(webView, str);
            if (!WebDialog.this.f20347j && (e10 = WebDialog.this.f20342e) != null) {
                e10.dismiss();
            }
            FrameLayout a10 = WebDialog.this.f20344g;
            if (a10 != null) {
                a10.setBackgroundColor(0);
            }
            WebView n10 = WebDialog.this.n();
            if (n10 != null) {
                n10.setVisibility(0);
            }
            ImageView b10 = WebDialog.this.f20343f;
            if (b10 != null) {
                b10.setVisibility(0);
            }
            WebDialog.this.f20348w = true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ProgressDialog e10;
            m.f(webView, "view");
            m.f(str, ImagesContract.URL);
            p0.f0("FacebookSDK.WebDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (!WebDialog.this.f20347j && (e10 = WebDialog.this.f20342e) != null) {
                e10.show();
            }
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            m.f(webView, "view");
            m.f(str, "description");
            m.f(str2, "failingUrl");
            super.onReceivedError(webView, i10, str, str2);
            WebDialog.this.t(new com.facebook.k(str, i10, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            m.f(webView, "view");
            m.f(sslErrorHandler, "handler");
            m.f(sslError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.t(new com.facebook.k((String) null, -11, (String) null));
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.m.f(r6, r0)
                java.lang.String r6 = "url"
                kotlin.jvm.internal.m.f(r7, r6)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Redirect URL: "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r0 = "FacebookSDK.WebDialog"
                q5.p0.f0(r0, r6)
                android.net.Uri r6 = android.net.Uri.parse(r7)
                java.lang.String r0 = "parsedURL"
                kotlin.jvm.internal.m.e(r6, r0)
                java.lang.String r0 = r6.getPath()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x003f
                java.lang.String r0 = "^/(v\\d+\\.\\d+/)??dialog/.*"
                java.lang.String r6 = r6.getPath()
                boolean r6 = java.util.regex.Pattern.matches(r0, r6)
                if (r6 == 0) goto L_0x003f
                r6 = r1
                goto L_0x0040
            L_0x003f:
                r6 = r2
            L_0x0040:
                com.facebook.internal.WebDialog r0 = com.facebook.internal.WebDialog.this
                java.lang.String r0 = r0.f20339b
                r3 = 2
                r4 = 0
                boolean r0 = kotlin.text.j.F(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00d3
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                android.os.Bundle r6 = r6.r(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L_0x0062
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L_0x0062:
                java.lang.String r0 = "error_msg"
                java.lang.String r0 = r6.getString(r0)
                if (r0 != 0) goto L_0x0070
                java.lang.String r0 = "error_message"
                java.lang.String r0 = r6.getString(r0)
            L_0x0070:
                if (r0 != 0) goto L_0x0078
                java.lang.String r0 = "error_description"
                java.lang.String r0 = r6.getString(r0)
            L_0x0078:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                r3 = -1
                if (r2 == 0) goto L_0x008c
                boolean r4 = q5.p0.Y(r2)
                if (r4 != 0) goto L_0x008c
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x008c }
                goto L_0x008d
            L_0x008c:
                r2 = r3
            L_0x008d:
                boolean r4 = q5.p0.Y(r7)
                if (r4 == 0) goto L_0x00a1
                boolean r4 = q5.p0.Y(r0)
                if (r4 == 0) goto L_0x00a1
                if (r2 != r3) goto L_0x00a1
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                r7.u(r6)
                goto L_0x00d2
            L_0x00a1:
                if (r7 == 0) goto L_0x00b9
                java.lang.String r6 = "access_denied"
                boolean r6 = kotlin.jvm.internal.m.b(r7, r6)
                if (r6 != 0) goto L_0x00b3
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = kotlin.jvm.internal.m.b(r7, r6)
                if (r6 == 0) goto L_0x00b9
            L_0x00b3:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00d2
            L_0x00b9:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L_0x00c3
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00d2
            L_0x00c3:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r0)
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                com.facebook.q r2 = new com.facebook.q
                r2.<init>(r6, r0)
                r7.t(r2)
            L_0x00d2:
                return r1
            L_0x00d3:
                java.lang.String r0 = "fbconnect://cancel"
                boolean r0 = kotlin.text.j.F(r7, r0, r2, r3, r4)
                if (r0 == 0) goto L_0x00e1
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                return r1
            L_0x00e1:
                if (r6 != 0) goto L_0x0103
                java.lang.String r6 = "touch"
                boolean r6 = kotlin.text.j.K(r7, r6, r2, r3, r4)
                if (r6 == 0) goto L_0x00ec
                goto L_0x0103
            L_0x00ec:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this     // Catch:{ ActivityNotFoundException -> 0x0101 }
                android.content.Context r6 = r6.getContext()     // Catch:{ ActivityNotFoundException -> 0x0101 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0101 }
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x0101 }
                r0.<init>(r3, r7)     // Catch:{ ActivityNotFoundException -> 0x0101 }
                r6.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0101 }
                goto L_0x0102
            L_0x0101:
                r1 = r2
            L_0x0102:
                return r1
            L_0x0103:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.c.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    public interface d {
        void a(Bundle bundle, l lVar);
    }

    private final class e extends AsyncTask {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Exception[] f20357a = new Exception[0];

        /* renamed from: b  reason: collision with root package name */
        private final String f20358b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f20359c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WebDialog f20360d;

        static final class a implements GraphRequest.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f20361a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String[] f20362b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f20363c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ CountDownLatch f20364d;

            a(e eVar, String[] strArr, int i10, CountDownLatch countDownLatch) {
                this.f20361a = eVar;
                this.f20362b = strArr;
                this.f20363c = i10;
                this.f20364d = countDownLatch;
            }

            public final void a(t tVar) {
                m.f(tVar, "response");
                try {
                    FacebookRequestError b10 = tVar.b();
                    String str = "Error staging photo.";
                    if (b10 != null) {
                        String c10 = b10.c();
                        if (c10 != null) {
                            str = c10;
                        }
                        throw new com.facebook.m(tVar, str);
                    }
                    JSONObject c11 = tVar.c();
                    if (c11 != null) {
                        String optString = c11.optString("uri");
                        if (optString != null) {
                            this.f20362b[this.f20363c] = optString;
                            this.f20364d.countDown();
                            return;
                        }
                        throw new l(str);
                    }
                    throw new l(str);
                } catch (Exception e10) {
                    this.f20361a.f20357a[this.f20363c] = e10;
                }
            }
        }

        public e(WebDialog webDialog, String str, Bundle bundle) {
            m.f(str, "action");
            m.f(bundle, "parameters");
            this.f20360d = webDialog;
            this.f20358b = str;
            this.f20359c = bundle;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:28|29|(2:32|30)|41) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r11 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008c, code lost:
            if (r11.hasNext() != false) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008e, code lost:
            ((com.facebook.r) r11.next()).cancel(true);
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0084 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String[] b(java.lang.Void... r11) {
            /*
                r10 = this;
                boolean r0 = v5.a.d(r10)
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.String r0 = "p0"
                kotlin.jvm.internal.m.f(r11, r0)     // Catch:{ all -> 0x0054 }
                android.os.Bundle r11 = r10.f20359c     // Catch:{ all -> 0x0054 }
                java.lang.String r0 = "media"
                java.lang.String[] r11 = r11.getStringArray(r0)     // Catch:{ all -> 0x0054 }
                if (r11 == 0) goto L_0x0098
                java.lang.String r0 = "parameters.getStringArra…RAM_MEDIA) ?: return null"
                kotlin.jvm.internal.m.e(r11, r0)     // Catch:{ all -> 0x0054 }
                int r0 = r11.length     // Catch:{ all -> 0x0054 }
                java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x0054 }
                int r2 = r11.length     // Catch:{ all -> 0x0054 }
                java.lang.Exception[] r2 = new java.lang.Exception[r2]     // Catch:{ all -> 0x0054 }
                r10.f20357a = r2     // Catch:{ all -> 0x0054 }
                java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0054 }
                int r3 = r11.length     // Catch:{ all -> 0x0054 }
                r2.<init>(r3)     // Catch:{ all -> 0x0054 }
                java.util.concurrent.ConcurrentLinkedQueue r3 = new java.util.concurrent.ConcurrentLinkedQueue     // Catch:{ all -> 0x0054 }
                r3.<init>()     // Catch:{ all -> 0x0054 }
                com.facebook.AccessToken$c r4 = com.facebook.AccessToken.N0     // Catch:{ all -> 0x0054 }
                com.facebook.AccessToken r4 = r4.e()     // Catch:{ all -> 0x0054 }
                r5 = 1
                int r6 = r11.length     // Catch:{ Exception -> 0x0084 }
                r7 = 0
            L_0x0038:
                if (r7 >= r6) goto L_0x0080
                boolean r8 = r10.isCancelled()     // Catch:{ Exception -> 0x0084 }
                if (r8 == 0) goto L_0x0057
                java.util.Iterator r11 = r3.iterator()     // Catch:{ Exception -> 0x0084 }
            L_0x0044:
                boolean r0 = r11.hasNext()     // Catch:{ Exception -> 0x0084 }
                if (r0 == 0) goto L_0x0056
                java.lang.Object r0 = r11.next()     // Catch:{ Exception -> 0x0084 }
                com.facebook.r r0 = (com.facebook.r) r0     // Catch:{ Exception -> 0x0084 }
                r0.cancel(r5)     // Catch:{ Exception -> 0x0084 }
                goto L_0x0044
            L_0x0054:
                r11 = move-exception
                goto L_0x0099
            L_0x0056:
                return r1
            L_0x0057:
                r8 = r11[r7]     // Catch:{ Exception -> 0x0084 }
                android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x0084 }
                boolean r9 = q5.p0.a0(r8)     // Catch:{ Exception -> 0x0084 }
                if (r9 == 0) goto L_0x006d
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0084 }
                r0[r7] = r8     // Catch:{ Exception -> 0x0084 }
                r2.countDown()     // Catch:{ Exception -> 0x0084 }
                goto L_0x007d
            L_0x006d:
                com.facebook.internal.WebDialog$e$a r9 = new com.facebook.internal.WebDialog$e$a     // Catch:{ Exception -> 0x0084 }
                r9.<init>(r10, r0, r7, r2)     // Catch:{ Exception -> 0x0084 }
                com.facebook.GraphRequest r8 = com.facebook.share.internal.p.v(r4, r8, r9)     // Catch:{ Exception -> 0x0084 }
                com.facebook.r r8 = r8.j()     // Catch:{ Exception -> 0x0084 }
                r3.add(r8)     // Catch:{ Exception -> 0x0084 }
            L_0x007d:
                int r7 = r7 + 1
                goto L_0x0038
            L_0x0080:
                r2.await()     // Catch:{ Exception -> 0x0084 }
                return r0
            L_0x0084:
                java.util.Iterator r11 = r3.iterator()     // Catch:{ all -> 0x0054 }
            L_0x0088:
                boolean r0 = r11.hasNext()     // Catch:{ all -> 0x0054 }
                if (r0 == 0) goto L_0x0098
                java.lang.Object r0 = r11.next()     // Catch:{ all -> 0x0054 }
                com.facebook.r r0 = (com.facebook.r) r0     // Catch:{ all -> 0x0054 }
                r0.cancel(r5)     // Catch:{ all -> 0x0054 }
                goto L_0x0088
            L_0x0098:
                return r1
            L_0x0099:
                v5.a.b(r11, r10)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.e.b(java.lang.Void[]):java.lang.String[]");
        }

        /* access modifiers changed from: protected */
        public void c(String[] strArr) {
            if (!v5.a.d(this)) {
                try {
                    ProgressDialog e10 = this.f20360d.f20342e;
                    if (e10 != null) {
                        e10.dismiss();
                    }
                    for (Exception exc : this.f20357a) {
                        if (exc != null) {
                            this.f20360d.t(exc);
                            return;
                        }
                    }
                    if (strArr == null) {
                        this.f20360d.t(new l("Failed to stage photos for web dialog"));
                        return;
                    }
                    List c10 = j.c(strArr);
                    if (c10.contains((Object) null)) {
                        this.f20360d.t(new l("Failed to stage photos for web dialog"));
                        return;
                    }
                    p0.m0(this.f20359c, "media", new JSONArray(c10));
                    this.f20360d.f20338a = p0.f(i0.b(), o.r() + DomExceptionUtils.SEPARATOR + "dialog/" + this.f20358b, this.f20359c).toString();
                    ImageView b10 = this.f20360d.f20343f;
                    if (b10 != null) {
                        Drawable drawable = b10.getDrawable();
                        m.e(drawable, "checkNotNull(crossImageView).drawable");
                        this.f20360d.x((drawable.getIntrinsicWidth() / 2) + 1);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                return b((Void[]) objArr);
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            if (!v5.a.d(this)) {
                try {
                    c((String[]) obj);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebDialog f20365a;

        f(WebDialog webDialog) {
            this.f20365a = webDialog;
        }

        public final void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    this.f20365a.cancel();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static final class g implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebDialog f20366a;

        g(WebDialog webDialog) {
            this.f20366a = webDialog;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.f20366a.cancel();
        }
    }

    static final class h implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f20367a = new h();

        h() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    public /* synthetic */ WebDialog(Context context, String str, Bundle bundle, int i10, k kVar, d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bundle, i10, kVar, dVar);
    }

    private final void l() {
        ImageView imageView = new ImageView(getContext());
        this.f20343f = imageView;
        imageView.setOnClickListener(new f(this));
        Context context = getContext();
        m.e(context, "context");
        Drawable drawable = context.getResources().getDrawable(u2.c.f24280c);
        ImageView imageView2 = this.f20343f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.f20343f;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
    }

    private final int m(int i10, float f10, int i11, int i12) {
        int i13 = (int) (((float) i10) / f10);
        return (int) (((double) i10) * (i13 <= i11 ? 1.0d : i13 >= i12 ? 0.5d : ((((double) (i12 - i13)) / ((double) (i12 - i11))) * 0.5d) + 0.5d));
    }

    public static final WebDialog q(Context context, String str, Bundle bundle, int i10, k kVar, d dVar) {
        return Z.d(context, str, bundle, i10, kVar, dVar);
    }

    /* access modifiers changed from: private */
    public final void x(int i10) {
        WebSettings settings;
        WebSettings settings2;
        WebSettings settings3;
        LinearLayout linearLayout = new LinearLayout(getContext());
        WebDialog$setUpWebView$1 webDialog$setUpWebView$1 = new WebDialog$setUpWebView$1(this, getContext());
        this.f20341d = webDialog$setUpWebView$1;
        webDialog$setUpWebView$1.setVerticalScrollBarEnabled(false);
        WebView webView = this.f20341d;
        if (webView != null) {
            webView.setHorizontalScrollBarEnabled(false);
        }
        WebView webView2 = this.f20341d;
        if (webView2 != null) {
            webView2.setWebViewClient(new c());
        }
        WebView webView3 = this.f20341d;
        if (!(webView3 == null || (settings3 = webView3.getSettings()) == null)) {
            settings3.setJavaScriptEnabled(true);
        }
        WebView webView4 = this.f20341d;
        if (webView4 != null) {
            String str = this.f20338a;
            if (str != null) {
                webView4.loadUrl(str);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        WebView webView5 = this.f20341d;
        if (webView5 != null) {
            webView5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        WebView webView6 = this.f20341d;
        if (webView6 != null) {
            webView6.setVisibility(4);
        }
        WebView webView7 = this.f20341d;
        if (!(webView7 == null || (settings2 = webView7.getSettings()) == null)) {
            settings2.setSavePassword(false);
        }
        WebView webView8 = this.f20341d;
        if (!(webView8 == null || (settings = webView8.getSettings()) == null)) {
            settings.setSaveFormData(false);
        }
        WebView webView9 = this.f20341d;
        if (webView9 != null) {
            webView9.setFocusable(true);
        }
        WebView webView10 = this.f20341d;
        if (webView10 != null) {
            webView10.setFocusableInTouchMode(true);
        }
        WebView webView11 = this.f20341d;
        if (webView11 != null) {
            webView11.setOnTouchListener(h.f20367a);
        }
        linearLayout.setPadding(i10, i10, i10, i10);
        linearLayout.addView(this.f20341d);
        linearLayout.setBackgroundColor(-872415232);
        FrameLayout frameLayout = this.f20344g;
        if (frameLayout != null) {
            frameLayout.addView(linearLayout);
        }
    }

    public void cancel() {
        if (this.f20340c != null && !this.f20346i) {
            t(new n());
        }
    }

    public void dismiss() {
        ProgressDialog progressDialog;
        WebView webView = this.f20341d;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.f20347j && (progressDialog = this.f20342e) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public final WebView n() {
        return this.f20341d;
    }

    /* access modifiers changed from: protected */
    public final boolean o() {
        return this.f20346i;
    }

    public void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        IBinder iBinder;
        IBinder iBinder2;
        Window window;
        WindowManager.LayoutParams attributes;
        this.f20347j = false;
        Context context = getContext();
        m.e(context, "context");
        if (p0.k0(context) && (layoutParams = this.C) != null) {
            IBinder iBinder3 = null;
            if (layoutParams != null) {
                iBinder = layoutParams.token;
            } else {
                iBinder = null;
            }
            if (iBinder == null) {
                if (layoutParams != null) {
                    Activity ownerActivity = getOwnerActivity();
                    if (ownerActivity == null || (window = ownerActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                        iBinder2 = null;
                    } else {
                        iBinder2 = attributes.token;
                    }
                    layoutParams.token = iBinder2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Set token on onAttachedToWindow(): ");
                WindowManager.LayoutParams layoutParams2 = this.C;
                if (layoutParams2 != null) {
                    iBinder3 = layoutParams2.token;
                }
                sb2.append(iBinder3);
                p0.f0("FacebookSDK.WebDialog", sb2.toString());
            }
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.f20342e = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.f20342e;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(u2.f.f24296f));
        }
        ProgressDialog progressDialog3 = this.f20342e;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.f20342e;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new g(this));
        }
        requestWindowFeature(1);
        this.f20344g = new FrameLayout(getContext());
        s();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        l();
        if (this.f20338a != null) {
            ImageView imageView = this.f20343f;
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                m.e(drawable, "checkNotNull(crossImageView).drawable");
                x((drawable.getIntrinsicWidth() / 2) + 1);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        FrameLayout frameLayout = this.f20344g;
        if (frameLayout != null) {
            frameLayout.addView(this.f20343f, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.f20344g;
        if (frameLayout2 != null) {
            setContentView(frameLayout2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onDetachedFromWindow() {
        this.f20347j = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        m.f(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i10 == 4) {
            WebView webView = this.f20341d;
            if (webView == null || webView == null || !webView.canGoBack()) {
                cancel();
            } else {
                WebView webView2 = this.f20341d;
                if (webView2 != null) {
                    webView2.goBack();
                }
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AsyncTask.Status status;
        super.onStart();
        e eVar = this.f20345h;
        if (eVar != null) {
            if (eVar != null) {
                status = eVar.getStatus();
            } else {
                status = null;
            }
            if (status == AsyncTask.Status.PENDING) {
                e eVar2 = this.f20345h;
                if (eVar2 != null) {
                    eVar2.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.f20342e;
                if (progressDialog != null) {
                    progressDialog.show();
                    return;
                }
                return;
            }
        }
        s();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        e eVar = this.f20345h;
        if (eVar != null) {
            eVar.cancel(true);
            ProgressDialog progressDialog = this.f20342e;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        m.f(layoutParams, "params");
        if (layoutParams.token == null) {
            this.C = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    /* access modifiers changed from: protected */
    public final boolean p() {
        return this.f20348w;
    }

    public Bundle r(String str) {
        Uri parse = Uri.parse(str);
        m.e(parse, "u");
        Bundle l02 = p0.l0(parse.getQuery());
        l02.putAll(p0.l0(parse.getFragment()));
        return l02;
    }

    public final void s() {
        int i10;
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i11 = displayMetrics.widthPixels;
            int i12 = displayMetrics.heightPixels;
            if (i11 < i12) {
                i10 = i11;
            } else {
                i10 = i12;
            }
            if (i11 < i12) {
                i11 = i12;
            }
            int min = Math.min(m(i10, displayMetrics.density, 480, 800), displayMetrics.widthPixels);
            int min2 = Math.min(m(i11, displayMetrics.density, 800, 1280), displayMetrics.heightPixels);
            Window window = getWindow();
            if (window != null) {
                window.setLayout(min, min2);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* access modifiers changed from: protected */
    public final void t(Throwable th) {
        l lVar;
        if (this.f20340c != null && !this.f20346i) {
            this.f20346i = true;
            if (th instanceof l) {
                lVar = (l) th;
            } else {
                lVar = new l(th);
            }
            d dVar = this.f20340c;
            if (dVar != null) {
                dVar.a((Bundle) null, lVar);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final void u(Bundle bundle) {
        d dVar = this.f20340c;
        if (dVar != null && !this.f20346i) {
            this.f20346i = true;
            if (dVar != null) {
                dVar.a(bundle, (l) null);
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final void v(String str) {
        m.f(str, "expectedRedirectUrl");
        this.f20339b = str;
    }

    public final void w(d dVar) {
        this.f20340c = dVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected WebDialog(Context context, String str) {
        this(context, str, Z.a());
        m.f(context, "context");
        m.f(str, ImagesContract.URL);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, int i10) {
        super(context, i10 == 0 ? Z.a() : i10);
        this.f20339b = "fbconnect://success";
        this.f20338a = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, Bundle bundle, int i10, k kVar, d dVar) {
        super(context, i10 == 0 ? Z.a() : i10);
        Uri uri;
        String str2 = "fbconnect://success";
        this.f20339b = str2;
        bundle = bundle == null ? new Bundle() : bundle;
        str2 = p0.S(context) ? "fbconnect://chrome_os_success" : str2;
        this.f20339b = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "touch");
        bundle.putString("client_id", o.g());
        b0 b0Var = b0.f709a;
        String format = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{o.w()}, 1));
        m.e(format, "java.lang.String.format(locale, format, *args)");
        bundle.putString("sdk", format);
        this.f20340c = dVar;
        if (!m.b(str, FirebaseAnalytics.Event.SHARE) || !bundle.containsKey("media")) {
            if (r0.f23445a[kVar.ordinal()] != 1) {
                String b10 = i0.b();
                uri = p0.f(b10, o.r() + DomExceptionUtils.SEPARATOR + "dialog/" + str, bundle);
            } else {
                uri = p0.f(i0.j(), "oauth/authorize", bundle);
            }
            this.f20338a = uri.toString();
            return;
        }
        this.f20345h = new e(this, str, bundle);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f20349a;

        /* renamed from: b  reason: collision with root package name */
        private String f20350b;

        /* renamed from: c  reason: collision with root package name */
        private String f20351c;

        /* renamed from: d  reason: collision with root package name */
        private int f20352d;

        /* renamed from: e  reason: collision with root package name */
        private d f20353e;

        /* renamed from: f  reason: collision with root package name */
        private Bundle f20354f;

        /* renamed from: g  reason: collision with root package name */
        private AccessToken f20355g;

        public a(Context context, String str, Bundle bundle) {
            m.f(context, "context");
            m.f(str, "action");
            AccessToken.c cVar = AccessToken.N0;
            this.f20355g = cVar.e();
            if (!cVar.g()) {
                String E = p0.E(context);
                if (E != null) {
                    this.f20350b = E;
                } else {
                    throw new l("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            b(context, str, bundle);
        }

        private final void b(Context context, String str, Bundle bundle) {
            this.f20349a = context;
            this.f20351c = str;
            if (bundle != null) {
                this.f20354f = bundle;
            } else {
                this.f20354f = new Bundle();
            }
        }

        public WebDialog a() {
            String str;
            AccessToken accessToken = this.f20355g;
            if (accessToken != null) {
                Bundle bundle = this.f20354f;
                String str2 = null;
                if (bundle != null) {
                    if (accessToken != null) {
                        str = accessToken.c();
                    } else {
                        str = null;
                    }
                    bundle.putString(Constant.PARAM_APP_ID, str);
                }
                Bundle bundle2 = this.f20354f;
                if (bundle2 != null) {
                    AccessToken accessToken2 = this.f20355g;
                    if (accessToken2 != null) {
                        str2 = accessToken2.m();
                    }
                    bundle2.putString("access_token", str2);
                }
            } else {
                Bundle bundle3 = this.f20354f;
                if (bundle3 != null) {
                    bundle3.putString(Constant.PARAM_APP_ID, this.f20350b);
                }
            }
            b bVar = WebDialog.Z;
            Context context = this.f20349a;
            if (context != null) {
                return bVar.c(context, this.f20351c, this.f20354f, this.f20352d, this.f20353e);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final String c() {
            return this.f20350b;
        }

        public final Context d() {
            return this.f20349a;
        }

        public final d e() {
            return this.f20353e;
        }

        public final Bundle f() {
            return this.f20354f;
        }

        public final int g() {
            return this.f20352d;
        }

        public final a h(d dVar) {
            this.f20353e = dVar;
            return this;
        }

        public a(Context context, String str, String str2, Bundle bundle) {
            m.f(context, "context");
            m.f(str2, "action");
            this.f20350b = q0.n(str == null ? p0.E(context) : str, "applicationId");
            b(context, str2, bundle);
        }
    }
}

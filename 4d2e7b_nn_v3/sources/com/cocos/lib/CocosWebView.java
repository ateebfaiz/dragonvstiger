package com.cocos.lib;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.net.URI;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CocosWebView extends WebView {
    /* access modifiers changed from: private */
    public static final String TAG = CocosWebViewHelper.class.getSimpleName();
    public static CocosWebView sWebView;
    /* access modifiers changed from: private */
    public String mJSScheme;
    /* access modifiers changed from: private */
    public int mViewTag;

    class a implements DownloadListener {
        a() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str));
                GlobalObject.getActivity().startActivity(intent);
            } catch (Exception e10) {
                e10.getStackTrace();
            }
        }
    }

    class b implements View.OnLongClickListener {
        b() {
        }

        public boolean onLongClick(View view) {
            WebView.HitTestResult hitTestResult = CocosWebView.sWebView.getHitTestResult();
            if (hitTestResult == null) {
                return false;
            }
            int type = hitTestResult.getType();
            String extra = hitTestResult.getExtra();
            if (type == 5 || type == 8) {
                CocosWebView.this.downloadAndSave(extra);
            } else if (type == 7 || type == 2 || type == 4) {
                ((ClipboardManager) GlobalObject.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", extra));
            }
            return false;
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }

    class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19343a;

        class a implements Runnable {

            /* renamed from: com.cocos.lib.CocosWebView$d$a$a  reason: collision with other inner class name */
            class C0244a implements Runnable {
                C0244a() {
                }

                public void run() {
                    Toast.makeText(GlobalObject.getActivity(), "Save Success", 0).show();
                }
            }

            class b implements Runnable {
                b() {
                }

                public void run() {
                    Toast.makeText(GlobalObject.getActivity(), "Save Failured", 0).show();
                }
            }

            a() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.OutputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.io.InputStream} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.io.InputStream} */
            /* JADX WARNING: type inference failed for: r4v0, types: [java.io.OutputStream] */
            /* JADX WARNING: type inference failed for: r4v1, types: [java.io.OutputStream] */
            /* JADX WARNING: type inference failed for: r4v2 */
            /* JADX WARNING: type inference failed for: r4v3 */
            /* JADX WARNING: type inference failed for: r0v7, types: [java.io.OutputStream] */
            /* JADX WARNING: type inference failed for: r0v8 */
            /* JADX WARNING: type inference failed for: r0v14 */
            /* JADX WARNING: type inference failed for: r4v14, types: [java.io.OutputStream, java.io.FileOutputStream] */
            /* JADX WARNING: type inference failed for: r4v16 */
            /* JADX WARNING: type inference failed for: r4v17 */
            /* JADX WARNING: type inference failed for: r4v18 */
            /* JADX WARNING: type inference failed for: r4v19 */
            /* JADX WARNING: type inference failed for: r4v20 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x014d A[Catch:{ all -> 0x015a }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0161 A[SYNTHETIC, Splitter:B:62:0x0161] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0166 A[Catch:{ Exception -> 0x0137 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x016c A[SYNTHETIC, Splitter:B:67:0x016c] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0174 A[Catch:{ Exception -> 0x0170 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Unknown variable types count: 4 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    java.lang.String r0 = "is_pending"
                    r1 = 0
                    java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    com.cocos.lib.CocosWebView$d r3 = com.cocos.lib.CocosWebView.d.this     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    java.lang.String r3 = r3.f19343a     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    r3 = 5000(0x1388, float:7.006E-42)
                    r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    java.lang.String r3 = "GET"
                    r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    r4 = 200(0xc8, float:2.8E-43)
                    if (r3 != r4) goto L_0x0130
                    java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x012d, all -> 0x012a }
                    android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r5 = 29
                    r6 = 100
                    if (r4 < r5) goto L_0x00b9
                    android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r4.<init>()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r5 = "_display_name"
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r7.<init>()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r7.append(r8)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r8 = ".png"
                    r7.append(r8)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r4.put(r5, r7)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r5 = "mime_type"
                    java.lang.String r7 = "image/*"
                    r4.put(r5, r7)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r5 = "relative_path"
                    java.lang.String r7 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r4.put(r5, r7)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r5 = 1
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r4.put(r0, r5)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.app.Activity r5 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.net.Uri r7 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.net.Uri r7 = r5.insert(r7, r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.io.OutputStream r8 = r5.openOutputStream(r7)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.graphics.Bitmap$CompressFormat r9 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    r3.compress(r9, r6, r8)     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    r4.clear()     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    r3 = 0
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    r4.put(r0, r3)     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    r5.update(r7, r4, r1, r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a5 }
                    if (r8 != 0) goto L_0x00a2
                    if (r2 == 0) goto L_0x0098
                    r2.close()     // Catch:{ Exception -> 0x0096 }
                    goto L_0x0098
                L_0x0096:
                    r0 = move-exception
                    goto L_0x009e
                L_0x0098:
                    if (r8 == 0) goto L_0x00a1
                    r8.close()     // Catch:{ Exception -> 0x0096 }
                    goto L_0x00a1
                L_0x009e:
                    r0.printStackTrace()
                L_0x00a1:
                    return
                L_0x00a2:
                    r1 = r8
                    goto L_0x0117
                L_0x00a5:
                    r0 = move-exception
                    r1 = r2
                    r4 = r8
                    goto L_0x016a
                L_0x00aa:
                    r0 = move-exception
                    r1 = r2
                    r4 = r8
                    goto L_0x0143
                L_0x00af:
                    r0 = move-exception
                    r4 = r1
                L_0x00b1:
                    r1 = r2
                    goto L_0x016a
                L_0x00b4:
                    r0 = move-exception
                    r4 = r1
                L_0x00b6:
                    r1 = r2
                    goto L_0x0143
                L_0x00b9:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0.<init>()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.app.Activity r4 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0.append(r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0.append(r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0.append(r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r5.<init>(r0)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r4.<init>(r5)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r3.compress(r5, r6, r4)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r4.flush()     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.app.Activity r3 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r5.<init>(r0)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.provider.MediaStore.Images.Media.insertImage(r3, r0, r5, r1)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.app.Activity r1 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    java.lang.String r5 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
                    java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r6.<init>(r0)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    android.net.Uri r0 = android.net.Uri.fromFile(r6)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r3.<init>(r5, r0)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r1.sendBroadcast(r3)     // Catch:{ Exception -> 0x0128, all -> 0x0126 }
                    r1 = r4
                L_0x0117:
                    android.app.Activity r0 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    com.cocos.lib.CocosWebView$d$a$a r3 = new com.cocos.lib.CocosWebView$d$a$a     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r3.<init>()     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0.runOnUiThread(r3)     // Catch:{ Exception -> 0x00b4, all -> 0x00af }
                    r0 = r1
                    r1 = r2
                    goto L_0x0131
                L_0x0126:
                    r0 = move-exception
                    goto L_0x00b1
                L_0x0128:
                    r0 = move-exception
                    goto L_0x00b6
                L_0x012a:
                    r0 = move-exception
                    r4 = r1
                    goto L_0x016a
                L_0x012d:
                    r0 = move-exception
                    r4 = r1
                    goto L_0x0143
                L_0x0130:
                    r0 = r1
                L_0x0131:
                    if (r1 == 0) goto L_0x0139
                    r1.close()     // Catch:{ Exception -> 0x0137 }
                    goto L_0x0139
                L_0x0137:
                    r0 = move-exception
                    goto L_0x013f
                L_0x0139:
                    if (r0 == 0) goto L_0x0169
                    r0.close()     // Catch:{ Exception -> 0x0137 }
                    goto L_0x0169
                L_0x013f:
                    r0.printStackTrace()
                    goto L_0x0169
                L_0x0143:
                    android.app.Activity r2 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ all -> 0x015a }
                    boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x015a }
                    if (r2 != 0) goto L_0x015c
                    android.app.Activity r2 = com.cocos.lib.GlobalObject.getActivity()     // Catch:{ all -> 0x015a }
                    com.cocos.lib.CocosWebView$d$a$b r3 = new com.cocos.lib.CocosWebView$d$a$b     // Catch:{ all -> 0x015a }
                    r3.<init>()     // Catch:{ all -> 0x015a }
                    r2.runOnUiThread(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x015c
                L_0x015a:
                    r0 = move-exception
                    goto L_0x016a
                L_0x015c:
                    r0.printStackTrace()     // Catch:{ all -> 0x015a }
                    if (r1 == 0) goto L_0x0164
                    r1.close()     // Catch:{ Exception -> 0x0137 }
                L_0x0164:
                    if (r4 == 0) goto L_0x0169
                    r4.close()     // Catch:{ Exception -> 0x0137 }
                L_0x0169:
                    return
                L_0x016a:
                    if (r1 == 0) goto L_0x0172
                    r1.close()     // Catch:{ Exception -> 0x0170 }
                    goto L_0x0172
                L_0x0170:
                    r1 = move-exception
                    goto L_0x0178
                L_0x0172:
                    if (r4 == 0) goto L_0x017b
                    r4.close()     // Catch:{ Exception -> 0x0170 }
                    goto L_0x017b
                L_0x0178:
                    r1.printStackTrace()
                L_0x017b:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cocos.lib.CocosWebView.d.a.run():void");
            }
        }

        d(String str) {
            this.f19343a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            new Thread(new a()).start();
        }
    }

    class e extends WebViewClient {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19349a;

            a(String str) {
                this.f19349a = str;
            }

            public void run() {
                CocosWebViewHelper._onJsCallback(CocosWebView.this.mViewTag, this.f19349a);
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19351a;

            b(String str) {
                this.f19351a = str;
            }

            public void run() {
                CocosWebViewHelper._onJsCallback(CocosWebView.this.mViewTag, this.f19351a);
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19353a;

            c(String str) {
                this.f19353a = str;
            }

            public void run() {
                CocosWebViewHelper._didFinishLoading(CocosWebView.this.mViewTag, this.f19353a);
            }
        }

        class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19355a;

            d(String str) {
                this.f19355a = str;
            }

            public void run() {
                CocosWebViewHelper._didFailLoading(CocosWebView.this.mViewTag, this.f19355a);
            }
        }

        e() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            CocosHelper.runOnGameThreadAtForeground(new c(str));
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            CocosHelper.runOnGameThreadAtForeground(new d(str2));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                URI create = URI.create(str);
                if (CocosWebView.this.mJSScheme.equals("https")) {
                    if (create != null && (create.getScheme().equals("https") || create.getScheme().equals("http"))) {
                        CocosHelper.runOnGameThreadAtForeground(new a(str));
                        return true;
                    }
                } else if (create != null && create.getScheme().equals(CocosWebView.this.mJSScheme)) {
                    CocosHelper.runOnGameThreadAtForeground(new b(str));
                    return true;
                }
            } catch (Exception unused) {
                Log.d(CocosWebView.TAG, "Failed to create URI from url");
            }
            boolean[] zArr = {true};
            CountDownLatch countDownLatch = new CountDownLatch(1);
            GlobalObject.runOnUiThread(new p(countDownLatch, zArr, CocosWebView.this.mViewTag, str));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused2) {
                Log.d(CocosWebView.TAG, "'shouldOverrideUrlLoading' failed");
            }
            return zArr[0];
        }
    }

    public CocosWebView(Context context) {
        this(context, -1);
    }

    /* access modifiers changed from: private */
    public void downloadAndSave(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            new AlertDialog.Builder(GlobalObject.getActivity()).setMessage("Save Picture？").setPositiveButton("Save", new d(str)).setNeutralButton("Cancel", new c()).show();
        }
    }

    /* access modifiers changed from: private */
    public void showFileChooser() {
        CocosActivity cocosActivity = (CocosActivity) GlobalObject.getActivity();
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent createChooser = Intent.createChooser(intent, "File Browser");
        Objects.requireNonNull(cocosActivity);
        cocosActivity.startActivityForResult(createChooser, 888);
    }

    public void setJavascriptInterfaceScheme(String str) {
        if (str == null) {
            str = "";
        }
        this.mJSScheme = str;
    }

    public void setScalesPageToFit(boolean z10) {
        getSettings().setSupportZoom(z10);
    }

    public void setWebViewRect(int i10, int i11, int i12, int i13) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = i10;
        layoutParams.topMargin = i11;
        layoutParams.width = i12;
        layoutParams.height = i13;
        setLayoutParams(layoutParams);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public CocosWebView(Context context, int i10) {
        super(context);
        this.mViewTag = i10;
        this.mJSScheme = "";
        sWebView = this;
        setBackgroundColor(0);
        setFocusable(true);
        setFocusableInTouchMode(true);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        try {
            getClass().getMethod("removeJavascriptInterface", new Class[]{String.class}).invoke(this, new Object[]{"searchBoxJavaBridge_"});
        } catch (Exception unused) {
            Log.d(TAG, "This API level do not support `removeJavascriptInterface`");
        }
        setWebViewClient(new e());
        setWebChromeClient(new WebChromeClient() {
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                ((CocosActivity) GlobalObject.getActivity()).mUploadCallBackAboveL = valueCallback;
                CocosWebView.this.showFileChooser();
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                ((CocosActivity) GlobalObject.getActivity()).mUploadCallBack = valueCallback;
                CocosWebView.this.showFileChooser();
            }
        });
        setDownloadListener(new a());
        setOnLongClickListener(new b());
    }
}

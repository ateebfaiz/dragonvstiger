package org.cocos2dx.javascript;

import android.content.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import java.net.URLDecoder;

abstract class i extends WebViewClient {

    /* renamed from: e  reason: collision with root package name */
    private static final String f1468e = WebGameActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public WebView f1469a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f1470b;

    /* renamed from: c  reason: collision with root package name */
    public WebGameActivity f1471c;

    /* renamed from: d  reason: collision with root package name */
    public String f1472d;

    i() {
    }

    private String a() {
        ClipboardManager clipboardManager = (ClipboardManager) this.f1471c.getApplicationContext().getSystemService("clipboard");
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip().getItemCount() <= 0) {
            return "";
        }
        String valueOf = String.valueOf(clipboardManager.getPrimaryClip().getItemAt(0).getText());
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        return "";
    }

    private void b(String str) {
        String str2;
        String str3 = "";
        String[] split = str.replace("game://", str3).split("&");
        if (split.length == 1) {
            str2 = split[0];
        } else {
            str3 = split[0];
            str2 = split[1];
        }
        if (split.length == 1 || str3.equals(FirebaseAnalytics.Event.SHARE)) {
            Log.d(f1468e, "sendToGame: share");
            LocalShareUtil.shareText(this.f1471c, str2 + "\n" + this.f1472d, (String) null);
        } else if (str3.equals("gamesuc")) {
            String str4 = f1468e;
            Log.d(str4, "sendToGame cmd: gamesuc");
            if (this.f1471c.timer != null) {
                Log.d(str4, "加载游戏成功1...");
                this.f1471c.cancelAllOtherCalls((String) null, true);
                this.f1471c.timer.cancel();
            }
        } else if (str3.equals("clipboard")) {
            Log.d(f1468e, "sendToGame cmd: clipboard");
            String a10 = a();
            this.f1469a.evaluateJavascript("window.app2game('" + str3 + "', '" + a10 + "');", (ValueCallback) null);
        } else {
            Log.d(f1468e, "sendToGame: false");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r2.equals("clipboard") == false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "wggame://"
            java.lang.String r1 = ""
            java.lang.String r0 = r8.replace(r0, r1)
            java.lang.String r1 = "&"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            r0 = r0[r3]
            r2.hashCode()
            r4 = 0
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case -1600397930: goto L_0x0038;
                case -195586801: goto L_0x002d;
                case 109400031: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            r1 = r5
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "share"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x002b
            goto L_0x0020
        L_0x002b:
            r1 = 2
            goto L_0x0041
        L_0x002d:
            java.lang.String r1 = "gamesuc"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0036
            goto L_0x0020
        L_0x0036:
            r1 = r3
            goto L_0x0041
        L_0x0038:
            java.lang.String r6 = "clipboard"
            boolean r6 = r2.equals(r6)
            if (r6 != 0) goto L_0x0041
            goto L_0x0020
        L_0x0041:
            switch(r1) {
                case 0: goto L_0x009d;
                case 1: goto L_0x007e;
                case 2: goto L_0x005b;
                default: goto L_0x0044;
            }
        L_0x0044:
            java.lang.String r0 = f1468e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sendToWgGame no find cmd: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r0, r8)
            goto L_0x00cb
        L_0x005b:
            java.lang.String r8 = f1468e
            java.lang.String r1 = "sendToWgGame cmd: share"
            android.util.Log.d(r8, r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r0 = "\n"
            r8.append(r0)
            java.lang.String r0 = r7.f1472d
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            org.cocos2dx.javascript.WebGameActivity r0 = r7.f1471c
            org.cocos2dx.javascript.LocalShareUtil.shareText(r0, r8, r4)
            goto L_0x00cb
        L_0x007e:
            java.lang.String r8 = f1468e
            java.lang.String r0 = "sendToWgGame cmd: gamesuc"
            android.util.Log.d(r8, r0)
            org.cocos2dx.javascript.WebGameActivity r0 = r7.f1471c
            java.util.Timer r0 = r0.timer
            if (r0 == 0) goto L_0x00cb
            java.lang.String r0 = "加载游戏成功..."
            android.util.Log.d(r8, r0)
            org.cocos2dx.javascript.WebGameActivity r8 = r7.f1471c
            r8.cancelAllOtherCalls(r4, r3)
            org.cocos2dx.javascript.WebGameActivity r8 = r7.f1471c
            java.util.Timer r8 = r8.timer
            r8.cancel()
            goto L_0x00cb
        L_0x009d:
            java.lang.String r8 = f1468e
            java.lang.String r0 = "sendToWgGame cmd: clipboard"
            android.util.Log.d(r8, r0)
            java.lang.String r8 = r7.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "window.app2game('"
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = "', '"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = "');"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.webkit.WebView r0 = r7.f1469a
            r0.evaluateJavascript(r8, r4)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.i.c(java.lang.String):void");
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        Log.d("webLog_error: received ", "ReceivedError: " + webResourceRequest.getUrl().toString() + ", " + webResourceError.getDescription());
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            URI create = URI.create(str);
            String decode = URLDecoder.decode(str, "UTF-8");
            Log.d("MyWebViewClient", "url: " + decode);
            decode.replace("game://", "");
            if (create != null && create.getScheme().equals("game")) {
                b(decode);
                return true;
            } else if (create == null || !create.getScheme().equals("wggame")) {
                return false;
            } else {
                c(decode);
                return true;
            }
        } catch (Exception unused) {
            Log.d(f1468e, "Failed to create URI from url");
            return false;
        }
    }
}

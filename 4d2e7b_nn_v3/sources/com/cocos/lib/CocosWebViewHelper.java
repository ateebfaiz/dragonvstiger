package com.cocos.lib;

import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CocosWebViewHelper {
    private static final String TAG = "CocosWebViewHelper";
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public static FrameLayout sLayout;
    private static PopupWindow sPopUp;
    private static int viewTag;
    /* access modifiers changed from: private */
    public static SparseArray<CocosWebView> webViews;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19357a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19358b;

        a(int i10, String str) {
            this.f19357a = i10;
            this.f19358b = str;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19357a);
            if (cocosWebView != null) {
                cocosWebView.loadUrl(this.f19358b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19359a;

        b(int i10) {
            this.f19359a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19359a);
            if (cocosWebView != null) {
                cocosWebView.stopLoading();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19360a;

        c(int i10) {
            this.f19360a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19360a);
            if (cocosWebView != null) {
                cocosWebView.reload();
            }
        }
    }

    class d implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19361a;

        d(int i10) {
            this.f19361a = i10;
        }

        /* renamed from: a */
        public Boolean call() {
            boolean z10;
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19361a);
            if (cocosWebView == null || !cocosWebView.canGoBack()) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19362a;

        e(int i10) {
            this.f19362a = i10;
        }

        /* renamed from: a */
        public Boolean call() {
            boolean z10;
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19362a);
            if (cocosWebView == null || !cocosWebView.canGoForward()) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19363a;

        f(int i10) {
            this.f19363a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19363a);
            if (cocosWebView != null) {
                cocosWebView.goBack();
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19364a;

        g(int i10) {
            this.f19364a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19364a);
            if (cocosWebView != null) {
                cocosWebView.goForward();
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19365a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19366b;

        h(int i10, String str) {
            this.f19365a = i10;
            this.f19366b = str;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19365a);
            if (cocosWebView != null) {
                cocosWebView.loadUrl("javascript:" + this.f19366b);
            }
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f19368b;

        i(int i10, boolean z10) {
            this.f19367a = i10;
            this.f19368b = z10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19367a);
            if (cocosWebView != null) {
                cocosWebView.setScalesPageToFit(this.f19368b);
            }
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19369a;

        j(int i10) {
            this.f19369a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = new CocosWebView(GlobalObject.getContext(), this.f19369a);
            CocosWebViewHelper.sLayout.addView(cocosWebView, new FrameLayout.LayoutParams(-2, -2));
            CocosWebViewHelper.webViews.put(this.f19369a, cocosWebView);
        }
    }

    class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19370a;

        k(int i10) {
            this.f19370a = i10;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19370a);
            if (cocosWebView != null) {
                CocosWebViewHelper.webViews.remove(this.f19370a);
                CocosWebViewHelper.sLayout.removeView(cocosWebView);
                cocosWebView.destroy();
            }
        }
    }

    class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f19372b;

        l(int i10, boolean z10) {
            this.f19371a = i10;
            this.f19372b = z10;
        }

        public void run() {
            int i10;
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19371a);
            if (cocosWebView != null) {
                if (this.f19372b) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                cocosWebView.setVisibility(i10);
            }
        }
    }

    class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19373a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19374b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19375c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f19376d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f19377e;

        m(int i10, int i11, int i12, int i13, int i14) {
            this.f19373a = i10;
            this.f19374b = i11;
            this.f19375c = i12;
            this.f19376d = i13;
            this.f19377e = i14;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19373a);
            if (cocosWebView != null) {
                cocosWebView.setWebViewRect(this.f19374b, this.f19375c, this.f19376d, this.f19377e);
            }
        }
    }

    class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19378a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f19379b;

        n(int i10, boolean z10) {
            this.f19378a = i10;
            this.f19379b = z10;
        }

        public void run() {
            int i10;
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19378a);
            if (cocosWebView != null) {
                if (this.f19379b) {
                    i10 = 0;
                } else {
                    i10 = -1;
                }
                cocosWebView.setBackgroundColor(i10);
                cocosWebView.setLayerType(1, (Paint) null);
            }
        }
    }

    class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19381b;

        o(int i10, String str) {
            this.f19380a = i10;
            this.f19381b = str;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19380a);
            if (cocosWebView != null) {
                cocosWebView.setJavascriptInterfaceScheme(this.f19381b);
            }
        }
    }

    class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19382a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19383b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19384c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19385d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f19386e;

        p(int i10, String str, String str2, String str3, String str4) {
            this.f19382a = i10;
            this.f19383b = str;
            this.f19384c = str2;
            this.f19385d = str3;
            this.f19386e = str4;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19382a);
            if (cocosWebView != null) {
                cocosWebView.loadDataWithBaseURL(this.f19383b, this.f19384c, this.f19385d, this.f19386e, (String) null);
            }
        }
    }

    class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19387a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19388b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19389c;

        q(int i10, String str, String str2) {
            this.f19387a = i10;
            this.f19388b = str;
            this.f19389c = str2;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19387a);
            if (cocosWebView != null) {
                cocosWebView.loadDataWithBaseURL(this.f19388b, this.f19389c, (String) null, (String) null, (String) null);
            }
        }
    }

    class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19390a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19391b;

        r(int i10, String str) {
            this.f19390a = i10;
            this.f19391b = str;
        }

        public void run() {
            CocosWebView cocosWebView = (CocosWebView) CocosWebViewHelper.webViews.get(this.f19390a);
            if (cocosWebView != null) {
                cocosWebView.loadUrl(this.f19391b);
            }
        }
    }

    public CocosWebViewHelper(FrameLayout frameLayout) {
        sLayout = frameLayout;
        sHandler = new Handler(Looper.myLooper());
        webViews = new SparseArray<>();
    }

    public static void _didFailLoading(int i10, String str) {
        didFailLoading(i10, str);
    }

    public static void _didFinishLoading(int i10, String str) {
        didFinishLoading(i10, str);
    }

    public static void _onJsCallback(int i10, String str) {
        onJsCallback(i10, str);
    }

    public static boolean _shouldStartLoading(int i10, String str) {
        return !shouldStartLoading(i10, str);
    }

    public static <T> T callInMainThread(Callable<T> callable) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(callable);
        sHandler.post(futureTask);
        return futureTask.get();
    }

    public static boolean canGoBack(int i10) {
        try {
            return ((Boolean) callInMainThread(new d(i10))).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static boolean canGoForward(int i10) {
        try {
            return ((Boolean) callInMainThread(new e(i10))).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static int createWebView() {
        GlobalObject.runOnUiThread(new j(viewTag));
        int i10 = viewTag;
        viewTag = i10 + 1;
        return i10;
    }

    private static native void didFailLoading(int i10, String str);

    private static native void didFinishLoading(int i10, String str);

    public static void evaluateJS(int i10, String str) {
        GlobalObject.runOnUiThread(new h(i10, str));
    }

    public static void goBack(int i10) {
        GlobalObject.runOnUiThread(new f(i10));
    }

    public static void goForward(int i10) {
        GlobalObject.runOnUiThread(new g(i10));
    }

    public static void loadData(int i10, String str, String str2, String str3, String str4) {
        GlobalObject.runOnUiThread(new p(i10, str4, str, str2, str3));
    }

    public static void loadFile(int i10, String str) {
        GlobalObject.runOnUiThread(new a(i10, str));
    }

    public static void loadHTMLString(int i10, String str, String str2) {
        GlobalObject.runOnUiThread(new q(i10, str2, str));
    }

    public static void loadUrl(int i10, String str) {
        GlobalObject.runOnUiThread(new r(i10, str));
    }

    private static native void onJsCallback(int i10, String str);

    public static void reload(int i10) {
        GlobalObject.runOnUiThread(new c(i10));
    }

    public static void removeWebView(int i10) {
        GlobalObject.runOnUiThread(new k(i10));
    }

    public static void setBackgroundTransparent(int i10, boolean z10) {
        GlobalObject.runOnUiThread(new n(i10, z10));
    }

    public static void setJavascriptInterfaceScheme(int i10, String str) {
        GlobalObject.runOnUiThread(new o(i10, str));
    }

    public static void setScalesPageToFit(int i10, boolean z10) {
        GlobalObject.runOnUiThread(new i(i10, z10));
    }

    public static void setVisible(int i10, boolean z10) {
        GlobalObject.runOnUiThread(new l(i10, z10));
    }

    public static void setWebViewRect(int i10, int i11, int i12, int i13, int i14) {
        GlobalObject.runOnUiThread(new m(i10, i11, i12, i13, i14));
    }

    private static native boolean shouldStartLoading(int i10, String str);

    public static void stopLoading(int i10) {
        GlobalObject.runOnUiThread(new b(i10));
    }
}

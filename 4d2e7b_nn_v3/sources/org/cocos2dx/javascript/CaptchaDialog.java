package org.cocos2dx.javascript;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;

public final class CaptchaDialog extends DialogFragment {
    private static final String ARG_URL = "url";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CaptchaDialog";

    public static final class Companion {
        private Companion() {
        }

        public final CaptchaDialog newInstance(String str) {
            m.f(str, "url");
            CaptchaDialog captchaDialog = new CaptchaDialog();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            captchaDialog.setArguments(bundle);
            return captchaDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class JsInterface {
        public JsInterface() {
        }

        @JavascriptInterface
        public final void postMessage(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "data");
            CaptchaDialog captchaDialog = CaptchaDialog.this;
            try {
                o.a aVar = o.f12592b;
                captchaDialog.dismiss();
                b0 b0Var = b0.f709a;
                String format = String.format("window['G']?.PlatformUtils?.cloudflareBehavior(`%s`,`%s`);", Arrays.copyOf(new Object[]{str, str2}, 2));
                m.e(format, "format(...)");
                PlatformUtils.callJSMethod(format);
                o.b(Unit.f12577a);
            } catch (Throwable th) {
                o.a aVar2 = o.f12592b;
                o.b(p.a(th));
            }
        }
    }

    private final void initView(WebView webView) {
        String str;
        Window window;
        View decorView;
        webView.setBackgroundColor(0);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(-1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(true);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("url")) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            dismiss();
            return;
        }
        webView.loadUrl(str);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            webView.setLayoutParams(new FrameLayout.LayoutParams(rect.width(), rect.height()));
            webView.requestLayout();
        }
        webView.addJavascriptInterface(new JsInterface(), "jsBridge");
        webView.setWebChromeClient(new CaptchaDialog$initView$3(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext());
        Window window = dialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WebView webView = new WebView(requireContext());
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        initView(webView);
        frameLayout.addView(webView);
        dialog.setContentView(frameLayout);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        return dialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.clearFlags(2);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setDimAmount(0.0f);
            }
        }
    }

    public final void showUniqueDialog(FragmentManager fragmentManager) {
        m.f(fragmentManager, "fragmentManager");
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            show(fragmentManager, TAG);
        }
    }
}

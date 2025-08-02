package com.facebook.react.devsupport;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.o;
import java.util.Locale;

public class d implements k6.c {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f3051d = true;

    /* renamed from: a  reason: collision with root package name */
    private final x0 f3052a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f3053b;

    /* renamed from: c  reason: collision with root package name */
    private PopupWindow f3054c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3055a;

        a(String str) {
            this.f3055a = str;
        }

        public void run() {
            d.this.h(this.f3055a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3057a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f3058b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Integer f3059c;

        b(String str, Integer num, Integer num2) {
            this.f3057a = str;
            this.f3058b = num;
            this.f3059c = num2;
        }

        public void run() {
            Integer num;
            StringBuilder sb2 = new StringBuilder();
            String str = this.f3057a;
            if (str == null) {
                str = "Loading";
            }
            sb2.append(str);
            if (!(this.f3058b == null || (num = this.f3059c) == null || num.intValue() <= 0)) {
                sb2.append(String.format(Locale.getDefault(), " %.1f%%", new Object[]{Float.valueOf((((float) this.f3058b.intValue()) / ((float) this.f3059c.intValue())) * 100.0f)}));
            }
            sb2.append("…");
            if (d.this.f3053b != null) {
                d.this.f3053b.setText(sb2);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            d.this.g();
        }
    }

    public d(x0 x0Var) {
        this.f3052a = x0Var;
    }

    /* access modifiers changed from: private */
    public void g() {
        PopupWindow popupWindow = this.f3054c;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f3054c.dismiss();
            this.f3054c = null;
            this.f3053b = null;
        }
    }

    /* access modifiers changed from: private */
    public void h(String str) {
        PopupWindow popupWindow = this.f3054c;
        if (popupWindow == null || !popupWindow.isShowing()) {
            Activity j10 = this.f3052a.j();
            if (j10 == null) {
                z2.a.j("ReactNative", "Unable to display loading message because react activity isn't available");
                return;
            }
            try {
                Rect rect = new Rect();
                j10.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int i10 = rect.top;
                TextView textView = (TextView) ((LayoutInflater) j10.getSystemService("layout_inflater")).inflate(o.f20872a, (ViewGroup) null);
                this.f3053b = textView;
                textView.setText(str);
                PopupWindow popupWindow2 = new PopupWindow(this.f3053b, -1, -2);
                this.f3054c = popupWindow2;
                popupWindow2.setTouchable(false);
                this.f3054c.showAtLocation(j10.getWindow().getDecorView(), 0, 0, i10);
            } catch (WindowManager.BadTokenException unused) {
                z2.a.j("ReactNative", "Unable to display loading message because react activity isn't active, message: " + str);
            }
        }
    }

    public void a() {
        if (f3051d) {
            UiThreadUtil.runOnUiThread(new c());
        }
    }

    public void b(String str) {
        if (f3051d) {
            UiThreadUtil.runOnUiThread(new a(str));
        }
    }

    public void c(String str, Integer num, Integer num2) {
        if (f3051d) {
            UiThreadUtil.runOnUiThread(new b(str, num, num2));
        }
    }
}

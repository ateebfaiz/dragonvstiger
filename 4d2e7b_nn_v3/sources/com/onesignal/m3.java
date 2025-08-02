package com.onesignal;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.onesignal.a;
import java.lang.ref.WeakReference;

abstract class m3 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10794a = b(24);

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f10796b;

        /* renamed from: com.onesignal.m3$a$a  reason: collision with other inner class name */
        class C0126a extends a.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f10797a;

            C0126a(a aVar) {
                this.f10797a = aVar;
            }

            /* access modifiers changed from: package-private */
            public void a(Activity activity) {
                this.f10797a.r(a.this.f10795a);
                if (m3.i(activity)) {
                    a.this.f10796b.run();
                } else {
                    m3.a(activity, a.this.f10796b);
                }
            }
        }

        a(String str, Runnable runnable) {
            this.f10795a = str;
            this.f10796b = runnable;
        }

        public void run() {
            a b10 = b.b();
            if (b10 != null) {
                b10.c(this.f10795a, new C0126a(b10));
            }
        }
    }

    static void a(Activity activity, Runnable runnable) {
        activity.getWindow().getDecorView().post(new a("decorViewReady:" + runnable, runnable));
    }

    static int b(int i10) {
        return (int) (((float) i10) * Resources.getSystem().getDisplayMetrics().density);
    }

    static int[] c(Activity activity) {
        float f10;
        float f11;
        DisplayCutout a10;
        Rect g10 = g(activity);
        View findViewById = activity.getWindow().findViewById(16908290);
        float top = ((float) (g10.top - findViewById.getTop())) / Resources.getSystem().getDisplayMetrics().density;
        float bottom = ((float) (findViewById.getBottom() - g10.bottom)) / Resources.getSystem().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT != 29 || (a10 = activity.getWindowManager().getDefaultDisplay().getCutout()) == null) {
            f11 = 0.0f;
            f10 = 0.0f;
        } else {
            f11 = ((float) a10.getSafeInsetRight()) / Resources.getSystem().getDisplayMetrics().density;
            f10 = ((float) a10.getSafeInsetLeft()) / Resources.getSystem().getDisplayMetrics().density;
        }
        return new int[]{Math.round(top), Math.round(bottom), Math.round(f11), Math.round(f10)};
    }

    static int d(Activity activity) {
        return activity.getWindow().getDecorView().getWidth();
    }

    static int e(Activity activity) {
        return f(activity);
    }

    private static int f(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return decorView.getHeight();
        }
        return (decorView.getHeight() - rootWindowInsets.getStableInsetBottom()) - rootWindowInsets.getStableInsetTop();
    }

    private static Rect g(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    static int h(Activity activity) {
        return g(activity).width();
    }

    static boolean i(Activity activity) {
        boolean z10;
        boolean z11;
        if (activity.getWindow().getDecorView().getApplicationWindowToken() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (activity.getWindow().getDecorView().getRootWindowInsets() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    static boolean j(WeakReference weakReference) {
        View view;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Rect rect = new Rect();
        if (weakReference.get() != null) {
            Window window = ((Activity) weakReference.get()).getWindow();
            view = window.getDecorView();
            view.getWindowVisibleDisplayFrame(rect);
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            view = null;
        }
        if (view == null || displayMetrics.heightPixels - rect.bottom <= f10794a) {
            return false;
        }
        return true;
    }
}

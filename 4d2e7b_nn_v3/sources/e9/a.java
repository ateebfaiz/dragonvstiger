package e9;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.alibaba.pdns.f;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f11966a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11967b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11968c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11969d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11970e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11971f;

    /* renamed from: g  reason: collision with root package name */
    private final float f11972g;

    a(Activity activity) {
        boolean z10;
        boolean z11 = false;
        if (activity.getResources().getConfiguration().orientation == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f11971f = z10;
        this.f11972g = h(activity);
        this.f11966a = c(activity, "status_bar_height");
        this.f11967b = b(activity);
        int e10 = e(activity);
        this.f11969d = e10;
        this.f11970e = g(activity);
        this.f11968c = e10 > 0 ? true : z11;
    }

    private int b(Activity activity) {
        int i10;
        View findViewById = activity.getWindow().findViewById(q.f12039a);
        if (findViewById != null) {
            i10 = findViewById.getMeasuredHeight();
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(16843499, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    private int c(Context context, String str) {
        float f10;
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", f.f17924q);
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f11 = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                if (f11 >= 0.0f) {
                    f10 = f11 + 0.5f;
                } else {
                    f10 = f11 - 0.5f;
                }
                return (int) f10;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    private int e(Context context) {
        String str;
        if (!j((Activity) context)) {
            return 0;
        }
        if (this.f11971f) {
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return c(context, str);
    }

    private int g(Context context) {
        if (j((Activity) context)) {
            return c(context, "navigation_bar_width");
        }
        return 0;
    }

    private float h(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f10 = displayMetrics.density;
        return Math.min(((float) displayMetrics.widthPixels) / f10, ((float) displayMetrics.heightPixels) / f10);
    }

    private boolean j(Activity activity) {
        if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            return false;
        }
        if (o.f()) {
            if (!o.i()) {
                if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            } else if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                return false;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i12 = displayMetrics2.heightPixels;
        if (i11 - displayMetrics2.widthPixels > 0 || i10 - i12 > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f11967b;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f11969d;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f11970e;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f11966a;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f11968c;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        if (this.f11972g >= 600.0f || this.f11971f) {
            return true;
        }
        return false;
    }
}

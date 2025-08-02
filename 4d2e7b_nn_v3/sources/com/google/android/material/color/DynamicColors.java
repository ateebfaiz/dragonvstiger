package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.adjust.sdk.Constants;
import com.google.android.material.R;
import com.google.android.material.color.DynamicColorsOptions;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DynamicColors {
    private static final c DEFAULT_DEVICE_SUPPORT_CONDITION;
    private static final Map<String, c> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, c> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    @SuppressLint({"PrivateApi"})
    private static final c SAMSUNG_DEVICE_SUPPORT_CONDITION;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    public interface OnAppliedCallback {
        void onApplied(@NonNull Activity activity);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(@NonNull Activity activity, @StyleRes int i10);
    }

    class a implements c {
        a() {
        }

        public boolean isSupported() {
            return true;
        }
    }

    class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private Long f8042a;

        b() {
        }

        public boolean isSupported() {
            if (this.f8042a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", new Class[]{String.class});
                    declaredMethod.setAccessible(true);
                    Long l10 = (Long) declaredMethod.invoke((Object) null, new Object[]{"ro.build.version.oneui"});
                    l10.longValue();
                    this.f8042a = l10;
                } catch (Exception unused) {
                    this.f8042a = -1L;
                }
            }
            if (this.f8042a.longValue() >= 40100) {
                return true;
            }
            return false;
        }
    }

    private interface c {
        boolean isSupported();
    }

    private static class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final DynamicColorsOptions f8043a;

        d(DynamicColorsOptions dynamicColorsOptions) {
            this.f8043a = dynamicColorsOptions;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyToActivityIfAvailable(activity, this.f8043a.getThemeOverlay(), this.f8043a.getPrecondition(), this.f8043a.getOnAppliedCallback());
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        a aVar = new a();
        DEFAULT_DEVICE_SUPPORT_CONDITION = aVar;
        b bVar = new b();
        SAMSUNG_DEVICE_SUPPORT_CONDITION = bVar;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.REFERRER_API_GOOGLE, aVar);
        hashMap.put("hmd global", aVar);
        hashMap.put("infinix", aVar);
        hashMap.put("infinix mobility limited", aVar);
        hashMap.put("itel", aVar);
        hashMap.put("kyocera", aVar);
        hashMap.put("lenovo", aVar);
        hashMap.put("lge", aVar);
        hashMap.put("motorola", aVar);
        hashMap.put("nothing", aVar);
        hashMap.put("oneplus", aVar);
        hashMap.put("oppo", aVar);
        hashMap.put("realme", aVar);
        hashMap.put("robolectric", aVar);
        hashMap.put(Constants.REFERRER_API_SAMSUNG, bVar);
        hashMap.put("sharp", aVar);
        hashMap.put("sony", aVar);
        hashMap.put("tcl", aVar);
        hashMap.put("tecno", aVar);
        hashMap.put("tecno mobile limited", aVar);
        hashMap.put("vivo", aVar);
        hashMap.put(Constants.REFERRER_API_XIAOMI, aVar);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", aVar);
        hashMap2.put("jio", aVar);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
    }

    private DynamicColors() {
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity activity) {
        applyToActivityIfAvailable(activity);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().build());
    }

    public static void applyToActivityIfAvailable(@NonNull Activity activity) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().build());
    }

    private static int getDefaultThemeOverlay(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @SuppressLint({"DefaultLocale"})
    @ChecksSdkIntAtLeast(api = 31)
    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        c cVar = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (cVar == null) {
            cVar = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
        }
        if (cVar == null || !cVar.isSupported()) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity activity, @StyleRes int i10) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setThemeOverlay(i10).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i10) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i10).build());
    }

    public static void applyToActivityIfAvailable(@NonNull Activity activity, @NonNull DynamicColorsOptions dynamicColorsOptions) {
        applyToActivityIfAvailable(activity, dynamicColorsOptions.getThemeOverlay(), dynamicColorsOptions.getPrecondition(), dynamicColorsOptions.getOnAppliedCallback());
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @StyleRes int i10) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        if (i10 == 0) {
            i10 = getDefaultThemeOverlay(context);
        }
        return i10 == 0 ? context : new ContextThemeWrapper(context, i10);
    }

    @Deprecated
    public static void applyIfAvailable(@NonNull Activity activity, @NonNull Precondition precondition) {
        applyToActivityIfAvailable(activity, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setPrecondition(precondition).build());
    }

    /* access modifiers changed from: private */
    public static void applyToActivityIfAvailable(@NonNull Activity activity, @StyleRes int i10, @NonNull Precondition precondition, @NonNull OnAppliedCallback onAppliedCallback) {
        if (isDynamicColorAvailable()) {
            if (i10 == 0) {
                i10 = getDefaultThemeOverlay(activity);
            }
            if (i10 != 0 && precondition.shouldApplyDynamicColors(activity, i10)) {
                n.a(activity, i10);
                onAppliedCallback.onApplied(activity);
            }
        }
    }

    @Deprecated
    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i10, @NonNull Precondition precondition) {
        applyToActivitiesIfAvailable(application, new DynamicColorsOptions.Builder().setThemeOverlay(i10).setPrecondition(precondition).build());
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull DynamicColorsOptions dynamicColorsOptions) {
        application.registerActivityLifecycleCallbacks(new d(dynamicColorsOptions));
    }
}

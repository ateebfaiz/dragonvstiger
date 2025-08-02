package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> cls) {
        return isComponentExplicitlyEnabled(context, cls.getName());
    }

    public static void setComponentEnabled(@NonNull Context context, @NonNull Class<?> cls, boolean z10) {
        int i10;
        String str;
        String str2 = "disabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z10) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i10, 1);
            Logger logger = Logger.get();
            String str3 = TAG;
            String name = cls.getName();
            if (z10) {
                str = "enabled";
            } else {
                str = str2;
            }
            logger.debug(str3, String.format("%s %s", new Object[]{name, str}), new Throwable[0]);
        } catch (Exception e10) {
            Logger logger2 = Logger.get();
            String str4 = TAG;
            String name2 = cls.getName();
            if (z10) {
                str2 = "enabled";
            }
            logger2.debug(str4, String.format("%s could not be %s", new Object[]{name2, str2}), e10);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str)) == 1;
    }
}

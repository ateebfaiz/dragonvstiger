package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private static class a {
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        static String a(TelephonyManager telephonyManager, int i10) {
            return telephonyManager.getDeviceId(i10);
        }
    }

    private static class b {
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    private static class c {
        @DoNotInline
        static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    @Nullable
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId == Integer.MAX_VALUE || subscriptionId == -1) {
            return telephonyManager.getDeviceId();
        }
        return a.a(telephonyManager, SubscriptionManagerCompat.getSlotIndex(subscriptionId));
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return c.a(telephonyManager);
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", (Class[]) null);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, (Object[]) null);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}

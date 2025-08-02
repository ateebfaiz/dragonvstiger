package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.jvm.internal.m;

public final class BuildCompat {
    @ChecksSdkIntAtLeast(extension = 1000000)
    public static final int AD_SERVICES_EXTENSION_INT;
    public static final BuildCompat INSTANCE = new BuildCompat();
    @ChecksSdkIntAtLeast(extension = 30)
    public static final int R_EXTENSION_INT;
    @ChecksSdkIntAtLeast(extension = 31)
    public static final int S_EXTENSION_INT;
    @ChecksSdkIntAtLeast(extension = 33)
    public static final int T_EXTENSION_INT;

    @Retention(RetentionPolicy.CLASS)
    public @interface PrereleaseSdkCheck {
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15035a = new a();

        private a() {
        }

        @DoNotInline
        public final int a(int i10) {
            return SdkExtensions.getExtensionVersion(i10);
        }
    }

    static {
        int i10;
        int i11;
        int i12;
        int i13 = Build.VERSION.SDK_INT;
        int i14 = 0;
        if (i13 >= 30) {
            i10 = a.f15035a.a(30);
        } else {
            i10 = 0;
        }
        R_EXTENSION_INT = i10;
        if (i13 >= 30) {
            i11 = a.f15035a.a(31);
        } else {
            i11 = 0;
        }
        S_EXTENSION_INT = i11;
        if (i13 >= 30) {
            i12 = a.f15035a.a(33);
        } else {
            i12 = 0;
        }
        T_EXTENSION_INT = i12;
        if (i13 >= 30) {
            i14 = a.f15035a.a(1000000);
        }
        AD_SERVICES_EXTENSION_INT = i14;
    }

    private BuildCompat() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static final boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 25)
    public static final boolean isAtLeastNMR1() {
        if (Build.VERSION.SDK_INT >= 25) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 26)
    public static final boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 27)
    public static final boolean isAtLeastOMR1() {
        if (Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean isAtLeastPreReleaseCodename(String str, String str2) {
        m.f(str, "codename");
        m.f(str2, "buildCodename");
        if (m.b("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        m.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        m.e(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.compareTo(upperCase2) >= 0) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 29)
    public static final boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static final boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    public static final boolean isAtLeastS() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31) {
            if (i10 >= 30) {
                String str = Build.VERSION.CODENAME;
                m.e(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("S", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    public static final boolean isAtLeastSv2() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 32) {
            if (i10 >= 31) {
                String str = Build.VERSION.CODENAME;
                m.e(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("Sv2", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    public static final boolean isAtLeastT() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 33) {
            if (i10 >= 32) {
                String str = Build.VERSION.CODENAME;
                m.e(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("Tiramisu", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @ChecksSdkIntAtLeast(api = 34, codename = "UpsideDownCake")
    public static final boolean isAtLeastU() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 34) {
            if (i10 >= 33) {
                String str = Build.VERSION.CODENAME;
                m.e(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("UpsideDownCake", str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @ChecksSdkIntAtLeast(codename = "VanillaIceCream")
    @PrereleaseSdkCheck
    public static final boolean isAtLeastV() {
        if (Build.VERSION.SDK_INT >= 34) {
            String str = Build.VERSION.CODENAME;
            m.e(str, "CODENAME");
            if (isAtLeastPreReleaseCodename("VanillaIceCream", str)) {
                return true;
            }
        }
        return false;
    }
}

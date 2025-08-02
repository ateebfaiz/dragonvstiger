package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.LocaleListCompat;

public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    private static class a {
        @DoNotInline
        static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @DoNotInline
        static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i10) {
            return accessibilityWindowInfo.getChild(i10);
        }

        @DoNotInline
        static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @DoNotInline
        static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @DoNotInline
        static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @DoNotInline
        static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @DoNotInline
        static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @DoNotInline
        static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @DoNotInline
        static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @DoNotInline
        static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @DoNotInline
        static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @DoNotInline
        static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    private static class b {
        @DoNotInline
        static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @DoNotInline
        static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    private static class c {
        @DoNotInline
        static boolean a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    private static class d {
        @DoNotInline
        static AccessibilityWindowInfo a() {
            return new AccessibilityWindowInfo();
        }
    }

    private static class e {
        @DoNotInline
        static int a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        @DoNotInline
        static void b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat c(Object obj, int i10) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) obj).getRoot(i10));
        }
    }

    private static class f {
        @DoNotInline
        static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        @DoNotInline
        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mInfo = d.a();
        } else {
            this.mInfo = null;
        }
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(a.l());
    }

    private static String typeToString(int i10) {
        if (i10 == 1) {
            return "TYPE_APPLICATION";
        }
        if (i10 == 2) {
            return "TYPE_INPUT_METHOD";
        }
        if (i10 == 3) {
            return "TYPE_SYSTEM";
        }
        if (i10 != 4) {
            return "<UNKNOWN>";
        }
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 != null) {
            return obj2.equals(accessibilityWindowInfoCompat.mInfo);
        }
        if (accessibilityWindowInfoCompat.mInfo == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(b.a((AccessibilityWindowInfo) this.mInfo));
        }
        return null;
    }

    public void getBoundsInScreen(@NonNull Rect rect) {
        a.a((AccessibilityWindowInfo) this.mInfo, rect);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int i10) {
        return wrapNonNullInstance(a.b((AccessibilityWindowInfo) this.mInfo, i10));
    }

    public int getChildCount() {
        return a.c((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return e.a((AccessibilityWindowInfo) this.mInfo);
        }
        return 0;
    }

    public int getId() {
        return a.d((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        return a.e((AccessibilityWindowInfo) this.mInfo);
    }

    @NonNull
    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocaleListCompat.wrap(f.a((AccessibilityWindowInfo) this.mInfo));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(a.f((AccessibilityWindowInfo) this.mInfo));
    }

    public void getRegionInScreen(@NonNull Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            e.b((AccessibilityWindowInfo) this.mInfo, region);
            return;
        }
        Rect rect = new Rect();
        a.a((AccessibilityWindowInfo) this.mInfo, rect);
        region.set(rect);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(a.g((AccessibilityWindowInfo) this.mInfo));
    }

    @Nullable
    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b((AccessibilityWindowInfo) this.mInfo);
        }
        return null;
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return f.b((AccessibilityWindowInfo) this.mInfo);
        }
        return 0;
    }

    public int getType() {
        return a.h((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return a.i((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        return a.j((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        return a.k((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.a((AccessibilityWindowInfo) this.mInfo);
        }
        return false;
    }

    @Deprecated
    public void recycle() {
    }

    @NonNull
    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb2.append("AccessibilityWindowInfo[");
        sb2.append("id=");
        sb2.append(getId());
        sb2.append(", type=");
        sb2.append(typeToString(getType()));
        sb2.append(", layer=");
        sb2.append(getLayer());
        sb2.append(", bounds=");
        sb2.append(rect);
        sb2.append(", focused=");
        sb2.append(isFocused());
        sb2.append(", active=");
        sb2.append(isActive());
        sb2.append(", hasParent=");
        boolean z11 = false;
        if (getParent() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb2.append(z10);
        sb2.append(", hasChildren=");
        if (getChildCount() > 0) {
            z11 = true;
        }
        sb2.append(z11);
        sb2.append(", transitionTime=");
        sb2.append(getTransitionTimeMillis());
        sb2.append(", locales=");
        sb2.append(getLocales());
        sb2.append(']');
        return sb2.toString();
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(a.m((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot(int i10) {
        if (Build.VERSION.SDK_INT >= 33) {
            return e.c(this.mInfo, i10);
        }
        return getRoot();
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }
}

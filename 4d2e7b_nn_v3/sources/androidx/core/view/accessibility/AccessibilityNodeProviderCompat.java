package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    @Nullable
    private final Object mProvider;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityNodeProviderCompat f15252a;

        a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f15252a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.f15252a.createAccessibilityNodeInfo(i10);
            if (createAccessibilityNodeInfo == null) {
                return null;
            }
            return createAccessibilityNodeInfo.unwrap();
        }

        public List findAccessibilityNodeInfosByText(String str, int i10) {
            List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.f15252a.findAccessibilityNodeInfosByText(str, i10);
            if (findAccessibilityNodeInfosByText == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = findAccessibilityNodeInfosByText.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(findAccessibilityNodeInfosByText.get(i11).unwrap());
            }
            return arrayList;
        }

        public AccessibilityNodeInfo findFocus(int i10) {
            AccessibilityNodeInfoCompat findFocus = this.f15252a.findFocus(i10);
            if (findFocus == null) {
                return null;
            }
            return findFocus.unwrap();
        }

        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f15252a.performAction(i10, i11, bundle);
        }
    }

    static class b extends a {
        b(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f15252a.addExtraDataToAccessibilityNodeInfo(i10, AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mProvider = new b(this);
        } else {
            this.mProvider = new a(this);
        }
    }

    public void addExtraDataToAccessibilityNodeInfo(int i10, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i10) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String str, int i10) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i10) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i10, int i11, @Nullable Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object obj) {
        this.mProvider = obj;
    }
}

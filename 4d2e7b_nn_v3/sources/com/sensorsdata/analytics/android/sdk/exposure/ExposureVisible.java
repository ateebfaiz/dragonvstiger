package com.sensorsdata.analytics.android.sdk.exposure;

import android.graphics.Rect;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import java.util.HashMap;

public class ExposureVisible {
    private final HashMap<String, Boolean> mVisible = new HashMap<>();

    /* JADX WARNING: Removed duplicated region for block: B:7:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isParentVisible(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.view.ViewParent r4 = r4.getParent()
        L_0x0008:
            boolean r1 = r4 instanceof android.view.View
            if (r1 != 0) goto L_0x000e
            r4 = 1
            return r4
        L_0x000e:
            r1 = r4
            android.view.View r1 = (android.view.View) r1
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            boolean r1 = r3.isViewSelfVisible(r1, r2)
            if (r1 != 0) goto L_0x001d
            return r0
        L_0x001d:
            android.view.ViewParent r4 = r4.getParent()
            if (r4 != 0) goto L_0x0008
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.ExposureVisible.isParentVisible(android.view.View):boolean");
    }

    private boolean isViewSelfVisible(View view, Rect rect) {
        boolean z10;
        if (view == null || view.getWindowVisibility() == 8) {
            SALog.i("SA.ExposureVisible", "view.getWindowVisibility() == View.GONE");
            return false;
        }
        HashMap<String, Boolean> hashMap = this.mVisible;
        Boolean bool = hashMap.get(view.hashCode() + "");
        if (bool == null) {
            z10 = view.getLocalVisibleRect(rect);
            HashMap<String, Boolean> hashMap2 = this.mVisible;
            hashMap2.put(view.hashCode() + "", Boolean.valueOf(z10));
        } else {
            z10 = bool.booleanValue();
        }
        if (WindowHelper.isDecorView(view.getClass())) {
            return true;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || view.getAlpha() <= 0.0f || !z10) {
            SALog.i("SA.ExposureVisible", "isViewSelfVisible，width = " + view.getWidth() + ",height = " + view.getHeight() + "，alpha = " + view.getAlpha());
            return false;
        } else if ((view.getAnimation() == null || !view.getAnimation().getFillAfter()) && view.getVisibility() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void cleanVisible() {
        this.mVisible.clear();
    }

    public boolean isVisible(View view, Rect rect) {
        if (isViewSelfVisible(view, rect) && isParentVisible(view)) {
            return view.isShown();
        }
        return false;
    }
}

package com.sensorsdata.analytics.android.sdk.exposure;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ExposedPage {
    private static final String TAG = "SA.ExposedPage";
    private final Map<String, ExposureView> mExposureViewMap = new HashMap();
    private final ExposureVisible mExposureVisible = new ExposureVisible();
    private final WeakHashMap<View, ExposureView> mViewWeakHashMap = new WeakHashMap<>();

    private boolean isExposed(ExposureView exposureView) {
        boolean isLastVisible = exposureView.isLastVisible();
        View view = exposureView.getView();
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!this.mExposureVisible.isVisible(view, rect)) {
            exposureView.setLastVisible(false);
            return false;
        } else if (!isLastVisible && visibleRect(view, rect, exposureView.getExposureData().getExposureConfig().getAreaRate())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean viewIsExposed(ExposureView exposureView) {
        SAExposureData exposureData;
        SAExposureConfig exposureConfig;
        if (!(exposureView == null || (exposureData = exposureView.getExposureData()) == null || (exposureConfig = exposureData.getExposureConfig()) == null || !exposureView.isAddExposureView())) {
            boolean isRepeated = exposureConfig.isRepeated();
            boolean isExposed = isExposed(exposureView);
            SALog.i(TAG, "viewIsExposed:" + isExposed);
            if (isRepeated) {
                if (isExposed) {
                    return true;
                }
            } else if (!isExposed || (exposureView.isExposed() && !exposureView.isActivityChange())) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean visibleRect(View view, Rect rect, float f10) {
        if (view == null) {
            return false;
        }
        SALog.i(TAG, "width = " + rect.width() + ", height = " + rect.height() + ", MeasuredHeight = " + view.getMeasuredHeight() + ", MeasuredWidth = " + view.getMeasuredWidth());
        if (((float) (rect.width() * rect.height())) >= ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * f10) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addExposureView(android.view.View r2, com.sensorsdata.analytics.android.sdk.exposure.ExposureView r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0010
            if (r3 != 0) goto L_0x0006
            goto L_0x0010
        L_0x0006:
            java.util.WeakHashMap<android.view.View, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> r0 = r1.mViewWeakHashMap     // Catch:{ all -> 0x000d }
            r0.put(r2, r3)     // Catch:{ all -> 0x000d }
            monitor-exit(r1)
            return
        L_0x000d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0010:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.ExposedPage.addExposureView(android.view.View, com.sensorsdata.analytics.android.sdk.exposure.ExposureView):void");
    }

    public synchronized ExposureView getExposureView(View view) {
        if (view == null) {
            return null;
        }
        return this.mViewWeakHashMap.get(view);
    }

    public synchronized List<ExposureView> getExposureViewList(View view) {
        ArrayList arrayList;
        try {
            this.mExposureVisible.cleanVisible();
            arrayList = new ArrayList();
            if (view != null) {
                arrayList.add(this.mViewWeakHashMap.get(view));
            } else {
                for (View next : this.mViewWeakHashMap.keySet()) {
                    if (next != null) {
                        ExposureView exposureView = this.mViewWeakHashMap.get(next);
                        SALog.i(TAG, "getExposureViewList->exposureview:" + exposureView);
                        if (viewIsExposed(exposureView)) {
                            arrayList.add(exposureView);
                        }
                    }
                }
                this.mExposureVisible.cleanVisible();
                Collections.sort(arrayList, new Comparator<ExposureView>() {
                    public int compare(ExposureView exposureView, ExposureView exposureView2) {
                        return (int) (exposureView.getAddTime() - exposureView2.getAddTime());
                    }
                });
            }
        } finally {
        }
        return arrayList;
    }

    public int getExposureViewSize() {
        return this.mViewWeakHashMap.size();
    }

    public Collection<ExposureView> getExposureViews() {
        return this.mViewWeakHashMap.values();
    }

    public synchronized void invisibleElement() {
        ExposureView exposureView;
        for (View next : this.mViewWeakHashMap.keySet()) {
            if (!(next == null || (exposureView = this.mViewWeakHashMap.get(next)) == null)) {
                exposureView.setLastVisible(false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeExposureView(android.view.View r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            com.sensorsdata.analytics.android.sdk.exposure.ExposureView r0 = r2.getExposureView((android.view.View) r3)     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0049
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r1 = r0.getExposureData()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0049
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r1 = r0.getExposureData()     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r1.getIdentifier()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0038
            if (r4 == 0) goto L_0x0038
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r0 = r0.getExposureData()     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = r0.getIdentifier()     // Catch:{ all -> 0x0036 }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0049
            java.util.WeakHashMap<android.view.View, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> r0 = r2.mViewWeakHashMap     // Catch:{ all -> 0x0036 }
            r0.remove(r3)     // Catch:{ all -> 0x0036 }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> r3 = r2.mExposureViewMap     // Catch:{ all -> 0x0036 }
            r3.remove(r4)     // Catch:{ all -> 0x0036 }
            goto L_0x0049
        L_0x0036:
            r3 = move-exception
            goto L_0x004b
        L_0x0038:
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r0 = r0.getExposureData()     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = r0.getIdentifier()     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0049
            if (r4 != 0) goto L_0x0049
            java.util.WeakHashMap<android.view.View, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> r4 = r2.mViewWeakHashMap     // Catch:{ all -> 0x0036 }
            r4.remove(r3)     // Catch:{ all -> 0x0036 }
        L_0x0049:
            monitor-exit(r2)
            return
        L_0x004b:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.ExposedPage.removeExposureView(android.view.View, java.lang.String):void");
    }

    public synchronized ExposureView getExposureView(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mExposureViewMap.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addExposureView(java.lang.String r2, com.sensorsdata.analytics.android.sdk.exposure.ExposureView r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x0013
            if (r3 != 0) goto L_0x000a
            goto L_0x0013
        L_0x000a:
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.exposure.ExposureView> r0 = r1.mExposureViewMap     // Catch:{ all -> 0x0011 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0011 }
            monitor-exit(r1)
            return
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.ExposedPage.addExposureView(java.lang.String, com.sensorsdata.analytics.android.sdk.exposure.ExposureView):void");
    }
}

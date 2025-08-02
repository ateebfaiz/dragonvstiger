package com.sensorsdata.analytics.android.sdk.exposure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil;
import java.lang.ref.WeakReference;
import java.util.Collection;

public class ExposedTransform implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private final String TAG = "SA.ExposedTransform";
    private volatile boolean isMonitor = false;
    /* access modifiers changed from: private */
    public boolean isResumedLayoutChanged;
    /* access modifiers changed from: private */
    public WeakReference<Activity> mActivityWeakReference;
    private final AppPageChange mAppPageChange;
    private final SAExposedProcess.CallBack mCallBack;
    private volatile int windowCount = -1;

    interface LayoutCallBack {
        void viewLayoutChange();
    }

    public ExposedTransform(final SAExposedProcess.CallBack callBack) {
        this.mCallBack = callBack;
        this.mAppPageChange = new AppPageChange(new LayoutCallBack() {
            public void viewLayoutChange() {
                Activity activity;
                if (ExposedTransform.this.mActivityWeakReference != null && (activity = (Activity) ExposedTransform.this.mActivityWeakReference.get()) != null && ExposedTransform.this.isViewChanged(activity)) {
                    boolean unused = ExposedTransform.this.isResumedLayoutChanged = false;
                    callBack.viewLayoutChange(activity);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isViewChanged(Activity activity) {
        try {
            Collection<ExposureView> exposureViews = this.mCallBack.getExposureViews(activity);
            if (exposureViews != null) {
                if (!exposureViews.isEmpty()) {
                    boolean z10 = false;
                    for (ExposureView next : exposureViews) {
                        try {
                            View view = next.getView();
                            int[] iArr = new int[2];
                            view.getLocationOnScreen(iArr);
                            String str = (String) view.getTag(R.id.sensors_analytics_tag_view_exposure_key);
                            String str2 = iArr[0] + "," + iArr[1] + "," + ViewUtil.viewVisibilityInParents(view);
                            if (str2.equals(str)) {
                                if (this.isResumedLayoutChanged) {
                                }
                                view.setTag(R.id.sensors_analytics_tag_view_exposure_key, str2);
                            }
                            SALog.i("SA.ExposedTransform", str + ", newSize = " + str2 + ",view = " + view);
                            try {
                                next.setViewLayoutChange(true);
                                z10 = true;
                                view.setTag(R.id.sensors_analytics_tag_view_exposure_key, str2);
                            } catch (Exception e10) {
                                e = e10;
                                z10 = true;
                                SALog.printStackTrace(e);
                            }
                        } catch (Exception e11) {
                            e = e11;
                        }
                    }
                    return z10;
                }
            }
            return false;
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
            return true;
        }
    }

    private View[] processViews() {
        try {
            WindowHelper.init();
            View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
            if (sortedWindowViews.length > 0) {
                this.windowCount = sortedWindowViews.length;
            } else {
                this.windowCount = 0;
            }
            return sortedWindowViews;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    private void viewRemoveTreeObserver(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.removeGlobalOnLayoutListener(this.mAppPageChange);
        viewTreeObserver.removeOnWindowFocusChangeListener(this.mAppPageChange);
        viewTreeObserver.removeOnScrollChangedListener(this.mAppPageChange);
        viewTreeObserver.removeOnGlobalFocusChangeListener(this.mAppPageChange);
    }

    private void viewTreeObserver(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(this.mAppPageChange);
        viewTreeObserver.addOnWindowFocusChangeListener(this.mAppPageChange);
        viewTreeObserver.addOnScrollChangedListener(this.mAppPageChange);
        viewTreeObserver.addOnGlobalFocusChangeListener(this.mAppPageChange);
    }

    private void viewsAddTreeObserver(Activity activity) {
        SALog.i("SA.ExposedTransform", "viewsAddTreeObserver:" + this.isMonitor);
        if (!this.isMonitor && this.mCallBack.getExposureViewSize(activity) > 0) {
            processViews();
            View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
            View decorView = activity.getWindow().getDecorView();
            if (sortedWindowViews == null || sortedWindowViews.length <= 0) {
                viewTreeObserver(activity.getWindow().getDecorView());
            } else {
                boolean z10 = true;
                for (View view : sortedWindowViews) {
                    if (decorView == view) {
                        z10 = false;
                    }
                    viewTreeObserver(view);
                }
                if (z10) {
                    viewTreeObserver(decorView);
                }
            }
            this.isMonitor = true;
        }
    }

    private void viewsRemoveTreeObserver(Activity activity, View[] viewArr) {
        SALog.i("SA.ExposedTransform", "viewsRemoveTreeObserver:" + this.isMonitor);
        if (this.isMonitor) {
            this.isMonitor = false;
            if (viewArr == null) {
                viewArr = WindowHelper.getSortedWindowViews();
            }
            if (viewArr == null || viewArr.length <= 0) {
                viewRemoveTreeObserver(activity.getWindow().getDecorView());
                return;
            }
            for (View viewRemoveTreeObserver : viewArr) {
                viewRemoveTreeObserver(viewRemoveTreeObserver);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void observerWindow(android.app.Activity r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.windowCount     // Catch:{ all -> 0x0033 }
            android.view.View[] r1 = r5.processViews()     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = "SA.ExposedTransform"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r3.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "originWindowCount:"
            r3.append(r4)     // Catch:{ all -> 0x0033 }
            r3.append(r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = ",windowCount:"
            r3.append(r4)     // Catch:{ all -> 0x0033 }
            int r4 = r5.windowCount     // Catch:{ all -> 0x0033 }
            r3.append(r4)     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0033 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0033 }
            int r2 = r5.windowCount     // Catch:{ all -> 0x0033 }
            if (r0 == r2) goto L_0x0035
            r5.viewsRemoveTreeObserver(r6, r1)     // Catch:{ all -> 0x0033 }
            r5.onActivityResumed(r6)     // Catch:{ all -> 0x0033 }
            monitor-exit(r5)
            return
        L_0x0033:
            r6 = move-exception
            goto L_0x003e
        L_0x0035:
            boolean r0 = r5.isMonitor     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x003c
            r5.onActivityResumed(r6)     // Catch:{ all -> 0x0033 }
        L_0x003c:
            monitor-exit(r5)
            return
        L_0x003e:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.observerWindow(android.app.Activity):void");
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.mActivityWeakReference = new WeakReference<>(activity);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        SALog.i("SA.ExposedTransform", "onActivityPaused");
        synchronized (this) {
            viewsRemoveTreeObserver(activity, (View[]) null);
            this.mCallBack.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.isResumedLayoutChanged = true;
        SALog.i("SA.ExposedTransform", "onActivityResumed:" + activity);
        synchronized (this) {
            viewsAddTreeObserver(activity);
            this.mCallBack.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }
}

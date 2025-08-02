package com.sensorsdata.analytics.android.sdk.exposure;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class SAExposedProcess {
    private static final long DELAY_TIME = 500;
    private static final String TAG = "SA.SAExposedProcess";
    /* access modifiers changed from: private */
    public boolean isActivityChange;
    private CallBack mCallBack;
    /* access modifiers changed from: private */
    public WeakHashMap<Activity, ExposedPage> mExposedPageWeakHashMap;
    private ExposedTransform mExposedTransform;
    /* access modifiers changed from: private */
    public final SAExposureConfig mExposureConfig;
    /* access modifiers changed from: private */
    public ExposureRunnable mExposureRunnable;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public String mLastActivityUrl = "";
    /* access modifiers changed from: private */
    public WeakHashMap<ExposureView, StayDurationRunnable> mStayDurationRunnableWeakHashMap;

    interface CallBack {
        int getExposureViewSize(Activity activity);

        Collection<ExposureView> getExposureViews(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void viewLayoutChange(Activity activity);
    }

    class ExposureRunnable implements Runnable {
        private final ExposedPage mExposedPage;
        private final View mView;

        public ExposureRunnable(ExposedPage exposedPage, View view) {
            this.mExposedPage = exposedPage;
            this.mView = view;
        }

        public void run() {
            try {
                for (ExposureView next : this.mExposedPage.getExposureViewList(this.mView)) {
                    if (next.getView() != null && next.isViewLayoutChange()) {
                        synchronized (SAExposedProcess.class) {
                            StayDurationRunnable stayDurationRunnable = (StayDurationRunnable) SAExposedProcess.this.mStayDurationRunnableWeakHashMap.get(next);
                            if (stayDurationRunnable != null) {
                                SAExposedProcess.this.mHandler.removeCallbacks(stayDurationRunnable);
                                SAExposedProcess.this.mStayDurationRunnableWeakHashMap.remove(next);
                            }
                            SALog.i(SAExposedProcess.TAG, "ExposureRunnable->exposureView:" + next);
                            SAExposureData exposureData = next.getExposureData();
                            if (exposureData != null) {
                                StayDurationRunnable stayDurationRunnable2 = new StayDurationRunnable(next);
                                SAExposedProcess.this.mStayDurationRunnableWeakHashMap.put(next, stayDurationRunnable2);
                                SAExposedProcess.this.mHandler.postDelayed(stayDurationRunnable2, (long) (exposureData.getExposureConfig().getStayDuration() * 1000.0d));
                                next.setViewLayoutChange(false);
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SAExposedProcess(SAExposureConfig sAExposureConfig) {
        this.mExposureConfig = sAExposureConfig;
    }

    private Activity exposureProcess(View view, SAExposureData sAExposureData, boolean z10) throws Exception {
        ExposureView exposureView = null;
        if (view == null || sAExposureData == null) {
            return null;
        }
        Activity activityOfView = SAViewUtils.getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null) {
            return null;
        }
        init();
        ExposedPage exposedPage = this.mExposedPageWeakHashMap.get(activityOfView);
        if (exposedPage == null) {
            exposedPage = new ExposedPage();
            this.mExposedPageWeakHashMap.put(activityOfView, exposedPage);
        }
        if (z10 && sAExposureData.getExposureConfig() == null) {
            sAExposureData.setExposureConfig(this.mExposureConfig);
        }
        String identifier = sAExposureData.getIdentifier();
        if (!TextUtils.isEmpty(identifier)) {
            ExposureView exposureView2 = exposedPage.getExposureView(identifier);
            ExposureView exposureView3 = exposedPage.getExposureView(view);
            if (!(exposureView3 == null || exposureView3.getExposureData() == null || exposureView3.getExposureData().getIdentifier() == null || exposureView3.getExposureData().getIdentifier().equals(sAExposureData.getIdentifier()))) {
                exposureView3.setLastVisible(false);
            }
            if (exposureView2 != null) {
                exposureView = exposureView2.clone();
                exposureView.setView(view);
                if (z10) {
                    exposureView.setExposureData(sAExposureData);
                }
            }
        } else if (exposedPage.getExposureView(view) != null) {
            exposureView = exposedPage.getExposureView(view);
            exposureView.setExposureData(sAExposureData);
        }
        if (exposureView == null) {
            exposureView = new ExposureView(sAExposureData, false, false, view);
        }
        if (z10) {
            exposureView.setAddExposureView(true);
        }
        SALog.i(TAG, "addExposureView:" + exposureView);
        exposedPage.addExposureView(view, exposureView);
        exposedPage.addExposureView(sAExposureData.getIdentifier(), exposureView);
        return activityOfView;
    }

    private synchronized void init() {
        try {
            if (this.mExposedPageWeakHashMap == null) {
                this.mExposedPageWeakHashMap = new WeakHashMap<>();
                this.mStayDurationRunnableWeakHashMap = new WeakHashMap<>();
                HandlerThread handlerThread = new HandlerThread("SA.Exposured");
                handlerThread.start();
                this.mHandler = new Handler(handlerThread.getLooper());
                AnonymousClass1 r02 = new CallBack() {
                    public int getExposureViewSize(Activity activity) {
                        ExposedPage exposedPage;
                        try {
                            if (SAExposedProcess.this.mExposedPageWeakHashMap == null || (exposedPage = (ExposedPage) SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) == null) {
                                return 0;
                            }
                            return exposedPage.getExposureViewSize();
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                            return 0;
                        }
                    }

                    public Collection<ExposureView> getExposureViews(Activity activity) {
                        ExposedPage exposedPage;
                        try {
                            if (SAExposedProcess.this.mExposedPageWeakHashMap == null || (exposedPage = (ExposedPage) SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) == null) {
                                return null;
                            }
                            return exposedPage.getExposureViews();
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                            return null;
                        }
                    }

                    public void onActivityPaused(Activity activity) {
                        try {
                            if (SAExposedProcess.this.mExposedPageWeakHashMap != null) {
                                ExposedPage exposedPage = (ExposedPage) SAExposedProcess.this.mExposedPageWeakHashMap.get(activity);
                                if (exposedPage != null) {
                                    exposedPage.invisibleElement();
                                }
                                SAExposedProcess.this.removeStayDurationRunnable();
                            }
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }

                    public void onActivityResumed(Activity activity) {
                        ExposedPage exposedPage;
                        try {
                            String canonicalName = activity.getClass().getCanonicalName();
                            SAExposedProcess sAExposedProcess = SAExposedProcess.this;
                            boolean unused = sAExposedProcess.isActivityChange = !sAExposedProcess.mLastActivityUrl.equals(canonicalName);
                            String unused2 = SAExposedProcess.this.mLastActivityUrl = canonicalName;
                            if (SAExposedProcess.this.isActivityChange && (exposedPage = (ExposedPage) SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) != null) {
                                for (ExposureView next : exposedPage.getExposureViews()) {
                                    if (next != null) {
                                        next.setActivityChange(true);
                                    }
                                }
                            }
                            viewLayoutChange(activity);
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }

                    public void viewLayoutChange(Activity activity) {
                        if (SAExposedProcess.this.mExposureRunnable != null) {
                            SAExposedProcess.this.mHandler.removeCallbacks(SAExposedProcess.this.mExposureRunnable);
                        }
                        SAExposedProcess.this.removeStayDurationRunnable();
                        ExposedPage exposedPage = (ExposedPage) SAExposedProcess.this.mExposedPageWeakHashMap.get(activity);
                        if (exposedPage != null) {
                            SAExposedProcess sAExposedProcess = SAExposedProcess.this;
                            ExposureRunnable unused = sAExposedProcess.mExposureRunnable = new ExposureRunnable(exposedPage, (View) null);
                            if (SAExposedProcess.this.mExposureConfig != null) {
                                SALog.i(SAExposedProcess.TAG, "delayTime:" + SAExposedProcess.this.mExposureConfig.getDelayTime());
                                SAExposedProcess.this.mHandler.postDelayed(SAExposedProcess.this.mExposureRunnable, SAExposedProcess.this.mExposureConfig.getDelayTime());
                                return;
                            }
                            SALog.i(SAExposedProcess.TAG, "delayTime->500ms");
                            SAExposedProcess.this.mHandler.postDelayed(SAExposedProcess.this.mExposureRunnable, SAExposedProcess.DELAY_TIME);
                        }
                    }
                };
                this.mCallBack = r02;
                this.mExposedTransform = new ExposedTransform(r02);
                SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mExposedTransform);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return;
    }

    /* access modifiers changed from: private */
    public void removeStayDurationRunnable() {
        synchronized (SAExposedProcess.class) {
            try {
                WeakHashMap<ExposureView, StayDurationRunnable> weakHashMap = this.mStayDurationRunnableWeakHashMap;
                if (weakHashMap != null) {
                    Iterator<ExposureView> it = weakHashMap.keySet().iterator();
                    while (it.hasNext()) {
                        ExposureView next = it.next();
                        if (next != null && next.isViewLayoutChange()) {
                            SALog.i(TAG, "remove ExposureView = " + next);
                            this.mHandler.removeCallbacks(this.mStayDurationRunnableWeakHashMap.get(next));
                            it.remove();
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean verifyExposureData(SAExposureData sAExposureData) {
        if (sAExposureData == null) {
            SALog.i(TAG, "SAExposureData is null");
            return false;
        } else if (TextUtils.isEmpty(sAExposureData.getEvent())) {
            SALog.i(TAG, "EventName is empty or null");
            return false;
        } else {
            SAExposureConfig exposureConfig = sAExposureData.getExposureConfig();
            if (exposureConfig == null) {
                SAExposureConfig sAExposureConfig = this.mExposureConfig;
                if (sAExposureConfig != null && (sAExposureConfig.getAreaRate() > 1.0f || this.mExposureConfig.getAreaRate() < 0.0f)) {
                    SALog.i(TAG, "Global SAExposureConfig areaRate must be 0~1");
                    sAExposureData.setExposureConfig(new SAExposureConfig(0.0f, this.mExposureConfig.getStayDuration(), this.mExposureConfig.isRepeated()));
                }
            } else if (exposureConfig.getAreaRate() > 1.0f || exposureConfig.getAreaRate() < 0.0f) {
                SALog.i(TAG, "SAExposureConfig areaRate must be 0~1");
                exposureConfig.setAreaRate(0.0f);
                return true;
            }
            return true;
        }
    }

    public void addExposureView(View view, SAExposureData sAExposureData) {
        Activity exposureProcess;
        try {
            if (verifyExposureData(sAExposureData) && (exposureProcess = exposureProcess(view, sAExposureData, true)) != null) {
                this.mCallBack.viewLayoutChange(exposureProcess);
                ExposedTransform exposedTransform = this.mExposedTransform;
                if (exposedTransform != null) {
                    exposedTransform.observerWindow(exposureProcess);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void removeExposureView(View view, String str) {
        ExposedPage exposedPage;
        if (view != null) {
            Activity activityOfView = SAViewUtils.getActivityOfView(view.getContext(), view);
            if (activityOfView == null) {
                activityOfView = AppStateTools.getInstance().getForegroundActivity();
            }
            if (activityOfView != null) {
                WeakHashMap<Activity, ExposedPage> weakHashMap = this.mExposedPageWeakHashMap;
                if (weakHashMap != null) {
                    exposedPage = weakHashMap.get(activityOfView);
                } else {
                    exposedPage = null;
                }
                if (exposedPage != null) {
                    exposedPage.removeExposureView(view, str);
                }
            }
        }
    }

    public void setExposureIdentifier(View view, String str) {
        try {
            exposureProcess(view, new SAExposureData((String) null, (JSONObject) null, str, (SAExposureConfig) null), false);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateExposureView(android.view.View r3, org.json.JSONObject r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            java.util.WeakHashMap<android.app.Activity, com.sensorsdata.analytics.android.sdk.exposure.ExposedPage> r0 = r2.mExposedPageWeakHashMap     // Catch:{ all -> 0x002f }
            android.content.Context r1 = r3.getContext()     // Catch:{ all -> 0x002f }
            android.app.Activity r1 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(r1, r3)     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x002f }
            com.sensorsdata.analytics.android.sdk.exposure.ExposedPage r0 = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) r0     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0031
            com.sensorsdata.analytics.android.sdk.exposure.ExposureView r3 = r0.getExposureView((android.view.View) r3)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x0031
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r0 = r3.getExposureData()     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0031
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData r3 = r3.getExposureData()     // Catch:{ all -> 0x002f }
            org.json.JSONObject r3 = r3.getProperties()     // Catch:{ all -> 0x002f }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r4, r3)     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            r3 = move-exception
            goto L_0x0033
        L_0x0031:
            monitor-exit(r2)
            return
        L_0x0033:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.updateExposureView(android.view.View, org.json.JSONObject):void");
    }
}

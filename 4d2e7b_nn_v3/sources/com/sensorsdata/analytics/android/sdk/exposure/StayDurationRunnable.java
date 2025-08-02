package com.sensorsdata.analytics.android.sdk.exposure;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener;
import com.sensorsdata.analytics.android.sdk.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewNode;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class StayDurationRunnable implements Runnable {
    private static final String TAG = "SA.StayDurationRunnable";
    private final ExposureView mExposureView;

    public StayDurationRunnable(ExposureView exposureView) {
        this.mExposureView = exposureView;
    }

    private void didExposure(final ExposureView exposureView) {
        try {
            final SAExposureListener exposureListener = exposureView.getExposureData().getExposureListener();
            if (exposureListener != null && Dispatcher.getInstance().getUiThreadHandler() != null) {
                Dispatcher.getInstance().getUiThreadHandler().post(new Runnable() {
                    public void run() {
                        exposureListener.didExposure(exposureView.getView(), exposureView.getExposureData());
                    }
                });
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private boolean shouldExposure(final ExposureView exposureView) {
        try {
            final SAExposureListener exposureListener = exposureView.getExposureData().getExposureListener();
            if (exposureListener == null) {
                return true;
            }
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(exposureListener.shouldExposure(exposureView.getView(), exposureView.getExposureData()));
                }
            });
            Dispatcher.getInstance().getUiThreadHandler().post(futureTask);
            if (((Boolean) futureTask.get(3000, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            SALog.i(TAG, "Exposure fail, shouldExposure is false");
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    public void run() {
        JSONObject jSONObject;
        try {
            if (shouldExposure(this.mExposureView)) {
                JSONObject properties = this.mExposureView.getExposureData().getProperties();
                if (properties == null) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(properties.toString());
                }
                View view = this.mExposureView.getView();
                if (view != null) {
                    Activity activityOfView = SAViewUtils.getActivityOfView(view.getContext(), view);
                    if (activityOfView != null) {
                        SALog.i(TAG, "activity is not null.");
                        JSONObject screenNameAndTitle = SAViewUtils.getScreenNameAndTitle(view);
                        if (screenNameAndTitle == null || TextUtils.isEmpty(screenNameAndTitle.toString())) {
                            screenNameAndTitle = SAViewUtils.buildTitleAndScreenName(activityOfView);
                        }
                        JSONUtils.mergeJSONObject(screenNameAndTitle, jSONObject);
                    }
                    SALog.i(TAG, "StayDurationRunnable:" + this.mExposureView);
                    ViewNode viewNode = ViewTreeStatusObservable.getInstance().getViewNode(view);
                    if (viewNode != null) {
                        if (!TextUtils.isEmpty(viewNode.getViewPath())) {
                            jSONObject.put(VisualConstants.ELEMENT_PATH, viewNode.getViewPath());
                        }
                        if (!TextUtils.isEmpty(viewNode.getViewPosition())) {
                            jSONObject.put(VisualConstants.ELEMENT_POSITION, viewNode.getViewPosition());
                        }
                    }
                    String viewContent = SAViewUtils.getViewContent(view);
                    if (!TextUtils.isEmpty(viewContent)) {
                        jSONObject.put(AutoTrackConstants.ELEMENT_CONTENT, viewContent);
                    }
                    jSONObject.put(AutoTrackConstants.ELEMENT_TYPE, SAViewUtils.getViewType(view));
                    SensorsDataAPI.sharedInstance().track(this.mExposureView.getExposureData().getEvent(), jSONObject);
                    didExposure(this.mExposureView);
                    this.mExposureView.setLastVisible(true);
                    this.mExposureView.setExposed(true);
                    this.mExposureView.setActivityChange(false);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}

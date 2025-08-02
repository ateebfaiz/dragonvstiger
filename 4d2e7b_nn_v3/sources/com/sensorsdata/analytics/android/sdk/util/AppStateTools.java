package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppStateTools implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private static final String TAG = "AppStateTools";
    private int mActivityCount;
    private final List<AppState> mAppStateList;
    private String mCurrentFragmentName;
    private int mCurrentRootWindowsHashCode;
    private WeakReference<Activity> mForeGroundActivity;

    public interface AppState {
        void onBackground();

        void onForeground();
    }

    private static class SingleHolder {
        /* access modifiers changed from: private */
        public static final AppStateTools mSingleInstance = new AppStateTools();

        private SingleHolder() {
        }
    }

    public static AppStateTools getInstance() {
        return SingleHolder.mSingleInstance;
    }

    private void setForegroundActivity(Activity activity) {
        this.mForeGroundActivity = new WeakReference<>(activity);
    }

    public void addAppStateListener(AppState appState) {
        this.mAppStateList.add(appState);
    }

    public void delayInit(Context context) {
        try {
            if (context instanceof Activity) {
                onActivityStarted((Activity) context);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public int getCurrentRootWindowsHashCode() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Window window;
        if (!(this.mCurrentRootWindowsHashCode != -1 || (weakReference = this.mForeGroundActivity) == null || weakReference.get() == null || (activity = this.mForeGroundActivity.get()) == null || (window = activity.getWindow()) == null || !window.isActive())) {
            this.mCurrentRootWindowsHashCode = window.getDecorView().hashCode();
        }
        return this.mCurrentRootWindowsHashCode;
    }

    public Activity getForegroundActivity() {
        return this.mForeGroundActivity.get();
    }

    public String getFragmentScreenName() {
        return this.mCurrentFragmentName;
    }

    public boolean isAppOnForeground() {
        if (this.mActivityCount != 0) {
            return true;
        }
        return false;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            setForegroundActivity(activity);
            if (!activity.isChild()) {
                this.mCurrentRootWindowsHashCode = -1;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        try {
            if (!SensorsDataDialogUtils.isSchemeActivity(activity)) {
                SensorsDataUtils.handleSchemeUrl(activity, activity.getIntent());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (!activity.isChild()) {
            this.mCurrentRootWindowsHashCode = -1;
        }
    }

    public void onActivityResumed(Activity activity) {
        setForegroundActivity(activity);
        View view = null;
        try {
            Window window = activity.getWindow();
            if (window != null) {
                view = window.getDecorView();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        if (!activity.isChild() && view != null) {
            this.mCurrentRootWindowsHashCode = view.hashCode();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int i10 = this.mActivityCount;
        this.mActivityCount = i10 + 1;
        if (i10 == 0) {
            for (AppState onForeground : this.mAppStateList) {
                try {
                    onForeground.onForeground();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        int i10 = this.mActivityCount - 1;
        this.mActivityCount = i10;
        if (i10 == 0) {
            for (AppState onBackground : this.mAppStateList) {
                try {
                    onBackground.onBackground();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
    }

    public void setFragmentScreenName(Object obj, String str) {
        try {
            if (obj.getClass().getMethod("getParentFragment", (Class[]) null).invoke(obj, (Object[]) null) == null) {
                this.mCurrentFragmentName = str;
                SALog.i(TAG, "setFragmentScreenName | " + str + " is not nested fragment and set");
                return;
            }
            SALog.i(TAG, "setFragmentScreenName | " + str + " is nested fragment and ignored");
        } catch (Exception unused) {
        }
    }

    private AppStateTools() {
        this.mForeGroundActivity = new WeakReference<>((Object) null);
        this.mCurrentFragmentName = null;
        this.mCurrentRootWindowsHashCode = -1;
        this.mActivityCount = 0;
        this.mAppStateList = new ArrayList();
    }
}

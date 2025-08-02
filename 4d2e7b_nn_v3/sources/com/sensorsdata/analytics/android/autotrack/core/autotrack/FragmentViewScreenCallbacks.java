package com.sensorsdata.analytics.android.autotrack.core.autotrack;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.sensorsdata.analytics.android.autotrack.R;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.WeakSet;
import java.util.Set;
import org.json.JSONObject;

public class FragmentViewScreenCallbacks implements SAFragmentLifecycleCallbacks {
    private static final String TAG = "SA.FragmentViewScreenCallbacks";
    private final Set<Object> mPageFragments = new WeakSet();

    private boolean isFragmentValid(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "fragment is null, return");
            return false;
        } else if (SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
            SALog.i(TAG, "AutoTrackEventTypeIgnored, return");
            return false;
        } else if (!SensorsDataAPI.sharedInstance().isTrackFragmentAppViewScreenEnabled()) {
            SALog.i(TAG, "TrackFragmentAppViewScreenEnabled is false, return");
            return false;
        } else {
            Activity activityFromFragment = SAFragmentUtils.getActivityFromFragment(obj);
            if (activityFromFragment != null && SensorsDataAPI.sharedInstance().isActivityAutoTrackAppViewScreenIgnored(activityFromFragment.getClass())) {
                SALog.i(TAG, "isActivityAutoTrackAppViewScreenIgnored is false, return");
                return false;
            } else if ("com.bumptech.glide.manager.SupportRequestManagerFragment".equals(obj.getClass().getCanonicalName())) {
                SALog.i(TAG, "fragment is SupportRequestManagerFragment,return");
                return false;
            } else if (!SensorsDataAPI.sharedInstance().isFragmentAutoTrackAppViewScreen(obj.getClass())) {
                SALog.i(TAG, "fragment class ignored,return");
                return false;
            } else if (this.mPageFragments.contains(obj)) {
                SALog.i(TAG, "pageFragment contains,return");
                return false;
            } else if (SAFragmentUtils.isFragmentVisible(obj)) {
                return true;
            } else {
                SALog.i(TAG, "fragment is not visible,return");
                return false;
            }
        }
    }

    private void trackFragmentAppViewScreen(Object obj) {
        try {
            JSONObject fragmentPageInfo = SAPageInfoUtils.getFragmentPageInfo((Activity) null, obj);
            AppStateTools.getInstance().setFragmentScreenName(obj, fragmentPageInfo.optString("$screen_name"));
            if (obj instanceof ScreenAutoTracker) {
                JSONUtils.mergeJSONObject(((ScreenAutoTracker) obj).getTrackProperties(), fragmentPageInfo);
            }
            SensorsDataAPI.sharedInstance().trackViewScreen(SAPageTools.getScreenUrl(obj), SADataHelper.appendLibMethodAutoTrack(fragmentPageInfo));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private static void traverseView(String str, ViewGroup viewGroup) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    childAt.setTag(R.id.sensors_analytics_tag_view_fragment_name, str);
                    if ((childAt instanceof ViewGroup) && !(childAt instanceof ListView) && !(childAt instanceof GridView) && !(childAt instanceof Spinner) && !(childAt instanceof RadioGroup)) {
                        traverseView(str, (ViewGroup) childAt);
                    }
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onCreate(Object obj) {
    }

    public void onHiddenChanged(Object obj, boolean z10) {
        if (obj == null) {
            try {
                SALog.i(TAG, "fragment is null,return");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        } else if (z10) {
            this.mPageFragments.remove(obj);
            SALog.i(TAG, "fragment hidden is true,return");
        } else if (isFragmentValid(obj)) {
            trackFragmentAppViewScreen(obj);
            this.mPageFragments.add(obj);
        }
    }

    public void onPause(Object obj) {
        if (obj != null) {
            this.mPageFragments.remove(obj);
        }
    }

    public void onResume(Object obj) {
        try {
            if (isFragmentValid(obj)) {
                trackFragmentAppViewScreen(obj);
                this.mPageFragments.add(obj);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onStart(Object obj) {
    }

    public void onStop(Object obj) {
    }

    public void onViewCreated(Object obj, View view, Bundle bundle) {
        Window window;
        try {
            String name = obj.getClass().getName();
            view.setTag(R.id.sensors_analytics_tag_view_fragment_name, name);
            if (view instanceof ViewGroup) {
                traverseView(name, (ViewGroup) view);
            }
            Activity activityOfView = SAViewUtils.getActivityOfView(view.getContext(), view);
            if (!(activityOfView == null || (window = activityOfView.getWindow()) == null)) {
                window.getDecorView().getRootView().setTag(R.id.sensors_analytics_tag_view_fragment_name, "");
            }
            SAFragmentUtils.setFragmentToCache(name, obj);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void setUserVisibleHint(Object obj, boolean z10) {
        if (obj == null) {
            try {
                SALog.i(TAG, "object is null");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        } else if (!z10) {
            this.mPageFragments.remove(obj);
            SALog.i(TAG, "fragment isVisibleToUser is false,return");
        } else if (isFragmentValid(obj)) {
            trackFragmentAppViewScreen(obj);
            this.mPageFragments.add(obj);
        }
    }
}

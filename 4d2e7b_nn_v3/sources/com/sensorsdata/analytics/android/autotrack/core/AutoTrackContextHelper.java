package com.sensorsdata.analytics.android.autotrack.core;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper;
import com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.autotrack.core.autotrack.FragmentViewScreenCallbacks;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml;
import com.sensorsdata.analytics.android.autotrack.core.pageleave.ActivityPageLeaveCallbacks;
import com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks;
import com.sensorsdata.analytics.android.autotrack.core.plugins.AutoTrackEventPlugin;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import java.util.List;

public class AutoTrackContextHelper {
    private static final String TAG = "AutoTrackContextHelper";
    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private final InternalConfigOptions mInternalConfigs;
    private final AutoTrackProtocolIml mProtocolImp;
    private final SAContextManager mSAContextManager;

    public AutoTrackContextHelper(SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
        this.mProtocolImp = new AutoTrackProtocolIml(sAContextManager);
        registerListener();
        sAContextManager.getPluginManager().registerPropertyPlugin(new AutoTrackEventPlugin());
        try {
            if (sAContextManager.getInternalConfigs().context instanceof Activity) {
                delayExecution((Activity) sAContextManager.getInternalConfigs().context);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: protected */
    public void delayExecution(Activity activity) {
        ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            activityLifecycleCallbacks.onActivityCreated(activity, (Bundle) null);
            this.mActivityLifecycleCallbacks.onDelayInitStarted(activity);
        }
        if (SALog.isLogEnabled()) {
            SALog.i(TAG, "SDK init success by：" + activity.getClass().getName());
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2041176285:
                if (str.equals(Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPVIEWSCREEN_IGNORED)) {
                    c10 = 0;
                    break;
                }
                break;
            case -1758337854:
                if (str.equals(Modules.AutoTrack.METHOD_SET_VIEW_FRAGMENT_NAME)) {
                    c10 = 1;
                    break;
                }
                break;
            case -1032848920:
                if (str.equals(Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPCLICK_IGNORED)) {
                    c10 = 2;
                    break;
                }
                break;
            case -879617324:
                if (str.equals(Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK)) {
                    c10 = 3;
                    break;
                }
                break;
            case -855900378:
                if (str.equals(Modules.AutoTrack.METHOD_GET_LAST_SCREEN_TRACK_PROPERTIES)) {
                    c10 = 4;
                    break;
                }
                break;
            case -780627273:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITIES)) {
                    c10 = 5;
                    break;
                }
                break;
            case -632963972:
                if (str.equals(Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITIES)) {
                    c10 = 6;
                    break;
                }
                break;
            case -573253991:
                if (str.equals(Modules.AutoTrack.METHOD_ENABLE_AUTO_TRACK)) {
                    c10 = 7;
                    break;
                }
                break;
            case -402423012:
                if (str.equals(Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN)) {
                    c10 = 8;
                    break;
                }
                break;
            case -255560615:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITY)) {
                    c10 = 9;
                    break;
                }
                break;
            case -249863270:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENT)) {
                    c10 = 10;
                    break;
                }
                break;
            case 184800113:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_VIEW_TYPE)) {
                    c10 = 11;
                    break;
                }
                break;
            case 459453303:
                if (str.equals(Modules.AutoTrack.METHOD_TRACK_FRAGMENT_APPVIEWSCREEN)) {
                    c10 = 12;
                    break;
                }
                break;
            case 492266615:
                if (str.equals(Modules.AutoTrack.METHOD_GET_REFERRER_SCREEN_TITLE)) {
                    c10 = 13;
                    break;
                }
                break;
            case 529995791:
                if (str.equals(Modules.AutoTrack.METHOD_IS_AUTOTRACK_ENABLED)) {
                    c10 = 14;
                    break;
                }
                break;
            case 584755798:
                if (str.equals(Modules.AutoTrack.METHOD_SET_VIEW_ACTIVITY)) {
                    c10 = 15;
                    break;
                }
                break;
            case 629903034:
                if (str.equals(Modules.AutoTrack.METHOD_SET_VIEW_PROPERTIES)) {
                    c10 = 16;
                    break;
                }
                break;
            case 664765826:
                if (str.equals(Modules.AutoTrack.METHOD_SET_VIEW_ID)) {
                    c10 = 17;
                    break;
                }
                break;
            case 669731678:
                if (str.equals(Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITY)) {
                    c10 = 18;
                    break;
                }
                break;
            case 722156336:
                if (str.equals(Modules.AutoTrack.METHOD_IS_FRAGMENT_AUTOTRACK_APPVIEWSCREEN)) {
                    c10 = 19;
                    break;
                }
                break;
            case 844173337:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENTS)) {
                    c10 = 20;
                    break;
                }
                break;
            case 880636823:
                if (str.equals(Modules.AutoTrack.METHOD_IGNORE_VIEW)) {
                    c10 = 21;
                    break;
                }
                break;
            case 998210608:
                if (str.equals(Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED)) {
                    c10 = 22;
                    break;
                }
                break;
            case 1023570953:
                if (str.equals(Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENT)) {
                    c10 = 23;
                    break;
                }
                break;
            case 1371889303:
                if (str.equals(Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK)) {
                    c10 = 24;
                    break;
                }
                break;
            case 1507882935:
                if (str.equals(Modules.AutoTrack.METHOD_GET_LAST_SCREENURL)) {
                    c10 = 25;
                    break;
                }
                break;
            case 1525033920:
                if (str.equals(Modules.AutoTrack.METHOD_IS_TRACK_FRAGMENT_APPVIEWSCREEN_ENABLED)) {
                    c10 = JSONLexer.EOI;
                    break;
                }
                break;
            case 1546646393:
                if (str.equals(Modules.AutoTrack.METHOD_GET_IGNORED_VIEW_TYPE_LIST)) {
                    c10 = 27;
                    break;
                }
                break;
            case 1577777639:
                if (str.equals(Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENT)) {
                    c10 = 28;
                    break;
                }
                break;
            case 1665928586:
                if (str.equals(Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENTS)) {
                    c10 = 29;
                    break;
                }
                break;
            case 1666466668:
                if (str.equals(Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENTS)) {
                    c10 = 30;
                    break;
                }
                break;
            case 1886155136:
                if (str.equals(Modules.AutoTrack.METHOD_CLEAR_REFERRER_WHEN_APPEND)) {
                    c10 = 31;
                    break;
                }
                break;
            case 2007472672:
                if (str.equals(Modules.AutoTrack.METHOD_CLEAR_LAST_SCREENURL)) {
                    c10 = ' ';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return Boolean.valueOf(this.mProtocolImp.isActivityAutoTrackAppViewScreenIgnored(objArr[0]));
            case 1:
                this.mProtocolImp.setViewFragmentName(objArr[0], objArr[1]);
                return null;
            case 2:
                return Boolean.valueOf(this.mProtocolImp.isActivityAutoTrackAppClickIgnored(objArr[0]));
            case 3:
                SensorsDataAPI.AutoTrackEventType autoTrackEventType = objArr[0];
                if (autoTrackEventType instanceof SensorsDataAPI.AutoTrackEventType) {
                    this.mProtocolImp.disableAutoTrack(autoTrackEventType);
                    return null;
                }
                this.mProtocolImp.disableAutoTrack((List<SensorsDataAPI.AutoTrackEventType>) (List) autoTrackEventType);
                return null;
            case 4:
                return this.mProtocolImp.getLastScreenTrackProperties();
            case 5:
                this.mProtocolImp.ignoreAutoTrackActivities(objArr[0]);
                return null;
            case 6:
                this.mProtocolImp.resumeAutoTrackActivities(objArr[0]);
                return null;
            case 7:
                this.mProtocolImp.enableAutoTrack((List<SensorsDataAPI.AutoTrackEventType>) objArr[0]);
                return null;
            case 8:
                if (objArr.length == 1) {
                    Activity activity = objArr[0];
                    if (activity instanceof Activity) {
                        this.mProtocolImp.trackViewScreen(activity);
                        return null;
                    }
                    this.mProtocolImp.trackViewScreen((Object) activity);
                    return null;
                }
                this.mProtocolImp.trackViewScreen(objArr[0], objArr[1]);
                return null;
            case 9:
                this.mProtocolImp.ignoreAutoTrackActivity(objArr[0]);
                return null;
            case 10:
                this.mProtocolImp.ignoreAutoTrackFragment(objArr[0]);
                return null;
            case 11:
                this.mProtocolImp.ignoreViewType(objArr[0]);
                return null;
            case 12:
                this.mProtocolImp.trackFragmentAppViewScreen();
                return null;
            case 13:
                return SAPageTools.getReferrerTitle();
            case 14:
                return Boolean.valueOf(this.mProtocolImp.isAutoTrackEnabled());
            case 15:
                this.mProtocolImp.setViewActivity(objArr[0], objArr[1]);
                return null;
            case 16:
                this.mProtocolImp.setViewProperties(objArr[0], objArr[1]);
                return null;
            case 17:
                View view = objArr[0];
                if (view instanceof View) {
                    this.mProtocolImp.setViewID(view, objArr[1]);
                    return null;
                } else if (view instanceof Dialog) {
                    this.mProtocolImp.setViewID((Dialog) view, objArr[1]);
                    return null;
                } else {
                    this.mProtocolImp.setViewID((Object) view, objArr[1]);
                    return null;
                }
            case 18:
                this.mProtocolImp.resumeAutoTrackActivity(objArr[0]);
                return null;
            case 19:
                return Boolean.valueOf(this.mProtocolImp.isFragmentAutoTrackAppViewScreen(objArr[0]));
            case 20:
                this.mProtocolImp.ignoreAutoTrackFragments(objArr[0]);
                return null;
            case 21:
                if (objArr.length == 1) {
                    this.mProtocolImp.ignoreView(objArr[0]);
                    return null;
                }
                this.mProtocolImp.ignoreView(objArr[0], objArr[1].booleanValue());
                return null;
            case 22:
                Integer num = objArr[0];
                if (num instanceof Integer) {
                    return Boolean.valueOf(this.mProtocolImp.isAutoTrackEventTypeIgnored(num.intValue()));
                }
                return Boolean.valueOf(this.mProtocolImp.isAutoTrackEventTypeIgnored((SensorsDataAPI.AutoTrackEventType) num));
            case 23:
                this.mProtocolImp.enableAutoTrackFragment(objArr[0]);
                return null;
            case 24:
                if (objArr.length == 1) {
                    this.mProtocolImp.trackViewAppClick(objArr[0]);
                    return null;
                }
                this.mProtocolImp.trackViewAppClick(objArr[0], objArr[1]);
                return null;
            case 25:
                return this.mProtocolImp.getLastScreenUrl();
            case 26:
                return Boolean.valueOf(this.mProtocolImp.isTrackFragmentAppViewScreenEnabled());
            case 27:
                return this.mProtocolImp.getIgnoredViewTypeList();
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                this.mProtocolImp.resumeIgnoredAutoTrackFragment(objArr[0]);
                return null;
            case 29:
                this.mProtocolImp.enableAutoTrackFragments(objArr[0]);
                return null;
            case 30:
                this.mProtocolImp.resumeIgnoredAutoTrackFragments(objArr[0]);
                return null;
            case 31:
                this.mProtocolImp.clearReferrerWhenAppEnd();
                return null;
            case ' ':
                this.mProtocolImp.clearLastScreenUrl();
                return null;
            default:
                return null;
        }
    }

    public void registerListener() {
        this.mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks(this.mSAContextManager);
        SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mActivityLifecycleCallbacks);
        SensorsDataExceptionHandler.addExceptionListener(this.mActivityLifecycleCallbacks);
        FragmentTrackHelper.addFragmentCallbacks(new FragmentViewScreenCallbacks());
        if (this.mInternalConfigs.saConfigOptions.isTrackPageLeave()) {
            ActivityPageLeaveCallbacks activityPageLeaveCallbacks = new ActivityPageLeaveCallbacks(this.mInternalConfigs.saConfigOptions.getIgnorePageLeave());
            SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(activityPageLeaveCallbacks);
            SensorsDataExceptionHandler.addExceptionListener(activityPageLeaveCallbacks);
            if (this.mInternalConfigs.saConfigOptions.isTrackFragmentPageLeave()) {
                FragmentPageLeaveCallbacks fragmentPageLeaveCallbacks = new FragmentPageLeaveCallbacks(this.mInternalConfigs.saConfigOptions.getIgnorePageLeave());
                FragmentTrackHelper.addFragmentCallbacks(fragmentPageLeaveCallbacks);
                SensorsDataExceptionHandler.addExceptionListener(fragmentPageLeaveCallbacks);
            }
        }
    }
}

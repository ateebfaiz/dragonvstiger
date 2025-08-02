package com.sensorsdata.analytics.android.autotrack.aop;

import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.ThreadUtils;

public class SensorsDataAutoTrackHelper {
    private static final String TAG = "SA.SensorsDataAutoTrackHelper";

    public static void track(String str, String str2) {
        AppClickTrackImpl.track(SensorsDataAPI.sharedInstance(), str, str2);
    }

    public static void trackDialog(DialogInterface dialogInterface, int i10) {
        AppClickTrackImpl.trackDialog(SensorsDataAPI.sharedInstance(), dialogInterface, i10);
    }

    public static void trackDrawerClosed(View view) {
        AppClickTrackImpl.trackDrawerClosed(SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackDrawerOpened(View view) {
        AppClickTrackImpl.trackDrawerOpened(SensorsDataAPI.sharedInstance(), view);
    }

    public static void trackExpandableListViewOnChildClick(ExpandableListView expandableListView, View view, int i10, int i11) {
        AppClickTrackImpl.trackExpandableListViewOnChildClick(SensorsDataAPI.sharedInstance(), expandableListView, view, i10, i11);
    }

    public static void trackExpandableListViewOnGroupClick(ExpandableListView expandableListView, View view, int i10) {
        AppClickTrackImpl.trackExpandableListViewOnGroupClick(SensorsDataAPI.sharedInstance(), expandableListView, view, i10);
    }

    public static void trackListView(AdapterView<?> adapterView, View view, int i10) {
        AppClickTrackImpl.trackListView(SensorsDataAPI.sharedInstance(), adapterView, view, i10);
    }

    public static void trackMenuItem(MenuItem menuItem) {
        trackMenuItem((Object) null, menuItem);
    }

    public static void trackRN(Object obj, int i10, int i11, boolean z10) {
    }

    public static void trackRadioGroup(RadioGroup radioGroup, int i10) {
        AppClickTrackImpl.trackRadioGroup(SensorsDataAPI.sharedInstance(), radioGroup, i10);
    }

    public static void trackTabHost(final String str) {
        try {
            ThreadUtils.getSinglePool().execute(new Runnable() {
                public void run() {
                    AppClickTrackImpl.trackTabHost(SensorsDataAPI.sharedInstance(), str);
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void trackTabLayoutSelected(Object obj, Object obj2) {
        AppClickTrackImpl.trackTabLayoutSelected(SensorsDataAPI.sharedInstance(), obj, obj2);
    }

    public static void trackViewOnClick(View view) {
        if (view != null) {
            trackViewOnClick(view, view.isPressed());
        }
    }

    public static void trackMenuItem(final Object obj, final MenuItem menuItem) {
        try {
            ThreadUtils.getSinglePool().execute(new Runnable() {
                public void run() {
                    AppClickTrackImpl.trackMenuItem(SensorsDataAPI.sharedInstance(), obj, menuItem);
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void trackViewOnClick(View view, boolean z10) {
        AppClickTrackImpl.trackViewOnClick(SensorsDataAPI.sharedInstance(), view, z10);
    }
}

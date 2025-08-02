package com.sensorsdata.analytics.android.autotrack.core.autotrack;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import com.google.android.material.tabs.TabLayout;
import com.sensorsdata.analytics.android.autotrack.R;
import com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants;
import com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.autotrack.utils.AopUtil;
import com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils;
import com.sensorsdata.analytics.android.autotrack.utils.KeyboardViewUtil;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsAdapterViewItemTrackProperties;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsExpandableListViewItemTrackProperties;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AppClickTrackImpl {
    private static final String TAG = "AppClickTrackImpl";
    private static final HashMap<Integer, Long> eventTimestamp = new HashMap<>();

    public static JSONObject buildPageProperty(Activity activity, Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj != null) {
            JSONUtils.mergeJSONObject(SAPageInfoUtils.getFragmentPageInfo(activity, obj), jSONObject);
        } else if (activity != null) {
            JSONUtils.mergeJSONObject(SAPageInfoUtils.getActivityPageInfo(activity), jSONObject);
        }
        return jSONObject;
    }

    private static ViewContext getAppClickViewContext(View view, Class<?> cls) {
        return getAppClickViewContext((Object) null, view, cls);
    }

    private static JSONObject getExpandListViewExtendProperty(ExpandableListView expandableListView, int i10, int i11) {
        try {
            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
            if (!(expandableListAdapter instanceof SensorsExpandableListViewItemTrackProperties)) {
                return null;
            }
            SensorsExpandableListViewItemTrackProperties sensorsExpandableListViewItemTrackProperties = (SensorsExpandableListViewItemTrackProperties) expandableListAdapter;
            if (i11 == -1) {
                return sensorsExpandableListViewItemTrackProperties.getSensorsGroupItemTrackProperties(i10);
            }
            return sensorsExpandableListViewItemTrackProperties.getSensorsChildItemTrackProperties(i10, i11);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    private static boolean isAppClickIgnore(SensorsDataAPI sensorsDataAPI) {
        if (!sensorsDataAPI.isAutoTrackEnabled() || sensorsDataAPI.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK)) {
            return true;
        }
        return false;
    }

    private static boolean isDeBounceTrack(Object obj) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashMap<Integer, Long> hashMap = eventTimestamp;
        Long l10 = hashMap.get(Integer.valueOf(obj.hashCode()));
        if (l10 != null && elapsedRealtime - l10.longValue() < 500) {
            return true;
        }
        hashMap.put(Integer.valueOf(obj.hashCode()), Long.valueOf(elapsedRealtime));
        return false;
    }

    public static void track(final SensorsDataAPI sensorsDataAPI, final String str, String str2) {
        final JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                    SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                        public void run() {
                            sensorsDataAPI.getSAContextManager().trackEvent(new InputData().setEventName(str).setProperties(jSONObject).setEventType(EventType.TRACK));
                        }
                    });
                }
                jSONObject = null;
                SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                    public void run() {
                        sensorsDataAPI.getSAContextManager().trackEvent(new InputData().setEventName(str).setProperties(jSONObject).setEventType(EventType.TRACK));
                    }
                });
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private static void trackAutoEvent(final SensorsDataAPI sensorsDataAPI, final JSONObject jSONObject, final View view) {
        final JSONObject appendLibMethodAutoTrack = SADataHelper.appendLibMethodAutoTrack(jSONObject);
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                if (view != null) {
                    SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_MERGE_VISUAL_PROPERTIES, jSONObject, view);
                }
                sensorsDataAPI.getSAContextManager().trackEvent(new InputData().setEventName("$AppClick").setEventType(EventType.TRACK).setProperties(appendLibMethodAutoTrack));
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:24|(3:25|26|(2:30|(1:32)))|36|37|38|39|40|(1:44)(8:45|46|47|(3:49|50|(2:52|(1:54))(5:55|(3:57|(1:61)|62)|84|85|94))(5:63|(3:65|66|(3:70|71|(1:73))(3:75|76|(3:78|(1:82)|83)))|84|85|94)|74|84|85|94)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:45|46|47|(3:49|50|(2:52|(1:54))(5:55|(3:57|(1:61)|62)|84|85|94))(5:63|(3:65|66|(3:70|71|(1:73))(3:75|76|(3:78|(1:82)|83)))|84|85|94)|74|84|85|94) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0134 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackDialog(com.sensorsdata.analytics.android.sdk.SensorsDataAPI r9, android.content.DialogInterface r10, int r11) {
        /*
            r0 = 0
            r1 = 1
            java.lang.Class<androidx.appcompat.app.AlertDialog> r2 = androidx.appcompat.app.AlertDialog.class
            boolean r3 = isAppClickIgnore(r9)     // Catch:{ Exception -> 0x0021 }
            if (r3 != 0) goto L_0x0138
            java.lang.Class<android.app.Dialog> r3 = android.app.Dialog.class
            boolean r3 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewIgnored((java.lang.Class<?>) r3)     // Catch:{ Exception -> 0x0021 }
            if (r3 == 0) goto L_0x0014
            goto L_0x0138
        L_0x0014:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            r3.<init>()     // Catch:{ Exception -> 0x0021 }
            boolean r4 = r10 instanceof android.app.Dialog     // Catch:{ Exception -> 0x0021 }
            r5 = 0
            if (r4 == 0) goto L_0x0024
            android.app.Dialog r10 = (android.app.Dialog) r10     // Catch:{ Exception -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r9 = move-exception
            goto L_0x0139
        L_0x0024:
            r10 = r5
        L_0x0025:
            if (r10 == 0) goto L_0x0138
            boolean r4 = isDeBounceTrack(r10)     // Catch:{ Exception -> 0x0021 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0138
        L_0x002f:
            android.content.Context r4 = r10.getContext()     // Catch:{ Exception -> 0x0021 }
            android.app.Activity r4 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(r4, r5)     // Catch:{ Exception -> 0x0021 }
            if (r4 != 0) goto L_0x003d
            android.app.Activity r4 = r10.getOwnerActivity()     // Catch:{ Exception -> 0x0021 }
        L_0x003d:
            if (r4 == 0) goto L_0x0138
            java.lang.Class r6 = r4.getClass()     // Catch:{ Exception -> 0x0021 }
            boolean r6 = r9.isActivityAutoTrackAppClickIgnored(r6)     // Catch:{ Exception -> 0x0021 }
            if (r6 == 0) goto L_0x004b
            goto L_0x0138
        L_0x004b:
            org.json.JSONObject r4 = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(r4)     // Catch:{ Exception -> 0x0021 }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r4, r3)     // Catch:{ Exception -> 0x0021 }
            android.view.Window r4 = r10.getWindow()     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x007e
            boolean r4 = r4.isActive()     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x007e
            android.view.Window r4 = r10.getWindow()     // Catch:{ Exception -> 0x007a }
            android.view.View r4 = r4.getDecorView()     // Catch:{ Exception -> 0x007a }
            int r6 = com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id     // Catch:{ Exception -> 0x007a }
            java.lang.Object r4 = r4.getTag(r6)     // Catch:{ Exception -> 0x007a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x007a }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x007a }
            if (r6 != 0) goto L_0x007e
            java.lang.String r6 = "$element_id"
            r3.put(r6, r4)     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ Exception -> 0x0021 }
        L_0x007e:
            org.json.JSONObject r4 = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getRNPageInfo()     // Catch:{ Exception -> 0x0021 }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDuplicateProperty(r4, r3)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r4 = "$element_type"
            java.lang.String r6 = "Dialog"
            r3.put(r4, r6)     // Catch:{ Exception -> 0x0021 }
            int r4 = androidx.appcompat.app.AlertDialog.f13887a     // Catch:{ Exception -> 0x008f }
            goto L_0x0093
        L_0x008f:
            int r4 = androidx.appcompat.app.AlertDialog.f13887a     // Catch:{ Exception -> 0x0092 }
            goto L_0x0093
        L_0x0092:
            r2 = r5
        L_0x0093:
            if (r2 != 0) goto L_0x0096
            return
        L_0x0096:
            boolean r4 = r10 instanceof android.app.AlertDialog     // Catch:{ Exception -> 0x0021 }
            java.lang.String r6 = "$element_content"
            if (r4 == 0) goto L_0x00d2
            android.app.AlertDialog r10 = (android.app.AlertDialog) r10     // Catch:{ Exception -> 0x0021 }
            android.widget.Button r0 = r10.getButton(r11)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x00b6
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0021 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0021 }
            if (r10 != 0) goto L_0x010b
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0021 }
            r3.put(r6, r10)     // Catch:{ Exception -> 0x0021 }
            goto L_0x010b
        L_0x00b6:
            android.widget.ListView r10 = r10.getListView()     // Catch:{ Exception -> 0x0021 }
            if (r10 == 0) goto L_0x0134
            android.widget.ListAdapter r0 = r10.getAdapter()     // Catch:{ Exception -> 0x0021 }
            java.lang.Object r0 = r0.getItem(r11)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x00cd
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0021 }
            if (r1 == 0) goto L_0x00cd
            r3.put(r6, r0)     // Catch:{ Exception -> 0x0021 }
        L_0x00cd:
            android.view.View r5 = r10.getChildAt(r11)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0134
        L_0x00d2:
            boolean r2 = r2.isInstance(r10)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0134
            java.lang.Class r2 = r10.getClass()     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r4 = "getButton"
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00f7 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00f7 }
            r7[r0] = r8     // Catch:{ Exception -> 0x00f7 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r7)     // Catch:{ Exception -> 0x00f7 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x00f7 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00f7 }
            r1[r0] = r4     // Catch:{ Exception -> 0x00f7 }
            java.lang.Object r0 = r2.invoke(r10, r1)     // Catch:{ Exception -> 0x00f7 }
            android.widget.Button r0 = (android.widget.Button) r0     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00f8
        L_0x00f7:
            r0 = r5
        L_0x00f8:
            if (r0 == 0) goto L_0x010d
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0021 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0021 }
            if (r10 != 0) goto L_0x010b
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0021 }
            r3.put(r6, r10)     // Catch:{ Exception -> 0x0021 }
        L_0x010b:
            r5 = r0
            goto L_0x0134
        L_0x010d:
            java.lang.Class r0 = r10.getClass()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r1 = "getListView"
            java.lang.reflect.Method r0 = r0.getMethod(r1, r5)     // Catch:{ Exception -> 0x0134 }
            java.lang.Object r10 = r0.invoke(r10, r5)     // Catch:{ Exception -> 0x0134 }
            android.widget.ListView r10 = (android.widget.ListView) r10     // Catch:{ Exception -> 0x0134 }
            if (r10 == 0) goto L_0x0134
            android.widget.ListAdapter r0 = r10.getAdapter()     // Catch:{ Exception -> 0x0134 }
            java.lang.Object r0 = r0.getItem(r11)     // Catch:{ Exception -> 0x0134 }
            if (r0 == 0) goto L_0x0130
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0134 }
            if (r1 == 0) goto L_0x0130
            r3.put(r6, r0)     // Catch:{ Exception -> 0x0134 }
        L_0x0130:
            android.view.View r5 = r10.getChildAt(r11)     // Catch:{ Exception -> 0x0134 }
        L_0x0134:
            trackAutoEvent(r9, r3, r5)     // Catch:{ Exception -> 0x0021 }
            goto L_0x013c
        L_0x0138:
            return
        L_0x0139:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.autotrack.AppClickTrackImpl.trackDialog(com.sensorsdata.analytics.android.sdk.SensorsDataAPI, android.content.DialogInterface, int):void");
    }

    public static void trackDrawerClosed(SensorsDataAPI sensorsDataAPI, View view) {
        if (view != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AutoTrackConstants.ELEMENT_CONTENT, "Close");
                sensorsDataAPI.setViewProperties(view, jSONObject);
                trackViewOnClick(sensorsDataAPI, view, view.isPressed());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void trackDrawerOpened(SensorsDataAPI sensorsDataAPI, View view) {
        if (view != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AutoTrackConstants.ELEMENT_CONTENT, "Open");
                sensorsDataAPI.setViewProperties(view, jSONObject);
                trackViewOnClick(sensorsDataAPI, view, view.isPressed());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void trackExpandableListViewOnChildClick(SensorsDataAPI sensorsDataAPI, ExpandableListView expandableListView, View view, int i10, int i11) {
        String str;
        if (expandableListView != null && view != null) {
            try {
                if (SAViewUtils.isViewIgnored(view)) {
                    return;
                }
                if (!isAppClickIgnore(sensorsDataAPI)) {
                    ViewContext appClickViewContext = getAppClickViewContext(expandableListView, ExpandableListView.class);
                    if (appClickViewContext != null) {
                        JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                        String viewId = SAViewUtils.getViewId(expandableListView);
                        if (!TextUtils.isEmpty(viewId)) {
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, viewId);
                        }
                        buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, "ExpandableListView");
                        if (view instanceof ViewGroup) {
                            str = null;
                            try {
                                str = SAViewUtils.traverseView(new StringBuilder(), (ViewGroup) view);
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.substring(0, str.length() - 1);
                                }
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        } else {
                            str = SAViewUtils.getViewContent(view);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, str);
                        }
                        JSONUtils.mergeJSONObject(getExpandListViewExtendProperty(expandableListView, i10, i11), buildPageProperty);
                        JSONUtils.mergeJSONObject((JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                        trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static void trackExpandableListViewOnGroupClick(SensorsDataAPI sensorsDataAPI, ExpandableListView expandableListView, View view, int i10) {
        String str;
        if (expandableListView != null && view != null) {
            try {
                if (!isAppClickIgnore(sensorsDataAPI)) {
                    ViewContext appClickViewContext = getAppClickViewContext(expandableListView, ExpandableListView.class);
                    if (appClickViewContext != null) {
                        JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                        String viewId = SAViewUtils.getViewId(expandableListView);
                        if (!TextUtils.isEmpty(viewId)) {
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, viewId);
                        }
                        buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, "ExpandableListView");
                        if (view instanceof ViewGroup) {
                            str = null;
                            try {
                                str = SAViewUtils.traverseView(new StringBuilder(), (ViewGroup) view);
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.substring(0, str.length() - 1);
                                }
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        } else {
                            str = SAViewUtils.getViewContent(view);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, str);
                        }
                        JSONUtils.mergeJSONObject(getExpandListViewExtendProperty(expandableListView, i10, -1), buildPageProperty);
                        JSONUtils.mergeJSONObject((JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                        trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static void trackListView(SensorsDataAPI sensorsDataAPI, AdapterView<?> adapterView, View view, int i10) {
        String str;
        Class cls;
        if (view != null) {
            try {
                if (!isAppClickIgnore(sensorsDataAPI) && !SAViewUtils.isViewIgnored((View) adapterView)) {
                    if (!KeyboardViewUtil.isKeyboardView(view)) {
                        if (adapterView instanceof ListView) {
                            cls = ListView.class;
                            str = "ListView";
                        } else if (adapterView instanceof GridView) {
                            cls = GridView.class;
                            str = "GridView";
                        } else if (adapterView instanceof Spinner) {
                            cls = Spinner.class;
                            str = "Spinner";
                        } else {
                            str = "";
                            cls = null;
                        }
                        ViewContext appClickViewContext = getAppClickViewContext(adapterView, view, cls);
                        if (appClickViewContext != null) {
                            JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                            if (!TextUtils.isEmpty(str)) {
                                buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, str);
                            }
                            String viewId = SAViewUtils.getViewId(adapterView);
                            if (!TextUtils.isEmpty(viewId)) {
                                buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, viewId);
                            }
                            Object adapter = adapterView.getAdapter();
                            if (adapter instanceof HeaderViewListAdapter) {
                                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                            }
                            if (adapter instanceof SensorsAdapterViewItemTrackProperties) {
                                try {
                                    JSONUtils.mergeJSONObject(((SensorsAdapterViewItemTrackProperties) adapter).getSensorsItemTrackProperties(i10), buildPageProperty);
                                } catch (JSONException e10) {
                                    SALog.printStackTrace(e10);
                                }
                            }
                            String viewContent = SAViewUtils.getViewContent(view);
                            if (!TextUtils.isEmpty(viewContent)) {
                                buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, viewContent);
                            }
                            JSONUtils.mergeJSONObject((JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                            trackAutoEvent(sensorsDataAPI, buildPageProperty, view);
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static void trackMenuItem(SensorsDataAPI sensorsDataAPI, Object obj, MenuItem menuItem) {
        if (menuItem != null) {
            try {
                if (isDeBounceTrack(menuItem)) {
                    return;
                }
                if (!isAppClickIgnore(sensorsDataAPI)) {
                    ViewContext appClickViewContext = getAppClickViewContext(obj, WindowHelper.getClickView(menuItem), MenuItem.class);
                    if (appClickViewContext != null) {
                        JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                        try {
                            Activity activity = appClickViewContext.activity;
                            if (activity != null) {
                                String resourceEntryName = activity.getResources().getResourceEntryName(menuItem.getItemId());
                                if (!TextUtils.isEmpty(resourceEntryName)) {
                                    buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, resourceEntryName);
                                }
                            }
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                        if (menuItem.getTitle() != null) {
                            String charSequence = menuItem.getTitle().toString();
                            if (appClickViewContext.view != null && TextUtils.isEmpty(charSequence)) {
                                charSequence = SAViewUtils.getViewContent(appClickViewContext.view);
                            }
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, charSequence);
                        }
                        buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, "MenuItem");
                        trackAutoEvent(sensorsDataAPI, buildPageProperty, appClickViewContext.view);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static void trackRadioGroup(SensorsDataAPI sensorsDataAPI, RadioGroup radioGroup, int i10) {
        RadioButton radioButton;
        Exception e10;
        if (radioGroup != null) {
            try {
                if (!isAppClickIgnore(sensorsDataAPI)) {
                    View findViewById = radioGroup.findViewById(i10);
                    if (findViewById == null) {
                        return;
                    }
                    if (findViewById.isPressed()) {
                        ViewContext appClickViewContext = getAppClickViewContext(radioGroup, RadioGroup.class);
                        if (appClickViewContext != null) {
                            JSONObject buildPageProperty = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                            String viewId = SAViewUtils.getViewId(radioGroup);
                            if (!TextUtils.isEmpty(viewId)) {
                                buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, viewId);
                            }
                            buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, SAViewUtils.getViewType(findViewById));
                            RadioButton radioButton2 = null;
                            try {
                                Activity activity = appClickViewContext.activity;
                                if (activity != null) {
                                    radioButton = (RadioButton) activity.findViewById(radioGroup.getCheckedRadioButtonId());
                                    if (radioButton != null) {
                                        try {
                                            if (!TextUtils.isEmpty(radioButton.getText())) {
                                                buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, radioButton.getText().toString());
                                            }
                                        } catch (Exception e11) {
                                            e10 = e11;
                                            SALog.printStackTrace(e10);
                                            radioButton2 = radioButton;
                                            JSONUtils.mergeJSONObject((JSONObject) radioGroup.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                                            trackAutoEvent(sensorsDataAPI, buildPageProperty, radioButton2);
                                        }
                                    }
                                    radioButton2 = radioButton;
                                }
                            } catch (Exception e12) {
                                Exception exc = e12;
                                radioButton = null;
                                e10 = exc;
                                SALog.printStackTrace(e10);
                                radioButton2 = radioButton;
                                JSONUtils.mergeJSONObject((JSONObject) radioGroup.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                                trackAutoEvent(sensorsDataAPI, buildPageProperty, radioButton2);
                            }
                            JSONUtils.mergeJSONObject((JSONObject) radioGroup.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                            trackAutoEvent(sensorsDataAPI, buildPageProperty, radioButton2);
                        }
                    }
                }
            } catch (Exception e13) {
                SALog.printStackTrace(e13);
            }
        }
    }

    public static void trackTabHost(SensorsDataAPI sensorsDataAPI, String str) {
        ViewContext appClickViewContext;
        try {
            if (!isAppClickIgnore(sensorsDataAPI) && (appClickViewContext = getAppClickViewContext(AutoTrackViewUtils.getTabView(str), TabHost.class)) != null) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = buildPageProperty(appClickViewContext.activity, appClickViewContext.fragment);
                    String viewContent = SAViewUtils.getViewContent(appClickViewContext.view);
                    if (!TextUtils.isEmpty(viewContent)) {
                        str = viewContent;
                    }
                    jSONObject.put(AutoTrackConstants.ELEMENT_CONTENT, str);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put(AutoTrackConstants.ELEMENT_TYPE, "TabHost");
                trackAutoEvent(sensorsDataAPI, jSONObject, appClickViewContext.view);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void trackTabLayoutSelected(SensorsDataAPI sensorsDataAPI, Object obj, Object obj2) {
        ViewContext tabLayoutContext;
        boolean isBindViewPager;
        Activity activity;
        Class cls = TabLayout.Tab.class;
        if (obj2 != null) {
            try {
                if (isDeBounceTrack(obj2)) {
                    return;
                }
                if (!isAppClickIgnore(sensorsDataAPI)) {
                    View tabLayout = AutoTrackViewUtils.getTabLayout(obj2);
                    if (tabLayout != null && (tabLayoutContext = AutoTrackViewUtils.getTabLayoutContext(obj, tabLayout)) != null) {
                        Activity activity2 = tabLayoutContext.activity;
                        if (activity2 == null || !sensorsDataAPI.isActivityAutoTrackAppClickIgnored(activity2.getClass())) {
                            Object obj3 = tabLayoutContext.fragment;
                            if (obj3 == null || !sensorsDataAPI.isActivityAutoTrackAppClickIgnored(obj3.getClass())) {
                                JSONObject buildPageProperty = buildPageProperty(tabLayoutContext.activity, tabLayoutContext.fragment);
                                buildPageProperty.put(AutoTrackConstants.ELEMENT_TYPE, "TabLayout");
                                View view = (View) ReflectUtil.findField((Class<?>) cls, obj2, "mCustomView", "customView");
                                String tabLayoutText = AutoTrackViewUtils.getTabLayoutText(view, obj2);
                                if (tabLayoutText != null) {
                                    buildPageProperty.put(AutoTrackConstants.ELEMENT_CONTENT, tabLayoutText);
                                }
                                if (view == null || view.getId() == -1) {
                                    view = tabLayout;
                                }
                                if (!(view.getId() == -1 || (activity = tabLayoutContext.activity) == null)) {
                                    String resourceEntryName = activity.getResources().getResourceEntryName(view.getId());
                                    if (!TextUtils.isEmpty(resourceEntryName)) {
                                        buildPageProperty.put(AutoTrackConstants.ELEMENT_ID, resourceEntryName);
                                    }
                                }
                                JSONUtils.mergeJSONObject((JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties), buildPageProperty);
                                View view2 = (View) ReflectUtil.findField((Class<?>) cls, obj2, "view");
                                if (view2 == null) {
                                    view2 = (View) ReflectUtil.findField((Class<?>) cls, obj2, "mView");
                                }
                                if (view2 != null && ((isBindViewPager && !view2.isPressed()) || (!(isBindViewPager = AutoTrackViewUtils.isBindViewPager(tabLayout)) && view2.isPressed()))) {
                                    buildPageProperty.put("$referrer_title", SAPageTools.getCurrentTitle());
                                }
                                trackAutoEvent(sensorsDataAPI, buildPageProperty, view2);
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void trackViewOnClick(SensorsDataAPI sensorsDataAPI, View view, boolean z10) {
        JSONObject injectClickInfo;
        if (view != null) {
            try {
                if (!isAppClickIgnore(sensorsDataAPI) && !isDeBounceTrack(view)) {
                    if (!KeyboardViewUtil.isKeyboardView(view)) {
                        ViewContext appClickViewContext = getAppClickViewContext(view, view.getClass());
                        if (appClickViewContext != null && (injectClickInfo = AopUtil.injectClickInfo(appClickViewContext, new JSONObject(), z10)) != null) {
                            trackAutoEvent(sensorsDataAPI, injectClickInfo, view);
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private static ViewContext getAppClickViewContext(Object obj, View view, Class<?> cls) {
        if (SAViewUtils.isViewIgnored(cls)) {
            return null;
        }
        Context context = obj instanceof Context ? (Context) obj : null;
        if (view != null) {
            if (SAViewUtils.isViewIgnored(view)) {
                return null;
            }
            if (context == null && (context = view.getContext()) == null) {
                return null;
            }
        }
        Activity activityOfView = SAViewUtils.getActivityOfView(context, view);
        if (activityOfView != null && SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityOfView.getClass())) {
            return null;
        }
        Object fragmentFromView = SAFragmentUtils.getFragmentFromView(view, activityOfView);
        if (fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) {
            return new ViewContext(activityOfView, fragmentFromView, view);
        }
        return null;
    }
}

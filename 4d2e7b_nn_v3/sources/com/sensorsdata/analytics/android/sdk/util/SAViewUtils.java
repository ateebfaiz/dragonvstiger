package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class SAViewUtils {
    private static final String TAG = "SA.SAViewUtils";
    private static List<String> sOSViewPackage = new LinkedList<String>() {
        {
            add("android##widget");
            add("android##support##v7##widget");
            add("android##support##design##widget");
            add("android##support##text##emoji##widget");
            add("androidx##appcompat##widget");
            add("androidx##emoji##widget");
            add("androidx##cardview##widget");
            add("com##google##android##material");
        }
    };

    public static JSONObject buildTitleAndScreenName(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$screen_name", activity.getClass().getCanonicalName());
            String activityTitle = SensorsDataUtils.getActivityTitle(activity);
            if (!TextUtils.isEmpty(activityTitle)) {
                jSONObject.put("$title", activityTitle);
            }
            return jSONObject;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new JSONObject();
        }
    }

    private static void exceptionCollect(View view) {
        if (view != null) {
            try {
                SALog.i(TAG, "viewClass:" + view.getClass());
                SALog.i(TAG, "viewId:" + view.getId());
                ViewParent parent = view.getParent();
                if (parent != null) {
                    if (parent instanceof View) {
                        SALog.i(TAG, "viewParentClass->ID:" + ((View) parent).getId());
                    }
                } else if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                    View childAt = ((ViewGroup) view).getChildAt(0);
                    SALog.i(TAG, "childView->ID:" + childAt.getId());
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static Activity getActivityOfView(Context context, View view) {
        Object tag;
        Activity activity;
        Activity activity2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                if (context instanceof ContextWrapper) {
                    while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                }
                if (activity2 == null || view == null || (tag = view.getTag(R.id.sensors_analytics_tag_view_activity)) == null || !(tag instanceof Activity)) {
                    return activity2;
                }
                return (Activity) tag;
            }
            activity2 = activity;
            return activity2 == null ? activity2 : activity2;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public static int getChildIndex(ViewParent viewParent, View view) {
        try {
            if (!(viewParent instanceof ViewGroup)) {
                return -1;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent;
            String viewId = getViewId(view);
            String canonicalName = SnapCache.getInstance().getCanonicalName(view.getClass());
            int i10 = 0;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (Pathfinder.hasClassName(childAt, canonicalName)) {
                    String viewId2 = getViewId(childAt);
                    if ((viewId == null || viewId.equals(viewId2)) && childAt == view) {
                        return i10;
                    }
                    i10++;
                }
            }
            return -1;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return -1;
        }
    }

    public static String getElementSelector(View view) {
        View view2;
        String str;
        String selectPath = SnapCache.getInstance().getSelectPath(view);
        if (selectPath != null) {
            return selectPath;
        }
        ViewParent parent = view.getParent();
        String str2 = null;
        if (parent instanceof ViewGroup) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 != null) {
            str2 = SnapCache.getInstance().getSelectPath(view2);
        }
        String canonicalName = SnapCache.getInstance().getCanonicalName(view.getClass());
        if (view2 != null) {
            if (str2 == null) {
                str2 = getElementSelectorOrigin(view2);
                SnapCache.getInstance().setSelectPath(view2, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            if (str2 != null && !str2.equals("")) {
                sb2.append(str2);
                sb2.append(DomExceptionUtils.SEPARATOR);
            }
            int childIndex = getChildIndex(parent, view);
            sb2.append(canonicalName);
            sb2.append("[");
            sb2.append(childIndex);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = getElementSelectorOrigin(view);
        }
        SnapCache.getInstance().setSelectPath(view, str);
        return str;
    }

    private static String getElementSelectorOrigin(View view) {
        boolean z10;
        LinkedList linkedList = new LinkedList();
        do {
            ViewParent parent = view.getParent();
            linkedList.add(view.getClass().getCanonicalName() + "[" + getChildIndex(parent, view) + "]");
            z10 = parent instanceof ViewGroup;
            if (z10) {
                view = (ViewGroup) parent;
                continue;
            }
        } while (z10);
        Collections.reverse(linkedList);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 1; i10 < linkedList.size(); i10++) {
            sb2.append((String) linkedList.get(i10));
            if (i10 != linkedList.size() - 1) {
                sb2.append(DomExceptionUtils.SEPARATOR);
            }
        }
        return sb2.toString();
    }

    public static Object getMenuItemData(View view) {
        try {
            return view.getClass().getMethod("getItemData", (Class[]) null).invoke(view, (Object[]) null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static JSONObject getScreenNameAndTitle(View view) {
        if (view == null) {
            return null;
        }
        Activity activityOfView = getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null || activityOfView.getWindow() == null || !activityOfView.getWindow().isActive()) {
            return null;
        }
        Object fragmentFromView = SAFragmentUtils.getFragmentFromView(view, activityOfView);
        if (fragmentFromView != null) {
            return SAPageInfoUtils.getFragmentPageInfo(activityOfView, fragmentFromView);
        }
        JSONObject activityPageInfo = SAPageInfoUtils.getActivityPageInfo(activityOfView);
        JSONUtils.mergeDuplicateProperty(SAPageInfoUtils.getRNPageInfo(), activityPageInfo);
        return activityPageInfo;
    }

    private static String getTabLayoutContent(Object obj) {
        String str = null;
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$Tab", "com.google.android.material.tabs.TabLayout$Tab"});
            if (currentClass == null) {
                return null;
            }
            Object callMethod = ReflectUtil.callMethod(obj, "getText", new Object[0]);
            if (callMethod != null) {
                str = callMethod.toString();
            }
            View view = (View) ReflectUtil.findField(currentClass, obj, "mCustomView", "customView");
            if (view == null) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!(view instanceof ViewGroup)) {
                return getViewContent(view);
            }
            String traverseView = traverseView(sb2, (ViewGroup) view);
            if (!TextUtils.isEmpty(traverseView)) {
                return traverseView.substring(0, traverseView.length() - 1);
            }
            return traverseView;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getViewContent(View view) {
        return getViewContent(view, false);
    }

    public static String getViewGroupTypeByReflect(View view) {
        String canonicalName = SnapCache.getInstance().getCanonicalName(view.getClass());
        Class<?> classByName = ReflectUtil.getClassByName("androidx.cardview.widget.CardView");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        Class<?> classByName2 = ReflectUtil.getClassByName("androidx.cardview.widget.CardView");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        Class<?> classByName3 = ReflectUtil.getClassByName("com.google.android.material.navigation.NavigationView");
        if (classByName3 != null && classByName3.isInstance(view)) {
            return getViewType(canonicalName, "NavigationView");
        }
        Class<?> classByName4 = ReflectUtil.getClassByName("com.google.android.material.navigation.NavigationView");
        if (classByName4 == null || !classByName4.isInstance(view)) {
            return canonicalName;
        }
        return getViewType(canonicalName, "NavigationView");
    }

    public static String getViewId(View view) {
        String str = null;
        try {
            String str2 = (String) view.getTag(R.id.sensors_analytics_tag_view_id);
            try {
                if (!TextUtils.isEmpty(str2) || !isValid(view.getId())) {
                    return str2;
                }
                str = SnapCache.getInstance().getViewId(view);
                if (str == null) {
                    str = view.getContext().getResources().getResourceEntryName(view.getId());
                    SnapCache.getInstance().setViewId(view, str);
                }
                return str;
            } catch (Exception unused) {
                str = str2;
                if (SALog.isLogEnabled()) {
                    exceptionCollect(view);
                }
                return str;
            }
        } catch (Exception unused2) {
        }
    }

    public static String getViewType(View view) {
        String viewType = SnapCache.getInstance().getViewType(view);
        if (viewType == null) {
            viewType = SnapCache.getInstance().getCanonicalName(view.getClass());
            if (view instanceof CheckBox) {
                viewType = getViewType(viewType, "CheckBox");
            } else if (view instanceof RadioButton) {
                viewType = getViewType(viewType, "RadioButton");
            } else if (view instanceof ToggleButton) {
                viewType = getViewType(viewType, "ToggleButton");
            } else if (view instanceof CompoundButton) {
                viewType = getViewTypeByReflect(view);
            } else if (view instanceof Button) {
                viewType = getViewType(viewType, "Button");
            } else if (view instanceof CheckedTextView) {
                viewType = getViewType(viewType, "CheckedTextView");
            } else if (view instanceof TextView) {
                viewType = getViewType(viewType, "TextView");
            } else if (view instanceof ImageView) {
                viewType = getViewType(viewType, "ImageView");
            } else if (view instanceof RatingBar) {
                viewType = getViewType(viewType, "RatingBar");
            } else if (view instanceof SeekBar) {
                viewType = getViewType(viewType, "SeekBar");
            } else if (view instanceof Spinner) {
                viewType = getViewType(viewType, "Spinner");
            } else if (instanceOfTabView(view) != null) {
                viewType = getViewType(viewType, "TabLayout");
            } else if (instanceOfNavigationView(view)) {
                viewType = getViewType(viewType, "NavigationView");
            } else if (view instanceof ViewGroup) {
                viewType = getViewGroupTypeByReflect(view);
            }
            SnapCache.getInstance().setViewType(view, viewType);
        }
        return viewType;
    }

    public static String getViewTypeByReflect(View view) {
        String canonicalName = SnapCache.getInstance().getCanonicalName(view.getClass());
        Class<?> classByName = ReflectUtil.getClassByName("android.widget.Switch");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "Switch");
        }
        Class<?> classByName2 = ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "SwitchCompat");
        }
        Class<?> classByName3 = ReflectUtil.getClassByName("androidx.appcompat.widget.SwitchCompat");
        if (classByName3 == null || !classByName3.isInstance(view)) {
            return canonicalName;
        }
        return getViewType(canonicalName, "SwitchCompat");
    }

    public static boolean instanceOfActionMenuItem(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ActionMenuItem");
    }

    public static boolean instanceOfAndroidXListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    public static boolean instanceOfBottomNavigationItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.bottomnavigation.BottomNavigationItemView", "com.google.android.material.internal.NavigationMenuItemView");
    }

    public static boolean instanceOfNavigationView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView");
    }

    public static boolean instanceOfSupportListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    private static Object instanceOfTabView(View view) {
        if (view == null) {
            return null;
        }
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView"});
            if (currentClass != null && currentClass.isAssignableFrom(view.getClass())) {
                return ReflectUtil.findField(currentClass, (Object) view, "mTab", "tab");
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return null;
    }

    public static boolean instanceOfToolbar(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar");
    }

    private static boolean isOSViewByPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace(f.G, "##");
        for (String startsWith : sOSViewPackage) {
            if (replace.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int i10) {
        return (i10 == -1 || (-16777216 & i10) == 0 || (i10 & 16711680) == 0) ? false : true;
    }

    public static boolean isViewIgnored(View view) {
        if (view == null) {
            return true;
        }
        try {
            List<Class<?>> ignoredViewTypeList = SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList != null) {
                for (Class<?> isAssignableFrom : ignoredViewTypeList) {
                    if (isAssignableFrom.isAssignableFrom(view.getClass())) {
                        return true;
                    }
                }
            }
            return "1".equals(view.getTag(R.id.sensors_analytics_tag_view_ignored));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    public static boolean isViewSelfVisible(View view) {
        if (!(view == null || view.getWindowVisibility() == 8)) {
            if (WindowHelper.isDecorView(view.getClass())) {
                return true;
            }
            boolean localVisibleRect = view.getLocalVisibleRect(new Rect());
            if (view.getWidth() > 0 && view.getHeight() > 0 && view.getAlpha() > 0.0f && localVisibleRect) {
                if ((view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) && view.getVisibility() != 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isWeexTextView(View view) {
        if (view == null) {
            return false;
        }
        String name = view.getClass().getName();
        if (name.equals("com.taobao.weex.ui.view.WXTextView") || name.equals("org.apache.weex.ui.view.WXTextView")) {
            return true;
        }
        return false;
    }

    public static boolean isWeexView(View view) {
        if (view == null) {
            return false;
        }
        String name = view.getClass().getName();
        if (name.startsWith("com.taobao.weex.ui.view") || name.startsWith("org.apache.weex.ui.view")) {
            return true;
        }
        return false;
    }

    public static String traverseView(StringBuilder sb2, ViewGroup viewGroup) {
        if (sb2 == null) {
            try {
                sb2 = new StringBuilder();
            } catch (Throwable th) {
                SALog.i(TAG, th.getMessage());
                if (sb2 != null) {
                    return sb2.toString();
                }
                return "";
            }
        }
        if (viewGroup == null) {
            return sb2.toString();
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                if (childAt.getVisibility() == 0) {
                    if (childAt instanceof ViewGroup) {
                        traverseView(sb2, (ViewGroup) childAt);
                    } else if (!isViewIgnored(childAt)) {
                        String viewContent = getViewContent(childAt);
                        if (!TextUtils.isEmpty(viewContent)) {
                            sb2.append(viewContent);
                            sb2.append("-");
                        }
                    }
                }
            }
        }
        return sb2.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:11|(1:13)(2:14|(1:16)(2:17|(2:19|(1:21)(1:22))(3:23|24|(7:26|27|(2:31|32)|33|35|36|(1:47)(3:42|(1:44)(1:45)|46))(2:48|(1:50)(2:51|(1:53)(3:54|(2:56|(1:58))(2:59|(2:61|(1:65))(2:66|(1:68)(2:69|(1:71)(2:72|(2:74|(1:76))(2:77|(1:79)(2:80|(2:82|(4:84|85|86|(2:88|(1:90))))(3:91|92|(2:94|(1:96)(1:97))(2:98|(4:100|(1:102)(1:103)|104|(3:106|107|(1:109)))))))))))|110))))))|112|113|(1:117)|118|(1:124)|(1:126)(1:127)|128) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x01c6 */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01ef A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f1 A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getViewContent(android.view.View r5, boolean r6) {
        /*
            java.lang.String r0 = "androidx.appcompat.widget.SwitchCompat"
            java.lang.String r1 = ""
            if (r5 != 0) goto L_0x0011
            java.lang.String r5 = "SA.SAViewUtils"
            java.lang.String r6 = "getViewContent view is null"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x000e }
            return r1
        L_0x000e:
            r5 = move-exception
            goto L_0x0213
        L_0x0011:
            com.sensorsdata.analytics.android.sdk.util.SnapCache r2 = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = r2.getViewType(r5)     // Catch:{ Exception -> 0x000e }
            com.sensorsdata.analytics.android.sdk.util.SnapCache r3 = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance()     // Catch:{ Exception -> 0x000e }
            java.lang.String r3 = r3.getViewText(r5)     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0025
            if (r3 != 0) goto L_0x01fd
        L_0x0025:
            boolean r2 = r5 instanceof android.widget.CheckBox     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0032
            r0 = r5
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x0032:
            boolean r2 = r5 instanceof android.widget.RadioButton     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x003f
            r0 = r5
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x003f:
            boolean r2 = r5 instanceof android.widget.ToggleButton     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0058
            r0 = r5
            android.widget.ToggleButton r0 = (android.widget.ToggleButton) r0     // Catch:{ Exception -> 0x000e }
            boolean r2 = r0.isChecked()     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0052
            java.lang.CharSequence r0 = r0.getTextOn()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x0052:
            java.lang.CharSequence r0 = r0.getTextOff()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x0058:
            boolean r2 = r5 instanceof android.widget.CompoundButton     // Catch:{ Exception -> 0x000e }
            r3 = 0
            if (r2 == 0) goto L_0x00a1
            java.lang.Class r2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName(r0)     // Catch:{ Exception -> 0x0062 }
            goto L_0x0063
        L_0x0062:
            r2 = r3
        L_0x0063:
            if (r2 != 0) goto L_0x0069
            java.lang.Class r2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName(r0)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            r0 = r5
            android.widget.CompoundButton r0 = (android.widget.CompoundButton) r0     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x0074
            boolean r2 = r2.isInstance(r5)     // Catch:{ Exception -> 0x000e }
            if (r2 != 0) goto L_0x0078
        L_0x0074:
            boolean r2 = r5 instanceof android.widget.Switch     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x009b
        L_0x0078:
            boolean r0 = r0.isChecked()     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x0089
            java.lang.Class r0 = r5.getClass()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "getTextOn"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ Exception -> 0x000e }
            goto L_0x0093
        L_0x0089:
            java.lang.Class r0 = r5.getClass()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "getTextOff"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ Exception -> 0x000e }
        L_0x0093:
            java.lang.Object r0 = r0.invoke(r5, r3)     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x009b:
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x00a1:
            boolean r0 = r5 instanceof android.widget.Button     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x00ae
            r0 = r5
            android.widget.Button r0 = (android.widget.Button) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x00ae:
            boolean r0 = r5 instanceof android.widget.CheckedTextView     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x00bb
            r0 = r5
            android.widget.CheckedTextView r0 = (android.widget.CheckedTextView) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x00bb:
            boolean r0 = r5 instanceof android.widget.TextView     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x00da
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "androidx.appcompat.widget.AppCompatTextView"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x000e }
            java.lang.String r4 = "mPrecomputedTextFuture"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x000e }
            java.lang.Object r2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.String[]) r2, (java.lang.Object) r0, (java.lang.String[]) r4)     // Catch:{ Exception -> 0x000e }
            if (r2 != 0) goto L_0x01c5
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x00da:
            boolean r0 = r5 instanceof android.widget.ImageView     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x00fb
            r0 = r5
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r2 = r0.getContentDescription()     // Catch:{ Exception -> 0x000e }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x000e }
            if (r2 != 0) goto L_0x01c5
            boolean r2 = isWeexView(r5)     // Catch:{ Exception -> 0x000e }
            if (r2 != 0) goto L_0x01c5
            java.lang.CharSequence r0 = r0.getContentDescription()     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x00fb:
            boolean r0 = r5 instanceof android.widget.RatingBar     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x010c
            r0 = r5
            android.widget.RatingBar r0 = (android.widget.RatingBar) r0     // Catch:{ Exception -> 0x000e }
            float r0 = r0.getRating()     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x010c:
            boolean r0 = r5 instanceof android.widget.SeekBar     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x011d
            r0 = r5
            android.widget.SeekBar r0 = (android.widget.SeekBar) r0     // Catch:{ Exception -> 0x000e }
            int r0 = r0.getProgress()     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x011d:
            boolean r0 = r5 instanceof android.widget.Spinner     // Catch:{ Exception -> 0x000e }
            r2 = 0
            if (r0 == 0) goto L_0x0144
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x000e }
            r0.<init>()     // Catch:{ Exception -> 0x000e }
            r3 = r5
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = traverseView(r0, r3)     // Catch:{ Exception -> 0x000e }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x000e }
            int r0 = r0.length()     // Catch:{ Exception -> 0x000e }
            int r0 = r0 + -1
            java.lang.String r0 = r3.substring(r2, r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x0144:
            java.lang.Object r0 = instanceOfTabView(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x0150
            java.lang.String r0 = getTabLayoutContent(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x01c6
        L_0x0150:
            boolean r0 = instanceOfBottomNavigationItemView(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x017c
            java.lang.Object r0 = getMenuItemData(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x01c5
            java.lang.String r2 = "androidx.appcompat.view.menu.MenuItemImpl"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x01c5 }
            java.lang.Class r2 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(r2)     // Catch:{ Exception -> 0x01c5 }
            if (r2 == 0) goto L_0x01c5
            java.lang.String r4 = "mTitle"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x01c5 }
            java.lang.Object r0 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) r2, (java.lang.Object) r0, (java.lang.String[]) r4)     // Catch:{ Exception -> 0x01c5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01c5 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c5 }
            if (r2 != 0) goto L_0x01c5
            r3 = r0
            goto L_0x01c5
        L_0x017c:
            boolean r0 = instanceOfNavigationView(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x018e
            boolean r0 = isViewSelfVisible(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x018b
            java.lang.String r0 = "Open"
            goto L_0x01c6
        L_0x018b:
            java.lang.String r0 = "Close"
            goto L_0x01c6
        L_0x018e:
            boolean r0 = r5 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x01c5
            boolean r0 = isWeexView(r5)     // Catch:{ Exception -> 0x000e }
            if (r0 != 0) goto L_0x019d
            java.lang.CharSequence r0 = r5.getContentDescription()     // Catch:{ Exception -> 0x000e }
            goto L_0x019e
        L_0x019d:
            r0 = r3
        L_0x019e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 == 0) goto L_0x01c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c6 }
            r3.<init>()     // Catch:{ Exception -> 0x01c6 }
            r4 = r5
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4     // Catch:{ Exception -> 0x01c6 }
            java.lang.String r0 = traverseView(r3, r4)     // Catch:{ Exception -> 0x01c6 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01c6 }
            if (r3 != 0) goto L_0x01c6
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x01c6 }
            int r4 = r0.length()     // Catch:{ Exception -> 0x01c6 }
            int r4 = r4 + -1
            java.lang.String r0 = r3.substring(r2, r4)     // Catch:{ Exception -> 0x01c6 }
            goto L_0x01c6
        L_0x01c5:
            r0 = r3
        L_0x01c6:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x01d7
            boolean r2 = r5 instanceof android.widget.TextView     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x01d7
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x000e }
            java.lang.CharSequence r0 = r0.getHint()     // Catch:{ Exception -> 0x000e }
        L_0x01d7:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x01ed
            boolean r2 = isWeexView(r5)     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x01e9
            boolean r2 = isWeexTextView(r5)     // Catch:{ Exception -> 0x000e }
            if (r2 == 0) goto L_0x01ed
        L_0x01e9:
            java.lang.CharSequence r0 = r5.getContentDescription()     // Catch:{ Exception -> 0x000e }
        L_0x01ed:
            if (r0 != 0) goto L_0x01f1
            r3 = r1
            goto L_0x01f2
        L_0x01f1:
            r3 = r0
        L_0x01f2:
            com.sensorsdata.analytics.android.sdk.util.SnapCache r0 = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x000e }
            r0.setViewText(r5, r2)     // Catch:{ Exception -> 0x000e }
        L_0x01fd:
            boolean r0 = r5 instanceof android.widget.EditText     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x020b
            if (r6 == 0) goto L_0x020a
            android.widget.EditText r5 = (android.widget.EditText) r5     // Catch:{ Exception -> 0x000e }
            android.text.Editable r3 = r5.getText()     // Catch:{ Exception -> 0x000e }
            goto L_0x020b
        L_0x020a:
            r3 = r1
        L_0x020b:
            if (r3 != 0) goto L_0x020e
            r3 = r1
        L_0x020e:
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x000e }
            return r5
        L_0x0213:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(android.view.View, boolean):java.lang.String");
    }

    public static boolean isViewIgnored(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        try {
            List<Class<?>> ignoredViewTypeList = SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList.isEmpty()) {
                return false;
            }
            for (Class<?> isAssignableFrom : ignoredViewTypeList) {
                if (isAssignableFrom.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static String getViewType(String str, String str2) {
        return (TextUtils.isEmpty(str) || isOSViewByPackage(str)) ? str2 : str;
    }
}

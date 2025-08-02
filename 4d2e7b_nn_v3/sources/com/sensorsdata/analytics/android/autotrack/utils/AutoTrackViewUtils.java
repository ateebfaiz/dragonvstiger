package com.sensorsdata.analytics.android.autotrack.utils;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TabHost;
import com.google.android.material.tabs.TabLayout;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import java.lang.ref.WeakReference;
import java.util.List;

public class AutoTrackViewUtils {
    private static View findTabLayout(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            int i10 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (i10 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i10);
                if ("ViewPager".equals(childAt.getClass().getSimpleName())) {
                    View findTabLayoutView = findTabLayoutView(childAt);
                    if (findTabLayoutView != null) {
                        return findTabLayoutView;
                    }
                } else {
                    i10++;
                }
            }
        }
        if (parent.getParent() == null) {
            return null;
        }
        return findTabLayout((View) parent);
    }

    private static View findTabLayoutView(View view) {
        List list = (List) ReflectUtil.findField(view.getClass(), (Object) view, "mOnPageChangeListeners");
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (Object next : list) {
            WeakReference weakReference = (WeakReference) ReflectUtil.findField(next.getClass(), next, "tabLayoutRef");
            if (weakReference != null && weakReference.get() != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    private static View getAndroidXTabLayout(Object obj) {
        Class<TabLayout> cls = TabLayout.class;
        try {
            int i10 = TabLayout.MODE_SCROLLABLE;
            if (SAViewUtils.isViewIgnored((Class<?>) cls) || !ReflectUtil.isInstance(obj, "com.google.android.material.tabs.TabLayout$Tab")) {
                return null;
            }
            View view = (View) ReflectUtil.findField(new String[]{"com.google.android.material.tabs.TabLayout$Tab"}, obj, "parent");
            if (view != null) {
                try {
                    if (ReflectUtil.isInstance(view, "com.google.android.material.tabs.TabLayout") && SAViewUtils.isViewIgnored(view)) {
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return view;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static View getSupportTabLayout(Object obj) {
        Class<TabLayout> cls = TabLayout.class;
        try {
            int i10 = TabLayout.MODE_SCROLLABLE;
            if (SAViewUtils.isViewIgnored((Class<?>) cls) || !ReflectUtil.isInstance(obj, "com.google.android.material.tabs.TabLayout$Tab")) {
                return null;
            }
            View view = (View) ReflectUtil.findField(new String[]{"com.google.android.material.tabs.TabLayout$Tab"}, obj, "mParent", "parent");
            if (view != null) {
                try {
                    if (ReflectUtil.isInstance(view, "com.google.android.material.tabs.TabLayout") && SAViewUtils.isViewIgnored(view)) {
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return view;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static View getTabLayout(Object obj) {
        View androidXTabLayout = getAndroidXTabLayout(obj);
        if (androidXTabLayout == null) {
            return getSupportTabLayout(obj);
        }
        return androidXTabLayout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[Catch:{ Exception -> 0x000d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext getTabLayoutContext(java.lang.Object r6, android.view.View r7) {
        /*
            r0 = 0
            boolean r1 = r6 instanceof android.content.Context     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000f
            android.content.Context r6 = (android.content.Context) r6     // Catch:{ Exception -> 0x000d }
            android.app.Activity r6 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(r6, r0)     // Catch:{ Exception -> 0x000d }
        L_0x000b:
            r4 = r0
            goto L_0x0049
        L_0x000d:
            r6 = move-exception
            goto L_0x0069
        L_0x000f:
            java.lang.Class r1 = r6.getClass()     // Catch:{ Exception -> 0x000d }
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch:{ Exception -> 0x000d }
            int r2 = r1.length     // Catch:{ Exception -> 0x000d }
            r3 = 0
        L_0x0019:
            if (r3 >= r2) goto L_0x0047
            r4 = r1[r3]     // Catch:{ Exception -> 0x000d }
            r5 = 1
            r4.setAccessible(r5)     // Catch:{ Exception -> 0x000d }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x000d }
            boolean r5 = r4 instanceof android.app.Activity     // Catch:{ Exception -> 0x000d }
            if (r5 == 0) goto L_0x002d
            r6 = r4
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ Exception -> 0x000d }
            goto L_0x000b
        L_0x002d:
            boolean r5 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(r4)     // Catch:{ Exception -> 0x000d }
            if (r5 == 0) goto L_0x0035
            r6 = r0
            goto L_0x0049
        L_0x0035:
            boolean r5 = r4 instanceof android.view.View     // Catch:{ Exception -> 0x000d }
            if (r5 == 0) goto L_0x0044
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x000d }
            android.content.Context r6 = r4.getContext()     // Catch:{ Exception -> 0x000d }
            android.app.Activity r6 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(r6, r0)     // Catch:{ Exception -> 0x000d }
            goto L_0x000b
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0047:
            r6 = r0
            r4 = r6
        L_0x0049:
            if (r7 == 0) goto L_0x005b
            if (r6 != 0) goto L_0x0055
            android.content.Context r6 = r7.getContext()     // Catch:{ Exception -> 0x000d }
            android.app.Activity r6 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(r6, r0)     // Catch:{ Exception -> 0x000d }
        L_0x0055:
            if (r4 != 0) goto L_0x005b
            java.lang.Object r4 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getFragmentFromView(r7, r6)     // Catch:{ Exception -> 0x000d }
        L_0x005b:
            if (r6 != 0) goto L_0x0063
            if (r4 == 0) goto L_0x0063
            android.app.Activity r6 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(r4)     // Catch:{ Exception -> 0x000d }
        L_0x0063:
            com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext r1 = new com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext     // Catch:{ Exception -> 0x000d }
            r1.<init>(r6, r4, r7)     // Catch:{ Exception -> 0x000d }
            return r1
        L_0x0069:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.utils.AutoTrackViewUtils.getTabLayoutContext(java.lang.Object, android.view.View):com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext");
    }

    public static String getTabLayoutText(View view, Object obj) {
        Object callMethod;
        String str = null;
        if (view != null) {
            try {
                if (view instanceof ViewGroup) {
                    str = SAViewUtils.traverseView(new StringBuilder(), (ViewGroup) view);
                    if (!TextUtils.isEmpty(str)) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = SAViewUtils.getViewContent(view);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
        if (!TextUtils.isEmpty(str) || (callMethod = ReflectUtil.callMethod(obj, "getText", new Object[0])) == null) {
            return str;
        }
        return callMethod.toString();
    }

    public static View getTabView(String str) {
        View clickView = WindowHelper.getClickView(str);
        if (clickView != null) {
            View view = clickView;
            View view2 = null;
            while (view2 == null && view != null && view.getParent() != null) {
                view = (View) view.getParent();
                if (view instanceof TabHost) {
                    view2 = view;
                }
            }
            if (view2 == null || !SAViewUtils.isViewIgnored(view2)) {
                return clickView;
            }
            return null;
        }
        return clickView;
    }

    public static boolean isBindViewPager(View view) {
        if (view == null) {
            return false;
        }
        if (((View) ReflectUtil.findField(view.getClass(), (Object) view, "viewPager")) != null) {
            return true;
        }
        if (view == findTabLayout(view)) {
            return true;
        }
        return false;
    }
}

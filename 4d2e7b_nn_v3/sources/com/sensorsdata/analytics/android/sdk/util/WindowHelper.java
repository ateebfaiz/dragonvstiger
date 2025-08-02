package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TabHost;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WindowHelper {
    private static boolean sArrayListWindowViews = false;
    private static final String sCustomWindowPrefix = "/CustomWindow";
    private static final String sDialogWindowPrefix = "/DialogWindow";
    private static boolean sIsInitialized = false;
    private static Method sItemViewGetDataMethod = null;
    private static Class<?> sListMenuItemViewClazz = null;
    private static final String sMainWindowPrefix = "/MainWindow";
    private static Class sPhoneWindowClazz = null;
    private static Class sPopupWindowClazz = null;
    private static final String sPopupWindowPrefix = "/PopupWindow";
    private static boolean sViewArrayWindowViews;
    private static Comparator<View> sViewSizeComparator = new Comparator<View>() {
        public int compare(View view, View view2) {
            int hashCode = view.hashCode();
            int hashCode2 = view2.hashCode();
            int currentRootWindowsHashCode = AppStateTools.getInstance().getCurrentRootWindowsHashCode();
            if (hashCode == currentRootWindowsHashCode) {
                return -1;
            }
            if (hashCode2 == currentRootWindowsHashCode) {
                return 1;
            }
            return (view2.getWidth() * view2.getHeight()) - (view.getWidth() * view.getHeight());
        }
    };
    private static Object sWindowManger;
    private static Field viewsField;

    private static View[] filterNullAndDismissToastView(View[] viewArr) {
        ArrayList arrayList = new ArrayList(viewArr.length);
        System.currentTimeMillis();
        for (View view : viewArr) {
            if (view != null) {
                arrayList.add(view);
            }
        }
        View[] viewArr2 = new View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    private static View findMenuItemView(View view, MenuItem menuItem) throws InvocationTargetException, IllegalAccessException {
        View view2;
        if ((SAViewUtils.instanceOfActionMenuItem(menuItem) && menuItem.getItemId() == 16908332 && SAViewUtils.instanceOfToolbar(view.getParent()) && (view instanceof ImageButton) && (view2 = (View) ReflectUtil.findField(new String[]{"androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar"}, (Object) view.getParent(), "mNavButtonView")) != null && view2 == view) || getMenuItemData(view) == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i10 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i10 >= viewGroup.getChildCount()) {
                return null;
            }
            View findMenuItemView = findMenuItemView(viewGroup.getChildAt(i10), menuItem);
            if (findMenuItemView != null) {
                return findMenuItemView;
            }
            i10++;
        }
    }

    private static View findTabView(View view, String str) {
        int i10 = 0;
        if (TextUtils.equals(str, getTabHostTag(view))) {
            return (View) ReflectUtil.callMethod(view, "getCurrentTabView", new Object[0]);
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i10 >= viewGroup.getChildCount()) {
                return null;
            }
            View findTabView = findTabView(viewGroup.getChildAt(i10), str);
            if (findTabView != null) {
                return findTabView;
            }
            i10++;
        }
    }

    public static View getClickView(MenuItem menuItem) {
        View findMenuItemView;
        View findMenuItemView2;
        if (menuItem == null) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        try {
            for (View view : windowViews) {
                if (view.getClass() == sPopupWindowClazz && (findMenuItemView2 = findMenuItemView(view, menuItem)) != null) {
                    return findMenuItemView2;
                }
            }
            for (View view2 : windowViews) {
                if (view2.getClass() != sPopupWindowClazz && (findMenuItemView = findMenuItemView(view2, menuItem)) != null) {
                    return findMenuItemView;
                }
            }
        } catch (Exception | IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    public static String getMainWindowPrefix() {
        return sMainWindowPrefix;
    }

    @SuppressLint({"RestrictedApi"})
    private static Object getMenuItemData(View view) throws InvocationTargetException, IllegalAccessException {
        if (view.getClass() == sListMenuItemViewClazz) {
            return sItemViewGetDataMethod.invoke(view, (Object[]) null);
        }
        if (SAViewUtils.instanceOfAndroidXListMenuItemView(view) || SAViewUtils.instanceOfSupportListMenuItemView(view) || SAViewUtils.instanceOfBottomNavigationItemView(view)) {
            return SAViewUtils.getMenuItemData(view);
        }
        return null;
    }

    public static View[] getSortedWindowViews() {
        View[] windowViews = getWindowViews();
        if (windowViews.length <= 1) {
            return windowViews;
        }
        View[] viewArr = (View[]) Arrays.copyOf(windowViews, windowViews.length);
        Arrays.sort(viewArr, sViewSizeComparator);
        return viewArr;
    }

    private static String getSubWindowPrefix(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof WindowManager.LayoutParams)) {
            int i10 = ((WindowManager.LayoutParams) layoutParams).type;
            if (i10 == 1) {
                return sMainWindowPrefix;
            }
            if (i10 < 99 && view.getClass() == sPhoneWindowClazz) {
                return sDialogWindowPrefix;
            }
            if (i10 < 1999 && view.getClass() == sPopupWindowClazz) {
                return sPopupWindowPrefix;
            }
            if (i10 < 2999) {
                return sCustomWindowPrefix;
            }
        }
        Class<?> cls = view.getClass();
        if (cls == sPhoneWindowClazz) {
            return sDialogWindowPrefix;
        }
        if (cls == sPopupWindowClazz) {
            return sPopupWindowPrefix;
        }
        return sCustomWindowPrefix;
    }

    private static String getTabHostTag(View view) {
        if (view instanceof TabHost) {
            return (String) ReflectUtil.callMethod(view, "getCurrentTabTag", new Object[0]);
        }
        return null;
    }

    public static String getWindowPrefix(View view) {
        if (view.hashCode() == AppStateTools.getInstance().getCurrentRootWindowsHashCode()) {
            return getMainWindowPrefix();
        }
        return getSubWindowPrefix(view);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.view.View[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.View[]} */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View[] getWindowViews() {
        /*
            r0 = 0
            android.view.View[] r1 = new android.view.View[r0]
            java.lang.Object r2 = sWindowManger
            r3 = 0
            if (r2 != 0) goto L_0x0028
            com.sensorsdata.analytics.android.sdk.util.AppStateTools r2 = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance()
            android.app.Activity r2 = r2.getForegroundActivity()
            if (r2 == 0) goto L_0x0020
            android.view.Window r4 = r2.getWindow()
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x0020
            android.view.View r3 = r4.getDecorView()
        L_0x0020:
            if (r2 == 0) goto L_0x0027
            r1 = 1
            android.view.View[] r1 = new android.view.View[r1]
            r1[r0] = r3
        L_0x0027:
            return r1
        L_0x0028:
            boolean r0 = sArrayListWindowViews     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x003c
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x004c }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x004c }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x004c }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ Exception -> 0x004c }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x004c }
            goto L_0x0049
        L_0x003c:
            boolean r0 = sViewArrayWindowViews     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x0049
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x004c }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x004c }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x004c }
        L_0x0049:
            if (r3 == 0) goto L_0x004c
            r1 = r3
        L_0x004c:
            android.view.View[] r0 = filterNullAndDismissToastView(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowViews():android.view.View[]");
    }

    public static void init() {
        if (!sIsInitialized) {
            try {
                Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
                viewsField = cls.getDeclaredField("mViews");
                Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
                viewsField.setAccessible(true);
                if (viewsField.getType() == ArrayList.class) {
                    sArrayListWindowViews = true;
                } else if (viewsField.getType() == View[].class) {
                    sViewArrayWindowViews = true;
                }
                declaredField.setAccessible(true);
                sWindowManger = declaredField.get((Object) null);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            }
            try {
                sListMenuItemViewClazz = Class.forName("com.android.internal.view.menu.ListMenuItemView");
                sItemViewGetDataMethod = Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", (Class[]) null);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
            }
            try {
                sPhoneWindowClazz = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
            } catch (ClassNotFoundException unused3) {
                try {
                    sPhoneWindowClazz = Class.forName("com.android.internal.policy.DecorView");
                } catch (ClassNotFoundException unused4) {
                }
            }
            try {
                sPopupWindowClazz = Class.forName("android.widget.PopupWindow$PopupDecorView");
            } catch (ClassNotFoundException unused5) {
            }
            sIsInitialized = true;
        }
    }

    public static boolean isCustomWindow(View view) {
        return TextUtils.equals(sCustomWindowPrefix, getSubWindowPrefix(view));
    }

    public static boolean isDecorView(Class cls) {
        if (!sIsInitialized) {
            init();
        }
        if (cls == sPhoneWindowClazz || cls == sPopupWindowClazz) {
            return true;
        }
        return false;
    }

    public static boolean isDialogOrPopupWindow(View view) {
        String subWindowPrefix = getSubWindowPrefix(view);
        if (TextUtils.equals(sDialogWindowPrefix, subWindowPrefix) || TextUtils.equals(sPopupWindowPrefix, subWindowPrefix)) {
            return true;
        }
        return false;
    }

    public static boolean isMainWindow(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 1) {
            return false;
        }
        return true;
    }

    public static View getClickView(String str) {
        View findTabView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        int i10 = 0;
        while (i10 < windowViews.length) {
            try {
                View view = windowViews[i10];
                if (view.getClass() != sPopupWindowClazz && (findTabView = findTabView(view, str)) != null) {
                    return findTabView;
                }
                i10++;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

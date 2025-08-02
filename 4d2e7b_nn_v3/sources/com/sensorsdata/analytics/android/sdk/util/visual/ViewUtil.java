package com.sensorsdata.analytics.android.sdk.util.visual;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.SnapCache;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtil {
    private static boolean sHaveCustomRecyclerView;
    private static final boolean sHaveRecyclerView = haveRecyclerView();
    private static Class<?> sRecyclerViewClass;
    private static Method sRecyclerViewGetChildAdapterPositionMethod;
    private static final SparseArray<String> sViewCache = new SparseArray<>();

    private static void checkAndInvalidate(View view) {
        if (view.getLayerType() != 0) {
            view.invalidate();
        }
    }

    private static void checkCustomRecyclerView(Class<?> cls, String str) {
        if (!sHaveRecyclerView && !sHaveCustomRecyclerView && str != null && str.contains("RecyclerView")) {
            try {
                if (findRecyclerInSuper(cls) != null && sRecyclerViewGetChildAdapterPositionMethod != null) {
                    sRecyclerViewClass = cls;
                    sHaveCustomRecyclerView = true;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void clear() {
        SparseArray<String> sparseArray = sViewCache;
        synchronized (sparseArray) {
            sparseArray.clear();
        }
    }

    private static Class<?> findRecyclerInSuper(Class<?> cls) {
        Class<View> cls2 = View.class;
        Class<? super Object> cls3 = cls;
        while (cls3 != null && !cls3.equals(ViewGroup.class)) {
            try {
                sRecyclerViewGetChildAdapterPositionMethod = cls3.getMethod("getChildAdapterPosition", new Class[]{cls2});
            } catch (NoSuchMethodException unused) {
            }
            if (sRecyclerViewGetChildAdapterPositionMethod == null) {
                try {
                    sRecyclerViewGetChildAdapterPositionMethod = cls3.getMethod("getChildPosition", new Class[]{cls2});
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (sRecyclerViewGetChildAdapterPositionMethod != null) {
                return cls3;
            }
            cls3 = cls3.getSuperclass();
        }
        return null;
    }

    private static String getCanonicalAndCheckCustomView(Class<?> cls) {
        String canonicalName = SnapCache.getInstance().getCanonicalName(cls);
        if (canonicalName != null) {
            checkCustomRecyclerView(cls, canonicalName);
        }
        return canonicalName;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|(2:7|8)|9|10|(1:23)(2:14|15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return -1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getChildAdapterPositionInRecyclerView(android.view.View r6, android.view.ViewGroup r7) {
        /*
            r0 = 0
            r1 = 1
            java.lang.Class<android.view.View> r2 = android.view.View.class
            boolean r3 = instanceOfRecyclerView(r7)
            if (r3 == 0) goto L_0x0043
            java.lang.Class r3 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.String r4 = "getChildAdapterPosition"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x001a }
            r5[r0] = r2     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x001a }
            sRecyclerViewGetChildAdapterPositionMethod = r3     // Catch:{ NoSuchMethodException -> 0x001a }
        L_0x001a:
            java.lang.reflect.Method r3 = sRecyclerViewGetChildAdapterPositionMethod
            if (r3 != 0) goto L_0x002e
            java.lang.Class r3 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.String r4 = "getChildPosition"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002e }
            r5[r0] = r2     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.reflect.Method r2 = r3.getMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x002e }
            sRecyclerViewGetChildAdapterPositionMethod = r2     // Catch:{ NoSuchMethodException -> 0x002e }
        L_0x002e:
            java.lang.reflect.Method r2 = sRecyclerViewGetChildAdapterPositionMethod     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            if (r2 == 0) goto L_0x004c
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            r1[r0] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            java.lang.Object r6 = r2.invoke(r7, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            if (r6 == 0) goto L_0x004c
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            int r6 = r6.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004c }
            return r6
        L_0x0043:
            boolean r0 = sHaveCustomRecyclerView
            if (r0 == 0) goto L_0x004c
            int r6 = invokeCRVGetChildAdapterPositionMethod(r7, r6)
            return r6
        L_0x004c:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getChildAdapterPositionInRecyclerView(android.view.View, android.view.ViewGroup):int");
    }

    private static int getCurrentItem(View view) {
        try {
            Object invoke = view.getClass().getMethod("getCurrentItem", (Class[]) null).invoke(view, (Object[]) null);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            return -1;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static int getMainWindowCount(View[] viewArr) {
        WindowHelper.init();
        int i10 = 0;
        for (View view : viewArr) {
            if (view != null) {
                i10 += WindowHelper.getWindowPrefix(view).equals(WindowHelper.getMainWindowPrefix()) ? 1 : 0;
            }
        }
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(android.view.View r14, int r15, boolean r16) {
        /*
            r0 = r14
            r1 = 2
            r2 = 0
            r3 = 1
            int r4 = getViewPosition(r14, r15)
            android.view.ViewParent r5 = r14.getParent()
            r6 = 0
            if (r5 != 0) goto L_0x0010
            return r6
        L_0x0010:
            java.lang.Class r7 = r14.getClass()
            boolean r7 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(r7)
            if (r7 == 0) goto L_0x001e
            boolean r7 = r5 instanceof android.view.View
            if (r7 == 0) goto L_0x026a
        L_0x001e:
            boolean r7 = r5 instanceof android.view.View
            if (r7 == 0) goto L_0x026a
            r7 = r5
            android.view.View r7 = (android.view.View) r7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.Class r10 = r14.getClass()
            java.lang.String r10 = getCanonicalAndCheckCustomView(r10)
            android.view.ViewParent r11 = r7.getParent()
            boolean r12 = r11 instanceof android.view.View
            if (r12 == 0) goto L_0x005a
            android.view.View r11 = (android.view.View) r11
            android.util.SparseArray<java.lang.String> r12 = sViewCache
            monitor-enter(r12)
            int r11 = r11.hashCode()     // Catch:{ all -> 0x0057 }
            java.lang.Object r11 = r12.get(r11)     // Catch:{ all -> 0x0057 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0057 }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0057 }
            if (r13 != 0) goto L_0x0055
            r6 = r11
        L_0x0055:
            monitor-exit(r12)     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0057 }
            throw r0
        L_0x005a:
            boolean r11 = r7 instanceof android.widget.ExpandableListView
            if (r11 == 0) goto L_0x0164
            r5 = r7
            android.widget.ExpandableListView r5 = (android.widget.ExpandableListView) r5
            long r11 = r5.getExpandableListPosition(r4)
            int r13 = android.widget.ExpandableListView.getPackedPositionType(r11)
            if (r13 == r1) goto L_0x00fa
            int r4 = android.widget.ExpandableListView.getPackedPositionGroup(r11)
            int r5 = android.widget.ExpandableListView.getPackedPositionChild(r11)
            r6 = -1
            if (r5 == r6) goto L_0x00c4
            java.util.Locale r6 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE
            java.lang.String r11 = "%d:%d"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r12
            r1[r3] = r13
            java.lang.String r1 = java.lang.String.format(r6, r11, r1)
            r9.append(r8)
            java.lang.String r6 = "/ELVG["
            r9.append(r6)
            r9.append(r4)
            java.lang.String r6 = "]/ELVC[-]/"
            r9.append(r6)
            r9.append(r10)
            java.lang.String r6 = "[0]"
            r9.append(r6)
            java.lang.String r6 = "/ELVG["
            r8.append(r6)
            r8.append(r4)
            java.lang.String r4 = "]/ELVC["
            r8.append(r4)
            r8.append(r5)
            java.lang.String r4 = "]/"
            r8.append(r4)
            r8.append(r10)
            java.lang.String r4 = "[0]"
            r8.append(r4)
        L_0x00c1:
            r6 = r1
            goto L_0x0160
        L_0x00c4:
            java.util.Locale r1 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE
            java.lang.String r5 = "%d"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r11 = new java.lang.Object[r3]
            r11[r2] = r6
            java.lang.String r1 = java.lang.String.format(r1, r5, r11)
            r9.append(r8)
            java.lang.String r5 = "/ELVG[-]/"
            r9.append(r5)
            r9.append(r10)
            java.lang.String r5 = "[0]"
            r9.append(r5)
            java.lang.String r5 = "/ELVG["
            r8.append(r5)
            r8.append(r4)
            java.lang.String r4 = "]/"
            r8.append(r4)
            r8.append(r10)
            java.lang.String r4 = "[0]"
            r8.append(r4)
            goto L_0x00c1
        L_0x00fa:
            int r1 = r5.getHeaderViewsCount()
            if (r4 >= r1) goto L_0x012b
            java.lang.String r1 = "/ELH["
            r8.append(r1)
            r8.append(r4)
            java.lang.String r1 = "]/"
            r8.append(r1)
            r8.append(r10)
            java.lang.String r1 = "[0]"
            r8.append(r1)
            java.lang.String r1 = "/ELH["
            r9.append(r1)
            r9.append(r4)
            java.lang.String r1 = "]/"
            r9.append(r1)
            r9.append(r10)
            java.lang.String r1 = "[0]"
            r9.append(r1)
            goto L_0x015f
        L_0x012b:
            int r1 = r5.getCount()
            int r3 = r5.getFooterViewsCount()
            int r1 = r1 - r3
            int r4 = r4 - r1
            java.lang.String r1 = "/ELF["
            r8.append(r1)
            r8.append(r4)
            java.lang.String r1 = "]/"
            r8.append(r1)
            r8.append(r10)
            java.lang.String r1 = "[0]"
            r8.append(r1)
            java.lang.String r1 = "/ELF["
            r9.append(r1)
            r9.append(r4)
            java.lang.String r1 = "]/"
            r9.append(r1)
            r9.append(r10)
            java.lang.String r1 = "[0]"
            r9.append(r1)
        L_0x015f:
            r3 = r2
        L_0x0160:
            r10 = r3
        L_0x0161:
            r3 = r6
            goto L_0x021e
        L_0x0164:
            boolean r1 = isListView(r7)
            if (r1 == 0) goto L_0x01a3
            java.util.Locale r1 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE
            java.lang.String r5 = "%d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r2] = r4
            java.lang.String r1 = java.lang.String.format(r1, r5, r6)
            r9.append(r8)
            java.lang.String r4 = "/"
            r9.append(r4)
            r9.append(r10)
            java.lang.String r4 = "[-]"
            r9.append(r4)
            java.lang.String r4 = "/"
            r8.append(r4)
            r8.append(r10)
            java.lang.String r4 = "["
            r8.append(r4)
            r8.append(r1)
            java.lang.String r4 = "]"
            r8.append(r4)
            r10 = r3
            r3 = r1
            goto L_0x021e
        L_0x01a3:
            boolean r1 = instanceOfSupportSwipeRefreshLayout(r7)
            if (r1 == 0) goto L_0x01c4
            java.lang.String r1 = "/"
            r8.append(r1)
            r8.append(r10)
            java.lang.String r1 = "[0]"
            r8.append(r1)
            java.lang.String r1 = "/"
            r9.append(r1)
            r9.append(r10)
            java.lang.String r1 = "[0]"
            r9.append(r1)
            goto L_0x021b
        L_0x01c4:
            java.lang.Object r1 = instanceOfFragmentRootView(r7, r14)
            if (r1 == 0) goto L_0x01ed
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = getCanonicalAndCheckCustomView(r1)
            java.lang.String r3 = "/"
            r8.append(r3)
            r8.append(r1)
            java.lang.String r3 = "[0]"
            r8.append(r3)
            java.lang.String r3 = "/"
            r9.append(r3)
            r9.append(r1)
            java.lang.String r1 = "[0]"
            r9.append(r1)
            goto L_0x021b
        L_0x01ed:
            int r1 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getChildIndex(r5, r14)
            java.lang.String r3 = "/"
            r8.append(r3)
            r8.append(r10)
            java.lang.String r3 = "["
            r8.append(r3)
            r8.append(r1)
            java.lang.String r3 = "]"
            r8.append(r3)
            java.lang.String r3 = "/"
            r9.append(r3)
            r9.append(r10)
            java.lang.String r3 = "["
            r9.append(r3)
            r9.append(r1)
            java.lang.String r1 = "]"
            r9.append(r1)
        L_0x021b:
            r10 = r2
            goto L_0x0161
        L_0x021e:
            java.lang.Class r1 = r7.getClass()
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(r1)
            if (r1 == 0) goto L_0x023a
            int r1 = r8.length()
            if (r1 <= 0) goto L_0x0231
            r8.deleteCharAt(r2)
        L_0x0231:
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x023a
            r9.deleteCharAt(r2)
        L_0x023a:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x024f
            android.util.SparseArray<java.lang.String> r1 = sViewCache
            monitor-enter(r1)
            int r2 = r7.hashCode()     // Catch:{ all -> 0x024c }
            r1.put(r2, r3)     // Catch:{ all -> 0x024c }
            monitor-exit(r1)     // Catch:{ all -> 0x024c }
            goto L_0x024f
        L_0x024c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x024c }
            throw r0
        L_0x024f:
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r11 = new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode
            java.lang.String r4 = r8.toString()
            java.lang.String r5 = r9.toString()
            r1 = r16
            java.lang.String r6 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(r14, r1)
            java.lang.String r7 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewType(r14)
            r1 = r11
            r2 = r14
            r8 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r11
        L_0x026a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewNode(android.view.View, int, boolean):com.sensorsdata.analytics.android.sdk.util.visual.ViewNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewPathAndPosition(android.view.View r13, boolean r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 8
            r0.<init>(r1)
            r0.add(r13)
            android.view.ViewParent r1 = r13.getParent()
        L_0x000e:
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x001d
            r2 = r1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.add(r2)
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x000e
        L_0x001d:
            int r1 = r0.size()
            int r2 = r1 + -1
            java.lang.Object r2 = r0.get(r2)
            android.view.View r2 = (android.view.View) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            boolean r5 = r2 instanceof android.view.ViewGroup
            r6 = 0
            if (r5 == 0) goto L_0x00b0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -2
            r5 = r6
        L_0x003d:
            if (r1 < 0) goto L_0x0097
            java.lang.Object r7 = r0.get(r1)
            android.view.View r7 = (android.view.View) r7
            int r2 = r2.indexOfChild(r7)
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r2 = getViewNode(r7, r2, r14)
            if (r2 == 0) goto L_0x0093
            java.lang.String r5 = r2.getViewPath()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x007b
            java.lang.String r5 = r2.getViewPath()
            java.lang.String r8 = "-"
            boolean r5 = r5.contains(r8)
            if (r5 == 0) goto L_0x007b
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x007b
            int r5 = r4.indexOf(r8)
            r8 = -1
            if (r5 == r8) goto L_0x007b
            int r8 = r5 + 1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.replace(r5, r8, r6)
        L_0x007b:
            java.lang.String r5 = r2.getViewOriginalPath()
            r3.append(r5)
            java.lang.String r5 = r2.getViewPath()
            r4.append(r5)
            java.lang.String r5 = r2.getViewPosition()
            java.lang.String r2 = r2.getViewContent()
            r6 = r5
            r5 = r2
        L_0x0093:
            boolean r2 = r7 instanceof android.view.ViewGroup
            if (r2 != 0) goto L_0x009a
        L_0x0097:
            r12 = r5
            r9 = r6
            goto L_0x00a0
        L_0x009a:
            r2 = r7
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -1
            goto L_0x003d
        L_0x00a0:
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r14 = new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode
            java.lang.String r10 = r3.toString()
            java.lang.String r11 = r4.toString()
            r7 = r14
            r8 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            return r14
        L_0x00b0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewPathAndPosition(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.util.visual.ViewNode");
    }

    private static int getViewPosition(View view, int i10) {
        int childAdapterPositionInRecyclerView;
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return i10;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (instanceOfAndroidXViewPager(viewGroup) || instanceOfSupportViewPager(viewGroup)) {
            return getCurrentItem(viewGroup);
        }
        if (viewGroup instanceof AdapterView) {
            return i10 + ((AdapterView) viewGroup).getFirstVisiblePosition();
        }
        if (!instanceOfRecyclerView(viewGroup) || (childAdapterPositionInRecyclerView = getChildAdapterPositionInRecyclerView(view, viewGroup)) < 0) {
            return i10;
        }
        return childAdapterPositionInRecyclerView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r1 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0006, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0007, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0004 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean haveRecyclerView() {
        /*
            r0 = 1
            int r1 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL     // Catch:{ ClassNotFoundException -> 0x0004 }
            return r0
        L_0x0004:
            int r1 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL     // Catch:{ ClassNotFoundException -> 0x0007 }
            return r0
        L_0x0007:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.haveRecyclerView():boolean");
    }

    private static boolean instanceOfAndroidXViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    public static boolean instanceOfFlutterActivity(Object obj) {
        return ReflectUtil.isInstance(obj, "io.flutter.embedding.android.FlutterActivity");
    }

    public static boolean instanceOfFlutterSurfaceView(Object obj) {
        return ReflectUtil.isInstance(obj, "io.flutter.embedding.android.FlutterSurfaceView");
    }

    private static Object instanceOfFragmentRootView(View view, View view2) {
        Object fragmentFromView = SAFragmentUtils.getFragmentFromView(view);
        Object fragmentFromView2 = SAFragmentUtils.getFragmentFromView(view2);
        if (fragmentFromView != null || fragmentFromView2 == null) {
            return null;
        }
        return fragmentFromView2;
    }

    public static boolean instanceOfRecyclerView(Object obj) {
        boolean z10;
        Class<?> cls;
        boolean isInstance = ReflectUtil.isInstance(obj, "androidx.recyclerview.widget.RecyclerView", "androidx.recyclerview.widget.RecyclerView");
        if (isInstance) {
            return isInstance;
        }
        if (!sHaveCustomRecyclerView || obj == null || (cls = sRecyclerViewClass) == null || !cls.isAssignableFrom(obj.getClass())) {
            z10 = false;
        } else {
            z10 = true;
        }
        return z10;
    }

    private static boolean instanceOfSupportSwipeRefreshLayout(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout", "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    }

    private static boolean instanceOfSupportViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    private static boolean instanceOfUCWebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.alipay.mobile.nebulauc.impl.UCWebView$WebViewEx");
    }

    public static boolean instanceOfWebView(Object obj) {
        if ((obj instanceof WebView) || instanceOfX5WebView(obj) || instanceOfUCWebView(obj)) {
            return true;
        }
        return false;
    }

    public static boolean instanceOfX5WebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.tencent.smtt.sdk.WebView");
    }

    public static void invalidateLayerTypeView(View[] viewArr) {
        for (ViewGroup viewGroup : viewArr) {
            if (viewVisibilityInParents(viewGroup) && viewGroup.isHardwareAccelerated()) {
                checkAndInvalidate(viewGroup);
                if (viewGroup instanceof ViewGroup) {
                    invalidateViewGroup(viewGroup);
                }
            }
        }
    }

    private static void invalidateViewGroup(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (SAViewUtils.isViewSelfVisible(childAt)) {
                checkAndInvalidate(childAt);
                if (childAt instanceof ViewGroup) {
                    invalidateViewGroup((ViewGroup) childAt);
                }
            }
        }
    }

    private static int invokeCRVGetChildAdapterPositionMethod(View view, View view2) {
        try {
            if (view.getClass() != sRecyclerViewClass) {
                return -1;
            }
            return ((Integer) sRecyclerViewGetChildAdapterPositionMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return -1;
        }
    }

    private static boolean isListView(View view) {
        if ((view instanceof AdapterView) || instanceOfRecyclerView(view) || instanceOfAndroidXViewPager(view) || instanceOfSupportViewPager(view)) {
            return true;
        }
        return false;
    }

    public static boolean isWindowNeedTraverse(View view, String str, boolean z10) {
        if (view.hashCode() == AppStateTools.getInstance().getCurrentRootWindowsHashCode()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            if (!z10) {
                return true;
            }
            if (!(view.getWindowVisibility() == 8 || view.getVisibility() != 0 || TextUtils.equals(str, WindowHelper.getMainWindowPrefix()) || view.getWidth() == 0 || view.getHeight() == 0)) {
                return true;
            }
        }
        if ((view.getWindowVisibility() == 0 || view.getVisibility() == 0) && WindowHelper.isCustomWindow(view)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean viewVisibilityInParents(android.view.View r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(r2)
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            android.view.ViewParent r2 = r2.getParent()
        L_0x000f:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L_0x0024
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(r1)
            if (r1 != 0) goto L_0x001d
            return r0
        L_0x001d:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x0024:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.viewVisibilityInParents(android.view.View):boolean");
    }
}

package com.sensorsdata.analytics.android.sdk.util.visual;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ViewTreeStatusObservable {
    private static final String TAG = "SA.ViewTreeStatusObservable";
    public static volatile ViewTreeStatusObservable viewTreeStatusObservable;
    private HashMap<String, ViewNode> mViewNodesHashMap = new HashMap<>();
    private SparseArray<ViewNode> mViewNodesWithHashCode = new SparseArray<>();
    private HashMap<String, ViewNode> mWebViewHashMap = new HashMap<>();

    private String generateKey(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
        }
        return sb2.toString();
    }

    private ViewNode getCacheViewPathAndPosition(View view, boolean z10) {
        View view2;
        ViewNode viewNode;
        String str;
        int lastIndexOf;
        ViewNode viewNode2 = this.mViewNodesWithHashCode.get(view.hashCode());
        if (viewNode2 != null) {
            return viewNode2;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 == null) {
            viewNode = ViewUtil.getViewPathAndPosition(view, z10);
        } else {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            ViewNode viewNode3 = this.mViewNodesWithHashCode.get(view2.hashCode());
            if (viewNode3 == null) {
                viewNode3 = ViewUtil.getViewPathAndPosition(view2, z10);
                this.mViewNodesWithHashCode.put(view2.hashCode(), viewNode3);
            }
            if (viewNode3 != null) {
                sb2.append(viewNode3.getViewOriginalPath());
                sb3.append(viewNode3.getViewPath());
                str = viewNode3.getViewPosition();
            } else {
                str = "";
            }
            viewNode = ViewUtil.getViewNode(view, ((ViewGroup) view2).indexOfChild(view), z10);
            if (viewNode != null && !TextUtils.isEmpty(viewNode.getViewPath()) && viewNode.getViewPath().contains("-") && !TextUtils.isEmpty(str) && (lastIndexOf = sb3.lastIndexOf("-")) != -1) {
                sb3.replace(lastIndexOf, lastIndexOf + 1, String.valueOf(str));
            }
            if (viewNode != null) {
                sb2.append(viewNode.getViewOriginalPath());
                sb3.append(viewNode.getViewPath());
                viewNode = new ViewNode(view, viewNode.getViewPosition(), sb2.toString(), sb3.toString(), viewNode.getViewContent());
            }
        }
        this.mViewNodesWithHashCode.put(view.hashCode(), viewNode);
        return viewNode;
    }

    public static ViewTreeStatusObservable getInstance() {
        if (viewTreeStatusObservable == null) {
            synchronized (ViewTreeStatusObservable.class) {
                try {
                    if (viewTreeStatusObservable == null) {
                        viewTreeStatusObservable = new ViewTreeStatusObservable();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return viewTreeStatusObservable;
    }

    private ViewNode getSingleViewPathAndPosition(View view, boolean z10) {
        View view2;
        String str;
        int lastIndexOf;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 == null) {
            return ViewUtil.getViewPathAndPosition(view, z10);
        }
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        ViewNode viewPathAndPosition = ViewUtil.getViewPathAndPosition(view2, z10);
        if (viewPathAndPosition != null) {
            sb2.append(viewPathAndPosition.getViewOriginalPath());
            sb3.append(viewPathAndPosition.getViewPath());
            str = viewPathAndPosition.getViewPosition();
        } else {
            str = "";
        }
        ViewNode viewNode = ViewUtil.getViewNode(view, ((ViewGroup) view2).indexOfChild(view), z10);
        if (viewNode == null) {
            return viewNode;
        }
        if (!TextUtils.isEmpty(viewNode.getViewPath()) && viewNode.getViewPath().contains("-") && !TextUtils.isEmpty(str) && (lastIndexOf = sb3.lastIndexOf("-")) != -1) {
            sb3.replace(lastIndexOf, lastIndexOf + 1, String.valueOf(str));
        }
        sb2.append(viewNode.getViewOriginalPath());
        sb3.append(viewNode.getViewPath());
        return new ViewNode(view, viewNode.getViewPosition(), sb2.toString(), sb3.toString(), viewNode.getViewContent());
    }

    private void traverseNode() {
        traverseNode((View) null);
    }

    public void clearViewNodeCache() {
        this.mViewNodesWithHashCode.clear();
        this.mViewNodesHashMap.clear();
    }

    public void clearWebViewCache() {
        try {
            HashMap<String, ViewNode> hashMap = this.mWebViewHashMap;
            if (hashMap != null) {
                hashMap.clear();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public List<View> getCurrentWebView() {
        try {
            if (this.mWebViewHashMap.size() == 0) {
                traverseNode();
            }
            if (this.mWebViewHashMap.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (ViewNode view : this.mWebViewHashMap.values()) {
                WeakReference<View> view2 = view.getView();
                if (!(view2 == null || view2.get() == null)) {
                    arrayList.add(view2.get());
                }
            }
            return arrayList;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public ViewNode getViewNode(View view) {
        try {
            return getViewPathAndPosition(view);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public ViewNode getViewPathAndPosition(View view) {
        return getSingleViewPathAndPosition(view, false);
    }

    private void traverseNode(View view) {
        try {
            this.mViewNodesHashMap.clear();
            this.mViewNodesWithHashCode.clear();
            this.mWebViewHashMap.clear();
            SparseArray<ViewNode> sparseArray = new SparseArray<>();
            HashMap<String, ViewNode> hashMap = new HashMap<>();
            HashMap<String, ViewNode> hashMap2 = new HashMap<>();
            if (view != null) {
                traverseNode(view, sparseArray, hashMap, hashMap2);
            } else {
                for (View traverseNode : WindowHelper.getSortedWindowViews()) {
                    traverseNode(traverseNode, sparseArray, hashMap, hashMap2);
                }
            }
            this.mViewNodesHashMap = hashMap;
            this.mViewNodesWithHashCode = sparseArray;
            this.mWebViewHashMap = hashMap2;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.util.visual.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.util.visual.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(java.lang.ref.WeakReference<android.view.View> r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> r1 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x005c }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.util.visual.ViewNode) r1     // Catch:{ Exception -> 0x005c }
            if (r1 != 0) goto L_0x0061
            if (r4 == 0) goto L_0x0025
            java.lang.Object r2 = r4.get()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0022 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getRootView()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            r4 = move-exception
            r0 = r1
            goto L_0x005d
        L_0x0025:
            if (r0 != 0) goto L_0x0049
            com.sensorsdata.analytics.android.sdk.util.AppStateTools r4 = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance()     // Catch:{ Exception -> 0x0022 }
            android.app.Activity r4 = r4.getForegroundActivity()     // Catch:{ Exception -> 0x0022 }
            if (r4 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r2 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            boolean r2 = r2.isActive()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0049
            android.view.Window r4 = r4.getWindow()     // Catch:{ Exception -> 0x0022 }
            android.view.View r0 = r4.getDecorView()     // Catch:{ Exception -> 0x0022 }
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r3.traverseNode(r0)     // Catch:{ Exception -> 0x0022 }
        L_0x004e:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> r4 = r3.mViewNodesHashMap     // Catch:{ Exception -> 0x0022 }
            java.lang.String r5 = r3.generateKey(r5, r6, r7)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0022 }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r4 = (com.sensorsdata.analytics.android.sdk.util.visual.ViewNode) r4     // Catch:{ Exception -> 0x0022 }
            r1 = r4
            goto L_0x0061
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
            r1 = r0
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getViewNode(java.lang.ref.WeakReference, java.lang.String, java.lang.String, java.lang.String):com.sensorsdata.analytics.android.sdk.util.visual.ViewNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.sensorsdata.analytics.android.sdk.util.visual.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.util.visual.ViewNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> r1 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x0050 }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r1 = (com.sensorsdata.analytics.android.sdk.util.visual.ViewNode) r1     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x001f
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x001c }
            if (r2 == 0) goto L_0x001f
            java.lang.ref.WeakReference r2 = r1.getView()     // Catch:{ Exception -> 0x001c }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x001c }
            if (r2 != 0) goto L_0x0055
            goto L_0x001f
        L_0x001c:
            r5 = move-exception
            r0 = r1
            goto L_0x0051
        L_0x001f:
            com.sensorsdata.analytics.android.sdk.util.AppStateTools r2 = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance()     // Catch:{ Exception -> 0x001c }
            android.app.Activity r2 = r2.getForegroundActivity()     // Catch:{ Exception -> 0x001c }
            if (r2 == 0) goto L_0x0041
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x001c }
            if (r3 == 0) goto L_0x0041
            android.view.Window r3 = r2.getWindow()     // Catch:{ Exception -> 0x001c }
            boolean r3 = r3.isActive()     // Catch:{ Exception -> 0x001c }
            if (r3 == 0) goto L_0x0041
            android.view.Window r0 = r2.getWindow()     // Catch:{ Exception -> 0x001c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x001c }
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r4.traverseNode(r0)     // Catch:{ Exception -> 0x001c }
        L_0x0046:
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> r0 = r4.mWebViewHashMap     // Catch:{ Exception -> 0x001c }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x001c }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r5 = (com.sensorsdata.analytics.android.sdk.util.visual.ViewNode) r5     // Catch:{ Exception -> 0x001c }
            r1 = r5
            goto L_0x0055
        L_0x0050:
            r5 = move-exception
        L_0x0051:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
            r1 = r0
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getViewNode(java.lang.String):com.sensorsdata.analytics.android.sdk.util.visual.ViewNode");
    }

    private void traverseNode(View view, SparseArray<ViewNode> sparseArray, HashMap<String, ViewNode> hashMap, HashMap<String, ViewNode> hashMap2) {
        JSONObject screenNameAndTitle;
        if (view != null) {
            try {
                ViewNode cacheViewPathAndPosition = getCacheViewPathAndPosition(view, true);
                if (cacheViewPathAndPosition != null) {
                    sparseArray.put(view.hashCode(), cacheViewPathAndPosition);
                    if (!TextUtils.isEmpty(cacheViewPathAndPosition.getViewPath()) && (screenNameAndTitle = SAViewUtils.getScreenNameAndTitle(view)) != null) {
                        String optString = screenNameAndTitle.optString("$screen_name");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(cacheViewPathAndPosition.getViewContent())) {
                                hashMap.put(generateKey(cacheViewPathAndPosition.getViewPath(), cacheViewPathAndPosition.getViewPosition(), optString), cacheViewPathAndPosition);
                            }
                            if (ViewUtil.instanceOfWebView(view)) {
                                hashMap2.put(cacheViewPathAndPosition.getViewPath() + optString, cacheViewPathAndPosition);
                            }
                        }
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = viewGroup.getChildAt(i10);
                        if (childAt != null) {
                            traverseNode(childAt, sparseArray, hashMap, hashMap2);
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }
}

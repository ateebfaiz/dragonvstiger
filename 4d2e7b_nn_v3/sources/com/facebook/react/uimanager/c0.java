package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import c8.b;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import l7.e;
import l7.f;

public class c0 {
    private static final String TAG = "c0";
    private final boolean DEBUG_MODE;
    private final RectF mBoundingBox;
    private final g7.a mJSResponderHandler;
    private boolean mLayoutAnimationEnabled;
    private final e mLayoutAnimator;
    /* access modifiers changed from: private */
    public HashMap<Integer, Set<Integer>> mPendingDeletionsForTag;
    private final SparseBooleanArray mRootTags;
    private final RootViewManager mRootViewManager;
    private final SparseArray<ViewManager> mTagsToViewManagers;
    private final SparseArray<View> mTagsToViews;
    private final i2 mViewManagers;

    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroupManager f3562a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3563b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3564c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f3565d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f3566e;

        a(ViewGroupManager viewGroupManager, ViewGroup viewGroup, View view, Set set, int i10) {
            this.f3562a = viewGroupManager;
            this.f3563b = viewGroup;
            this.f3564c = view;
            this.f3565d = set;
            this.f3566e = i10;
        }

        public void a() {
            UiThreadUtil.assertOnUiThread();
            this.f3562a.removeView(this.f3563b, this.f3564c);
            c0.this.dropView(this.f3564c);
            this.f3565d.remove(Integer.valueOf(this.f3564c.getId()));
            if (this.f3565d.isEmpty()) {
                c0.this.mPendingDeletionsForTag.remove(Integer.valueOf(this.f3566e));
            }
        }
    }

    public c0(i2 i2Var) {
        this(i2Var, new RootViewManager());
    }

    private boolean b(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private void c(View view, int[] iArr) {
        this.mBoundingBox.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        g(view, this.mBoundingBox);
        iArr[0] = Math.round(this.mBoundingBox.left);
        iArr[1] = Math.round(this.mBoundingBox.top);
        RectF rectF = this.mBoundingBox;
        iArr[2] = Math.round(rectF.right - rectF.left);
        RectF rectF2 = this.mBoundingBox;
        iArr[3] = Math.round(rectF2.bottom - rectF2.top);
    }

    private static String d(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, a2[] a2VarArr, int[] iArr2) {
        StringBuilder sb2 = new StringBuilder();
        if (viewGroup != null) {
            sb2.append("View tag:" + viewGroup.getId() + " View Type:" + viewGroup.getClass().toString() + "\n");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  children(");
            sb3.append(viewGroupManager.getChildCount(viewGroup));
            sb3.append("): [\n");
            sb2.append(sb3.toString());
            for (int i10 = 0; viewGroupManager.getChildAt(viewGroup, i10) != null; i10 += 16) {
                int i11 = 0;
                while (true) {
                    int i12 = i10 + i11;
                    if (viewGroupManager.getChildAt(viewGroup, i12) == null || i11 >= 16) {
                        sb2.append("\n");
                    } else {
                        sb2.append(viewGroupManager.getChildAt(viewGroup, i12).getId() + ",");
                        i11++;
                    }
                }
                sb2.append("\n");
            }
            sb2.append(" ],\n");
        }
        if (iArr != null) {
            sb2.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i13 = 0; i13 < iArr.length; i13 += 16) {
                int i14 = 0;
                while (true) {
                    int i15 = i13 + i14;
                    if (i15 >= iArr.length || i14 >= 16) {
                        sb2.append("\n");
                    } else {
                        sb2.append(iArr[i15] + ",");
                        i14++;
                    }
                }
                sb2.append("\n");
            }
            sb2.append(" ],\n");
        }
        if (a2VarArr != null) {
            sb2.append("  viewsToAdd(" + a2VarArr.length + "): [\n");
            for (int i16 = 0; i16 < a2VarArr.length; i16 += 16) {
                int i17 = 0;
                while (true) {
                    int i18 = i16 + i17;
                    if (i18 >= a2VarArr.length || i17 >= 16) {
                        sb2.append("\n");
                    } else {
                        sb2.append("[" + a2VarArr[i18].f3549b + "," + a2VarArr[i18].f3548a + "],");
                        i17++;
                    }
                }
                sb2.append("\n");
            }
            sb2.append(" ],\n");
        }
        if (iArr2 != null) {
            sb2.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i19 = 0; i19 < iArr2.length; i19 += 16) {
                int i20 = 0;
                while (true) {
                    int i21 = i19 + i20;
                    if (i21 >= iArr2.length || i20 >= 16) {
                        sb2.append("\n");
                    } else {
                        sb2.append(iArr2[i21] + ",");
                        i20++;
                    }
                }
                sb2.append("\n");
            }
            sb2.append(" ]\n");
        }
        return sb2.toString();
    }

    private static String e(ViewGroup viewGroup, ViewGroupManager viewGroupManager, ReadableArray readableArray) {
        a2[] a2VarArr = new a2[readableArray.size()];
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            a2VarArr[i10] = new a2(readableArray.getInt(i10), i10);
        }
        return d(viewGroup, viewGroupManager, (int[]) null, a2VarArr, (int[]) null);
    }

    private Set f(int i10) {
        if (this.mPendingDeletionsForTag == null) {
            this.mPendingDeletionsForTag = new HashMap<>();
        }
        if (!this.mPendingDeletionsForTag.containsKey(Integer.valueOf(i10))) {
            this.mPendingDeletionsForTag.put(Integer.valueOf(i10), new HashSet());
        }
        return this.mPendingDeletionsForTag.get(Integer.valueOf(i10));
    }

    private void g(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset((float) view2.getLeft(), (float) view2.getTop());
            parent = view2.getParent();
        }
    }

    private void h(View view, long j10) {
        UiThreadUtil.assertOnUiThread();
        view.setTag(m.B, Long.valueOf(j10));
    }

    private void i(View view, int i10, int i11, int i12, int i13) {
        if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(view)) {
            view.layout(i10, i11, i12 + i10, i13 + i11);
        } else {
            this.mLayoutAnimator.applyLayoutUpdate(view, i10, i11, i12, i13);
        }
    }

    public synchronized void addRootView(int i10, View view) {
        addRootViewGroup(i10, view);
    }

    /* access modifiers changed from: protected */
    public final synchronized void addRootViewGroup(int i10, View view) {
        try {
            if (view.getId() != -1) {
                String str = TAG;
                z2.a.j(str, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
            }
            this.mTagsToViews.put(i10, view);
            this.mTagsToViewManagers.put(i10, this.mRootViewManager);
            this.mRootTags.put(i10, true);
            view.setId(i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.b();
    }

    /* access modifiers changed from: package-private */
    public void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    /* access modifiers changed from: package-private */
    public void configureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mLayoutAnimator.initializeFromConfig(readableMap, callback);
    }

    public synchronized void createView(e1 e1Var, int i10, String str, @Nullable v0 v0Var) {
        UiThreadUtil.assertOnUiThread();
        b.a(0, "NativeViewHierarchyManager_createView").a("tag", i10).b("className", str).c();
        try {
            ViewManager c10 = this.mViewManagers.c(str);
            this.mTagsToViews.put(i10, c10.createView(i10, e1Var, v0Var, (d1) null, this.mJSResponderHandler));
            this.mTagsToViewManagers.put(i10, c10);
        } finally {
            c8.a.g(0);
        }
    }

    @Deprecated
    public synchronized void dispatchCommand(int i10, int i11, @Nullable ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            resolveViewManager(i10).receiveCommand(view, i11, readableArray);
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i10 + "] and command " + i11);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void dropView(View view) {
        try {
            UiThreadUtil.assertOnUiThread();
            if (view != null) {
                if (this.mTagsToViewManagers.get(view.getId()) != null) {
                    if (!this.mRootTags.get(view.getId())) {
                        resolveViewManager(view.getId()).onDropViewInstance(view);
                    }
                    ViewManager viewManager = this.mTagsToViewManagers.get(view.getId());
                    if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                        for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                            View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                            if (childAt == null) {
                                z2.a.j(TAG, "Unable to drop null child view");
                            } else if (this.mTagsToViews.get(childAt.getId()) != null) {
                                dropView(childAt);
                            }
                        }
                        viewGroupManager.removeAllViews(viewGroup);
                    }
                    this.mTagsToViews.remove(view.getId());
                    this.mTagsToViewManagers.remove(view.getId());
                }
            }
        } finally {
        }
    }

    public synchronized int findTargetTagForTouch(int i10, float f10, float f11) {
        View view;
        UiThreadUtil.assertOnUiThread();
        view = this.mTagsToViews.get(i10);
        if (view != null) {
        } else {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i10);
        }
        return f1.d(f10, f11, (ViewGroup) view);
    }

    @Nullable
    public long getInstanceHandle(int i10) {
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            Long l10 = (Long) view.getTag(m.B);
            if (l10 != null) {
                return l10.longValue();
            }
            throw new s("Unable to find instanceHandle for tag: " + i10);
        }
        throw new s("Unable to find view for tag: " + i10);
    }

    public synchronized int getRootViewNum() {
        return this.mRootTags.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01de, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void manageChildren(int r18, @androidx.annotation.Nullable int[] r19, @androidx.annotation.Nullable com.facebook.react.uimanager.a2[] r20, @androidx.annotation.Nullable int[] r21) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            monitor-enter(r17)
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()     // Catch:{ all -> 0x0049 }
            java.util.Set r12 = r17.f(r18)     // Catch:{ all -> 0x0049 }
            android.util.SparseArray<android.view.View> r1 = r8.mTagsToViews     // Catch:{ all -> 0x0049 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0049 }
            r13 = r1
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13     // Catch:{ all -> 0x0049 }
            com.facebook.react.uimanager.ViewManager r1 = r17.resolveViewManager(r18)     // Catch:{ all -> 0x0049 }
            r14 = r1
            com.facebook.react.uimanager.ViewGroupManager r14 = (com.facebook.react.uimanager.ViewGroupManager) r14     // Catch:{ all -> 0x0049 }
            if (r13 == 0) goto L_0x01df
            int r1 = r14.getChildCount(r13)     // Catch:{ all -> 0x0049 }
            if (r9 == 0) goto L_0x00f1
            int r2 = r9.length     // Catch:{ all -> 0x0049 }
            int r2 = r2 + -1
        L_0x002d:
            if (r2 < 0) goto L_0x00f1
            r3 = r9[r2]     // Catch:{ all -> 0x0049 }
            if (r3 < 0) goto L_0x00c6
            android.view.View r4 = r14.getChildAt(r13, (int) r3)     // Catch:{ all -> 0x0049 }
            if (r4 != 0) goto L_0x0077
            android.util.SparseBooleanArray r1 = r8.mRootTags     // Catch:{ all -> 0x0049 }
            boolean r1 = r1.get(r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x004c
            int r1 = r14.getChildCount(r13)     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x004c
            monitor-exit(r17)
            return
        L_0x0049:
            r0 = move-exception
            goto L_0x0205
        L_0x004c:
            com.facebook.react.uimanager.s r1 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = "Trying to remove a view index above child count "
            r2.append(r4)     // Catch:{ all -> 0x0049 }
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " view tag: "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "\n detail: "
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = d(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0049 }
            r1.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x0077:
            if (r3 >= r1) goto L_0x009b
            android.view.View r1 = r14.getChildAt(r13, (int) r3)     // Catch:{ all -> 0x0049 }
            boolean r4 = r8.mLayoutAnimationEnabled     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x0094
            l7.e r4 = r8.mLayoutAnimator     // Catch:{ all -> 0x0049 }
            boolean r4 = r4.shouldAnimateLayout(r1)     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x0094
            int r1 = r1.getId()     // Catch:{ all -> 0x0049 }
            boolean r1 = r8.b(r11, r1)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0094
            goto L_0x0097
        L_0x0094:
            r14.removeViewAt(r13, (int) r3)     // Catch:{ all -> 0x0049 }
        L_0x0097:
            int r2 = r2 + -1
            r1 = r3
            goto L_0x002d
        L_0x009b:
            com.facebook.react.uimanager.s r1 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = "Trying to remove an out of order view index:"
            r2.append(r4)     // Catch:{ all -> 0x0049 }
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " view tag: "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "\n detail: "
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = d(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0049 }
            r1.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x00c6:
            com.facebook.react.uimanager.s r1 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = "Trying to remove a negative view index:"
            r2.append(r4)     // Catch:{ all -> 0x0049 }
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " view tag: "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = "\n detail: "
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = d(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0049 }
            r2.append(r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0049 }
            r1.<init>(r0)     // Catch:{ all -> 0x0049 }
            throw r1     // Catch:{ all -> 0x0049 }
        L_0x00f1:
            if (r11 == 0) goto L_0x0162
            r7 = 0
        L_0x00f4:
            int r1 = r11.length     // Catch:{ all -> 0x0049 }
            if (r7 >= r1) goto L_0x0162
            r1 = r11[r7]     // Catch:{ all -> 0x0049 }
            android.util.SparseArray<android.view.View> r2 = r8.mTagsToViews     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0049 }
            r6 = r2
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x013d
            boolean r2 = r8.mLayoutAnimationEnabled     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0130
            l7.e r2 = r8.mLayoutAnimator     // Catch:{ all -> 0x0049 }
            boolean r2 = r2.shouldAnimateLayout(r6)     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0130
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0049 }
            r12.add(r1)     // Catch:{ all -> 0x0049 }
            l7.e r5 = r8.mLayoutAnimator     // Catch:{ all -> 0x0049 }
            com.facebook.react.uimanager.c0$a r4 = new com.facebook.react.uimanager.c0$a     // Catch:{ all -> 0x0049 }
            r1 = r4
            r2 = r17
            r3 = r14
            r15 = r4
            r4 = r13
            r0 = r5
            r5 = r6
            r9 = r6
            r6 = r12
            r16 = r7
            r7 = r18
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0049 }
            r0.deleteView(r9, r15)     // Catch:{ all -> 0x0049 }
            goto L_0x0136
        L_0x0130:
            r9 = r6
            r16 = r7
            r8.dropView(r9)     // Catch:{ all -> 0x0049 }
        L_0x0136:
            int r7 = r16 + 1
            r0 = r18
            r9 = r19
            goto L_0x00f4
        L_0x013d:
            com.facebook.react.uimanager.s r0 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "Trying to destroy unknown view tag: "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r2.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "\n detail: "
            r2.append(r1)     // Catch:{ all -> 0x0049 }
            r1 = r19
            java.lang.String r1 = d(r13, r14, r1, r10, r11)     // Catch:{ all -> 0x0049 }
            r2.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0049 }
            r0.<init>(r1)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0162:
            r1 = r9
            if (r10 == 0) goto L_0x01ce
            r0 = 0
        L_0x0166:
            int r2 = r10.length     // Catch:{ all -> 0x0049 }
            if (r0 >= r2) goto L_0x01ce
            r2 = r10[r0]     // Catch:{ all -> 0x0049 }
            android.util.SparseArray<android.view.View> r3 = r8.mTagsToViews     // Catch:{ all -> 0x0049 }
            int r4 = r2.f3548a     // Catch:{ all -> 0x0049 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0049 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x01a9
            int r4 = r2.f3549b     // Catch:{ all -> 0x0049 }
            boolean r5 = r12.isEmpty()     // Catch:{ all -> 0x0049 }
            if (r5 != 0) goto L_0x01a3
            r4 = 0
            r5 = 0
        L_0x0181:
            int r6 = r13.getChildCount()     // Catch:{ all -> 0x0049 }
            if (r4 >= r6) goto L_0x01a3
            int r6 = r2.f3549b     // Catch:{ all -> 0x0049 }
            if (r5 != r6) goto L_0x018c
            goto L_0x01a3
        L_0x018c:
            android.view.View r6 = r13.getChildAt(r4)     // Catch:{ all -> 0x0049 }
            int r6 = r6.getId()     // Catch:{ all -> 0x0049 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0049 }
            boolean r6 = r12.contains(r6)     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x01a0
            int r5 = r5 + 1
        L_0x01a0:
            int r4 = r4 + 1
            goto L_0x0181
        L_0x01a3:
            r14.addView(r13, (android.view.View) r3, (int) r4)     // Catch:{ all -> 0x0049 }
            int r0 = r0 + 1
            goto L_0x0166
        L_0x01a9:
            com.facebook.react.uimanager.s r0 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r3.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = "Trying to add unknown view tag: "
            r3.append(r4)     // Catch:{ all -> 0x0049 }
            int r2 = r2.f3548a     // Catch:{ all -> 0x0049 }
            r3.append(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "\n detail: "
            r3.append(r2)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = d(r13, r14, r1, r10, r11)     // Catch:{ all -> 0x0049 }
            r3.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0049 }
            r0.<init>(r1)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x01ce:
            boolean r0 = r12.isEmpty()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x01dd
            java.util.HashMap<java.lang.Integer, java.util.Set<java.lang.Integer>> r0 = r8.mPendingDeletionsForTag     // Catch:{ all -> 0x0049 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x0049 }
            r0.remove(r1)     // Catch:{ all -> 0x0049 }
        L_0x01dd:
            monitor-exit(r17)
            return
        L_0x01df:
            r1 = r9
            com.facebook.react.uimanager.s r0 = new com.facebook.react.uimanager.s     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "Trying to manageChildren view with tag "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            r3 = r18
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " which doesn't exist\n detail: "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = d(r13, r14, r1, r10, r11)     // Catch:{ all -> 0x0049 }
            r2.append(r1)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0049 }
            r0.<init>(r1)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0205:
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.c0.manageChildren(int, int[], com.facebook.react.uimanager.a2[], int[]):void");
    }

    public synchronized void measure(int i10, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            View view2 = (View) a1.a(view);
            if (view2 != null) {
                c(view2, iArr);
                int i11 = iArr[0];
                int i12 = iArr[1];
                c(view, iArr);
                iArr[0] = iArr[0] - i11;
                iArr[1] = iArr[1] - i12;
            } else {
                throw new e0("Native view " + i10 + " is no longer on screen");
            }
        } else {
            throw new e0("No native view for " + i10 + " currently exists");
        }
    }

    public synchronized void measureInWindow(int i10, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            iArr[0] = iArr[0] - rect.left;
            iArr[1] = iArr[1] - rect.top;
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } else {
            throw new e0("No native view for " + i10 + " currently exists");
        }
    }

    public synchronized void removeRootView(int i10) {
        try {
            UiThreadUtil.assertOnUiThread();
            if (!this.mRootTags.get(i10)) {
                SoftAssertions.assertUnreachable("View with tag " + i10 + " is not registered as a root view");
            }
            dropView(this.mTagsToViews.get(i10));
            this.mRootTags.delete(i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized View resolveView(int i10) {
        View view;
        view = this.mTagsToViews.get(i10);
        if (view == null) {
            throw new s("Trying to resolve view with tag " + i10 + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i10) {
        ViewManager viewManager;
        viewManager = this.mTagsToViewManagers.get(i10);
        if (viewManager == null) {
            throw new s("ViewManager for tag " + i10 + " could not be found.\n");
        }
        return viewManager;
    }

    public void sendAccessibilityEvent(int i10, int i11) {
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            view.sendAccessibilityEvent(i11);
            return;
        }
        throw new RetryableMountingLayerException("Could not find view with tag " + i10);
    }

    public synchronized void setChildren(int i10, ReadableArray readableArray) {
        try {
            UiThreadUtil.assertOnUiThread();
            ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i10);
            ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i10);
            int i11 = 0;
            while (i11 < readableArray.size()) {
                View view = this.mTagsToViews.get(readableArray.getInt(i11));
                if (view != null) {
                    viewGroupManager.addView(viewGroup, view, i11);
                    i11++;
                } else {
                    throw new s("Trying to add unknown view tag: " + readableArray.getInt(i11) + "\n detail: " + e(viewGroup, viewGroupManager, readableArray));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setJSResponder(int i10, int i11, boolean z10) {
        if (!z10) {
            this.mJSResponderHandler.d(i11, (ViewParent) null);
            return;
        }
        View view = this.mTagsToViews.get(i10);
        if (i11 == i10 || !(view instanceof ViewParent)) {
            if (this.mRootTags.get(i10)) {
                SoftAssertions.assertUnreachable("Cannot block native responder on " + i10 + " that is a root view");
            }
            this.mJSResponderHandler.d(i11, view.getParent());
            return;
        }
        this.mJSResponderHandler.d(i11, (ViewParent) view);
    }

    public void setLayoutAnimationEnabled(boolean z10) {
        this.mLayoutAnimationEnabled = z10;
    }

    public synchronized void updateInstanceHandle(int i10, long j10) {
        UiThreadUtil.assertOnUiThread();
        try {
            h(resolveView(i10), j10);
        } catch (s e10) {
            String str = TAG;
            z2.a.k(str, "Unable to update properties for view tag " + i10, e10);
        }
        return;
    }

    public synchronized void updateLayout(int i10, int i11, int i12, int i13, int i14, int i15) {
        UiThreadUtil.assertOnUiThread();
        b.a(0, "NativeViewHierarchyManager_updateLayout").a("parentTag", i10).a("tag", i11).c();
        try {
            View resolveView = resolveView(i11);
            resolveView.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
            ViewParent parent = resolveView.getParent();
            if (parent instanceof z0) {
                parent.requestLayout();
            }
            if (!this.mRootTags.get(i10)) {
                ViewManager viewManager = this.mTagsToViewManagers.get(i10);
                if (viewManager instanceof r) {
                    r rVar = (r) viewManager;
                    if (rVar != null && !rVar.needsCustomLayoutForChildren()) {
                        i(resolveView, i12, i13, i14, i15);
                    }
                } else {
                    throw new s("Trying to use view with tag " + i10 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                }
            } else {
                i(resolveView, i12, i13, i14, i15);
            }
        } finally {
            c8.a.g(0);
        }
    }

    public synchronized void updateProperties(int i10, v0 v0Var) {
        UiThreadUtil.assertOnUiThread();
        try {
            ViewManager resolveViewManager = resolveViewManager(i10);
            View resolveView = resolveView(i10);
            if (v0Var != null) {
                resolveViewManager.updateProperties(resolveView, v0Var);
            }
        } catch (s e10) {
            String str = TAG;
            z2.a.k(str, "Unable to update properties for view tag " + i10, e10);
        }
        return;
    }

    public synchronized void updateViewExtraData(int i10, Object obj) {
        UiThreadUtil.assertOnUiThread();
        resolveViewManager(i10).updateExtraData(resolveView(i10), obj);
    }

    public c0(i2 i2Var, RootViewManager rootViewManager) {
        this.DEBUG_MODE = false;
        this.mJSResponderHandler = new g7.a();
        this.mLayoutAnimator = new e();
        this.mBoundingBox = new RectF();
        this.mViewManagers = i2Var;
        this.mTagsToViews = new SparseArray<>();
        this.mTagsToViewManagers = new SparseArray<>();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public synchronized void dispatchCommand(int i10, String str, @Nullable ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i10);
        if (view != null) {
            resolveViewManager(i10).receiveCommand(view, str, readableArray);
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i10 + "] and command " + str);
        }
    }
}

package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.r;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.v0;
import com.facebook.react.uimanager.z0;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import com.swmansion.worklets.AndroidUIScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class AnimationsManager implements ViewHierarchyObserver {
    private boolean isInvalidated;
    private HashSet<Integer> mAncestorsToRemove = new HashSet<>();
    private HashMap<Integer, Runnable> mCallbacks = new HashMap<>();
    private ReactContext mContext;
    private final HashMap<Integer, Rect> mEnteringViewTargetValues = new HashMap<>();
    private final HashSet<Integer> mEnteringViews = new HashSet<>();
    private HashMap<Integer, Integer> mExitingSubviewCountMap = new HashMap<>();
    private HashMap<Integer, View> mExitingViews = new HashMap<>();
    private NativeMethodsHolder mNativeMethodsHolder;
    private ReanimatedNativeHierarchyManager mReanimatedNativeHierarchyManager;
    private final SharedTransitionManager mSharedTransitionManager;
    private UIManager mUIManager;
    private WeakReference<AndroidUIScheduler> mWeakAndroidUIScheduler = new WeakReference<>((Object) null);

    public AnimationsManager(ReactContext reactContext, UIManager uIManager) {
        this.mContext = reactContext;
        this.mUIManager = uIManager;
        this.isInvalidated = false;
        this.mSharedTransitionManager = new SharedTransitionManager(this);
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else {
            throw new IllegalStateException("[Reanimated] Unknown type of animated value for Layout Animations.");
        }
    }

    private void checkDuplicateSharedTag(View view) {
        int id2 = view.getId();
        ViewParent parent = view.getParent();
        while (parent != null && !parent.getClass().getSimpleName().equals("Screen")) {
            parent = parent.getParent();
        }
        if (parent != null) {
            this.mNativeMethodsHolder.checkDuplicateSharedTag(id2, ((View) parent).getId());
        }
    }

    private static Point convertScreenLocationToViewCoordinates(Point point, View view) {
        int[] iArr = {0, 0};
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return new Point(point.x - iArr[0], point.y - iArr[1]);
    }

    private void maybeDropAncestors(View view) {
        int i10;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            while (view2 != null && !(view2 instanceof z0)) {
                View view3 = (View) view2.getParent();
                int id2 = view2.getId();
                Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id2));
                if (num != null) {
                    i10 = num.intValue() - 1;
                } else {
                    i10 = 0;
                }
                Integer valueOf = Integer.valueOf(i10);
                if (i10 <= 0) {
                    if (this.mAncestorsToRemove.contains(Integer.valueOf(id2))) {
                        this.mAncestorsToRemove.remove(Integer.valueOf(id2));
                        if (!this.mExitingViews.containsKey(Integer.valueOf(id2))) {
                            removeView(view2, (ViewGroup) view3);
                        }
                    }
                    this.mExitingSubviewCountMap.remove(Integer.valueOf(id2));
                } else {
                    this.mExitingSubviewCountMap.put(Integer.valueOf(id2), valueOf);
                }
                view2 = view3;
            }
        }
    }

    private void registerExitingAncestors(View view) {
        View view2 = (View) view.getParent();
        while (view2 != null && !(view2 instanceof z0)) {
            int id2 = view2.getId();
            Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id2));
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            this.mExitingSubviewCountMap.put(Integer.valueOf(id2), Integer.valueOf(i10));
            view2 = (View) view2.getParent();
        }
    }

    private boolean removeOrAnimateExitRecursive(View view, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int id2 = view.getId();
        ViewManager resolveViewManager = resolveViewManager(id2);
        if (resolveViewManager != null) {
            String name = resolveViewManager.getName();
            if (name.equals(ReactModalHostManager.REACT_CLASS) || name.equals(ScreenViewManager.REACT_CLASS) || name.equals(ScreenStackViewManager.REACT_CLASS)) {
                cancelAnimationsRecursive(view);
                return false;
            }
        }
        boolean shouldAnimateExiting = shouldAnimateExiting(id2, z11);
        if (!shouldAnimateExiting || (!hasAnimationForTag(id2, 2) && !this.mExitingViews.containsKey(Integer.valueOf(id2)))) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z10 || z12) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (hasAnimationForTag(id2, 4)) {
            this.mSharedTransitionManager.notifyAboutRemovedView(view);
            this.mSharedTransitionManager.makeSnapshot(view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z14 = false;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (removeOrAnimateExitRecursive(childAt, z13, shouldAnimateExiting)) {
                    z14 = true;
                } else if (z13 && childAt.getId() != -1) {
                    arrayList.add(childAt);
                }
            }
        } else {
            z14 = false;
        }
        if (z12 || z14) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z12) {
            HashMap<String, Object> prepareDataForAnimationWorklet = prepareDataForAnimationWorklet(new Snapshot(view, this.mReanimatedNativeHierarchyManager).toCurrentMap(), false);
            if (!this.mExitingViews.containsKey(Integer.valueOf(id2))) {
                this.mExitingViews.put(Integer.valueOf(id2), view);
                registerExitingAncestors(view);
                this.mNativeMethodsHolder.startAnimation(id2, 2, prepareDataForAnimationWorklet);
            }
        }
        this.mNativeMethodsHolder.clearAnimationConfig(id2);
        if (!z15) {
            return false;
        }
        if (z14) {
            if (id2 == -1) {
                cancelAnimationsRecursive(view);
                return false;
            }
            this.mAncestorsToRemove.add(Integer.valueOf(id2));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeView((View) it.next(), (ViewGroup) view);
        }
        return true;
    }

    private void removeView(View view, ViewGroup viewGroup) {
        int id2 = view.getId();
        if (this.mCallbacks.containsKey(Integer.valueOf(id2))) {
            Runnable runnable = this.mCallbacks.get(Integer.valueOf(id2));
            this.mCallbacks.remove(Integer.valueOf(id2));
            if (runnable != null) {
                runnable.run();
            }
        } else {
            this.mReanimatedNativeHierarchyManager.publicDropView(view);
        }
        if (viewGroup != null && viewGroup.indexOfChild(view) != -1) {
            viewGroup.removeView(view);
        }
    }

    private ViewManager resolveViewManager(int i10) {
        try {
            return this.mReanimatedNativeHierarchyManager.resolveViewManager(i10);
        } catch (Exception unused) {
            return null;
        }
    }

    public void cancelAnimationsInSubviews(View view) {
        cancelAnimationsRecursive(view);
        clearAnimationConfigRecursive(view);
    }

    public void cancelAnimationsRecursive(View view) {
        if (this.mExitingViews.containsKey(Integer.valueOf(view.getId()))) {
            endLayoutAnimation(view.getId(), true);
        } else if ((view instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(view.getId()))) {
            cancelAnimationsInSubviews((ViewGroup) view);
        }
    }

    public void clearAnimationConfigRecursive(View view) {
        this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                clearAnimationConfigRecursive(viewGroup.getChildAt(i10));
            }
        }
    }

    public void endLayoutAnimation(int i10, boolean z10) {
        View resolveView = resolveView(i10);
        if (resolveView != null) {
            Rect rect = this.mEnteringViewTargetValues.get(Integer.valueOf(i10));
            if (!z10 && this.mEnteringViews.contains(Integer.valueOf(i10)) && rect != null) {
                resolveView.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
            this.mEnteringViews.remove(Integer.valueOf(i10));
            this.mEnteringViewTargetValues.remove(Integer.valueOf(i10));
            if (z10) {
                if ((resolveView instanceof ViewGroup) && this.mAncestorsToRemove.contains(Integer.valueOf(i10))) {
                    cancelAnimationsInSubviews((ViewGroup) resolveView);
                }
                this.mExitingViews.remove(Integer.valueOf(i10));
                maybeDropAncestors(resolveView);
                removeView(resolveView, (ViewGroup) resolveView.getParent());
            }
            this.mSharedTransitionManager.finishSharedAnimation(i10);
        }
    }

    /* access modifiers changed from: protected */
    public ReactContext getContext() {
        return this.mContext;
    }

    public ReanimatedNativeHierarchyManager getReanimatedNativeHierarchyManager() {
        return this.mReanimatedNativeHierarchyManager;
    }

    public boolean hasAnimationForTag(int i10, int i11) {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        if (nativeMethodsHolder == null || !nativeMethodsHolder.hasAnimation(i10, i11)) {
            return false;
        }
        return true;
    }

    public void invalidate() {
        this.isInvalidated = true;
        this.mNativeMethodsHolder = null;
        this.mContext = null;
        this.mUIManager = null;
        this.mExitingViews = null;
        this.mExitingSubviewCountMap = null;
        this.mAncestorsToRemove = null;
        this.mCallbacks = null;
    }

    public boolean isLayoutAnimationEnabled() {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        if (nativeMethodsHolder == null || !nativeMethodsHolder.isLayoutAnimationEnabled()) {
            return false;
        }
        return true;
    }

    public void makeSnapshotOfTopScreenViews(ViewGroup viewGroup) {
        this.mSharedTransitionManager.doSnapshotForTopScreenViews(viewGroup);
    }

    public void maybeRegisterSharedView(View view) {
        if (hasAnimationForTag(view.getId(), 4)) {
            this.mSharedTransitionManager.notifyAboutNewView(view);
        }
    }

    public void navigationTabChanged(View view, View view2) {
        this.mSharedTransitionManager.navigationTabChanged(view, view2);
    }

    public void notifyAboutScreenWillDisappear() {
        this.mSharedTransitionManager.onScreenWillDisappear();
    }

    public void notifyAboutViewsRemoval(int[] iArr) {
        this.mSharedTransitionManager.onViewsRemoval(iArr);
    }

    public void onViewCreate(View view, ViewGroup viewGroup, Snapshot snapshot) {
        AndroidUIScheduler androidUIScheduler;
        if (!this.isInvalidated) {
            maybeRegisterSharedView(view);
            if (hasAnimationForTag(view.getId(), 1) && (androidUIScheduler = this.mWeakAndroidUIScheduler.get()) != null) {
                androidUIScheduler.triggerUI();
                int id2 = view.getId();
                HashMap<String, Object> targetMap = snapshot.toTargetMap();
                if (targetMap != null) {
                    this.mNativeMethodsHolder.startAnimation(id2, 1, prepareDataForAnimationWorklet(targetMap, true));
                    this.mEnteringViews.add(Integer.valueOf(id2));
                }
            }
        }
    }

    public void onViewRemoval(View view, ViewGroup viewGroup, Runnable runnable) {
        if (!this.isInvalidated) {
            this.mCallbacks.put(Integer.valueOf(view.getId()), runnable);
            if (!removeOrAnimateExitRecursive(view, true, true)) {
                removeView(view, viewGroup);
            }
        }
    }

    public void onViewUpdate(View view, Snapshot snapshot, Snapshot snapshot2) {
        if (!this.isInvalidated) {
            int id2 = view.getId();
            if (hasAnimationForTag(id2, 3)) {
                HashMap<String, Object> currentMap = snapshot.toCurrentMap();
                HashMap<String, Object> targetMap = snapshot2.toTargetMap();
                boolean z10 = true;
                for (int i10 = 0; i10 < Snapshot.targetKeysToTransform.size(); i10++) {
                    if (((Number) currentMap.get(Snapshot.currentKeysToTransform.get(i10))).doubleValue() != ((Number) targetMap.get(Snapshot.targetKeysToTransform.get(i10))).doubleValue()) {
                        z10 = false;
                    }
                }
                if (!z10) {
                    HashMap<String, Object> prepareDataForAnimationWorklet = prepareDataForAnimationWorklet(currentMap, false);
                    HashMap hashMap = new HashMap(prepareDataForAnimationWorklet(targetMap, true));
                    for (String next : prepareDataForAnimationWorklet.keySet()) {
                        hashMap.put(next, prepareDataForAnimationWorklet.get(next));
                    }
                    this.mNativeMethodsHolder.startAnimation(id2, 3, hashMap);
                }
            } else if (this.mEnteringViews.contains(Integer.valueOf(id2))) {
                HashMap<Integer, Rect> hashMap2 = this.mEnteringViewTargetValues;
                Integer valueOf = Integer.valueOf(id2);
                int i11 = snapshot2.originX;
                int i12 = snapshot2.originY;
                hashMap2.put(valueOf, new Rect(i11, i12, snapshot2.width + i11, snapshot2.height + i12));
                int i13 = snapshot.originX;
                int i14 = snapshot.originY;
                view.layout(i13, i14, snapshot.width + i13, snapshot.height + i14);
            }
        }
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> hashMap, boolean z10) {
        return prepareDataForAnimationWorklet(hashMap, z10, false);
    }

    public void printSubTree(View view, int i10) {
        if (i10 == 0) {
            Log.v("rea", "----------------------");
        }
        if (view != null) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                sb2.append("+");
            }
            sb2.append(" TAG:");
            sb2.append(view.getId());
            sb2.append(" CLASS:");
            sb2.append(view.getClass().getSimpleName());
            Log.v("rea", sb2.toString());
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i11 < viewGroup.getChildCount()) {
                        printSubTree(viewGroup.getChildAt(i11), i10 + 1);
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void progressLayoutAnimation(int i10, Map<String, Object> map, boolean z10) {
        ViewGroup viewGroup;
        View resolveView = resolveView(i10);
        if (resolveView != null && (viewGroup = (ViewGroup) resolveView.getParent()) != null) {
            ViewManager resolveViewManager = resolveViewManager(i10);
            ViewManager resolveViewManager2 = resolveViewManager(viewGroup.getId());
            if (resolveViewManager != null) {
                setNewProps(map, resolveView, resolveViewManager, resolveViewManager2, Integer.valueOf(viewGroup.getId()), z10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public View resolveView(int i10) {
        if (this.mExitingViews.containsKey(Integer.valueOf(i10))) {
            return this.mExitingViews.get(Integer.valueOf(i10));
        }
        View transitioningView = this.mSharedTransitionManager.getTransitioningView(i10);
        if (transitioningView != null) {
            return transitioningView;
        }
        try {
            return this.mUIManager.resolveView(i10);
        } catch (s unused) {
            return null;
        }
    }

    public void screenDidLayout(View view) {
        this.mSharedTransitionManager.screenDidLayout(view);
    }

    public void setAndroidUIScheduler(AndroidUIScheduler androidUIScheduler) {
        this.mWeakAndroidUIScheduler = new WeakReference<>(androidUIScheduler);
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
        this.mSharedTransitionManager.setNativeMethods(nativeMethodsHolder);
    }

    public void setNewProps(Map<String, Object> map, View view, ViewManager viewManager, ViewManager viewManager2, Integer num, boolean z10) {
        float b10;
        float b11;
        float b12;
        float b13;
        Map<String, Object> map2 = map;
        View view2 = view;
        if (map2.get(Snapshot.ORIGIN_X) != null) {
            b10 = ((Double) map2.get(Snapshot.ORIGIN_X)).floatValue();
        } else {
            b10 = g0.b((float) view.getLeft());
        }
        float f10 = b10;
        if (map2.get(Snapshot.ORIGIN_Y) != null) {
            b11 = ((Double) map2.get(Snapshot.ORIGIN_Y)).floatValue();
        } else {
            b11 = g0.b((float) view.getTop());
        }
        float f11 = b11;
        if (map2.get(Snapshot.WIDTH) != null) {
            b12 = ((Double) map2.get(Snapshot.WIDTH)).floatValue();
        } else {
            b12 = g0.b((float) view.getWidth());
        }
        float f12 = b12;
        if (map2.get(Snapshot.HEIGHT) != null) {
            b13 = ((Double) map2.get(Snapshot.HEIGHT)).floatValue();
        } else {
            b13 = g0.b((float) view.getHeight());
        }
        float f13 = b13;
        if (map2.containsKey(Snapshot.TRANSFORM_MATRIX)) {
            float[] fArr = new float[9];
            Object obj = map2.get(Snapshot.TRANSFORM_MATRIX);
            if (obj instanceof ReadableNativeArray) {
                ReadableNativeArray readableNativeArray = (ReadableNativeArray) obj;
                for (int i10 = 0; i10 < 9; i10++) {
                    fArr[i10] = Double.valueOf(readableNativeArray.getDouble(i10)).floatValue();
                }
            } else {
                ArrayList arrayList = (ArrayList) map2.get(Snapshot.TRANSFORM_MATRIX);
                for (int i11 = 0; i11 < 9; i11++) {
                    fArr[i11] = ((Float) arrayList.get(i11)).floatValue();
                }
            }
            view2.setScaleX(fArr[0]);
            view2.setScaleY(fArr[4]);
            map2.remove(Snapshot.TRANSFORM_MATRIX);
        }
        updateLayout(view, viewManager2, num.intValue(), f10, f11, f12, f13, z10);
        map2.remove(Snapshot.ORIGIN_X);
        map2.remove(Snapshot.ORIGIN_Y);
        map2.remove(Snapshot.GLOBAL_ORIGIN_X);
        map2.remove(Snapshot.GLOBAL_ORIGIN_Y);
        map2.remove(Snapshot.WIDTH);
        map2.remove(Snapshot.HEIGHT);
        if (map.size() != 0) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            for (String next : map.keySet()) {
                addProp(javaOnlyMap, next, map2.get(next));
            }
            viewManager.updateProperties(view2, new v0(javaOnlyMap));
        }
    }

    public void setReanimatedNativeHierarchyManager(ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager) {
        this.mReanimatedNativeHierarchyManager = reanimatedNativeHierarchyManager;
    }

    public boolean shouldAnimateExiting(int i10, boolean z10) {
        return this.mNativeMethodsHolder.shouldAnimateExiting(i10, z10);
    }

    public void updateLayout(View view, ViewManager viewManager, int i10, float f10, float f11, float f12, float f13, boolean z10) {
        int round = Math.round(g0.d(f10));
        int round2 = Math.round(g0.d(f11));
        int round3 = Math.round(g0.d(f12));
        int round4 = Math.round(g0.d(f13));
        view.measure(View.MeasureSpec.makeMeasureSpec(round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round4, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof z0) {
            parent.requestLayout();
        }
        if (i10 % 10 != 1 || viewManager == null) {
            if (z10) {
                Point convertScreenLocationToViewCoordinates = convertScreenLocationToViewCoordinates(new Point(round, round2), (View) view.getParent());
                round = convertScreenLocationToViewCoordinates.x;
                round2 = convertScreenLocationToViewCoordinates.y;
            }
            view.layout(round, round2, round3 + round, round4 + round2);
        } else if (!(viewManager instanceof r)) {
            throw new s("[Reanimated] Trying to use view with tag " + i10 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren.");
        } else if (!((r) viewManager).needsCustomLayoutForChildren()) {
            view.layout(round, round2, round3 + round, round4 + round2);
        }
    }

    public void viewDidLayout(View view) {
        this.mSharedTransitionManager.viewDidLayout(view);
    }

    public void visitNativeTreeAndMakeSnapshot(View view) {
        this.mSharedTransitionManager.visitNativeTreeAndMakeSnapshot(view);
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> hashMap, boolean z10, boolean z11) {
        ArrayList<String> arrayList;
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (z10) {
            arrayList = Snapshot.targetKeysToTransform;
        } else {
            arrayList = Snapshot.currentKeysToTransform;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap2.put(next, Float.valueOf(g0.b(Utils.convertToFloat(hashMap.get(next)))));
        }
        if (z11) {
            String str = z10 ? Snapshot.TARGET_TRANSFORM_MATRIX : Snapshot.CURRENT_TRANSFORM_MATRIX;
            hashMap2.put(str, hashMap.get(str));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i10 = displayMetrics.heightPixels;
            hashMap2.put("windowWidth", Float.valueOf(g0.b((float) displayMetrics.widthPixels)));
            hashMap2.put("windowHeight", Float.valueOf(g0.b((float) i10)));
        } else {
            hashMap2.put("windowWidth", Float.valueOf(g0.b(0.0f)));
            hashMap2.put("windowHeight", Float.valueOf(g0.b(0.0f)));
        }
        return hashMap2;
    }

    private void cancelAnimationsInSubviews(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null) {
                if (this.mExitingViews.containsKey(Integer.valueOf(childAt.getId()))) {
                    endLayoutAnimation(childAt.getId(), true);
                } else if ((childAt instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(childAt.getId()))) {
                    cancelAnimationsInSubviews((ViewGroup) childAt);
                }
            }
        }
    }
}

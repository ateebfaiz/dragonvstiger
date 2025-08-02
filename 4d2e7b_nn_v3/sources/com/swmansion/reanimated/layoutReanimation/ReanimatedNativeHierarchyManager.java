package com.swmansion.reanimated.layoutReanimation;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.a2;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.s;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ReanimatedNativeHierarchyManager extends ReanimatedNativeHierarchyManagerBase {
    private final HashMap<Integer, Runnable> cleanerCallback = new HashMap<>();
    private boolean initOk = true;
    private final HashMap<Integer, Set<Integer>> mPendingDeletionsForTag = new HashMap<>();
    private final ReaLayoutAnimator mReaLayoutAnimator;
    private final TabNavigatorObserver mTabNavigatorObserver;
    private final HashMap<Integer, ArrayList<View>> toBeRemoved = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReanimatedNativeHierarchyManager(i2 i2Var, ReactApplicationContext reactApplicationContext) {
        super(i2Var);
        Class<Field> cls = Field.class;
        ReaLayoutAnimator reaLayoutAnimator = new ReaLayoutAnimator(reactApplicationContext, this);
        this.mReaLayoutAnimator = reaLayoutAnimator;
        this.mTabNavigatorObserver = new TabNavigatorObserver(reaLayoutAnimator);
        Class<? super Object> superclass = getClass().getSuperclass().getSuperclass();
        if (superclass == null) {
            Log.e("reanimated", "unable to resolve NativeViewHierarchyManager class from ReanimatedNativeHierarchyManager");
            return;
        }
        try {
            Field declaredField = superclass.getDeclaredField("mLayoutAnimator");
            declaredField.setAccessible(true);
            try {
                Field declaredField2 = cls.getDeclaredField("accessFlags");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
            } catch (IllegalAccessException | NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            declaredField.set(this, this.mReaLayoutAnimator);
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            this.initOk = false;
            e11.printStackTrace();
        }
        try {
            Field declaredField3 = superclass.getDeclaredField("mPendingDeletionsForTag");
            declaredField3.setAccessible(true);
            try {
                Field declaredField4 = cls.getDeclaredField("accessFlags");
                declaredField4.setAccessible(true);
                declaredField4.setInt(declaredField3, declaredField3.getModifiers() & -17);
            } catch (IllegalAccessException | NoSuchFieldException e12) {
                e12.printStackTrace();
            }
            declaredField3.set(this, this.mPendingDeletionsForTag);
        } catch (IllegalAccessException | NoSuchFieldException e13) {
            this.initOk = false;
            e13.printStackTrace();
        }
        if (this.initOk) {
            setLayoutAnimationEnabled(true);
        }
    }

    private boolean checkIfTopScreenHasHeader(ViewGroup viewGroup) {
        try {
            View childAt = ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(0)).getChildAt(0);
            Field declaredField = childAt.getClass().getDeclaredField("mIsHidden");
            declaredField.setAccessible(true);
            return !declaredField.getBoolean(childAt);
        } catch (IllegalAccessException | NoSuchFieldException | NullPointerException unused) {
            return false;
        }
    }

    private boolean isLayoutAnimationDisabled() {
        if (!this.initOk || !this.mReaLayoutAnimator.isLayoutAnimationEnabled()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$manageChildren$0(ArrayList arrayList, View view, ViewGroupManager viewGroupManager, ViewGroup viewGroup) {
        arrayList.remove(view);
        viewGroupManager.removeView(viewGroup, view);
    }

    /* access modifiers changed from: protected */
    public synchronized void dropView(View view) {
        if (isLayoutAnimationDisabled()) {
            super.dropView(view);
            return;
        }
        if (this.toBeRemoved.containsKey(Integer.valueOf(view.getId()))) {
            this.toBeRemoved.remove(Integer.valueOf(view.getId()));
        }
        if (this.cleanerCallback.containsKey(Integer.valueOf(view.getId()))) {
            this.cleanerCallback.remove(Integer.valueOf(view.getId()));
            this.cleanerCallback.get(Integer.valueOf(view.getId())).run();
        }
        super.dropView(view);
    }

    public synchronized void manageChildren(int i10, @Nullable int[] iArr, @Nullable a2[] a2VarArr, @Nullable int[] iArr2) {
        Set set;
        if (isLayoutAnimationDisabled()) {
            super.manageChildren(i10, iArr, a2VarArr, iArr2);
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) resolveView(i10);
            ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i10);
            AnimationsManager animationsManager = this.mReaLayoutAnimator.getAnimationsManager();
            int i11 = 0;
            if (viewGroupManager.getName().equals(ScreenStackViewManager.REACT_CLASS)) {
                if (iArr2 == null) {
                    animationsManager.makeSnapshotOfTopScreenViews(viewGroup);
                } else {
                    animationsManager.notifyAboutViewsRemoval(iArr2);
                }
                if (iArr != null && (this.mReaLayoutAnimator instanceof ReaLayoutAnimator)) {
                    int length = iArr.length;
                    while (i11 < length) {
                        this.mReaLayoutAnimator.getAnimationsManager().cancelAnimationsInSubviews(viewGroupManager.getChildAt(viewGroup, iArr[i11]));
                        i11++;
                    }
                }
                super.manageChildren(i10, iArr, a2VarArr, iArr2);
                return;
            }
            if (this.toBeRemoved.containsKey(Integer.valueOf(i10))) {
                HashSet hashSet = new HashSet();
                Iterator it = this.toBeRemoved.get(Integer.valueOf(i10)).iterator();
                while (it.hasNext()) {
                    hashSet.add(Integer.valueOf(((View) it.next()).getId()));
                }
                while (viewGroupManager.getChildCount(viewGroup) != 0 && hashSet.contains(Integer.valueOf(viewGroupManager.getChildAt(viewGroup, viewGroupManager.getChildCount(viewGroup) - 1).getId()))) {
                    viewGroupManager.removeViewAt(viewGroup, viewGroupManager.getChildCount(viewGroup) - 1);
                }
            }
            if (iArr2 != null) {
                if (!this.toBeRemoved.containsKey(Integer.valueOf(i10))) {
                    this.toBeRemoved.put(Integer.valueOf(i10), new ArrayList());
                }
                ArrayList arrayList = this.toBeRemoved.get(Integer.valueOf(i10));
                int length2 = iArr2.length;
                while (i11 < length2) {
                    try {
                        View resolveView = resolveView(iArr2[i11]);
                        arrayList.add(resolveView);
                        this.cleanerCallback.put(Integer.valueOf(resolveView.getId()), new c(arrayList, resolveView, viewGroupManager, viewGroup));
                    } catch (s e10) {
                        e10.printStackTrace();
                    }
                    i11++;
                }
            }
            HashMap<Integer, Set<Integer>> hashMap = this.mPendingDeletionsForTag;
            if (!(hashMap == null || (set = hashMap.get(Integer.valueOf(i10))) == null)) {
                set.clear();
            }
            animationsManager.notifyAboutViewsRemoval(iArr2);
            super.manageChildren(i10, iArr, a2VarArr, (int[]) null);
            if (this.toBeRemoved.containsKey(Integer.valueOf(i10))) {
                Iterator it2 = this.toBeRemoved.get(Integer.valueOf(i10)).iterator();
                while (it2.hasNext()) {
                    viewGroupManager.addView(viewGroup, (View) it2.next(), viewGroupManager.getChildCount(viewGroup));
                }
            }
            super.manageChildren(i10, (int[]) null, (a2[]) null, iArr2);
        } catch (s e11) {
            e11.printStackTrace();
            super.manageChildren(i10, iArr, a2VarArr, iArr2);
        }
    }

    public void publicDropView(View view) {
        dropView(view);
    }

    public synchronized void updateLayoutCommon(int i10, int i11, int i12, int i13, int i14, int i15) {
        ReaLayoutAnimator reaLayoutAnimator;
        try {
            if (!isLayoutAnimationDisabled()) {
                String name = resolveViewManager(i11).getName();
                View resolveView = resolveView(i10);
                if (!(resolveView == null || !name.equals(ScreenViewManager.REACT_CLASS) || this.mReaLayoutAnimator == null)) {
                    if (checkIfTopScreenHasHeader((ViewGroup) resolveView)) {
                        if (!resolveView.isLayoutRequested()) {
                        }
                        View resolveView2 = resolveView(i11);
                        View view = (View) resolveView2.getParent();
                        if (view != null && ScreensHelper.isScreenContainer((View) view.getParent())) {
                            this.mTabNavigatorObserver.handleScreenContainerUpdate(resolveView2);
                        }
                    }
                    this.mReaLayoutAnimator.getAnimationsManager().screenDidLayout(resolveView);
                    View resolveView22 = resolveView(i11);
                    View view2 = (View) resolveView22.getParent();
                    this.mTabNavigatorObserver.handleScreenContainerUpdate(resolveView22);
                }
                View resolveView3 = resolveView(i11);
                if (!(resolveView3 == null || (reaLayoutAnimator = this.mReaLayoutAnimator) == null)) {
                    reaLayoutAnimator.getAnimationsManager().viewDidLayout(resolveView3);
                }
            }
        } catch (s e10) {
            e10.printStackTrace();
        } catch (Throwable th) {
            throw th;
        }
    }
}

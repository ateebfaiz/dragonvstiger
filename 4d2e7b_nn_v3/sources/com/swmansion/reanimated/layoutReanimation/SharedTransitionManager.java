package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.i;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.s;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.reanimated.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SharedTransitionManager {
    /* access modifiers changed from: private */
    public final List<View> mAddedSharedViews = new ArrayList();
    /* access modifiers changed from: private */
    public final AnimationsManager mAnimationsManager;
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private boolean mIsTransitionPrepared = false;
    private NativeMethodsHolder mNativeMethodsHolder;
    private final Set<View> mReattachedViews = new HashSet();
    /* access modifiers changed from: private */
    public final List<View> mRemovedSharedViews = new ArrayList();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, SharedElement> mSharedElementsLookup = new HashMap();
    private final List<SharedElement> mSharedElementsWithAnimation = new ArrayList();
    private final List<SharedElement> mSharedElementsWithProgress = new ArrayList();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, SortedSet<Integer>> mSharedViewChildrenIndices = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    /* access modifiers changed from: private */
    public final Set<Integer> mTagsToCleanup = new HashSet();
    private View mTransitionContainer;
    private final Set<Integer> mViewTagsToHide = new HashSet();

    class PrepareConfigCleanupTreeVisitor implements TreeVisitor {
        PrepareConfigCleanupTreeVisitor() {
        }

        public void run(View view) {
            SharedTransitionManager.this.mTagsToCleanup.add(Integer.valueOf(view.getId()));
        }
    }

    class SnapshotTreeVisitor implements TreeVisitor {
        SnapshotTreeVisitor() {
        }

        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }
    }

    class TopWillAppearListener implements i {
        private final e mEventDispatcher;

        public TopWillAppearListener(e eVar) {
            this.mEventDispatcher = eVar;
        }

        public void onEventDispatch(d dVar) {
            if (dVar.getEventName().equals("topWillAppear")) {
                SharedTransitionManager sharedTransitionManager = SharedTransitionManager.this;
                boolean unused = sharedTransitionManager.tryStartSharedTransitionForViews(sharedTransitionManager.mAddedSharedViews, true);
                SharedTransitionManager.this.mAddedSharedViews.clear();
                this.mEventDispatcher.j(this);
            }
        }
    }

    interface TreeVisitor {
        void run(View view);
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    private void clearAllSharedConfigsForView(View view) {
        int id2 = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id2));
        this.mNativeMethodsHolder.clearAnimationConfig(id2);
    }

    private void disableCleaningForViewTag(int i10) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i10));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i10), 1);
        }
    }

    private void enableCleaningForViewTag(int i10) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                this.mDisableCleaningForViewTag.remove(Integer.valueOf(i10));
            } else {
                this.mDisableCleaningForViewTag.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    private View findScreen(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("Screen")) {
                return (View) parent;
            }
        }
        return null;
    }

    private void findSharedViewsForScreen(View view, List<View> list) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                list.add(topScreenForStack);
            }
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                findSharedViewsForScreen(viewGroup.getChildAt(i10), list);
            }
        }
    }

    private View findStack(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("ScreenStack")) {
                return (View) parent;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.swmansion.reanimated.layoutReanimation.SharedElement> getSharedElementsForCurrentTransition(java.util.List<android.view.View> r20, boolean r21) {
        /*
            r19 = this;
            r0 = r19
            java.util.Set<android.view.View> r1 = r0.mReattachedViews
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            if (r21 != 0) goto L_0x0035
            java.util.Iterator r6 = r20.iterator()
        L_0x001d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0035
            java.lang.Object r7 = r6.next()
            android.view.View r7 = (android.view.View) r7
            int r7 = r7.getId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.add(r7)
            goto L_0x001d
        L_0x0035:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.swmansion.reanimated.layoutReanimation.AnimationsManager r7 = r0.mAnimationsManager
            com.swmansion.reanimated.layoutReanimation.ReanimatedNativeHierarchyManager r7 = r7.getReanimatedNativeHierarchyManager()
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.util.List<android.view.View> r9 = r0.mRemovedSharedViews
            java.util.Iterator r9 = r9.iterator()
        L_0x004b:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0063
            java.lang.Object r10 = r9.next()
            android.view.View r10 = (android.view.View) r10
            int r10 = r10.getId()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.add(r10)
            goto L_0x004b
        L_0x0063:
            java.util.Iterator r9 = r20.iterator()
        L_0x0067:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01b6
            java.lang.Object r10 = r9.next()
            android.view.View r10 = (android.view.View) r10
            com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder r11 = r0.mNativeMethodsHolder
            int r12 = r10.getId()
            int r11 = r11.findPrecedingViewTagForTransition(r12)
            if (r1 == 0) goto L_0x0099
        L_0x007f:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            boolean r12 = r8.contains(r12)
            if (r12 == 0) goto L_0x0099
            com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder r12 = r0.mNativeMethodsHolder
            r12.clearAnimationConfig(r11)
            com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder r11 = r0.mNativeMethodsHolder
            int r12 = r10.getId()
            int r11 = r11.findPrecedingViewTagForTransition(r12)
            goto L_0x007f
        L_0x0099:
            if (r21 != 0) goto L_0x00a7
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            boolean r12 = r5.contains(r12)
            if (r12 == 0) goto L_0x00a7
            r12 = 1
            goto L_0x00a8
        L_0x00a7:
            r12 = 0
        L_0x00a8:
            if (r11 >= 0) goto L_0x00ab
            goto L_0x0067
        L_0x00ab:
            android.view.View r11 = r7.resolveView(r11)
            android.view.View r11 = r0.maybeOverrideSiblingForTabNavigator(r10, r11)
            if (r21 == 0) goto L_0x00ba
            r18 = r11
            r11 = r10
            r10 = r18
        L_0x00ba:
            if (r12 == 0) goto L_0x00c3
            r0.clearAllSharedConfigsForView(r10)
            r0.clearAllSharedConfigsForView(r11)
            goto L_0x0067
        L_0x00c3:
            java.util.Map<java.lang.Integer, android.view.View> r12 = r0.mCurrentSharedTransitionViews
            int r13 = r10.getId()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            boolean r12 = r12.containsKey(r13)
            if (r12 != 0) goto L_0x0159
            android.view.View r13 = r0.findScreen(r10)
            android.view.View r14 = r0.findScreen(r11)
            if (r13 == 0) goto L_0x0067
            if (r14 != 0) goto L_0x00e0
            goto L_0x0067
        L_0x00e0:
            android.view.View r15 = r0.findStack(r13)
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15
            if (r15 != 0) goto L_0x00ea
            goto L_0x0067
        L_0x00ea:
            int r3 = r15.getId()
            com.facebook.react.uimanager.ViewManager r3 = r7.resolveViewManager(r3)
            com.facebook.react.uimanager.ViewGroupManager r3 = (com.facebook.react.uimanager.ViewGroupManager) r3
            r17 = r1
            r2 = 0
            r16 = 0
        L_0x00f9:
            int r1 = r3.getChildCount(r15)
            if (r2 >= r1) goto L_0x010a
            android.view.View r1 = r3.getChildAt(r15, (int) r2)
            if (r1 != r14) goto L_0x0107
            r16 = 1
        L_0x0107:
            int r2 = r2 + 1
            goto L_0x00f9
        L_0x010a:
            if (r16 == 0) goto L_0x015b
            int r1 = r15.getId()
            com.facebook.react.uimanager.ViewManager r1 = r7.resolveViewManager(r1)
            com.facebook.react.uimanager.ViewGroupManager r1 = (com.facebook.react.uimanager.ViewGroupManager) r1
            int r2 = r1.getChildCount(r15)
            r3 = 2
            if (r2 >= r3) goto L_0x0121
        L_0x011d:
            r1 = r17
            goto L_0x0067
        L_0x0121:
            int r3 = r2 + -1
            android.view.View r3 = r1.getChildAt(r15, (int) r3)
            int r2 = r2 + -2
            android.view.View r1 = r1.getChildAt(r15, (int) r2)
            if (r21 == 0) goto L_0x0144
            int r1 = r1.getId()
            int r2 = r13.getId()
            if (r1 != r2) goto L_0x011d
            int r1 = r3.getId()
            int r2 = r14.getId()
            if (r1 != r2) goto L_0x011d
            goto L_0x015b
        L_0x0144:
            int r2 = r3.getId()
            int r3 = r13.getId()
            if (r2 != r3) goto L_0x011d
            int r1 = r1.getId()
            int r2 = r14.getId()
            if (r1 != r2) goto L_0x011d
            goto L_0x015b
        L_0x0159:
            r17 = r1
        L_0x015b:
            r1 = 0
            if (r21 == 0) goto L_0x017a
            java.util.Set<java.lang.Integer> r2 = r0.mViewTagsToHide
            int r3 = r10.getId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.add(r3)
            if (r12 == 0) goto L_0x0173
            com.swmansion.reanimated.layoutReanimation.Snapshot r1 = new com.swmansion.reanimated.layoutReanimation.Snapshot
            r1.<init>(r10)
            goto L_0x0176
        L_0x0173:
            r0.makeSnapshot(r10)
        L_0x0176:
            r0.makeSnapshot(r11)
            goto L_0x017f
        L_0x017a:
            if (r12 == 0) goto L_0x017f
            r0.makeSnapshot(r10)
        L_0x017f:
            if (r1 != 0) goto L_0x0191
            java.util.Map<java.lang.Integer, com.swmansion.reanimated.layoutReanimation.Snapshot> r1 = r0.mSnapshotRegistry
            int r2 = r10.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r1.get(r2)
            com.swmansion.reanimated.layoutReanimation.Snapshot r1 = (com.swmansion.reanimated.layoutReanimation.Snapshot) r1
        L_0x0191:
            java.util.Map<java.lang.Integer, com.swmansion.reanimated.layoutReanimation.Snapshot> r2 = r0.mSnapshotRegistry
            int r3 = r11.getId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            com.swmansion.reanimated.layoutReanimation.Snapshot r2 = (com.swmansion.reanimated.layoutReanimation.Snapshot) r2
            if (r2 != 0) goto L_0x01a6
            r0.makeSnapshot(r11)
        L_0x01a6:
            r4.add(r10)
            r4.add(r11)
            com.swmansion.reanimated.layoutReanimation.SharedElement r3 = new com.swmansion.reanimated.layoutReanimation.SharedElement
            r3.<init>(r10, r1, r11, r2)
            r6.add(r3)
            goto L_0x011d
        L_0x01b6:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x0241
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.swmansion.reanimated.layoutReanimation.SharedElement> r2 = r0.mSharedElements
            java.util.Iterator r2 = r2.iterator()
        L_0x01c7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01d9
            java.lang.Object r3 = r2.next()
            com.swmansion.reanimated.layoutReanimation.SharedElement r3 = (com.swmansion.reanimated.layoutReanimation.SharedElement) r3
            android.view.View r3 = r3.sourceView
            r1.add(r3)
            goto L_0x01c7
        L_0x01d9:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.Iterator r3 = r6.iterator()
        L_0x01e2:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01f4
            java.lang.Object r5 = r3.next()
            com.swmansion.reanimated.layoutReanimation.SharedElement r5 = (com.swmansion.reanimated.layoutReanimation.SharedElement) r5
            android.view.View r5 = r5.sourceView
            r2.add(r5)
            goto L_0x01e2
        L_0x01f4:
            java.util.Iterator r1 = r1.iterator()
        L_0x01f8:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x021e
            java.lang.Object r3 = r1.next()
            android.view.View r3 = (android.view.View) r3
            boolean r5 = r2.contains(r3)
            if (r5 != 0) goto L_0x021c
            java.util.Set<java.lang.Integer> r5 = r0.mViewTagsToHide
            int r7 = r3.getId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5.remove(r7)
            r5 = 0
            r3.setVisibility(r5)
            goto L_0x01f8
        L_0x021c:
            r5 = 0
            goto L_0x01f8
        L_0x021e:
            java.util.Map<java.lang.Integer, android.view.View> r1 = r0.mCurrentSharedTransitionViews
            r1.clear()
            java.util.Iterator r1 = r4.iterator()
        L_0x0227:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0241
            java.lang.Object r2 = r1.next()
            android.view.View r2 = (android.view.View) r2
            java.util.Map<java.lang.Integer, android.view.View> r3 = r0.mCurrentSharedTransitionViews
            int r4 = r2.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.put(r4, r2)
            goto L_0x0227
        L_0x0241:
            r0.mSharedElements = r6
            java.util.Iterator r1 = r6.iterator()
        L_0x0247:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0263
            java.lang.Object r2 = r1.next()
            com.swmansion.reanimated.layoutReanimation.SharedElement r2 = (com.swmansion.reanimated.layoutReanimation.SharedElement) r2
            java.util.Map<java.lang.Integer, com.swmansion.reanimated.layoutReanimation.SharedElement> r3 = r0.mSharedElementsLookup
            android.view.View r4 = r2.sourceView
            int r4 = r4.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.put(r4, r2)
            goto L_0x0247
        L_0x0263:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.SharedTransitionManager.getSharedElementsForCurrentTransition(java.util.List, boolean):java.util.List");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$finishSharedAnimation$1(ViewParent viewParent) {
        if (this.mReattachedViews.size() <= 0) {
            ((ViewGroup) viewParent).removeView(this.mTransitionContainer);
        }
    }

    private View maybeOverrideSiblingForTabNavigator(View view, View view2) {
        View tabNavigator = ScreensHelper.getTabNavigator(view);
        if (tabNavigator == null) {
            return view2;
        }
        int id2 = view2.getId();
        int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view.getId());
        int i10 = -1;
        for (int i11 = 0; i11 < sharedGroup.length; i11++) {
            if (sharedGroup[i11] == id2) {
                i10 = i11;
            }
        }
        while (i10 >= 0) {
            View resolveView = this.mAnimationsManager.resolveView(sharedGroup[i10]);
            if (tabNavigator == ScreensHelper.getTabNavigator(resolveView)) {
                return resolveView;
            }
            i10--;
        }
        return view2;
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SharedElement next : this.mSharedElements) {
                if (next.targetView == view2) {
                    arrayList.add(next);
                    View view3 = next.sourceView;
                    View view4 = next.targetView;
                    Snapshot snapshot = new Snapshot(view3);
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                    Snapshot snapshot3 = new Snapshot(view4);
                    int i10 = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                    int i11 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                    snapshot2.originX = i10;
                    snapshot2.originY = i11;
                    snapshot2.globalOriginX = i10;
                    snapshot2.globalOriginY = i11;
                    snapshot2.originXByParent = snapshot3.originXByParent;
                    snapshot2.originYByParent = snapshot3.originYByParent;
                    snapshot2.height = snapshot3.height;
                    snapshot2.width = snapshot3.width;
                    next.sourceViewSnapshot = snapshot;
                    next.targetViewSnapshot = snapshot2;
                    disableCleaningForViewTag(view3.getId());
                    disableCleaningForViewTag(view4.getId());
                }
            }
            startSharedTransition(arrayList, 4);
        }
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        for (SharedElement sharedElement : list) {
            View view = sharedElement.sourceView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int id2 = viewGroup.getId();
                int indexOfChild = viewGroup.indexOfChild(view);
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(indexOfChild));
                SortedSet sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id2));
                if (sortedSet == null) {
                    this.mSharedViewChildrenIndices.put(Integer.valueOf(id2), new TreeSet(Collections.singleton(Integer.valueOf(indexOfChild))));
                } else {
                    sortedSet.add(Integer.valueOf(indexOfChild));
                }
            }
        }
        for (SharedElement sharedElement2 : list) {
            View view2 = sharedElement2.sourceView;
            ((ViewGroup) view2.getParent()).removeView(view2);
            ((ViewGroup) this.mTransitionContainer).addView(view2);
            this.mReattachedViews.add(view2);
        }
    }

    private void setupTransitionContainer() {
        Activity currentActivity;
        if (this.mTransitionContainer == null) {
            this.mTransitionContainer = new ReactViewGroup(this.mAnimationsManager.getContext());
        }
        if (this.mTransitionContainer.getParent() == null && (currentActivity = this.mAnimationsManager.getContext().getCurrentActivity()) != null) {
            ((ViewGroup) currentActivity.getWindow().getDecorView().getRootView()).addView(this.mTransitionContainer);
            this.mTransitionContainer.bringToFront();
        }
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, new d());
    }

    private void startPreparedTransitions() {
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
        startSharedTransition(this.mSharedElementsWithProgress, 5);
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2, int i10) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> prepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap hashMap = new HashMap(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        hashMap.putAll(prepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), i10, hashMap);
    }

    private void startSharedTransition(List<SharedElement> list, int i10) {
        for (SharedElement next : list) {
            View view = next.sourceView;
            view.setVisibility(0);
            startSharedAnimationForView(view, next.sourceViewSnapshot, next.targetViewSnapshot, i10);
            next.targetView.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public boolean tryStartSharedTransitionForViews(List<View> list, boolean z10) {
        if (!prepareSharedTransition(list, z10)) {
            return false;
        }
        startPreparedTransitions();
        return true;
    }

    private void visitTree(View view, TreeVisitor treeVisitor) {
        ViewGroupManager viewGroupManager;
        int id2 = view.getId();
        if (id2 != -1) {
            ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
            try {
                treeVisitor.run(view);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewManager resolveViewManager = reanimatedNativeHierarchyManager.resolveViewManager(id2);
                    if (resolveViewManager instanceof ViewGroupManager) {
                        viewGroupManager = (ViewGroupManager) resolveViewManager;
                    } else {
                        viewGroupManager = null;
                    }
                    if (viewGroupManager != null) {
                        for (int i10 = 0; i10 < viewGroupManager.getChildCount(viewGroup); i10++) {
                            visitTree(viewGroupManager.getChildAt(viewGroup, i10), treeVisitor);
                        }
                    }
                }
            } catch (s unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                Log.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finishSharedAnimation(int i10) {
        ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i10))) {
            enableCleaningForViewTag(i10);
            return;
        }
        SharedElement sharedElement = this.mSharedElementsLookup.get(Integer.valueOf(i10));
        if (sharedElement != null) {
            this.mSharedElementsLookup.remove(Integer.valueOf(i10));
            View view = sharedElement.sourceView;
            if (this.mReattachedViews.contains(view)) {
                this.mReattachedViews.remove(view);
                int id2 = view.getId();
                ((ViewGroup) this.mTransitionContainer).removeView(view);
                Integer num = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id2));
                int intValue = num.intValue();
                ViewGroup viewGroup = (ViewGroup) this.mSharedTransitionParent.get(Integer.valueOf(id2));
                int id3 = viewGroup.getId();
                SortedSet sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id3));
                int size = sortedSet.headSet(num).size();
                sortedSet.remove(num);
                if (sortedSet.isEmpty()) {
                    this.mSharedViewChildrenIndices.remove(Integer.valueOf(id3));
                }
                int i11 = intValue - size;
                if (i11 <= viewGroup.getChildCount()) {
                    viewGroup.addView(view, i11);
                } else {
                    viewGroup.addView(view);
                }
                Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id2));
                if (snapshot != null) {
                    int i12 = snapshot.originX;
                    int i13 = snapshot.originY;
                    if (findStack(view) == null) {
                        snapshot.originX = snapshot.originXByParent;
                        snapshot.originY = snapshot.originYByParent;
                    }
                    HashMap<String, Object> basicMap = snapshot.toBasicMap();
                    HashMap hashMap = new HashMap();
                    for (String next : basicMap.keySet()) {
                        Object obj = basicMap.get(next);
                        if (next.equals(Snapshot.TRANSFORM_MATRIX)) {
                            hashMap.put(next, obj);
                        } else {
                            hashMap.put(next, Double.valueOf((double) g0.b(Utils.convertToFloat(obj))));
                        }
                    }
                    this.mAnimationsManager.progressLayoutAnimation(id2, hashMap, true);
                    snapshot.originX = i12;
                    snapshot.originY = i13;
                }
                if (this.mViewTagsToHide.contains(Integer.valueOf(i10))) {
                    view.setVisibility(4);
                }
                this.mCurrentSharedTransitionViews.remove(Integer.valueOf(sharedElement.targetView.getId()));
                this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id2));
                this.mSharedTransitionParent.remove(Integer.valueOf(id2));
                this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id2));
            }
            sharedElement.targetView.setVisibility(0);
            if (this.mRemovedSharedViews.contains(view)) {
                this.mRemovedSharedViews.remove(view);
                this.mSnapshotRegistry.remove(Integer.valueOf(view.getId()));
                this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
            }
            if (this.mReattachedViews.isEmpty()) {
                View view2 = this.mTransitionContainer;
                if (!(view2 == null || (parent = view2.getParent()) == null)) {
                    this.mTransitionContainer.post(new e(this, parent));
                }
                this.mSharedElements.clear();
                this.mSharedElementsWithProgress.clear();
                this.mSharedElementsWithAnimation.clear();
                this.mViewTagsToHide.clear();
            }
        }
    }

    /* access modifiers changed from: protected */
    public View getTransitioningView(int i10) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i10));
    }

    /* access modifiers changed from: protected */
    public void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    public void navigationTabChanged(View view, View view2) {
        Snapshot snapshot;
        this.mAddedSharedViews.clear();
        ArrayList<SharedElement> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        findSharedViewsForScreen(view, arrayList2);
        sortViewsByTags(arrayList2);
        for (View view3 : arrayList2) {
            int[] sharedGroup = this.mNativeMethodsHolder.getSharedGroup(view3.getId());
            int length = sharedGroup.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                View resolveView = this.mAnimationsManager.resolveView(sharedGroup[length]);
                if (ScreensHelper.isViewChildOfScreen(resolveView, view2) && (snapshot = this.mSnapshotRegistry.get(Integer.valueOf(view3.getId()))) != null) {
                    arrayList.add(new SharedElement(view3, snapshot, resolveView, new Snapshot(resolveView)));
                    break;
                }
                length--;
            }
        }
        if (!arrayList.isEmpty()) {
            this.mSharedElements = arrayList;
            this.mSharedElementsWithAnimation.clear();
            for (SharedElement sharedElement : arrayList) {
                this.mSharedElementsLookup.put(Integer.valueOf(sharedElement.sourceView.getId()), sharedElement);
                this.mSharedElementsWithAnimation.add(sharedElement);
            }
            setupTransitionContainer();
            reparentSharedViewsForCurrentTransition(arrayList);
            startSharedTransition(this.mSharedElementsWithAnimation, 4);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    public void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    public void onScreenWillDisappear() {
        for (Integer intValue : this.mTagsToCleanup) {
            this.mNativeMethodsHolder.clearAnimationConfig(intValue.intValue());
        }
        this.mTagsToCleanup.clear();
        if (this.mIsTransitionPrepared) {
            this.mIsTransitionPrepared = false;
            for (SharedElement next : this.mSharedElementsWithAnimation) {
                next.targetViewSnapshot = new Snapshot(next.targetView);
            }
            for (SharedElement next2 : this.mSharedElementsWithProgress) {
                next2.targetViewSnapshot = new Snapshot(next2.targetView);
            }
            startPreparedTransitions();
        }
    }

    /* access modifiers changed from: protected */
    public void onViewsRemoval(int[] iArr) {
        if (iArr != null) {
            visitTreeForTags(iArr, new SnapshotTreeVisitor());
            if (this.mRemovedSharedViews.size() > 0) {
                boolean prepareSharedTransition = prepareSharedTransition(this.mRemovedSharedViews, false);
                this.mIsTransitionPrepared = prepareSharedTransition;
                if (!prepareSharedTransition) {
                    this.mRemovedSharedViews.clear();
                }
                visitTreeForTags(iArr, new PrepareConfigCleanupTreeVisitor());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void orderByAnimationTypes(List<SharedElement> list) {
        this.mSharedElementsWithProgress.clear();
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement next : list) {
            if (this.mAnimationsManager.hasAnimationForTag(next.sourceView.getId(), 5)) {
                this.mSharedElementsWithProgress.add(next);
            } else {
                this.mSharedElementsWithAnimation.add(next);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean prepareSharedTransition(List<View> list, boolean z10) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z10);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        orderByAnimationTypes(sharedElementsForCurrentTransition);
        return true;
    }

    /* access modifiers changed from: protected */
    public void screenDidLayout(View view) {
        e c10;
        if (!this.mAddedSharedViews.isEmpty() && (c10 = k1.c((ReactContext) view.getContext(), view.getId())) != null) {
            c10.b(new TopWillAppearListener(c10));
        }
    }

    /* access modifiers changed from: protected */
    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    /* access modifiers changed from: protected */
    public void viewDidLayout(View view) {
    }

    /* access modifiers changed from: package-private */
    public void visitNativeTreeAndMakeSnapshot(View view) {
        View topScreenForStack = ScreensHelper.getTopScreenForStack(view);
        if (topScreenForStack instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) topScreenForStack;
            if (this.mAnimationsManager.hasAnimationForTag(topScreenForStack.getId(), 4)) {
                makeSnapshot(topScreenForStack);
            }
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i10));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr != null) {
            ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
            for (int resolveView : iArr) {
                visitTree(reanimatedNativeHierarchyManager.resolveView(resolveView), treeVisitor);
            }
        }
    }
}

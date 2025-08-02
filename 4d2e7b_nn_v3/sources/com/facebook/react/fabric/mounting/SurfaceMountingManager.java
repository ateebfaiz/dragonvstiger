package com.facebook.react.fabric.mounting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.collection.SparseArrayCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.GuardedFrameCallback;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.i2;
import com.facebook.react.uimanager.p0;
import com.facebook.react.uimanager.q;
import com.facebook.react.uimanager.r0;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.v0;
import com.facebook.react.uimanager.z0;
import g7.a;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = "SurfaceMountingManager";
    /* access modifiers changed from: private */
    public final Set<Integer> mErroneouslyReaddedReactTags = new HashSet();
    private volatile boolean mIsStopped = false;
    private a mJSResponderHandler;
    private MountingManager.MountItemExecutor mMountItemExecutor;
    private Queue<MountItem> mOnViewAttachMountItems = new ArrayDeque();
    /* access modifiers changed from: private */
    public final Stack<Integer> mReactTagsToRemove = new Stack<>();
    @Nullable
    private RemoveDeleteTreeUIFrameCallback mRemoveDeleteTreeUIFrameCallback;
    private volatile boolean mRootViewAttached = false;
    private RootViewManager mRootViewManager;
    private final int mSurfaceId;
    private SparseArrayCompat<Object> mTagSetForStoppedSurface;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    @Nullable
    private e1 mThemedReactContext;
    private i2 mViewManagerRegistry;

    private static class PendingViewEvent {
        private final boolean mCanCoalesceEvent;
        private final int mEventCategory;
        private final String mEventName;
        @Nullable
        private final WritableMap mParams;

        public PendingViewEvent(String str, @Nullable WritableMap writableMap, int i10, boolean z10) {
            this.mEventName = str;
            this.mParams = writableMap;
            this.mEventCategory = i10;
            this.mCanCoalesceEvent = z10;
        }

        public void dispatch(EventEmitterWrapper eventEmitterWrapper) {
            if (this.mCanCoalesceEvent) {
                eventEmitterWrapper.dispatchUnique(this.mEventName, this.mParams);
            } else {
                eventEmitterWrapper.dispatch(this.mEventName, this.mParams, this.mEventCategory);
            }
        }
    }

    private class RemoveDeleteTreeUIFrameCallback extends GuardedFrameCallback {
        private static final long FRAME_TIME_MS = 16;
        private static final long MAX_TIME_IN_FRAME = 9;

        private boolean haveExceededNonBatchedFrameTime(long j10) {
            if (FRAME_TIME_MS - ((System.nanoTime() - j10) / 1000000) < MAX_TIME_IN_FRAME) {
                return true;
            }
            return false;
        }

        @UiThread
        public void doFrameGuarded(long j10) {
            boolean z10;
            Stack stack = new Stack();
            int i10 = 0;
            while (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                try {
                    Integer num = (Integer) SurfaceMountingManager.this.mReactTagsToRemove.pop();
                    int intValue = num.intValue();
                    i10++;
                    if (SurfaceMountingManager.this.mErroneouslyReaddedReactTags.contains(num)) {
                        ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, new s("RemoveDeleteTree recursively tried to remove a React View that was actually reused. This indicates a bug in the Differ. [" + intValue + "]"));
                    } else {
                        stack.clear();
                        ViewState f10 = SurfaceMountingManager.this.getNullableViewState(intValue);
                        if (f10 != null) {
                            View view = f10.mView;
                            ViewManager viewManager = f10.mViewManager;
                            if (viewManager instanceof q) {
                                q qVar = (q) viewManager;
                                int i11 = 0;
                                z10 = false;
                                while (true) {
                                    View childAt = qVar.getChildAt(view, i11);
                                    if (childAt == null) {
                                        break;
                                    }
                                    int id2 = childAt.getId();
                                    if (!z10) {
                                        if (SurfaceMountingManager.this.getNullableViewState(id2) == null) {
                                            z10 = false;
                                            stack.push(Integer.valueOf(childAt.getId()));
                                            i11++;
                                        }
                                    }
                                    z10 = true;
                                    stack.push(Integer.valueOf(childAt.getId()));
                                    i11++;
                                }
                                if (z10) {
                                    qVar.removeAllViews(view);
                                }
                                if (z10) {
                                    SurfaceMountingManager.this.mReactTagsToRemove.addAll(stack);
                                }
                            }
                            SurfaceMountingManager.this.mTagToViewState.remove(num);
                            SurfaceMountingManager.this.onViewStateDeleted(f10);
                            if (i10 % 20 == 0 && haveExceededNonBatchedFrameTime(j10)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (RuntimeException e10) {
                    ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, e10);
                    z10 = false;
                } catch (Throwable th) {
                    if (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                        com.facebook.react.modules.core.a.h().m(a.b.IDLE_EVENT, this);
                    } else {
                        SurfaceMountingManager.this.mErroneouslyReaddedReactTags.clear();
                        SurfaceMountingManager.this.mReactTagsToRemove.clear();
                    }
                    throw th;
                }
            }
            if (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                com.facebook.react.modules.core.a.h().m(a.b.IDLE_EVENT, this);
                return;
            }
            SurfaceMountingManager.this.mErroneouslyReaddedReactTags.clear();
            SurfaceMountingManager.this.mReactTagsToRemove.clear();
        }

        private RemoveDeleteTreeUIFrameCallback(@NonNull ReactContext reactContext) {
            super(reactContext);
        }
    }

    public SurfaceMountingManager(int i10, @NonNull g7.a aVar, @NonNull i2 i2Var, @NonNull RootViewManager rootViewManager, @NonNull MountingManager.MountItemExecutor mountItemExecutor, @NonNull e1 e1Var) {
        this.mSurfaceId = i10;
        this.mJSResponderHandler = aVar;
        this.mViewManagerRegistry = i2Var;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
        this.mThemedReactContext = e1Var;
    }

    @AnyThread
    private void addRootView(@NonNull View view) {
        if (!isStopped()) {
            this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, this.mRootViewManager, true));
            b bVar = new b(this, view);
            if (UiThreadUtil.isOnUiThread()) {
                bVar.run();
            } else {
                UiThreadUtil.runOnUiThread(bVar);
            }
        }
    }

    @UiThread
    private void executeMountItemsOnViewAttach() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachMountItems);
    }

    /* access modifiers changed from: private */
    @Nullable
    public ViewState getNullableViewState(int i10) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i10));
    }

    @NonNull
    private static q getViewGroupManager(@NonNull ViewState viewState) {
        ViewManager viewManager = viewState.mViewManager;
        if (viewManager != null) {
            return (q) viewManager;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    @NonNull
    private ViewState getViewState(int i10) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i10));
        if (viewState != null) {
            return viewState;
        }
        throw new RetryableMountingLayerException("Unable to find viewState for tag " + i10 + ". Surface stopped: " + isStopped());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addRootView$0(View view) {
        if (!isStopped()) {
            if (view.getId() == this.mSurfaceId) {
                String str = TAG;
                ReactSoftExceptionLogger.logSoftException(str, new s("Race condition in addRootView detected. Trying to set an id of [" + this.mSurfaceId + "] on the RootView, but that id has already been set. "));
            } else if (view.getId() != -1) {
                z2.a.l(TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(this.mSurfaceId));
                throw new s("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
            }
            view.setId(this.mSurfaceId);
            if (view instanceof r0) {
                ((r0) view).setRootViewTag(this.mSurfaceId);
            }
            if (!o6.a.b()) {
                this.mRootViewAttached = true;
            }
            executeMountItemsOnViewAttach();
            if (o6.a.b()) {
                this.mRootViewAttached = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopSurface$1() {
        this.mTagSetForStoppedSurface = new SparseArrayCompat<>();
        for (Map.Entry next : this.mTagToViewState.entrySet()) {
            this.mTagSetForStoppedSurface.put(((Integer) next.getKey()).intValue(), this);
            onViewStateDeleted((ViewState) next.getValue());
        }
        this.mTagToViewState = null;
        this.mJSResponderHandler = null;
        this.mRootViewManager = null;
        this.mMountItemExecutor = null;
        this.mThemedReactContext = null;
        if (o6.a.a()) {
            this.mRemoveDeleteTreeUIFrameCallback = null;
        }
        this.mOnViewAttachMountItems.clear();
        if (ReactFeatureFlags.enableViewRecycling) {
            this.mViewManagerRegistry.i(this.mSurfaceId);
        }
        String str = TAG;
        z2.a.j(str, "Surface [" + this.mSurfaceId + "] was stopped on SurfaceMountingManager.");
    }

    private static void logViewHierarchy(ViewGroup viewGroup, boolean z10) {
        ViewGroup viewGroup2;
        int i10;
        int id2 = viewGroup.getId();
        String str = TAG;
        z2.a.j(str, "  <ViewGroup tag=" + id2 + " class=" + viewGroup.getClass().toString() + ">");
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            String str2 = TAG;
            z2.a.j(str2, "     <View idx=" + i11 + " tag=" + viewGroup.getChildAt(i11).getId() + " class=" + viewGroup.getChildAt(i11).getClass().toString() + ">");
        }
        String str3 = TAG;
        z2.a.j(str3, "  </ViewGroup tag=" + id2 + ">");
        if (z10) {
            z2.a.j(str3, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) parent;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 == null) {
                    i10 = -1;
                } else {
                    i10 = viewGroup2.getId();
                }
                String str4 = TAG;
                z2.a.j(str4, "<ViewParent tag=" + i10 + " class=" + parent.getClass().toString() + ">");
            }
        }
    }

    /* access modifiers changed from: private */
    @UiThread
    public void onViewStateDeleted(ViewState viewState) {
        d1 d1Var = viewState.mStateWrapper;
        if (d1Var != null) {
            d1Var.destroyState();
            viewState.mStateWrapper = null;
        }
        EventEmitterWrapper eventEmitterWrapper = viewState.mEventEmitter;
        if (eventEmitterWrapper != null) {
            eventEmitterWrapper.destroy();
            viewState.mEventEmitter = null;
        }
        ViewManager viewManager = viewState.mViewManager;
        if (!viewState.mIsRoot && viewManager != null) {
            viewManager.onDropViewInstance(viewState.mView);
        }
    }

    @UiThread
    public void addViewAt(int i10, int i11, int i12) {
        int i13;
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            View view = viewState.mView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewState viewState2 = getViewState(i11);
                View view2 = viewState2.mView;
                if (view2 != null) {
                    ViewParent parent = view2.getParent();
                    if (parent != null) {
                        boolean z10 = parent instanceof ViewGroup;
                        if (z10) {
                            i13 = ((ViewGroup) parent).getId();
                        } else {
                            i13 = -1;
                        }
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + i11 + "] into parent [" + i10 + "]: View already has a parent: [" + i13 + "]  Parent: " + parent.getClass().getSimpleName() + " View: " + view2.getClass().getSimpleName()));
                        if (z10) {
                            ((ViewGroup) parent).removeView(view2);
                        }
                        this.mErroneouslyReaddedReactTags.add(Integer.valueOf(i11));
                    }
                    try {
                        getViewGroupManager(viewState).addView(viewGroup, view2, i12);
                    } catch (IllegalStateException e10) {
                        throw new IllegalStateException("addViewAt: failed to insert view [" + i11 + "] into parent [" + i10 + "] at index " + i12, e10);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i11);
                }
            } else {
                String str = "Unable to add a view into a view that is not a ViewGroup. ParentTag: " + i10 + " - Tag: " + i11 + " - Index: " + i12;
                z2.a.j(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void attachRootView(View view, e1 e1Var) {
        this.mThemedReactContext = e1Var;
        addRootView(view);
    }

    @UiThread
    public void createView(@NonNull String str, int i10, @Nullable ReadableMap readableMap, @Nullable d1 d1Var, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z10) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i10);
            if (nullableViewState == null || nullableViewState.mView == null) {
                createViewUnsafe(str, i10, readableMap, d1Var, eventEmitterWrapper, z10);
            }
        }
    }

    @UiThread
    public void createViewUnsafe(@NonNull String str, int i10, @Nullable ReadableMap readableMap, @Nullable d1 d1Var, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z10) {
        View view;
        ViewManager viewManager;
        v0 v0Var = new v0(readableMap);
        if (z10) {
            viewManager = this.mViewManagerRegistry.c(str);
            view = viewManager.createView(i10, this.mThemedReactContext, v0Var, d1Var, this.mJSResponderHandler);
        } else {
            viewManager = null;
            view = null;
        }
        ViewState viewState = new ViewState(i10, view, viewManager);
        viewState.mCurrentProps = v0Var;
        viewState.mStateWrapper = d1Var;
        viewState.mEventEmitter = eventEmitterWrapper;
        this.mTagToViewState.put(Integer.valueOf(i10), viewState);
    }

    @UiThread
    public void deleteView(int i10) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i10);
            if (nullableViewState == null) {
                String str = MountingManager.TAG;
                ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i10 + " for deleteView"));
                return;
            }
            this.mTagToViewState.remove(Integer.valueOf(i10));
            onViewStateDeleted(nullableViewState);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = r0.get(java.lang.Integer.valueOf(r2));
     */
    @androidx.annotation.AnyThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enqueuePendingEvent(int r2, java.lang.String r3, boolean r4, @androidx.annotation.Nullable com.facebook.react.bridge.WritableMap r5, int r6) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState> r0 = r1.mTagToViewState
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState r2 = (com.facebook.react.fabric.mounting.SurfaceMountingManager.ViewState) r2
            if (r2 != 0) goto L_0x0012
            return
        L_0x0012:
            com.facebook.react.fabric.mounting.SurfaceMountingManager$PendingViewEvent r0 = new com.facebook.react.fabric.mounting.SurfaceMountingManager$PendingViewEvent
            r0.<init>(r3, r5, r6, r4)
            com.facebook.react.fabric.mounting.SurfaceMountingManager$4 r3 = new com.facebook.react.fabric.mounting.SurfaceMountingManager$4
            r3.<init>(r2, r0)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.mounting.SurfaceMountingManager.enqueuePendingEvent(int, java.lang.String, boolean, com.facebook.react.bridge.WritableMap, int):void");
    }

    @Nullable
    public e1 getContext() {
        return this.mThemedReactContext;
    }

    @AnyThread
    @Nullable
    public EventEmitterWrapper getEventEmitter(int i10) {
        ViewState nullableViewState = getNullableViewState(i10);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @UiThread
    public View getView(int i10) {
        View view;
        ViewState nullableViewState = getNullableViewState(i10);
        if (nullableViewState == null) {
            view = null;
        } else {
            view = nullableViewState.mView;
        }
        if (view != null) {
            return view;
        }
        throw new s("Trying to resolve view with tag " + i10 + " which doesn't exist");
    }

    public boolean getViewExists(int i10) {
        SparseArrayCompat<Object> sparseArrayCompat = this.mTagSetForStoppedSurface;
        if (sparseArrayCompat != null && sparseArrayCompat.containsKey(i10)) {
            return true;
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i10));
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    @UiThread
    public void preallocateView(@NonNull String str, int i10, @Nullable ReadableMap readableMap, @Nullable d1 d1Var, @Nullable EventEmitterWrapper eventEmitterWrapper, boolean z10) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped() && getNullableViewState(i10) == null) {
            createViewUnsafe(str, i10, readableMap, d1Var, eventEmitterWrapper, z10);
        }
    }

    public void printSurfaceState() {
        String str;
        View view;
        z2.a.l(TAG, "Views created for surface {%d}:", Integer.valueOf(getSurfaceId()));
        for (ViewState next : this.mTagToViewState.values()) {
            ViewManager viewManager = next.mViewManager;
            Integer num = null;
            if (viewManager != null) {
                str = viewManager.getName();
            } else {
                str = null;
            }
            View view2 = next.mView;
            if (view2 != null) {
                view = (View) view2.getParent();
            } else {
                view = null;
            }
            if (view != null) {
                num = Integer.valueOf(view.getId());
            }
            z2.a.l(TAG, "<%s id=%d parentTag=%s isRoot=%b />", str, Integer.valueOf(next.mReactTag), num, Boolean.valueOf(next.mIsRoot));
        }
    }

    @Deprecated
    public void receiveCommand(int i10, int i11, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i10);
            if (nullableViewState != null) {
                ViewManager viewManager = nullableViewState.mViewManager;
                if (viewManager != null) {
                    View view = nullableViewState.mView;
                    if (view != null) {
                        viewManager.receiveCommand(view, i11, readableArray);
                        return;
                    }
                    throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i10);
                }
                throw new RetryableMountingLayerException("Unable to find viewManager for tag " + i10);
            }
            throw new RetryableMountingLayerException("Unable to find viewState for tag: [" + i10 + "] for commandId: " + i11);
        }
    }

    @UiThread
    public void removeDeleteTreeAt(int i10, int i11, int i12) {
        int i13;
        if (!isStopped()) {
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i11);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i11 + "] for removeDeleteTreeAt"));
                return;
            }
            View view = nullableViewState.mView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup != null) {
                    q viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i12);
                    if (childAt != null) {
                        i13 = childAt.getId();
                    } else {
                        i13 = -1;
                    }
                    if (i13 != i10) {
                        int childCount = viewGroup.getChildCount();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= childCount) {
                                i14 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i14).getId() == i10) {
                                break;
                            } else {
                                i14++;
                            }
                        }
                        if (i14 == -1) {
                            z2.a.j(TAG, "removeDeleteTreeAt: [" + i10 + "] -> [" + i11 + "] @" + i12 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove+delete view [" + i10 + "] of parent [" + i11 + "] at index " + i12 + ", but got view tag " + i13 + " - actual index of view: " + i14));
                        i12 = i14;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i12);
                        if (this.mReactTagsToRemove.empty()) {
                            if (this.mRemoveDeleteTreeUIFrameCallback == null) {
                                this.mRemoveDeleteTreeUIFrameCallback = new RemoveDeleteTreeUIFrameCallback(this.mThemedReactContext);
                            }
                            com.facebook.react.modules.core.a.h().m(a.b.IDLE_EVENT, this.mRemoveDeleteTreeUIFrameCallback);
                        }
                        this.mReactTagsToRemove.push(Integer.valueOf(i10));
                    } catch (RuntimeException e10) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i12 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e10);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i11 + "]");
                }
            } else {
                String str = "Unable to remove+delete a view from a view that is not a ViewGroup. ParentTag: " + i11 + " - Tag: " + i10 + " - Index: " + i12;
                z2.a.j(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    @UiThread
    public void removeViewAt(int i10, int i11, int i12) {
        int i13;
        if (!isStopped()) {
            if (this.mErroneouslyReaddedReactTags.contains(Integer.valueOf(i10))) {
                ReactSoftExceptionLogger.logSoftException(TAG, new s("removeViewAt tried to remove a React View that was actually reused. This indicates a bug in the Differ (specifically instruction ordering). [" + i10 + "]"));
                return;
            }
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i11);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i11 + "] for removeViewAt"));
                return;
            }
            View view = nullableViewState.mView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup != null) {
                    q viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i12);
                    if (childAt != null) {
                        i13 = childAt.getId();
                    } else {
                        i13 = -1;
                    }
                    if (i13 != i10) {
                        int childCount = viewGroup.getChildCount();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= childCount) {
                                i14 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i14).getId() == i10) {
                                break;
                            } else {
                                i14++;
                            }
                        }
                        if (i14 == -1) {
                            z2.a.j(TAG, "removeViewAt: [" + i10 + "] -> [" + i11 + "] @" + i12 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove view [" + i10 + "] of parent [" + i11 + "] at index " + i12 + ", but got view tag " + i13 + " - actual index of view: " + i14));
                        i12 = i14;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i12);
                    } catch (RuntimeException e10) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i12 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e10);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i11 + "]");
                }
            } else {
                String str = "Unable to remove a view from a view that is not a ViewGroup. ParentTag: " + i11 + " - Tag: " + i10 + " - Index: " + i12;
                z2.a.j(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    @UiThread
    public void scheduleMountItemOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachMountItems.add(mountItem);
    }

    public void sendAccessibilityEvent(int i10, int i11) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            if (viewState.mViewManager != null) {
                View view = viewState.mView;
                if (view != null) {
                    view.sendAccessibilityEvent(i11);
                    return;
                }
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i10);
            }
            throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i10);
        }
    }

    @UiThread
    public synchronized void setJSResponder(int i10, int i11, boolean z10) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (!z10) {
                this.mJSResponderHandler.d(i11, (ViewParent) null);
                return;
            }
            ViewState viewState = getViewState(i10);
            View view = viewState.mView;
            if (i11 != i10 && (view instanceof ViewParent)) {
                this.mJSResponderHandler.d(i11, (ViewParent) view);
            } else if (view == null) {
                SoftAssertions.assertUnreachable("Cannot find view for tag [" + i10 + "].");
            } else {
                if (viewState.mIsRoot) {
                    SoftAssertions.assertUnreachable("Cannot block native responder on [" + i10 + "] that is a root view");
                }
                this.mJSResponderHandler.d(i11, view.getParent());
            }
        }
    }

    @AnyThread
    public void stopSurface() {
        String str = TAG;
        z2.a.j(str, "Stopping surface [" + this.mSurfaceId + "]");
        if (!isStopped()) {
            this.mIsStopped = true;
            for (ViewState next : this.mTagToViewState.values()) {
                d1 d1Var = next.mStateWrapper;
                if (d1Var != null) {
                    d1Var.destroyState();
                    next.mStateWrapper = null;
                }
                EventEmitterWrapper eventEmitterWrapper = next.mEventEmitter;
                if (eventEmitterWrapper != null) {
                    eventEmitterWrapper.destroy();
                    next.mEventEmitter = null;
                }
            }
            c cVar = new c(this);
            if (UiThreadUtil.isOnUiThread()) {
                cVar.run();
            } else {
                UiThreadUtil.runOnUiThread(cVar);
            }
        }
    }

    @UiThread
    public void updateEventEmitter(int i10, @NonNull EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i10));
            if (viewState == null) {
                viewState = new ViewState(i10, (View) null, (ViewManager) null);
                this.mTagToViewState.put(Integer.valueOf(i10), viewState);
            }
            EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
            viewState.mEventEmitter = eventEmitterWrapper;
            if (!(eventEmitterWrapper2 == eventEmitterWrapper || eventEmitterWrapper2 == null)) {
                eventEmitterWrapper2.destroy();
            }
            Queue<PendingViewEvent> queue = viewState.mPendingEventQueue;
            if (queue != null) {
                for (PendingViewEvent dispatch : queue) {
                    dispatch.dispatch(eventEmitterWrapper);
                }
                viewState.mPendingEventQueue = null;
            }
        }
    }

    @UiThread
    public void updateLayout(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        q qVar;
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    int i18 = 0;
                    if (o6.a.d()) {
                        int i19 = 1;
                        if (i17 == 1) {
                            i19 = 0;
                        } else if (i17 != 2) {
                            i19 = 2;
                        }
                        view.setLayoutDirection(i19);
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
                    ViewParent parent = view.getParent();
                    if (parent instanceof z0) {
                        parent.requestLayout();
                    }
                    ViewManager viewManager = getViewState(i11).mViewManager;
                    if (viewManager != null) {
                        qVar = (q) viewManager;
                    } else {
                        qVar = null;
                    }
                    if (qVar == null || !qVar.needsCustomLayoutForChildren()) {
                        view.layout(i12, i13, i14 + i12, i15 + i13);
                    }
                    if (i16 == 0) {
                        i18 = 4;
                    }
                    if (view.getVisibility() != i18) {
                        view.setVisibility(i18);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unable to find View for tag: " + i10);
            }
        }
    }

    @UiThread
    public void updateOverflowInset(int i10, int i11, int i12, int i13, int i14) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view == null) {
                    throw new IllegalStateException("Unable to find View for tag: " + i10);
                } else if (view instanceof p0) {
                    ((p0) view).setOverflowInset(i11, i12, i13, i14);
                }
            }
        }
    }

    @UiThread
    public void updatePadding(int i10, int i11, int i12, int i13, int i14) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    ViewManager viewManager = viewState.mViewManager;
                    if (viewManager != null) {
                        viewManager.setPadding(view, i11, i12, i13, i14);
                        return;
                    }
                    throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
                }
                throw new IllegalStateException("Unable to find View for tag: " + i10);
            }
        }
    }

    public void updateProps(int i10, ReadableMap readableMap) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            viewState.mCurrentProps = new v0(readableMap);
            View view = viewState.mView;
            if (view != null) {
                ((ViewManager) p5.a.c(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag [" + i10 + "]");
        }
    }

    @UiThread
    public void updateState(int i10, @Nullable d1 d1Var) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i10);
            d1 d1Var2 = viewState.mStateWrapper;
            viewState.mStateWrapper = d1Var;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, d1Var);
                if (updateState != null) {
                    viewManager.updateExtraData(viewState.mView, updateState);
                }
                if (d1Var2 != null) {
                    d1Var2.destroyState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i10);
        }
    }

    private static class ViewState {
        @Nullable
        public ReadableMap mCurrentLocalData;
        @Nullable
        public v0 mCurrentProps;
        @Nullable
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        @Nullable
        public Queue<PendingViewEvent> mPendingEventQueue;
        final int mReactTag;
        @Nullable
        public d1 mStateWrapper;
        @Nullable
        final View mView;
        @Nullable
        final ViewManager mViewManager;

        @NonNull
        public String toString() {
            boolean z10;
            if (this.mViewManager == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z10;
        }

        private ViewState(int i10, @Nullable View view, @Nullable ViewManager viewManager) {
            this(i10, view, viewManager, false);
        }

        private ViewState(int i10, @Nullable View view, @Nullable ViewManager viewManager, boolean z10) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mPendingEventQueue = null;
            this.mReactTag = i10;
            this.mView = view;
            this.mIsRoot = z10;
            this.mViewManager = viewManager;
        }
    }

    public void receiveCommand(int i10, @NonNull String str, @Nullable ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i10);
            if (nullableViewState != null) {
                ViewManager viewManager = nullableViewState.mViewManager;
                if (viewManager != null) {
                    View view = nullableViewState.mView;
                    if (view != null) {
                        viewManager.receiveCommand(view, str, readableArray);
                        return;
                    }
                    throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i10);
                }
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i10);
            }
            throw new RetryableMountingLayerException("Unable to find viewState for tag: " + i10 + " for commandId: " + str);
        }
    }
}

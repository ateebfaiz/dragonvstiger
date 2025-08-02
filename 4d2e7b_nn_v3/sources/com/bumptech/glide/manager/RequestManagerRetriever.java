package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() {
        @NonNull
        public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    private static final String FRAGMENT_INDEX_KEY = "key";
    @VisibleForTesting
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int HAS_ATTEMPTED_TO_ADD_FRAGMENT_TWICE = 1;
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final FrameWaiter frameWaiter;
    private final Handler handler;
    private final LifecycleRequestManagerRetriever lifecycleRequestManagerRetriever;
    @VisibleForTesting
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final Bundle tempBundle = new Bundle();
    private final ArrayMap<View, Fragment> tempViewToFragment = new ArrayMap<>();
    private final ArrayMap<View, androidx.fragment.app.Fragment> tempViewToSupportFragment = new ArrayMap<>();

    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory, GlideExperiments glideExperiments) {
        requestManagerFactory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.factory = requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.lifecycleRequestManagerRetriever = new LifecycleRequestManagerRetriever(requestManagerFactory);
        this.frameWaiter = buildFrameWaiter(glideExperiments);
    }

    @TargetApi(17)
    private static void assertNotDestroyed(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static FrameWaiter buildFrameWaiter(GlideExperiments glideExperiments) {
        if (!HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED || !HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED) {
            return new DoNothingFirstFrameWaiter();
        }
        if (glideExperiments.isEnabled(GlideBuilder.WaitForFramesAfterTrimMemory.class)) {
            return new FirstFrameAndAfterTrimMemoryWaiter();
        }
        return new FirstFrameWaiter();
    }

    @Nullable
    private static Activity findActivity(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        findAllFragmentsWithViewsPreO(fragmentManager, arrayMap);
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        Fragment fragment;
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            this.tempBundle.putInt(FRAGMENT_INDEX_KEY, i10);
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                }
                i10 = i11;
            } else {
                return;
            }
        }
    }

    private static void findAllSupportFragmentsWithViews(@Nullable Collection<androidx.fragment.app.Fragment> collection, @NonNull Map<View, androidx.fragment.app.Fragment> map) {
        if (collection != null) {
            for (androidx.fragment.app.Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    findAllSupportFragmentsWithViews(next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    @Deprecated
    @Nullable
    private Fragment findFragment(@NonNull View view, @NonNull Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View findViewById = activity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    @Nullable
    private androidx.fragment.app.Fragment findSupportFragment(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View findViewById = fragmentActivity.findViewById(16908290);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private RequestManager fragmentGet(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z10) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager == null) {
            requestManager = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
            if (z10) {
                requestManager.onStart();
            }
            requestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }

    @NonNull
    private RequestManager getApplicationManager(@NonNull Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                try {
                    if (this.applicationManager == null) {
                        this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.applicationManager;
    }

    private static boolean isActivityVisible(Context context) {
        Activity findActivity = findActivity(context);
        if (findActivity == null || !findActivity.isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean verifyOurFragmentWasAddedOrCantBeAdded(FragmentManager fragmentManager, boolean z10) {
        RequestManagerFragment requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager);
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment2 == requestManagerFragment) {
            return true;
        }
        if (requestManagerFragment2 != null && requestManagerFragment2.getRequestManager() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + requestManagerFragment2 + " New: " + requestManagerFragment);
        } else if (z10 || fragmentManager.isDestroyed()) {
            if (Log.isLoggable(TAG, 5)) {
                if (fragmentManager.isDestroyed()) {
                    Log.w(TAG, "Parent was destroyed before our Fragment could be added");
                } else {
                    Log.w(TAG, "Tried adding Fragment twice and failed twice, giving up!");
                }
            }
            requestManagerFragment.getGlideLifecycle().onDestroy();
            return true;
        } else {
            FragmentTransaction add = fragmentManager.beginTransaction().add(requestManagerFragment, FRAGMENT_TAG);
            if (requestManagerFragment2 != null) {
                add.remove(requestManagerFragment2);
            }
            add.commitAllowingStateLoss();
            this.handler.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
    }

    private boolean verifyOurSupportFragmentWasAddedOrCantBeAdded(androidx.fragment.app.FragmentManager fragmentManager, boolean z10) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment2 == supportRequestManagerFragment) {
            return true;
        }
        if (supportRequestManagerFragment2 != null && supportRequestManagerFragment2.getRequestManager() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + supportRequestManagerFragment2 + " New: " + supportRequestManagerFragment);
        } else if (z10 || fragmentManager.isDestroyed()) {
            if (fragmentManager.isDestroyed()) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                }
            } else if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
            supportRequestManagerFragment.getGlideLifecycle().onDestroy();
            return true;
        } else {
            androidx.fragment.app.FragmentTransaction add = fragmentManager.beginTransaction().add((androidx.fragment.app.Fragment) supportRequestManagerFragment, FRAGMENT_TAG);
            if (supportRequestManagerFragment2 != null) {
                add.remove(supportRequestManagerFragment2);
            }
            add.commitNowAllowingStateLoss();
            this.handler.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "We failed to add our Fragment the first time around, trying again...");
            }
            return false;
        }
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return get(contextWrapper.getBaseContext());
                    }
                }
            }
            return getApplicationManager(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public RequestManagerFragment getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), (Fragment) null);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager) {
        return getSupportRequestManagerFragment(fragmentManager, (androidx.fragment.app.Fragment) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: androidx.fragment.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.app.FragmentManager} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.app.FragmentManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            int r0 = r8.arg1
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0008
            r0 = r1
            goto L_0x0009
        L_0x0008:
            r0 = r2
        L_0x0009:
            int r3 = r8.what
            r4 = 0
            if (r3 == r1) goto L_0x0026
            r5 = 2
            if (r3 == r5) goto L_0x0014
            r1 = r2
            r8 = r4
            goto L_0x003b
        L_0x0014:
            java.lang.Object r8 = r8.obj
            androidx.fragment.app.FragmentManager r8 = (androidx.fragment.app.FragmentManager) r8
            boolean r0 = r7.verifyOurSupportFragmentWasAddedOrCantBeAdded(r8, r0)
            if (r0 == 0) goto L_0x0037
            java.util.Map<androidx.fragment.app.FragmentManager, com.bumptech.glide.manager.SupportRequestManagerFragment> r0 = r7.pendingSupportRequestManagerFragments
            java.lang.Object r4 = r0.remove(r8)
        L_0x0024:
            r2 = r1
            goto L_0x003b
        L_0x0026:
            java.lang.Object r8 = r8.obj
            android.app.FragmentManager r8 = (android.app.FragmentManager) r8
            boolean r0 = r7.verifyOurFragmentWasAddedOrCantBeAdded(r8, r0)
            if (r0 == 0) goto L_0x0037
            java.util.Map<android.app.FragmentManager, com.bumptech.glide.manager.RequestManagerFragment> r0 = r7.pendingRequestManagerFragments
            java.lang.Object r4 = r0.remove(r8)
            goto L_0x0024
        L_0x0037:
            r8 = r4
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x003b:
            r0 = 5
            java.lang.String r3 = "RMRetriever"
            boolean r0 = android.util.Log.isLoggable(r3, r0)
            if (r0 == 0) goto L_0x005c
            if (r1 == 0) goto L_0x005c
            if (r4 != 0) goto L_0x005c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to remove expected request manager fragment, manager: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.util.Log.w(r3, r8)
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerRetriever.handleMessage(android.os.Message):boolean");
    }

    @NonNull
    private RequestManagerFragment getRequestManagerFragment(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        RequestManagerFragment requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment2 == null) {
            requestManagerFragment2 = new RequestManagerFragment();
            requestManagerFragment2.setParentFragmentHint(fragment);
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment2);
            fragmentManager.beginTransaction().add(requestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment2;
    }

    @NonNull
    private SupportRequestManagerFragment getSupportRequestManagerFragment(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment2 == null) {
            supportRequestManagerFragment2 = new SupportRequestManagerFragment();
            supportRequestManagerFragment2.setParentFragmentHint(fragment);
            this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment2);
            fragmentManager.beginTransaction().add((androidx.fragment.app.Fragment) supportRequestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment2;
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        this.frameWaiter.registerSelf(fragmentActivity);
        boolean isActivityVisible = isActivityVisible(fragmentActivity);
        return this.lifecycleRequestManagerRetriever.getOrCreate(fragmentActivity, Glide.get(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), isActivityVisible);
    }

    @NonNull
    public RequestManager get(@NonNull androidx.fragment.app.Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.frameWaiter.registerSelf(fragment.getActivity());
        }
        androidx.fragment.app.FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Context context = fragment.getContext();
        return this.lifecycleRequestManagerRetriever.getOrCreate(context, Glide.get(context.getApplicationContext()), fragment.getLifecycle(), childFragmentManager, fragment.isVisible());
    }

    @NonNull
    @Deprecated
    public RequestManager get(@NonNull Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return get((FragmentActivity) activity);
        }
        assertNotDestroyed(activity);
        this.frameWaiter.registerSelf(activity);
        return fragmentGet(activity, activity.getFragmentManager(), (Fragment) null, isActivityVisible(activity));
    }

    @NonNull
    public RequestManager get(@NonNull View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity findActivity = findActivity(view.getContext());
        if (findActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (findActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) findActivity;
            androidx.fragment.app.Fragment findSupportFragment = findSupportFragment(view, fragmentActivity);
            return findSupportFragment != null ? get(findSupportFragment) : get(fragmentActivity);
        }
        Fragment findFragment = findFragment(view, findActivity);
        if (findFragment == null) {
            return get(findActivity);
        }
        return get(findFragment);
    }

    @TargetApi(17)
    @NonNull
    @Deprecated
    public RequestManager get(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            if (fragment.getActivity() != null) {
                this.frameWaiter.registerSelf(fragment.getActivity());
            }
            return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }
}

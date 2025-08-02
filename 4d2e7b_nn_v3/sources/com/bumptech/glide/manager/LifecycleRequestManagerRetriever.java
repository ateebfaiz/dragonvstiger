package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class LifecycleRequestManagerRetriever {
    @NonNull
    private final RequestManagerRetriever.RequestManagerFactory factory;
    final Map<Lifecycle, RequestManager> lifecycleToRequestManager = new HashMap();

    private final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {
        private final FragmentManager childFragmentManager;

        SupportRequestManagerTreeNode(FragmentManager fragmentManager) {
            this.childFragmentManager = fragmentManager;
        }

        private void getChildFragmentsRecursive(FragmentManager fragmentManager, Set<RequestManager> set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = fragments.get(i10);
                getChildFragmentsRecursive(fragment.getChildFragmentManager(), set);
                RequestManager only = LifecycleRequestManagerRetriever.this.getOnly(fragment.getLifecycle());
                if (only != null) {
                    set.add(only);
                }
            }
        }

        @NonNull
        public Set<RequestManager> getDescendants() {
            HashSet hashSet = new HashSet();
            getChildFragmentsRecursive(this.childFragmentManager, hashSet);
            return hashSet;
        }
    }

    LifecycleRequestManagerRetriever(@NonNull RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory;
    }

    /* access modifiers changed from: package-private */
    public RequestManager getOnly(Lifecycle lifecycle) {
        Util.assertMainThread();
        return this.lifecycleToRequestManager.get(lifecycle);
    }

    /* access modifiers changed from: package-private */
    public RequestManager getOrCreate(Context context, Glide glide, final Lifecycle lifecycle, FragmentManager fragmentManager, boolean z10) {
        Util.assertMainThread();
        RequestManager only = getOnly(lifecycle);
        if (only != null) {
            return only;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
        RequestManager build = this.factory.build(glide, lifecycleLifecycle, new SupportRequestManagerTreeNode(fragmentManager), context);
        this.lifecycleToRequestManager.put(lifecycle, build);
        lifecycleLifecycle.addListener(new LifecycleListener() {
            public void onDestroy() {
                LifecycleRequestManagerRetriever.this.lifecycleToRequestManager.remove(lifecycle);
            }

            public void onStart() {
            }

            public void onStop() {
            }
        });
        if (z10) {
            build.onStart();
        }
        return build;
    }
}

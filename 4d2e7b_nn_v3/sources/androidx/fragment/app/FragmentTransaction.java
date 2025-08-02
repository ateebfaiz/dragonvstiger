package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    @Nullable
    String mName;
    ArrayList<a> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f15638a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f15639b;

        /* renamed from: c  reason: collision with root package name */
        int f15640c;

        /* renamed from: d  reason: collision with root package name */
        int f15641d;

        /* renamed from: e  reason: collision with root package name */
        int f15642e;

        /* renamed from: f  reason: collision with root package name */
        int f15643f;

        /* renamed from: g  reason: collision with root package name */
        Lifecycle.State f15644g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f15645h;

        a() {
        }

        a(int i10, Fragment fragment) {
            this.f15638a = i10;
            this.f15639b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f15644g = state;
            this.f15645h = state;
        }

        a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f15638a = i10;
            this.f15639b = fragment;
            this.f15644g = fragment.mMaxState;
            this.f15645h = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.mClassLoader;
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                if (bundle != null) {
                    instantiate.setArguments(bundle);
                }
                return instantiate;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(createFragment(cls, bundle), str);
    }

    /* access modifiers changed from: package-private */
    public void addOp(a aVar) {
        this.mOps.add(aVar);
        aVar.f15640c = this.mEnterAnim;
        aVar.f15641d = this.mExitAnim;
        aVar.f15642e = this.mPopEnterAnim;
        aVar.f15643f = this.mPopExitAnim;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (j.D()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.mSharedElementSourceNames == null) {
                    this.mSharedElementSourceNames = new ArrayList<>();
                    this.mSharedElementTargetNames = new ArrayList<>();
                } else if (this.mSharedElementTargetNames.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
                this.mSharedElementSourceNames.add(transitionName);
                this.mSharedElementTargetNames.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        addOp(new a(7, fragment));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        addOp(new a(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.mAddToBackStack) {
            this.mAllowAddToBackStack = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void doAddOp(int i10, Fragment fragment, @Nullable String str, int i11) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = fragment.mFragmentId;
                if (i12 == 0 || i12 == i10) {
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        addOp(new a(i11, fragment));
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        addOp(new a(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        addOp(new a(3, fragment));
        return this;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i10, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return replace(i10, cls, bundle, (String) null);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z10) {
        return setReorderingAllowed(z10);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i10) {
        this.mBreadCrumbShortTitleRes = i10;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i10) {
        this.mBreadCrumbTitleRes = i10;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i10, @AnimRes @AnimatorRes int i11) {
        return setCustomAnimations(i10, i11, 0, 0);
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        addOp(new a(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        addOp(new a(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z10) {
        this.mReorderingAllowed = z10;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i10) {
        this.mTransition = i10;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int i10) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        addOp(new a(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i10, @NonNull Fragment fragment) {
        return replace(i10, fragment, (String) null);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i10, @AnimRes @AnimatorRes int i11, @AnimRes @AnimatorRes int i12, @AnimRes @AnimatorRes int i13) {
        this.mEnterAnim = i10;
        this.mExitAnim = i11;
        this.mPopEnterAnim = i12;
        this.mPopExitAnim = i13;
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i10, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return add(i10, createFragment(cls, bundle));
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i10, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return replace(i10, createFragment(cls, bundle), str);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i10, @NonNull Fragment fragment) {
        doAddOp(i10, fragment, (String) null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i10, @NonNull Fragment fragment, @Nullable String str) {
        if (i10 != 0) {
            doAddOp(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i10, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(i10, createFragment(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i10, @NonNull Fragment fragment, @Nullable String str) {
        doAddOp(i10, fragment, str, 1);
        return this;
    }

    FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader) {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    /* access modifiers changed from: package-private */
    public FragmentTransaction add(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.mContainer = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }
}

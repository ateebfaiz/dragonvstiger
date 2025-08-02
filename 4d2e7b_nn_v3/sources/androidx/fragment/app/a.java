package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.m {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f15660a;

    /* renamed from: b  reason: collision with root package name */
    boolean f15661b;

    /* renamed from: c  reason: collision with root package name */
    int f15662c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentFactory r0 = r3.getFragmentFactory()
            androidx.fragment.app.FragmentHostCallback r1 = r3.getHost()
            if (r1 == 0) goto L_0x0017
            androidx.fragment.app.FragmentHostCallback r1 = r3.getHost()
            android.content.Context r1 = r1.getContext()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r2.<init>(r0, r1)
            r0 = -1
            r2.f15662c = r0
            r2.f15660a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.FragmentManager):void");
    }

    private static boolean k(FragmentTransaction.a aVar) {
        Fragment fragment = aVar.f15639b;
        if (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) {
            return false;
        }
        return true;
    }

    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.f15660a.addBackStackState(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(int i10) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.mOps.size();
            for (int i11 = 0; i11 < size; i11++) {
                FragmentTransaction.a aVar = this.mOps.get(i11);
                Fragment fragment = aVar.f15639b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f15639b + " to " + aVar.f15639b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int c(boolean z10) {
        if (!this.f15661b) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new m("FragmentManager"));
                d("  ", printWriter);
                printWriter.close();
            }
            this.f15661b = true;
            if (this.mAddToBackStack) {
                this.f15662c = this.f15660a.allocBackStackIndex();
            } else {
                this.f15662c = -1;
            }
            this.f15660a.enqueueAction(this, z10);
            return this.f15662c;
        }
        throw new IllegalStateException("commit already called");
    }

    public int commit() {
        return c(false);
    }

    public int commitAllowingStateLoss() {
        return c(true);
    }

    public void commitNow() {
        disallowAddToBackStack();
        this.f15660a.execSingleAction(this, false);
    }

    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f15660a.execSingleAction(this, true);
    }

    public void d(String str, PrintWriter printWriter) {
        e(str, printWriter, true);
    }

    public FragmentTransaction detach(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f15660a) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void doAddOp(int i10, Fragment fragment, String str, int i11) {
        super.doAddOp(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f15660a;
    }

    public void e(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.f15662c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f15661b);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.mOps.size();
            for (int i10 = 0; i10 < size; i10++) {
                FragmentTransaction.a aVar = this.mOps.get(i10);
                switch (aVar.f15638a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f15638a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f15639b);
                if (z10) {
                    if (!(aVar.f15640c == 0 && aVar.f15641d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f15640c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f15641d));
                    }
                    if (aVar.f15642e != 0 || aVar.f15643f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f15642e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f15643f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int size = this.mOps.size();
        for (int i10 = 0; i10 < size; i10++) {
            FragmentTransaction.a aVar = this.mOps.get(i10);
            Fragment fragment = aVar.f15639b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (aVar.f15638a) {
                case 1:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, false);
                    this.f15660a.addFragment(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, false);
                    this.f15660a.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, false);
                    this.f15660a.attachFragment(fragment);
                    break;
                case 8:
                    this.f15660a.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.f15660a.setPrimaryNavigationFragment((Fragment) null);
                    break;
                case 10:
                    this.f15660a.setMaxLifecycle(fragment, aVar.f15645h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f15638a);
            }
            if (!this.mReorderingAllowed && aVar.f15638a != 1 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.f15660a.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed && !FragmentManager.USE_STATE_MANAGER) {
            FragmentManager fragmentManager = this.f15660a;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z10) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.mOps.get(size);
            Fragment fragment = aVar.f15639b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (aVar.f15638a) {
                case 1:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, true);
                    this.f15660a.removeFragment(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, true);
                    this.f15660a.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f15640c, aVar.f15641d, aVar.f15642e, aVar.f15643f);
                    this.f15660a.setExitAnimationOrder(fragment, true);
                    this.f15660a.detachFragment(fragment);
                    break;
                case 8:
                    this.f15660a.setPrimaryNavigationFragment((Fragment) null);
                    break;
                case 9:
                    this.f15660a.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.f15660a.setMaxLifecycle(fragment, aVar.f15644g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f15638a);
            }
            if (!this.mReorderingAllowed && aVar.f15638a != 3 && fragment != null && !FragmentManager.USE_STATE_MANAGER) {
                this.f15660a.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mReorderingAllowed && z10 && !FragmentManager.USE_STATE_MANAGER) {
            FragmentManager fragmentManager = this.f15660a;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.f15660a.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.f15660a.getHost().getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.f15662c;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(ArrayList arrayList, Fragment fragment) {
        ArrayList arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.mOps.size()) {
            FragmentTransaction.a aVar = this.mOps.get(i10);
            int i11 = aVar.f15638a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f15639b;
                    int i12 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = (Fragment) arrayList2.get(size);
                        if (fragment4.mContainerId == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.mOps.add(i10, new FragmentTransaction.a(9, fragment4));
                                    i10++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.a aVar2 = new FragmentTransaction.a(3, fragment4);
                                aVar2.f15640c = aVar.f15640c;
                                aVar2.f15642e = aVar.f15642e;
                                aVar2.f15641d = aVar.f15641d;
                                aVar2.f15643f = aVar.f15643f;
                                this.mOps.add(i10, aVar2);
                                arrayList2.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.mOps.remove(i10);
                        i10--;
                    } else {
                        aVar.f15638a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList2.remove(aVar.f15639b);
                    Fragment fragment5 = aVar.f15639b;
                    if (fragment5 == fragment2) {
                        this.mOps.add(i10, new FragmentTransaction.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.mOps.add(i10, new FragmentTransaction.a(9, fragment2));
                        i10++;
                        fragment2 = aVar.f15639b;
                    }
                }
                i10++;
            }
            arrayList2.add(aVar.f15639b);
            i10++;
        }
        return fragment2;
    }

    public FragmentTransaction hide(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f15660a) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i10) {
        int i11;
        int size = this.mOps.size();
        for (int i12 = 0; i12 < size; i12++) {
            Fragment fragment = this.mOps.get(i12).f15639b;
            if (fragment != null) {
                i11 = fragment.mContainerId;
            } else {
                i11 = 0;
            }
            if (i11 != 0 && i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean j(ArrayList arrayList, int i10, int i11) {
        int i12;
        int i13;
        if (i11 == i10) {
            return false;
        }
        int size = this.mOps.size();
        int i14 = -1;
        for (int i15 = 0; i15 < size; i15++) {
            Fragment fragment = this.mOps.get(i15).f15639b;
            if (fragment != null) {
                i12 = fragment.mContainerId;
            } else {
                i12 = 0;
            }
            if (!(i12 == 0 || i12 == i14)) {
                for (int i16 = i10; i16 < i11; i16++) {
                    a aVar = (a) arrayList.get(i16);
                    int size2 = aVar.mOps.size();
                    for (int i17 = 0; i17 < size2; i17++) {
                        Fragment fragment2 = aVar.mOps.get(i17).f15639b;
                        if (fragment2 != null) {
                            i13 = fragment2.mContainerId;
                        } else {
                            i13 = 0;
                        }
                        if (i13 == i12) {
                            return true;
                        }
                    }
                }
                i14 = i12;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        for (int i10 = 0; i10 < this.mOps.size(); i10++) {
            if (k(this.mOps.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        if (this.mCommitRunnables != null) {
            for (int i10 = 0; i10 < this.mCommitRunnables.size(); i10++) {
                this.mCommitRunnables.get(i10).run();
            }
            this.mCommitRunnables = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment.k kVar) {
        for (int i10 = 0; i10 < this.mOps.size(); i10++) {
            FragmentTransaction.a aVar = this.mOps.get(i10);
            if (k(aVar)) {
                aVar.f15639b.setOnStartEnterTransitionListener(kVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment o(ArrayList arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.a aVar = this.mOps.get(size);
            int i10 = aVar.f15638a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f15639b;
                            break;
                        case 10:
                            aVar.f15645h = aVar.f15644g;
                            break;
                    }
                }
                arrayList.add(aVar.f15639b);
            }
            arrayList.remove(aVar.f15639b);
        }
        return fragment;
    }

    public FragmentTransaction remove(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f15660a) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f15660a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f15660a);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f15660a) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public FragmentTransaction show(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f15660a) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f15662c >= 0) {
            sb2.append(" #");
            sb2.append(this.f15662c);
        }
        if (this.mName != null) {
            sb2.append(" ");
            sb2.append(this.mName);
        }
        sb2.append("}");
        return sb2.toString();
    }
}

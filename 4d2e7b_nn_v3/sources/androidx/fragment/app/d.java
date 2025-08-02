package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;

class d implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f15723a;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f15724a;

        a(h hVar) {
            this.f15724a = hVar;
        }

        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f15724a.k();
            this.f15724a.m();
            n.n((ViewGroup) k10.mView.getParent(), d.this.f15723a).j();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    d(FragmentManager fragmentManager) {
        this.f15723a = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        h hVar;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f15723a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f15723a.findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f15723a.findFragmentByTag(string);
        }
        if (fragment == null && id2 != -1) {
            fragment = this.f15723a.findFragmentById(id2);
        }
        if (fragment == null) {
            fragment = this.f15723a.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id2;
            fragment.mContainerId = id2;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f15723a;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.getHost();
            fragment.onInflate(this.f15723a.getHost().getContext(), attributeSet, fragment.mSavedFragmentState);
            hVar = this.f15723a.addFragment(fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f15723a;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.getHost();
            fragment.onInflate(this.f15723a.getHost().getContext(), attributeSet, fragment.mSavedFragmentState);
            hVar = this.f15723a.createOrGetFragmentStateManager(fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
        }
        fragment.mContainer = (ViewGroup) view;
        hVar.m();
        hVar.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new a(hVar));
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}

package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private b mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<b> mTabs = new ArrayList<>();

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f15632a;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f15632a + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f15632a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f15632a = parcel.readString();
        }
    }

    static class a implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15633a;

        public a(Context context) {
            this.f15633a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f15633a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f15634a;

        /* renamed from: b  reason: collision with root package name */
        final Class f15635b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f15636c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f15637d;

        b(String str, Class cls, Bundle bundle) {
            this.f15634a = str;
            this.f15635b = cls;
            this.f15636c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, (AttributeSet) null);
        initFragmentTabHost(context, (AttributeSet) null);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        b tabInfoForTag = getTabInfoForTag(str);
        if (this.mLastTab != tabInfoForTag) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            b bVar = this.mLastTab;
            if (!(bVar == null || (fragment = bVar.f15637d) == null)) {
                fragmentTransaction.detach(fragment);
            }
            if (tabInfoForTag != null) {
                Fragment fragment2 = tabInfoForTag.f15637d;
                if (fragment2 == null) {
                    Fragment instantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), tabInfoForTag.f15635b.getName());
                    tabInfoForTag.f15637d = instantiate;
                    instantiate.setArguments(tabInfoForTag.f15636c);
                    fragmentTransaction.add(this.mContainerId, tabInfoForTag.f15637d, tabInfoForTag.f15634a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.mLastTab = tabInfoForTag;
        }
        return fragmentTransaction;
    }

    private void ensureContent() {
        if (this.mRealTabContent == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.mContainerId);
            this.mRealTabContent = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
            }
        }
    }

    private void ensureHierarchy(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.mRealTabContent = frameLayout2;
            frameLayout2.setId(this.mContainerId);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    private b getTabInfoForTag(String str) {
        int size = this.mTabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.mTabs.get(i10);
            if (bVar.f15634a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new a(this.mContext));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.mAttached) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(tag);
            bVar.f15637d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                beginTransaction.detach(bVar.f15637d);
                beginTransaction.commit();
            }
        }
        this.mTabs.add(bVar);
        addTab(tabSpec);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.mTabs.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.mTabs.get(i10);
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(bVar.f15634a);
            bVar.f15637d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (bVar.f15634a.equals(currentTabTag)) {
                    this.mLastTab = bVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.mFragmentManager.beginTransaction();
                    }
                    fragmentTransaction.detach(bVar.f15637d);
                }
            }
        }
        this.mAttached = true;
        FragmentTransaction doTabChanged = doTabChanged(currentTabTag, fragmentTransaction);
        if (doTabChanged != null) {
            doTabChanged.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f15632a);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15632a = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction doTabChanged;
        if (this.mAttached && (doTabChanged = doTabChanged(str, (FragmentTransaction) null)) != null) {
            doTabChanged.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        ensureContent();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initFragmentTabHost(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i10) {
        ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i10;
        ensureContent();
        this.mRealTabContent.setId(i10);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}

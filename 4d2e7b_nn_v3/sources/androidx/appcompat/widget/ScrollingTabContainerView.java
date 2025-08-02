package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private c mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    protected ViewPropertyAnimator mVisibilityAnim;

    private class TabView extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f14265a;

        /* renamed from: b  reason: collision with root package name */
        private ActionBar.Tab f14266b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f14267c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f14268d;

        /* renamed from: e  reason: collision with root package name */
        private View f14269e;

        public TabView(Context context, ActionBar.Tab tab, boolean z10) {
            super(context, (AttributeSet) null, R.attr.actionBarTabStyle);
            int[] iArr = {16842964};
            this.f14265a = iArr;
            this.f14266b = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr, R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z10) {
                setGravity(8388627);
            }
            c();
        }

        public void a(ActionBar.Tab tab) {
            this.f14266b = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.f14266b;
        }

        public void c() {
            ActionBar.Tab tab = this.f14266b;
            View customView = tab.getCustomView();
            CharSequence charSequence = null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f14269e = customView;
                TextView textView = this.f14267c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f14268d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f14268d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f14269e;
            if (view != null) {
                removeView(view);
                this.f14269e = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f14268d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f14268d = appCompatImageView;
                }
                this.f14268d.setImageDrawable(icon);
                this.f14268d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f14268d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f14268d.setImageDrawable((Drawable) null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(text);
            if (z10) {
                if (this.f14267c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f14267c = appCompatTextView;
                }
                this.f14267c.setText(text);
                this.f14267c.setVisibility(0);
            } else {
                TextView textView2 = this.f14267c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f14267c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f14268d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            if (!z10) {
                charSequence = tab.getContentDescription();
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i10, int i11) {
            int i12;
            super.onMeasure(i10, i11);
            if (ScrollingTabContainerView.this.mMaxTabWidth > 0 && getMeasuredWidth() > (i12 = ScrollingTabContainerView.this.mMaxTabWidth)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
            }
        }

        public void setSelected(boolean z10) {
            boolean z11;
            if (isSelected() != z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private int mFinalVisibility;

        protected VisibilityAnimListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.mVisibilityAnim = null;
                scrollingTabContainerView.setVisibility(this.mFinalVisibility);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i10) {
            this.mFinalVisibility = i10;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f14271a;

        a(View view) {
            this.f14271a = view;
        }

        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f14271a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f14271a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.mTabSelector = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        public Object getItem(int i10) {
            return ((TabView) ScrollingTabContainerView.this.mTabLayout.getChildAt(i10)).b();
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.createTabView((ActionBar.Tab) getItem(i10), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i10));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            boolean z10;
            ((TabView) view).b().select();
            int childCount = ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = ScrollingTabContainerView.this.mTabLayout.getChildAt(i10);
                if (childAt == view) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                childAt.setSelected(z10);
            }
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat createTabLayout = createTabLayout();
        this.mTabLayout = createTabLayout;
        addView(createTabLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        Spinner spinner = this.mTabSpinner;
        if (spinner == null || spinner.getParent() != this) {
            return false;
        }
        return true;
    }

    private void performCollapse() {
        if (!isCollapsed()) {
            if (this.mTabSpinner == null) {
                this.mTabSpinner = createSpinner();
            }
            removeView(this.mTabLayout);
            addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
            if (this.mTabSpinner.getAdapter() == null) {
                this.mTabSpinner.setAdapter(new b());
            }
            Runnable runnable = this.mTabSelector;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.mTabSelector = null;
            }
            this.mTabSpinner.setSelection(this.mSelectedTabIndex);
        }
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab tab, boolean z10) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            createTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(int i10) {
        View childAt = this.mTabLayout.getChildAt(i10);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.mTabSelector = aVar;
        post(aVar);
    }

    public void animateToVisibility(int i10) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200);
            alpha.setInterpolator(sAlphaInterpolator);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i10));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
        alpha2.setDuration(200);
        alpha2.setInterpolator(sAlphaInterpolator);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i10));
        alpha2.start();
    }

    /* access modifiers changed from: package-private */
    public TabView createTabView(ActionBar.Tab tab, boolean z10) {
        TabView tabView = new TabView(getContext(), tab, z10);
        if (z10) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new c();
            }
            tabView.setOnClickListener(this.mTabClickListener);
        }
        return tabView;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((TabView) view).b().select();
    }

    public void onMeasure(int i10, int i11) {
        boolean z10;
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        setFillViewport(z10);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = -1;
        } else {
            if (childCount > 2) {
                this.mMaxTabWidth = (int) (((float) View.MeasureSpec.getSize(i10)) * 0.4f);
            } else {
                this.mMaxTabWidth = View.MeasureSpec.getSize(i10) / 2;
            }
            this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (z10 || !this.mAllowCollapse) {
            performExpand();
        } else {
            this.mTabLayout.measure(0, makeMeasureSpec);
            if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                performCollapse();
            } else {
                performExpand();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z10 && measuredWidth != measuredWidth2) {
            setTabSelected(this.mSelectedTabIndex);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i10) {
        this.mTabLayout.removeViewAt(i10);
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z10) {
        this.mAllowCollapse = z10;
    }

    public void setContentHeight(int i10) {
        this.mContentHeight = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        boolean z10;
        this.mSelectedTabIndex = i10;
        int childCount = this.mTabLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.mTabLayout.getChildAt(i11);
            if (i11 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            childAt.setSelected(z10);
            if (z10) {
                animateToTab(i10);
            }
        }
        Spinner spinner = this.mTabSpinner;
        if (spinner != null && i10 >= 0) {
            spinner.setSelection(i10);
        }
    }

    public void updateTab(int i10) {
        ((TabView) this.mTabLayout.getChildAt(i10)).c();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i10, boolean z10) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, i10, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            createTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}

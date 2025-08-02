package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    boolean mContentAnimations = true;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener = new a();
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private boolean mNowShowing = true;
    ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener = new b();
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private Context mThemedContext;
    final ViewPropertyAnimatorUpdateListener mUpdateListener = new c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode == this) {
                if (!WindowDecorActionBar.checkShowingFlags(windowDecorActionBar.mHiddenByApp, windowDecorActionBar.mHiddenBySystem, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.mDeferredDestroyActionMode = this;
                    windowDecorActionBar2.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.mContextView.closeMode();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
                WindowDecorActionBar.this.mActionMode = null;
            }
        }

        public View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                WindowDecorActionBar.this.mContextView.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z10) {
            super.setTitleOptionalHint(z10);
            WindowDecorActionBar.this.mContextView.setTitleOptional(z10);
        }

        public void setSubtitle(int i10) {
            setSubtitle((CharSequence) WindowDecorActionBar.this.mContext.getResources().getString(i10));
        }

        public void setTitle(int i10) {
            setTitle((CharSequence) WindowDecorActionBar.this.mContext.getResources().getString(i10));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int i10) {
            return setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(i10));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            int i10 = this.mPosition;
            if (i10 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i10);
            }
            return this;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            int i10 = this.mPosition;
            if (i10 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i10);
            }
            return this;
        }

        public void setPosition(int i10) {
            this.mPosition = i10;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            int i10 = this.mPosition;
            if (i10 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i10);
            }
            return this;
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            int i10 = this.mPosition;
            if (i10 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i10);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i10) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i10, (ViewGroup) null));
        }

        public ActionBar.Tab setIcon(int i10) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, i10));
        }

        public ActionBar.Tab setText(int i10) {
            return setText(WindowDecorActionBar.this.mContext.getResources().getText(i10));
        }
    }

    class a extends ViewPropertyAnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.mContainerView.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.mCurrentShowAnim = null;
            windowDecorActionBar2.completeDeferredDestroyActionMode();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    class b extends ViewPropertyAnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.mCurrentShowAnim = null;
            windowDecorActionBar.mContainerView.requestLayout();
        }
    }

    class c implements ViewPropertyAnimatorUpdateListener {
        c() {
        }

        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z10) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z10) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    static boolean checkShowingFlags(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return !z10 && !z11;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab tab, int i10) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i10);
            this.mTabs.add(i10, tabImpl);
            int size = this.mTabs.size();
            while (true) {
                i10++;
                if (i10 < size) {
                    this.mTabs.get(i10).setPosition(i10);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(0);
                this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.mContainerView.setTabContainer(scrollingTabContainerView);
            }
            this.mTabScrollView = scrollingTabContainerView;
        }
    }

    private DecorToolbar getDecorToolbar(View view) {
        String str;
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb2.append(str);
        throw new IllegalStateException(sb2.toString());
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view) {
        boolean z10;
        boolean z11;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.mDecorToolbar = getDecorToolbar(view.findViewById(R.id.action_bar));
        this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || this.mContextView == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = decorToolbar.getContext();
        if ((this.mDecorToolbar.getDisplayOptions() & 4) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.mDisplayHomeAsUpSet = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
        if (actionBarPolicy.enableHomeButtonByDefault() || z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        setHomeButtonEnabled(z11);
        setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void setHasEmbeddedTabs(boolean z10) {
        boolean z11;
        boolean z12;
        this.mHasEmbeddedTabs = z10;
        if (!z10) {
            this.mDecorToolbar.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        } else {
            this.mContainerView.setTabContainer((ScrollingTabContainerView) null);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }
        boolean z13 = true;
        if (getNavigationMode() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            if (z11) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (this.mHasEmbeddedTabs || !z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        decorToolbar.setCollapsible(z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !z11) {
            z13 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z13);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.mContainerView);
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean z10) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z10);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z10);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z10) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z10) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (shouldAnimateContextView()) {
            if (z10) {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(4, FADE_OUT_DURATION_MS);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
            } else {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(8, FADE_OUT_DURATION_MS);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.start();
        } else if (z10) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback = this.mDeferredModeDestroyCallback;
        if (callback != null) {
            callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z10) {
        if (z10 != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z10;
            int size = this.mMenuVisibilityListeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mMenuVisibilityListeners.get(i10).onMenuVisibilityChanged(z10);
            }
        }
    }

    public void doHide(boolean z10) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z10)) {
            this.mHideListener.onAnimationEnd((View) null);
            return;
        }
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f10 = (float) (-this.mContainerView.getHeight());
        if (z10) {
            int[] iArr = {0, 0};
            this.mContainerView.getLocationInWindow(iArr);
            f10 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(f10);
        translationY.setUpdateListener(this.mUpdateListener);
        viewPropertyAnimatorCompatSet2.play(translationY);
        if (this.mContentAnimations && (view = this.mContentView) != null) {
            viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f10));
        }
        viewPropertyAnimatorCompatSet2.setInterpolator(sHideInterpolator);
        viewPropertyAnimatorCompatSet2.setDuration(250);
        viewPropertyAnimatorCompatSet2.setListener(this.mHideListener);
        this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.start();
    }

    public void doShow(boolean z10) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z10)) {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            if (this.mContentAnimations && (view = this.mContentView) != null) {
                view.setTranslationY(0.0f);
            }
            this.mShowListener.onAnimationEnd((View) null);
        } else {
            this.mContainerView.setTranslationY(0.0f);
            float f10 = (float) (-this.mContainerView.getHeight());
            if (z10) {
                int[] iArr = {0, 0};
                this.mContainerView.getLocationInWindow(iArr);
                f10 -= (float) iArr[1];
            }
            this.mContainerView.setTranslationY(f10);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(0.0f);
            translationY.setUpdateListener(this.mUpdateListener);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                view2.setTranslationY(f10);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(sShowInterpolator);
            viewPropertyAnimatorCompatSet2.setDuration(250);
            viewPropertyAnimatorCompatSet2.setListener(this.mShowListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean z10) {
        this.mContentAnimations = z10;
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mContainerView);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            return this.mDecorToolbar.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.mTabs.size();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            return this.mDecorToolbar.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.mSelectedTab) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i10) {
        return this.mTabs.get(i10);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i10);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int height = getHeight();
        if (!this.mNowShowing || (height != 0 && getHideOffset() >= height)) {
            return false;
        }
        return true;
    }

    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || !decorToolbar.isTitleTruncated()) {
            return false;
        }
        return true;
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.mCurrentShowAnim = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int i10, KeyEvent keyEvent) {
        Menu menu;
        int i11;
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i11 = keyEvent.getDeviceId();
        } else {
            i11 = -1;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(i11).getKeyboardType() == 1) {
            z10 = false;
        }
        menu.setQwertyMode(z10);
        return menu.performShortcut(i10, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i10) {
        this.mCurWindowVisibility = i10;
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i10) {
        int i11;
        ActionBar.Tab tab;
        if (this.mTabScrollView != null) {
            TabImpl tabImpl = this.mSelectedTab;
            if (tabImpl != null) {
                i11 = tabImpl.getPosition();
            } else {
                i11 = this.mSavedTabPosition;
            }
            this.mTabScrollView.removeTabAt(i10);
            TabImpl remove = this.mTabs.remove(i10);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i12 = i10; i12 < size; i12++) {
                this.mTabs.get(i12).setPosition(i12);
            }
            if (i11 == i10) {
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    tab = this.mTabs.get(Math.max(0, i10 - 1));
                }
                selectTab(tab);
            }
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        int i10 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i10 = tab.getPosition();
            }
            this.mSavedTabPosition = i10;
            return;
        }
        if (!(this.mActivity instanceof FragmentActivity) || this.mDecorToolbar.getViewGroup().isInEditMode()) {
            fragmentTransaction = null;
        } else {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i10 = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i10);
            TabImpl tabImpl2 = this.mSelectedTab;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.mSelectedTab = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i10) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i10, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z10) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z10);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 4);
    }

    public void setDisplayOptions(int i10) {
        if ((i10 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(i10);
    }

    public void setDisplayShowCustomEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 16;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        setDisplayOptions(i10, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z10) {
        setDisplayOptions(z10 ? 1 : 0, 1);
    }

    public void setElevation(float f10) {
        ViewCompat.setElevation(this.mContainerView, f10);
    }

    public void setHideOffset(int i10) {
        if (i10 == 0 || this.mOverlayLayout.isInOverlayMode()) {
            this.mOverlayLayout.setActionBarHideOffset(i10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (!z10 || this.mOverlayLayout.isInOverlayMode()) {
            this.mHideOnContentScroll = z10;
            this.mOverlayLayout.setHideOnContentScrollEnabled(z10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z10) {
        this.mDecorToolbar.setHomeButtonEnabled(z10);
    }

    public void setIcon(int i10) {
        this.mDecorToolbar.setIcon(i10);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new v(onNavigationListener));
    }

    public void setLogo(int i10) {
        this.mDecorToolbar.setLogo(i10);
    }

    public void setNavigationMode(int i10) {
        boolean z10;
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab((ActionBar.Tab) null);
            this.mTabScrollView.setVisibility(8);
        }
        if (!(navigationMode == i10 || this.mHasEmbeddedTabs || (actionBarOverlayLayout = this.mOverlayLayout) == null)) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.mDecorToolbar.setNavigationMode(i10);
        boolean z11 = false;
        if (i10 == 2) {
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            int i11 = this.mSavedTabPosition;
            if (i11 != -1) {
                setSelectedNavigationItem(i11);
                this.mSavedTabPosition = -1;
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (i10 != 2 || this.mHasEmbeddedTabs) {
            z10 = false;
        } else {
            z10 = true;
        }
        decorToolbar.setCollapsible(z10);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (i10 == 2 && !this.mHasEmbeddedTabs) {
            z11 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z11);
    }

    public void setSelectedNavigationItem(int i10) {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(i10);
        } else if (navigationMode == 2) {
            selectTab(this.mTabs.get(i10));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z10) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z10;
        if (!z10 && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public void setSubtitle(int i10) {
        setSubtitle((CharSequence) this.mContext.getString(i10));
    }

    public void setTitle(int i10) {
        setTitle((CharSequence) this.mContext.getString(i10));
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.mActionMode = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.mContextView.initForMode(actionModeImpl2);
        animateToMode(true);
        return actionModeImpl2;
    }

    public void addTab(ActionBar.Tab tab, int i10) {
        addTab(tab, i10, this.mTabs.isEmpty());
    }

    public void setHomeActionContentDescription(int i10) {
        this.mDecorToolbar.setNavigationContentDescription(i10);
    }

    public void setHomeAsUpIndicator(int i10) {
        this.mDecorToolbar.setNavigationIcon(i10);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void addTab(ActionBar.Tab tab, boolean z10) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, z10);
        configureTab(tab, this.mTabs.size());
        if (z10) {
            selectTab(tab);
        }
    }

    public void setDisplayOptions(int i10, int i11) {
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((i11 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((i10 & i11) | ((~i11) & displayOptions));
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void addTab(ActionBar.Tab tab, int i10, boolean z10) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, i10, z10);
        configureTab(tab, i10);
        if (z10) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        init(view);
    }
}

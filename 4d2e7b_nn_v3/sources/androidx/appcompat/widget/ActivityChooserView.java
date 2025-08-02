package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final f mAdapter;
    private final g mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, TINT_ATTRS);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    class a extends DataSetObserver {
        a() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.mAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!ActivityChooserView.this.isShowingPopup()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().show();
            ActionProvider actionProvider = ActivityChooserView.this.mProvider;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
        }
    }

    class c extends View.AccessibilityDelegate {
        c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    class d extends ForwardingListener {
        d(View view) {
            super(view);
        }

        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    class e extends DataSetObserver {
        e() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.updateAppearance();
        }
    }

    private class f extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private ActivityChooserModel f14170a;

        /* renamed from: b  reason: collision with root package name */
        private int f14171b = 4;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14172c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14173d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14174e;

        f() {
        }

        public int a() {
            return this.f14170a.f();
        }

        public ActivityChooserModel b() {
            return this.f14170a;
        }

        public ResolveInfo c() {
            return this.f14170a.h();
        }

        public int d() {
            return this.f14170a.i();
        }

        public boolean e() {
            return this.f14172c;
        }

        public int f() {
            int i10 = this.f14171b;
            this.f14171b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i11 = 0;
            View view = null;
            for (int i12 = 0; i12 < count; i12++) {
                view = getView(i12, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i11 = Math.max(i11, view.getMeasuredWidth());
            }
            this.f14171b = i10;
            return i11;
        }

        public void g(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel b10 = ActivityChooserView.this.mAdapter.b();
            if (b10 != null && ActivityChooserView.this.isShown()) {
                b10.unregisterObserver(ActivityChooserView.this.mModelDataSetObserver);
            }
            this.f14170a = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.mModelDataSetObserver);
            }
            notifyDataSetChanged();
        }

        public int getCount() {
            int f10 = this.f14170a.f();
            if (!this.f14172c && this.f14170a.h() != null) {
                f10--;
            }
            int min = Math.min(f10, this.f14171b);
            if (this.f14174e) {
                return min + 1;
            }
            return min;
        }

        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                if (!this.f14172c && this.f14170a.h() != null) {
                    i10++;
                }
                return this.f14170a.e(i10);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public int getItemViewType(int i10) {
            if (!this.f14174e || i10 != getCount() - 1) {
                return 0;
            }
            return 1;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f14172c || i10 != 0 || !this.f14173d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i10) {
            if (this.f14171b != i10) {
                this.f14171b = i10;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z10, boolean z11) {
            if (this.f14172c != z10 || this.f14173d != z11) {
                this.f14172c = z10;
                this.f14173d = z11;
                notifyDataSetChanged();
            }
        }

        public void j(boolean z10) {
            if (this.f14174e != z10) {
                this.f14174e = z10;
                notifyDataSetChanged();
            }
        }
    }

    private class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.mDefaultActivityButton) {
                activityChooserView.dismissPopup();
                Intent b10 = ActivityChooserView.this.mAdapter.b().b(ActivityChooserView.this.mAdapter.b().g(ActivityChooserView.this.mAdapter.c()));
                if (b10 != null) {
                    b10.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b10);
                }
            } else if (view == activityChooserView.mExpandActivityOverflowButton) {
                activityChooserView.mIsSelectingDefaultActivity = false;
                activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.mProvider;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType == 0) {
                ActivityChooserView.this.dismissPopup();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.mIsSelectingDefaultActivity) {
                    if (!activityChooserView.mAdapter.e()) {
                        i10++;
                    }
                    Intent b10 = ActivityChooserView.this.mAdapter.b().b(i10);
                    if (b10 != null) {
                        b10.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b10);
                    }
                } else if (i10 > 0) {
                    activityChooserView.mAdapter.b().o(i10);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.showPopupUnchecked(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.mDefaultActivityButton) {
                if (activityChooserView.mAdapter.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.mIsSelectingDefaultActivity = true;
                    activityChooserView2.showPopupUnchecked(activityChooserView2.mInitialActivityCount);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ActivityChooserModel getDataModel() {
        return this.mAdapter.b();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(this.mAdapter);
            this.mListPopupWindow.setAnchorView(this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel b10 = this.mAdapter.b();
        if (b10 != null) {
            b10.registerObserver(this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel b10 = this.mAdapter.b();
        if (b10 != null) {
            b10.unregisterObserver(this.mModelDataSetObserver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.mActivityChooserContent.layout(0, 0, i12 - i10, i13 - i11);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        View view = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.mAdapter.g(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.mDefaultActionButtonContentDescription = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.mInitialActivityCount = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void showPopupUnchecked(int i10) {
        boolean z10;
        if (this.mAdapter.b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            if (this.mDefaultActivityButton.getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int a10 = this.mAdapter.a();
            if (i10 == Integer.MAX_VALUE || a10 <= i10 + (z10 ? 1 : 0)) {
                this.mAdapter.j(false);
                this.mAdapter.h(i10);
            } else {
                this.mAdapter.j(true);
                this.mAdapter.h(i10 - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (this.mIsSelectingDefaultActivity || !z10) {
                    this.mAdapter.i(true, z10);
                } else {
                    this.mAdapter.i(false, false);
                }
                listPopupWindow.setContentWidth(Math.min(this.mAdapter.f(), this.mListPopupMaxWidth));
                listPopupWindow.show();
                ActionProvider actionProvider = this.mProvider;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
                listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    public void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int a10 = this.mAdapter.a();
        int d10 = this.mAdapter.d();
        if (a10 == 1 || (a10 > 1 && d10 > 0)) {
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo c10 = this.mAdapter.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(c10.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                CharSequence loadLabel = c10.loadLabel(packageManager);
                this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{loadLabel}));
            }
        } else {
            this.mDefaultActivityButton.setVisibility(8);
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable((Drawable) null);
        }
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mModelDataSetObserver = new a();
        this.mOnGlobalLayoutListener = new b();
        this.mInitialActivityCount = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i10, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        g gVar = new g();
        this.mCallbacks = gVar;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = findViewById;
        this.mActivityChooserContentBackground = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        this.mDefaultActivityButtonImage = (ImageView) frameLayout.findViewById(R.id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.mExpandActivityOverflowButton = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.image);
        this.mExpandActivityOverflowButtonImage = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.mAdapter = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}

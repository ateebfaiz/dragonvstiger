package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    @StyleableRes
    @SuppressLint({"ResourceType"})
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {16843505};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private i mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f14194a;

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

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f14194a ? (byte) 1 : 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f14194a = parcel.readByte() != 0;
        }
    }

    class a extends ForwardingListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f14195a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f14195a = hVar;
        }

        public ShowableListMenu getPopup() {
            return this.f14195a;
        }

        public boolean onForwardingStarted() {
            if (AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            AppCompatSpinner.this.showPopup();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.showPopup();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    private static final class c {
        @DoNotInline
        static void a(@NonNull ViewTreeObserver viewTreeObserver, @Nullable ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private static final class d {
        @DoNotInline
        static int a(@NonNull View view) {
            return view.getTextAlignment();
        }

        @DoNotInline
        static int b(@NonNull View view) {
            return view.getTextDirection();
        }

        @DoNotInline
        static void c(@NonNull View view, int i10) {
            view.setTextAlignment(i10);
        }

        @DoNotInline
        static void d(@NonNull View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    private static final class e {
        @DoNotInline
        static void a(@NonNull ThemedSpinnerAdapter themedSpinnerAdapter, @Nullable Resources.Theme theme) {
            if (!ObjectsCompat.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    class f implements i, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        AlertDialog f14198a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f14199b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f14200c;

        f() {
        }

        public CharSequence a() {
            return this.f14200c;
        }

        public void b(CharSequence charSequence) {
            this.f14200c = charSequence;
        }

        public void c(int i10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void d(int i10, int i11) {
            if (this.f14199b != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f14200c;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                AlertDialog create = builder.setSingleChoiceItems(this.f14199b, AppCompatSpinner.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                this.f14198a = create;
                ListView listView = create.getListView();
                d.d(listView, i10);
                d.c(listView, i11);
                this.f14198a.show();
            }
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f14198a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f14198a = null;
            }
        }

        public Drawable getBackground() {
            return null;
        }

        public int getHorizontalOffset() {
            return 0;
        }

        public int getVerticalOffset() {
            return 0;
        }

        public boolean isShowing() {
            AlertDialog alertDialog = this.f14198a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i10, this.f14199b.getItemId(i10));
            }
            dismiss();
        }

        public void setAdapter(ListAdapter listAdapter) {
            this.f14199b = listAdapter;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int i10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void setVerticalOffset(int i10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    private static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f14202a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f14203b;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f14202a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f14203b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f14203b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i10);
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter == null || !spinnerAdapter.hasStableIds()) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f14203b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f14202a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class h extends ListPopupWindow implements i {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f14204a;

        /* renamed from: b  reason: collision with root package name */
        ListAdapter f14205b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f14206c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private int f14207d;

        class a implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppCompatSpinner f14209a;

            a(AppCompatSpinner appCompatSpinner) {
                this.f14209a = appCompatSpinner;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    AppCompatSpinner.this.performItemClick(view, i10, hVar.f14205b.getItemId(i10));
                }
                h.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.h(AppCompatSpinner.this)) {
                    h.this.dismiss();
                    return;
                }
                h.this.f();
                h.super.show();
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f14212a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f14212a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f14212a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new a(AppCompatSpinner.this));
        }

        public CharSequence a() {
            return this.f14204a;
        }

        public void b(CharSequence charSequence) {
            this.f14204a = charSequence;
        }

        public void c(int i10) {
            this.f14207d = i10;
        }

        public void d(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            f();
            setInputMethodMode(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            d.d(listView, i10);
            d.c(listView, i11);
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                setOnDismissListener(new c(bVar));
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i10;
            int i11;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                    i10 = AppCompatSpinner.this.mTempRect.right;
                } else {
                    i10 = -AppCompatSpinner.this.mTempRect.left;
                }
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i12 = appCompatSpinner.mDropDownWidth;
            if (i12 == -2) {
                int compatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((SpinnerAdapter) this.f14205b, getBackground());
                int i13 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.mTempRect;
                int i14 = (i13 - rect2.left) - rect2.right;
                if (compatMeasureContentWidth > i14) {
                    compatMeasureContentWidth = i14;
                }
                setContentWidth(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i12 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i12);
            }
            if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                i11 = i10 + (((width - paddingRight) - getWidth()) - g());
            } else {
                i11 = i10 + paddingLeft + g();
            }
            setHorizontalOffset(i11);
        }

        public int g() {
            return this.f14207d;
        }

        /* access modifiers changed from: package-private */
        public boolean h(View view) {
            if (!ViewCompat.isAttachedToWindow(view) || !view.getGlobalVisibleRect(this.f14206c)) {
                return false;
            }
            return true;
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f14205b = listAdapter;
        }
    }

    interface i {
        CharSequence a();

        void b(CharSequence charSequence);

        void c(int i10);

        void d(int i10, int i11);

        void dismiss();

        Drawable getBackground();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i10);

        void setVerticalOffset(int i10);
    }

    public AppCompatSpinner(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.mTempRect);
        Rect rect = this.mTempRect;
        return i11 + rect.left + rect.right;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        i iVar = this.mPopup;
        if (iVar != null) {
            return iVar.getHorizontalOffset();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        i iVar = this.mPopup;
        if (iVar != null) {
            return iVar.getVerticalOffset();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        return super.getDropDownWidth();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final i getInternalPopup() {
        return this.mPopup;
    }

    public Drawable getPopupBackground() {
        i iVar = this.mPopup;
        if (iVar != null) {
            return iVar.getBackground();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public CharSequence getPrompt() {
        i iVar = this.mPopup;
        if (iVar != null) {
            return iVar.a();
        }
        return super.getPrompt();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.mPopup;
        if (iVar != null && iVar.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mPopup != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f14194a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        i iVar = this.mPopup;
        if (iVar == null || !iVar.isShowing()) {
            z10 = false;
        } else {
            z10 = true;
        }
        savedState.f14194a = z10;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        i iVar = this.mPopup;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.isShowing()) {
            return true;
        }
        showPopup();
        return true;
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i10) {
        super.setBackgroundResource(i10);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i10);
        }
    }

    public void setDropDownHorizontalOffset(int i10) {
        i iVar = this.mPopup;
        if (iVar != null) {
            iVar.c(i10);
            this.mPopup.setHorizontalOffset(i10);
            return;
        }
        super.setDropDownHorizontalOffset(i10);
    }

    public void setDropDownVerticalOffset(int i10) {
        i iVar = this.mPopup;
        if (iVar != null) {
            iVar.setVerticalOffset(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    public void setDropDownWidth(int i10) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.mPopup;
        if (iVar != null) {
            iVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i10) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i10));
    }

    public void setPrompt(CharSequence charSequence) {
        i iVar = this.mPopup;
        if (iVar != null) {
            iVar.b(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void showPopup() {
        this.mPopup.d(d.b(this), d.a(this));
    }

    public AppCompatSpinner(@NonNull Context context, int i10) {
        this(context, (AttributeSet) null, R.attr.spinnerStyle, i10);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.setAdapter(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r11 != null) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.mTempRect = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r6, r0)
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.AppCompatBackgroundHelper r2 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r2.<init>(r6)
            r6.mBackgroundTintHelper = r2
            if (r11 == 0) goto L_0x0029
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.mPopupContext = r2
            goto L_0x003b
        L_0x0029:
            int r11 = androidx.appcompat.R.styleable.Spinner_popupTheme
            int r11 = r0.getResourceId(r11, r1)
            if (r11 == 0) goto L_0x0039
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.mPopupContext = r2
            goto L_0x003b
        L_0x0039:
            r6.mPopupContext = r7
        L_0x003b:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006d
            int[] r11 = ATTRS_ANDROID_SPINNERMODE     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0053 }
            if (r3 == 0) goto L_0x0055
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0055
        L_0x0050:
            r7 = move-exception
            r2 = r11
            goto L_0x0067
        L_0x0053:
            r3 = move-exception
            goto L_0x005d
        L_0x0055:
            r11.recycle()
            goto L_0x006d
        L_0x0059:
            r7 = move-exception
            goto L_0x0067
        L_0x005b:
            r3 = move-exception
            r11 = r2
        L_0x005d:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x006d
            goto L_0x0055
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.recycle()
        L_0x006c:
            throw r7
        L_0x006d:
            r11 = 1
            if (r10 == 0) goto L_0x00aa
            if (r10 == r11) goto L_0x0073
            goto L_0x00ba
        L_0x0073:
            androidx.appcompat.widget.AppCompatSpinner$h r10 = new androidx.appcompat.widget.AppCompatSpinner$h
            android.content.Context r3 = r6.mPopupContext
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.mPopupContext
            int[] r4 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.getLayoutDimension((int) r3, (int) r4)
            r6.mDropDownWidth = r3
            int r3 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.getDrawable(r3)
            r10.setBackgroundDrawable(r3)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r3 = r0.getString(r3)
            r10.b(r3)
            r1.recycle()
            r6.mPopup = r10
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r6, r10)
            r6.mForwardingListener = r1
            goto L_0x00ba
        L_0x00aa:
            androidx.appcompat.widget.AppCompatSpinner$f r10 = new androidx.appcompat.widget.AppCompatSpinner$f
            r10.<init>()
            r6.mPopup = r10
            int r1 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.getString(r1)
            r10.b(r1)
        L_0x00ba:
            int r10 = androidx.appcompat.R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.getTextArray(r10)
            if (r10 == 0) goto L_0x00d2
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d2:
            r0.recycle()
            r6.mPopupSet = r11
            android.widget.SpinnerAdapter r7 = r6.mTempAdapter
            if (r7 == 0) goto L_0x00e0
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.mTempAdapter = r2
        L_0x00e0:
            androidx.appcompat.widget.AppCompatBackgroundHelper r7 = r6.mBackgroundTintHelper
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}

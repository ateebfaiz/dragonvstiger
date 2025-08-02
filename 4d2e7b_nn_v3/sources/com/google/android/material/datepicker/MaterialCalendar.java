package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends g {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    @VisibleForTesting
    static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting
    static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting
    static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    @VisibleForTesting
    static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    /* access modifiers changed from: private */
    @Nullable
    public CalendarConstraints calendarConstraints;
    private k calendarSelector;
    /* access modifiers changed from: private */
    public b calendarStyle;
    /* access modifiers changed from: private */
    @Nullable
    public Month current;
    /* access modifiers changed from: private */
    @Nullable
    public DateSelector<S> dateSelector;
    /* access modifiers changed from: private */
    public View dayFrame;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    @StyleRes
    private int themeResId;
    private View yearFrame;
    /* access modifiers changed from: private */
    public RecyclerView yearSelector;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8116a;

        a(int i10) {
            this.f8116a = i10;
        }

        public void run() {
            MaterialCalendar.this.recyclerView.smoothScrollToPosition(this.f8116a);
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
        }
    }

    class c extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f8119a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f8119a = i11;
        }

        /* access modifiers changed from: protected */
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.f8119a == 0) {
                iArr[0] = MaterialCalendar.this.recyclerView.getWidth();
                iArr[1] = MaterialCalendar.this.recyclerView.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.recyclerView.getHeight();
            iArr[1] = MaterialCalendar.this.recyclerView.getHeight();
        }
    }

    class d implements l {
        d() {
        }

        public void a(long j10) {
            if (MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(j10)) {
                MaterialCalendar.this.dateSelector.select(j10);
                Iterator<OnSelectionChangedListener<Object>> it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
                }
                MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.yearSelector != null) {
                    MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    class e extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f8122a = k.q();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f8123b = k.q();

        e() {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i10;
            int i11;
            if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair next : MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                    F f10 = next.first;
                    if (!(f10 == null || next.second == null)) {
                        this.f8122a.setTimeInMillis(((Long) f10).longValue());
                        this.f8123b.setTimeInMillis(((Long) next.second).longValue());
                        int c10 = yearGridAdapter.c(this.f8122a.get(1));
                        int c11 = yearGridAdapter.c(this.f8123b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(c10);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(c11);
                        int spanCount = c10 / gridLayoutManager.getSpanCount();
                        int spanCount2 = c11 / gridLayoutManager.getSpanCount();
                        for (int i12 = spanCount; i12 <= spanCount2; i12++) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i12);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.this.calendarStyle.f8184d.c();
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.calendarStyle.f8184d.b();
                                if (i12 == spanCount) {
                                    i10 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                } else {
                                    i10 = 0;
                                }
                                if (i12 == spanCount2) {
                                    i11 = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    i11 = recyclerView.getWidth();
                                }
                                canvas.drawRect((float) i10, (float) top, (float) i11, (float) bottom, MaterialCalendar.this.calendarStyle.f8188h);
                            }
                        }
                    }
                }
            }
        }
    }

    class f extends AccessibilityDelegateCompat {
        f() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (MaterialCalendar.this.dayFrame.getVisibility() == 0) {
                str = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
                str = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
            }
            accessibilityNodeInfoCompat.setHintText(str);
        }
    }

    class g extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f8126a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f8127b;

        g(MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
            this.f8126a = monthsPagerAdapter;
            this.f8127b = materialButton;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f8127b.getText());
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int i12;
            if (i10 < 0) {
                i12 = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
            } else {
                i12 = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
            }
            Month unused = MaterialCalendar.this.current = this.f8126a.b(i12);
            this.f8127b.setText(this.f8126a.c(i12));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View view) {
            MaterialCalendar.this.toggleVisibleSelector();
        }
    }

    class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f8130a;

        i(MonthsPagerAdapter monthsPagerAdapter) {
            this.f8130a = monthsPagerAdapter;
        }

        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                MaterialCalendar.this.setCurrentMonth(this.f8130a.b(findFirstVisibleItemPosition));
            }
        }
    }

    class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f8132a;

        j(MonthsPagerAdapter monthsPagerAdapter) {
            this.f8132a = monthsPagerAdapter;
        }

        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.setCurrentMonth(this.f8132a.b(findLastVisibleItemPosition));
            }
        }
    }

    enum k {
        DAY,
        YEAR
    }

    interface l {
        void a(long j10);
    }

    private void addActionsToMonthNavigation(@NonNull View view, @NonNull MonthsPagerAdapter monthsPagerAdapter) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(NAVIGATION_PREV_TAG);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(k.DAY);
        materialButton.setText(this.current.h());
        this.recyclerView.addOnScrollListener(new g(monthsPagerAdapter, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(monthsPagerAdapter));
        materialButton2.setOnClickListener(new j(monthsPagerAdapter));
    }

    @NonNull
    private RecyclerView.ItemDecoration createItemDecoration() {
        return new e();
    }

    @Px
    static int getDayHeight(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i10 = f.f8203f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> dateSelector2, @StyleRes int i10, @NonNull CalendarConstraints calendarConstraints2) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i10);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector2);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints2);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints2.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void postSmoothRecyclerViewScroll(int i10) {
        this.recyclerView.post(new a(i10));
    }

    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    /* access modifiers changed from: package-private */
    public b getCalendarStyle() {
        return this.calendarStyle;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Month getCurrentMonth() {
        return this.current;
    }

    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (Month) bundle.getParcelable(CURRENT_MONTH_KEY);
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i11 = R.layout.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i11 = R.layout.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i11, viewGroup, false);
        inflate.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b());
        gridView.setAdapter(new e());
        gridView.setNumColumns(start.f8152d);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new c(getContext(), i10, false, i10));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new d());
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView2;
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(inflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.d(this.current));
        return inflate;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentMonth(Month month) {
        boolean z10;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int d10 = monthsPagerAdapter.d(month);
        int d11 = d10 - monthsPagerAdapter.d(this.current);
        boolean z11 = false;
        if (Math.abs(d11) > 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (d11 > 0) {
            z11 = true;
        }
        this.current = month;
        if (z10 && z11) {
            this.recyclerView.scrollToPosition(d10 - 3);
            postSmoothRecyclerViewScroll(d10);
        } else if (z10) {
            this.recyclerView.scrollToPosition(d10 + 3);
            postSmoothRecyclerViewScroll(d10);
        } else {
            postSmoothRecyclerViewScroll(d10);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSelector(k kVar) {
        this.calendarSelector = kVar;
        if (kVar == k.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).c(this.current.f8151c));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    /* access modifiers changed from: package-private */
    public void toggleVisibleSelector() {
        k kVar = this.calendarSelector;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            setSelector(k.DAY);
        } else if (kVar == k.DAY) {
            setSelector(kVar2);
        }
    }
}

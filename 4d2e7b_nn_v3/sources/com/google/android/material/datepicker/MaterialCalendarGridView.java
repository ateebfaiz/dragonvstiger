package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f8137a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8138b;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().i());
        } else if (i10 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    private View c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l10, Long l11, Long l12, Long l13) {
        if (l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public f getAdapter() {
        return (f) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        f b10 = getAdapter();
        DateSelector dateSelector = b10.f8205b;
        b bVar = b10.f8207d;
        int max = Math.max(b10.b(), getFirstVisiblePosition());
        int min = Math.min(b10.i(), getLastVisiblePosition());
        Long c10 = b10.getItem(max);
        Long c11 = b10.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            F f10 = next.first;
            if (f10 == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                Long l10 = (Long) f10;
                long longValue = l10.longValue();
                Long l11 = (Long) next.second;
                long longValue2 = l11.longValue();
                if (!e(c10, c11, l10, l11)) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (longValue < c10.longValue()) {
                        if (b10.f(max)) {
                            i19 = 0;
                        } else if (!isLayoutRtl) {
                            i19 = materialCalendarGridView.c(max - 1).getRight();
                        } else {
                            i19 = materialCalendarGridView.c(max - 1).getLeft();
                        }
                        i10 = i19;
                        i11 = max;
                    } else {
                        materialCalendarGridView.f8137a.setTimeInMillis(longValue);
                        i11 = b10.a(materialCalendarGridView.f8137a.get(5));
                        i10 = d(materialCalendarGridView.c(i11));
                    }
                    if (longValue2 > c11.longValue()) {
                        if (b10.g(min)) {
                            i18 = getWidth();
                        } else if (!isLayoutRtl) {
                            i18 = materialCalendarGridView.c(min).getRight();
                        } else {
                            i18 = materialCalendarGridView.c(min).getLeft();
                        }
                        i12 = i18;
                        i13 = min;
                    } else {
                        materialCalendarGridView.f8137a.setTimeInMillis(longValue2);
                        i13 = b10.a(materialCalendarGridView.f8137a.get(5));
                        i12 = d(materialCalendarGridView.c(i13));
                    }
                    int itemId = (int) b10.getItemId(i11);
                    int i20 = max;
                    int i21 = min;
                    int itemId2 = (int) b10.getItemId(i13);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View c12 = materialCalendarGridView.c(numColumns);
                        int top = c12.getTop() + bVar.f8181a.c();
                        f fVar = b10;
                        int bottom = c12.getBottom() - bVar.f8181a.b();
                        if (!isLayoutRtl) {
                            if (numColumns > i11) {
                                i15 = 0;
                            } else {
                                i15 = i10;
                            }
                            if (i13 > numColumns2) {
                                i14 = getWidth();
                            } else {
                                i14 = i12;
                            }
                        } else {
                            if (i13 > numColumns2) {
                                i16 = 0;
                            } else {
                                i16 = i12;
                            }
                            if (numColumns > i11) {
                                i17 = getWidth();
                            } else {
                                i17 = i10;
                            }
                            int i22 = i16;
                            i14 = i17;
                            i15 = i22;
                        }
                        canvas.drawRect((float) i15, (float) top, (float) i14, (float) bottom, bVar.f8188h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        b10 = fVar;
                    }
                    materialCalendarGridView = this;
                    max = i20;
                    min = i21;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i10, int i11) {
        if (this.f8138b) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setSelection(int i10) {
        if (i10 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8137a = k.q();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f8138b = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof f) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), f.class.getCanonicalName()}));
    }
}

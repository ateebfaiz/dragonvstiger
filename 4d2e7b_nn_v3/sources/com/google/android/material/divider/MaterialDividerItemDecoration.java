package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    @ColorInt
    private int color;
    @NonNull
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private boolean lastItemDecorated;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    public MaterialDividerItemDecoration(@NonNull Context context, int i10) {
        this(context, (AttributeSet) null, i10);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingTop();
            i10 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i11, recyclerView.getWidth() - recyclerView.getPaddingRight(), i10);
        } else {
            i10 = recyclerView.getHeight();
            i11 = 0;
        }
        int i12 = i11 + this.insetStart;
        int i13 = i10 - this.insetEnd;
        int childCount = recyclerView.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = recyclerView.getChildAt(i14);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.tempRect);
            int round = this.tempRect.right + Math.round(childAt.getTranslationX());
            this.dividerDrawable.setBounds((round - this.dividerDrawable.getIntrinsicWidth()) - this.thickness, i12, round, i13);
            this.dividerDrawable.draw(canvas);
        }
        canvas.restore();
    }

    private void drawForVerticalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i10;
        int i11;
        int i12;
        int i13;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingLeft();
            i10 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i11, recyclerView.getPaddingTop(), i10, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i10 = recyclerView.getWidth();
            i11 = 0;
        }
        boolean z10 = true;
        if (ViewCompat.getLayoutDirection(recyclerView) != 1) {
            z10 = false;
        }
        if (z10) {
            i12 = this.insetEnd;
        } else {
            i12 = this.insetStart;
        }
        int i14 = i11 + i12;
        if (z10) {
            i13 = this.insetStart;
        } else {
            i13 = this.insetEnd;
        }
        int i15 = i10 - i13;
        int childCount = recyclerView.getChildCount();
        if (!this.lastItemDecorated) {
            childCount--;
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = recyclerView.getChildAt(i16);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.tempRect);
            int round = this.tempRect.bottom + Math.round(childAt.getTranslationY());
            this.dividerDrawable.setBounds(i14, (round - this.dividerDrawable.getIntrinsicHeight()) - this.thickness, i15, round);
            this.dividerDrawable.draw(canvas);
        }
        canvas.restore();
    }

    @ColorInt
    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    @Px
    public int getDividerThickness() {
        return this.thickness;
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (this.orientation == 1) {
            rect.bottom = this.dividerDrawable.getIntrinsicHeight() + this.thickness;
        } else {
            rect.right = this.dividerDrawable.getIntrinsicWidth() + this.thickness;
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.orientation == 1) {
                drawForVerticalOrientation(canvas, recyclerView);
            } else {
                drawForHorizontalOrientation(canvas, recyclerView);
            }
        }
    }

    public void setDividerColor(@ColorInt int i10) {
        this.color = i10;
        Drawable wrap = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = wrap;
        DrawableCompat.setTint(wrap, i10);
    }

    public void setDividerColorResource(@NonNull Context context, @ColorRes int i10) {
        setDividerColor(ContextCompat.getColor(context, i10));
    }

    public void setDividerInsetEnd(@Px int i10) {
        this.insetEnd = i10;
    }

    public void setDividerInsetEndResource(@NonNull Context context, @DimenRes int i10) {
        setDividerInsetEnd(context.getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(@Px int i10) {
        this.insetStart = i10;
    }

    public void setDividerInsetStartResource(@NonNull Context context, @DimenRes int i10) {
        setDividerInsetStart(context.getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(@Px int i10) {
        this.thickness = i10;
    }

    public void setDividerThicknessResource(@NonNull Context context, @DimenRes int i10) {
        setDividerThickness(context.getResources().getDimensionPixelSize(i10));
    }

    public void setLastItemDecorated(boolean z10) {
        this.lastItemDecorated = z10;
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.orientation = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i10 + ". It should be either HORIZONTAL or VERTICAL");
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, R.attr.materialDividerStyle, i10);
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        this.tempRect = new Rect();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.MaterialDivider, i10, DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        this.lastItemDecorated = obtainStyledAttributes.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
        obtainStyledAttributes.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(i11);
    }
}

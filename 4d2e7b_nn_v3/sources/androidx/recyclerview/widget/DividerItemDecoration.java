package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {16843284};
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private int mOrientation;

    @SuppressLint({"UnknownNullness"})
    public DividerItemDecoration(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.mDivider = drawable;
        if (drawable == null) {
            Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        setOrientation(i10);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
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
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = this.mBounds.right + Math.round(childAt.getTranslationX());
            this.mDivider.setBounds(round - this.mDivider.getIntrinsicWidth(), i11, round, i10);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingLeft();
            i10 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i11, recyclerView.getPaddingTop(), i10, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i10 = recyclerView.getWidth();
            i11 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
            this.mDivider.setBounds(i11, round - this.mDivider.getIntrinsicHeight(), i10, round);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDivider;
    }

    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.mDivider;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null && this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawVertical(canvas, recyclerView);
            } else {
                drawHorizontal(canvas, recyclerView);
            }
        }
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.mDivider = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.mOrientation = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}

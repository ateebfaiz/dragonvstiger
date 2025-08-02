package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void updateTopBottomPadding(@NonNull View view, int i10, int i11) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i10, ViewCompat.getPaddingEnd(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean updateViewsWithinLayout(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.messageView.getPaddingTop() == i11 && this.messageView.getPaddingBottom() == i12) {
            return z10;
        }
        updateTopBottomPadding(this.messageView, i11, i12);
        return true;
    }

    public void animateContentIn(int i10, int i11) {
        this.messageView.setAlpha(0.0f);
        long j10 = (long) i11;
        long j11 = (long) i10;
        this.messageView.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    public void animateContentOut(int i10, int i11) {
        this.messageView.setAlpha(1.0f);
        long j10 = (long) i11;
        long j11 = (long) i10;
        this.messageView.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        super.onMeasure(i10, i11);
        if (getOrientation() != 1) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            if (this.messageView.getLayout().getLineCount() > 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if (!z10) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                    return;
                }
            } else if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
            super.onMeasure(i10, i11);
        }
    }

    public void setMaxInlineActionWidth(int i10) {
        this.maxInlineActionWidth = i10;
    }

    /* access modifiers changed from: package-private */
    public void updateActionTextColorAlphaIfNeeded(float f10) {
        if (f10 != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f10));
        }
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

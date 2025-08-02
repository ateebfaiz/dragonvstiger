package com.facebook.react.views.switchview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

class ReactSwitch extends SwitchCompat {
    private boolean mAllowChange = true;
    @Nullable
    private Integer mTrackColorForFalse = null;
    @Nullable
    private Integer mTrackColorForTrue = null;

    public ReactSwitch(Context context) {
        super(context);
    }

    private ColorStateList createRippleDrawableColorStateList(@Nullable Integer num) {
        return new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{num.intValue()});
    }

    public void setBackgroundColor(int i10) {
        setBackground(new RippleDrawable(createRippleDrawableColorStateList(Integer.valueOf(i10)), new ColorDrawable(i10), (Drawable) null));
    }

    public void setChecked(boolean z10) {
        if (!this.mAllowChange || isChecked() == z10) {
            super.setChecked(isChecked());
            return;
        }
        this.mAllowChange = false;
        super.setChecked(z10);
        setTrackColor(z10);
    }

    /* access modifiers changed from: package-private */
    public void setColor(Drawable drawable, @Nullable Integer num) {
        if (num == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOn(boolean z10) {
        if (isChecked() != z10) {
            super.setChecked(z10);
            setTrackColor(z10);
        }
        this.mAllowChange = true;
    }

    public void setThumbColor(@Nullable Integer num) {
        setColor(super.getThumbDrawable(), num);
        if (num != null && (super.getBackground() instanceof RippleDrawable)) {
            ((RippleDrawable) super.getBackground()).setColor(createRippleDrawableColorStateList(num));
        }
    }

    public void setTrackColor(@Nullable Integer num) {
        setColor(super.getTrackDrawable(), num);
    }

    public void setTrackColorForFalse(@Nullable Integer num) {
        if (num != this.mTrackColorForFalse) {
            this.mTrackColorForFalse = num;
            if (!isChecked()) {
                setTrackColor(this.mTrackColorForFalse);
            }
        }
    }

    public void setTrackColorForTrue(@Nullable Integer num) {
        if (num != this.mTrackColorForTrue) {
            this.mTrackColorForTrue = num;
            if (isChecked()) {
                setTrackColor(this.mTrackColorForTrue);
            }
        }
    }

    private void setTrackColor(boolean z10) {
        Integer num = this.mTrackColorForTrue;
        if (num != null || this.mTrackColorForFalse != null) {
            if (!z10) {
                num = this.mTrackColorForFalse;
            }
            setTrackColor(num);
        }
    }
}

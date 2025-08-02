package com.facebook.share.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.FacebookButtonBase;
import u2.c;
import u2.f;
import u2.g;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    public LikeButton(Context context, boolean z10) {
        super(context, (AttributeSet) null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        setSelected(z10);
    }

    private void m() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(c.f24279b, 0, 0, 0);
            setText(getResources().getString(f.f24294d));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), c.f24278a), (Drawable) null, (Drawable) null, (Drawable) null);
        setText(getResources().getString(f.f24295e));
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        super.d(context, attributeSet, i10, i11);
        m();
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return g.f24303d;
    }

    @Deprecated
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        m();
    }
}

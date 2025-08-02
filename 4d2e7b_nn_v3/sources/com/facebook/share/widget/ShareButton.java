package com.facebook.share.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import q5.d;
import q5.i;
import u2.c;
import y7.b;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        super.d(context, attributeSet, i10, i11);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), c.f24278a), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return d.c.Share.a();
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return b.f13332b;
    }

    /* access modifiers changed from: protected */
    public i getDialog() {
        b bVar;
        if (getFragment() != null) {
            bVar = new b(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            bVar = new b(getNativeFragment(), getRequestCode());
        } else {
            bVar = new b(getActivity(), getRequestCode());
        }
        bVar.l(getCallbackManager());
        return bVar;
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, "fb_share_button_create", "fb_share_button_did_tap");
    }
}

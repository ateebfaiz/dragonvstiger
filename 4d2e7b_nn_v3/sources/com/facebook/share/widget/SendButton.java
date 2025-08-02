package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import q5.d;
import q5.i;
import y7.b;

@Deprecated
public final class SendButton extends ShareButtonBase {
    public SendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return d.c.Message.a();
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return b.f13331a;
    }

    /* access modifiers changed from: protected */
    public i getDialog() {
        a aVar;
        if (getFragment() != null) {
            aVar = new a(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            aVar = new a(getNativeFragment(), getRequestCode());
        } else {
            aVar = new a(getActivity(), getRequestCode());
        }
        aVar.l(getCallbackManager());
        return aVar;
    }

    public SendButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, "fb_send_button_create", "fb_send_button_did_tap");
    }
}

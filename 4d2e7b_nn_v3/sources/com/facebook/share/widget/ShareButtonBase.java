package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.g;
import com.facebook.o;
import com.facebook.share.model.ShareContent;
import q5.i;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private g C;

    /* renamed from: i  reason: collision with root package name */
    private ShareContent f4735i;

    /* renamed from: j  reason: collision with root package name */
    private int f4736j = 0;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4737w = false;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            ShareButtonBase.this.c(view);
            ShareButtonBase.this.getDialog().m(ShareButtonBase.this.getShareContent());
        }
    }

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i10, String str, String str2) {
        super(context, attributeSet, i10, 0, str, str2);
        int i11;
        if (isInEditMode()) {
            i11 = 0;
        } else {
            i11 = getDefaultRequestCode();
        }
        this.f4736j = i11;
        o(false);
    }

    private void o(boolean z10) {
        setEnabled(z10);
        this.f4737w = false;
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        super.d(context, attributeSet, i10, i11);
        setInternalOnClickListener(getShareOnClickListener());
    }

    /* access modifiers changed from: protected */
    public g getCallbackManager() {
        return this.C;
    }

    /* access modifiers changed from: protected */
    public abstract i getDialog();

    public int getRequestCode() {
        return this.f4736j;
    }

    public ShareContent getShareContent() {
        return this.f4735i;
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener getShareOnClickListener() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return getDialog().b(getShareContent());
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f4737w = true;
    }

    /* access modifiers changed from: protected */
    public void setRequestCode(int i10) {
        if (!o.y(i10)) {
            this.f4736j = i10;
            return;
        }
        throw new IllegalArgumentException("Request code " + i10 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(ShareContent shareContent) {
        this.f4735i = shareContent;
        if (!this.f4737w) {
            o(n());
        }
    }
}

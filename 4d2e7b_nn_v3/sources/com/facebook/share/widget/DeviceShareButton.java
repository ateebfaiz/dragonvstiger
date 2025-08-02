package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.o;
import com.facebook.share.model.ShareContent;
import q5.d;
import y7.b;

@Deprecated
public final class DeviceShareButton extends FacebookButtonBase {
    private y7.a C;

    /* renamed from: i  reason: collision with root package name */
    private ShareContent f4687i;

    /* renamed from: j  reason: collision with root package name */
    private int f4688j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4689w;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            DeviceShareButton.this.c(view);
            DeviceShareButton.this.getDialog().m(DeviceShareButton.this.getShareContent());
        }
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public y7.a getDialog() {
        y7.a aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        if (getFragment() != null) {
            this.C = new y7.a(getFragment());
        } else if (getNativeFragment() != null) {
            this.C = new y7.a(getNativeFragment());
        } else {
            this.C = new y7.a(getActivity());
        }
        return this.C;
    }

    private boolean o() {
        return new y7.a(getActivity()).b(getShareContent());
    }

    private void p(boolean z10) {
        setEnabled(z10);
        this.f4689w = false;
    }

    private void setRequestCode(int i10) {
        if (!o.y(i10)) {
            this.f4688j = i10;
            return;
        }
        throw new IllegalArgumentException("Request code " + i10 + " cannot be within the range reserved by the Facebook SDK.");
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        super.d(context, attributeSet, i10, i11);
        setInternalOnClickListener(getShareOnClickListener());
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return d.c.Share.a();
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return b.f13332b;
    }

    public int getRequestCode() {
        return this.f4688j;
    }

    public ShareContent getShareContent() {
        return this.f4687i;
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener getShareOnClickListener() {
        return new a();
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f4689w = true;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f4687i = shareContent;
        if (!this.f4689w) {
            p(o());
        }
    }

    private DeviceShareButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.f4688j = 0;
        this.f4689w = false;
        this.C = null;
        this.f4688j = isInEditMode() ? 0 : getDefaultRequestCode();
        p(false);
    }
}

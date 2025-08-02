package com.zing.zalo.zalosdk.oauth.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class PaymentDialog extends Dialog {
    private Object tag;

    public PaymentDialog(Context context) {
        super(context);
    }

    public Object getTag() {
        return this.tag;
    }

    public void onAttachedToWindow() {
        getWindow().addFlags(6815872);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }
}

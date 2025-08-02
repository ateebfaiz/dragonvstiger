package com.zing.zalo.zalosdk.payment.direct;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zing.zalo.zalosdk.R;

public class PaymentAlertDialog extends PaymentDialog implements View.OnClickListener {
    OnCancelListener cancelListener;
    boolean hideOkButton;
    OnOkListener listener;
    String okTitle;
    String title;

    public interface OnCancelListener {
        void onCancel();
    }

    public interface OnOkListener {
        void onOK();
    }

    public PaymentAlertDialog(Context context) {
        super(context);
        this.cancelListener = null;
        this.listener = null;
        this.hideOkButton = false;
    }

    public void hideOkButton(boolean z10) {
        this.hideOkButton = z10;
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.zalosdk_ok_ctl) {
            dismiss();
            OnOkListener onOkListener = this.listener;
            if (onOkListener != null) {
                onOkListener.onOK();
            }
        } else if (id2 == R.id.zalosdk_cancel_ctl) {
            dismiss();
            OnCancelListener onCancelListener = this.cancelListener;
            if (onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.zalosdk_activity_alert);
        findViewById(R.id.zalosdk_ok_ctl).setOnClickListener(this);
        if (!TextUtils.isEmpty(this.okTitle)) {
            ((TextView) findViewById(R.id.zalosdk_ok_ctl)).setText(this.okTitle);
        }
        if (this.cancelListener == null) {
            findViewById(R.id.button_devider).setVisibility(8);
            findViewById(R.id.zalosdk_cancel_ctl).setVisibility(8);
            findViewById(R.id.zalosdk_cancel_ctl).setOnClickListener((View.OnClickListener) null);
            return;
        }
        findViewById(R.id.button_devider).setVisibility(0);
        findViewById(R.id.zalosdk_cancel_ctl).setVisibility(0);
        findViewById(R.id.zalosdk_cancel_ctl).setOnClickListener(this);
    }

    public void setOkButtonTitle(String str) {
        this.okTitle = str;
    }

    public void setOnOkListener(OnOkListener onOkListener) {
        this.listener = onOkListener;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void showAlert(String str) {
        show();
        ((TextView) findViewById(R.id.zalosdk_message_ctl)).setText(str);
        View findViewById = findViewById(R.id.zalosdk_ok_ctl);
        if (this.hideOkButton) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        setCancelable(true);
        TextView textView = (TextView) findViewById(R.id.text_title_alert);
        if (textView != null) {
            textView.setText(this.title);
        }
    }

    public PaymentAlertDialog(Context context, OnOkListener onOkListener) {
        super(context);
        this.cancelListener = null;
        this.hideOkButton = false;
        this.listener = onOkListener;
    }

    public PaymentAlertDialog(Context context, OnOkListener onOkListener, OnCancelListener onCancelListener) {
        super(context);
        this.hideOkButton = false;
        this.listener = onOkListener;
        this.cancelListener = onCancelListener;
    }
}

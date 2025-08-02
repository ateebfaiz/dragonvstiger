package com.zing.zalo.zalosdk.payment.direct;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.zing.zalo.zalosdk.R;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.resource.StringResource;

public class PaymentProcessingDialog extends PaymentDialog implements DialogInterface.OnDismissListener {
    String LOG_TAG = PaymentProcessingDialog.class.getSimpleName();
    Handler handler = new Handler();
    public boolean isShow = false;
    boolean isTimeOut = false;
    OnCloseListener listener;
    Runnable runnable = new Runnable() {
        public void run() {
            PaymentProcessingDialog paymentProcessingDialog = PaymentProcessingDialog.this;
            if (paymentProcessingDialog.viewIndex > 0 && paymentProcessingDialog.isShowing()) {
                PaymentProcessingDialog.this.hideView();
                OnCloseListener onCloseListener = PaymentProcessingDialog.this.listener;
                if (onCloseListener != null) {
                    onCloseListener.onClose();
                }
            }
        }
    };
    int viewIndex = 0;
    String zalosdk_processing;
    String zalosdk_success;
    String zalosdk_unsuccess;

    /* renamed from: com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$Status[] r0 = com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status = r0
                com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$Status r1 = com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.Status.PROCESSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$Status r1 = com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$Status r1 = com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog$Status r1 = com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.Status.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog.AnonymousClass2.<clinit>():void");
        }
    }

    public interface OnCloseListener {
        void onClose();
    }

    public enum Status {
        PROCESSING,
        SUCCESS,
        FAILED,
        TIMEOUT
    }

    public PaymentProcessingDialog(Context context, OnCloseListener onCloseListener) {
        super(context);
        this.listener = onCloseListener;
        setOnDismissListener(this);
        this.zalosdk_processing = StringResource.getString("zalosdk_processing");
        this.zalosdk_success = StringResource.getString("zalosdk_success");
        this.zalosdk_unsuccess = StringResource.getString("zalosdk_unsuccess");
    }

    private void autoClose() {
        this.handler.postDelayed(this.runnable, 3000);
    }

    private void showProcessingView() {
        Log.i("THREAD BEGIN", "PROCESSING!!");
        ((TextView) findViewById(R.id.zalosdk_message_ctl)).setText(this.zalosdk_processing);
        findViewById(R.id.zalosdk_status_ctl).setVisibility(8);
        findViewById(R.id.zalosdk_indicator_ctl).setVisibility(0);
        setCancelable(false);
        this.viewIndex = 0;
    }

    private void showSuccessView() {
        Log.i(this.LOG_TAG, "Show success dialog");
        ((TextView) findViewById(R.id.zalosdk_message_ctl)).setText(this.zalosdk_success);
        findViewById(R.id.zalosdk_indicator_ctl).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.zalosdk_status_ctl);
        imageView.setImageResource(R.drawable.zalosdk_ic_success);
        imageView.setVisibility(0);
        setCancelable(true);
        this.viewIndex = 1;
        autoClose();
    }

    private void showTimeOutView() {
        Log.i("debuglog", "time out showview");
        findViewById(R.id.zalosdk_process_dialog_ctl).setVisibility(8);
        setCancelable(true);
        this.viewIndex = 1;
        this.handler.postDelayed(this.runnable, 1);
        this.isTimeOut = true;
    }

    private void showUnSuccessView() {
        ((TextView) findViewById(R.id.zalosdk_message_ctl)).setText(this.zalosdk_unsuccess);
        findViewById(R.id.zalosdk_indicator_ctl).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.zalosdk_status_ctl);
        imageView.setImageResource(R.drawable.zalosdk_ic_fail);
        imageView.setVisibility(0);
        setCancelable(true);
        this.viewIndex = 1;
        autoClose();
    }

    public void hide() {
        Log.i(this.LOG_TAG, "hide loading!");
        super.hide();
    }

    public void hideView() {
        this.isShow = false;
        hide();
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.zalosdk_activity_processing);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.listener != null) {
            Log.i(getClass().getName(), "cancel");
            this.listener.onClose();
        }
    }

    public void show() {
        Log.i(this.LOG_TAG, "show loading..");
        try {
            super.show();
        } catch (Exception unused) {
            Log.i(this.LOG_TAG, "error can not show loading");
        }
    }

    public void showView(Status status) {
        show();
        this.isShow = true;
        int i10 = AnonymousClass2.$SwitchMap$com$zing$zalo$zalosdk$payment$direct$PaymentProcessingDialog$Status[status.ordinal()];
        if (i10 == 1) {
            showProcessingView();
        } else if (i10 == 2) {
            showSuccessView();
        } else if (i10 == 3) {
            showUnSuccessView();
        } else if (i10 == 4) {
            showTimeOutView();
        }
    }

    public void updateProcessingTransactionView(String str) {
        ((TextView) findViewById(R.id.zalosdk_message_ctl)).setText(str);
    }
}

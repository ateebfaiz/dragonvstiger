package org.cocos2dx.javascript;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ExitDialog extends Dialog {
    private Context context;
    private String exitStr;
    private String goBackStr;
    private boolean isRtl;
    private String messageStr;
    /* access modifiers changed from: private */
    public onExitOnClickListener onExitOnClickListener;
    /* access modifiers changed from: private */
    public onNoOnClickListener onNoOnClickListener;
    private String titleStr;
    private TextView tv_contect;
    private TextView tv_exit;
    private TextView tv_go;
    private TextView tv_title;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (ExitDialog.this.onExitOnClickListener != null) {
                ExitDialog.this.onExitOnClickListener.onExitClick();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            if (ExitDialog.this.onNoOnClickListener != null) {
                ExitDialog.this.onNoOnClickListener.onNoClick();
            }
        }
    }

    public interface onExitOnClickListener {
        void onExitClick();
    }

    public interface onNoOnClickListener {
        void onNoClick();
    }

    public ExitDialog(@NonNull Context context2) {
        super(context2);
    }

    private void initData() {
        this.tv_title.setText(this.titleStr);
        this.tv_contect.setText(this.messageStr);
        this.tv_go.setText(this.goBackStr);
        this.tv_exit.setText(this.exitStr);
    }

    private void initEvent() {
        this.tv_exit.setOnClickListener(new a());
        this.tv_go.setOnClickListener(new b());
    }

    private void initView() {
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.tv_contect = (TextView) findViewById(R.id.tv_contect);
        this.tv_go = (TextView) findViewById(R.id.tv_go);
        this.tv_exit = (TextView) findViewById(R.id.tv_exit);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog);
        View findViewById = findViewById(R.id.rl_root);
        if (this.isRtl) {
            findViewById.setLayoutDirection(1);
        } else {
            findViewById.setLayoutDirection(0);
        }
        setCanceledOnTouchOutside(false);
        initView();
        initData();
        initEvent();
    }

    public void setExitOnClickListener(onExitOnClickListener onexitonclicklistener) {
        this.onExitOnClickListener = onexitonclicklistener;
    }

    public void setMessage(String str) {
        this.messageStr = str;
    }

    public void setNoOnClickListener(onNoOnClickListener onnoonclicklistener) {
        this.onNoOnClickListener = onnoonclicklistener;
    }

    public void setTitle(String str) {
        this.titleStr = str;
    }

    public ExitDialog(@NonNull Context context2, String str, String str2, String str3, String str4, boolean z10) {
        super(context2, R.style.ExitDialog);
        this.context = context2;
        this.titleStr = str;
        this.messageStr = str2;
        this.goBackStr = str3;
        this.exitStr = str4;
        this.isRtl = z10;
    }

    protected ExitDialog(@NonNull Context context2, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context2, z10, onCancelListener);
    }
}

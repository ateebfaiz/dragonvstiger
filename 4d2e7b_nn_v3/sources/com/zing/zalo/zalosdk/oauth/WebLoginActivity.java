package com.zing.zalo.zalosdk.oauth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.R;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.oauth.model.LoginResponse;
import com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginBaseFragment;
import com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment;
import com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment;
import com.zing.zalo.zalosdk.payment.direct.PaymentProcessingDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class WebLoginActivity extends FragmentActivity implements ZaloWebLoginBaseFragment.ZaloWebLoginBaseFragmentListener, View.OnClickListener {
    String appExtInfo;
    ImageView backButton;
    String codeChallenge;
    FrameLayout frameLayout;
    int frameLayoutId;
    ZaloWebLoginFragment loginFragment;
    PaymentProcessingDialog progressDialog;
    ZaloWebRegisterFragment registerFragment;
    boolean registerOnly;
    String state;
    TextView titleView;

    public interface OnDialogClickListener {
        void onCancel();

        void onClickOk();
    }

    private void changestatusbarColor() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.zing_pressed));
    }

    public static Intent newIntent(Context context, boolean z10, String str, String str2, String str3) {
        Intent intent = new Intent(context, WebLoginActivity.class);
        intent.putExtra("registerOnly", z10);
        intent.putExtra("codeChallenge", str);
        intent.putExtra("appExtInfo", str2);
        intent.putExtra("state", str3);
        return intent;
    }

    private void showWebLoginFragment() {
        this.loginFragment = ZaloWebLoginFragment.newInstance(this.codeChallenge, this.state, this.appExtInfo);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(this.frameLayoutId, (Fragment) this.loginFragment, "login-fragment");
        beginTransaction.commitAllowingStateLoss();
    }

    public void hideBackButton() {
        ImageView imageView = this.backButton;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void hideLoading() {
        PaymentProcessingDialog paymentProcessingDialog = this.progressDialog;
        if (paymentProcessingDialog != null && paymentProcessingDialog.isShowing()) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        ZaloSDK.Instance.onActivityResult(this, i10, i11, intent);
    }

    public void onBackPressed() {
        ImageView imageView = this.backButton;
        if (imageView != null && imageView.getVisibility() == 0) {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view == this.backButton) {
            Utils.hideSoftKeyboard(this);
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        changestatusbarColor();
        this.registerOnly = getIntent().getBooleanExtra("registerOnly", false);
        this.codeChallenge = getIntent().getStringExtra("codeChallenge");
        this.state = getIntent().getStringExtra("state");
        this.appExtInfo = getIntent().getStringExtra("appExtInfo");
        setContentView(Utils.getResourceId(this, "zalosdk_activity_zalo_web_login", "layout"));
        int resourceId = Utils.getResourceId(this, "zalosdk_weblogin_container", "id");
        this.frameLayoutId = resourceId;
        this.frameLayout = (FrameLayout) findViewById(resourceId);
        this.titleView = (TextView) findViewById(Utils.getResourceId(this, "zalosdk_txt_title", "id"));
        ImageView imageView = (ImageView) findViewById(Utils.getResourceId(this, "zalosdk_back_control", "id"));
        this.backButton = imageView;
        imageView.setOnClickListener(this);
        if (bundle != null) {
            return;
        }
        if (this.registerOnly) {
            this.registerFragment = ZaloWebRegisterFragment.newIstance();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(this.frameLayoutId, (Fragment) this.registerFragment, "register-fragment");
            beginTransaction.commit();
            return;
        }
        showWebLoginFragment();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLoginCompleted(LoginResponse loginResponse) {
        Intent intent = new Intent();
        intent.putExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR, loginResponse.getError());
        intent.putExtra("uid", loginResponse.getUid());
        intent.putExtra(Constant.PARAM_OAUTH_CODE, loginResponse.getOauth());
        intent.putExtra("isRegister", loginResponse.isRegister());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(loginResponse.getExtInfo())) {
                jSONObject2.put("ext_info", new JSONObject(loginResponse.getExtInfo()));
            }
        } catch (JSONException unused) {
        }
        try {
            jSONObject2.put("viewer", loginResponse.getViewer());
            jSONObject2.put("state", loginResponse.getState());
            jSONObject2.put("display_name", loginResponse.getName());
            jSONObject2.put("zprotect", loginResponse.getZprotect());
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e10) {
            Log.w("onLoginCompleted", e10);
        }
        intent.putExtra("data", jSONObject.toString());
        intent.putExtra("isWebview", true);
        setResult(-1, intent);
        finish();
    }

    public void onLoginFailed(LoginResponse loginResponse) {
        Intent intent = new Intent();
        intent.putExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR, loginResponse.getError());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("errorMsg", loginResponse.getErrorMsg());
            jSONObject2.put("error_description", loginResponse.getErrorDescription());
            jSONObject2.put("error_reason", loginResponse.getErrorReason());
            jSONObject2.put("from_source", loginResponse.getFromSource());
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e10) {
            Log.e("onLoginFailed", (Exception) e10);
        }
        intent.putExtra("data", jSONObject.toString());
        setResult(-1, intent);
        finish();
    }

    public void setTitle(String str) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void showBackButton() {
        ImageView imageView = this.backButton;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void showConfirmDialog(Activity activity, final OnDialogClickListener onDialogClickListener, String str, String str2, String str3, String str4, String str5) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.zalo_web_regis_dialog_confirm);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (!TextUtils.isEmpty(str3)) {
            ((TextView) dialog.findViewById(R.id.content)).setText(str3);
        }
        if (TextUtils.isEmpty(str)) {
            dialog.findViewById(Utils.getResourceId(activity, "line", "id")).setVisibility(8);
            dialog.findViewById(Utils.getResourceId(activity, "txt_title", "id")).setVisibility(8);
        } else {
            ((TextView) dialog.findViewById(Utils.getResourceId(activity, "txt_title", "id"))).setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            dialog.findViewById(R.id.phoneNumber).setVisibility(8);
        } else {
            dialog.findViewById(R.id.phoneNumber).setVisibility(0);
            ((TextView) dialog.findViewById(R.id.phoneNumber)).setText(str2);
        }
        if (TextUtils.isEmpty(str5)) {
            dialog.findViewById(R.id.btn_add).setVisibility(8);
        } else {
            ((TextView) dialog.findViewById(R.id.btn_add)).setText(str5);
            dialog.findViewById(R.id.btn_add).setVisibility(0);
            dialog.findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onClickOk();
                    }
                }
            });
        }
        if (TextUtils.isEmpty(str4)) {
            dialog.findViewById(R.id.btn_cancel).setVisibility(8);
        } else {
            ((TextView) dialog.findViewById(R.id.btn_cancel)).setText(str4);
            dialog.findViewById(R.id.btn_cancel).setVisibility(0);
            dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onCancel();
                    }
                }
            });
        }
        if ((!TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5))) {
            if (TextUtils.isEmpty(str4)) {
                str4 = str5;
            }
            dialog.findViewById(R.id.btn_cancel).setVisibility(8);
            dialog.findViewById(R.id.btn_add).setVisibility(8);
            TextView textView = (TextView) dialog.findViewById(Utils.getResourceId(activity, "centerbtn", "id"));
            textView.setVisibility(0);
            textView.setText(str4);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    OnDialogClickListener onDialogClickListener = onDialogClickListener;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onCancel();
                        onDialogClickListener.onClickOk();
                    }
                }
            });
        }
        dialog.show();
    }

    public void showDialog(Activity activity, OnDialogClickListener onDialogClickListener, String str, String str2, String str3) {
        showConfirmDialog(activity, onDialogClickListener, str, (String) null, str2, (String) null, str3);
    }

    public void showLoading() {
        if (this.progressDialog == null) {
            this.progressDialog = new PaymentProcessingDialog(this, new PaymentProcessingDialog.OnCloseListener() {
                public void onClose() {
                }
            });
        }
        if (!this.progressDialog.isShowing()) {
            this.progressDialog.show();
        }
    }

    public void showMessageDialog(String str, String str2) {
        showDialog(this, (OnDialogClickListener) null, str, str2, getString(Utils.getResourceId(this, "txt_close", "string")));
    }
}

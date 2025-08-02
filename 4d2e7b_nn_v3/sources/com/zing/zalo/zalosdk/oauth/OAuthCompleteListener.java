package com.zing.zalo.zalosdk.oauth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;

public class OAuthCompleteListener {
    public void onAuthenError(ErrorResponse errorResponse) {
    }

    public void onFinishLoading() {
    }

    public void onGetOAuthComplete(OauthResponse oauthResponse) {
    }

    public void onGetPermissionData(int i10) {
    }

    public void onProtectAccComplete(int i10, String str, Dialog dialog) {
    }

    /* access modifiers changed from: protected */
    public void onRequestAccountProtect(int i10, String str) {
    }

    public void onSkipProtectAcc(Dialog dialog) {
    }

    public void onStartLoading() {
    }

    public void onZaloNotInstalled(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(ZaloSDK.Instance.getLocalizedString().getZaloNotInstalledMessage()).setPositiveButton(ZaloSDK.Instance.getLocalizedString().getInstallMessage(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                AppInfo.launchMarketApp(context, Constant.ZALO_PACKAGE_NAME);
            }
        });
        builder.setNegativeButton(ZaloSDK.Instance.getLocalizedString().getCancelMessage(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false).show();
    }

    public void onZaloOutOfDate(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(ZaloSDK.Instance.getLocalizedString().getZaloOauthOfDateMessage()).setPositiveButton(ZaloSDK.Instance.getLocalizedString().getUpdateMessage(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                AppInfo.launchMarketApp(context, Constant.ZALO_PACKAGE_NAME);
            }
        });
        builder.setNegativeButton(ZaloSDK.Instance.getLocalizedString().getCancelMessage(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false).show();
    }
}

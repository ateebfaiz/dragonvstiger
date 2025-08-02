package com.zing.zalo.zalosdk.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;
import java.lang.ref.WeakReference;

public class OpenAPIActivity extends Activity {
    LoginListener listener;

    private class LoginListener extends OAuthCompleteListener {
        boolean autoBack;
        String shareTo;

        public LoginListener(String str, boolean z10) {
            this.shareTo = str;
            this.autoBack = z10;
        }

        public void onAuthenError(ErrorResponse errorResponse) {
            ZaloPluginCallback zaloPluginCallback;
            super.onAuthenError(errorResponse);
            int errorCode = errorResponse.getErrorCode();
            String errorMsg = errorResponse.getErrorMsg();
            if (!(OpenAPIService.getInstance().mCallback == null || (zaloPluginCallback = OpenAPIService.getInstance().mCallback.get()) == null)) {
                zaloPluginCallback.onResult(false, errorCode, errorMsg, "");
            }
            OpenAPIActivity.this.finish();
        }

        public void onGetOAuthComplete(OauthResponse oauthResponse) {
            super.onGetOAuthComplete(oauthResponse);
            OpenAPIService instance = OpenAPIService.getInstance();
            WeakReference<ZaloPluginCallback> weakReference = instance.mCallback;
            if (weakReference != null) {
                ZaloPluginCallback zaloPluginCallback = weakReference.get();
                Context context = instance.mWeakContext.get();
                if (!(zaloPluginCallback == null || context == null)) {
                    String str = this.shareTo;
                    instance._shareTo = str;
                    boolean z10 = this.autoBack;
                    instance._autoBack = z10;
                    instance.doShare(context, instance.mFeedOb, zaloPluginCallback, str, z10);
                }
            }
            OpenAPIActivity.this.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        ZaloSDK.Instance.onActivityResult(this, i10, i11, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("login_from_share_feed", false);
        String stringExtra = intent.getStringExtra("share_to");
        boolean booleanExtra2 = intent.getBooleanExtra("autoBack", false);
        String stringExtra2 = intent.getStringExtra("code_challenge");
        if (booleanExtra) {
            LoginListener loginListener = new LoginListener(stringExtra, booleanExtra2);
            this.listener = loginListener;
            ZaloSDK.Instance.authenticateZaloPlugin(this, stringExtra2, loginListener);
        }
    }
}

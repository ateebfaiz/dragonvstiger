package com.zing.zalo.zalosdk.service.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;

final class NativeProtocol {
    static final int CMD_GET_LOGIN_STATUS = 10001;
    private static final String INTENT_ACTION_PLATFORM_SERVICE = "com.zing.zalo.action.PlatformService";
    private static final String INTENT_PACKAGE_PLATFORM_SERVICE = "com.zing.zalo";
    static final String KEY_REQUEST_APPLICATION_ID = "com.zing.zalo.platform.request.APPLICATION_ID";
    static final String KEY_RESULT_DATA = "com.zing.zalo.platform.result.DATA";
    static final String KEY_RESULT_ERROR_CODE = "com.zing.zalo.platform.result.ERROR_CODE";

    NativeProtocol() {
    }

    static Intent createPlatformServiceIntent(Context context) {
        return validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage("com.zing.zalo").addCategory("android.intent.category.DEFAULT"));
    }

    private static Intent validateServiceIntent(Context context, Intent intent) {
        ResolveInfo resolveService;
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null || !ZaloSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }
}

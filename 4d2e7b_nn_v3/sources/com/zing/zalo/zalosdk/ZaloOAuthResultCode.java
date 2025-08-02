package com.zing.zalo.zalosdk;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import com.zing.zalo.zalosdk.core.R;

public class ZaloOAuthResultCode {
    public static final int ERR_APPLICATION_IS_NOT_APPROVED = -7004;
    public static final int ERR_APP_ID_IN_USE_IS_DISABLED_OR_BANDED = -9013;
    public static final int ERR_APP_ID_IS_INVALID = -5000;
    public static final int ERR_AUTHORIZED_CODE_EXPIRED = -5016;
    public static final int ERR_BUILD_REDIRECT_URI_FAILED = -7006;
    public static final int ERR_CALL_FAIL = -9009;
    public static final int ERR_CANT_LOGIN_FACEBOOK = -7012;
    public static final int ERR_CANT_LOGIN_GOOGLE = -7011;
    public static final int ERR_CANT_LOGIN_ZINGME = -7013;
    public static final int ERR_CANT_RESOLVE_TO_A_VALID_USER_ID = -9002;
    public static final int ERR_CREATE_ACCESS_TOKEN_FAILED = -7001;
    public static final int ERR_CREATE_OAUTH_FAILED = -7002;
    public static final int ERR_DO_NOT_DISTURB_USER = -9021;
    public static final int ERR_FORGOT_PASSWD_GUEST_ACC_FAILED = -7005;
    public static final int ERR_INVALID_ACCESS_TOKEN = -5004;
    public static final int ERR_INVALID_ANDROID_PACKAGE = -5006;
    public static final int ERR_INVALID_ANDROID_SIGN_KEY = -5008;
    public static final int ERR_INVALID_BODY_DATA = -5013;
    public static final int ERR_INVALID_CALLBACK_URL = -5001;
    public static final int ERR_INVALID_CLIENT_SECRET = -5002;
    public static final int ERR_INVALID_CODE_CHALLENGE = -5009;
    public static final int ERR_INVALID_CODE_VERIFIER = -5010;
    public static final int ERR_INVALID_CSRF_TOKEN = -7000;
    public static final int ERR_INVALID_GRANT_TYPE = -5015;
    public static final int ERR_INVALID_IOS_BUNDLE_ID = -5005;
    public static final int ERR_INVALID_OAUTHORIZED_CODE = -5003;
    public static final int ERR_INVALID_OA_ID = -5012;
    public static final int ERR_INVALID_PARAMETER = -9000;
    public static final int ERR_INVALID_PERMISSION = -6001;
    public static final int ERR_INVALID_REFRESH_TOKEN = -5011;
    public static final int ERR_INVALID_REQUIRED_PARAMS = -5014;
    public static final int ERR_INVALID_SESSION = -5007;
    public static final int ERR_INVALID_STATE = -5018;
    public static final int ERR_INVALID_USER_ID = -9001;
    public static final int ERR_ITEM_NOT_EXITS = -9012;
    public static final int ERR_LIMIT_OF_FRIENDS_LIST_IS_TOO_LARGE = -9015;
    public static final int ERR_METHOD_IS_NOT_SUPPORT_FOR_THIS_API = -9010;
    public static final int ERR_NO_NETWORK = -8001;
    public static final int ERR_OAUTH_CODE_INVALID = -5020;
    public static final int ERR_QUOTA_DAILY_FOR_YOUR_APP_IS_LIMITED = -9016;
    public static final int ERR_QUOTA_DAILY_PER_USER_FOR_YOUR_APP_IS_LIMITED = -9024;
    public static final int ERR_QUOTA_FOR_YOUR_APP_IS_LIMITED = -9014;
    public static final int ERR_QUOTA_MONTHLY_FOR_YOUR_APP_IS_LIMITED = -9018;
    public static final int ERR_QUOTA_MONTHLY_FOR_YOUR_APP_IS_LIMITED2 = -9019;
    public static final int ERR_QUOTA_WEEKY_FOR_YOUR_APP_IS_LIMITED = -9017;
    public static final int ERR_RECIPIENT_WAS_REACHED_QUOTA_MESSAGE_RECIEVE = -9022;
    public static final int ERR_REFRESH_TOKEN_EXPIRED = -5017;
    public static final int ERR_REFRESH_TOKEN_NOT_GUEST_CHANNEL = -5019;
    public static final int ERR_REQUESTS_DISABLED_FOR_THIS_APP = -9007;
    public static final int ERR_REQUIRES_THE_EXTENDED_PERMISSION = -9005;
    public static final int ERR_SENDER_AND_RECIPIENT_IS_NOT_FRIEND = -9023;
    public static final int ERR_SESSION_KEY_INVALID = -9006;
    public static final int ERR_SYNTAX_ERROR = -9008;
    public static final int ERR_UNKNOWN_ERROR = -8000;
    public static final int ERR_UNKOWN_EXCEPTION = -9011;
    public static final int ERR_USER_BACK = -7008;
    public static final int ERR_USER_BANNED = -6005;
    public static final int ERR_USER_HAS_NOT_PLAYED_GAME_FOR_30_DAYS_AGO = -9020;
    public static final int ERR_USER_IS_INVALID = -6000;
    public static final int ERR_USER_NOT_CONSENT = -6003;
    public static final int ERR_USER_NOT_LOGIN = -6002;
    public static final int ERR_USER_NOT_OWN_OA = -6004;
    public static final int ERR_USER_NOT_VISIBLE = -9004;
    public static final int ERR_USER_REJECT = -7009;
    public static final int ERR_VERIFY_SESSION_USER_FAIL = -7003;
    public static final int ERR_WEB_VIEW_LOGIN_NOT_ALLOWED = -7007;
    public static final int ERR_YOUR_APP_DONT_LINK_WITH_ANY_OFFICIAL_ACCOUNT = -9003;
    public static final int ERR_YOUR_FRIEND_IS_NOT_USING_APP = -9025;
    public static final int ERR_YOUR_FRIEND_IS_USING_APP = -9026;
    public static final int ERR_ZALO_APP_NOT_INSTALLED = -7014;
    public static final int ERR_ZALO_OUT_OF_DATE = -7015;
    public static final int ERR_ZALO_WEBVIEW_COOKIE_ERROR = -7010;
    public static final int RESULTCODE_NO_ERROR = 0;
    public static final int RESULTCODE_REGIS_CERTIFICATE_GUEST_SUCCESS = 8001;
    public static final int RESULTCODE_REGIS_IDENTIFY_CARD_NUMBER_SUCCESS = 8000;

    public static int findById(int i10) {
        if (i10 == -1112) {
            return ERR_UNKNOWN_ERROR;
        }
        if (i10 == -1111) {
            return ERR_USER_BACK;
        }
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return ERR_UNKNOWN_ERROR;
        }
        if (i10 == 2) {
            return ERR_USER_BACK;
        }
        if (i10 == 3) {
            return ERR_USER_REJECT;
        }
        if (i10 == 4) {
            return ERR_USER_NOT_LOGIN;
        }
        switch (i10) {
            case -14048:
                return ERR_REFRESH_TOKEN_NOT_GUEST_CHANNEL;
            case -1205:
                return ERR_CANT_LOGIN_GOOGLE;
            case -1118:
                return ERR_WEB_VIEW_LOGIN_NOT_ALLOWED;
            case -1114:
                return ERR_USER_REJECT;
            case -1105:
                return ERR_CANT_LOGIN_FACEBOOK;
            case -1014:
                return ERR_APPLICATION_IS_NOT_APPROVED;
            case -201:
                return ERR_USER_IS_INVALID;
            case 100:
                return ERR_INVALID_PARAMETER;
            case 210:
                return ERR_USER_NOT_VISIBLE;
            case 289:
                return ERR_REQUIRES_THE_EXTENDED_PERMISSION;
            case 452:
                return ERR_SESSION_KEY_INVALID;
            case 2004:
                return ERR_REQUESTS_DISABLED_FOR_THIS_APP;
            case 2500:
                return ERR_SYNTAX_ERROR;
            case 11004:
                return ERR_APP_ID_IN_USE_IS_DISABLED_OR_BANDED;
            default:
                switch (i10) {
                    case -14031:
                        return ERR_BUILD_REDIRECT_URI_FAILED;
                    case -14030:
                        return ERR_FORGOT_PASSWD_GUEST_ACC_FAILED;
                    case -14029:
                        return ERR_APPLICATION_IS_NOT_APPROVED;
                    case -14028:
                        return ERR_VERIFY_SESSION_USER_FAIL;
                    case -14027:
                        return ERR_CREATE_OAUTH_FAILED;
                    case -14026:
                        return ERR_CREATE_ACCESS_TOKEN_FAILED;
                    case -14025:
                        return ERR_USER_BANNED;
                    case -14024:
                        return ERR_USER_NOT_OWN_OA;
                    case -14023:
                        return ERR_USER_NOT_CONSENT;
                    case -14022:
                        return ERR_USER_NOT_LOGIN;
                    case -14021:
                        return ERR_INVALID_PERMISSION;
                    case -14020:
                        return ERR_REFRESH_TOKEN_EXPIRED;
                    case -14019:
                        return ERR_AUTHORIZED_CODE_EXPIRED;
                    case -14018:
                        return ERR_INVALID_GRANT_TYPE;
                    case -14017:
                        return ERR_INVALID_REQUIRED_PARAMS;
                    case -14016:
                        return ERR_INVALID_BODY_DATA;
                    case -14015:
                        return ERR_INVALID_OA_ID;
                    case -14014:
                        return ERR_INVALID_REFRESH_TOKEN;
                    case -14013:
                        return ERR_INVALID_CODE_VERIFIER;
                    case -14012:
                        return ERR_INVALID_CODE_CHALLENGE;
                    case -14011:
                        return ERR_INVALID_ANDROID_SIGN_KEY;
                    case -14010:
                        return ERR_INVALID_SESSION;
                    case -14009:
                        return ERR_INVALID_ANDROID_PACKAGE;
                    default:
                        switch (i10) {
                            case -14007:
                                return ERR_INVALID_CSRF_TOKEN;
                            case -14006:
                                return ERR_USER_IS_INVALID;
                            case -14005:
                                return ERR_INVALID_OAUTHORIZED_CODE;
                            case -14004:
                                return ERR_INVALID_CLIENT_SECRET;
                            case -14003:
                                return ERR_INVALID_CALLBACK_URL;
                            case -14002:
                                return ERR_APP_ID_IS_INVALID;
                            case -14001:
                                return ERR_UNKNOWN_ERROR;
                            default:
                                switch (i10) {
                                    case -1025:
                                        return ERR_ZALO_OUT_OF_DATE;
                                    case -1024:
                                        return ERR_ZALO_APP_NOT_INSTALLED;
                                    case -1023:
                                        return ERR_CANT_LOGIN_ZINGME;
                                    case -1022:
                                    case -1021:
                                        return ERR_NO_NETWORK;
                                    case -1020:
                                        return ERR_ZALO_WEBVIEW_COOKIE_ERROR;
                                    case -1019:
                                        return ERR_INVALID_OAUTHORIZED_CODE;
                                    default:
                                        switch (i10) {
                                            case -1009:
                                                return ERR_USER_NOT_CONSENT;
                                            case -1008:
                                                return ERR_CREATE_ACCESS_TOKEN_FAILED;
                                            case -1007:
                                                return ERR_CREATE_OAUTH_FAILED;
                                            case -1006:
                                                return ERR_VERIFY_SESSION_USER_FAIL;
                                            case -1005:
                                                return ERR_USER_IS_INVALID;
                                            case -1004:
                                                return ERR_INVALID_OAUTHORIZED_CODE;
                                            case -1003:
                                                return ERR_INVALID_CLIENT_SECRET;
                                            case -1002:
                                                return ERR_INVALID_REQUIRED_PARAMS;
                                            case -1001:
                                                return ERR_APP_ID_IS_INVALID;
                                            case NotificationManagerCompat.IMPORTANCE_UNSPECIFIED /*-1000*/:
                                                return ERR_UNKNOWN_ERROR;
                                            default:
                                                switch (i10) {
                                                    case 110:
                                                        return ERR_INVALID_USER_ID;
                                                    case 111:
                                                        return ERR_CANT_RESOLVE_TO_A_VALID_USER_ID;
                                                    case 112:
                                                        return ERR_YOUR_APP_DONT_LINK_WITH_ANY_OFFICIAL_ACCOUNT;
                                                    default:
                                                        switch (i10) {
                                                            case 10000:
                                                                return ERR_CALL_FAIL;
                                                            case 10001:
                                                                return ERR_METHOD_IS_NOT_SUPPORT_FOR_THIS_API;
                                                            case 10002:
                                                                return ERR_UNKOWN_EXCEPTION;
                                                            case 10003:
                                                                return ERR_ITEM_NOT_EXITS;
                                                            default:
                                                                switch (i10) {
                                                                    case 12000:
                                                                        return ERR_QUOTA_FOR_YOUR_APP_IS_LIMITED;
                                                                    case 12001:
                                                                        return ERR_LIMIT_OF_FRIENDS_LIST_IS_TOO_LARGE;
                                                                    case 12002:
                                                                        return ERR_QUOTA_DAILY_FOR_YOUR_APP_IS_LIMITED;
                                                                    case 12003:
                                                                        return ERR_QUOTA_WEEKY_FOR_YOUR_APP_IS_LIMITED;
                                                                    case 12004:
                                                                        return ERR_QUOTA_MONTHLY_FOR_YOUR_APP_IS_LIMITED;
                                                                    case 12005:
                                                                        return ERR_QUOTA_MONTHLY_FOR_YOUR_APP_IS_LIMITED2;
                                                                    case 12006:
                                                                        return ERR_USER_HAS_NOT_PLAYED_GAME_FOR_30_DAYS_AGO;
                                                                    case 12007:
                                                                        return ERR_DO_NOT_DISTURB_USER;
                                                                    case 12008:
                                                                        return ERR_RECIPIENT_WAS_REACHED_QUOTA_MESSAGE_RECIEVE;
                                                                    case 12009:
                                                                        return ERR_SENDER_AND_RECIPIENT_IS_NOT_FRIEND;
                                                                    case 12010:
                                                                        return ERR_QUOTA_DAILY_PER_USER_FOR_YOUR_APP_IS_LIMITED;
                                                                    case 12011:
                                                                        return ERR_YOUR_FRIEND_IS_NOT_USING_APP;
                                                                    case 12012:
                                                                        return ERR_YOUR_FRIEND_IS_USING_APP;
                                                                    default:
                                                                        return i10;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static String findErrorMessageByID(Context context, int i10) {
        int findById = findById(i10);
        if (findById == -8001) {
            return context.getString(R.string.no_network);
        }
        if (findById == -8000) {
            return context.getString(R.string.unknown_error);
        }
        if (findById == -7015) {
            return context.getString(R.string.zalo_app_out_of_date);
        }
        if (findById == -7014) {
            return context.getString(R.string.zalo_app_not_installed);
        }
        if (findById == -7012) {
            return context.getString(R.string.cant_login_fb);
        }
        if (findById == -7011) {
            return context.getString(R.string.cant_login_gg);
        }
        if (findById == -7009 || findById == -7008 || findById == -6000) {
            return "";
        }
        if (findById != -5019) {
            return context.getString(R.string.cant_login_zalo);
        }
        return context.getString(R.string.refresh_token_not_guest_channel);
    }
}

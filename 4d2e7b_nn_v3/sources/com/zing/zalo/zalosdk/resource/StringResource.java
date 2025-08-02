package com.zing.zalo.zalosdk.resource;

import com.zing.zalo.zalosdk.common.Constant;
import java.util.HashMap;

public class StringResource {
    public static HashMap<String, String> mapStringResource = new HashMap<>();

    public static String getString(Object obj) {
        String str = (String) obj;
        if (str.equals("zalosdk_transaction_timeOut_mess")) {
            String str2 = mapStringResource.get(obj);
            if (str2 == null) {
                return "Giao dịch đã quá thời gian cho phép";
            }
            return str2;
        } else if (str.equals("get_status_timeOut")) {
            String str3 = mapStringResource.get(obj);
            if (str3 == null) {
                return "30000";
            }
            return str3;
        } else if (str.equals("OAuthCodeParam")) {
            String str4 = mapStringResource.get(obj);
            if (str4 == null) {
                return Constant.PARAM_OAUTH_CODE;
            }
            return str4;
        } else if (str.equals("zalosdk_no_internet")) {
            String str5 = mapStringResource.get(obj);
            if (str5 == null) {
                return "Mạng không ổn định, vui lòng thử lại sau";
            }
            return str5;
        } else if (str.equals("durationTimeForAsync")) {
            String str6 = mapStringResource.get(obj);
            if (str6 == null) {
                return "1800000";
            }
            return str6;
        } else if (str.equals("zalosdk_maintance")) {
            String str7 = mapStringResource.get(obj);
            if (str7 == null) {
                return "Hệ thống đang bảo trì, bạn vui lòng thử lại sau";
            }
            return str7;
        } else if (!str.equals("zalosdk_processing")) {
            return null;
        } else {
            String str8 = mapStringResource.get(obj);
            if (str8 == null) {
                return "Đang xử lý";
            }
            return str8;
        }
    }
}

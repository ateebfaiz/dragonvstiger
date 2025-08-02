package com.bugsnag.android;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Map;

class t3 {
    t3() {
    }

    public s3 a(Map map) {
        return new s3((String) u2.c(map, FirebaseAnalytics.Param.METHOD), (String) u2.c(map, "file"), (Number) u2.c(map, "lineNumber"), (Boolean) u2.c(map, "inProject"), (Map) u2.c(map, Constant.PARAM_OAUTH_CODE), (Number) u2.c(map, "columnNumber"));
    }
}

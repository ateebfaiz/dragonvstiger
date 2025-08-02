package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SALog;

public class SADisplayUtil {
    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getStringResource(Context context, int i10) {
        try {
            return context.getString(i10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }
}

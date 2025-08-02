package com.blankj.utilcode.util;

import android.app.Activity;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.blankj.utilcode.util.p;

public class UtilsTransActivity4MainProcess extends UtilsTransActivity {
    public static void start(UtilsTransActivity.a aVar) {
        UtilsTransActivity.g((Activity) null, (p.a) null, aVar, UtilsTransActivity4MainProcess.class);
    }

    public static void start(p.a aVar, UtilsTransActivity.a aVar2) {
        UtilsTransActivity.g((Activity) null, aVar, aVar2, UtilsTransActivity4MainProcess.class);
    }

    public static void start(Activity activity, UtilsTransActivity.a aVar) {
        UtilsTransActivity.g(activity, (p.a) null, aVar, UtilsTransActivity4MainProcess.class);
    }

    public static void start(Activity activity, p.a aVar, UtilsTransActivity.a aVar2) {
        UtilsTransActivity.g(activity, aVar, aVar2, UtilsTransActivity4MainProcess.class);
    }
}

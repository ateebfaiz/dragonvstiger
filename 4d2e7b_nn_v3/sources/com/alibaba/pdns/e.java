package com.alibaba.pdns;

import android.text.TextUtils;
import com.alibaba.pdns.model.f;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class e {
    public static boolean a(CopyOnWriteArrayList<f> copyOnWriteArrayList) {
        return copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0;
    }

    public static boolean b(CopyOnWriteArrayList<f> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 1) {
            return false;
        }
        return true;
    }

    public static boolean a(Map<String, Object> map) {
        return map != null && map.size() > 0;
    }

    public static boolean a(String[] strArr) {
        return strArr != null && strArr.length > 0;
    }

    public static boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, str2);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !TextUtils.equals(str, "");
    }
}

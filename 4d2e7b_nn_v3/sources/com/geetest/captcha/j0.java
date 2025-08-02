package com.geetest.captcha;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.zx.sdk.api.ZXID;
import com.zx.sdk.api.ZXIDListener;
import kotlin.jvm.internal.m;

public final class j0 implements ZXIDListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f5824a;

    public j0(Context context) {
        this.f5824a = context;
    }

    public void onFailed(int i10, String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        h0 h0Var = h0.f5812d;
        h0Var.a("ZxIdUtils", "ZxID onFailed code: " + i10 + ", msg: " + str);
    }

    public void onSuccess(ZXID zxid) {
        m.f(zxid, "zxid");
        h0 h0Var = h0.f5812d;
        h0Var.a("ZxIdUtils", "ZxID success: " + zxid.getValue());
        try {
            SharedPreferences.Editor edit = this.f5824a.getSharedPreferences("gt_zid_sp", 0).edit();
            edit.putLong("gt_zid_et", zxid.getExpiredTime());
            edit.putString("gt_zid", zxid.getValue());
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}

package com.geetest.core;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.zing.zalo.zalosdk.common.Constant;

public class w5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6206a;

    public w5(Context context) {
        this.f6206a = context;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public void a(b5 b5Var) {
        if (this.f6206a != null && b5Var != null) {
            if (!a()) {
                new d5("Only supports Android 10.0 and above for Nubia");
                ((z4) b5Var).f6235b.countDown();
                return;
            }
            try {
                ContentProviderClient acquireContentProviderClient = this.f6206a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
                if (acquireContentProviderClient != null) {
                    String str = null;
                    Bundle call = acquireContentProviderClient.call("getOAID", (String) null, (Bundle) null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.release();
                    } else {
                        acquireContentProviderClient.release();
                    }
                    if (call != null) {
                        if (call.getInt(Constant.PARAM_OAUTH_CODE, -1) == 0) {
                            str = call.getString("id");
                        }
                        if (str == null || str.length() == 0) {
                            throw new d5("OAID query failed: " + call.getString("message"));
                        }
                        z4 z4Var = (z4) b5Var;
                        z4Var.f6234a[0] = str;
                        z4Var.f6235b.countDown();
                        return;
                    }
                    throw new d5("OAID query failed: bundle is null");
                }
            } catch (Exception unused) {
                ((z4) b5Var).f6235b.countDown();
            }
        }
    }
}

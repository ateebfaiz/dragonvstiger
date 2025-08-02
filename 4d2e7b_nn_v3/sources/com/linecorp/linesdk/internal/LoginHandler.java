package com.linecorp.linesdk.internal;

import android.app.Activity;
import android.content.Intent;
import com.linecorp.linesdk.LoginListener;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.a;
import java.util.ArrayList;

public class LoginHandler {

    /* renamed from: b  reason: collision with root package name */
    private static int f10089b = 1;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f10090a = new ArrayList();

    private Intent b(Activity activity, boolean z10, String str, LineAuthenticationParams lineAuthenticationParams) {
        if (z10) {
            return a.b(activity, str, lineAuthenticationParams);
        }
        return a.c(activity, str, lineAuthenticationParams);
    }

    public void a(LoginListener loginListener) {
        this.f10090a.add(loginListener);
    }

    public void c(Activity activity, FragmentWrapper fragmentWrapper, boolean z10, String str, LineAuthenticationParams lineAuthenticationParams) {
        fragmentWrapper.a(b(activity, z10, str, lineAuthenticationParams), f10089b);
    }

    public void d(Activity activity, boolean z10, String str, LineAuthenticationParams lineAuthenticationParams) {
        activity.startActivityForResult(b(activity, z10, str, lineAuthenticationParams), f10089b);
    }

    public void e(LoginListener loginListener) {
        this.f10090a.remove(loginListener);
    }
}

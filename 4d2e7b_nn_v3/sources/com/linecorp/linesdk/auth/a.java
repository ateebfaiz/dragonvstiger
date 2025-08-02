package com.linecorp.linesdk.auth;

import android.content.Context;
import android.content.Intent;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.internal.LineAuthenticationActivity;
import k9.c;

public abstract class a {
    public static Intent a(Context context, LineAuthenticationConfig lineAuthenticationConfig, LineAuthenticationParams lineAuthenticationParams) {
        if (!lineAuthenticationConfig.e()) {
            c.c(context);
        }
        return LineAuthenticationActivity.getLoginIntent(context, lineAuthenticationConfig, lineAuthenticationParams);
    }

    public static Intent b(Context context, String str, LineAuthenticationParams lineAuthenticationParams) {
        return a(context, new LineAuthenticationConfig.b(str).g(), lineAuthenticationParams);
    }

    public static Intent c(Context context, String str, LineAuthenticationParams lineAuthenticationParams) {
        return a(context, new LineAuthenticationConfig.b(str).h().g(), lineAuthenticationParams);
    }

    public static LineLoginResult d(Intent intent) {
        if (intent == null) {
            return LineLoginResult.j("Callback intent is null");
        }
        return LineAuthenticationActivity.getResultFromIntent(intent);
    }
}

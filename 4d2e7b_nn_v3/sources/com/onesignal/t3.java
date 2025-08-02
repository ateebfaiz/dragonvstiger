package com.onesignal;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.games.paddleboat.GameControllerManager;
import java.util.List;

abstract class t3 {

    private static class a extends CustomTabsServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private String f11066a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11067b;

        a(String str, boolean z10) {
            this.f11066a = str;
            this.f11067b = z10;
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            customTabsClient.warmup(0);
            CustomTabsSession newSession = customTabsClient.newSession((CustomTabsCallback) null);
            if (newSession != null) {
                Uri parse = Uri.parse(this.f11066a);
                newSession.mayLaunchUrl(parse, (Bundle) null, (List<Bundle>) null);
                if (this.f11067b) {
                    CustomTabsIntent build = new CustomTabsIntent.Builder(newSession).build();
                    build.intent.setData(parse);
                    build.intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
                    o3.f10882b.startActivity(build.intent, build.startAnimationBundle);
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static boolean a() {
        return true;
    }

    protected static boolean b(String str, boolean z10) {
        if (!a()) {
            return false;
        }
        return CustomTabsClient.bindCustomTabsService(o3.f10882b, "com.android.chrome", new a(str, z10));
    }
}

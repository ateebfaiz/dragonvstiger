package org.cocos2dx.javascript.sdk;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.livechatinc.inappchat.a;
import com.livechatinc.inappchat.b;
import com.livechatinc.inappchat.c;
import com.livechatinc.inappchat.f;
import com.livechatinc.inappchat.g;
import java.util.HashMap;
import org.cocos2dx.javascript.AppActivity;

public class LiveChatSDK extends AppCompatActivity implements c {
    private static LiveChatSDK _instance;
    public a configuration;
    private g fullScreenChatWindow;
    public String groupId = "";
    public String licenseId = "";
    private AppActivity mActivity;

    public static LiveChatSDK getIns() {
        if (_instance == null) {
            _instance = new LiveChatSDK();
        }
        return _instance;
    }

    public void clearSession() {
        if (this.fullScreenChatWindow != null) {
            f.a(this.mActivity);
            this.fullScreenChatWindow.e(Boolean.FALSE);
        }
    }

    public boolean handleUri(Uri uri) {
        return false;
    }

    public void initSDK(AppActivity appActivity, String str, String str2) {
        this.mActivity = appActivity;
        this.licenseId = str;
        this.groupId = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("config", "config");
        this.configuration = new a(this.licenseId, this.groupId, "", "", hashMap);
        g b10 = f.b(this.mActivity);
        this.fullScreenChatWindow = b10;
        b10.f(this.configuration);
        this.fullScreenChatWindow.setEventsListener(_instance);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.fullScreenChatWindow.a(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        if (!this.fullScreenChatWindow.b()) {
            super.onBackPressed();
        }
    }

    public void onChatWindowVisibilityChanged(boolean z10) {
    }

    public boolean onError(b bVar, int i10, String str) {
        if (bVar == b.WebViewClient && i10 == -2 && this.fullScreenChatWindow.g()) {
            return false;
        }
        g gVar = this.fullScreenChatWindow;
        if (gVar == null) {
            return true;
        }
        gVar.c();
        return true;
    }

    public void onNewMessage(p9.a aVar, boolean z10) {
    }

    public void onRequestAudioPermissions(String[] strArr, int i10) {
        requestPermissions(strArr, i10);
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.fullScreenChatWindow.onRequestPermissionsResult(i10, strArr, iArr)) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    public void onStartFilePickerActivity(Intent intent, int i10) {
        this.mActivity.getLauncher().launch(intent);
    }

    public void onWindowInitialized() {
    }

    public void startFullScreenWindow() {
        g gVar = this.fullScreenChatWindow;
        if (gVar != null) {
            gVar.e(Boolean.TRUE);
            this.fullScreenChatWindow.d();
        }
    }
}

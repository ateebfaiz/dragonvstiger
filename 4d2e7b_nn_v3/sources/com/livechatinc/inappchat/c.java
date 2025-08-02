package com.livechatinc.inappchat;

import android.content.Intent;
import android.net.Uri;
import p9.a;

public interface c {
    boolean handleUri(Uri uri);

    void onChatWindowVisibilityChanged(boolean z10);

    boolean onError(b bVar, int i10, String str);

    void onNewMessage(a aVar, boolean z10);

    void onRequestAudioPermissions(String[] strArr, int i10);

    void onStartFilePickerActivity(Intent intent, int i10);

    void onWindowInitialized();
}

package com.appsflyer.deeplink;

import androidx.annotation.NonNull;

public interface DeepLinkListener {
    void onDeepLinking(@NonNull DeepLinkResult deepLinkResult);
}

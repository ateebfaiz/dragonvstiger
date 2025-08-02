package com.linecorp.linesdk.api;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import k9.a;
import k9.c;
import l9.e;
import l9.i;
import n9.b;

public class LineApiClientBuilder {
    @NonNull
    private Uri apiBaseUri;
    @NonNull
    private final String channelId;
    @NonNull
    private final Context context;
    private boolean isEncryptorPreparationDisabled;
    private boolean isTokenAutoRefreshDisabled;
    @NonNull
    private Uri openidDiscoveryDocumentUrl;

    public LineApiClientBuilder(@NonNull Context context2, @NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.context = context2.getApplicationContext();
            this.channelId = str;
            this.openidDiscoveryDocumentUrl = Uri.parse("https://access.line.me/.well-known/openid-configuration");
            this.apiBaseUri = Uri.parse("https://api.line.me/");
            return;
        }
        throw new IllegalArgumentException("channel id is empty");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LineApiClientBuilder apiBaseUri(@Nullable Uri uri) {
        this.apiBaseUri = (Uri) b.a(uri, Uri.parse("https://api.line.me/"));
        return this;
    }

    @NonNull
    public a build() {
        if (!this.isEncryptorPreparationDisabled) {
            c.c(this.context);
        }
        j9.b bVar = new j9.b(this.channelId, new e(this.context, this.openidDiscoveryDocumentUrl, this.apiBaseUri), new i(this.context, this.apiBaseUri), new a(this.context, this.channelId));
        if (this.isTokenAutoRefreshDisabled) {
            return bVar;
        }
        return j9.a.a(bVar);
    }

    @NonNull
    public LineApiClientBuilder disableEncryptorPreparation() {
        this.isEncryptorPreparationDisabled = true;
        return this;
    }

    @NonNull
    public LineApiClientBuilder disableTokenAutoRefresh() {
        this.isTokenAutoRefreshDisabled = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LineApiClientBuilder openidDiscoveryDocumentUrl(@Nullable Uri uri) {
        this.openidDiscoveryDocumentUrl = (Uri) b.a(uri, Uri.parse("https://access.line.me/.well-known/openid-configuration"));
        return this;
    }
}

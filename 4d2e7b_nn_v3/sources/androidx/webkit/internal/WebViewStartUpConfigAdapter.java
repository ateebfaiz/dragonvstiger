package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.WebViewStartUpConfig;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface;

public class WebViewStartUpConfigAdapter implements WebViewStartUpConfigBoundaryInterface {
    private final WebViewStartUpConfig mWebViewStartUpConfig;

    public WebViewStartUpConfigAdapter(@NonNull WebViewStartUpConfig webViewStartUpConfig) {
        this.mWebViewStartUpConfig = webViewStartUpConfig;
    }

    @NonNull
    public Executor getBackgroundExecutor() {
        return this.mWebViewStartUpConfig.getBackgroundExecutor();
    }

    public boolean shouldRunUiThreadStartUpTasks() {
        return this.mWebViewStartUpConfig.shouldRunUiThreadStartUpTasks();
    }
}

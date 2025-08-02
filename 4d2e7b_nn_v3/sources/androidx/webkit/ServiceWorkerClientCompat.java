package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.WorkerThread;

public abstract class ServiceWorkerClientCompat {
    @WorkerThread
    public abstract WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest);
}

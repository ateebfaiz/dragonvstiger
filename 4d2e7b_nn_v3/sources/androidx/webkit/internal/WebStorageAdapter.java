package androidx.webkit.internal;

import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebStorageBoundaryInterface;

public class WebStorageAdapter implements WebStorageBoundaryInterface {
    final WebStorageBoundaryInterface mImpl;

    public WebStorageAdapter(WebStorageBoundaryInterface webStorageBoundaryInterface) {
        this.mImpl = webStorageBoundaryInterface;
    }

    public void deleteBrowsingData(Executor executor, Runnable runnable) {
        this.mImpl.deleteBrowsingData(executor, runnable);
    }

    public String deleteBrowsingDataForSite(String str, Executor executor, Runnable runnable) {
        return this.mImpl.deleteBrowsingDataForSite(str, executor, runnable);
    }
}

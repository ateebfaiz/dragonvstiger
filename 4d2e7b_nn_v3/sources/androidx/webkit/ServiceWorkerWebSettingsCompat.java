package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

@AnyThread
public abstract class ServiceWorkerWebSettingsCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheMode {
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getBlockNetworkLoads();

    public abstract int getCacheMode();

    public abstract Set<String> getRequestedWithHeaderOriginAllowList();

    public abstract void setAllowContentAccess(boolean z10);

    public abstract void setAllowFileAccess(boolean z10);

    public abstract void setBlockNetworkLoads(boolean z10);

    public abstract void setCacheMode(int i10);

    public abstract void setRequestedWithHeaderOriginAllowList(Set<String> set);
}

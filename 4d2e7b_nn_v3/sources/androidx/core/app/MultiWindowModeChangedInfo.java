package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.m;

public final class MultiWindowModeChangedInfo {
    private final boolean isInMultiWindowMode;
    @RequiresApi(26)
    private Configuration newConfiguration;

    public MultiWindowModeChangedInfo(boolean z10) {
        this.isInMultiWindowMode = z10;
    }

    @RequiresApi(26)
    public final Configuration getNewConfig() {
        Configuration configuration = this.newConfiguration;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?".toString());
    }

    public final boolean isInMultiWindowMode() {
        return this.isInMultiWindowMode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public MultiWindowModeChangedInfo(boolean z10, Configuration configuration) {
        this(z10);
        m.f(configuration, "newConfig");
        this.newConfiguration = configuration;
    }
}

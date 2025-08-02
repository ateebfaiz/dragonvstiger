package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

public final class AFf1sSDK implements AFf1uSDK {
    private PluginInfo values = new PluginInfo(Plugin.NATIVE, "6.10.2", (Map) null, 4, (DefaultConstructorMarker) null);

    public final void values(PluginInfo pluginInfo) {
        m.f(pluginInfo, "");
        this.values = pluginInfo;
    }

    public final Map<String, Object> values() {
        Map<String, Object> j10 = i0.j(t.a("platform", this.values.getPlugin().getPluginName()), t.a("version", this.values.getVersion()));
        if (true ^ this.values.getAdditionalParams().isEmpty()) {
            j10.put("extras", this.values.getAdditionalParams());
        }
        return j10;
    }
}

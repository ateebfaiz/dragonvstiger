package com.appsflyer.internal.platform_extension;

import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class PluginInfo {
    private final String AFInAppEventType;
    private final Plugin valueOf;
    private final Map<String, String> values;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PluginInfo(Plugin plugin, String str) {
        this(plugin, str, (Map) null, 4, (DefaultConstructorMarker) null);
        m.f(plugin, "");
        m.f(str, "");
    }

    public static /* synthetic */ PluginInfo copy$default(PluginInfo pluginInfo, Plugin plugin, String str, Map<String, String> map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            plugin = pluginInfo.valueOf;
        }
        if ((i10 & 2) != 0) {
            str = pluginInfo.AFInAppEventType;
        }
        if ((i10 & 4) != 0) {
            map = pluginInfo.values;
        }
        return pluginInfo.copy(plugin, str, map);
    }

    public final Plugin component1() {
        return this.valueOf;
    }

    public final String component2() {
        return this.AFInAppEventType;
    }

    public final Map<String, String> component3() {
        return this.values;
    }

    public final PluginInfo copy(Plugin plugin, String str, Map<String, String> map) {
        m.f(plugin, "");
        m.f(str, "");
        m.f(map, "");
        return new PluginInfo(plugin, str, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginInfo)) {
            return false;
        }
        PluginInfo pluginInfo = (PluginInfo) obj;
        return this.valueOf == pluginInfo.valueOf && m.b(this.AFInAppEventType, pluginInfo.AFInAppEventType) && m.b(this.values, pluginInfo.values);
    }

    public final Map<String, String> getAdditionalParams() {
        return this.values;
    }

    public final Plugin getPlugin() {
        return this.valueOf;
    }

    public final String getVersion() {
        return this.AFInAppEventType;
    }

    public final int hashCode() {
        return (((this.valueOf.hashCode() * 31) + this.AFInAppEventType.hashCode()) * 31) + this.values.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PluginInfo(plugin=");
        sb2.append(this.valueOf);
        sb2.append(", version=");
        sb2.append(this.AFInAppEventType);
        sb2.append(", additionalParams=");
        sb2.append(this.values);
        sb2.append(')');
        return sb2.toString();
    }

    public PluginInfo(Plugin plugin, String str, Map<String, String> map) {
        m.f(plugin, "");
        m.f(str, "");
        m.f(map, "");
        this.valueOf = plugin;
        this.AFInAppEventType = str;
        this.values = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginInfo(Plugin plugin, String str, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(plugin, str, (i10 & 4) != 0 ? i0.f() : map);
    }
}

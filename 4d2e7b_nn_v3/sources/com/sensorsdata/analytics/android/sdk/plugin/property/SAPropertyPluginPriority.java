package com.sensorsdata.analytics.android.sdk.plugin.property;

public class SAPropertyPluginPriority {
    public static SAPropertyPluginPriority DEFAULT = new SAPropertyPluginPriority(500);
    public static SAPropertyPluginPriority HIGH = new SAPropertyPluginPriority(750);
    public static SAPropertyPluginPriority LOW = new SAPropertyPluginPriority(250);
    protected static SAPropertyPluginPriority SUPER = new SAPropertyPluginPriority(1431656640);
    private final long priority;

    public SAPropertyPluginPriority(long j10) {
        this.priority = j10;
    }

    public long getPriority() {
        return this.priority;
    }
}

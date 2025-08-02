package com.facebook.react.modules.devtoolssettings;

import android.content.SharedPreferences;
import com.facebook.fbreact.specs.NativeDevToolsSettingsManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "DevToolsSettingsManager")
public final class DevToolsSettingsManagerModule extends NativeDevToolsSettingsManagerSpec {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String KEY_CONSOLE_PATCH_SETTINGS = "ConsolePatchSettings";
    private static final String KEY_PROFILING_SETTINGS = "ProfilingSettings";
    private static final String SHARED_PREFERENCES_PREFIX = "ReactNative__DevToolsSettings";
    private final SharedPreferences sharedPreferences;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevToolsSettingsManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        SharedPreferences sharedPreferences2 = reactApplicationContext.getSharedPreferences(SHARED_PREFERENCES_PREFIX, 0);
        m.e(sharedPreferences2, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences2;
    }

    public String getConsolePatchSettings() {
        return this.sharedPreferences.getString(KEY_CONSOLE_PATCH_SETTINGS, (String) null);
    }

    public String getProfilingSettings() {
        return this.sharedPreferences.getString(KEY_PROFILING_SETTINGS, (String) null);
    }

    public void setConsolePatchSettings(String str) {
        this.sharedPreferences.edit().putString(KEY_CONSOLE_PATCH_SETTINGS, str).apply();
    }

    public void setProfilingSettings(String str) {
        this.sharedPreferences.edit().putString(KEY_PROFILING_SETTINGS, str).apply();
    }
}

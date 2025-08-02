package com.facebook.react.modules.appearance;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.fbreact.specs.NativeAppearanceSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "Appearance")
public final class AppearanceModule extends NativeAppearanceSpec {
    private static final String APPEARANCE_CHANGED_EVENT_NAME = "appearanceChanged";
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "Appearance";
    private String colorScheme;
    private final b overrideColorScheme;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppearanceModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (b) null, 2, (DefaultConstructorMarker) null);
        m.f(reactApplicationContext, "reactContext");
    }

    private final String colorSchemeForCurrentConfiguration(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) != 32) {
            return "light";
        }
        return "dark";
    }

    public void addListener(String str) {
        m.f(str, "eventName");
    }

    public final void emitAppearanceChanged(String str) {
        m.f(str, "colorScheme");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("colorScheme", str);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent(APPEARANCE_CHANGED_EVENT_NAME, createMap);
        }
    }

    public String getColorScheme() {
        Context currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = getReactApplicationContext();
        }
        m.c(currentActivity);
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(currentActivity);
        this.colorScheme = colorSchemeForCurrentConfiguration;
        return colorSchemeForCurrentConfiguration;
    }

    public final void onConfigurationChanged(Context context) {
        m.f(context, "currentContext");
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(context);
        if (!m.b(this.colorScheme, colorSchemeForCurrentConfiguration)) {
            this.colorScheme = colorSchemeForCurrentConfiguration;
            emitAppearanceChanged(colorSchemeForCurrentConfiguration);
        }
    }

    public void removeListeners(double d10) {
    }

    public void setColorScheme(String str) {
        m.f(str, "style");
        int hashCode = str.hashCode();
        if (hashCode != -1626174665) {
            if (hashCode != 3075958) {
                if (hashCode == 102970646 && str.equals("light")) {
                    AppCompatDelegate.setDefaultNightMode(1);
                }
            } else if (str.equals("dark")) {
                AppCompatDelegate.setDefaultNightMode(2);
            }
        } else if (str.equals("unspecified")) {
            AppCompatDelegate.setDefaultNightMode(-1);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppearanceModule(ReactApplicationContext reactApplicationContext, b bVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, (i10 & 2) != 0 ? null : bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppearanceModule(ReactApplicationContext reactApplicationContext, b bVar) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        this.colorScheme = colorSchemeForCurrentConfiguration(reactApplicationContext);
    }
}

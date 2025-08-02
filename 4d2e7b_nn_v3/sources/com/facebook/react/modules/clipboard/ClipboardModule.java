package com.facebook.react.modules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.facebook.fbreact.specs.NativeClipboardSpec;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "Clipboard")
public final class ClipboardModule extends NativeClipboardSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "Clipboard";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "context");
    }

    private final ClipboardManager getClipboardService() {
        Object systemService = getReactApplicationContext().getSystemService("clipboard");
        m.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }

    public void getString(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            ClipData primaryClip = getClipboardService().getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() < 1) {
                promise.resolve("");
            } else {
                promise.resolve(String.valueOf(primaryClip.getItemAt(0).getText()));
            }
        } catch (Exception e10) {
            promise.reject((Throwable) e10);
        }
    }

    public void setString(String str) {
        ClipData newPlainText = ClipData.newPlainText((CharSequence) null, str);
        m.e(newPlainText, "newPlainText(...)");
        getClipboardService().setPrimaryClip(newPlainText);
    }
}

package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap<>();
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ExtraData {
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    private final boolean shouldSkipDump(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                if (str.equals("--translation") && Build.VERSION.SDK_INT >= 31) {
                    return true;
                }
                return false;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                if (str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return false;
            case 1455016274:
                if (str.equals("--autofill") && Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
                return false;
            default:
                return false;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        m.f(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        m.f(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        m.e(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        m.f(cls, "extraDataClass");
        return (ExtraData) this.extraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        m.f(bundle, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void putExtraData(ExtraData extraData) {
        m.f(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    /* access modifiers changed from: protected */
    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        m.f(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return super.dispatchKeyEvent(keyEvent);
    }
}

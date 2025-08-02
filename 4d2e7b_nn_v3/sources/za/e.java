package za;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.d;
import kotlin.jvm.internal.m;

public abstract class e {
    public static final void a(ReactContext reactContext, d dVar) {
        m.f(reactContext, "<this>");
        m.f(dVar, NotificationCompat.CATEGORY_EVENT);
        try {
            NativeModule nativeModule = reactContext.getNativeModule(UIManagerModule.class);
            m.c(nativeModule);
            ((UIManagerModule) nativeModule).getEventDispatcher().c(dVar);
        } catch (NullPointerException e10) {
            throw new Exception("Couldn't get an instance of UIManagerModule. Gesture Handler is unable to send an event.", e10);
        }
    }
}

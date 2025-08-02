package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.react.ReactRootView;

public final class RNGestureHandlerEnabledRootView extends ReactRootView {
    public RNGestureHandlerEnabledRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        throw new UnsupportedOperationException("Your application is configured to use RNGestureHandlerEnabledRootView which is no longer supported. You can see how to migrate to <GestureHandlerRootView /> here: https://docs.swmansion.com/react-native-gesture-handler/docs/guides/migrating-off-rnghenabledroot");
    }
}

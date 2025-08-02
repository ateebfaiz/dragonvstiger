package com.swmansion.reanimated.keyboard;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;

public class WindowsInsetsManager {
    private final String MissingContextErrorMsg = "Unable to get reference to react activity";
    private boolean mIsNavigationBarTranslucent = false;
    private boolean mIsStatusBarTranslucent = false;
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;
    private final WeakReference<ReactApplicationContext> mReactContext;

    public WindowsInsetsManager(WeakReference<ReactApplicationContext> weakReference, Keyboard keyboard, NotifyAboutKeyboardChangeFunction notifyAboutKeyboardChangeFunction) {
        this.mReactContext = weakReference;
        this.mKeyboard = keyboard;
        this.mNotifyAboutKeyboardChange = notifyAboutKeyboardChangeFunction;
    }

    private Activity getCurrentActivity() {
        return this.mReactContext.get().getCurrentActivity();
    }

    private FrameLayout.LayoutParams getLayoutParams(int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mIsStatusBarTranslucent) {
            i10 = 0;
        }
        if (this.mIsNavigationBarTranslucent) {
            i11 = 0;
        }
        layoutParams.setMargins(0, i10, 0, i11);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateInsets$1(int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = getLayoutParams(i10, i11);
        int i12 = R.id.action_bar_root;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
        } else {
            currentActivity.getWindow().getDecorView().findViewById(i12).setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateWindowDecor$0(boolean z10) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
        } else {
            WindowCompat.setDecorFitsSystemWindows(currentActivity.getWindow(), z10);
        }
    }

    /* access modifiers changed from: private */
    public WindowInsetsCompat onApplyWindowInsetsListener(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        if (this.mKeyboard.getState() == KeyboardState.OPEN) {
            this.mKeyboard.updateHeight(windowInsetsCompat, this.mIsNavigationBarTranslucent);
            this.mNotifyAboutKeyboardChange.call();
        }
        setWindowInsets(onApplyWindowInsets);
        return onApplyWindowInsets;
    }

    private void setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        int systemBars = WindowInsetsCompat.Type.systemBars();
        updateInsets(windowInsetsCompat.getInsets(systemBars).top, windowInsetsCompat.getInsets(systemBars).bottom);
    }

    private void updateInsets(int i10, int i11) {
        new Handler(Looper.getMainLooper()).post(new d(this, i10, i11));
    }

    private void updateWindowDecor(boolean z10) {
        new Handler(Looper.getMainLooper()).post(new c(this, z10));
    }

    public void startObservingChanges(KeyboardAnimationCallback keyboardAnimationCallback, boolean z10, boolean z11) {
        this.mIsStatusBarTranslucent = z10;
        this.mIsNavigationBarTranslucent = z11;
        updateWindowDecor(false);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new b(this));
        ViewCompat.setWindowInsetsAnimationCallback(decorView, keyboardAnimationCallback);
    }

    public void stopObservingChanges() {
        boolean z10;
        if (this.mIsStatusBarTranslucent || this.mIsNavigationBarTranslucent) {
            z10 = false;
        } else {
            z10 = true;
        }
        updateWindowDecor(z10);
        updateInsets(0, 0);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        ViewCompat.setWindowInsetsAnimationCallback(decorView, (WindowInsetsAnimationCompat.Callback) null);
        ViewCompat.setOnApplyWindowInsetsListener(decorView, (OnApplyWindowInsetsListener) null);
    }
}

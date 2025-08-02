package com.swmansion.reanimated.keyboard;

import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

public class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback {
    private static final int CONTENT_TYPE_MASK = WindowInsetsCompat.Type.ime();
    private final boolean mIsNavigationBarTranslucent;
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;

    public KeyboardAnimationCallback(Keyboard keyboard, NotifyAboutKeyboardChangeFunction notifyAboutKeyboardChangeFunction, boolean z10) {
        super(1);
        this.mNotifyAboutKeyboardChange = notifyAboutKeyboardChangeFunction;
        this.mIsNavigationBarTranslucent = z10;
        this.mKeyboard = keyboard;
    }

    private static boolean isKeyboardAnimation(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        if ((windowInsetsAnimationCompat.getTypeMask() & CONTENT_TYPE_MASK) != 0) {
            return true;
        }
        return false;
    }

    public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        if (isKeyboardAnimation(windowInsetsAnimationCompat)) {
            this.mKeyboard.onAnimationEnd();
            this.mNotifyAboutKeyboardChange.call();
        }
    }

    @NonNull
    public WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        Iterator<WindowInsetsAnimationCompat> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (isKeyboardAnimation(it.next())) {
                    this.mKeyboard.updateHeight(windowInsetsCompat, this.mIsNavigationBarTranslucent);
                    this.mNotifyAboutKeyboardChange.call();
                    break;
                }
            } else {
                break;
            }
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsAnimationCompat.BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        if (!isKeyboardAnimation(windowInsetsAnimationCompat)) {
            return boundsCompat;
        }
        this.mKeyboard.onAnimationStart();
        this.mNotifyAboutKeyboardChange.call();
        return super.onStart(windowInsetsAnimationCompat, boundsCompat);
    }
}

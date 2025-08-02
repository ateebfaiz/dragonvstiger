package com.swmansion.reanimated.keyboard;

import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.g0;

public class Keyboard {
    private static final int CONTENT_TYPE_MASK = WindowInsetsCompat.Type.ime();
    private static final int SYSTEM_BAR_TYPE_MASK = WindowInsetsCompat.Type.systemBars();
    private int mActiveTransitionCounter = 0;
    private int mHeight = 0;
    private KeyboardState mState = KeyboardState.UNKNOWN;

    public int getHeight() {
        return this.mHeight;
    }

    public KeyboardState getState() {
        return this.mState;
    }

    public void onAnimationEnd() {
        KeyboardState keyboardState;
        int i10 = this.mActiveTransitionCounter - 1;
        this.mActiveTransitionCounter = i10;
        if (i10 == 0) {
            if (this.mHeight <= 0) {
                keyboardState = KeyboardState.CLOSED;
            } else {
                keyboardState = KeyboardState.OPEN;
            }
            this.mState = keyboardState;
        }
    }

    public void onAnimationStart() {
        KeyboardState keyboardState;
        int i10 = this.mActiveTransitionCounter;
        if (i10 > 0) {
            KeyboardState keyboardState2 = this.mState;
            KeyboardState keyboardState3 = KeyboardState.OPENING;
            if (keyboardState2 == keyboardState3) {
                keyboardState3 = KeyboardState.CLOSING;
            }
            this.mState = keyboardState3;
        } else {
            if (this.mHeight <= 0) {
                keyboardState = KeyboardState.OPENING;
            } else {
                keyboardState = KeyboardState.CLOSING;
            }
            this.mState = keyboardState;
        }
        this.mActiveTransitionCounter = i10 + 1;
    }

    public void updateHeight(WindowInsetsCompat windowInsetsCompat, boolean z10) {
        int i10;
        int i11 = windowInsetsCompat.getInsets(CONTENT_TYPE_MASK).bottom;
        if (z10) {
            i10 = 0;
        } else {
            i10 = windowInsetsCompat.getInsets(SYSTEM_BAR_TYPE_MASK).bottom;
        }
        int b10 = (int) g0.b((float) Math.max(0, i11 - i10));
        if (b10 > 0 || this.mState != KeyboardState.OPEN) {
            this.mHeight = b10;
        }
    }
}

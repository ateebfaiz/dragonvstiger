package com.swmansion.reanimated.keyboard;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class KeyboardAnimationManager {
    private final Keyboard mKeyboard;
    private final ConcurrentHashMap<Integer, KeyboardWorkletWrapper> mListeners = new ConcurrentHashMap<>();
    private int mNextListenerId = 0;
    private final WindowsInsetsManager mWindowsInsetsManager;

    public KeyboardAnimationManager(WeakReference<ReactApplicationContext> weakReference) {
        Keyboard keyboard = new Keyboard();
        this.mKeyboard = keyboard;
        this.mWindowsInsetsManager = new WindowsInsetsManager(weakReference, keyboard, new a(this));
    }

    public void notifyAboutKeyboardChange() {
        for (KeyboardWorkletWrapper invoke : this.mListeners.values()) {
            invoke.invoke(this.mKeyboard.getState().asInt(), this.mKeyboard.getHeight());
        }
    }

    public int subscribeForKeyboardUpdates(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z10, boolean z11) {
        int i10 = this.mNextListenerId;
        this.mNextListenerId = i10 + 1;
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.startObservingChanges(new KeyboardAnimationCallback(this.mKeyboard, new a(this), z11), z10, z11);
        }
        this.mListeners.put(Integer.valueOf(i10), keyboardWorkletWrapper);
        return i10;
    }

    public void unsubscribeFromKeyboardUpdates(int i10) {
        this.mListeners.remove(Integer.valueOf(i10));
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.stopObservingChanges();
        }
    }
}

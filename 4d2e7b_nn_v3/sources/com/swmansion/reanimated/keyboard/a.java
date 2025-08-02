package com.swmansion.reanimated.keyboard;

public final /* synthetic */ class a implements NotifyAboutKeyboardChangeFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardAnimationManager f11448a;

    public /* synthetic */ a(KeyboardAnimationManager keyboardAnimationManager) {
        this.f11448a = keyboardAnimationManager;
    }

    public final void call() {
        this.f11448a.notifyAboutKeyboardChange();
    }
}

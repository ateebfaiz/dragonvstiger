package org.cocos2dx.javascript.rn;

import androidx.lifecycle.Observer;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RNDelegateManager f1486a;

    public /* synthetic */ c(RNDelegateManager rNDelegateManager) {
        this.f1486a = rNDelegateManager;
    }

    public final void onChanged(Object obj) {
        this.f1486a.lambda$observerHotUpdate$1((Integer) obj);
    }
}

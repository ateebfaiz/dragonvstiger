package org.cocos2dx.javascript;

import org.cocos2dx.javascript.ExitDialog;

public final /* synthetic */ class z implements ExitDialog.onExitOnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebGameActivity f1498a;

    public /* synthetic */ z(WebGameActivity webGameActivity) {
        this.f1498a = webGameActivity;
    }

    public final void onExitClick() {
        this.f1498a.goClose();
    }
}

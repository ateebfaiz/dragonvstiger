package com.geetest.captcha;

import android.content.DialogInterface;
import android.view.KeyEvent;

public final class e implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f5788a;

    public e(z zVar) {
        this.f5788a = zVar;
    }

    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent == null || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1) {
            return false;
        }
        this.f5788a.b();
        return false;
    }
}

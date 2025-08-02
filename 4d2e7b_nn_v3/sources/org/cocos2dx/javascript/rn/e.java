package org.cocos2dx.javascript.rn;

import android.content.Intent;
import org.cocos2dx.javascript.AppActivity;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppActivity f1488a;

    public /* synthetic */ e(AppActivity appActivity) {
        this.f1488a = appActivity;
    }

    public final void run() {
        this.f1488a.startActivity(new Intent(this.f1488a, TestActivity.class));
    }
}

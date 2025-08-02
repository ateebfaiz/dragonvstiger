package com.cocos.lib;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CocosActivity f19394a;

    public /* synthetic */ b(CocosActivity cocosActivity) {
        this.f19394a = cocosActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f19394a.lambda$onCreate$0(view, motionEvent);
    }
}

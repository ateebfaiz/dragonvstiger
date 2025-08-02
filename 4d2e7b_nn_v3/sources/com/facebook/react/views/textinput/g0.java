package com.facebook.react.views.textinput;

import android.view.View;
import com.facebook.react.uimanager.e1;

public final /* synthetic */ class g0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e1 f4329a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReactEditText f4330b;

    public /* synthetic */ g0(e1 e1Var, ReactEditText reactEditText) {
        this.f4329a = e1Var;
        this.f4330b = reactEditText;
    }

    public final void onFocusChange(View view, boolean z10) {
        ReactTextInputManager.lambda$addEventEmitters$0(this.f4329a, this.f4330b, view, z10);
    }
}

package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.widget.TextView;
import com.facebook.react.uimanager.e1;

public final /* synthetic */ class h0 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactEditText f4332a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e1 f4333b;

    public /* synthetic */ h0(ReactEditText reactEditText, e1 e1Var) {
        this.f4332a = reactEditText;
        this.f4333b = e1Var;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return ReactTextInputManager.lambda$addEventEmitters$1(this.f4332a, this.f4333b, textView, i10, keyEvent);
    }
}

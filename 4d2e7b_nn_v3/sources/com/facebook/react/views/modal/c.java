package com.facebook.react.views.modal;

import android.content.DialogInterface;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.views.modal.ReactModalHostView;

public final /* synthetic */ class c implements ReactModalHostView.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f4051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e1 f4052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReactModalHostView f4053c;

    public /* synthetic */ c(e eVar, e1 e1Var, ReactModalHostView reactModalHostView) {
        this.f4051a = eVar;
        this.f4052b = e1Var;
        this.f4053c = reactModalHostView;
    }

    public final void a(DialogInterface dialogInterface) {
        ReactModalHostManager.addEventEmitters$lambda$0(this.f4051a, this.f4052b, this.f4053c, dialogInterface);
    }
}

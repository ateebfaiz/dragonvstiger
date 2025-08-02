package com.facebook.react.views.modal;

import android.content.DialogInterface;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;

public final /* synthetic */ class d implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f4054a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e1 f4055b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReactModalHostView f4056c;

    public /* synthetic */ d(e eVar, e1 e1Var, ReactModalHostView reactModalHostView) {
        this.f4054a = eVar;
        this.f4055b = e1Var;
        this.f4056c = reactModalHostView;
    }

    public final void onShow(DialogInterface dialogInterface) {
        ReactModalHostManager.addEventEmitters$lambda$1(this.f4054a, this.f4055b, this.f4056c, dialogInterface);
    }
}

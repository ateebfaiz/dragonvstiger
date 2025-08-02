package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class x implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.a f9320a;

    public /* synthetic */ x(FirebaseMessaging.a aVar) {
        this.f9320a = aVar;
    }

    public final void handle(Event event) {
        this.f9320a.d(event);
    }
}

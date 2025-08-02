package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f8994a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Event f8995b;

    public /* synthetic */ p(Map.Entry entry, Event event) {
        this.f8994a = entry;
        this.f8995b = event;
    }

    public final void run() {
        ((EventHandler) this.f8994a.getKey()).handle(this.f8995b);
    }
}

package com.facebook.react.uimanager.events;

import z2.a;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f3587a = new b();

    private b() {
    }

    public static e k() {
        return f3587a;
    }

    public void a(int i10, RCTEventEmitter rCTEventEmitter) {
    }

    public void b(i iVar) {
    }

    public void c(d dVar) {
        String simpleName = getClass().getSimpleName();
        a.b(simpleName, "Trying to emit event to JS, but the React instance isn't ready. Event: " + dVar.getEventName());
    }

    public void d() {
    }

    public void e(a aVar) {
    }

    public void f(a aVar) {
    }

    public void g() {
    }

    public void h(int i10, RCTModernEventEmitter rCTModernEventEmitter) {
    }

    public void i(int i10) {
    }

    public void j(i iVar) {
    }
}

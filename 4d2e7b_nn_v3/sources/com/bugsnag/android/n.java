package com.bugsnag.android;

import c1.q;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

public abstract class n {
    private final CopyOnWriteArrayList<q> observers = new CopyOnWriteArrayList<>();

    public final void addObserver(q qVar) {
        this.observers.addIfAbsent(qVar);
    }

    public final CopyOnWriteArrayList<q> getObservers$bugsnag_android_core_release() {
        return this.observers;
    }

    public final void removeObserver(q qVar) {
        this.observers.remove(qVar);
    }

    public final void updateState(v3 v3Var) {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(v3Var);
            }
        }
    }

    public final void updateState$bugsnag_android_core_release(Function0<? extends v3> function0) {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3 v3Var = (v3) function0.invoke();
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(v3Var);
            }
        }
    }
}

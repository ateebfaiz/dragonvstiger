package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import d9.a;
import java.util.ArrayList;
import java.util.List;

public class ComponentMonitor implements ComponentRegistrarProcessor {
    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$processRegistrar$0(String str, Component component, ComponentContainer componentContainer) {
        try {
            FirebaseTrace.pushTrace(str);
            return component.getFactory().create(componentContainer);
        } finally {
            FirebaseTrace.popTrace();
        }
    }

    public List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component next : componentRegistrar.getComponents()) {
            String name = next.getName();
            if (name != null) {
                next = next.withFactory(new a(name, next));
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}

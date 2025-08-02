package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class x implements ComponentContainer {

    /* renamed from: a  reason: collision with root package name */
    private final Set f9007a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f9008b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f9009c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f9010d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f9011e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f9012f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentContainer f9013g;

    private static class a implements Publisher {

        /* renamed from: a  reason: collision with root package name */
        private final Set f9014a;

        /* renamed from: b  reason: collision with root package name */
        private final Publisher f9015b;

        public a(Set set, Publisher publisher) {
            this.f9014a = set;
            this.f9015b = publisher;
        }

        public void publish(Event event) {
            if (this.f9014a.contains(event.getType())) {
                this.f9015b.publish(event);
            } else {
                throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            }
        }
    }

    x(Component component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency next : component.getDependencies()) {
            if (next.isDirectInjection()) {
                if (next.isSet()) {
                    hashSet4.add(next.getInterface());
                } else {
                    hashSet.add(next.getInterface());
                }
            } else if (next.isDeferred()) {
                hashSet3.add(next.getInterface());
            } else if (next.isSet()) {
                hashSet5.add(next.getInterface());
            } else {
                hashSet2.add(next.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Qualified.unqualified(Publisher.class));
        }
        this.f9007a = Collections.unmodifiableSet(hashSet);
        this.f9008b = Collections.unmodifiableSet(hashSet2);
        this.f9009c = Collections.unmodifiableSet(hashSet3);
        this.f9010d = Collections.unmodifiableSet(hashSet4);
        this.f9011e = Collections.unmodifiableSet(hashSet5);
        this.f9012f = component.getPublishedEvents();
        this.f9013g = componentContainer;
    }

    public Object get(Class cls) {
        if (this.f9007a.contains(Qualified.unqualified(cls))) {
            Object obj = this.f9013g.get(cls);
            if (!cls.equals(Publisher.class)) {
                return obj;
            }
            return new a(this.f9012f, (Publisher) obj);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public Deferred getDeferred(Class cls) {
        return getDeferred(Qualified.unqualified(cls));
    }

    public Provider getProvider(Class cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    public /* synthetic */ Set setOf(Class cls) {
        return f.f(this, cls);
    }

    public Provider setOfProvider(Class cls) {
        return setOfProvider(Qualified.unqualified(cls));
    }

    public Deferred getDeferred(Qualified qualified) {
        if (this.f9009c.contains(qualified)) {
            return this.f9013g.getDeferred(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[]{qualified}));
    }

    public Provider getProvider(Qualified qualified) {
        if (this.f9008b.contains(qualified)) {
            return this.f9013g.getProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{qualified}));
    }

    public Set setOf(Qualified qualified) {
        if (this.f9010d.contains(qualified)) {
            return this.f9013g.setOf(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{qualified}));
    }

    public Provider setOfProvider(Qualified qualified) {
        if (this.f9011e.contains(qualified)) {
            return this.f9013g.setOfProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{qualified}));
    }

    public Object get(Qualified qualified) {
        if (this.f9007a.contains(qualified)) {
            return this.f9013g.get(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{qualified}));
    }
}

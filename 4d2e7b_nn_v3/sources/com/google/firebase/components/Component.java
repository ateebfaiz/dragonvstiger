package com.google.firebase.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component<T> {
    private final Set<Dependency> dependencies;
    private final ComponentFactory<T> factory;
    private final int instantiation;
    private final String name;
    private final Set<Qualified<? super T>> providedInterfaces;
    private final Set<Class<?>> publishedEvents;
    private final int type;

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>((Class) cls, new Class[0]);
    }

    public static <T> Component<T> intoSet(T t10, Class<T> cls) {
        return intoSetBuilder(cls).factory(new c(t10)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        return builder(cls).intoSet();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$intoSet$3(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$intoSet$4(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$0(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$1(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$2(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @Deprecated
    public static <T> Component<T> of(Class<T> cls, T t10) {
        return builder(cls).factory(new d(t10)).build();
    }

    public Set<Dependency> getDependencies() {
        return this.dependencies;
    }

    public ComponentFactory<T> getFactory() {
        return this.factory;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public Set<Qualified<? super T>> getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.publishedEvents;
    }

    public boolean isAlwaysEager() {
        if (this.instantiation == 1) {
            return true;
        }
        return false;
    }

    public boolean isEagerInDefaultApp() {
        if (this.instantiation == 2) {
            return true;
        }
        return false;
    }

    public boolean isLazy() {
        if (this.instantiation == 0) {
            return true;
        }
        return false;
    }

    public boolean isValue() {
        if (this.type == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }

    public Component<T> withFactory(ComponentFactory<T> componentFactory) {
        return new Component(this.name, this.providedInterfaces, this.dependencies, this.instantiation, this.type, componentFactory, this.publishedEvents);
    }

    public static class Builder<T> {
        private final Set<Dependency> dependencies;
        private ComponentFactory<T> factory;
        private int instantiation;
        private String name;
        private final Set<Qualified<? super T>> providedInterfaces;
        private final Set<Class<?>> publishedEvents;
        private int type;

        /* access modifiers changed from: private */
        @CanIgnoreReturnValue
        public Builder<T> intoSet() {
            this.type = 1;
            return this;
        }

        @CanIgnoreReturnValue
        private Builder<T> setInstantiation(int i10) {
            boolean z10;
            if (this.instantiation == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Instantiation type has already been set.");
            this.instantiation = i10;
            return this;
        }

        private void validateInterface(Qualified<?> qualified) {
            Preconditions.checkArgument(!this.providedInterfaces.contains(qualified), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @CanIgnoreReturnValue
        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            validateInterface(dependency.getInterface());
            this.dependencies.add(dependency);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> alwaysEager() {
            return setInstantiation(1);
        }

        public Component<T> build() {
            boolean z10;
            if (this.factory != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Missing required property: factory.");
            return new Component(this.name, new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
        }

        @CanIgnoreReturnValue
        public Builder<T> eagerInDefaultApp() {
            return setInstantiation(2);
        }

        @CanIgnoreReturnValue
        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.factory = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> name(@NonNull String str) {
            this.name = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> publishes(Class<?> cls) {
            this.publishedEvents.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.name = null;
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(Qualified.unqualified(cls));
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
                this.providedInterfaces.add(Qualified.unqualified(cls2));
            }
        }

        @SafeVarargs
        private Builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
            this.name = null;
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified<? super T> checkNotNull : qualifiedArr) {
                Preconditions.checkNotNull(checkNotNull, "Null interface");
            }
            Collections.addAll(this.providedInterfaces, qualifiedArr);
        }
    }

    private Component(@Nullable String str, Set<Qualified<? super T>> set, Set<Dependency> set2, int i10, int i11, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.name = str;
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i10;
        this.type = i11;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>((Class) cls, (Class[]) clsArr);
    }

    public static <T> Component<T> intoSet(T t10, Qualified<T> qualified) {
        return intoSetBuilder(qualified).factory(new b(t10)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Qualified<T> qualified) {
        return builder(qualified).intoSet();
    }

    @SafeVarargs
    public static <T> Component<T> of(T t10, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new e(t10)).build();
    }

    public static <T> Builder<T> builder(Qualified<T> qualified) {
        return new Builder<>((Qualified) qualified, new Qualified[0]);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t10, Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return builder(qualified, qualifiedArr).factory(new a(t10)).build();
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return new Builder<>((Qualified) qualified, (Qualified[]) qualifiedArr);
    }
}

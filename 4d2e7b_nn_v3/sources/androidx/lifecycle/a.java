package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class a {

    /* renamed from: c  reason: collision with root package name */
    static a f15879c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map f15880a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map f15881b = new HashMap();

    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    static class C0203a {

        /* renamed from: a  reason: collision with root package name */
        final Map f15882a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map f15883b;

        C0203a(Map map) {
            this.f15883b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List list = (List) this.f15882a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f15882a.put(event, list);
                }
                list.add((b) entry.getKey());
            }
        }

        private static void b(List list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(lifecycleOwner, event, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b((List) this.f15882a.get(event), lifecycleOwner, event, obj);
            b((List) this.f15882a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f15884a;

        /* renamed from: b  reason: collision with root package name */
        final Method f15885b;

        b(int i10, Method method) {
            this.f15884a = i10;
            this.f15885b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f15884a;
                if (i10 == 0) {
                    this.f15885b.invoke(obj, (Object[]) null);
                } else if (i10 == 1) {
                    this.f15885b.invoke(obj, new Object[]{lifecycleOwner});
                } else if (i10 == 2) {
                    this.f15885b.invoke(obj, new Object[]{lifecycleOwner, event});
                }
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Failed to call observer method", e10.getCause());
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f15884a != bVar.f15884a || !this.f15885b.getName().equals(bVar.f15885b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f15884a * 31) + this.f15885b.getName().hashCode();
        }
    }

    a() {
    }

    private C0203a a(Class cls, Method[] methodArr) {
        int i10;
        C0203a c10;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c10 = c(superclass)) == null)) {
            hashMap.putAll(c10.f15883b);
        }
        for (Class c11 : cls.getInterfaces()) {
            for (Map.Entry entry : c(c11).f15883b.entrySet()) {
                e(hashMap, (b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else if (LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i10 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i10, method), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0203a aVar = new C0203a(hashMap);
        this.f15880a.put(cls, aVar);
        this.f15881b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    private void e(Map map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f15885b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    public C0203a c(Class cls) {
        C0203a aVar = (C0203a) this.f15880a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f15881b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method annotation : b10) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f15881b.put(cls, Boolean.FALSE);
        return false;
    }
}

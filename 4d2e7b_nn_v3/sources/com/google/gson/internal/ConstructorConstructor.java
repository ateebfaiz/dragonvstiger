package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    class a implements ObjectConstructor {
        a() {
        }

        public Object construct() {
            return new TreeSet();
        }
    }

    class b implements ObjectConstructor {
        b() {
        }

        public Object construct() {
            return new LinkedHashSet();
        }
    }

    class c implements ObjectConstructor {
        c() {
        }

        public Object construct() {
            return new ArrayDeque();
        }
    }

    class d implements ObjectConstructor {
        d() {
        }

        public Object construct() {
            return new ArrayList();
        }
    }

    class e implements ObjectConstructor {
        e() {
        }

        public Object construct() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements ObjectConstructor {
        f() {
        }

        public Object construct() {
            return new ConcurrentHashMap();
        }
    }

    class g implements ObjectConstructor {
        g() {
        }

        public Object construct() {
            return new TreeMap();
        }
    }

    class h implements ObjectConstructor {
        h() {
        }

        public Object construct() {
            return new LinkedHashMap();
        }
    }

    class i implements ObjectConstructor {
        i() {
        }

        public Object construct() {
            return new LinkedTreeMap();
        }
    }

    class j implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f9341a;

        j(Class cls) {
            this.f9341a = cls;
        }

        public Object construct() {
            try {
                return UnsafeAllocator.INSTANCE.newInstance(this.f9341a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f9341a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    class k implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstanceCreator f9343a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f9344b;

        k(InstanceCreator instanceCreator, Type type) {
            this.f9343a = instanceCreator;
            this.f9344b = type;
        }

        public Object construct() {
            return this.f9343a.createInstance(this.f9344b);
        }
    }

    class l implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9346a;

        l(String str) {
            this.f9346a = str;
        }

        public Object construct() {
            throw new JsonIOException(this.f9346a);
        }
    }

    class m implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstanceCreator f9348a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f9349b;

        m(InstanceCreator instanceCreator, Type type) {
            this.f9348a = instanceCreator;
            this.f9349b = type;
        }

        public Object construct() {
            return this.f9348a.createInstance(this.f9349b);
        }
    }

    class n implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9351a;

        n(String str) {
            this.f9351a = str;
        }

        public Object construct() {
            throw new JsonIOException(this.f9351a);
        }
    }

    class o implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9353a;

        o(String str) {
            this.f9353a = str;
        }

        public Object construct() {
            throw new JsonIOException(this.f9353a);
        }
    }

    class p implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f9355a;

        p(Type type) {
            this.f9355a = type;
        }

        public Object construct() {
            Type type = this.f9355a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f9355a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f9355a.toString());
        }
    }

    class q implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f9356a;

        q(Type type) {
            this.f9356a = type;
        }

        public Object construct() {
            Type type = this.f9356a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + this.f9356a.toString());
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.f9356a.toString());
        }
    }

    class r implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9357a;

        r(String str) {
            this.f9357a = str;
        }

        public Object construct() {
            throw new JsonIOException(this.f9357a);
        }
    }

    class s implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9358a;

        s(String str) {
            this.f9358a = str;
        }

        public Object construct() {
            throw new JsonIOException(this.f9358a);
        }
    }

    class t implements ObjectConstructor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f9359a;

        t(Constructor constructor) {
            this.f9359a = constructor;
        }

        public Object construct() {
            try {
                return this.f9359a.newInstance((Object[]) null);
            } catch (InstantiationException e10) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f9359a) + "' with no args", e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f9359a) + "' with no args", e11.getCause());
            } catch (IllegalAccessException e12) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e12);
            }
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z10, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z10;
        this.reflectionFilters = list;
    }

    static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String tryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult != filterResult2 && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, (Object) null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            } else if (filterResult != filterResult2 || (tryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) == null) {
                return new t(declaredConstructor);
            } else {
                return new s(tryMakeAccessible);
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new c();
            }
            return new d();
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if (type instanceof ParameterizedType) {
                if (!String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                    return new h();
                }
            }
            return new i();
        }
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new k(instanceCreator, type);
        }
        InstanceCreator instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new m(instanceCreator2, type);
        }
        ObjectConstructor<T> newSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (newSpecialCollectionConstructor != null) {
            return newSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (newDefaultImplementationConstructor != null) {
            return newDefaultImplementationConstructor;
        }
        String checkInstantiable = checkInstantiable(rawType);
        if (checkInstantiable != null) {
            return new n(checkInstantiable);
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}

package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

abstract class k2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f3794a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f3795b = new HashMap();

    class a extends ThreadLocal {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3796a;

        a(int i10) {
            this.f3796a = i10;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Object[] initialValue() {
            return new Object[this.f3796a];
        }
    }

    private static class b extends m {
        public b(h7.a aVar, Method method) {
            super(aVar, "Array", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            return (ReadableArray) obj;
        }
    }

    private static class c extends m {

        /* renamed from: i  reason: collision with root package name */
        private final boolean f3797i;

        public c(h7.a aVar, Method method, boolean z10) {
            super(aVar, "boolean", method);
            this.f3797i = z10;
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            boolean z10;
            if (obj == null) {
                z10 = this.f3797i;
            } else {
                z10 = ((Boolean) obj).booleanValue();
            }
            if (z10) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    private static class d extends m {
        public d(h7.a aVar, Method method) {
            super(aVar, "boolean", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            if (obj == null) {
                return null;
            }
            if (((Boolean) obj).booleanValue()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    private static class e extends m {
        public e(h7.a aVar, Method method) {
            super(aVar, "mixed", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            if (obj != null) {
                return ColorPropConverter.getColor(obj, context);
            }
            return null;
        }

        public e(h7.b bVar, Method method, int i10) {
            super(bVar, "mixed", method, i10);
        }
    }

    private static class f extends m {
        public f(h7.a aVar, Method method) {
            super(aVar, "number", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Double) {
                return Integer.valueOf(((Double) obj).intValue());
            }
            return (Integer) obj;
        }

        public f(h7.b bVar, Method method, int i10) {
            super(bVar, "number", method, i10);
        }
    }

    private static class i extends m {
        public i(h7.a aVar, Method method) {
            super(aVar, "mixed", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            if (obj instanceof Dynamic) {
                return obj;
            }
            return new DynamicFromObject(obj);
        }

        public i(h7.b bVar, Method method, int i10) {
            super(bVar, "mixed", method, i10);
        }
    }

    private static class l extends m {
        public l(h7.a aVar, Method method) {
            super(aVar, "Map", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            return (ReadableMap) obj;
        }
    }

    private static class n extends m {
        public n(h7.a aVar, Method method) {
            super(aVar, "String", method);
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            return (String) obj;
        }
    }

    public static void b() {
        f3794a.clear();
        f3795b.clear();
    }

    private static m c(h7.a aVar, Method method, Class cls) {
        if (cls == Dynamic.class) {
            return new i(aVar, method);
        }
        if (cls == Boolean.TYPE) {
            return new c(aVar, method, aVar.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            if ("Color".equals(aVar.customType())) {
                return new g(aVar, method, aVar.defaultInt());
            }
            return new k(aVar, method, aVar.defaultInt());
        } else if (cls == Float.TYPE) {
            return new j(aVar, method, aVar.defaultFloat());
        } else {
            if (cls == Double.TYPE) {
                return new h(aVar, method, aVar.defaultDouble());
            }
            if (cls == String.class) {
                return new n(aVar, method);
            }
            if (cls == Boolean.class) {
                return new d(aVar, method);
            }
            if (cls == Integer.class) {
                if ("Color".equals(aVar.customType())) {
                    return new e(aVar, method);
                }
                return new f(aVar, method);
            } else if (cls == ReadableArray.class) {
                return new b(aVar, method);
            } else {
                if (cls == ReadableMap.class) {
                    return new l(aVar, method);
                }
                throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
            }
        }
    }

    private static void d(h7.b bVar, Method method, Class cls, Map map) {
        String[] names = bVar.names();
        int i10 = 0;
        if (cls == Dynamic.class) {
            while (i10 < names.length) {
                map.put(names[i10], new i(bVar, method, i10));
                i10++;
            }
        } else if (cls == Integer.TYPE) {
            while (i10 < names.length) {
                if ("Color".equals(bVar.customType())) {
                    map.put(names[i10], new g(bVar, method, i10, bVar.defaultInt()));
                } else {
                    map.put(names[i10], new k(bVar, method, i10, bVar.defaultInt()));
                }
                i10++;
            }
        } else if (cls == Float.TYPE) {
            while (i10 < names.length) {
                map.put(names[i10], new j(bVar, method, i10, bVar.defaultFloat()));
                i10++;
            }
        } else if (cls == Double.TYPE) {
            while (i10 < names.length) {
                map.put(names[i10], new h(bVar, method, i10, bVar.defaultDouble()));
                i10++;
            }
        } else if (cls == Integer.class) {
            while (i10 < names.length) {
                if ("Color".equals(bVar.customType())) {
                    map.put(names[i10], new e(bVar, method, i10));
                } else {
                    map.put(names[i10], new f(bVar, method, i10));
                }
                i10++;
            }
        } else {
            throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
        }
    }

    /* access modifiers changed from: private */
    public static ThreadLocal e(int i10) {
        if (i10 <= 0) {
            return null;
        }
        return new a(i10);
    }

    private static void f(Class cls, Map map) {
        for (Method method : cls.getDeclaredMethods()) {
            h7.a aVar = (h7.a) method.getAnnotation(h7.a.class);
            if (aVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    map.put(aVar.name(), c(aVar, method, parameterTypes[0]));
                } else {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
            }
            h7.b bVar = (h7.b) method.getAnnotation(h7.b.class);
            if (bVar != null) {
                Class[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 2) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                } else if (parameterTypes2[0] == Integer.TYPE) {
                    d(bVar, method, parameterTypes2[1], map);
                } else {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
            }
        }
    }

    private static void g(Class cls, Map map) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            h7.a aVar = (h7.a) method.getAnnotation(h7.a.class);
            Class<View> cls2 = View.class;
            if (aVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                } else if (cls2.isAssignableFrom(parameterTypes[0])) {
                    map.put(aVar.name(), c(aVar, method, parameterTypes[1]));
                } else {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
            }
            h7.b bVar = (h7.b) method.getAnnotation(h7.b.class);
            if (bVar != null) {
                Class[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 3) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                } else if (!cls2.isAssignableFrom(parameterTypes2[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                } else if (parameterTypes2[1] == Integer.TYPE) {
                    d(bVar, method, parameterTypes2[2], map);
                } else {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
            }
        }
    }

    static Map h(Class cls) {
        if (cls == null) {
            return f3795b;
        }
        for (Class<t0> cls2 : cls.getInterfaces()) {
            if (cls2 == t0.class) {
                return f3795b;
            }
        }
        Map map = f3794a;
        Map map2 = (Map) map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap(h(cls.getSuperclass()));
        f(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    static Map i(Class cls) {
        if (cls == ViewManager.class) {
            return f3795b;
        }
        Map map = f3794a;
        Map map2 = (Map) map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap(i(cls.getSuperclass()));
        g(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    private static class g extends m {

        /* renamed from: i  reason: collision with root package name */
        private final int f3798i;

        public g(h7.a aVar, Method method, int i10) {
            super(aVar, "mixed", method);
            this.f3798i = i10;
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            if (obj == null) {
                return Integer.valueOf(this.f3798i);
            }
            return ColorPropConverter.getColor(obj, context);
        }

        public g(h7.b bVar, Method method, int i10, int i11) {
            super(bVar, "mixed", method, i10);
            this.f3798i = i11;
        }
    }

    private static class h extends m {

        /* renamed from: i  reason: collision with root package name */
        private final double f3799i;

        public h(h7.a aVar, Method method, double d10) {
            super(aVar, "number", method);
            this.f3799i = d10;
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            double d10;
            if (obj == null) {
                d10 = this.f3799i;
            } else {
                d10 = ((Double) obj).doubleValue();
            }
            return Double.valueOf(d10);
        }

        public h(h7.b bVar, Method method, int i10, double d10) {
            super(bVar, "number", method, i10);
            this.f3799i = d10;
        }
    }

    private static class j extends m {

        /* renamed from: i  reason: collision with root package name */
        private final float f3800i;

        public j(h7.a aVar, Method method, float f10) {
            super(aVar, "number", method);
            this.f3800i = f10;
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            float f10;
            if (obj == null) {
                f10 = this.f3800i;
            } else {
                f10 = ((Double) obj).floatValue();
            }
            return Float.valueOf(f10);
        }

        public j(h7.b bVar, Method method, int i10, float f10) {
            super(bVar, "number", method, i10);
            this.f3800i = f10;
        }
    }

    private static class k extends m {

        /* renamed from: i  reason: collision with root package name */
        private final int f3801i;

        public k(h7.a aVar, Method method, int i10) {
            super(aVar, "number", method);
            this.f3801i = i10;
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj, Context context) {
            int i10;
            if (obj == null) {
                i10 = this.f3801i;
            } else {
                i10 = ((Double) obj).intValue();
            }
            return Integer.valueOf(i10);
        }

        public k(h7.b bVar, Method method, int i10, int i11) {
            super(bVar, "number", method, i10);
            this.f3801i = i11;
        }
    }

    static abstract class m {

        /* renamed from: e  reason: collision with root package name */
        private static final ThreadLocal f3802e = k2.e(2);

        /* renamed from: f  reason: collision with root package name */
        private static final ThreadLocal f3803f = k2.e(3);

        /* renamed from: g  reason: collision with root package name */
        private static final ThreadLocal f3804g = k2.e(1);

        /* renamed from: h  reason: collision with root package name */
        private static final ThreadLocal f3805h = k2.e(2);

        /* renamed from: a  reason: collision with root package name */
        protected final String f3806a;

        /* renamed from: b  reason: collision with root package name */
        protected final String f3807b;

        /* renamed from: c  reason: collision with root package name */
        protected final Method f3808c;

        /* renamed from: d  reason: collision with root package name */
        protected final Integer f3809d;

        public String a() {
            return this.f3806a;
        }

        public String b() {
            return this.f3807b;
        }

        /* access modifiers changed from: protected */
        public abstract Object c(Object obj, Context context);

        public void d(t0 t0Var, Object obj) {
            Object[] objArr;
            try {
                if (this.f3809d == null) {
                    objArr = (Object[]) f3804g.get();
                    objArr[0] = c(obj, t0Var.F());
                } else {
                    objArr = (Object[]) f3805h.get();
                    objArr[0] = this.f3809d;
                    objArr[1] = c(obj, t0Var.F());
                }
                this.f3808c.invoke(t0Var, objArr);
                Arrays.fill(objArr, (Object) null);
            } catch (Throwable th) {
                z2.a.g(ViewManager.class, "Error while updating prop " + this.f3806a, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.f3806a + "' in shadow node of type: " + t0Var.M(), th);
            }
        }

        public void e(ViewManager viewManager, View view, Object obj) {
            Object[] objArr;
            try {
                if (this.f3809d == null) {
                    objArr = (Object[]) f3802e.get();
                    objArr[0] = view;
                    objArr[1] = c(obj, view.getContext());
                } else {
                    objArr = (Object[]) f3803f.get();
                    objArr[0] = view;
                    objArr[1] = this.f3809d;
                    objArr[2] = c(obj, view.getContext());
                }
                this.f3808c.invoke(viewManager, objArr);
                Arrays.fill(objArr, (Object) null);
            } catch (Throwable th) {
                z2.a.g(ViewManager.class, "Error while updating prop " + this.f3806a, th);
                throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.f3806a + "' of a view managed by: " + viewManager.getName(), th);
            }
        }

        private m(h7.a aVar, String str, Method method) {
            this.f3806a = aVar.name();
            this.f3807b = !"__default_type__".equals(aVar.customType()) ? aVar.customType() : str;
            this.f3808c = method;
            this.f3809d = null;
        }

        private m(h7.b bVar, String str, Method method, int i10) {
            this.f3806a = bVar.names()[i10];
            this.f3807b = !"__default_type__".equals(bVar.customType()) ? bVar.customType() : str;
            this.f3808c = method;
            this.f3809d = Integer.valueOf(i10);
        }
    }
}

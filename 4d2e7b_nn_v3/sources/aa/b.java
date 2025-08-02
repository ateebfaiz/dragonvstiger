package aa;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;
import okhttp3.HttpUrl;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final Type[] f2258a = new Type[0];

    private static final class a implements GenericArrayType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f2259a;

        public a(Type type) {
            Objects.requireNonNull(type);
            this.f2259a = b.b(type);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType) || !b.f(this, (GenericArrayType) obj)) {
                return false;
            }
            return true;
        }

        public Type getGenericComponentType() {
            return this.f2259a;
        }

        public int hashCode() {
            return this.f2259a.hashCode();
        }

        public String toString() {
            return b.t(this.f2259a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* renamed from: aa.b$b  reason: collision with other inner class name */
    private static final class C0039b implements ParameterizedType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f2260a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f2261b;

        /* renamed from: c  reason: collision with root package name */
        private final Type[] f2262c;

        public C0039b(Type type, Type type2, Type... typeArr) {
            Type type3;
            boolean z10;
            Objects.requireNonNull(type2);
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z11 = true;
                if (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (type == null && !z10) {
                    z11 = false;
                }
                a.a(z11);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = b.b(type);
            }
            this.f2260a = type3;
            this.f2261b = b.b(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.f2262c = typeArr2;
            int length = typeArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                Objects.requireNonNull(this.f2262c[i10]);
                b.c(this.f2262c[i10]);
                Type[] typeArr3 = this.f2262c;
                typeArr3[i10] = b.b(typeArr3[i10]);
            }
        }

        private static int a(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType) || !b.f(this, (ParameterizedType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f2262c.clone();
        }

        public Type getOwnerType() {
            return this.f2260a;
        }

        public Type getRawType() {
            return this.f2261b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f2262c) ^ this.f2261b.hashCode()) ^ a(this.f2260a);
        }

        public String toString() {
            int length = this.f2262c.length;
            if (length == 0) {
                return b.t(this.f2261b);
            }
            StringBuilder sb2 = new StringBuilder((length + 1) * 30);
            sb2.append(b.t(this.f2261b));
            sb2.append("<");
            sb2.append(b.t(this.f2262c[0]));
            for (int i10 = 1; i10 < length; i10++) {
                sb2.append(", ");
                sb2.append(b.t(this.f2262c[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    private static final class c implements WildcardType, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Type f2263a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f2264b;

        public c(Type[] typeArr, Type[] typeArr2) {
            boolean z10;
            boolean z11;
            boolean z12 = true;
            if (typeArr2.length <= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            a.a(z10);
            if (typeArr.length == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            a.a(z11);
            if (typeArr2.length == 1) {
                Objects.requireNonNull(typeArr2[0]);
                b.c(typeArr2[0]);
                Class<Object> cls = Object.class;
                a.a(typeArr[0] != cls ? false : z12);
                this.f2264b = b.b(typeArr2[0]);
                this.f2263a = cls;
                return;
            }
            Objects.requireNonNull(typeArr[0]);
            b.c(typeArr[0]);
            this.f2264b = null;
            this.f2263a = b.b(typeArr[0]);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType) || !b.f(this, (WildcardType) obj)) {
                return false;
            }
            return true;
        }

        public Type[] getLowerBounds() {
            Type type = this.f2264b;
            if (type == null) {
                return b.f2258a;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f2263a};
        }

        public int hashCode() {
            int i10;
            Type type = this.f2264b;
            if (type != null) {
                i10 = type.hashCode() + 31;
            } else {
                i10 = 1;
            }
            return i10 ^ (this.f2263a.hashCode() + 31);
        }

        public String toString() {
            if (this.f2264b != null) {
                return "? super " + b.t(this.f2264b);
            } else if (this.f2263a == Object.class) {
                return "?";
            } else {
                return "? extends " + b.t(this.f2263a);
            }
        }
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static Type b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new a(b(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0039b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    static void c(Type type) {
        boolean z10;
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a(z10);
    }

    private static Class d(TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    private static boolean e(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static boolean f(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!e(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return f(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return false;
            }
            return true;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                return false;
            }
            return true;
        }
    }

    public static Type g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type h(Type type, Class cls) {
        Type l10 = l(type, cls, Collection.class);
        if (l10 instanceof ParameterizedType) {
            return ((ParameterizedType) l10).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    private static Type i(Type type, Class<? super Object> cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class cls3 = interfaces[i10];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return i(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return i(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type[] j(Type type, Class cls) {
        if (type == Properties.class) {
            Class<String> cls2 = String.class;
            return new Type[]{cls2, cls2};
        }
        Type l10 = l(type, cls, Map.class);
        if (l10 instanceof ParameterizedType) {
            return ((ParameterizedType) l10).getActualTypeArguments();
        }
        Class<Object> cls3 = Object.class;
        return new Type[]{cls3, cls3};
    }

    public static Class k(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            a.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(k(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return k(((WildcardType) type).getUpperBounds()[0]);
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
        }
    }

    private static Type l(Type type, Class cls, Class cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        a.a(cls2.isAssignableFrom(cls));
        return o(type, cls, i(type, cls, cls2));
    }

    private static int m(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType n(Type type, Type type2, Type... typeArr) {
        return new C0039b(type, type2, typeArr);
    }

    public static Type o(Type type, Class cls, Type type2) {
        return p(type, cls, type2, new HashMap());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: java.lang.reflect.ParameterizedType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: java.lang.reflect.GenericArrayType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type p(java.lang.reflect.Type r9, java.lang.Class r10, java.lang.reflect.Type r11, java.util.Map r12) {
        /*
            r0 = 0
        L_0x0001:
            boolean r1 = r11 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L_0x0027
            r1 = r11
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1
            java.lang.Object r2 = r12.get(r1)
            java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
            if (r2 == 0) goto L_0x0017
            java.lang.Class r9 = java.lang.Void.TYPE
            if (r2 != r9) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r11 = r2
        L_0x0016:
            return r11
        L_0x0017:
            java.lang.Class r11 = java.lang.Void.TYPE
            r12.put(r1, r11)
            if (r0 != 0) goto L_0x001f
            r0 = r1
        L_0x001f:
            java.lang.reflect.Type r11 = q(r9, r10, r1)
            if (r11 != r1) goto L_0x0001
            goto L_0x00df
        L_0x0027:
            boolean r1 = r11 instanceof java.lang.Class
            if (r1 == 0) goto L_0x004c
            r1 = r11
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r2 = r1.isArray()
            if (r2 == 0) goto L_0x004c
            java.lang.Class r11 = r1.getComponentType()
            java.lang.reflect.Type r9 = p(r9, r10, r11, r12)
            boolean r10 = e(r11, r9)
            if (r10 == 0) goto L_0x0045
            r11 = r1
            goto L_0x00df
        L_0x0045:
            java.lang.reflect.GenericArrayType r9 = a(r9)
        L_0x0049:
            r11 = r9
            goto L_0x00df
        L_0x004c:
            boolean r1 = r11 instanceof java.lang.reflect.GenericArrayType
            if (r1 == 0) goto L_0x0067
            java.lang.reflect.GenericArrayType r11 = (java.lang.reflect.GenericArrayType) r11
            java.lang.reflect.Type r1 = r11.getGenericComponentType()
            java.lang.reflect.Type r9 = p(r9, r10, r1, r12)
            boolean r10 = e(r1, r9)
            if (r10 == 0) goto L_0x0062
            goto L_0x00df
        L_0x0062:
            java.lang.reflect.GenericArrayType r9 = a(r9)
            goto L_0x0049
        L_0x0067:
            boolean r1 = r11 instanceof java.lang.reflect.ParameterizedType
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x00ab
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r1 = r11.getOwnerType()
            java.lang.reflect.Type r4 = p(r9, r10, r1, r12)
            boolean r1 = e(r4, r1)
            r1 = r1 ^ r3
            java.lang.reflect.Type[] r5 = r11.getActualTypeArguments()
            int r6 = r5.length
        L_0x0081:
            if (r2 >= r6) goto L_0x00a0
            r7 = r5[r2]
            java.lang.reflect.Type r7 = p(r9, r10, r7, r12)
            r8 = r5[r2]
            boolean r8 = e(r7, r8)
            if (r8 != 0) goto L_0x009d
            if (r1 != 0) goto L_0x009b
            java.lang.Object r1 = r5.clone()
            r5 = r1
            java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
            r1 = r3
        L_0x009b:
            r5[r2] = r7
        L_0x009d:
            int r2 = r2 + 1
            goto L_0x0081
        L_0x00a0:
            if (r1 == 0) goto L_0x00df
            java.lang.reflect.Type r9 = r11.getRawType()
            java.lang.reflect.ParameterizedType r9 = n(r4, r9, r5)
            goto L_0x0049
        L_0x00ab:
            boolean r1 = r11 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L_0x00df
            java.lang.reflect.WildcardType r11 = (java.lang.reflect.WildcardType) r11
            java.lang.reflect.Type[] r1 = r11.getLowerBounds()
            java.lang.reflect.Type[] r4 = r11.getUpperBounds()
            int r5 = r1.length
            if (r5 != r3) goto L_0x00cb
            r3 = r1[r2]
            java.lang.reflect.Type r9 = p(r9, r10, r3, r12)
            r10 = r1[r2]
            if (r9 == r10) goto L_0x00df
            java.lang.reflect.WildcardType r11 = s(r9)
            goto L_0x00df
        L_0x00cb:
            int r1 = r4.length
            if (r1 != r3) goto L_0x00df
            r1 = r4[r2]
            java.lang.reflect.Type r9 = p(r9, r10, r1, r12)     // Catch:{ all -> 0x00dd }
            r10 = r4[r2]
            if (r9 == r10) goto L_0x00df
            java.lang.reflect.WildcardType r11 = r(r9)
            goto L_0x00df
        L_0x00dd:
            r9 = move-exception
            throw r9
        L_0x00df:
            if (r0 == 0) goto L_0x00e4
            r12.put(r0, r11)
        L_0x00e4:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.b.p(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Map):java.lang.reflect.Type");
    }

    private static Type q(Type type, Class cls, TypeVariable typeVariable) {
        Class d10 = d(typeVariable);
        if (d10 == null) {
            return typeVariable;
        }
        Type i10 = i(type, cls, d10);
        if (!(i10 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) i10).getActualTypeArguments()[m(d10.getTypeParameters(), typeVariable)];
    }

    public static WildcardType r(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getUpperBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(typeArr, f2258a);
    }

    public static WildcardType s(Type type) {
        Type[] typeArr;
        if (type instanceof WildcardType) {
            typeArr = ((WildcardType) type).getLowerBounds();
        } else {
            typeArr = new Type[]{type};
        }
        return new c(new Type[]{Object.class}, typeArr);
    }

    public static String t(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}

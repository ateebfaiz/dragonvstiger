package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, b> boundFields;

        Adapter(Map<String, b> map) {
            this.boundFields = map;
        }

        /* access modifiers changed from: package-private */
        public abstract A createAccumulator();

        /* access modifiers changed from: package-private */
        public abstract T finalize(A a10);

        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object createAccumulator = createAccumulator();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    b bVar = this.boundFields.get(jsonReader.nextName());
                    if (bVar != null) {
                        if (bVar.f9418e) {
                            readField(createAccumulator, jsonReader, bVar);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return finalize(createAccumulator);
            } catch (IllegalStateException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            } catch (IllegalAccessException e11) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e11);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void readField(A a10, JsonReader jsonReader, b bVar) throws IllegalAccessException, IOException;

        public void write(JsonWriter jsonWriter, T t10) throws IOException {
            if (t10 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (b c10 : this.boundFields.values()) {
                    c10.c(jsonWriter, t10);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            }
        }
    }

    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f9405f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Method f9406g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f9407h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9408i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Gson f9409j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ TypeToken f9410k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f9411l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f9412m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f9405f = z12;
            this.f9406g = method;
            this.f9407h = z13;
            this.f9408i = typeAdapter;
            this.f9409j = gson;
            this.f9410k = typeToken;
            this.f9411l = z14;
            this.f9412m = z15;
        }

        /* access modifiers changed from: package-private */
        public void a(JsonReader jsonReader, int i10, Object[] objArr) {
            Object read = this.f9408i.read(jsonReader);
            if (read != null || !this.f9411l) {
                objArr[i10] = read;
                return;
            }
            throw new JsonParseException("null is not allowed as value for record component '" + this.f9416c + "' of primitive type; at path " + jsonReader.getPath());
        }

        /* access modifiers changed from: package-private */
        public void b(JsonReader jsonReader, Object obj) {
            Object read = this.f9408i.read(jsonReader);
            if (read != null || !this.f9411l) {
                if (this.f9405f) {
                    ReflectiveTypeAdapterFactory.checkAccessible(obj, this.f9415b);
                } else if (this.f9412m) {
                    String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(this.f9415b, false);
                    throw new JsonIOException("Cannot set value of 'static final' " + accessibleObjectDescription);
                }
                this.f9415b.set(obj, read);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(JsonWriter jsonWriter, Object obj) {
            Object obj2;
            TypeAdapter typeAdapter;
            if (this.f9417d) {
                if (this.f9405f) {
                    Method method = this.f9406g;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, this.f9415b);
                    } else {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, method);
                    }
                }
                Method method2 = this.f9406g;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, (Object[]) null);
                    } catch (InvocationTargetException e10) {
                        String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(this.f9406g, false);
                        throw new JsonIOException("Accessor " + accessibleObjectDescription + " threw exception", e10.getCause());
                    }
                } else {
                    obj2 = this.f9415b.get(obj);
                }
                if (obj2 != obj) {
                    jsonWriter.name(this.f9414a);
                    if (this.f9407h) {
                        typeAdapter = this.f9408i;
                    } else {
                        typeAdapter = new a(this.f9409j, this.f9408i, this.f9410k.getType());
                    }
                    typeAdapter.write(jsonWriter, obj2);
                }
            }
        }
    }

    static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String f9414a;

        /* renamed from: b  reason: collision with root package name */
        final Field f9415b;

        /* renamed from: c  reason: collision with root package name */
        final String f9416c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f9417d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f9418e;

        protected b(String str, Field field, boolean z10, boolean z11) {
            this.f9414a = str;
            this.f9415b = field;
            this.f9416c = field.getName();
            this.f9417d = z10;
            this.f9418e = z11;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(JsonReader jsonReader, int i10, Object[] objArr);

        /* access modifiers changed from: package-private */
        public abstract void b(JsonReader jsonReader, Object obj);

        /* access modifiers changed from: package-private */
        public abstract void c(JsonWriter jsonWriter, Object obj);
    }

    private static final class c extends Adapter {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectConstructor f9419a;

        c(ObjectConstructor objectConstructor, Map map) {
            super(map);
            this.f9419a = objectConstructor;
        }

        /* access modifiers changed from: package-private */
        public Object createAccumulator() {
            return this.f9419a.construct();
        }

        /* access modifiers changed from: package-private */
        public Object finalize(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void readField(Object obj, JsonReader jsonReader, b bVar) {
            bVar.b(jsonReader, obj);
        }
    }

    private static final class d extends Adapter {

        /* renamed from: d  reason: collision with root package name */
        static final Map f9420d = c();

        /* renamed from: a  reason: collision with root package name */
        private final Constructor f9421a;

        /* renamed from: b  reason: collision with root package name */
        private final Object[] f9422b;

        /* renamed from: c  reason: collision with root package name */
        private final Map f9423c = new HashMap();

        d(Class cls, Map map, boolean z10) {
            super(map);
            Constructor canonicalRecordConstructor = ReflectionHelper.getCanonicalRecordConstructor(cls);
            this.f9421a = canonicalRecordConstructor;
            if (z10) {
                ReflectiveTypeAdapterFactory.checkAccessible((Object) null, canonicalRecordConstructor);
            } else {
                ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            }
            String[] recordComponentNames = ReflectionHelper.getRecordComponentNames(cls);
            for (int i10 = 0; i10 < recordComponentNames.length; i10++) {
                this.f9423c.put(recordComponentNames[i10], Integer.valueOf(i10));
            }
            Class[] parameterTypes = this.f9421a.getParameterTypes();
            this.f9422b = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f9422b[i11] = f9420d.get(parameterTypes[i11]);
            }
        }

        private static Map c() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Object[] createAccumulator() {
            return (Object[]) this.f9422b.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Object finalize(Object[] objArr) {
            try {
                return this.f9421a.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f9421a) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this.f9421a) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void readField(Object[] objArr, JsonReader jsonReader, b bVar) {
            Integer num = (Integer) this.f9423c.get(bVar.f9416c);
            if (num != null) {
                bVar.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.f9421a) + "' for field with name '" + bVar.f9416c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    /* access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void checkAccessible(Object obj, M m10) {
        if (Modifier.isStatic(((Member) m10).getModifiers())) {
            obj = null;
        }
        if (!ReflectionAccessFilterHelper.canAccess(m10, obj)) {
            String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(m10, true);
            throw new JsonIOException(accessibleObjectDescription + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private b createBoundField(Gson gson, Field field, Method method, String str, TypeToken<?> typeToken, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        TypeAdapter<?> typeAdapter;
        boolean z14;
        Gson gson2 = gson;
        TypeToken<?> typeToken2 = typeToken;
        boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        int modifiers = field.getModifiers();
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z13 = false;
        } else {
            z13 = true;
        }
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) {
            typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson2, typeToken2, jsonAdapter);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (typeAdapter == null) {
            typeAdapter = gson2.getAdapter(typeToken2);
        }
        return new a(str, field, z10, z11, z12, method, z14, typeAdapter, gson, typeToken, isPrimitive, z13);
    }

    private Map<String, b> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        int i10;
        int i11;
        Method method;
        boolean z13;
        boolean z14;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken<?> typeToken2 = typeToken;
        boolean z15 = z10;
        Class<? super Object> cls3 = cls2;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            boolean z16 = true;
            boolean z17 = false;
            if (cls3 != cls2 && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.reflectionFilters, cls3);
                if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls3 + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                } else if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                    z15 = true;
                } else {
                    z15 = false;
                }
            }
            boolean z18 = z15;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean includeField = reflectiveTypeAdapterFactory.includeField(field, z16);
                boolean includeField2 = reflectiveTypeAdapterFactory.includeField(field, z17);
                if (includeField || includeField2) {
                    b bVar = null;
                    if (!z11) {
                        z13 = includeField2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z13 = z17;
                    } else {
                        Method accessor = ReflectionHelper.getAccessor(cls3, field);
                        if (!z18) {
                            ReflectionHelper.makeAccessible(accessor);
                        }
                        Class cls4 = SerializedName.class;
                        if (accessor.getAnnotation(cls4) == null || field.getAnnotation(cls4) != null) {
                            z13 = includeField2;
                            method = accessor;
                        } else {
                            throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(accessor, z17) + " is not supported");
                        }
                    }
                    if (!z18 && method == null) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls3, field.getGenericType());
                    List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                    int size = fieldNames.size();
                    int i13 = z17;
                    while (i13 < size) {
                        String str = fieldNames.get(i13);
                        if (i13 != 0) {
                            z14 = z17;
                        } else {
                            z14 = includeField;
                        }
                        int i14 = i13;
                        b bVar2 = bVar;
                        int i15 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i16 = i12;
                        int i17 = length;
                        boolean z19 = z17;
                        b bVar3 = (b) linkedHashMap.put(str, createBoundField(gson, field, method, str, TypeToken.get(resolve), z14, z13, z18));
                        if (bVar2 == null) {
                            bVar = bVar3;
                        } else {
                            bVar = bVar2;
                        }
                        i13 = i14 + 1;
                        includeField = z14;
                        i12 = i16;
                        size = i15;
                        fieldNames = list;
                        field = field2;
                        length = i17;
                        z17 = z19;
                    }
                    b bVar4 = bVar;
                    Field field3 = field;
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                    if (bVar4 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + bVar4.f9414a + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(bVar4.f9415b) + " and " + ReflectionHelper.fieldToString(field3));
                    }
                } else {
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                }
                i12 = i11 + 1;
                z16 = true;
                reflectiveTypeAdapterFactory = this;
                length = i10;
                z17 = z12;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls3, cls3.getGenericSuperclass()));
            cls3 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            z15 = z18;
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean includeField(Field field, boolean z10) {
        if (this.excluder.excludeClass(field.getType(), z10) || this.excluder.excludeField(field, z10)) {
            return false;
        }
        return true;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z10;
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        if (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z11 = z10;
            if (ReflectionHelper.isRecord(rawType)) {
                return new d(rawType, getBoundFields(gson, typeToken, rawType, z11, true), z11);
            }
            return new c(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, z11, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}

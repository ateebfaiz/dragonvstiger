package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final String DEFAULT_DATE_PATTERN = null;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    class a extends TypeAdapter {
        a() {
        }

        /* renamed from: a */
        public Double read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            double doubleValue = number.doubleValue();
            Gson.checkValidFloatingPoint(doubleValue);
            jsonWriter.value(doubleValue);
        }
    }

    class b extends TypeAdapter {
        b() {
        }

        /* renamed from: a */
        public Float read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            float floatValue = number.floatValue();
            Gson.checkValidFloatingPoint((double) floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            jsonWriter.value(number);
        }
    }

    class c extends TypeAdapter {
        c() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    class d extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9331a;

        d(TypeAdapter typeAdapter) {
            this.f9331a = typeAdapter;
        }

        /* renamed from: a */
        public AtomicLong read(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f9331a.read(jsonReader)).longValue());
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f9331a.write(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9332a;

        e(TypeAdapter typeAdapter) {
            this.f9332a = typeAdapter;
        }

        /* renamed from: a */
        public AtomicLongArray read(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f9332a.read(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f9332a.write(jsonWriter, Long.valueOf(atomicLongArray.get(i10)));
            }
            jsonWriter.endArray();
        }
    }

    static class f extends SerializationDelegatingTypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private TypeAdapter f9333a = null;

        f() {
        }

        private TypeAdapter delegate() {
            TypeAdapter typeAdapter = this.f9333a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void a(TypeAdapter typeAdapter) {
            if (this.f9333a == null) {
                this.f9333a = typeAdapter;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }

        public TypeAdapter getSerializationDelegate() {
            return delegate();
        }

        public Object read(JsonReader jsonReader) {
            return delegate().read(jsonReader);
        }

        public void write(JsonWriter jsonWriter, Object obj) {
            delegate().write(jsonWriter, obj);
        }
    }

    public Gson() {
        this(Excluder.DEFAULT, DEFAULT_FIELD_NAMING_STRATEGY, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, DEFAULT_DATE_PATTERN, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DEFAULT_OBJECT_TO_NUMBER_STRATEGY, DEFAULT_NUMBER_TO_NUMBER_STRATEGY, Collections.emptyList());
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            } catch (IOException e11) {
                throw new JsonIOException((Throwable) e11);
            }
        }
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(TypeAdapter<Number> typeAdapter) {
        return new d(typeAdapter).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(TypeAdapter<Number> typeAdapter) {
        return new e(typeAdapter).nullSafe();
    }

    static void checkValidFloatingPoint(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z10) {
        if (z10) {
            return TypeAdapters.DOUBLE;
        }
        return new a();
    }

    private TypeAdapter<Number> floatAdapter(boolean z10) {
        if (z10) {
            return TypeAdapters.FLOAT;
        }
        return new b();
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy2) {
        if (longSerializationPolicy2 == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new c();
    }

    @Deprecated
    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return Primitives.wrap(cls).cast(fromJson(str, TypeToken.get(cls)));
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z10;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter<T> typeAdapter = this.typeTokenCache.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = this.threadLocalAdapterResults.get();
        if (map == null) {
            map = new HashMap();
            this.threadLocalAdapterResults.set(map);
            z10 = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z10 = false;
        }
        try {
            f fVar = new f();
            map.put(typeToken, fVar);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            TypeAdapter<T> typeAdapter3 = null;
            while (true) {
                if (it.hasNext()) {
                    typeAdapter3 = it.next().create(this, typeToken);
                    if (typeAdapter3 != null) {
                        fVar.a(typeAdapter3);
                        map.put(typeToken, typeAdapter3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (typeAdapter3 != null) {
                if (z10) {
                    this.typeTokenCache.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } finally {
            if (z10) {
                this.threadLocalAdapterResults.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z10 = false;
        for (TypeAdapterFactory next : this.factories) {
            if (z10) {
                TypeAdapter<T> create = next.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (next == typeAdapterFactory) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setHtmlSafe(this.htmlSafe);
        jsonWriter.setLenient(this.lenient);
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, (Type) obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        return fromJson(str, TypeToken.get(type));
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, (JsonWriter) jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public <T> T fromJson(String str, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return fromJson((Reader) new StringReader(str), typeToken);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        return Primitives.wrap(cls).cast(fromJson(reader, TypeToken.get(cls)));
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, (Type) obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    Gson(Excluder excluder2, FieldNamingStrategy fieldNamingStrategy2, Map<Type, InstanceCreator<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, LongSerializationPolicy longSerializationPolicy2, String str, int i10, int i11, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3, ToNumberStrategy toNumberStrategy, ToNumberStrategy toNumberStrategy2, List<ReflectionAccessFilter> list4) {
        Map<Type, InstanceCreator<?>> map2 = map;
        boolean z18 = z11;
        boolean z19 = z16;
        boolean z20 = z17;
        List<ReflectionAccessFilter> list5 = list4;
        this.threadLocalAdapterResults = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = excluder2;
        this.fieldNamingStrategy = fieldNamingStrategy2;
        this.instanceCreators = map2;
        ConstructorConstructor constructorConstructor2 = new ConstructorConstructor(map2, z20, list5);
        this.constructorConstructor = constructorConstructor2;
        this.serializeNulls = z10;
        this.complexMapKeySerialization = z18;
        this.generateNonExecutableJson = z12;
        this.htmlSafe = z13;
        this.prettyPrinting = z14;
        this.lenient = z15;
        this.serializeSpecialFloatingPointValues = z19;
        this.useJdkUnsafe = z20;
        this.longSerializationPolicy = longSerializationPolicy2;
        this.datePattern = str;
        this.dateStyle = i10;
        this.timeStyle = i11;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        this.objectToNumberStrategy = toNumberStrategy;
        this.numberToNumberStrategy = toNumberStrategy2;
        this.reflectionFilters = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.getFactory(toNumberStrategy));
        arrayList.add(excluder2);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy2);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z19)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z19)));
        arrayList.add(NumberTypeAdapter.getFactory(toNumberStrategy2));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(SqlTypesSupport.TIME_FACTORY);
            arrayList.add(SqlTypesSupport.DATE_FACTORY);
            arrayList.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor2));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor2, z18));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor2);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor2, fieldNamingStrategy2, excluder2, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        return fromJson(reader, TypeToken.get(type));
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        }
    }

    public <T> T fromJson(Reader reader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        JsonReader newJsonReader = newJsonReader(reader);
        T fromJson = fromJson(newJsonReader, typeToken);
        assertFullConsumption(fromJson, newJsonReader);
        return fromJson;
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter<?> adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls2 = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            adapter.write(jsonWriter, obj);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls2);
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls2);
            throw th;
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        return fromJson(jsonReader, TypeToken.get(type));
    }

    public <T> T fromJson(JsonReader jsonReader, TypeToken<T> typeToken) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            jsonReader.peek();
            T read = getAdapter(typeToken).read(jsonReader);
            jsonReader.setLenient(isLenient);
            return read;
        } catch (EOFException e10) {
            if (1 != 0) {
                jsonReader.setLenient(isLenient);
                return null;
            }
            throw new JsonSyntaxException((Throwable) e10);
        } catch (IllegalStateException e11) {
            throw new JsonSyntaxException((Throwable) e11);
        } catch (IOException e12) {
            throw new JsonSyntaxException((Throwable) e12);
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e13.getMessage(), e13);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get(cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return Primitives.wrap(cls).cast(fromJson(jsonElement, TypeToken.get(cls)));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return fromJson(jsonElement, TypeToken.get(type));
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(JsonElement jsonElement, TypeToken<T> typeToken) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return fromJson((JsonReader) new JsonTreeReader(jsonElement), typeToken);
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls2 = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(jsonElement, jsonWriter);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls2);
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls2);
            throw th;
        }
    }
}

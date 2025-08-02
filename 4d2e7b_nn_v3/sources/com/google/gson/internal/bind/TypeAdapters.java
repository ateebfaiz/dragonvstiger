package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = new g();
    public static final TypeAdapter<BigInteger> BIG_INTEGER = new h();
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = new d0();
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE = new d();
    public static final TypeAdapterFactory ENUM_FACTORY = new u();
    public static final TypeAdapter<Number> FLOAT = new c();
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER = new i();
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG = new b();
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    class a extends TypeAdapter {
        a() {
        }

        /* renamed from: a */
        public AtomicIntegerArray read(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException((Throwable) e10);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value((long) atomicIntegerArray.get(i10));
            }
            jsonWriter.endArray();
        }
    }

    class a0 implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f9430a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9431b;

        class a extends TypeAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f9432a;

            a(Class cls) {
                this.f9432a = cls;
            }

            public Object read(JsonReader jsonReader) {
                Object read = a0.this.f9431b.read(jsonReader);
                if (read == null || this.f9432a.isInstance(read)) {
                    return read;
                }
                throw new JsonSyntaxException("Expected a " + this.f9432a.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
            }

            public void write(JsonWriter jsonWriter, Object obj) {
                a0.this.f9431b.write(jsonWriter, obj);
            }
        }

        a0(Class cls, TypeAdapter typeAdapter) {
            this.f9430a = cls;
            this.f9431b = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (!this.f9430a.isAssignableFrom(rawType)) {
                return null;
            }
            return new a(rawType);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f9430a.getName() + ",adapter=" + this.f9431b + "]";
        }
    }

    class b extends TypeAdapter {
        b() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    }

    static /* synthetic */ class b0 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9434a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9434a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9434a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9434a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9434a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9434a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9434a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.b0.<clinit>():void");
        }
    }

    class c extends TypeAdapter {
        c() {
        }

        public Number read(JsonReader jsonReader) {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            jsonWriter.value(number);
        }
    }

    class c0 extends TypeAdapter {
        c0() {
        }

        /* renamed from: a */
        public Boolean read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool);
        }
    }

    class d extends TypeAdapter {
        d() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.doubleValue());
            }
        }
    }

    class d0 extends TypeAdapter {
        d0() {
        }

        /* renamed from: a */
        public Boolean read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Boolean bool) {
            String str;
            if (bool == null) {
                str = "null";
            } else {
                str = bool.toString();
            }
            jsonWriter.value(str);
        }
    }

    class e extends TypeAdapter {
        e() {
        }

        /* renamed from: a */
        public Character read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + nextString + "; at " + jsonReader.getPreviousPath());
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Character ch) {
            String str;
            if (ch == null) {
                str = null;
            } else {
                str = String.valueOf(ch);
            }
            jsonWriter.value(str);
        }
    }

    class e0 extends TypeAdapter {
        e0() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 255 && nextInt >= -128) {
                    return Byte.valueOf((byte) nextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + nextInt + " to byte; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.byteValue());
            }
        }
    }

    class f extends TypeAdapter {
        f() {
        }

        /* renamed from: a */
        public String read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, String str) {
            jsonWriter.value(str);
        }
    }

    class f0 extends TypeAdapter {
        f0() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 65535 && nextInt >= -32768) {
                    return Short.valueOf((short) nextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + nextInt + " to short; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.shortValue());
            }
        }
    }

    class g extends TypeAdapter {
        g() {
        }

        /* renamed from: a */
        public BigDecimal read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.value((Number) bigDecimal);
        }
    }

    class g0 extends TypeAdapter {
        g0() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.intValue());
            }
        }
    }

    class h extends TypeAdapter {
        h() {
        }

        /* renamed from: a */
        public BigInteger read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigInteger(nextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) {
            jsonWriter.value((Number) bigInteger);
        }
    }

    class h0 extends TypeAdapter {
        h0() {
        }

        /* renamed from: a */
        public AtomicInteger read(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
            jsonWriter.value((long) atomicInteger.get());
        }
    }

    class i extends TypeAdapter {
        i() {
        }

        /* renamed from: a */
        public LazilyParsedNumber read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) {
            jsonWriter.value((Number) lazilyParsedNumber);
        }
    }

    class i0 extends TypeAdapter {
        i0() {
        }

        /* renamed from: a */
        public AtomicBoolean read(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    class j extends TypeAdapter {
        j() {
        }

        /* renamed from: a */
        public StringBuilder read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, StringBuilder sb2) {
            String str;
            if (sb2 == null) {
                str = null;
            } else {
                str = sb2.toString();
            }
            jsonWriter.value(str);
        }
    }

    private static final class j0 extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Map f9435a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f9436b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map f9437c = new HashMap();

        class a implements PrivilegedAction {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f9438a;

            a(Class cls) {
                this.f9438a = cls;
            }

            /* renamed from: a */
            public Field[] run() {
                Field[] declaredFields = this.f9438a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum enumR = (Enum) field.get((Object) null);
                    String name = enumR.name();
                    String str = enumR.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                        for (String put : serializedName.alternate()) {
                            this.f9435a.put(put, enumR);
                        }
                    }
                    this.f9435a.put(name, enumR);
                    this.f9436b.put(str, enumR);
                    this.f9437c.put(enumR, name);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        /* renamed from: a */
        public Enum read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            Enum enumR = (Enum) this.f9435a.get(nextString);
            if (enumR == null) {
                return (Enum) this.f9436b.get(nextString);
            }
            return enumR;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Enum enumR) {
            String str;
            if (enumR == null) {
                str = null;
            } else {
                str = (String) this.f9437c.get(enumR);
            }
            jsonWriter.value(str);
        }
    }

    class k extends TypeAdapter {
        k() {
        }

        /* renamed from: a */
        public Class read(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends TypeAdapter {
        l() {
        }

        /* renamed from: a */
        public StringBuffer read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) {
            String str;
            if (stringBuffer == null) {
                str = null;
            } else {
                str = stringBuffer.toString();
            }
            jsonWriter.value(str);
        }
    }

    class m extends TypeAdapter {
        m() {
        }

        /* renamed from: a */
        public URL read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, URL url) {
            String str;
            if (url == null) {
                str = null;
            } else {
                str = url.toExternalForm();
            }
            jsonWriter.value(str);
        }
    }

    class n extends TypeAdapter {
        n() {
        }

        /* renamed from: a */
        public URI read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e10) {
                throw new JsonIOException((Throwable) e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, URI uri) {
            String str;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toASCIIString();
            }
            jsonWriter.value(str);
        }
    }

    class o extends TypeAdapter {
        o() {
        }

        /* renamed from: a */
        public InetAddress read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) {
            String str;
            if (inetAddress == null) {
                str = null;
            } else {
                str = inetAddress.getHostAddress();
            }
            jsonWriter.value(str);
        }
    }

    class p extends TypeAdapter {
        p() {
        }

        /* renamed from: a */
        public UUID read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return UUID.fromString(nextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, UUID uuid) {
            String str;
            if (uuid == null) {
                str = null;
            } else {
                str = uuid.toString();
            }
            jsonWriter.value(str);
        }
    }

    class q extends TypeAdapter {
        q() {
        }

        /* renamed from: a */
        public Currency read(JsonReader jsonReader) {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Currency currency) {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    class r extends TypeAdapter {
        r() {
        }

        /* renamed from: a */
        public Calendar read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i10 = nextInt;
                } else if ("month".equals(nextName)) {
                    i11 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i12 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i13 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i14 = nextInt;
                } else if ("second".equals(nextName)) {
                    i15 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Calendar calendar) {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value((long) calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value((long) calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value((long) calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value((long) calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value((long) calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value((long) calendar.get(13));
            jsonWriter.endObject();
        }
    }

    class s extends TypeAdapter {
        s() {
        }

        /* renamed from: a */
        public Locale read(JsonReader jsonReader) {
            String str;
            String str2;
            String str3 = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Locale locale) {
            String str;
            if (locale == null) {
                str = null;
            } else {
                str = locale.toString();
            }
            jsonWriter.value(str);
        }
    }

    class t extends TypeAdapter {
        t() {
        }

        private JsonElement b(JsonReader jsonReader, JsonToken jsonToken) {
            int i10 = b0.f9434a[jsonToken.ordinal()];
            if (i10 == 1) {
                return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
            }
            if (i10 == 2) {
                return new JsonPrimitive(jsonReader.nextString());
            }
            if (i10 == 3) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            if (i10 == 6) {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        private JsonElement c(JsonReader jsonReader, JsonToken jsonToken) {
            int i10 = b0.f9434a[jsonToken.ordinal()];
            if (i10 == 4) {
                jsonReader.beginArray();
                return new JsonArray();
            } else if (i10 != 5) {
                return null;
            } else {
                jsonReader.beginObject();
                return new JsonObject();
            }
        }

        /* renamed from: a */
        public JsonElement read(JsonReader jsonReader) {
            String str;
            boolean z10;
            if (jsonReader instanceof JsonTreeReader) {
                return ((JsonTreeReader) jsonReader).nextJsonElement();
            }
            JsonToken peek = jsonReader.peek();
            JsonElement c10 = c(jsonReader, peek);
            if (c10 == null) {
                return b(jsonReader, peek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    if (c10 instanceof JsonObject) {
                        str = jsonReader.nextName();
                    } else {
                        str = null;
                    }
                    JsonToken peek2 = jsonReader.peek();
                    JsonElement c11 = c(jsonReader, peek2);
                    if (c11 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (c11 == null) {
                        c11 = b(jsonReader, peek2);
                    }
                    if (c10 instanceof JsonArray) {
                        ((JsonArray) c10).add(c11);
                    } else {
                        ((JsonObject) c10).add(str, c11);
                    }
                    if (z10) {
                        arrayDeque.addLast(c10);
                        c10 = c11;
                    }
                } else {
                    if (c10 instanceof JsonArray) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return c10;
                    }
                    c10 = (JsonElement) arrayDeque.removeLast();
                }
            }
        }

        /* renamed from: d */
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
            } else if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                }
            } else if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
            } else if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (Map.Entry next : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name((String) next.getKey());
                    write(jsonWriter, (JsonElement) next.getValue());
                }
                jsonWriter.endObject();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    }

    class u implements TypeAdapterFactory {
        u() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class<? super Enum> rawType = typeToken.getRawType();
            Class<Enum> cls = Enum.class;
            if (!cls.isAssignableFrom(rawType) || rawType == cls) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    class v extends TypeAdapter {
        v() {
        }

        /* renamed from: a */
        public BitSet read(JsonReader jsonReader) {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i10 = 0;
            while (peek != JsonToken.END_ARRAY) {
                int i11 = b0.f9434a[peek.ordinal()];
                boolean z10 = true;
                if (i11 == 1 || i11 == 2) {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt == 0) {
                        z10 = false;
                    } else if (nextInt != 1) {
                        throw new JsonSyntaxException("Invalid bitset value " + nextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                    }
                } else if (i11 == 3) {
                    z10 = jsonReader.nextBoolean();
                } else {
                    throw new JsonSyntaxException("Invalid bitset value type: " + peek + "; at path " + jsonReader.getPath());
                }
                if (z10) {
                    bitSet.set(i10);
                }
                i10++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, BitSet bitSet) {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(bitSet.get(i10) ? 1 : 0);
            }
            jsonWriter.endArray();
        }
    }

    class w implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TypeToken f9440a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9441b;

        w(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.f9440a = typeToken;
            this.f9441b = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.equals(this.f9440a)) {
                return this.f9441b;
            }
            return null;
        }
    }

    class x implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f9442a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9443b;

        x(Class cls, TypeAdapter typeAdapter) {
            this.f9442a = cls;
            this.f9443b = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == this.f9442a) {
                return this.f9443b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9442a.getName() + ",adapter=" + this.f9443b + "]";
        }
    }

    class y implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f9444a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f9445b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9446c;

        y(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f9444a = cls;
            this.f9445b = cls2;
            this.f9446c = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.f9444a || rawType == this.f9445b) {
                return this.f9446c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9445b.getName() + "+" + this.f9444a.getName() + ",adapter=" + this.f9446c + "]";
        }
    }

    class z implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f9447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f9448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f9449c;

        z(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f9447a = cls;
            this.f9448b = cls2;
            this.f9449c = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.f9447a || rawType == this.f9448b) {
                return this.f9449c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9447a.getName() + "+" + this.f9448b.getName() + ",adapter=" + this.f9449c + "]";
        }
    }

    static {
        TypeAdapter<Class> nullSafe = new k().nullSafe();
        CLASS = nullSafe;
        CLASS_FACTORY = newFactory(Class.class, nullSafe);
        TypeAdapter<BitSet> nullSafe2 = new v().nullSafe();
        BIT_SET = nullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, nullSafe2);
        c0 c0Var = new c0();
        BOOLEAN = c0Var;
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        BYTE = e0Var;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        SHORT = f0Var;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        INTEGER = g0Var;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, g0Var);
        TypeAdapter<AtomicInteger> nullSafe3 = new h0().nullSafe();
        ATOMIC_INTEGER = nullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, nullSafe3);
        TypeAdapter<AtomicBoolean> nullSafe4 = new i0().nullSafe();
        ATOMIC_BOOLEAN = nullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, nullSafe4);
        TypeAdapter<AtomicIntegerArray> nullSafe5 = new a().nullSafe();
        ATOMIC_INTEGER_ARRAY = nullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, nullSafe5);
        e eVar = new e();
        CHARACTER = eVar;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        STRING = fVar;
        STRING_FACTORY = newFactory(String.class, fVar);
        j jVar = new j();
        STRING_BUILDER = jVar;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, jVar);
        l lVar = new l();
        STRING_BUFFER = lVar;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, lVar);
        m mVar = new m();
        URL = mVar;
        URL_FACTORY = newFactory(URL.class, mVar);
        n nVar = new n();
        URI = nVar;
        URI_FACTORY = newFactory(URI.class, nVar);
        o oVar = new o();
        INET_ADDRESS = oVar;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, oVar);
        p pVar = new p();
        UUID = pVar;
        UUID_FACTORY = newFactory(UUID.class, pVar);
        TypeAdapter<Currency> nullSafe6 = new q().nullSafe();
        CURRENCY = nullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, nullSafe6);
        r rVar = new r();
        CALENDAR = rVar;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        LOCALE = sVar;
        LOCALE_FACTORY = newFactory(Locale.class, sVar);
        t tVar = new t();
        JSON_ELEMENT = tVar;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, tVar);
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new w(typeToken, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new z(cls, cls2, typeAdapter);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new a0(cls, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new x(cls, typeAdapter);
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new y(cls, cls2, typeAdapter);
    }
}

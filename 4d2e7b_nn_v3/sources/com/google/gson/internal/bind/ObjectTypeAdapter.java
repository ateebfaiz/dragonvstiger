package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    class a implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ToNumberStrategy f9403a;

        a(ToNumberStrategy toNumberStrategy) {
            this.f9403a = toNumberStrategy;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson, this.f9403a, (a) null);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9404a;

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
                f9404a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9404a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9404a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9404a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9404a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9404a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ObjectTypeAdapter.b.<clinit>():void");
        }
    }

    /* synthetic */ ObjectTypeAdapter(Gson gson2, ToNumberStrategy toNumberStrategy2, a aVar) {
        this(gson2, toNumberStrategy2);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy2) {
        if (toNumberStrategy2 == ToNumberPolicy.DOUBLE) {
            return DOUBLE_FACTORY;
        }
        return newFactory(toNumberStrategy2);
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy toNumberStrategy2) {
        return new a(toNumberStrategy2);
    }

    private Object readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i10 = b.f9404a[jsonToken.ordinal()];
        if (i10 == 3) {
            return jsonReader.nextString();
        }
        if (i10 == 4) {
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        if (i10 == 5) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i10 == 6) {
            jsonReader.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    private Object tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i10 = b.f9404a[jsonToken.ordinal()];
        if (i10 == 1) {
            jsonReader.beginArray();
            return new ArrayList();
        } else if (i10 != 2) {
            return null;
        } else {
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
    }

    public Object read(JsonReader jsonReader) throws IOException {
        String str;
        boolean z10;
        JsonToken peek = jsonReader.peek();
        Object tryBeginNesting = tryBeginNesting(jsonReader, peek);
        if (tryBeginNesting == null) {
            return readTerminal(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (tryBeginNesting instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Object tryBeginNesting2 = tryBeginNesting(jsonReader, peek2);
                if (tryBeginNesting2 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (tryBeginNesting2 == null) {
                    tryBeginNesting2 = readTerminal(jsonReader, peek2);
                }
                if (tryBeginNesting instanceof List) {
                    ((List) tryBeginNesting).add(tryBeginNesting2);
                } else {
                    ((Map) tryBeginNesting).put(str, tryBeginNesting2);
                }
                if (z10) {
                    arrayDeque.addLast(tryBeginNesting);
                    tryBeginNesting = tryBeginNesting2;
                }
            } else {
                if (tryBeginNesting instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return tryBeginNesting;
                }
                tryBeginNesting = arrayDeque.removeLast();
            }
        }
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter<?> adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, obj);
    }

    private ObjectTypeAdapter(Gson gson2, ToNumberStrategy toNumberStrategy2) {
        this.gson = gson2;
        this.toNumberStrategy = toNumberStrategy2;
    }
}

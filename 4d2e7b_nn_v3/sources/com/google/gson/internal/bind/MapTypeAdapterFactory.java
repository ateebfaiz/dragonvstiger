package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class a extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f9397a;

        /* renamed from: b  reason: collision with root package name */
        private final TypeAdapter f9398b;

        /* renamed from: c  reason: collision with root package name */
        private final ObjectConstructor f9399c;

        public a(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
            this.f9397a = new a(gson, typeAdapter, type);
            this.f9398b = new a(gson, typeAdapter2, type2);
            this.f9399c = objectConstructor;
        }

        private String a(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            } else if (jsonElement.isJsonNull()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: b */
        public Map read(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map map = (Map) this.f9399c.construct();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    Object read = this.f9397a.read(jsonReader);
                    if (map.put(read, this.f9398b.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    Object read2 = this.f9397a.read(jsonReader);
                    if (map.put(read2, this.f9398b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        /* renamed from: c */
        public void write(JsonWriter jsonWriter, Map map) {
            boolean z10;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                for (Map.Entry entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f9398b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i10 = 0;
                boolean z11 = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.f9397a.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    if (jsonTree.isJsonArray() || jsonTree.isJsonObject()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 |= z10;
                }
                if (z11) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i10 < size) {
                        jsonWriter.beginArray();
                        Streams.write((JsonElement) arrayList.get(i10), jsonWriter);
                        this.f9398b.write(jsonWriter, arrayList2.get(i10));
                        jsonWriter.endArray();
                        i10++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i10 < size2) {
                    jsonWriter.name(a((JsonElement) arrayList.get(i10)));
                    this.f9398b.write(jsonWriter, arrayList2.get(i10));
                    i10++;
                }
                jsonWriter.endObject();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor2, boolean z10) {
        this.constructorConstructor = constructorConstructor2;
        this.complexMapKeySerialization = z10;
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.BOOLEAN_AS_STRING;
        }
        return gson.getAdapter(TypeToken.get(type));
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, rawType);
        return new a(gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }
}

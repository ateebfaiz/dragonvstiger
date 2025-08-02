package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final TreeTypeAdapter<T>.b context;
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    private final class b implements JsonSerializationContext, JsonDeserializationContext {
        private b() {
        }

        public Object deserialize(JsonElement jsonElement, Type type) {
            return TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }

        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }
    }

    private static final class c implements TypeAdapterFactory {

        /* renamed from: a  reason: collision with root package name */
        private final TypeToken f9425a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9426b;

        /* renamed from: c  reason: collision with root package name */
        private final Class f9427c;

        /* renamed from: d  reason: collision with root package name */
        private final JsonSerializer f9428d;

        /* renamed from: e  reason: collision with root package name */
        private final JsonDeserializer f9429e;

        c(Object obj, TypeToken typeToken, boolean z10, Class cls) {
            JsonSerializer jsonSerializer;
            boolean z11;
            JsonDeserializer jsonDeserializer = null;
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.f9428d = jsonSerializer;
            jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            this.f9429e = jsonDeserializer;
            if (jsonSerializer == null && jsonDeserializer == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            C$Gson$Preconditions.checkArgument(z11);
            this.f9425a = typeToken;
            this.f9426b = z10;
            this.f9427c = cls;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            boolean z10;
            TypeToken typeToken2 = this.f9425a;
            if (typeToken2 == null) {
                z10 = this.f9427c.isAssignableFrom(typeToken.getRawType());
            } else if (typeToken2.equals(typeToken) || (this.f9426b && this.f9425a.getType() == typeToken.getRawType())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return new TreeTypeAdapter(this.f9428d, this.f9429e, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory, boolean z10) {
        this.context = new b();
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = typeAdapterFactory;
        this.nullSafe = z10;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken2, Object obj) {
        return new c(obj, typeToken2, false, (Class) null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken2, Object obj) {
        boolean z10;
        if (typeToken2.getType() == typeToken2.getRawType()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new c(obj, typeToken2, z10, (Class) null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new c(obj, (TypeToken) null, false, cls);
    }

    public TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer != null) {
            return this;
        }
        return delegate();
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (!this.nullSafe || !parse.isJsonNull()) {
            return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, T t10) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t10);
        } else if (!this.nullSafe || t10 != null) {
            Streams.write(jsonSerializer.serialize(t10, this.typeToken.getType(), this.context), jsonWriter);
        } else {
            jsonWriter.nullValue();
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson2, typeToken2, typeAdapterFactory, true);
    }
}

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class a extends TypeAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f9450a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter f9451b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f9452c;

    a(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f9450a = gson;
        this.f9451b = typeAdapter;
        this.f9452c = type;
    }

    private static Type a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean b(TypeAdapter typeAdapter) {
        TypeAdapter serializationDelegate;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (serializationDelegate = ((SerializationDelegatingTypeAdapter) typeAdapter).getSerializationDelegate()) != typeAdapter) {
            typeAdapter = serializationDelegate;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    public Object read(JsonReader jsonReader) {
        return this.f9451b.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, Object obj) {
        TypeAdapter<?> typeAdapter = this.f9451b;
        Type a10 = a(this.f9452c, obj);
        if (a10 != this.f9452c) {
            typeAdapter = this.f9450a.getAdapter(TypeToken.get(a10));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !b(this.f9451b)) {
                typeAdapter = this.f9451b;
            }
        }
        typeAdapter.write(jsonWriter, obj);
    }
}

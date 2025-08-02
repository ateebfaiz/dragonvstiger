package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    private static final class a extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f9394a;

        /* renamed from: b  reason: collision with root package name */
        private final ObjectConstructor f9395b;

        public a(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
            this.f9394a = new a(gson, typeAdapter, type);
            this.f9395b = objectConstructor;
        }

        /* renamed from: a */
        public Collection read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection collection = (Collection) this.f9395b.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f9394a.read(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        /* renamed from: b */
        public void write(JsonWriter jsonWriter, Collection collection) {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (Object write : collection) {
                this.f9394a.write(jsonWriter, write);
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new a(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
    }
}

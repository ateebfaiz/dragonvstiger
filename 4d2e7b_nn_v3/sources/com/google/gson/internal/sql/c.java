package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

class c extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f9461b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final TypeAdapter f9462a;

    class a implements TypeAdapterFactory {
        a() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Timestamp.class) {
                return new c(gson.getAdapter(Date.class), (a) null);
            }
            return null;
        }
    }

    /* synthetic */ c(TypeAdapter typeAdapter, a aVar) {
        this(typeAdapter);
    }

    /* renamed from: a */
    public Timestamp read(JsonReader jsonReader) {
        Date date = (Date) this.f9462a.read(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Timestamp timestamp) {
        this.f9462a.write(jsonWriter, timestamp);
    }

    private c(TypeAdapter typeAdapter) {
        this.f9462a = typeAdapter;
    }
}

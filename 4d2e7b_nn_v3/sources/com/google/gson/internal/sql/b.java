package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class b extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f9459b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f9460a;

    class a implements TypeAdapterFactory {
        a() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new b((a) null);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* renamed from: a */
    public Time read(JsonReader jsonReader) {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f9460a.parse(nextString).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Time; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Time time) {
        String format;
        if (time == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f9460a.format(time);
        }
        jsonWriter.value(format);
    }

    private b() {
        this.f9460a = new SimpleDateFormat("hh:mm:ss a");
    }
}

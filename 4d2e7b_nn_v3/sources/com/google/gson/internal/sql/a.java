package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class a extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final TypeAdapterFactory f9457b = new C0110a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f9458a;

    /* renamed from: com.google.gson.internal.sql.a$a  reason: collision with other inner class name */
    class C0110a implements TypeAdapterFactory {
        C0110a() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new a((C0110a) null);
            }
            return null;
        }
    }

    /* synthetic */ a(C0110a aVar) {
        this();
    }

    /* renamed from: a */
    public Date read(JsonReader jsonReader) {
        java.util.Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                parse = this.f9458a.parse(nextString);
            }
            return new Date(parse.getTime());
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    /* renamed from: b */
    public void write(JsonWriter jsonWriter, Date date) {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.f9458a.format(date);
        }
        jsonWriter.value(format);
    }

    private a() {
        this.f9458a = new SimpleDateFormat("MMM d, yyyy");
    }
}

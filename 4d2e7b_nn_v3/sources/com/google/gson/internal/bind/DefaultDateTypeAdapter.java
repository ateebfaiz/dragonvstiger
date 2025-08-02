package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = new a(Date.class);
        private final Class<T> dateClass;

        class a extends DateType {
            a(Class cls) {
                super(cls);
            }

            /* access modifiers changed from: protected */
            public Date deserialize(Date date) {
                return date;
            }
        }

        protected DateType(Class<T> cls) {
            this.dateClass = cls;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return createFactory(new DefaultDateTypeAdapter(this, str));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return createFactory(new DefaultDateTypeAdapter(this, 2, 2));
        }

        /* access modifiers changed from: protected */
        public abstract T deserialize(Date date);

        public final TypeAdapterFactory createAdapterFactory(int i10) {
            return createFactory(new DefaultDateTypeAdapter(this, i10));
        }

        public final TypeAdapterFactory createAdapterFactory(int i10, int i11) {
            return createFactory(new DefaultDateTypeAdapter(this, i10, i11));
        }
    }

    private Date deserializeToDate(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            try {
                for (DateFormat parse : this.dateFormats) {
                    try {
                        Date parse2 = parse.parse(nextString);
                        return parse2;
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return ISO8601Utils.parse(nextString, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e10);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.dateType.deserialize(deserializeToDate(jsonReader));
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(dateType2);
        this.dateType = dateType2;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int i10) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(dateType2);
        this.dateType = dateType2;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i10, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i10));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i10));
        }
    }

    private DefaultDateTypeAdapter(DateType<T> dateType2, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(dateType2);
        this.dateType = dateType2;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i10, i11));
        }
    }
}

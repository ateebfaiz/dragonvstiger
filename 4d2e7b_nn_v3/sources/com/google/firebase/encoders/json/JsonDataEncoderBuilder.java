package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER = new c();
    private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = new a();
    private static final ValueEncoder<String> STRING_ENCODER = new b();
    private static final b TIMESTAMP_ENCODER = new b((a) null);
    /* access modifiers changed from: private */
    public ObjectEncoder<Object> fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
    /* access modifiers changed from: private */
    public boolean ignoreNullValues = false;
    /* access modifiers changed from: private */
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    /* access modifiers changed from: private */
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

    private static final class b implements ValueEncoder {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f9083a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f9083a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* renamed from: a */
        public void encode(Date date, ValueEncoderContext valueEncoderContext) {
            valueEncoderContext.add(f9083a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) STRING_ENCODER);
        registerEncoder(Boolean.class, (ValueEncoder) BOOLEAN_ENCODER);
        registerEncoder(Date.class, (ValueEncoder) TIMESTAMP_ENCODER);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    @NonNull
    public DataEncoder build() {
        return new a();
    }

    @NonNull
    public JsonDataEncoderBuilder configureWith(@NonNull Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder ignoreNullValues(boolean z10) {
        this.ignoreNullValues = z10;
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.fallbackEncoder = objectEncoder;
        return this;
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }

    class a implements DataEncoder {
        a() {
        }

        public void encode(Object obj, Writer writer) {
            d dVar = new d(writer, JsonDataEncoderBuilder.this.objectEncoders, JsonDataEncoderBuilder.this.valueEncoders, JsonDataEncoderBuilder.this.fallbackEncoder, JsonDataEncoderBuilder.this.ignoreNullValues);
            dVar.e(obj, false);
            dVar.o();
        }

        public String encode(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                encode(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.valueEncoders.put(cls, valueEncoder);
        this.objectEncoders.remove(cls);
        return this;
    }
}

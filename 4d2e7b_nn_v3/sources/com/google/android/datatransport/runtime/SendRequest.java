package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.b;
import com.google.auto.value.AutoValue;

abstract class SendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract SendRequest build();

        /* access modifiers changed from: package-private */
        public abstract Builder setEncoding(Encoding encoding);

        /* access modifiers changed from: package-private */
        public abstract Builder setEvent(Event<?> event);

        public <T> Builder setEvent(Event<T> event, Encoding encoding, Transformer<T, byte[]> transformer) {
            setEvent(event);
            setEncoding(encoding);
            setTransformer(transformer);
            return this;
        }

        /* access modifiers changed from: package-private */
        public abstract Builder setTransformer(Transformer<?, byte[]> transformer);

        public abstract Builder setTransportContext(TransportContext transportContext);

        public abstract Builder setTransportName(String str);
    }

    SendRequest() {
    }

    public static Builder a() {
        return new b.C0088b();
    }

    public abstract Encoding b();

    /* access modifiers changed from: package-private */
    public abstract Event c();

    public byte[] d() {
        return (byte[]) e().apply(c().getPayload());
    }

    /* access modifiers changed from: package-private */
    public abstract Transformer e();

    public abstract TransportContext f();

    public abstract String g();
}

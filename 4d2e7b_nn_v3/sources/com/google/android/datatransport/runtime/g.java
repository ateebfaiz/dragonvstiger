package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

final class g implements TransportFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Set f6487a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f6488b;

    /* renamed from: c  reason: collision with root package name */
    private final j f6489c;

    g(Set set, TransportContext transportContext, j jVar) {
        this.f6487a = set;
        this.f6488b = transportContext;
        this.f6489c = jVar;
    }

    public Transport getTransport(String str, Class cls, Transformer transformer) {
        return getTransport(str, cls, Encoding.of("proto"), transformer);
    }

    public Transport getTransport(String str, Class cls, Encoding encoding, Transformer transformer) {
        if (this.f6487a.contains(encoding)) {
            return new i(this.f6488b, str, encoding, transformer, this.f6489c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{encoding, this.f6487a}));
    }
}

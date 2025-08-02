package io.jsonwebtoken.impl.io;

import d.a;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.util.concurrent.atomic.AtomicReference;

public class RuntimeClasspathSerializerLocator implements InstanceLocator<Serializer> {
    private static final AtomicReference<Serializer<Object>> SERIALIZER = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public boolean compareAndSet(Serializer<Object> serializer) {
        return a.a(SERIALIZER, (Object) null, serializer);
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable(String str) {
        return Classes.isAvailable(str);
    }

    /* access modifiers changed from: protected */
    public Serializer<Object> locate() {
        if (isAvailable("com.fasterxml.jackson.databind.ObjectMapper")) {
            return (Serializer) Classes.newInstance("io.jsonwebtoken.io.JacksonSerializer");
        }
        if (isAvailable("org.json.JSONObject")) {
            return (Serializer) Classes.newInstance("io.jsonwebtoken.io.OrgJsonSerializer");
        }
        throw new IllegalStateException("Unable to discover any JSON Serializer implementations on the classpath.");
    }

    public Serializer<Object> getInstance() {
        AtomicReference<Serializer<Object>> atomicReference = SERIALIZER;
        Serializer<Object> serializer = atomicReference.get();
        boolean z10 = false;
        if (serializer == null) {
            serializer = locate();
            Assert.state(serializer != null, "locate() cannot return null.");
            if (!compareAndSet(serializer)) {
                serializer = atomicReference.get();
            }
        }
        if (serializer != null) {
            z10 = true;
        }
        Assert.state(z10, "serializer cannot be null.");
        return serializer;
    }
}

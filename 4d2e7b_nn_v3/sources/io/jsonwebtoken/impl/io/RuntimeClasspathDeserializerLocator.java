package io.jsonwebtoken.impl.io;

import d.a;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import java.util.concurrent.atomic.AtomicReference;

public class RuntimeClasspathDeserializerLocator<T> implements InstanceLocator<Deserializer<T>> {
    private static final AtomicReference<Deserializer> DESERIALIZER = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public boolean compareAndSet(Deserializer<T> deserializer) {
        return a.a(DESERIALIZER, (Object) null, deserializer);
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable(String str) {
        return Classes.isAvailable(str);
    }

    /* access modifiers changed from: protected */
    public Deserializer<T> locate() {
        if (isAvailable("com.fasterxml.jackson.databind.ObjectMapper")) {
            return (Deserializer) Classes.newInstance("io.jsonwebtoken.io.JacksonDeserializer");
        }
        if (isAvailable("org.json.JSONObject")) {
            return (Deserializer) Classes.newInstance("io.jsonwebtoken.io.OrgJsonDeserializer");
        }
        throw new IllegalStateException("Unable to discover any JSON Deserializer implementations on the classpath.");
    }

    public Deserializer<T> getInstance() {
        AtomicReference<Deserializer> atomicReference = DESERIALIZER;
        Deserializer<T> deserializer = atomicReference.get();
        boolean z10 = false;
        if (deserializer == null) {
            deserializer = locate();
            Assert.state(deserializer != null, "locate() cannot return null.");
            if (!compareAndSet(deserializer)) {
                deserializer = atomicReference.get();
            }
        }
        if (deserializer != null) {
            z10 = true;
        }
        Assert.state(z10, "deserializer cannot be null.");
        return deserializer;
    }
}

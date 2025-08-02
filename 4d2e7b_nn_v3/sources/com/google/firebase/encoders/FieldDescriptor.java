package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        Builder(String str) {
            this.name = str;
        }

        @NonNull
        public FieldDescriptor build() {
            Map map;
            String str = this.name;
            if (this.properties == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(new HashMap(this.properties));
            }
            return new FieldDescriptor(str, map);
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t10) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t10.annotationType(), t10);
            return this;
        }
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor of(@NonNull String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.name.equals(fieldDescriptor.name) || !this.properties.equals(fieldDescriptor.properties)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (Annotation) this.properties.get(cls);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }
}

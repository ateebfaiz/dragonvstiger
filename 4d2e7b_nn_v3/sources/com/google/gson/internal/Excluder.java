package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = IGNORE_VERSIONS;

    class a extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private TypeAdapter f9360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f9361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f9362c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Gson f9363d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TypeToken f9364e;

        a(boolean z10, boolean z11, Gson gson, TypeToken typeToken) {
            this.f9361b = z10;
            this.f9362c = z11;
            this.f9363d = gson;
            this.f9364e = typeToken;
        }

        private TypeAdapter delegate() {
            TypeAdapter typeAdapter = this.f9360a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            TypeAdapter delegateAdapter = this.f9363d.getDelegateAdapter(Excluder.this, this.f9364e);
            this.f9360a = delegateAdapter;
            return delegateAdapter;
        }

        public Object read(JsonReader jsonReader) {
            if (!this.f9361b) {
                return delegate().read(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        public void write(JsonWriter jsonWriter, Object obj) {
            if (this.f9362c) {
                jsonWriter.nullValue();
            } else {
                delegate().write(jsonWriter, obj);
            }
        }
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (this.serializeInnerClasses || !isInnerClass(cls)) {
            return isAnonymousOrNonStaticLocal(cls);
        }
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z10) {
        List<ExclusionStrategy> list;
        if (z10) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        for (ExclusionStrategy shouldSkipClass : list) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) || isStatic(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) {
            return false;
        }
        return true;
    }

    private boolean isInnerClass(Class<?> cls) {
        if (!cls.isMemberClass() || isStatic(cls)) {
            return false;
        }
        return true;
    }

    private boolean isStatic(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean isValidSince(Since since) {
        if (since == null) {
            return true;
        }
        if (this.version >= since.value()) {
            return true;
        }
        return false;
    }

    private boolean isValidUntil(Until until) {
        if (until == null) {
            return true;
        }
        if (this.version < until.value()) {
            return true;
        }
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (!isValidSince(since) || !isValidUntil(until)) {
            return false;
        }
        return true;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean z10;
        boolean z11;
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        if (excludeClassChecks || excludeClassInStrategy(rawType, true)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (excludeClassChecks || excludeClassInStrategy(rawType, false)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            return new a(z11, z10, gson, typeToken);
        }
        return null;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z10) {
        if (excludeClassChecks(cls) || excludeClassInStrategy(cls, z10)) {
            return true;
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z10) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z10 ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrNonStaticLocal(field.getType())) {
            return true;
        }
        if (z10) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        for (ExclusionStrategy shouldSkipField : list) {
            if (shouldSkipField.shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z10, boolean z11) {
        Excluder clone = clone();
        if (z10) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z11) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.modifiers = 0;
        for (int i10 : iArr) {
            clone.modifiers = i10 | clone.modifiers;
        }
        return clone;
    }

    public Excluder withVersion(double d10) {
        Excluder clone = clone();
        clone.version = d10;
        return clone;
    }

    /* access modifiers changed from: protected */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }
}

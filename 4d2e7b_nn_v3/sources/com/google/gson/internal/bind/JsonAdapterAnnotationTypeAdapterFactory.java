package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.google.gson.TypeAdapter<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.gson.TypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.TypeAdapter<?> getTypeAdapter(com.google.gson.internal.ConstructorConstructor r8, com.google.gson.Gson r9, com.google.gson.reflect.TypeToken<?> r10, com.google.gson.annotations.JsonAdapter r11) {
        /*
            r7 = this;
            java.lang.Class r0 = r11.value()
            com.google.gson.reflect.TypeToken r0 = com.google.gson.reflect.TypeToken.get(r0)
            com.google.gson.internal.ObjectConstructor r8 = r8.get(r0)
            java.lang.Object r8 = r8.construct()
            boolean r6 = r11.nullSafe()
            boolean r11 = r8 instanceof com.google.gson.TypeAdapter
            if (r11 == 0) goto L_0x001b
            com.google.gson.TypeAdapter r8 = (com.google.gson.TypeAdapter) r8
            goto L_0x007b
        L_0x001b:
            boolean r11 = r8 instanceof com.google.gson.TypeAdapterFactory
            if (r11 == 0) goto L_0x0026
            com.google.gson.TypeAdapterFactory r8 = (com.google.gson.TypeAdapterFactory) r8
            com.google.gson.TypeAdapter r8 = r8.create(r9, r10)
            goto L_0x007b
        L_0x0026:
            boolean r11 = r8 instanceof com.google.gson.JsonSerializer
            if (r11 != 0) goto L_0x005f
            boolean r0 = r8 instanceof com.google.gson.JsonDeserializer
            if (r0 == 0) goto L_0x002f
            goto L_0x005f
        L_0x002f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r11.append(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r11.append(r8)
            java.lang.String r8 = " as a @JsonAdapter for "
            r11.append(r8)
            java.lang.String r8 = r10.toString()
            r11.append(r8)
            java.lang.String r8 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.<init>(r8)
            throw r9
        L_0x005f:
            r0 = 0
            if (r11 == 0) goto L_0x0067
            r11 = r8
            com.google.gson.JsonSerializer r11 = (com.google.gson.JsonSerializer) r11
            r1 = r11
            goto L_0x0068
        L_0x0067:
            r1 = r0
        L_0x0068:
            boolean r11 = r8 instanceof com.google.gson.JsonDeserializer
            if (r11 == 0) goto L_0x0070
            com.google.gson.JsonDeserializer r8 = (com.google.gson.JsonDeserializer) r8
            r2 = r8
            goto L_0x0071
        L_0x0070:
            r2 = r0
        L_0x0071:
            com.google.gson.internal.bind.TreeTypeAdapter r8 = new com.google.gson.internal.bind.TreeTypeAdapter
            r5 = 0
            r0 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
        L_0x007b:
            if (r8 == 0) goto L_0x0083
            if (r6 == 0) goto L_0x0083
            com.google.gson.TypeAdapter r8 = r8.nullSafe()
        L_0x0083:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(com.google.gson.internal.ConstructorConstructor, com.google.gson.Gson, com.google.gson.reflect.TypeToken, com.google.gson.annotations.JsonAdapter):com.google.gson.TypeAdapter");
    }
}

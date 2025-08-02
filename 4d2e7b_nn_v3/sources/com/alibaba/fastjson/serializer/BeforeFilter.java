package com.alibaba.fastjson.serializer;

public abstract class BeforeFilter implements SerializeFilter {
    private static final Character COMMA = ',';
    private static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    private static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();

    /* access modifiers changed from: package-private */
    public final char writeBefore(JSONSerializer jSONSerializer, Object obj, char c10) {
        ThreadLocal<JSONSerializer> threadLocal = serializerLocal;
        threadLocal.set(jSONSerializer);
        ThreadLocal<Character> threadLocal2 = seperatorLocal;
        threadLocal2.set(Character.valueOf(c10));
        writeBefore(obj);
        threadLocal.set((Object) null);
        return threadLocal2.get().charValue();
    }

    public abstract void writeBefore(Object obj);

    /* access modifiers changed from: protected */
    public final void writeKeyValue(String str, Object obj) {
        ThreadLocal<Character> threadLocal = seperatorLocal;
        char charValue = threadLocal.get().charValue();
        serializerLocal.get().writeKeyValue(charValue, str, obj);
        if (charValue != ',') {
            threadLocal.set(COMMA);
        }
    }
}

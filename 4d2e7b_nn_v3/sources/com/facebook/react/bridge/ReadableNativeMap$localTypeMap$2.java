package com.facebook.react.bridge;

import com.facebook.react.bridge.ReadableNativeMap;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class ReadableNativeMap$localTypeMap$2 extends n implements Function0<HashMap<String, ReadableType>> {
    final /* synthetic */ ReadableNativeMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadableNativeMap$localTypeMap$2(ReadableNativeMap readableNativeMap) {
        super(0);
        this.this$0 = readableNativeMap;
    }

    public final HashMap<String, ReadableType> invoke() {
        int length = this.this$0.getKeys().length;
        HashMap<String, ReadableType> hashMap = new HashMap<>(length);
        Object[] access$importTypes = this.this$0.importTypes();
        ReadableNativeMap.Companion unused = ReadableNativeMap.Companion;
        ReadableNativeMap.jniPassCounter = ReadableNativeMap.jniPassCounter + 1;
        for (int i10 = 0; i10 < length; i10++) {
            String str = this.this$0.getKeys()[i10];
            Object obj = access$importTypes[i10];
            m.d(obj, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableType");
            hashMap.put(str, (ReadableType) obj);
        }
        return hashMap;
    }
}

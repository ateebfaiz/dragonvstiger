package com.facebook.react.bridge;

import com.facebook.react.bridge.ReadableNativeMap;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

final class ReadableNativeMap$localMap$2 extends n implements Function0<HashMap<String, Object>> {
    final /* synthetic */ ReadableNativeMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadableNativeMap$localMap$2(ReadableNativeMap readableNativeMap) {
        super(0);
        this.this$0 = readableNativeMap;
    }

    public final HashMap<String, Object> invoke() {
        int length = this.this$0.getKeys().length;
        HashMap<String, Object> hashMap = new HashMap<>(length);
        Object[] access$importValues = this.this$0.importValues();
        ReadableNativeMap.Companion unused = ReadableNativeMap.Companion;
        ReadableNativeMap.jniPassCounter = ReadableNativeMap.jniPassCounter + 1;
        for (int i10 = 0; i10 < length; i10++) {
            hashMap.put(this.this$0.getKeys()[i10], access$importValues[i10]);
        }
        return hashMap;
    }
}

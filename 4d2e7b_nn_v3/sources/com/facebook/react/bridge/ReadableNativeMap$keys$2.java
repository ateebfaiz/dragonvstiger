package com.facebook.react.bridge;

import com.facebook.react.bridge.ReadableNativeMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

final class ReadableNativeMap$keys$2 extends n implements Function0<String[]> {
    final /* synthetic */ ReadableNativeMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadableNativeMap$keys$2(ReadableNativeMap readableNativeMap) {
        super(0);
        this.this$0 = readableNativeMap;
    }

    public final String[] invoke() {
        String[] access$importKeys = this.this$0.importKeys();
        ReadableNativeMap.Companion unused = ReadableNativeMap.Companion;
        ReadableNativeMap.jniPassCounter = ReadableNativeMap.jniPassCounter + 1;
        return access$importKeys;
    }
}

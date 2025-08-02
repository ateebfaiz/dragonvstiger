package z6;

import com.facebook.react.bridge.ReadableMap;
import k5.b;
import k5.c;

public class a extends b {
    private final ReadableMap A;

    protected a(c cVar, ReadableMap readableMap) {
        super(cVar);
        this.A = readableMap;
    }

    public static a z(c cVar, ReadableMap readableMap) {
        return new a(cVar, readableMap);
    }

    public ReadableMap A() {
        return this.A;
    }
}

package c1;

import f1.f;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.d;

public final class h implements f.i {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f17219a;

    public h() {
        byte[] bytes = "\"[OBJECT]\"".getBytes(d.f797b);
        m.e(bytes, "this as java.lang.String).getBytes(charset)");
        this.f17219a = bytes;
    }

    public void a(Object obj, OutputStream outputStream) {
        outputStream.write(this.f17219a);
    }

    /* renamed from: c */
    public Object b(Map map, Type type, InputStream inputStream) {
        throw new UnsupportedOperationException();
    }
}

package x0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class c implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f24680g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f24681a;

    /* renamed from: b  reason: collision with root package name */
    int[] f24682b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f24683c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f24684d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f24685e;

    /* renamed from: f  reason: collision with root package name */
    boolean f24686f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f24687a;

        /* renamed from: b  reason: collision with root package name */
        final Options f24688b;

        private a(String[] strArr, Options options) {
            this.f24687a = strArr;
            this.f24688b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    c.H(buffer, strArr[i10]);
                    buffer.readByte();
                    byteStringArr[i10] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f24680g[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f24680g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    /* access modifiers changed from: private */
    public static void H(BufferedSink bufferedSink, String str) {
        String str2;
        String[] strArr = f24680g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i10 < i11) {
                bufferedSink.writeUtf8(str, i10, i11);
            }
            bufferedSink.writeUtf8(str2);
            i10 = i11 + 1;
        }
        if (i10 < length) {
            bufferedSink.writeUtf8(str, i10, length);
        }
        bufferedSink.writeByte(34);
    }

    public static c z(BufferedSource bufferedSource) {
        return new e(bufferedSource);
    }

    public abstract b A();

    /* access modifiers changed from: package-private */
    public final void B(int i10) {
        int i11 = this.f24681a;
        int[] iArr = this.f24682b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f24682b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f24683c;
                this.f24683c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f24684d;
                this.f24684d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new a("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f24682b;
        int i12 = this.f24681a;
        this.f24681a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int C(a aVar);

    public abstract void E();

    public abstract void G();

    /* access modifiers changed from: package-private */
    public final b I(String str) {
        throw new b(str + " at path " + getPath());
    }

    public abstract void b();

    public final String getPath() {
        return d.a(this.f24681a, this.f24682b, this.f24683c, this.f24684d);
    }

    public abstract void h();

    public abstract void j();

    public abstract void k();

    public abstract boolean m();

    public abstract boolean n();

    public abstract double p();

    public abstract int v();

    public abstract String w();

    public abstract String y();
}

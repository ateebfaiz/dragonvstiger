package m2;

import android.text.TextUtils;
import com.facebook.o;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import kotlin.text.h;
import org.json.JSONArray;
import org.json.JSONObject;
import v5.a;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f22529a = new g();

    private g() {
    }

    public static final File a() {
        Class<g> cls = g.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            File file = new File(o.f().getFilesDir(), "facebook_ml/");
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final Map c(File file) {
        int i10;
        File file2 = file;
        Class<g> cls = g.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(file2, "file");
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                int available = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[available];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (available < 4) {
                    return null;
                }
                int i11 = 0;
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                m.e(wrap, "bb");
                int i12 = wrap.getInt();
                int i13 = i12 + 4;
                if (available < i13) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i12, d.f797b));
                JSONArray names = jSONObject.names();
                int length = names.length();
                String[] strArr = new String[length];
                for (int i14 = 0; i14 < length; i14++) {
                    strArr[i14] = names.getString(i14);
                }
                j.p(strArr);
                HashMap hashMap = new HashMap();
                int i15 = 0;
                while (i15 < length) {
                    String str = strArr[i15];
                    if (str == null) {
                        i10 = i11;
                    } else {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        int length2 = jSONArray.length();
                        int[] iArr = new int[length2];
                        int i16 = 1;
                        while (i11 < length2) {
                            int i17 = jSONArray.getInt(i11);
                            iArr[i11] = i17;
                            i16 *= i17;
                            i11++;
                        }
                        int i18 = i16 * 4;
                        int i19 = i13 + i18;
                        if (i19 > available) {
                            return null;
                        }
                        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i13, i18);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        a aVar = new a(iArr);
                        i10 = 0;
                        wrap2.asFloatBuffer().get(aVar.a(), 0, i16);
                        hashMap.put(str, aVar);
                        i13 = i19;
                    }
                    i15++;
                    i11 = i10;
                }
                return hashMap;
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public final String b(String str) {
        int i10;
        boolean z10;
        if (a.d(this)) {
            return null;
        }
        try {
            m.f(str, "str");
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i11 > length) {
                    break;
                }
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (m.g(str.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11) {
                    if (!z10) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z10) {
                    break;
                } else {
                    length--;
                }
            }
            Object[] array = new h("\\s+").e(str.subSequence(i11, length + 1).toString(), 0).toArray(new String[0]);
            if (array != null) {
                String join = TextUtils.join(" ", (String[]) array);
                m.e(join, "TextUtils.join(\" \", strArray)");
                return join;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    public final int[] d(String str, int i10) {
        if (a.d(this)) {
            return null;
        }
        try {
            m.f(str, "texts");
            int[] iArr = new int[i10];
            String b10 = b(str);
            Charset forName = Charset.forName("UTF-8");
            m.e(forName, "Charset.forName(\"UTF-8\")");
            if (b10 != null) {
                byte[] bytes = b10.getBytes(forName);
                m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                for (int i11 = 0; i11 < i10; i11++) {
                    if (i11 < bytes.length) {
                        iArr[i11] = bytes[i11] & 255;
                    } else {
                        iArr[i11] = 0;
                    }
                }
                return iArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }
}

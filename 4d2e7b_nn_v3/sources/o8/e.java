package o8;

import c.d;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.std.k;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.z;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class e implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private static final Class f12877c = Node.class;

    /* renamed from: d  reason: collision with root package name */
    private static final Class f12878d;

    /* renamed from: e  reason: collision with root package name */
    public static final e f12879e = new e();

    /* renamed from: a  reason: collision with root package name */
    private final Map f12880a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f12881b;

    static {
        Class<Document> cls = Document.class;
        f12878d = cls;
        try {
            a.a();
        } catch (Throwable unused) {
        }
    }

    protected e() {
        HashMap hashMap = new HashMap();
        this.f12880a = hashMap;
        hashMap.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        hashMap.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap hashMap2 = new HashMap();
        this.f12881b = hashMap2;
        hashMap2.put("java.sql.Timestamp", k.f5556f);
        hashMap2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        hashMap2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        hashMap2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        hashMap2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    private boolean a(Class cls, Class cls2) {
        if (cls2 == null || !cls2.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    private boolean c(Class<Object> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }

    private Object d(Class cls, j jVar) {
        try {
            return f.k(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + f.C(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    private Object e(String str, j jVar) {
        try {
            return d(Class.forName(str), jVar);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + f.C(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public o b(z zVar, j jVar, c cVar) {
        Object e10;
        Class s10 = jVar.s();
        if (a(s10, f12877c)) {
            return (o) e("com.fasterxml.jackson.databind.ext.DOMSerializer", jVar);
        }
        String name = s10.getName();
        Object obj = this.f12881b.get(name);
        if (obj != null) {
            if (obj instanceof o) {
                return (o) obj;
            }
            return (o) e((String) obj, jVar);
        } else if ((!name.startsWith("javax.xml.") && !c(s10, "javax.xml.")) || (e10 = e("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", jVar)) == null) {
            return null;
        } else {
            d.a(e10);
            throw null;
        }
    }
}

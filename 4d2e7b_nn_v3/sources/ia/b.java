package ia;

import ha.c;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import s9.e;
import s9.j;
import s9.l;

public class b extends j implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    private a f12384g;

    public b(c cVar, c cVar2, c cVar3) {
        super(cVar, cVar2, cVar3);
    }

    public static b p(String str) {
        c[] e10 = e.e(str);
        if (e10.length == 3) {
            return new b(e10[0], e10[1], e10[2]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    }

    /* access modifiers changed from: protected */
    public void d(l lVar) {
        this.f12384g = null;
        super.d(lVar);
    }

    public a o() {
        a aVar = this.f12384g;
        if (aVar != null) {
            return aVar;
        }
        Map e10 = b().e();
        if (e10 != null) {
            a h10 = a.h(e10);
            this.f12384g = h10;
            return h10;
        }
        throw new ParseException("Payload of JWS object is not a valid JSON object", 0);
    }
}

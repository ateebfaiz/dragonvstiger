package b1;

import a1.k;
import a1.m;
import a1.p;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends j {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(int r7, java.lang.String r8, org.json.JSONObject r9, a1.p.b r10, a1.p.a r11) {
        /*
            r6 = this;
            if (r9 != 0) goto L_0x0005
            r9 = 0
        L_0x0003:
            r3 = r9
            goto L_0x000a
        L_0x0005:
            java.lang.String r9 = r9.toString()
            goto L_0x0003
        L_0x000a:
            r0 = r6
            r1 = r7
            r2 = r8
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.i.<init>(int, java.lang.String, org.json.JSONObject, a1.p$b, a1.p$a):void");
    }

    /* access modifiers changed from: protected */
    public p z(k kVar) {
        try {
            return p.c(new JSONObject(new String(kVar.f13616b, e.d(kVar.f13617c, "utf-8"))), e.c(kVar));
        } catch (UnsupportedEncodingException e10) {
            return p.a(new m(e10));
        } catch (JSONException e11) {
            return p.a(new m(e11));
        }
    }
}

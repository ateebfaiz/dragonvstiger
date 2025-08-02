package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.core.api.MTProtocol;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import org.json.JSONObject;
import u1.m;
import y1.a;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f21610a;

    public static s a() {
        if (f21610a == null) {
            synchronized (s.class) {
                f21610a = new s();
            }
        }
        return f21610a;
    }

    public final void b(Context context, int i10, long j10) {
        MTProtocol i11 = new MTProtocol().g(4).j(2).f(d.b(i10, j10)).i(a.f24870a);
        Bundle bundle = new Bundle();
        bundle.putParcelable("protocol", i11);
        h1.a.j(context, 2222, bundle);
    }

    public void c(Context context, Bundle bundle) {
        JSONObject optJSONObject;
        try {
            ByteBuffer wrap = ByteBuffer.wrap(((MTProtocol) bundle.getParcelable("protocol")).a());
            byte b10 = wrap.get();
            long j10 = wrap.getLong();
            LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(m.f(wrap)));
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            String readLine3 = lineNumberReader.readLine();
            if (!TextUtils.equals(readLine, context.getPackageName())) {
                s1.a.h("MTMessageBusiness", "the message applicationId is [" + readLine + "]");
            } else if (!TextUtils.equals(readLine2, p1.a.b(context))) {
                s1.a.h("MTMessageBusiness", "the message applicationKey is [" + readLine2 + "]");
            } else if (TextUtils.isEmpty(readLine3)) {
                s1.a.h("MTMessageBusiness", "the message is empty");
            } else {
                JSONObject jSONObject = new JSONObject(readLine3);
                int optInt = jSONObject.optInt("n_only");
                int optInt2 = jSONObject.optInt("show_type");
                b(context, b10, j10);
                if (!a0.c(context, x.a(jSONObject))) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("message", jSONObject.toString());
                    s1.a.a("MTMessageBusiness", "onMessage:" + s1.a.g(jSONObject));
                    if (!jSONObject.has("geofence") || (optJSONObject = jSONObject.optJSONObject("geofence")) == null || TextUtils.isEmpty(optJSONObject.optString("geofenceid"))) {
                        s1.a.h("MTMessageBusiness", "onMessage type=" + optInt2 + " flag=" + optInt);
                        if (optInt2 == 4) {
                            w.r().c(context, bundle2);
                            t.e().c(context, bundle2);
                        } else if (optInt == 1) {
                            w.r().c(context, bundle2);
                        } else if (optInt == 0) {
                            t.e().c(context, bundle2);
                        }
                    } else {
                        s1.a.a("MTMessageBusiness", "is geofence notification");
                        h1.a.j(context, 3881, bundle2);
                    }
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTMessageBusiness", "onMessage failed " + th.getMessage());
        }
    }
}

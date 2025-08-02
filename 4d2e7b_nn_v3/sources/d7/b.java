package d7;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import d7.e;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

public final class b implements e.c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f11874c = "b";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f11875a;

    /* renamed from: b  reason: collision with root package name */
    private Map f11876b;

    private class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private Object f11877a;

        public a(Object obj) {
            this.f11877a = obj;
        }

        public void a(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.f11877a);
                jSONObject.put(DbParams.KEY_CHANNEL_RESULT, obj);
                b.this.f11875a.h(jSONObject.toString());
            } catch (Exception e10) {
                z2.a.k(b.f11874c, "Responding failed", e10);
            }
        }

        public void b(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.f11877a);
                jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, obj);
                b.this.f11875a.h(jSONObject.toString());
            } catch (Exception e10) {
                z2.a.k(b.f11874c, "Responding with error failed", e10);
            }
        }
    }

    public b(String str, d dVar, Map map, e.b bVar) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("ws").encodedAuthority(dVar.a()).appendPath("message").appendQueryParameter("device", a7.a.d()).appendQueryParameter("app", dVar.b()).appendQueryParameter("clientid", str);
        this.f11875a = new e(builder.build().toString(), this, bVar);
        this.f11876b = map;
    }

    private void d(Object obj, String str) {
        if (obj != null) {
            new a(obj).b(str);
        }
        String str2 = f11874c;
        z2.a.j(str2, "Handling the message failed with reason: " + str);
    }

    public void a(ByteString byteString) {
        z2.a.G(f11874c, "Websocket received message with payload of unexpected type binary");
    }

    public void e() {
        this.f11875a.c();
    }

    public void f() {
        this.f11875a.e();
    }

    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("version");
            String optString = jSONObject.optString(FirebaseAnalytics.Param.METHOD);
            Object opt = jSONObject.opt("id");
            Object opt2 = jSONObject.opt("params");
            if (optInt != 2) {
                String str2 = f11874c;
                z2.a.j(str2, "Message with incompatible or missing version of protocol received: " + optInt);
            } else if (optString == null) {
                d(opt, "No method provided");
            } else {
                f fVar = (f) this.f11876b.get(optString);
                if (fVar == null) {
                    d(opt, "No request handler for method: " + optString);
                } else if (opt == null) {
                    fVar.a(opt2);
                } else {
                    fVar.b(opt2, new a(opt));
                }
            }
        } catch (Exception e10) {
            z2.a.k(f11874c, "Handling the message failed", e10);
        }
    }
}

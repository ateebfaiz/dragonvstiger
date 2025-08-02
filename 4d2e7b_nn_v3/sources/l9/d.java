package l9;

import java.io.IOException;
import java.io.InputStream;
import m9.b;
import m9.c;
import org.json.JSONException;
import org.json.JSONObject;

abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f12751a;

    d() {
        this(new b());
    }

    public Object a(InputStream inputStream) {
        try {
            return b(this.f12751a.a(inputStream));
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Object b(JSONObject jSONObject);

    d(b bVar) {
        this.f12751a = bVar;
    }
}

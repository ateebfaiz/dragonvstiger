package m9;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f12809a = new d();

    /* renamed from: b */
    public JSONObject a(InputStream inputStream) {
        try {
            return new JSONObject(this.f12809a.a(inputStream));
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }
}

package l9;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.linecorp.linesdk.LineGroup;
import com.linecorp.linesdk.LineProfile;
import i9.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {

    /* renamed from: c  reason: collision with root package name */
    private static final m9.c f12766c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final m9.c f12767d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final m9.c f12768e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final m9.c f12769f = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f12770a;

    /* renamed from: b  reason: collision with root package name */
    private final m9.a f12771b;

    static class a extends d {
        a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public i9.a b(JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("friends");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(d.e(jSONArray.getJSONObject(i10)));
            }
            return new i9.a(arrayList, jSONObject.optString("pageToken", (String) null));
        }
    }

    static class b extends d {
        b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public e b(JSONObject jSONObject) {
            return new e(jSONObject.getBoolean("friendFlag"));
        }
    }

    static class c extends d {
        c() {
        }

        private static LineGroup d(JSONObject jSONObject) {
            Uri uri = null;
            String optString = jSONObject.optString("pictureUrl", (String) null);
            String string = jSONObject.getString("groupId");
            String string2 = jSONObject.getString("groupName");
            if (optString != null) {
                uri = Uri.parse(optString);
            }
            return new LineGroup(string, string2, uri);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public i9.b b(JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("groups");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(d(jSONArray.getJSONObject(i10)));
            }
            return new i9.b(arrayList, jSONObject.optString("pageToken", (String) null));
        }
    }

    static class d extends d {
        d() {
        }

        /* access modifiers changed from: private */
        public static LineProfile e(JSONObject jSONObject) {
            Uri uri;
            String optString = jSONObject.optString("pictureUrl", (String) null);
            String string = jSONObject.getString("userId");
            String string2 = jSONObject.getString("displayName");
            if (optString == null) {
                uri = null;
            } else {
                uri = Uri.parse(optString);
            }
            return new LineProfile(string, string2, uri, jSONObject.optString("statusMessage", (String) null));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public LineProfile b(JSONObject jSONObject) {
            return e(jSONObject);
        }
    }

    public i(Context context, Uri uri) {
        this(uri, new m9.a(context, "5.3.1"));
    }

    private static Map a(k9.e eVar) {
        return n9.d.d("Authorization", "Bearer " + eVar.a());
    }

    public i9.c b(k9.e eVar) {
        return this.f12771b.b(n9.d.e(this.f12770a, "v2", Scopes.PROFILE), a(eVar), Collections.emptyMap(), f12766c);
    }

    i(Uri uri, m9.a aVar) {
        this.f12770a = uri;
        this.f12771b = aVar;
    }
}

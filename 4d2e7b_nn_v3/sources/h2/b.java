package h2;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f21860e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21861a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21862b;

    /* renamed from: c  reason: collision with root package name */
    private final List f21863c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21864d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(JSONObject jSONObject) {
        m.f(jSONObject, "component");
        String string = jSONObject.getString("name");
        m.e(string, "component.getString(PARAMETER_NAME_KEY)");
        this.f21861a = string;
        String optString = jSONObject.optString("value");
        m.e(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.f21862b = optString;
        String optString2 = jSONObject.optString("path_type", "absolute");
        m.e(optString2, "component.optString(Cons…tants.PATH_TYPE_ABSOLUTE)");
        this.f21864d = optString2;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                m.e(jSONObject2, "jsonPathArray.getJSONObject(i)");
                arrayList.add(new c(jSONObject2));
            }
        }
        this.f21863c = arrayList;
    }

    public final String a() {
        return this.f21861a;
    }

    public final List b() {
        return this.f21863c;
    }

    public final String c() {
        return this.f21864d;
    }

    public final String d() {
        return this.f21862b;
    }
}

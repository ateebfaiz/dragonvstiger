package h2;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: j  reason: collision with root package name */
    public static final b f21843j = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21844a;

    /* renamed from: b  reason: collision with root package name */
    private final c f21845b;

    /* renamed from: c  reason: collision with root package name */
    private final C0285a f21846c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21847d;

    /* renamed from: e  reason: collision with root package name */
    private final List f21848e;

    /* renamed from: f  reason: collision with root package name */
    private final List f21849f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21850g;

    /* renamed from: h  reason: collision with root package name */
    private final String f21851h;

    /* renamed from: i  reason: collision with root package name */
    private final String f21852i;

    /* renamed from: h2.a$a  reason: collision with other inner class name */
    public enum C0285a {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    public static final class b {
        private b() {
        }

        public final a a(JSONObject jSONObject) {
            m.f(jSONObject, "mapping");
            String string = jSONObject.getString(DbParams.KEY_CHANNEL_EVENT_NAME);
            String string2 = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
            m.e(string2, "mapping.getString(\"method\")");
            Locale locale = Locale.ENGLISH;
            m.e(locale, "Locale.ENGLISH");
            if (string2 != null) {
                String upperCase = string2.toUpperCase(locale);
                m.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                c valueOf = c.valueOf(upperCase);
                String string3 = jSONObject.getString("event_type");
                m.e(string3, "mapping.getString(\"event_type\")");
                m.e(locale, "Locale.ENGLISH");
                if (string3 != null) {
                    String upperCase2 = string3.toUpperCase(locale);
                    m.e(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
                    C0285a valueOf2 = C0285a.valueOf(upperCase2);
                    String string4 = jSONObject.getString("app_version");
                    JSONArray jSONArray = jSONObject.getJSONArray("path");
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        m.e(jSONObject2, "jsonPath");
                        arrayList.add(new c(jSONObject2));
                    }
                    String optString = jSONObject.optString("path_type", "absolute");
                    JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        for (int i11 = 0; i11 < length2; i11++) {
                            JSONObject jSONObject3 = optJSONArray.getJSONObject(i11);
                            m.e(jSONObject3, "jsonParameter");
                            arrayList2.add(new b(jSONObject3));
                        }
                    }
                    String optString2 = jSONObject.optString("component_id");
                    String optString3 = jSONObject.optString("activity_name");
                    m.e(string, "eventName");
                    m.e(string4, "appVersion");
                    m.e(optString2, "componentId");
                    m.e(optString, "pathType");
                    m.e(optString3, "activityName");
                    return new a(string, valueOf, valueOf2, string4, arrayList, arrayList2, optString2, optString, optString3);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public final List b(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                try {
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        m.e(jSONObject, "array.getJSONObject(i)");
                        arrayList.add(a(jSONObject));
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum c {
        MANUAL,
        INFERENCE
    }

    public a(String str, c cVar, C0285a aVar, String str2, List list, List list2, String str3, String str4, String str5) {
        m.f(str, "eventName");
        m.f(cVar, FirebaseAnalytics.Param.METHOD);
        m.f(aVar, "type");
        m.f(str2, "appVersion");
        m.f(list, "path");
        m.f(list2, "parameters");
        m.f(str3, "componentId");
        m.f(str4, "pathType");
        m.f(str5, "activityName");
        this.f21844a = str;
        this.f21845b = cVar;
        this.f21846c = aVar;
        this.f21847d = str2;
        this.f21848e = list;
        this.f21849f = list2;
        this.f21850g = str3;
        this.f21851h = str4;
        this.f21852i = str5;
    }

    public final String a() {
        return this.f21852i;
    }

    public final String b() {
        return this.f21844a;
    }

    public final List c() {
        List unmodifiableList = Collections.unmodifiableList(this.f21849f);
        m.e(unmodifiableList, "Collections.unmodifiableList(parameters)");
        return unmodifiableList;
    }

    public final List d() {
        List unmodifiableList = Collections.unmodifiableList(this.f21848e);
        m.e(unmodifiableList, "Collections.unmodifiableList(path)");
        return unmodifiableList;
    }
}

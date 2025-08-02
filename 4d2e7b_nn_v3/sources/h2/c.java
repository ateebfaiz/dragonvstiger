package h2;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class c {

    /* renamed from: i  reason: collision with root package name */
    public static final a f21865i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21866a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21867b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21868c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21869d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21870e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21871f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21872g;

    /* renamed from: h  reason: collision with root package name */
    private final int f21873h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum b {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f21880a;

        private b(int i10) {
            this.f21880a = i10;
        }

        public final int a() {
            return this.f21880a;
        }
    }

    public c(JSONObject jSONObject) {
        m.f(jSONObject, "component");
        String string = jSONObject.getString("class_name");
        m.e(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.f21866a = string;
        this.f21867b = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -1);
        this.f21868c = jSONObject.optInt("id");
        String optString = jSONObject.optString("text");
        m.e(optString, "component.optString(PATH_TEXT_KEY)");
        this.f21869d = optString;
        String optString2 = jSONObject.optString("tag");
        m.e(optString2, "component.optString(PATH_TAG_KEY)");
        this.f21870e = optString2;
        String optString3 = jSONObject.optString("description");
        m.e(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.f21871f = optString3;
        String optString4 = jSONObject.optString("hint");
        m.e(optString4, "component.optString(PATH_HINT_KEY)");
        this.f21872g = optString4;
        this.f21873h = jSONObject.optInt("match_bitmask");
    }

    public final String a() {
        return this.f21866a;
    }

    public final String b() {
        return this.f21871f;
    }

    public final String c() {
        return this.f21872g;
    }

    public final int d() {
        return this.f21868c;
    }

    public final int e() {
        return this.f21867b;
    }

    public final int f() {
        return this.f21873h;
    }

    public final String g() {
        return this.f21870e;
    }

    public final String h() {
        return this.f21869d;
    }
}

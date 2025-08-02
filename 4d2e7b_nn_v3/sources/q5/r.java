package q5;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r {

    /* renamed from: t  reason: collision with root package name */
    public static final a f23420t = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23421a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23422b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23423c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23424d;

    /* renamed from: e  reason: collision with root package name */
    private final EnumSet f23425e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f23426f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f23427g;

    /* renamed from: h  reason: collision with root package name */
    private final k f23428h;

    /* renamed from: i  reason: collision with root package name */
    private final String f23429i;

    /* renamed from: j  reason: collision with root package name */
    private final String f23430j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f23431k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f23432l;

    /* renamed from: m  reason: collision with root package name */
    private final JSONArray f23433m;

    /* renamed from: n  reason: collision with root package name */
    private final String f23434n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f23435o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f23436p;

    /* renamed from: q  reason: collision with root package name */
    private final String f23437q;

    /* renamed from: r  reason: collision with root package name */
    private final String f23438r;

    /* renamed from: s  reason: collision with root package name */
    private final String f23439s;

    public static final class a {
        private a() {
        }

        public final b a(String str, String str2, String str3) {
            r j10;
            Map map;
            m.f(str, "applicationId");
            m.f(str2, "actionName");
            m.f(str3, "featureName");
            if (p0.Y(str2) || p0.Y(str3) || (j10 = s.j(str)) == null || (map = (Map) j10.c().get(str2)) == null) {
                return null;
            }
            return (b) map.get(str3);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        public static final a f23440e = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f23441a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23442b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f23443c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f23444d;

        public static final class a {
            private a() {
            }

            private final int[] b(JSONArray jSONArray) {
                if (jSONArray == null) {
                    return null;
                }
                int length = jSONArray.length();
                int[] iArr = new int[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = -1;
                    int optInt = jSONArray.optInt(i10, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i10);
                        if (!p0.Y(optString)) {
                            try {
                                m.e(optString, "versionString");
                                i11 = Integer.parseInt(optString);
                            } catch (NumberFormatException e10) {
                                p0.e0("FacebookSDK", e10);
                            }
                            optInt = i11;
                        }
                    }
                    iArr[i10] = optInt;
                }
                return iArr;
            }

            public final b a(JSONObject jSONObject) {
                m.f(jSONObject, "dialogConfigJSON");
                String optString = jSONObject.optString("name");
                Uri uri = null;
                if (p0.Y(optString)) {
                    return null;
                }
                m.e(optString, "dialogNameWithFeature");
                List v02 = j.v0(optString, new String[]{"|"}, false, 0, 6, (Object) null);
                if (v02.size() != 2) {
                    return null;
                }
                String str = (String) kotlin.collections.r.Y(v02);
                String str2 = (String) kotlin.collections.r.g0(v02);
                if (p0.Y(str) || p0.Y(str2)) {
                    return null;
                }
                String optString2 = jSONObject.optString(ImagesContract.URL);
                if (!p0.Y(optString2)) {
                    uri = Uri.parse(optString2);
                }
                return new b(str, str2, uri, b(jSONObject.optJSONArray("versions")), (DefaultConstructorMarker) null);
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ b(String str, String str2, Uri uri, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, uri, iArr);
        }

        public final String a() {
            return this.f23441a;
        }

        public final Uri b() {
            return this.f23443c;
        }

        public final String c() {
            return this.f23442b;
        }

        public final int[] d() {
            return this.f23444d;
        }

        private b(String str, String str2, Uri uri, int[] iArr) {
            this.f23441a = str;
            this.f23442b = str2;
            this.f23443c = uri;
            this.f23444d = iArr;
        }
    }

    public r(boolean z10, String str, boolean z11, int i10, EnumSet enumSet, Map map, boolean z12, k kVar, String str2, String str3, boolean z13, boolean z14, JSONArray jSONArray, String str4, boolean z15, boolean z16, String str5, String str6, String str7) {
        k kVar2 = kVar;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        m.f(str, "nuxContent");
        m.f(enumSet, "smartLoginOptions");
        m.f(map, "dialogConfigurations");
        m.f(kVar2, "errorClassification");
        m.f(str8, "smartLoginBookmarkIconURL");
        m.f(str9, "smartLoginMenuIconURL");
        m.f(str10, "sdkUpdateMessage");
        this.f23421a = z10;
        this.f23422b = str;
        this.f23423c = z11;
        this.f23424d = i10;
        this.f23425e = enumSet;
        this.f23426f = map;
        this.f23427g = z12;
        this.f23428h = kVar2;
        this.f23429i = str8;
        this.f23430j = str9;
        this.f23431k = z13;
        this.f23432l = z14;
        this.f23433m = jSONArray;
        this.f23434n = str10;
        this.f23435o = z15;
        this.f23436p = z16;
        this.f23437q = str5;
        this.f23438r = str6;
        this.f23439s = str7;
    }

    public final boolean a() {
        return this.f23427g;
    }

    public final boolean b() {
        return this.f23432l;
    }

    public final Map c() {
        return this.f23426f;
    }

    public final k d() {
        return this.f23428h;
    }

    public final JSONArray e() {
        return this.f23433m;
    }

    public final boolean f() {
        return this.f23431k;
    }

    public final String g() {
        return this.f23422b;
    }

    public final boolean h() {
        return this.f23423c;
    }

    public final String i() {
        return this.f23437q;
    }

    public final String j() {
        return this.f23439s;
    }

    public final String k() {
        return this.f23434n;
    }

    public final int l() {
        return this.f23424d;
    }

    public final EnumSet m() {
        return this.f23425e;
    }

    public final String n() {
        return this.f23438r;
    }

    public final boolean o() {
        return this.f23421a;
    }
}

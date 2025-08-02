package q5;

import androidx.core.location.LocationRequestCompat;
import com.facebook.FacebookRequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.t;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static k f23357g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f23358h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Map f23359a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f23360b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f23361c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23362d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23363e;

    /* renamed from: f  reason: collision with root package name */
    private final String f23364f;

    public static final class a {
        private a() {
        }

        private final k c() {
            return new k((Map) null, i0.g(t.a(2, (Object) null), t.a(4, (Object) null), t.a(9, (Object) null), t.a(17, (Object) null), t.a(341, (Object) null)), i0.g(t.a(Integer.valueOf(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY), (Object) null), t.a(190, (Object) null), t.a(412, (Object) null)), (String) null, (String) null, (String) null);
        }

        private final Map d(JSONObject jSONObject) {
            int optInt;
            HashSet hashSet;
            JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (!(optJSONObject == null || (optInt = optJSONObject.optInt(Constant.PARAM_OAUTH_CODE)) == 0)) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                        hashSet = null;
                    } else {
                        hashSet = new HashSet();
                        int length2 = optJSONArray2.length();
                        for (int i11 = 0; i11 < length2; i11++) {
                            int optInt2 = optJSONArray2.optInt(i11);
                            if (optInt2 != 0) {
                                hashSet.add(Integer.valueOf(optInt2));
                            }
                        }
                    }
                    hashMap.put(Integer.valueOf(optInt), hashSet);
                }
            }
            return hashMap;
        }

        public final k a(JSONArray jSONArray) {
            String optString;
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            Map map = null;
            Map map2 = null;
            Map map3 = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                    if (j.q(optString, "other", true)) {
                        str = optJSONObject.optString("recovery_message", (String) null);
                        map = d(optJSONObject);
                    } else if (j.q(optString, "transient", true)) {
                        str2 = optJSONObject.optString("recovery_message", (String) null);
                        map2 = d(optJSONObject);
                    } else if (j.q(optString, "login_recoverable", true)) {
                        str3 = optJSONObject.optString("recovery_message", (String) null);
                        map3 = d(optJSONObject);
                    }
                }
            }
            return new k(map, map2, map3, str, str2, str3);
        }

        public final synchronized k b() {
            k a10;
            try {
                if (k.f23357g == null) {
                    k.f23357g = k.f23358h.c();
                }
                a10 = k.f23357g;
                if (a10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
                }
            } catch (Throwable th) {
                throw th;
            }
            return a10;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(Map map, Map map2, Map map3, String str, String str2, String str3) {
        this.f23359a = map;
        this.f23360b = map2;
        this.f23361c = map3;
        this.f23362d = str;
        this.f23363e = str2;
        this.f23364f = str3;
    }

    public final FacebookRequestError.a c(int i10, int i11, boolean z10) {
        Set set;
        Set set2;
        Set set3;
        if (z10) {
            return FacebookRequestError.a.TRANSIENT;
        }
        Map map = this.f23359a;
        if (map != null && map.containsKey(Integer.valueOf(i10)) && ((set3 = (Set) this.f23359a.get(Integer.valueOf(i10))) == null || set3.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.a.OTHER;
        }
        Map map2 = this.f23361c;
        if (map2 != null && map2.containsKey(Integer.valueOf(i10)) && ((set2 = (Set) this.f23361c.get(Integer.valueOf(i10))) == null || set2.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.a.LOGIN_RECOVERABLE;
        }
        Map map3 = this.f23360b;
        if (map3 == null || !map3.containsKey(Integer.valueOf(i10)) || ((set = (Set) this.f23360b.get(Integer.valueOf(i10))) != null && !set.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.a.OTHER;
        }
        return FacebookRequestError.a.TRANSIENT;
    }

    public final String d(FacebookRequestError.a aVar) {
        if (aVar != null) {
            int i10 = l.f23369a[aVar.ordinal()];
            if (i10 == 1) {
                return this.f23362d;
            }
            if (i10 == 2) {
                return this.f23364f;
            }
            if (i10 == 3) {
                return this.f23363e;
            }
        }
        return null;
    }
}

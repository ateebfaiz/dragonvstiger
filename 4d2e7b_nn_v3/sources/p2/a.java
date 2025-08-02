package p2;

import android.util.Patterns;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.d;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map f23075a;

    /* renamed from: b  reason: collision with root package name */
    private static Map f23076b;

    /* renamed from: c  reason: collision with root package name */
    private static Map f23077c;

    /* renamed from: d  reason: collision with root package name */
    private static JSONObject f23078d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f23079e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f23080f = new a();

    private a() {
    }

    public static final float[] a(JSONObject jSONObject, String str) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(jSONObject, "viewHierarchy");
            m.f(str, "appName");
            if (!f23079e) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            try {
                String lowerCase = str.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
                String optString = jSONObject.optString("screenname");
                JSONArray jSONArray = new JSONArray();
                a aVar = f23080f;
                aVar.j(jSONObject2, jSONArray);
                aVar.m(fArr, aVar.i(jSONObject2));
                JSONObject b10 = aVar.b(jSONObject2);
                if (b10 == null) {
                    return null;
                }
                m.e(optString, "screenName");
                String jSONObject3 = jSONObject2.toString();
                m.e(jSONObject3, "viewTree.toString()");
                aVar.m(fArr, aVar.h(b10, jSONArray, optString, jSONObject3, lowerCase));
                return fArr;
            } catch (JSONException unused) {
                return fArr;
            }
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private final JSONObject b(JSONObject jSONObject) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            if (optJSONArray == null) {
                return null;
            }
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                m.e(jSONObject2, "children.getJSONObject(i)");
                JSONObject b10 = b(jSONObject2);
                if (b10 != null) {
                    return b10;
                }
            }
            return null;
        } catch (JSONException unused) {
        } catch (Throwable th) {
            v5.a.b(th, this);
        }
    }

    public static final String c(String str, String str2, String str3) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "buttonText");
            m.f(str2, "activityName");
            m.f(str3, "appName");
            String str4 = str3 + " | " + str2 + ", " + str;
            if (str4 != null) {
                String lowerCase = str4.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void d(File file) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f23078d = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                f23078d = new JSONObject(new String(bArr, d.f797b));
                try {
                    f23075a = i0.i(t.a("ENGLISH", "1"), t.a("GERMAN", ExifInterface.GPS_MEASUREMENT_2D), t.a("SPANISH", ExifInterface.GPS_MEASUREMENT_3D), t.a("JAPANESE", "4"));
                    f23076b = i0.i(t.a("VIEW_CONTENT", "0"), t.a("SEARCH", "1"), t.a("ADD_TO_CART", ExifInterface.GPS_MEASUREMENT_2D), t.a("ADD_TO_WISHLIST", ExifInterface.GPS_MEASUREMENT_3D), t.a("INITIATE_CHECKOUT", "4"), t.a("ADD_PAYMENT_INFO", "5"), t.a("PURCHASE", "6"), t.a("LEAD", "7"), t.a("COMPLETE_REGISTRATION", "8"));
                    f23077c = i0.i(t.a("BUTTON_TEXT", "1"), t.a("PAGE_TITLE", ExifInterface.GPS_MEASUREMENT_2D), t.a("RESOLVED_DOCUMENT_LINK", ExifInterface.GPS_MEASUREMENT_3D), t.a("BUTTON_ID", "4"));
                    f23079e = true;
                } catch (Throwable th) {
                    v5.a.b(th, cls);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final boolean e(JSONObject jSONObject) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            if (((jSONObject.optInt("classtypebitmask") & 1) << 5) > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    public static final boolean f() {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            return f23079e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    private final boolean g(String[] strArr, String[] strArr2) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            for (String str : strArr) {
                for (String K : strArr2) {
                    if (j.K(K, str, false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    private final float[] h(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        String str4 = str2;
        if (v5.a.d(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            int length = jSONArray.length();
            if (length > 1) {
                f10 = ((float) length) - 1.0f;
            } else {
                f10 = 0.0f;
            }
            fArr[3] = f10;
            try {
                int length2 = jSONArray.length();
                for (int i11 = 0; i11 < length2; i11++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                    m.e(jSONObject2, "siblings.getJSONObject(i)");
                    if (e(jSONObject2)) {
                        fArr[9] = fArr[9] + 1.0f;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str5 = str + '|' + str3;
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            n(jSONObject, sb3, sb2);
            String sb4 = sb2.toString();
            m.e(sb4, "hintSB.toString()");
            String sb5 = sb3.toString();
            m.e(sb5, "textSB.toString()");
            if (l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", sb5)) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            fArr[15] = f11;
            if (l("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str5)) {
                f12 = 1.0f;
            } else {
                f12 = 0.0f;
            }
            fArr[16] = f12;
            if (l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", sb4)) {
                f13 = 1.0f;
            } else {
                f13 = 0.0f;
            }
            fArr[17] = f13;
            if (j.K(str4, HintConstants.AUTOFILL_HINT_PASSWORD, false, 2, (Object) null)) {
                f14 = 1.0f;
            } else {
                f14 = 0.0f;
            }
            fArr[18] = f14;
            if (k("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str4)) {
                f15 = 1.0f;
            } else {
                f15 = 0.0f;
            }
            fArr[19] = f15;
            if (k("(?i)(sign in)|login|signIn", str4)) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            fArr[20] = f16;
            if (k("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str4)) {
                f17 = 1.0f;
            } else {
                f17 = 0.0f;
            }
            fArr[21] = f17;
            if (l("ENGLISH", "PURCHASE", "BUTTON_TEXT", sb5)) {
                f18 = 1.0f;
            } else {
                f18 = 0.0f;
            }
            fArr[22] = f18;
            if (l("ENGLISH", "PURCHASE", "PAGE_TITLE", str5)) {
                f19 = 1.0f;
            } else {
                f19 = 0.0f;
            }
            fArr[24] = f19;
            if (k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", sb5)) {
                f20 = 1.0f;
            } else {
                f20 = 0.0f;
            }
            fArr[25] = f20;
            if (k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str5)) {
                f21 = 1.0f;
            } else {
                f21 = 0.0f;
            }
            fArr[27] = f21;
            if (l("ENGLISH", "LEAD", "BUTTON_TEXT", sb5)) {
                f22 = 1.0f;
            } else {
                f22 = 0.0f;
            }
            fArr[28] = f22;
            if (l("ENGLISH", "LEAD", "PAGE_TITLE", str5)) {
                f23 = 1.0f;
            } else {
                f23 = 0.0f;
            }
            fArr[29] = f23;
            return fArr;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final float[] i(JSONObject jSONObject) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            String optString = jSONObject.optString("text");
            m.e(optString, "node.optString(TEXT_KEY)");
            if (optString != null) {
                String lowerCase = optString.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                String optString2 = jSONObject.optString("hint");
                m.e(optString2, "node.optString(HINT_KEY)");
                if (optString2 != null) {
                    String lowerCase2 = optString2.toLowerCase();
                    m.e(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    String optString3 = jSONObject.optString("classname");
                    m.e(optString3, "node.optString(CLASS_NAME_KEY)");
                    if (optString3 != null) {
                        String lowerCase3 = optString3.toLowerCase();
                        m.e(lowerCase3, "(this as java.lang.String).toLowerCase()");
                        int optInt = jSONObject.optInt("inputtype", -1);
                        String[] strArr = {lowerCase, lowerCase2};
                        if (g(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                            fArr[0] = fArr[0] + 1.0f;
                        }
                        if (g(new String[]{HintConstants.AUTOFILL_HINT_PASSWORD, "pwd"}, strArr)) {
                            fArr[1] = fArr[1] + 1.0f;
                        }
                        if (g(new String[]{"tel", HintConstants.AUTOFILL_HINT_PHONE}, strArr)) {
                            fArr[2] = fArr[2] + 1.0f;
                        }
                        if (g(new String[]{FirebaseAnalytics.Event.SEARCH}, strArr)) {
                            fArr[4] = fArr[4] + 1.0f;
                        }
                        if (optInt >= 0) {
                            fArr[5] = fArr[5] + 1.0f;
                        }
                        if (optInt == 3 || optInt == 2) {
                            fArr[6] = fArr[6] + 1.0f;
                        }
                        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                            fArr[7] = fArr[7] + 1.0f;
                        }
                        if (j.K(lowerCase3, "checkbox", false, 2, (Object) null)) {
                            fArr[8] = fArr[8] + 1.0f;
                        }
                        if (g(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                            fArr[10] = fArr[10] + 1.0f;
                        }
                        if (j.K(lowerCase3, "radio", false, 2, (Object) null) && j.K(lowerCase3, "button", false, 2, (Object) null)) {
                            fArr[12] = fArr[12] + 1.0f;
                        }
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
                            int length = optJSONArray.length();
                            for (int i11 = 0; i11 < length; i11++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                                m.e(jSONObject2, "childViews.getJSONObject(i)");
                                m(fArr, i(jSONObject2));
                            }
                        } catch (JSONException unused) {
                        }
                        return fArr;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    private final boolean j(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z10;
        if (v5.a.d(this)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int length = optJSONArray.length();
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i10).optBoolean("is_interacted")) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
            boolean z11 = z10;
            JSONArray jSONArray2 = new JSONArray();
            if (z10) {
                int length2 = optJSONArray.length();
                for (int i11 = 0; i11 < length2; i11++) {
                    jSONArray.put(optJSONArray.getJSONObject(i11));
                }
            } else {
                int length3 = optJSONArray.length();
                for (int i12 = 0; i12 < length3; i12++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i12);
                    m.e(jSONObject2, "child");
                    if (j(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z11 = true;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z11;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    private final boolean k(String str, String str2) {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[Catch:{ all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean l(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            boolean r0 = v5.a.d(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONObject r0 = f23078d     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0014
            java.lang.String r2 = "rules"
            kotlin.jvm.internal.m.u(r2)     // Catch:{ all -> 0x0012 }
            goto L_0x0014
        L_0x0012:
            r5 = move-exception
            goto L_0x0073
        L_0x0014:
            java.lang.String r2 = "rulesForLanguage"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x006a
            java.util.Map r2 = f23075a     // Catch:{ all -> 0x0012 }
            if (r2 != 0) goto L_0x0025
            java.lang.String r3 = "languageInfo"
            kotlin.jvm.internal.m.u(r3)     // Catch:{ all -> 0x0012 }
        L_0x0025:
            java.lang.Object r5 = r2.get(r5)     // Catch:{ all -> 0x0012 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0012 }
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x006a
            java.lang.String r0 = "rulesForEvent"
            org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x006a
            java.util.Map r0 = f23076b     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0042
            java.lang.String r2 = "eventInfo"
            kotlin.jvm.internal.m.u(r2)     // Catch:{ all -> 0x0012 }
        L_0x0042:
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0012 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0012 }
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x006a
            java.lang.String r6 = "positiveRules"
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x006a
            java.util.Map r6 = f23077c     // Catch:{ all -> 0x0012 }
            if (r6 != 0) goto L_0x005f
            java.lang.String r0 = "textTypeInfo"
            kotlin.jvm.internal.m.u(r0)     // Catch:{ all -> 0x0012 }
        L_0x005f:
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0012 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0012 }
            java.lang.String r5 = r5.optString(r6)     // Catch:{ all -> 0x0012 }
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            if (r5 != 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            boolean r1 = r4.k(r5, r8)     // Catch:{ all -> 0x0012 }
        L_0x0072:
            return r1
        L_0x0073:
            v5.a.b(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.l(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private final void m(float[] fArr, float[] fArr2) {
        if (!v5.a.d(this)) {
            try {
                int length = fArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    fArr[i10] = fArr[i10] + fArr2[i10];
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void n(JSONObject jSONObject, StringBuilder sb2, StringBuilder sb3) {
        if (!v5.a.d(this)) {
            try {
                String optString = jSONObject.optString("text", "");
                m.e(optString, "view.optString(TEXT_KEY, \"\")");
                if (optString != null) {
                    String lowerCase = optString.toLowerCase();
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    String optString2 = jSONObject.optString("hint", "");
                    m.e(optString2, "view.optString(HINT_KEY, \"\")");
                    if (optString2 != null) {
                        String lowerCase2 = optString2.toLowerCase();
                        m.e(lowerCase2, "(this as java.lang.String).toLowerCase()");
                        if (lowerCase.length() > 0) {
                            sb2.append(lowerCase);
                            sb2.append(" ");
                        }
                        if (lowerCase2.length() > 0) {
                            sb3.append(lowerCase2);
                            sb3.append(" ");
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i10 = 0; i10 < length; i10++) {
                                try {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                                    m.e(jSONObject2, "currentChildView");
                                    n(jSONObject2, sb2, sb3);
                                } catch (JSONException unused) {
                                }
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}

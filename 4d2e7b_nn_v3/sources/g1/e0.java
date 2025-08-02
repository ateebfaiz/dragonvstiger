package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.push.api.TagMessage;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import z1.a;

public class e0 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e0 f21583c;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f21584b = new ConcurrentHashMap();

    public static e0 j() {
        if (f21583c == null) {
            synchronized (e0.class) {
                f21583c = new e0();
            }
        }
        return f21583c;
    }

    public final int b(int i10) {
        switch (i10) {
            case 3984:
                return 3016;
            case 3985:
                return 3015;
            case 3986:
                return 3014;
            case 3987:
                return 3013;
            case 3988:
                return 3012;
            case 3989:
                return 3011;
            default:
                return 0;
        }
    }

    public final int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return a.C0362a.f25001d;
        }
        if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
            return a.C0362a.f25001d;
        }
        try {
            if (str.getBytes(o1.a.f22951b).length > 40) {
                return a.C0362a.f25002e;
            }
            return 0;
        } catch (Throwable th) {
            s1.a.h("MTTagBusiness", "getBytes failed " + th.getMessage());
            return 0;
        }
    }

    public final int d(String[] strArr) {
        int a10 = a();
        if (a10 != 0) {
            return a10;
        }
        if (strArr.length > 1000) {
            return a.C0362a.f25003f;
        }
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            if (TextUtils.isEmpty(str)) {
                return a.C0362a.f25001d;
            }
            if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
                return a.C0362a.f25001d;
            }
            try {
                int length2 = str.getBytes(o1.a.f22951b).length;
                if (length2 > 40) {
                    return a.C0362a.f25002e;
                }
                i11 += length2;
                i10++;
            } catch (Throwable th) {
                s1.a.h("MTTagBusiness", "getBytes failed " + th.getMessage());
            }
        }
        if (i11 > 5000) {
            return a.C0362a.f25004g;
        }
        return 0;
    }

    public final TagMessage e(Context context, int i10, int i11, int i12, int i13, String[] strArr) {
        if (!(i13 == 0 || i12 == 0)) {
            try {
                if (this.f21584b.containsKey(Integer.valueOf(i11))) {
                    String[] strArr2 = (String[]) this.f21584b.get(Integer.valueOf(i11));
                    String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + strArr2.length);
                    System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
                    strArr = strArr3;
                }
                if (i12 < i13) {
                    this.f21584b.put(Integer.valueOf(i11), strArr);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("platform", "a");
                    jSONObject.put("op", "valid");
                    jSONObject.put("curr", i12 + 1);
                    String jSONObject2 = jSONObject.toString();
                    s1.a.a("MTTagBusiness", "sendTagOperation sequence:" + i11 + ", content:" + s1.a.g(jSONObject));
                    MTProtocol i14 = new MTProtocol().h((long) i11).g(28).j(1).f(d.d(jSONObject2)).i(y1.a.f24870a);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("protocol", i14);
                    h1.a.j(context, 2222, bundle);
                    return null;
                }
                this.f21584b.remove(Integer.valueOf(i11));
                return new TagMessage().d(i11).a(i10).e(strArr);
            } catch (Throwable th) {
                s1.a.h("MTTagBusiness", "onTagQueryAll failed " + th.getMessage());
            }
        }
        return null;
    }

    public void f(Context context, int i10, Bundle bundle) {
        MTCommonReceiver f10;
        try {
            bundle.setClassLoader(TagMessage.class.getClassLoader());
            TagMessage tagMessage = (TagMessage) bundle.getParcelable("tag");
            if (tagMessage != null && (f10 = p1.a.f(context)) != null) {
                switch (i10) {
                    case 3011:
                    case 3012:
                    case 3013:
                    case 3014:
                    case 3015:
                    case 3016:
                        f10.onTagMessage(context, tagMessage);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTTagBusiness", "processMainMessage failed " + th.getMessage());
        }
    }

    public void g(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            if (mTProtocol != null) {
                int c10 = (int) mTProtocol.c();
                this.f21584b.remove(Integer.valueOf(c10));
                TagMessage e10 = new TagMessage().d(c10).a(a.C0362a.f24998a).e((String[]) this.f21584b.get(Integer.valueOf(c10)));
                s1.a.a("MTTagBusiness", "onAliasOperationFailed sequence:" + c10 + ", tagMessage:" + e10.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("tag", e10);
                h1.a.i(context, 3011, bundle2);
            }
        } catch (Throwable th) {
            s1.a.h("MTTagBusiness", "onAliasOperationFailed failed " + th.getMessage());
        }
    }

    public final String[] h(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            strArr[i10] = jSONArray.optString(i10);
        }
        return strArr;
    }

    public final int i(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 96417:
                if (str.equals("add")) {
                    c10 = 0;
                    break;
                }
                break;
            case 99339:
                if (str.equals("del")) {
                    c10 = 1;
                    break;
                }
                break;
            case 102230:
                if (str.equals("get")) {
                    c10 = 2;
                    break;
                }
                break;
            case 113762:
                if (str.equals("set")) {
                    c10 = 3;
                    break;
                }
                break;
            case 94746185:
                if (str.equals("clean")) {
                    c10 = 4;
                    break;
                }
                break;
            case 111972348:
                if (str.equals("valid")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return 3011;
            case 1:
                return 3012;
            case 2:
                return 3016;
            case 3:
                return 3013;
            case 4:
                return 3015;
            case 5:
                return 3014;
            default:
                return 0;
        }
    }

    public final String k(int i10) {
        switch (i10) {
            case 3984:
                return "get";
            case 3985:
                return "clean";
            case 3986:
                return "valid";
            case 3987:
                return "set";
            case 3988:
                return "del";
            case 3989:
                return "add";
            default:
                return "";
        }
    }

    public final JSONArray l(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public void m(Context context, int i10, Bundle bundle) {
        try {
            int i11 = bundle.getInt("sequence");
            String k10 = k(i10);
            int b10 = b(i10);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            jSONObject.put("op", k10);
            switch (i10) {
                case 3984:
                    jSONObject.put("curr", 1);
                    break;
                case 3986:
                    String string = bundle.getString("tag");
                    int c10 = c(string);
                    if (c10 == 0) {
                        this.f21584b.put(Integer.valueOf(i11), new String[]{string});
                        jSONObject.put("tags", string);
                        break;
                    } else {
                        TagMessage b11 = new TagMessage().d(i11).a(c10).b(string);
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("tag", b11);
                        h1.a.i(context, b10, bundle2);
                        return;
                    }
                case 3987:
                case 3988:
                case 3989:
                    String[] stringArray = bundle.getStringArray("tag");
                    int d10 = d(stringArray);
                    if (d10 == 0) {
                        this.f21584b.put(Integer.valueOf(i11), stringArray);
                        jSONObject.put("tags", l(stringArray));
                        break;
                    } else {
                        TagMessage e10 = new TagMessage().d(i11).a(d10).e(stringArray);
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("tag", e10);
                        h1.a.i(context, b10, bundle3);
                        return;
                    }
            }
            s1.a.a("MTTagBusiness", "sendAliasOperation sequence:" + i11 + ", content:" + s1.a.g(jSONObject));
            byte[] d11 = d.d(jSONObject.toString());
            if (d11 != null) {
                MTProtocol i12 = new MTProtocol().h((long) i11).g(28).j(1).f(d11).i(y1.a.f24870a);
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("protocol", i12);
                h1.a.j(context, 2222, bundle4);
            }
        } catch (Throwable th) {
            s1.a.h("MTTagBusiness", "sendTagOperation failed " + th.getMessage());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(android.content.Context r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r0 = "MTTagBusiness"
            java.lang.String r1 = "protocol"
            android.os.Parcelable r14 = r14.getParcelable(r1)     // Catch:{ all -> 0x0077 }
            com.engagelab.privates.core.api.MTProtocol r14 = (com.engagelab.privates.core.api.MTProtocol) r14     // Catch:{ all -> 0x0077 }
            if (r14 != 0) goto L_0x000d
            return
        L_0x000d:
            long r1 = r14.c()     // Catch:{ all -> 0x0077 }
            int r6 = (int) r1     // Catch:{ all -> 0x0077 }
            byte[] r14 = r14.a()     // Catch:{ all -> 0x0077 }
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.wrap(r14)     // Catch:{ all -> 0x0077 }
            java.lang.String r14 = u1.m.f(r14)     // Catch:{ all -> 0x0077 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0077 }
            r1.<init>(r14)     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r14.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "onTagOperationSuccess sequence:"
            r14.append(r2)     // Catch:{ all -> 0x0077 }
            r14.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = ", content:"
            r14.append(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = s1.a.g(r1)     // Catch:{ all -> 0x0077 }
            r14.append(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0077 }
            s1.a.a(r0, r14)     // Catch:{ all -> 0x0077 }
            java.lang.String r14 = "code"
            int r5 = r1.optInt(r14)     // Catch:{ all -> 0x0077 }
            com.engagelab.privates.push.api.TagMessage r14 = new com.engagelab.privates.push.api.TagMessage     // Catch:{ all -> 0x0077 }
            r14.<init>()     // Catch:{ all -> 0x0077 }
            com.engagelab.privates.push.api.TagMessage r14 = r14.d(r6)     // Catch:{ all -> 0x0077 }
            com.engagelab.privates.push.api.TagMessage r14 = r14.a(r5)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "op"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ all -> 0x0077 }
            int r10 = r12.i(r2)     // Catch:{ all -> 0x0077 }
            int r3 = r2.hashCode()     // Catch:{ all -> 0x0077 }
            r4 = 0
            r7 = 1
            r8 = 5
            r9 = 2
            r11 = 3
            switch(r3) {
                case 96417: goto L_0x00a2;
                case 99339: goto L_0x0098;
                case 102230: goto L_0x008e;
                case 113762: goto L_0x0084;
                case 94746185: goto L_0x007a;
                case 111972348: goto L_0x006d;
                default: goto L_0x006c;
            }     // Catch:{ all -> 0x0077 }
        L_0x006c:
            goto L_0x00ac
        L_0x006d:
            java.lang.String r3 = "valid"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = r11
            goto L_0x00ad
        L_0x0077:
            r13 = move-exception
            goto L_0x013b
        L_0x007a:
            java.lang.String r3 = "clean"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = 4
            goto L_0x00ad
        L_0x0084:
            java.lang.String r3 = "set"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = r9
            goto L_0x00ad
        L_0x008e:
            java.lang.String r3 = "get"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = r8
            goto L_0x00ad
        L_0x0098:
            java.lang.String r3 = "del"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = r7
            goto L_0x00ad
        L_0x00a2:
            java.lang.String r3 = "add"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x00ac
            r2 = r4
            goto L_0x00ad
        L_0x00ac:
            r2 = -1
        L_0x00ad:
            if (r2 == 0) goto L_0x00fa
            if (r2 == r7) goto L_0x00fa
            if (r2 == r9) goto L_0x00fa
            if (r2 == r11) goto L_0x00d5
            if (r2 == r8) goto L_0x00b8
            goto L_0x0112
        L_0x00b8:
            java.lang.String r14 = "tags"
            org.json.JSONArray r14 = r1.optJSONArray(r14)     // Catch:{ all -> 0x0077 }
            java.lang.String[] r9 = r12.h(r14)     // Catch:{ all -> 0x0077 }
            java.lang.String r14 = "total"
            int r8 = r1.optInt(r14)     // Catch:{ all -> 0x0077 }
            java.lang.String r14 = "curr"
            int r7 = r1.optInt(r14)     // Catch:{ all -> 0x0077 }
            r3 = r12
            r4 = r13
            com.engagelab.privates.push.api.TagMessage r14 = r3.e(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0077 }
            goto L_0x0112
        L_0x00d5:
            java.util.concurrent.ConcurrentHashMap r2 = r12.f21584b     // Catch:{ all -> 0x0077 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0077 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String[] r2 = (java.lang.String[]) r2     // Catch:{ all -> 0x0077 }
            r2 = r2[r4]     // Catch:{ all -> 0x0077 }
            java.util.concurrent.ConcurrentHashMap r3 = r12.f21584b     // Catch:{ all -> 0x0077 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0077 }
            r3.remove(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "validated"
            boolean r1 = r1.optBoolean(r3)     // Catch:{ all -> 0x0077 }
            com.engagelab.privates.push.api.TagMessage r2 = r14.b(r2)     // Catch:{ all -> 0x0077 }
            r2.c(r1)     // Catch:{ all -> 0x0077 }
            goto L_0x0112
        L_0x00fa:
            java.util.concurrent.ConcurrentHashMap r1 = r12.f21584b     // Catch:{ all -> 0x0077 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x0077 }
            java.util.concurrent.ConcurrentHashMap r2 = r12.f21584b     // Catch:{ all -> 0x0077 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0077 }
            r2.remove(r3)     // Catch:{ all -> 0x0077 }
            r14.e(r1)     // Catch:{ all -> 0x0077 }
        L_0x0112:
            if (r14 != 0) goto L_0x0115
            return
        L_0x0115:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r1.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "onTagOperationSuccess tagMessage:"
            r1.append(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = r14.toString()     // Catch:{ all -> 0x0077 }
            r1.append(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0077 }
            s1.a.a(r0, r1)     // Catch:{ all -> 0x0077 }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0077 }
            r1.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "tag"
            r1.putParcelable(r2, r14)     // Catch:{ all -> 0x0077 }
            h1.a.i(r13, r10, r1)     // Catch:{ all -> 0x0077 }
            goto L_0x0153
        L_0x013b:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "onTagOperationSuccess failed "
            r14.append(r1)
            java.lang.String r13 = r13.getMessage()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            s1.a.h(r0, r13)
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.e0.n(android.content.Context, android.os.Bundle):void");
    }
}

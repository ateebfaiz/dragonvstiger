package i9;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Map f12367b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final k f12368c = new k(Scopes.PROFILE);

    /* renamed from: d  reason: collision with root package name */
    public static final k f12369d = new k("friends");

    /* renamed from: e  reason: collision with root package name */
    public static final k f12370e = new k("groups");

    /* renamed from: f  reason: collision with root package name */
    public static final k f12371f = new k("message.write");

    /* renamed from: g  reason: collision with root package name */
    public static final k f12372g = new k(Scopes.OPEN_ID);

    /* renamed from: h  reason: collision with root package name */
    public static final k f12373h = new k("email");

    /* renamed from: i  reason: collision with root package name */
    public static final k f12374i = new k(HintConstants.AUTOFILL_HINT_PHONE);

    /* renamed from: j  reason: collision with root package name */
    public static final k f12375j = new k(HintConstants.AUTOFILL_HINT_GENDER);

    /* renamed from: k  reason: collision with root package name */
    public static final k f12376k = new k("birthdate");

    /* renamed from: l  reason: collision with root package name */
    public static final k f12377l = new k("address");

    /* renamed from: m  reason: collision with root package name */
    public static final k f12378m = new k("real_name");

    /* renamed from: n  reason: collision with root package name */
    public static final k f12379n = new k("onetime.share");

    /* renamed from: a  reason: collision with root package name */
    private final String f12380a;

    protected k(String str) {
        Map map = f12367b;
        if (!map.containsKey(str)) {
            this.f12380a = str;
            map.put(str, this);
            return;
        }
        throw new IllegalArgumentException("Scope code already exists: " + str);
    }

    public static List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((k) it.next()).f12380a);
        }
        return arrayList;
    }

    public static List b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k c10 = c((String) it.next());
            if (c10 != null) {
                arrayList.add(c10);
            }
        }
        return arrayList;
    }

    public static k c(String str) {
        return (k) f12367b.get(str);
    }

    public static String d(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(" ", a(list));
    }

    public static List e(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        return b(Arrays.asList(str.split(" ")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f12380a.equals(((k) obj).f12380a);
    }

    public int hashCode() {
        return this.f12380a.hashCode();
    }

    public String toString() {
        return "Scope{code='" + this.f12380a + '\'' + '}';
    }
}

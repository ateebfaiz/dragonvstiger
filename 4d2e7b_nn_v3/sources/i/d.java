package i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f21998a = w.d.f("");

    public static JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put((String) it.next());
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    public static boolean b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String[] c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            strArr[i10] = jSONArray.getString(i10);
        }
        return strArr;
    }

    public static List d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                arrayList.add(jSONArray.getString(i10));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }
}

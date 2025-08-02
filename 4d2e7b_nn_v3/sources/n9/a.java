package n9;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public abstract class a {
    public static List a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }
}

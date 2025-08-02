package n7;

import android.view.View;
import android.view.ViewGroup;
import c.d;
import com.facebook.react.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final List f12826a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f12827b = new HashMap();

    public static View a(View view, String str) {
        String b10 = b(view);
        if (b10 != null && b10.equals(str)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View a10 = a(viewGroup.getChildAt(i10), str);
            if (a10 != null) {
                return a10;
            }
        }
        return null;
    }

    private static String b(View view) {
        Object tag = view.getTag(m.C);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static void c(View view) {
        String b10 = b(view);
        if (b10 != null) {
            Iterator it = f12826a.iterator();
            if (!it.hasNext()) {
                for (Map.Entry entry : f12827b.entrySet()) {
                    Set set = (Set) entry.getValue();
                    if (set != null && set.contains(b10)) {
                        d.a(entry.getKey());
                        throw null;
                    }
                }
                return;
            }
            d.a(it.next());
            throw null;
        }
    }
}

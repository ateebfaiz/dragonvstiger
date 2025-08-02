package o;

import android.content.Context;
import android.content.SharedPreferences;
import g.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import w.d;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final String f22860b = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final Context f22861a;

    public c(Context context) {
        this.f22861a = context;
    }

    public void a(a aVar) {
        synchronized (this) {
            SharedPreferences.Editor edit = this.f22861a.getSharedPreferences("mahx_crash_preference", 0).edit();
            edit.remove(aVar.f22835a);
            edit.commit();
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            SharedPreferences.Editor edit = this.f22861a.getSharedPreferences("mahx_crash_preference", 0).edit();
            edit.putString(aVar.f22835a, aVar.f());
            edit.commit();
        }
        if (aVar.f22837c && !aVar.f22839e && !aVar.f22840f) {
            m.a(this.f22861a).l(true);
        }
    }

    public List c() {
        Map<String, ?> all;
        SharedPreferences sharedPreferences = this.f22861a.getSharedPreferences("mahx_crash_preference", 0);
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            all = sharedPreferences.getAll();
        }
        for (Object next : all.values()) {
            if (next instanceof String) {
                try {
                    arrayList.add(a.b((String) next));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }
}

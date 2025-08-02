package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;
import kotlin.Pair;

public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairArr) {
        PersistableBundle a10 = p.a(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            p.b(a10, (String) pair.a(), pair.b());
        }
        return a10;
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> map) {
        PersistableBundle a10 = p.a(map.size());
        for (Map.Entry next : map.entrySet()) {
            p.b(a10, (String) next.getKey(), next.getValue());
        }
        return a10;
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return p.a(0);
    }
}

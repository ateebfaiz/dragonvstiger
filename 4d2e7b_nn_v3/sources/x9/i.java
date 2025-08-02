package x9;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class i {

    /* renamed from: a  reason: collision with root package name */
    static final Map f13295a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(h.f13292b, new HashSet(Arrays.asList(new f[]{f.SIGN, f.VERIFY})));
        hashMap.put(h.f13293c, new HashSet(Arrays.asList(new f[]{f.ENCRYPT, f.DECRYPT, f.WRAP_KEY, f.UNWRAP_KEY})));
        f13295a = Collections.unmodifiableMap(hashMap);
    }

    static boolean a(h hVar, Set set) {
        if (hVar == null || set == null) {
            return true;
        }
        Map map = f13295a;
        if (!map.containsKey(hVar) || ((Set) map.get(hVar)).containsAll(set)) {
            return true;
        }
        return false;
    }
}

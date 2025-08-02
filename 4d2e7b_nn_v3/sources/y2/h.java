package y2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class h extends HashSet {
    private h(Set set) {
        super(set);
    }

    public static h a(Object... objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        Collections.addAll(hashSet, objArr);
        return new h(hashSet);
    }
}

package y2;

import java.util.ArrayList;
import java.util.Collections;

public class f extends ArrayList {
    private f(int i10) {
        super(i10);
    }

    public static f a(Object... objArr) {
        f fVar = new f(objArr.length);
        Collections.addAll(fVar, objArr);
        return fVar;
    }
}

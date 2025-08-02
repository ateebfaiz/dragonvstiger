package pb;

import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.m;

public abstract class a {
    public static final EnumEntries a(Enum[] enumArr) {
        m.f(enumArr, "entries");
        return new b(enumArr);
    }
}

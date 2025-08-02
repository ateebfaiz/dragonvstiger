package pb;

import java.io.Serializable;
import kotlin.collections.c;
import kotlin.collections.j;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.m;

final class b extends c implements EnumEntries, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Enum[] f1801a;

    public b(Enum[] enumArr) {
        m.f(enumArr, "entries");
        this.f1801a = enumArr;
    }

    private final Object writeReplace() {
        return new c(this.f1801a);
    }

    public boolean a(Enum enumR) {
        m.f(enumR, "element");
        if (((Enum) j.C(this.f1801a, enumR.ordinal())) == enumR) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public Enum get(int i10) {
        c.Companion.a(i10, this.f1801a.length);
        return this.f1801a[i10];
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return a((Enum) obj);
    }

    public int d(Enum enumR) {
        m.f(enumR, "element");
        int ordinal = enumR.ordinal();
        if (((Enum) j.C(this.f1801a, ordinal)) == enumR) {
            return ordinal;
        }
        return -1;
    }

    public int e(Enum enumR) {
        m.f(enumR, "element");
        return indexOf(enumR);
    }

    public int getSize() {
        return this.f1801a.length;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return d((Enum) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return e((Enum) obj);
    }
}

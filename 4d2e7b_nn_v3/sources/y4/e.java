package y4;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum e {
    LOW,
    MEDIUM,
    HIGH;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f24920a = null;

    public static final class a {
        private a() {
        }

        public final e a(e eVar, e eVar2) {
            m.f(eVar, "priority1");
            m.f(eVar2, "priority2");
            if (eVar.ordinal() > eVar2.ordinal()) {
                return eVar;
            }
            return eVar2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f24920a = new a((DefaultConstructorMarker) null);
    }

    public static final e b(e eVar, e eVar2) {
        return f24920a.a(eVar, eVar2);
    }
}

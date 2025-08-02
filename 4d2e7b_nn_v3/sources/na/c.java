package na;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.j;

public enum c {
    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f12839a = null;

    public static final class a {
        private a() {
        }

        public final c a(String str) {
            c cVar = null;
            if (str != null) {
                c[] values = c.values();
                int length = values.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    c cVar2 = values[length];
                    if (j.q(cVar2.name(), str, true)) {
                        cVar = cVar2;
                        break;
                    }
                }
            }
            if (cVar == null) {
                return c.UNATTRIBUTED;
            }
            return cVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f12839a = new a((DefaultConstructorMarker) null);
    }

    public final boolean b() {
        if (c() || e()) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        if (this == DIRECT) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (this == DISABLED) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (this == INDIRECT) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this == UNATTRIBUTED) {
            return true;
        }
        return false;
    }
}

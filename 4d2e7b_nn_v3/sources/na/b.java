package na;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum b {
    IAM("iam"),
    NOTIFICATION("notification");
    

    /* renamed from: b  reason: collision with root package name */
    public static final a f12834b = null;

    /* renamed from: a  reason: collision with root package name */
    private final String f12838a;

    public static final class a {
        private a() {
        }

        public final b a(String str) {
            b bVar = null;
            if (str != null) {
                b[] values = b.values();
                int length = values.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    b bVar2 = values[length];
                    if (bVar2.b(str)) {
                        bVar = bVar2;
                        break;
                    }
                }
            }
            if (bVar == null) {
                return b.NOTIFICATION;
            }
            return bVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f12834b = new a((DefaultConstructorMarker) null);
    }

    private b(String str) {
        this.f12838a = str;
    }

    public final boolean b(String str) {
        m.f(str, "otherName");
        return m.b(this.f12838a, str);
    }

    public String toString() {
        return this.f12838a;
    }
}

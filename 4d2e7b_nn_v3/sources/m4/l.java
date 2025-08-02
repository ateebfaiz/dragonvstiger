package m4;

import kotlin.jvm.internal.DefaultConstructorMarker;

public enum l {
    UNKNOWN(-1),
    VISIBLE(1),
    INVISIBLE(2);
    

    /* renamed from: b  reason: collision with root package name */
    public static final a f22605b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final l[] f22606c = null;

    /* renamed from: a  reason: collision with root package name */
    private final int f22611a;

    public static final class a {
        private a() {
        }

        public final l a(int i10) {
            for (l lVar : l.f22606c) {
                if (lVar.c() == i10) {
                    return lVar;
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f22605b = new a((DefaultConstructorMarker) null);
        f22606c = values();
    }

    private l(int i10) {
        this.f22611a = i10;
    }

    public final int c() {
        return this.f22611a;
    }
}

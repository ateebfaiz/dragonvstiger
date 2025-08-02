package q5;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.EnumSet;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum j0 {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final EnumSet f23354f = null;

    /* renamed from: g  reason: collision with root package name */
    public static final a f23355g = null;

    /* renamed from: a  reason: collision with root package name */
    private final long f23356a;

    public static final class a {
        private a() {
        }

        public final EnumSet a(long j10) {
            EnumSet<E> noneOf = EnumSet.noneOf(j0.class);
            Iterator it = j0.f23354f.iterator();
            while (it.hasNext()) {
                j0 j0Var = (j0) it.next();
                if ((j0Var.b() & j10) != 0) {
                    noneOf.add(j0Var);
                }
            }
            m.e(noneOf, DbParams.KEY_CHANNEL_RESULT);
            return noneOf;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f23355g = new a((DefaultConstructorMarker) null);
        EnumSet<E> allOf = EnumSet.allOf(j0.class);
        m.e(allOf, "EnumSet.allOf(SmartLoginOption::class.java)");
        f23354f = allOf;
    }

    private j0(long j10) {
        this.f23356a = j10;
    }

    public final long b() {
        return this.f23356a;
    }
}

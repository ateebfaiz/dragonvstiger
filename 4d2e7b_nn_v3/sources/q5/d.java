package q5;

import android.content.Intent;
import com.facebook.g;
import com.facebook.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d implements g {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map f23268b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final b f23269c = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Map f23270a = new HashMap();

    public interface a {
        boolean a(int i10, Intent intent);
    }

    public static final class b {
        private b() {
        }

        private final synchronized a b(int i10) {
            return (a) d.f23268b.get(Integer.valueOf(i10));
        }

        /* access modifiers changed from: private */
        public final boolean d(int i10, int i11, Intent intent) {
            a b10 = b(i10);
            if (b10 != null) {
                return b10.a(i11, intent);
            }
            return false;
        }

        public final synchronized void c(int i10, a aVar) {
            m.f(aVar, "callback");
            if (!d.f23268b.containsKey(Integer.valueOf(i10))) {
                d.f23268b.put(Integer.valueOf(i10), aVar);
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum c {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f23281a;

        private c(int i10) {
            this.f23281a = i10;
        }

        public final int a() {
            return o.m() + this.f23281a;
        }
    }

    public static final synchronized void d(int i10, a aVar) {
        synchronized (d.class) {
            f23269c.c(i10, aVar);
        }
    }

    public boolean a(int i10, int i11, Intent intent) {
        a aVar = (a) this.f23270a.get(Integer.valueOf(i10));
        if (aVar != null) {
            return aVar.a(i11, intent);
        }
        return f23269c.d(i10, i11, intent);
    }

    public final void c(int i10, a aVar) {
        m.f(aVar, "callback");
        this.f23270a.put(Integer.valueOf(i10), aVar);
    }
}

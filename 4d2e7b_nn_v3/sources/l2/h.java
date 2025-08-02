package l2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.o;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h {

    /* renamed from: g  reason: collision with root package name */
    public static final a f22435g = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f22436a;

    /* renamed from: b  reason: collision with root package name */
    private Long f22437b;

    /* renamed from: c  reason: collision with root package name */
    private j f22438c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f22439d;

    /* renamed from: e  reason: collision with root package name */
    private Long f22440e;

    /* renamed from: f  reason: collision with root package name */
    private UUID f22441f;

    public static final class a {
        private a() {
        }

        public final void a() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
            edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
            edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
            edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
            edit.remove("com.facebook.appevents.SessionInfo.sessionId");
            edit.apply();
            j.f22445c.a();
        }

        public final h b() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
            long j10 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
            long j11 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
            String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", (String) null);
            if (j10 == 0 || j11 == 0 || string == null) {
                return null;
            }
            h hVar = new h(Long.valueOf(j10), Long.valueOf(j11), (UUID) null, 4, (DefaultConstructorMarker) null);
            hVar.f22436a = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
            hVar.l(j.f22445c.b());
            hVar.i(Long.valueOf(System.currentTimeMillis()));
            UUID fromString = UUID.fromString(string);
            m.e(fromString, "UUID.fromString(sessionIDStr)");
            hVar.j(fromString);
            return hVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(Long l10, Long l11, UUID uuid) {
        m.f(uuid, "sessionId");
        this.f22439d = l10;
        this.f22440e = l11;
        this.f22441f = uuid;
    }

    public final Long b() {
        long j10;
        Long l10 = this.f22437b;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = 0;
        }
        return Long.valueOf(j10);
    }

    public final int c() {
        return this.f22436a;
    }

    public final UUID d() {
        return this.f22441f;
    }

    public final Long e() {
        return this.f22440e;
    }

    public final long f() {
        Long l10;
        if (this.f22439d == null || (l10 = this.f22440e) == null) {
            return 0;
        }
        if (l10 != null) {
            return l10.longValue() - this.f22439d.longValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final j g() {
        return this.f22438c;
    }

    public final void h() {
        this.f22436a++;
    }

    public final void i(Long l10) {
        this.f22437b = l10;
    }

    public final void j(UUID uuid) {
        m.f(uuid, "<set-?>");
        this.f22441f = uuid;
    }

    public final void k(Long l10) {
        this.f22440e = l10;
    }

    public final void l(j jVar) {
        this.f22438c = jVar;
    }

    public final void m() {
        long j10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
        Long l10 = this.f22439d;
        long j11 = 0;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = 0;
        }
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", j10);
        Long l11 = this.f22440e;
        if (l11 != null) {
            j11 = l11.longValue();
        }
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", j11);
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f22436a);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f22441f.toString());
        edit.apply();
        j jVar = this.f22438c;
        if (jVar != null && jVar != null) {
            jVar.a();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ h(java.lang.Long r1, java.lang.Long r2, java.util.UUID r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000d
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r4 = "UUID.randomUUID()"
            kotlin.jvm.internal.m.e(r3, r4)
        L_0x000d:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.h.<init>(java.lang.Long, java.lang.Long, java.util.UUID, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

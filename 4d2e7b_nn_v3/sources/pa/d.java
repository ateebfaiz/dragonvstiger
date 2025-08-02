package pa;

import androidx.core.app.NotificationCompat;
import com.onesignal.c2;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;
import qa.b;
import qa.c;

public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f12904a;

    /* renamed from: b  reason: collision with root package name */
    private final a f12905b;

    /* renamed from: c  reason: collision with root package name */
    private final j f12906c;

    public d(c2 c2Var, a aVar, j jVar) {
        m.f(c2Var, "logger");
        m.f(aVar, "outcomeEventsCache");
        m.f(jVar, "outcomeEventsService");
        this.f12904a = c2Var;
        this.f12905b = aVar;
        this.f12906c = jVar;
    }

    public void a(b bVar) {
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        this.f12905b.k(bVar);
    }

    public void b(b bVar) {
        m.f(bVar, "eventParams");
        this.f12905b.m(bVar);
    }

    public List c(String str, List list) {
        m.f(str, "name");
        m.f(list, "influences");
        List g10 = this.f12905b.g(str, list);
        this.f12904a.b(m.n("OneSignal getNotCachedUniqueOutcome influences: ", g10));
        return g10;
    }

    public List d() {
        return this.f12905b.e();
    }

    public void e(Set set) {
        m.f(set, "unattributedUniqueOutcomeEvents");
        this.f12904a.b(m.n("OneSignal save unattributedUniqueOutcomeEvents: ", set));
        this.f12905b.l(set);
    }

    public void g(String str, String str2) {
        m.f(str, "notificationTableName");
        m.f(str2, "notificationIdColumnName");
        this.f12905b.c(str, str2);
    }

    public Set h() {
        Set i10 = this.f12905b.i();
        this.f12904a.b(m.n("OneSignal getUnattributedUniqueOutcomeEventsSentByChannel: ", i10));
        return i10;
    }

    public void i(b bVar) {
        m.f(bVar, "outcomeEvent");
        this.f12905b.d(bVar);
    }

    /* access modifiers changed from: protected */
    public final c2 j() {
        return this.f12904a;
    }

    public final j k() {
        return this.f12906c;
    }
}

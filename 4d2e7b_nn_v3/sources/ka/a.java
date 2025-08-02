package ka;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.o3;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final o3.v f12566a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12567b;

    public a(o3.v vVar, String str) {
        m.f(vVar, FirebaseAnalytics.Param.LEVEL);
        m.f(str, "entry");
        this.f12566a = vVar;
        this.f12567b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f12566a == aVar.f12566a && m.b(this.f12567b, aVar.f12567b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f12566a.hashCode() * 31) + this.f12567b.hashCode();
    }

    public String toString() {
        return "OneSignalLogEvent(level=" + this.f12566a + ", entry=" + this.f12567b + ')';
    }
}

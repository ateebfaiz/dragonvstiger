package qa;

import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f12918a;

    /* renamed from: b  reason: collision with root package name */
    private final d f12919b;

    /* renamed from: c  reason: collision with root package name */
    private float f12920c;

    /* renamed from: d  reason: collision with root package name */
    private long f12921d;

    public b(String str, d dVar, float f10, long j10) {
        m.f(str, "outcomeId");
        this.f12918a = str;
        this.f12919b = dVar;
        this.f12920c = f10;
        this.f12921d = j10;
    }

    public final String a() {
        return this.f12918a;
    }

    public final d b() {
        return this.f12919b;
    }

    public final long c() {
        return this.f12921d;
    }

    public final float d() {
        return this.f12920c;
    }

    public final boolean e() {
        d dVar = this.f12919b;
        if (dVar == null || (dVar.a() == null && this.f12919b.b() == null)) {
            return true;
        }
        return false;
    }

    public final void f(long j10) {
        this.f12921d = j10;
    }

    public final JSONObject g() {
        JSONObject put = new JSONObject().put("id", this.f12918a);
        d dVar = this.f12919b;
        if (dVar != null) {
            put.put("sources", dVar.g());
        }
        float f10 = this.f12920c;
        if (f10 > 0.0f) {
            put.put("weight", Float.valueOf(f10));
        }
        long j10 = this.f12921d;
        if (j10 > 0) {
            put.put("timestamp", j10);
        }
        m.e(put, "json");
        return put;
    }

    public String toString() {
        return "OSOutcomeEventParams{outcomeId='" + this.f12918a + "', outcomeSource=" + this.f12919b + ", weight=" + this.f12920c + ", timestamp=" + this.f12921d + '}';
    }
}

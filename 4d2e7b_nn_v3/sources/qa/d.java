package qa;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private e f12922a;

    /* renamed from: b  reason: collision with root package name */
    private e f12923b;

    public d(e eVar, e eVar2) {
        this.f12922a = eVar;
        this.f12923b = eVar2;
    }

    public final e a() {
        return this.f12922a;
    }

    public final e b() {
        return this.f12923b;
    }

    public final d c(e eVar) {
        d(eVar);
        return this;
    }

    public final void d(e eVar) {
        this.f12922a = eVar;
    }

    public final d e(e eVar) {
        f(eVar);
        return this;
    }

    public final void f(e eVar) {
        this.f12923b = eVar;
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        e eVar = this.f12922a;
        if (eVar != null) {
            jSONObject.put(DevicePublicKeyStringDef.DIRECT, eVar.e());
        }
        e eVar2 = this.f12923b;
        if (eVar2 != null) {
            jSONObject.put(DevicePublicKeyStringDef.INDIRECT, eVar2.e());
        }
        return jSONObject;
    }

    public String toString() {
        return "OSOutcomeSource{directBody=" + this.f12922a + ", indirectBody=" + this.f12923b + '}';
    }
}

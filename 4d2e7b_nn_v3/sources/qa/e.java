package qa;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f12924a;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f12925b;

    public e() {
        this((JSONArray) null, (JSONArray) null, 3, (DefaultConstructorMarker) null);
    }

    public final JSONArray a() {
        return this.f12925b;
    }

    public final JSONArray b() {
        return this.f12924a;
    }

    public final void c(JSONArray jSONArray) {
        this.f12925b = jSONArray;
    }

    public final void d(JSONArray jSONArray) {
        this.f12924a = jSONArray;
    }

    public final JSONObject e() {
        JSONObject put = new JSONObject().put("notification_ids", this.f12924a).put("in_app_message_ids", this.f12925b);
        m.e(put, "JSONObject()\n        .pu…AM_IDS, inAppMessagesIds)");
        return put;
    }

    public String toString() {
        return "OSOutcomeSourceBody{notificationIds=" + this.f12924a + ", inAppMessagesIds=" + this.f12925b + '}';
    }

    public e(JSONArray jSONArray, JSONArray jSONArray2) {
        this.f12924a = jSONArray;
        this.f12925b = jSONArray2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(JSONArray jSONArray, JSONArray jSONArray2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new JSONArray() : jSONArray, (i10 & 2) != 0 ? new JSONArray() : jSONArray2);
    }
}

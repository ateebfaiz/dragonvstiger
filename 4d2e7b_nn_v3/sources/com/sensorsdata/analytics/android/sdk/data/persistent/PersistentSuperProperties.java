package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistentSuperProperties extends PersistentIdentity<JSONObject> {
    public PersistentSuperProperties() {
        super(DbParams.PersistentName.SUPER_PROPERTIES, new PersistentIdentity.PersistentSerializer<JSONObject>() {
            public JSONObject create() {
                return new JSONObject();
            }

            public JSONObject load(String str) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e10) {
                    SALog.d("Persistent", "failed to load SuperProperties from SharedPreferences.", e10);
                    return new JSONObject();
                }
            }

            public String save(JSONObject jSONObject) {
                if (jSONObject == null) {
                    jSONObject = create();
                }
                return jSONObject.toString();
            }
        });
    }
}

package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class PersistentAppEndData extends PersistentIdentity<String> {
    public PersistentAppEndData() {
        super(DbParams.PersistentName.APP_END_DATA, new PersistentIdentity.PersistentSerializer<String>() {
            public String load(String str) {
                return str;
            }

            public String create() {
                return "";
            }

            public String save(String str) {
                return str == null ? create() : str;
            }
        });
    }
}

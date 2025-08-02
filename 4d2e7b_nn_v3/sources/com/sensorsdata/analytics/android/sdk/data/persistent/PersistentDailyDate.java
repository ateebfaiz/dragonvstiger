package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class PersistentDailyDate extends PersistentIdentity<String> {
    PersistentDailyDate() {
        super(DbParams.PersistentName.PERSISTENT_DAY_DATE, new PersistentIdentity.PersistentSerializer<String>() {
            public String create() {
                return null;
            }

            public String load(String str) {
                return str;
            }

            public String save(String str) {
                return str;
            }
        });
    }
}

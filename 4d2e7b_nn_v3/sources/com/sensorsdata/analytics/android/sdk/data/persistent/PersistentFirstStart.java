package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class PersistentFirstStart extends PersistentIdentity<Boolean> {
    public PersistentFirstStart() {
        super(DbParams.PersistentName.FIRST_START, new PersistentIdentity.PersistentSerializer<Boolean>() {
            public Boolean create() {
                return Boolean.TRUE;
            }

            public Boolean load(String str) {
                return Boolean.FALSE;
            }

            public String save(Boolean bool) {
                return bool == null ? create().toString() : String.valueOf(true);
            }
        });
    }
}

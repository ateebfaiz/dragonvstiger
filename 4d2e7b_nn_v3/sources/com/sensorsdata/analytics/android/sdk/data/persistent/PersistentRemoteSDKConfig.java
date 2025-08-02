package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class PersistentRemoteSDKConfig extends PersistentIdentity<String> {
    public PersistentRemoteSDKConfig() {
        super(DbParams.PersistentName.REMOTE_CONFIG, new PersistentIdentity.PersistentSerializer<String>() {
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

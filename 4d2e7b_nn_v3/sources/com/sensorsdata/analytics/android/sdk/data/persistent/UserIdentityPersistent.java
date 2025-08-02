package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class UserIdentityPersistent extends PersistentIdentity<String> {
    public UserIdentityPersistent() {
        super(DbParams.PersistentName.PERSISTENT_USER_ID, new PersistentIdentity.PersistentSerializer<String>() {
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

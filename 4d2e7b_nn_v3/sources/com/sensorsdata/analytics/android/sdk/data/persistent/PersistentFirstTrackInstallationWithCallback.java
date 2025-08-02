package com.sensorsdata.analytics.android.sdk.data.persistent;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;

public class PersistentFirstTrackInstallationWithCallback extends PersistentIdentity<Boolean> {
    public PersistentFirstTrackInstallationWithCallback() {
        super(DbParams.PersistentName.FIRST_INSTALL_CALLBACK, new PersistentIdentity.PersistentSerializer<Boolean>() {
            public Boolean create() {
                return Boolean.TRUE;
            }

            public Boolean load(String str) {
                return Boolean.FALSE;
            }

            public String save(Boolean bool) {
                return bool == null ? create().toString() : String.valueOf(bool);
            }
        });
    }
}

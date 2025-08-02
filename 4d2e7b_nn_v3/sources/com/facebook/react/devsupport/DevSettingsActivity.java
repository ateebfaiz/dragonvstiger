package com.facebook.react.devsupport;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.react.p;
import com.facebook.react.r;

public final class DevSettingsActivity extends PreferenceActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getApplication().getResources().getString(p.f20898s));
        addPreferencesFromResource(r.f20914a);
    }
}

package com.bugsnag.android.internal;

import android.app.Application;
import android.content.Context;
import c1.i;

public final class BugsnagContentProvider extends AbstractStartupProvider {
    public boolean onCreate() {
        Context context;
        Context context2 = getContext();
        Application application = null;
        if (context2 == null) {
            context = null;
        } else {
            context = context2.getApplicationContext();
        }
        if (context instanceof Application) {
            application = (Application) context;
        }
        if (application == null) {
            return true;
        }
        i.i(application);
        return true;
    }
}

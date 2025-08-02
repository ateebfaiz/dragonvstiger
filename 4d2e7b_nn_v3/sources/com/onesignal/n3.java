package com.onesignal;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import com.onesignal.o3;
import kotlin.jvm.internal.m;

public final class n3 {

    /* renamed from: a  reason: collision with root package name */
    public static final n3 f10820a = new n3();

    private n3() {
    }

    public static final synchronized WorkManager a(Context context) {
        WorkManager workManager;
        synchronized (n3.class) {
            m.f(context, "context");
            try {
                workManager = WorkManager.getInstance(context);
                m.e(workManager, "{\n            WorkManage…stance(context)\n        }");
            } catch (IllegalStateException e10) {
                o3.b(o3.v.ERROR, "OSWorkManagerHelper.getInstance failed, attempting to initialize: ", e10);
                f10820a.b(context);
                workManager = WorkManager.getInstance(context);
                m.e(workManager, "{\n            /*\n       …stance(context)\n        }");
            }
        }
        return workManager;
    }

    private final void b(Context context) {
        Configuration.Provider provider;
        try {
            Context applicationContext = context.getApplicationContext();
            Configuration configuration = null;
            if (applicationContext instanceof Configuration.Provider) {
                provider = (Configuration.Provider) applicationContext;
            } else {
                provider = null;
            }
            if (provider != null) {
                configuration = provider.getWorkManagerConfiguration();
            }
            if (configuration == null) {
                configuration = new Configuration.Builder().build();
            }
            m.e(configuration, "(context.applicationCont…uration.Builder().build()");
            WorkManager.initialize(context, configuration);
        } catch (IllegalStateException e10) {
            o3.b(o3.v.ERROR, "OSWorkManagerHelper initializing WorkManager failed: ", e10);
        }
    }
}

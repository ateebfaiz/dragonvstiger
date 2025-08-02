package androidx.core.content;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

public abstract class UnusedAppRestrictionsBackportService extends Service {
    @SuppressLint({"ActionValue"})
    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub mBinder = new a();

    class a extends IUnusedAppRestrictionsBackportService.Stub {
        a() {
        }

        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
            if (iUnusedAppRestrictionsBackportCallback != null) {
                UnusedAppRestrictionsBackportService.this.isPermissionRevocationEnabled(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void isPermissionRevocationEnabled(@NonNull UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}

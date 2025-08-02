package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import z.b;

public abstract class CustomTabsServiceConnection implements ServiceConnection {

    class a extends CustomTabsClient {
        a(b bVar, ComponentName componentName) {
            super(bVar, componentName);
        }
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onCustomTabsServiceConnected(componentName, new a(b.a.M(iBinder), componentName));
    }
}

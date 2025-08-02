package i1;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22045a;

    public b(Context context) {
        this.f22045a = context;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a.b().g(this.f22045a, iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        a.b().h(this.f22045a);
    }
}

package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import z.c;

public class PostMessageService extends Service {
    private c.a mBinder = new a();

    class a extends c.a {
        a() {
        }

        public void h(z.a aVar, String str, Bundle bundle) {
            aVar.D(str, bundle);
        }

        public void o(z.a aVar, Bundle bundle) {
            aVar.E(bundle);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}

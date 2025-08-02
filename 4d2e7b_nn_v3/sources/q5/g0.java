package q5;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public abstract class g0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23315a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f23316b;

    /* renamed from: c  reason: collision with root package name */
    private b f23317c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23318d;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f23319e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23320f;

    /* renamed from: g  reason: collision with root package name */
    private final int f23321g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23322h;

    /* renamed from: i  reason: collision with root package name */
    private final int f23323i;

    /* renamed from: j  reason: collision with root package name */
    private final String f23324j;

    public static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g0 f23325a;

        a(g0 g0Var) {
            this.f23325a = g0Var;
        }

        public void handleMessage(Message message) {
            if (!v5.a.d(this)) {
                try {
                    m.f(message, "message");
                    this.f23325a.c(message);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public interface b {
        void completed(Bundle bundle);
    }

    public g0(Context context, int i10, int i11, int i12, String str, String str2) {
        m.f(context, "context");
        m.f(str, "applicationId");
        Context applicationContext = context.getApplicationContext();
        this.f23315a = applicationContext != null ? applicationContext : context;
        this.f23320f = i10;
        this.f23321g = i11;
        this.f23322h = str;
        this.f23323i = i12;
        this.f23324j = str2;
        this.f23316b = new a(this);
    }

    private final void a(Bundle bundle) {
        if (this.f23318d) {
            this.f23318d = false;
            b bVar = this.f23317c;
            if (bVar != null) {
                bVar.completed(bundle);
            }
        }
    }

    private final void e() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f23322h);
        String str = this.f23324j;
        if (str != null) {
            bundle.putString("com.facebook.platform.extra.NONCE", str);
        }
        d(bundle);
        Message obtain = Message.obtain((Handler) null, this.f23320f);
        obtain.arg1 = this.f23323i;
        m.e(obtain, "request");
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.f23316b);
        try {
            Messenger messenger = this.f23319e;
            if (messenger != null) {
                messenger.send(obtain);
            }
        } catch (RemoteException unused) {
            a((Bundle) null);
        }
    }

    public final void b() {
        this.f23318d = false;
    }

    /* access modifiers changed from: protected */
    public final void c(Message message) {
        m.f(message, "message");
        if (message.what == this.f23321g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                a((Bundle) null);
            } else {
                a(data);
            }
            try {
                this.f23315a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(Bundle bundle);

    public final void f(b bVar) {
        this.f23317c = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f23318d     // Catch:{ all -> 0x0026 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            int r0 = r3.f23323i     // Catch:{ all -> 0x0026 }
            int r0 = q5.f0.y(r0)     // Catch:{ all -> 0x0026 }
            r2 = -1
            if (r0 != r2) goto L_0x0013
            monitor-exit(r3)
            return r1
        L_0x0013:
            android.content.Context r0 = r3.f23315a     // Catch:{ all -> 0x0026 }
            android.content.Intent r0 = q5.f0.o(r0)     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            r1 = 1
            r3.f23318d = r1     // Catch:{ all -> 0x0026 }
            android.content.Context r2 = r3.f23315a     // Catch:{ all -> 0x0026 }
            r2.bindService(r0, r3, r1)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r3)
            return r1
        L_0x0026:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.g0.g():boolean");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m.f(componentName, "name");
        m.f(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.f23319e = new Messenger(iBinder);
        e();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        m.f(componentName, "name");
        this.f23319e = null;
        try {
            this.f23315a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        a((Bundle) null);
    }
}

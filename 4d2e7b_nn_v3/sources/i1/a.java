package i1;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonService;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f22039f;

    /* renamed from: a  reason: collision with root package name */
    private Messenger f22040a;

    /* renamed from: b  reason: collision with root package name */
    private Messenger f22041b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22042c = false;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue f22043d = new ConcurrentLinkedQueue();

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentLinkedQueue f22044e = new ConcurrentLinkedQueue();

    public static a b() {
        if (f22039f == null) {
            synchronized (a.class) {
                f22039f = new a();
            }
        }
        return f22039f;
    }

    private boolean c(Context context) {
        String b10 = p1.a.b(context);
        if (TextUtils.isEmpty(b10)) {
            s1.a.b("MTMessenger", "appKey is empty, please check it");
            return false;
        }
        String a10 = p1.a.a(context);
        String c10 = p1.a.c(context);
        String e10 = p1.a.e(context);
        int d10 = p1.a.d(context);
        s1.a.a("MTMessenger", "appVersionCode:" + d10 + ", appVersionName:" + e10 + ", appKey:" + b10 + ", appChannel:" + a10 + ", appProcess:" + c10);
        m1.a.g(context, "3.6.0");
        m1.a.f(context, 360);
        m1.a.d(context, b10);
        m1.a.c(context, a10);
        return true;
    }

    public IBinder a() {
        return this.f22041b.getBinder();
    }

    public void d(Messenger messenger) {
        if (messenger != null) {
            try {
                this.f22040a = messenger;
                Iterator it = this.f22043d.iterator();
                while (it.hasNext()) {
                    this.f22040a.send((Message) it.next());
                    it.remove();
                }
            } catch (Throwable th) {
                s1.a.h("MTMessenger", "initMainMessenger failed " + th.getMessage());
            }
        }
    }

    public void e(Context context) {
        try {
            if (this.f22040a == null) {
                s1.a.e("MTMessenger", "init common version:3.6.0");
                if (c(context)) {
                    this.f22040a = new Messenger(new c(context, Looper.getMainLooper()));
                    Iterator it = this.f22043d.iterator();
                    while (it.hasNext()) {
                        this.f22040a.send((Message) it.next());
                        it.remove();
                    }
                } else {
                    return;
                }
            }
            if (p1.a.f23054c && !this.f22042c) {
                this.f22042c = true;
                if (p1.a.h(context) == null) {
                    s1.a.b("MTMessenger", "MTCommonService is null, please create new Service extends MTCommonService");
                    return;
                }
                b bVar = new b(context);
                MTCommonService h10 = p1.a.h(context);
                if (h10 == null) {
                    s1.a.b("MTMessenger", "initOnMainProcess error, there are no service extends MTCommonService");
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(context, h10.getClass());
                context.bindService(intent, bVar, 1);
                if (Build.VERSION.SDK_INT < 26) {
                    context.startService(intent);
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTMessenger", "initOnMainProcess failed " + th.getMessage());
        }
    }

    public void f(Context context) {
        try {
            if (this.f22041b == null) {
                p1.a.f23054c = true;
                s1.a.e("MTMessenger", "init common version:3.6.0");
                if (c(context)) {
                    this.f22041b = new Messenger(new d(context, Looper.getMainLooper()));
                    Iterator it = this.f22044e.iterator();
                    while (it.hasNext()) {
                        this.f22041b.send((Message) it.next());
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTMessenger", "initOnRemoteProcess failed " + th.getMessage());
        }
    }

    public void g(Context context, IBinder iBinder) {
        s1.a.e("MTMessenger", "onServiceConnected");
        this.f22042c = true;
        j1.a.a().b(context);
        this.f22041b = new Messenger(iBinder);
        try {
            Iterator it = this.f22044e.iterator();
            while (it.hasNext()) {
                this.f22041b.send((Message) it.next());
                it.remove();
            }
        } catch (Throwable th) {
            s1.a.h("MTMessenger", "sendMessageToRemoteProcess failed " + th.getMessage());
        }
        i(context, 1001, (Bundle) null);
        j(context, 1999, (Bundle) null);
    }

    public void h(Context context) {
        s1.a.e("MTMessenger", "onServiceDisconnected");
        this.f22042c = false;
        this.f22040a = null;
        this.f22041b = null;
        this.f22043d.clear();
        this.f22044e.clear();
        i(context, 1002, (Bundle) null);
    }

    public void i(Context context, int i10, Bundle bundle) {
        try {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.setData(bundle);
            Messenger messenger = this.f22040a;
            if (messenger == null) {
                this.f22043d.add(obtain);
            } else {
                messenger.send(obtain);
            }
        } catch (DeadObjectException e10) {
            s1.a.h("MTMessenger", "sendMessageToMainProcess DeadObjectException " + e10.getMessage());
        } catch (Throwable th) {
            s1.a.h("MTMessenger", "sendMessageToMainProcess failed " + th.getMessage());
        }
    }

    public void j(Context context, int i10, Bundle bundle) {
        try {
            if (p1.a.f23054c) {
                Message obtain = Message.obtain();
                obtain.what = i10;
                obtain.setData(bundle);
                if (p1.a.z(context)) {
                    obtain.replyTo = this.f22040a;
                }
                Messenger messenger = this.f22041b;
                if (messenger == null) {
                    this.f22044e.add(obtain);
                } else {
                    messenger.send(obtain);
                }
            }
        } catch (DeadObjectException e10) {
            s1.a.h("MTMessenger", "sendMessageToRemoteProcess DeadObjectException " + e10.getMessage());
        } catch (Throwable th) {
            s1.a.h("MTMessenger", "sendMessageToRemoteProcess failed " + th.getMessage());
        }
    }
}

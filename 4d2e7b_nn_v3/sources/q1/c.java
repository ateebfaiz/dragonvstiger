package q1;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import s1.a;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f23184c;

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap f23185a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap f23186b = new ConcurrentHashMap();

    public static c c() {
        if (f23184c == null) {
            synchronized (c.class) {
                f23184c = new c();
            }
        }
        return f23184c;
    }

    public a a(Context context, String str) {
        return b(context, str, 300000);
    }

    public synchronized a b(Context context, String str, int i10) {
        a aVar;
        try {
            b bVar = (b) this.f23185a.get(str);
            if (bVar == null) {
                bVar = new b(str);
                this.f23185a.put(str, bVar);
            }
            if (bVar.getState() == Thread.State.NEW) {
                bVar.start();
            }
            aVar = (a) this.f23186b.get(str);
            if (bVar.getState() == Thread.State.TERMINATED) {
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages((Object) null);
                }
                bVar = new b(str);
                bVar.start();
                this.f23185a.put(str, bVar);
                aVar = new a(bVar.getLooper(), context, i10);
                this.f23186b.put(str, aVar);
                a.a("MTHandler", "buildHandler：" + str);
            }
            if (aVar == null) {
                aVar = new a(bVar.getLooper(), context, i10);
                this.f23186b.put(str, aVar);
                a.a("MTHandler", "buildHandler：" + str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public void d(Context context, String str, Runnable runnable, long j10) {
        try {
            a a10 = a(context, str);
            if (a10 != null) {
                a10.postDelayed(runnable, j10);
            }
        } catch (Throwable th) {
            a.h("MTHandler", "sendMessageDelayed failed " + th.getMessage());
        }
    }

    public void e(Context context, String str) {
        try {
            if (this.f23186b.containsKey(str)) {
                a aVar = (a) this.f23186b.get(str);
                if (aVar != null) {
                    a.a("MTHandler", "releaseHandler:" + str);
                    aVar.removeCallbacksAndMessages((Object) null);
                }
                this.f23186b.remove(str);
            }
            if (this.f23185a.containsKey(str)) {
                b bVar = (b) this.f23185a.get(str);
                if (bVar != null) {
                    bVar.quit();
                }
                this.f23185a.remove(str);
            }
        } catch (Throwable th) {
            a.h("MTHandler", "releaseHandler failed " + th.getMessage());
        }
    }

    public void f(Context context, String str, int i10) {
        try {
            a a10 = a(context, str);
            if (a10 != null) {
                a10.removeMessages(i10);
            }
        } catch (Throwable th) {
            a.h("MTHandler", "removeMessages failed " + th.getMessage());
        }
    }

    public void g(Context context, String str, int i10, Bundle bundle) {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 0;
            obtain.obj = str;
            obtain.what = i10;
            obtain.setData(bundle);
            a a10 = a(context, str);
            if (a10 != null) {
                a10.sendMessage(obtain);
            }
        } catch (Throwable th) {
            a.h("MTHandler", "sendMessage failed " + th.getMessage());
        }
    }

    public void h(Context context, String str, int i10, Bundle bundle, long j10) {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 1;
            obtain.obj = str;
            obtain.what = i10;
            obtain.setData(bundle);
            a a10 = a(context, str);
            if (a10 != null) {
                a10.sendMessageDelayed(obtain, j10);
            }
        } catch (Throwable th) {
            a.h("MTHandler", "sendMessageDelayed failed " + th.getMessage());
        }
    }
}

package com.blankj.utilcode.util;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import c.d;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.p;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MessengerUtils {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap f18374a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map f18375b = new HashMap();

    public static class ServerService extends Service {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ConcurrentHashMap f18376a = new ConcurrentHashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Handler f18377b;

        /* renamed from: c  reason: collision with root package name */
        private final Messenger f18378c;

        class a extends Handler {
            a() {
            }

            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    ServerService.this.f18376a.put(Integer.valueOf(message.arg1), message.replyTo);
                } else if (i10 == 1) {
                    ServerService.this.f18376a.remove(Integer.valueOf(message.arg1));
                } else if (i10 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f18377b = aVar;
            this.f18378c = new Messenger(aVar);
        }

        /* access modifiers changed from: private */
        public void d(Message message) {
            String string;
            Bundle data = message.getData();
            if (data != null && (string = data.getString("MESSENGER_UTILS")) != null) {
                d.a(MessengerUtils.f18374a.get(string));
            }
        }

        /* access modifiers changed from: private */
        public void e(Message message) {
            Message obtain = Message.obtain(message);
            for (Messenger messenger : this.f18376a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(obtain));
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            obtain.recycle();
        }

        public IBinder onBind(Intent intent) {
            return this.f18378c.getBinder();
        }

        public int onStartCommand(Intent intent, int i10, int i11) {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, s.f(i.a.f18397b, (p.a) null));
            }
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                Message obtain = Message.obtain(this.f18377b, 2);
                obtain.replyTo = this.f18378c;
                obtain.setData(extras);
                e(obtain);
                d(obtain);
            }
            return 2;
        }
    }
}

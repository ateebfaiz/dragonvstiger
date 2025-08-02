package com.geetest.captcha;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.pdns.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f5809a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static a f5810b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5811c = true;

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f5812d = new h0();

    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        public static final C0073a f5813d = new C0073a();

        /* renamed from: a  reason: collision with root package name */
        public final Lazy f5814a = i.b(d.INSTANCE);

        /* renamed from: b  reason: collision with root package name */
        public final Lazy f5815b = i.b(new c(this));

        /* renamed from: c  reason: collision with root package name */
        public final SimpleDateFormat f5816c = new SimpleDateFormat(o.f18139c, Locale.CHINA);

        /* renamed from: com.geetest.captcha.h0$a$a  reason: collision with other inner class name */
        public static final class C0073a {
            public static final /* synthetic */ boolean a(C0073a aVar) {
                aVar.getClass();
                File file = new File(i0.f5821a + File.separator + "Geetest");
                if (file.exists()) {
                    File file2 = new File(file, "captcha_log.txt");
                    if (file2.exists() && file2.length() >= 10485760) {
                        return file2.delete();
                    }
                }
                return false;
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public long f5817a;

            /* renamed from: b  reason: collision with root package name */
            public String f5818b;

            /* renamed from: c  reason: collision with root package name */
            public String f5819c;
        }

        public static final class c extends n implements Function0<C0074a> {
            public final /* synthetic */ a this$0;

            /* renamed from: com.geetest.captcha.h0$a$c$a  reason: collision with other inner class name */
            public static final class C0074a extends Handler {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f5820a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0074a(c cVar, Looper looper) {
                    super(looper);
                    this.f5820a = cVar;
                }

                public void handleMessage(Message message) {
                    m.f(message, NotificationCompat.CATEGORY_MESSAGE);
                    super.handleMessage(message);
                    try {
                        if (!Thread.interrupted()) {
                            int i10 = message.what;
                            if (i10 == 0) {
                                Object obj = message.obj;
                                if (obj != null) {
                                    b bVar = (b) obj;
                                    a aVar = this.f5820a.this$0;
                                    C0073a aVar2 = a.f5813d;
                                    SimpleDateFormat simpleDateFormat = aVar.f5816c;
                                    long j10 = bVar.f5817a;
                                    String str = simpleDateFormat.format(new Date(j10)) + 9 + bVar.f5818b + 10 + bVar.f5819c + 10;
                                    m.e(str, "StringBuilder().apply {\n…             }.toString()");
                                    a.a(aVar, str);
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.geetest.captcha.utils.LogUtils.Logger.Item");
                            } else if (i10 == 1) {
                                C0073a.a(a.f5813d);
                            }
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            public final C0074a invoke() {
                return new C0074a(this, this.this$0.d().getLooper());
            }
        }

        public static final class d extends n implements Function0<HandlerThread> {
            public static final d INSTANCE = new d();

            public d() {
                super(0);
            }

            public final HandlerThread invoke() {
                return new HandlerThread("Captcha Thread");
            }
        }

        public final synchronized void b() {
            try {
                c().removeMessages(0);
                c().removeMessages(1);
                d().quitSafely();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return;
        }

        public final Handler c() {
            return (Handler) this.f5815b.getValue();
        }

        public final HandlerThread d() {
            return (HandlerThread) this.f5814a.getValue();
        }

        public final synchronized void e() {
            d().start();
        }

        public final synchronized void a(String str, String str2) {
            Message obtainMessage = c().obtainMessage();
            m.e(obtainMessage, "handler.obtainMessage()");
            obtainMessage.what = 0;
            b bVar = new b();
            bVar.f5817a = System.currentTimeMillis();
            bVar.f5818b = str;
            bVar.f5819c = str2;
            obtainMessage.obj = bVar;
            c().sendMessage(obtainMessage);
        }

        public final synchronized void a() {
            Message obtainMessage = c().obtainMessage();
            m.e(obtainMessage, "handler.obtainMessage()");
            obtainMessage.what = 1;
            c().sendMessage(obtainMessage);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[SYNTHETIC, Splitter:B:23:0x005b] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0061 A[SYNTHETIC, Splitter:B:29:0x0061] */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void a(com.geetest.captcha.h0.a r5, java.lang.String r6) {
            /*
                r5.getClass()
                r5 = 0
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                com.geetest.captcha.h0$a$a r1 = f5813d     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r1 = r1.getClass()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                boolean r1 = r0.exists()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                if (r1 != 0) goto L_0x001b
                r0.mkdirs()     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                goto L_0x001b
            L_0x0019:
                r6 = move-exception
                goto L_0x0059
            L_0x001b:
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r4 = "captcha_log.txt"
                r3.<init>(r0, r4)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r0 = 1
                r2.<init>(r3, r0)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x005f, all -> 0x0019 }
                java.lang.String r5 = "utf-8"
                java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r0 = "Charset.forName(charsetName)"
                kotlin.jvm.internal.m.e(r5, r0)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                if (r6 == 0) goto L_0x004c
                byte[] r5 = r6.getBytes(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r6 = "(this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.m.e(r5, r6)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                r1.write(r5)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                r1.close()     // Catch:{ IOException -> 0x0064 }
                goto L_0x0064
            L_0x004a:
                r5 = move-exception
                goto L_0x0054
            L_0x004c:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
                r5.<init>(r6)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
                throw r5     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            L_0x0054:
                r6 = r5
                r5 = r1
                goto L_0x0059
            L_0x0057:
                r5 = r1
                goto L_0x005f
            L_0x0059:
                if (r5 == 0) goto L_0x005e
                r5.close()     // Catch:{ IOException -> 0x005e }
            L_0x005e:
                throw r6
            L_0x005f:
                if (r5 == 0) goto L_0x0064
                r5.close()     // Catch:{ IOException -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.h0.a.a(com.geetest.captcha.h0$a, java.lang.String):void");
        }
    }

    public final void a(String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        if (f5809a <= 2) {
            Log.d("Captcha", str);
            c("Captcha", str);
        }
    }

    public final void b(String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        if (f5809a <= 5) {
            Log.e("Captcha", str);
            c("Captcha", str);
        }
    }

    public final void c(String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        if (f5811c) {
            Log.i("Captcha", str);
        }
        c("Captcha", str);
    }

    public final void a(String str, String str2) {
        m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f5809a <= 2) {
            Log.d(str, str2);
            c(str, str2);
        }
    }

    public final void b(String str, String str2) {
        m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f5809a <= 3) {
            Log.i(str, str2);
            c(str, str2);
        }
    }

    public final void c(String str, String str2) {
        if (f5810b == null) {
            a aVar = new a();
            f5810b = aVar;
            aVar.e();
            a aVar2 = f5810b;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        a aVar3 = f5810b;
        if (aVar3 != null) {
            aVar3.a(str, str2);
        }
    }
}

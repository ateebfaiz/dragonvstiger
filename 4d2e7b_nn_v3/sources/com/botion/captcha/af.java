package com.botion.captcha;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.pdns.o;
import com.alibaba.pdns.x.c;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.m;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static final af f18475a = new af();

    /* renamed from: b  reason: collision with root package name */
    private static int f18476b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static a f18477c;

    /* renamed from: d  reason: collision with root package name */
    private static String f18478d = "Captcha";

    /* renamed from: e  reason: collision with root package name */
    private static boolean f18479e = true;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0240a f18480a = new C0240a((byte) 0);

        /* renamed from: b  reason: collision with root package name */
        private HandlerThread f18481b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f18482c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final SimpleDateFormat f18483d = new SimpleDateFormat(o.f18139c, Locale.CHINA);

        /* renamed from: com.botion.captcha.af$a$a  reason: collision with other inner class name */
        public static final class C0240a {
            private C0240a() {
            }

            static String a() {
                return ag.a() + File.separator + "Botion";
            }

            public /* synthetic */ C0240a(byte b10) {
                this();
            }
        }

        static final class b {

            /* renamed from: a  reason: collision with root package name */
            long f18484a;

            /* renamed from: b  reason: collision with root package name */
            String f18485b;

            /* renamed from: c  reason: collision with root package name */
            String f18486c;
        }

        public static final class c extends Handler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f18487a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, Looper looper) {
                super(looper);
                this.f18487a = aVar;
            }

            public final void handleMessage(Message message) {
                m.f(message, NotificationCompat.CATEGORY_MESSAGE);
                super.handleMessage(message);
                try {
                    if (!Thread.interrupted()) {
                        int i10 = message.what;
                        if (i10 == 0) {
                            Object obj = message.obj;
                            if (obj != null) {
                                b bVar = (b) obj;
                                C0240a aVar = a.f18480a;
                                SimpleDateFormat a10 = this.f18487a.f18483d;
                                long j10 = bVar.f18484a;
                                String str = a10.format(new Date(j10)) + 9 + bVar.f18485b + 10 + bVar.f18486c + 10;
                                m.e(str, "sb.toString()");
                                a.a(str);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.botion.captcha.utils.LogUtils.Logger.Item");
                        } else if (i10 == 1) {
                            C0240a aVar2 = a.f18480a;
                            File file = new File(C0240a.a());
                            if (file.exists()) {
                                File file2 = new File(file, "captcha_log.txt");
                                if (file2.exists() && file2.length() >= 10485760) {
                                    file2.delete();
                                }
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        public final synchronized void b() {
            try {
                Handler handler = this.f18482c;
                if (handler == null) {
                    m.u("handler");
                }
                Message obtainMessage = handler.obtainMessage();
                m.e(obtainMessage, "handler.obtainMessage()");
                obtainMessage.what = 1;
                Handler handler2 = this.f18482c;
                if (handler2 == null) {
                    m.u("handler");
                }
                handler2.sendMessage(obtainMessage);
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void c() {
            try {
                Handler handler = this.f18482c;
                if (handler == null) {
                    m.u("handler");
                }
                handler.removeMessages(0);
                Handler handler2 = this.f18482c;
                if (handler2 == null) {
                    m.u("handler");
                }
                handler2.removeMessages(1);
                HandlerThread handlerThread = this.f18481b;
                if (handlerThread == null) {
                    m.u("thread");
                }
                handlerThread.quitSafely();
            } catch (Exception e10) {
                e10.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void a() {
            try {
                HandlerThread handlerThread = new HandlerThread("Captcha Thread");
                this.f18481b = handlerThread;
                handlerThread.start();
                HandlerThread handlerThread2 = this.f18481b;
                if (handlerThread2 == null) {
                    m.u("thread");
                }
                this.f18482c = new c(this, handlerThread2.getLooper());
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void a(String str, String str2) {
            try {
                Handler handler = this.f18482c;
                if (handler == null) {
                    m.u("handler");
                }
                Message obtainMessage = handler.obtainMessage();
                m.e(obtainMessage, "handler.obtainMessage()");
                obtainMessage.what = 0;
                b bVar = new b();
                bVar.f18484a = System.currentTimeMillis();
                bVar.f18485b = str;
                bVar.f18486c = str2;
                obtainMessage.obj = bVar;
                Handler handler2 = this.f18482c;
                if (handler2 == null) {
                    m.u("handler");
                }
                handler2.sendMessage(obtainMessage);
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC, Splitter:B:24:0x0054] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x005a A[SYNTHETIC, Splitter:B:30:0x005a] */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void a(java.lang.String r6) {
            /*
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                java.lang.String r2 = com.botion.captcha.af.a.C0240a.a()     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                if (r2 != 0) goto L_0x0016
                r1.mkdirs()     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                goto L_0x0016
            L_0x0014:
                r6 = move-exception
                goto L_0x0052
            L_0x0016:
                java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                java.lang.String r5 = "captcha_log.txt"
                r4.<init>(r1, r5)     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                r1 = 1
                r3.<init>(r4, r1)     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0058, all -> 0x0014 }
                java.lang.String r0 = "utf-8"
                java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                java.lang.String r1 = "Charset.forName(charsetName)"
                kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                if (r6 == 0) goto L_0x0048
                byte[] r6 = r6.getBytes(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                java.lang.String r0 = "(this as java.lang.String).getBytes(charset)"
                kotlin.jvm.internal.m.e(r6, r0)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                r2.write(r6)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                r2.close()     // Catch:{ IOException -> 0x0044 }
            L_0x0044:
                return
            L_0x0045:
                r6 = move-exception
                r0 = r2
                goto L_0x0052
            L_0x0048:
                java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r6.<init>(r0)     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
                throw r6     // Catch:{ Exception -> 0x0050, all -> 0x0045 }
            L_0x0050:
                r0 = r2
                goto L_0x0058
            L_0x0052:
                if (r0 == 0) goto L_0x0057
                r0.close()     // Catch:{ IOException -> 0x0057 }
            L_0x0057:
                throw r6
            L_0x0058:
                if (r0 == 0) goto L_0x005d
                r0.close()     // Catch:{ IOException -> 0x005d }
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.botion.captcha.af.a.a(java.lang.String):void");
        }
    }

    private af() {
    }

    public static void a(String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        if (f18476b <= 2) {
            Log.d(f18478d, str);
            c(f18478d, str);
        }
    }

    public static void b(String str, String str2) {
        m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f18476b <= 3) {
            Log.i(str, str2);
            c(str, str2);
        }
    }

    private static void c(String str, String str2) {
        if (f18477c == null) {
            a aVar = new a();
            f18477c = aVar;
            aVar.a();
            a aVar2 = f18477c;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        a aVar3 = f18477c;
        if (aVar3 != null) {
            aVar3.a(str, str2);
        }
    }

    public static void a(String str, String str2) {
        m.f(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (f18476b <= 2) {
            Log.d(str, str2);
            c(str, str2);
        }
    }

    public static void b(String str) {
        m.f(str, NotificationCompat.CATEGORY_MESSAGE);
        if (f18479e) {
            Log.i(f18478d, str);
        }
        c(f18478d, str);
    }

    public static void a() {
        try {
            a aVar = f18477c;
            if (aVar != null) {
                if (aVar != null) {
                    aVar.c();
                }
                f18477c = null;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void a(boolean z10) {
        f18479e = z10;
        f18476b = z10 ? 1 : c.f18290d;
    }
}

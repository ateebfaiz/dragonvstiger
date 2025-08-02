package com.cocos.lib;

import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Call;
import org.cocos2dx.okhttp3.Callback;
import org.cocos2dx.okhttp3.Dispatcher;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Protocol;
import org.cocos2dx.okhttp3.Request;

public class CocosDownloader {
    private static Dispatcher dispatcher;
    public static CocosMahAgent mahAgent;
    private int _countOfMaxProcessingTasks;
    /* access modifiers changed from: private */
    public OkHttpClient _httpClient = null;
    /* access modifiers changed from: private */
    public int _id;
    private int _runningTaskCount = 0;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, Call> _taskMap = new ConcurrentHashMap<>();
    private Queue<Runnable> _taskQueue = new LinkedList();
    private String _tempFileNameSuffix;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19221a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f19222b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f19223c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f19224d;

        a(int i10, long j10, long j11, long j12) {
            this.f19221a = i10;
            this.f19222b = j10;
            this.f19223c = j11;
            this.f19224d = j12;
        }

        public void run() {
            CocosDownloader cocosDownloader = CocosDownloader.this;
            cocosDownloader.nativeOnProgress(cocosDownloader._id, this.f19221a, this.f19222b, this.f19223c, this.f19224d);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19226a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19227b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19228c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ byte[] f19229d;

        b(int i10, int i11, String str, byte[] bArr) {
            this.f19226a = i10;
            this.f19227b = i11;
            this.f19228c = str;
            this.f19229d = bArr;
        }

        public void run() {
            CocosDownloader cocosDownloader = CocosDownloader.this;
            cocosDownloader.nativeOnFinish(cocosDownloader._id, this.f19226a, this.f19227b, this.f19228c, this.f19229d);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f19231a = null;

        /* renamed from: b  reason: collision with root package name */
        String f19232b = null;

        /* renamed from: c  reason: collision with root package name */
        File f19233c = null;

        /* renamed from: d  reason: collision with root package name */
        File f19234d = null;

        /* renamed from: e  reason: collision with root package name */
        long f19235e = 0;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f19236f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f19237g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f19238h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ CocosDownloader f19239i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ int f19240j;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ String[] f19241w;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19242a;

            a(String str) {
                this.f19242a = str;
            }

            public void run() {
                CocosDownloader cocosDownloader = c.this.f19239i;
                cocosDownloader.nativeOnFinish(cocosDownloader._id, c.this.f19240j, 0, this.f19242a, (byte[]) null);
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19244a;

            b(String str) {
                this.f19244a = str;
            }

            public void run() {
                CocosDownloader cocosDownloader = c.this.f19239i;
                cocosDownloader.nativeOnFinish(cocosDownloader._id, c.this.f19240j, 0, this.f19244a, (byte[]) null);
            }
        }

        /* renamed from: com.cocos.lib.CocosDownloader$c$c  reason: collision with other inner class name */
        class C0242c implements Callback {
            C0242c() {
            }

            public void onFailure(Call call, IOException iOException) {
                c cVar = c.this;
                cVar.f19239i.onFinish(cVar.f19240j, 0, iOException.toString(), (byte[]) null);
            }

            /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x011a A[Catch:{ IOException -> 0x00cf }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x012c A[Catch:{ IOException -> 0x00cf }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0142 A[Catch:{ IOException -> 0x00cf }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x01ec A[SYNTHETIC, Splitter:B:89:0x01ec] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x01f1 A[Catch:{ IOException -> 0x0199 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x01f7 A[SYNTHETIC, Splitter:B:94:0x01f7] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x01ff A[Catch:{ IOException -> 0x01fb }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(org.cocos2dx.okhttp3.Call r26, org.cocos2dx.okhttp3.Response r27) {
                /*
                    r25 = this;
                    r1 = r25
                    java.lang.String r2 = "CocosDownloader"
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r3 = new byte[r0]
                    r4 = 0
                    int r6 = r27.code()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r7 = 200(0xc8, float:2.8E-43)
                    if (r6 < r7) goto L_0x01a9
                    int r6 = r27.code()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r7 = 206(0xce, float:2.89E-43)
                    if (r6 <= r7) goto L_0x001b
                    goto L_0x01a9
                L_0x001b:
                    android.content.Context r6 = com.cocos.lib.GlobalObject.getContext()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r7 = "breakpointDownloadSupport"
                    android.content.SharedPreferences r6 = r6.getSharedPreferences(r7, r4)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    android.content.SharedPreferences$Editor r7 = r6.edit()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    org.cocos2dx.okhttp3.ResponseBody r8 = r27.body()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    long r8 = r8.contentLength()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    com.cocos.lib.CocosDownloader$c r10 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    long r11 = r10.f19235e     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    long r8 = r8 + r11
                    java.lang.String r10 = r10.f19236f     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    int r10 = r10.length()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r11 = 1
                    r12 = 0
                    if (r10 <= 0) goto L_0x006d
                    com.cocos.lib.CocosDownloader$c r10 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r10 = r10.f19232b     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    boolean r10 = r6.contains(r10)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    if (r10 != 0) goto L_0x006d
                    int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                    if (r10 <= 0) goto L_0x0063
                    com.cocos.lib.CocosDownloader$c r10 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r10 = r10.f19232b     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r7.putBoolean(r10, r11)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    goto L_0x006a
                L_0x0057:
                    r0 = move-exception
                    r3 = r0
                    r5 = 0
                L_0x005a:
                    r21 = 0
                    goto L_0x01f5
                L_0x005e:
                    r0 = move-exception
                    r5 = 0
                    r10 = 0
                    goto L_0x01d9
                L_0x0063:
                    com.cocos.lib.CocosDownloader$c r10 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r10 = r10.f19232b     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r7.putBoolean(r10, r4)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                L_0x006a:
                    r7.commit()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                L_0x006d:
                    com.cocos.lib.CocosDownloader$c r10 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    long r14 = r10.f19235e     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    org.cocos2dx.okhttp3.ResponseBody r10 = r27.body()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.io.InputStream r10 = r10.byteStream()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    java.lang.String r0 = r0.f19236f     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    int r0 = r0.length()     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    if (r0 <= 0) goto L_0x014d
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r22 = r6
                    long r5 = r0.f19235e     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
                    if (r0 <= 0) goto L_0x00a0
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader$c r5 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    java.io.File r5 = r5.f19233c     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r0.<init>(r5, r11)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                L_0x0096:
                    r5 = r0
                    goto L_0x00aa
                L_0x0098:
                    r0 = move-exception
                    r3 = r0
                    r5 = r10
                    goto L_0x005a
                L_0x009c:
                    r0 = move-exception
                    r5 = 0
                    goto L_0x01d9
                L_0x00a0:
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader$c r5 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    java.io.File r5 = r5.f19233c     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r0.<init>(r5, r4)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    goto L_0x0096
                L_0x00aa:
                    int r0 = r10.read(r3)     // Catch:{ IOException -> 0x00cf }
                    r6 = -1
                    if (r0 == r6) goto L_0x00d2
                    long r11 = (long) r0     // Catch:{ IOException -> 0x00cf }
                    long r23 = r14 + r11
                    r5.write(r3, r4, r0)     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader r13 = r0.f19239i     // Catch:{ IOException -> 0x00cf }
                    int r14 = r0.f19240j     // Catch:{ IOException -> 0x00cf }
                    r15 = r11
                    r17 = r23
                    r19 = r8
                    r13.onProgress(r14, r15, r17, r19)     // Catch:{ IOException -> 0x00cf }
                    r14 = r23
                    goto L_0x00aa
                L_0x00c8:
                    r0 = move-exception
                    r3 = r0
                    r21 = r5
                    r5 = r10
                    goto L_0x01f5
                L_0x00cf:
                    r0 = move-exception
                    goto L_0x01d9
                L_0x00d2:
                    r5.flush()     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.io.File r0 = r0.f19234d     // Catch:{ IOException -> 0x00cf }
                    boolean r0 = r0.exists()     // Catch:{ IOException -> 0x00cf }
                    if (r0 == 0) goto L_0x010e
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.io.File r0 = r0.f19234d     // Catch:{ IOException -> 0x00cf }
                    boolean r0 = r0.isDirectory()     // Catch:{ IOException -> 0x00cf }
                    if (r0 == 0) goto L_0x00ea
                    goto L_0x0117
                L_0x00ea:
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.io.File r0 = r0.f19234d     // Catch:{ IOException -> 0x00cf }
                    boolean r0 = r0.delete()     // Catch:{ IOException -> 0x00cf }
                    if (r0 != 0) goto L_0x010e
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cf }
                    r0.<init>()     // Catch:{ IOException -> 0x00cf }
                    java.lang.String r3 = "Can't remove old file:"
                    r0.append(r3)     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader$c r3 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.io.File r3 = r3.f19234d     // Catch:{ IOException -> 0x00cf }
                    java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x00cf }
                    r0.append(r3)     // Catch:{ IOException -> 0x00cf }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00cf }
                    goto L_0x0118
                L_0x010e:
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.io.File r3 = r0.f19233c     // Catch:{ IOException -> 0x00cf }
                    java.io.File r0 = r0.f19234d     // Catch:{ IOException -> 0x00cf }
                    r3.renameTo(r0)     // Catch:{ IOException -> 0x00cf }
                L_0x0117:
                    r0 = 0
                L_0x0118:
                    if (r0 != 0) goto L_0x012c
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader r3 = r0.f19239i     // Catch:{ IOException -> 0x00cf }
                    int r0 = r0.f19240j     // Catch:{ IOException -> 0x00cf }
                    r6 = 0
                    r3.onFinish(r0, r4, r6, r6)     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader r0 = r0.f19239i     // Catch:{ IOException -> 0x00cf }
                    r0.runNextTaskIfExists()     // Catch:{ IOException -> 0x00cf }
                    goto L_0x0136
                L_0x012c:
                    com.cocos.lib.CocosDownloader$c r3 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    com.cocos.lib.CocosDownloader r6 = r3.f19239i     // Catch:{ IOException -> 0x00cf }
                    int r3 = r3.f19240j     // Catch:{ IOException -> 0x00cf }
                    r8 = 0
                    r6.onFinish(r3, r4, r0, r8)     // Catch:{ IOException -> 0x00cf }
                L_0x0136:
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.lang.String r0 = r0.f19232b     // Catch:{ IOException -> 0x00cf }
                    r3 = r22
                    boolean r0 = r3.contains(r0)     // Catch:{ IOException -> 0x00cf }
                    if (r0 == 0) goto L_0x0193
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x00cf }
                    java.lang.String r0 = r0.f19232b     // Catch:{ IOException -> 0x00cf }
                    r7.remove(r0)     // Catch:{ IOException -> 0x00cf }
                    r7.commit()     // Catch:{ IOException -> 0x00cf }
                    goto L_0x0193
                L_0x014d:
                    int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0158
                    java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    int r5 = (int) r8     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r0.<init>(r5)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    goto L_0x015f
                L_0x0158:
                    java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r5 = 4096(0x1000, float:5.74E-42)
                    r0.<init>(r5)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                L_0x015f:
                    int r5 = r10.read(r3)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r6 = -1
                    if (r5 == r6) goto L_0x017d
                    long r11 = (long) r5     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    long r22 = r14 + r11
                    r0.write(r3, r4, r5)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader$c r5 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader r13 = r5.f19239i     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    int r14 = r5.f19240j     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r15 = r11
                    r17 = r22
                    r19 = r8
                    r13.onProgress(r14, r15, r17, r19)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r14 = r22
                    goto L_0x015f
                L_0x017d:
                    com.cocos.lib.CocosDownloader$c r3 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader r5 = r3.f19239i     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    int r3 = r3.f19240j     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    byte[] r0 = r0.toByteArray()     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r6 = 0
                    r5.onFinish(r3, r4, r6, r0)     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    com.cocos.lib.CocosDownloader r0 = r0.f19239i     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r0.runNextTaskIfExists()     // Catch:{ IOException -> 0x009c, all -> 0x0098 }
                    r5 = 0
                L_0x0193:
                    if (r10 == 0) goto L_0x019b
                    r10.close()     // Catch:{ IOException -> 0x0199 }
                    goto L_0x019b
                L_0x0199:
                    r0 = move-exception
                    goto L_0x01a1
                L_0x019b:
                    if (r5 == 0) goto L_0x01f4
                    r5.close()     // Catch:{ IOException -> 0x0199 }
                    goto L_0x01f4
                L_0x01a1:
                    java.lang.String r0 = r0.toString()
                    android.util.Log.e(r2, r0)
                    goto L_0x01f4
                L_0x01a9:
                    int r0 = r27.code()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r3 = 416(0x1a0, float:5.83E-43)
                    if (r0 != r3) goto L_0x01c9
                    java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    com.cocos.lib.CocosDownloader$c r3 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r3 = r3.f19238h     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r0.<init>(r3)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    boolean r3 = r0.exists()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    if (r3 == 0) goto L_0x01c9
                    boolean r3 = r0.isFile()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    if (r3 == 0) goto L_0x01c9
                    r0.delete()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                L_0x01c9:
                    com.cocos.lib.CocosDownloader$c r0 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    com.cocos.lib.CocosDownloader r3 = r0.f19239i     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    int r0 = r0.f19240j     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    java.lang.String r5 = r27.message()     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    r6 = -2
                    r7 = 0
                    r3.onFinish(r0, r6, r5, r7)     // Catch:{ IOException -> 0x005e, all -> 0x0057 }
                    return
                L_0x01d9:
                    r0.printStackTrace()     // Catch:{ all -> 0x00c8 }
                    com.cocos.lib.CocosDownloader$c r3 = com.cocos.lib.CocosDownloader.c.this     // Catch:{ all -> 0x00c8 }
                    com.cocos.lib.CocosDownloader r6 = r3.f19239i     // Catch:{ all -> 0x00c8 }
                    int r3 = r3.f19240j     // Catch:{ all -> 0x00c8 }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c8 }
                    r7 = 0
                    r6.onFinish(r3, r4, r0, r7)     // Catch:{ all -> 0x00c8 }
                    if (r10 == 0) goto L_0x01ef
                    r10.close()     // Catch:{ IOException -> 0x0199 }
                L_0x01ef:
                    if (r5 == 0) goto L_0x01f4
                    r5.close()     // Catch:{ IOException -> 0x0199 }
                L_0x01f4:
                    return
                L_0x01f5:
                    if (r5 == 0) goto L_0x01fd
                    r5.close()     // Catch:{ IOException -> 0x01fb }
                    goto L_0x01fd
                L_0x01fb:
                    r0 = move-exception
                    goto L_0x0203
                L_0x01fd:
                    if (r21 == 0) goto L_0x020a
                    r21.close()     // Catch:{ IOException -> 0x01fb }
                    goto L_0x020a
                L_0x0203:
                    java.lang.String r0 = r0.toString()
                    android.util.Log.e(r2, r0)
                L_0x020a:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cocos.lib.CocosDownloader.c.C0242c.onResponse(org.cocos2dx.okhttp3.Call, org.cocos2dx.okhttp3.Response):void");
            }
        }

        c(String str, String str2, String str3, CocosDownloader cocosDownloader, int i10, String[] strArr) {
            this.f19236f = str;
            this.f19237g = str2;
            this.f19238h = str3;
            this.f19239i = cocosDownloader;
            this.f19240j = i10;
            this.f19241w = strArr;
        }

        public void run() {
            String str;
            int i10 = 0;
            if (this.f19236f.length() > 0) {
                try {
                    this.f19231a = new URI(this.f19237g).getHost();
                    File file = new File(this.f19238h);
                    this.f19233c = file;
                    if (!file.isDirectory()) {
                        File parentFile = this.f19233c.getParentFile();
                        if (parentFile == null) {
                            String str2 = "Invalid path " + this.f19236f + " : The current path is inaccessible.";
                            Log.e("CocosDownloader", str2);
                            CocosHelper.runOnGameThread(new a(str2));
                            return;
                        } else if (parentFile.isDirectory() || parentFile.mkdirs()) {
                            File file2 = new File(this.f19236f);
                            this.f19234d = file2;
                            if (!file2.isDirectory()) {
                                long length = this.f19233c.length();
                                if (this.f19231a.startsWith("www.")) {
                                    str = this.f19231a.substring(4);
                                } else {
                                    str = this.f19231a;
                                }
                                this.f19232b = str;
                                if (length > 0) {
                                    SharedPreferences sharedPreferences = GlobalObject.getContext().getSharedPreferences("breakpointDownloadSupport", 0);
                                    if (!sharedPreferences.contains(this.f19232b) || !sharedPreferences.getBoolean(this.f19232b, false)) {
                                        try {
                                            PrintWriter printWriter = new PrintWriter(this.f19233c);
                                            printWriter.print("");
                                            printWriter.close();
                                        } catch (FileNotFoundException unused) {
                                        }
                                    } else {
                                        this.f19235e = length;
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (URISyntaxException e10) {
                    e10.printStackTrace();
                    return;
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            Request.Builder url = new Request.Builder().url(this.f19237g);
            while (true) {
                String[] strArr = this.f19241w;
                if (i10 >= strArr.length / 2) {
                    break;
                }
                int i11 = i10 * 2;
                url.addHeader(strArr[i11], strArr[i11 + 1]);
                i10++;
            }
            if (this.f19235e > 0) {
                url.addHeader("RANGE", "bytes=" + this.f19235e + "-");
            }
            Call newCall = this.f19239i._httpClient.newCall(url.build());
            if (newCall == null) {
                CocosHelper.runOnGameThread(new b("Can't create DownloadTask for " + this.f19237g));
            } else {
                this.f19239i._taskMap.put(Integer.valueOf(this.f19240j), newCall);
            }
            newCall.enqueue(new C0242c());
        }
    }

    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19248b;

        d(int i10) {
            this.f19248b = i10;
        }

        public void run() {
            for (Map.Entry entry : CocosDownloader.this._taskMap.entrySet()) {
                Object key = entry.getKey();
                Call call = (Call) entry.getValue();
                if (call != null && Integer.parseInt(key.toString()) == this.f19248b) {
                    call.cancel();
                    CocosDownloader.this._taskMap.remove(Integer.valueOf(this.f19248b));
                    CocosDownloader.this.runNextTaskIfExists();
                    return;
                }
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            for (Map.Entry value : CocosDownloader.this._taskMap.entrySet()) {
                Call call = (Call) value.getValue();
                if (call != null) {
                    call.cancel();
                }
            }
        }
    }

    public static void abort(CocosDownloader cocosDownloader, int i10) {
        GlobalObject.runOnUiThread(new d(i10));
    }

    public static void cancelAllRequests(CocosDownloader cocosDownloader) {
        GlobalObject.runOnUiThread(new e());
    }

    public static CocosDownloader createDownloader(int i10, int i11, String str, int i12) {
        boolean z10;
        CocosDownloader cocosDownloader = new CocosDownloader();
        cocosDownloader._id = i10;
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        CocosMahAgent cocosMahAgent = mahAgent;
        if (cocosMahAgent != null) {
            z10 = cocosMahAgent.setDownloadClient(cocosDownloader, i11, dispatcher);
        } else {
            z10 = false;
        }
        if (!z10) {
            if (i11 > 0) {
                cocosDownloader._httpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).connectTimeout((long) i11, TimeUnit.SECONDS).protocols(Collections.singletonList(Protocol.HTTP_1_1)).build();
            } else {
                cocosDownloader._httpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1)).build();
            }
        }
        cocosDownloader._tempFileNameSuffix = str;
        cocosDownloader._countOfMaxProcessingTasks = i12;
        return cocosDownloader;
    }

    public static void createTask(CocosDownloader cocosDownloader, int i10, String str, String str2, String[] strArr) {
        cocosDownloader.enqueueTask(new c(str2, str, (str2 + str.hashCode()) + cocosDownloader._tempFileNameSuffix, cocosDownloader, i10, strArr));
    }

    private void enqueueTask(Runnable runnable) {
        synchronized (this._taskQueue) {
            try {
                if (this._runningTaskCount < this._countOfMaxProcessingTasks) {
                    GlobalObject.runOnUiThread(runnable);
                    this._runningTaskCount++;
                } else {
                    this._taskQueue.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onFinish(int i10, int i11, String str, byte[] bArr) {
        if (this._taskMap.get(Integer.valueOf(i10)) != null) {
            this._taskMap.remove(Integer.valueOf(i10));
            this._runningTaskCount--;
            CocosHelper.runOnGameThread(new b(i10, i11, str, bArr));
            runNextTaskIfExists();
        }
    }

    /* access modifiers changed from: private */
    public void onProgress(int i10, long j10, long j11, long j12) {
        CocosHelper.runOnGameThread(new a(i10, j10, j11, j12));
    }

    /* access modifiers changed from: private */
    public void runNextTaskIfExists() {
        synchronized (this._taskQueue) {
            while (this._runningTaskCount < this._countOfMaxProcessingTasks && this._taskQueue.size() > 0) {
                try {
                    GlobalObject.runOnUiThread(this._taskQueue.poll());
                    this._runningTaskCount++;
                } finally {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public native void nativeOnFinish(int i10, int i11, int i12, String str, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void nativeOnProgress(int i10, int i11, long j10, long j11, long j12);

    public void setHttpClient(OkHttpClient okHttpClient) {
        this._httpClient = okHttpClient;
    }
}

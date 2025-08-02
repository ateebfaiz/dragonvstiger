package g1;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import s1.a;
import u1.f;

public abstract class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static Queue f21572a;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.ArrayList a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.Class<g1.a0> r0 = g1.a0.class
            monitor-enter(r0)
            r1 = 0
            if (r7 != 0) goto L_0x0012
            java.lang.String r7 = "MsgQueueUtils"
            java.lang.String r8 = "unexcepted , context is null"
            s1.a.h(r7, r8)     // Catch:{ all -> 0x000f }
            monitor-exit(r0)
            return r1
        L_0x000f:
            r7 = move-exception
            goto L_0x0082
        L_0x0012:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x000f }
            r2.<init>()     // Catch:{ all -> 0x000f }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0055 }
            java.io.File r4 = r7.getFilesDir()     // Catch:{ all -> 0x0055 }
            r3.<init>(r4, r8)     // Catch:{ all -> 0x0055 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0057
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0055 }
            r4.<init>(r3)     // Catch:{ all -> 0x0055 }
            byte[] r1 = u1.o.b(r4)     // Catch:{ all -> 0x004e }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ all -> 0x004e }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x004e }
            r5.<init>(r1)     // Catch:{ all -> 0x004e }
            r3.<init>(r5)     // Catch:{ all -> 0x004e }
            r1 = 0
        L_0x003a:
            int r5 = r3.length()     // Catch:{ all -> 0x004e }
            if (r1 >= r5) goto L_0x0050
            org.json.JSONObject r5 = r3.getJSONObject(r1)     // Catch:{ all -> 0x004e }
            g1.x r5 = g1.x.a(r5)     // Catch:{ all -> 0x004e }
            r2.add(r5)     // Catch:{ all -> 0x004e }
            int r1 = r1 + 1
            goto L_0x003a
        L_0x004e:
            r1 = move-exception
            goto L_0x0052
        L_0x0050:
            r1 = r4
            goto L_0x0057
        L_0x0052:
            r3 = r1
            r1 = r4
            goto L_0x005b
        L_0x0055:
            r3 = move-exception
            goto L_0x005b
        L_0x0057:
            u1.o.a(r1)     // Catch:{ all -> 0x000f }
            goto L_0x007b
        L_0x005b:
            java.lang.String r4 = "MsgQueueUtils"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r5.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r6 = "load objects error:"
            r5.append(r6)     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x007d }
            r5.append(r3)     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x007d }
            s1.a.h(r4, r3)     // Catch:{ all -> 0x007d }
            d(r7, r8)     // Catch:{ all -> 0x007d }
            u1.o.a(r1)     // Catch:{ all -> 0x000f }
        L_0x007b:
            monitor-exit(r0)
            return r2
        L_0x007d:
            r7 = move-exception
            u1.o.a(r1)     // Catch:{ all -> 0x000f }
            throw r7     // Catch:{ all -> 0x000f }
        L_0x0082:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.a0.a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public static synchronized void b(Context context, String str, ArrayList arrayList) {
        synchronized (a0.class) {
            a.a("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                a.h("MsgQueueUtils", "unexcepted , context is null");
                return;
            } else if (arrayList == null) {
                a.h("MsgQueueUtils", "mObjectList is null");
                return;
            } else {
                try {
                    File file = new File(context.getFilesDir(), str);
                    JSONArray jSONArray = new JSONArray();
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        jSONArray.put(((x) arrayList.get(i10)).b());
                    }
                    f.d(file.getAbsolutePath(), jSONArray.toString());
                } catch (Throwable th) {
                    a.e("MsgQueueUtils", "save Objects  error:" + th.getMessage());
                }
            }
        }
    }

    public static boolean c(Context context, x xVar) {
        if (f21572a == null) {
            f21572a = new ConcurrentLinkedQueue();
            try {
                ArrayList a10 = a(context, "msg_queue_v350_privates");
                if (a10 != null && !a10.isEmpty()) {
                    Iterator it = a10.iterator();
                    while (it.hasNext()) {
                        f21572a.offer((x) it.next());
                    }
                }
            } catch (Exception e10) {
                a.e("MsgQueueUtils", "init lastMsgQueue failed:" + e10.getMessage());
            }
        }
        if (context == null) {
            a.e("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (xVar == null) {
            a.e("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f21572a.contains(xVar)) {
            a.b("MsgQueueUtils", "Duplicated msg. Give up processing - " + xVar);
            return true;
        }
        if (f21572a.size() >= 200) {
            f21572a.poll();
        }
        f21572a.offer(xVar);
        try {
            ArrayList a11 = a(context, "msg_queue_v350_privates");
            if (a11 == null) {
                a11 = new ArrayList();
            }
            if (a11.size() >= 50) {
                a11.remove(0);
            }
            a11.add(xVar);
            b(context, "msg_queue_v350_privates", a11);
        } catch (Exception e11) {
            a.e("MsgQueueUtils", "msg save in sp failed:" + e11.getMessage());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void d(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.Class<g1.a0> r0 = g1.a0.class
            monitor-enter(r0)
            if (r2 != 0) goto L_0x0010
            java.lang.String r2 = "MsgQueueUtils"
            java.lang.String r3 = "unexcepted , context is null"
            s1.a.h(r2, r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)
            return
        L_0x000e:
            r2 = move-exception
            goto L_0x002f
        L_0x0010:
            java.io.File r2 = r2.getFilesDir()     // Catch:{ all -> 0x000e }
            if (r2 != 0) goto L_0x001f
            java.lang.String r2 = "MsgQueueUtils"
            java.lang.String r3 = "can't get files dir"
            s1.a.h(r2, r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)
            return
        L_0x001f:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x000e }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x000e }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x002d
            r1.delete()     // Catch:{ all -> 0x000e }
        L_0x002d:
            monitor-exit(r0)
            return
        L_0x002f:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.a0.d(android.content.Context, java.lang.String):void");
    }
}

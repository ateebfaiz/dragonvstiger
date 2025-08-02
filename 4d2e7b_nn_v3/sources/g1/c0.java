package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.push.api.AliasMessage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import z1.a;

public class c0 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c0 f21576c;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap f21577b = new ConcurrentHashMap();

    public static c0 e() {
        if (f21576c == null) {
            synchronized (c0.class) {
                f21576c = new c0();
            }
        }
        return f21576c;
    }

    public final int b(String str) {
        int a10 = a();
        if (a10 != 0) {
            return a10;
        }
        if (TextUtils.isEmpty(str)) {
            return a.C0362a.f24999b;
        }
        if (str.getBytes().length > 40) {
            return a.C0362a.f25000c;
        }
        if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
            return a.C0362a.f24999b;
        }
        return 0;
    }

    public void c(Context context, int i10, Bundle bundle) {
        MTCommonReceiver f10;
        try {
            bundle.setClassLoader(AliasMessage.class.getClassLoader());
            AliasMessage aliasMessage = (AliasMessage) bundle.getParcelable("alias");
            if (aliasMessage != null && (f10 = p1.a.f(context)) != null) {
                switch (i10) {
                    case 3017:
                    case 3018:
                    case 3019:
                        f10.onAliasMessage(context, aliasMessage);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTAliasBusiness", "processMainMessage failed " + th.getMessage());
        }
    }

    public void d(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            if (mTProtocol != null) {
                int c10 = (int) mTProtocol.c();
                this.f21577b.remove(Integer.valueOf(c10));
                AliasMessage a10 = new AliasMessage().c(c10).b(a.C0362a.f24998a).a((String) this.f21577b.get(Integer.valueOf(c10)));
                s1.a.a("MTAliasBusiness", "onAliasOperationFailed sequence:" + c10 + ", aliasMessage:" + a10.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("alias", a10);
                h1.a.i(context, 3017, bundle2);
            }
        } catch (Throwable th) {
            s1.a.h("MTAliasBusiness", "onAliasOperationFailed failed " + th.getMessage());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.content.Context r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            java.lang.String r0 = "MTAliasBusiness"
            java.lang.String r1 = "alias"
            java.lang.String r2 = "sequence"
            int r2 = r9.getInt(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = r9.getString(r1)     // Catch:{ all -> 0x0039 }
            switch(r8) {
                case 3981: goto L_0x0042;
                case 3982: goto L_0x003f;
                case 3983: goto L_0x0014;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.String r8 = ""
            goto L_0x0044
        L_0x0014:
            int r8 = r6.b(r9)     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x003c
            com.engagelab.privates.push.api.AliasMessage r3 = new com.engagelab.privates.push.api.AliasMessage     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.push.api.AliasMessage r2 = r3.c(r2)     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.push.api.AliasMessage r8 = r2.b(r8)     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.push.api.AliasMessage r8 = r8.a(r9)     // Catch:{ all -> 0x0039 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r9.<init>()     // Catch:{ all -> 0x0039 }
            r9.putParcelable(r1, r8)     // Catch:{ all -> 0x0039 }
            r8 = 3017(0xbc9, float:4.228E-42)
            h1.a.i(r7, r8, r9)     // Catch:{ all -> 0x0039 }
            return
        L_0x0039:
            r7 = move-exception
            goto L_0x00c1
        L_0x003c:
            java.lang.String r8 = "set"
            goto L_0x0044
        L_0x003f:
            java.lang.String r8 = "get"
            goto L_0x0044
        L_0x0042:
            java.lang.String r8 = "del"
        L_0x0044:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "platform"
            java.lang.String r5 = "a"
            r3.put(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "op"
            r3.put(r4, r8)     // Catch:{ all -> 0x0039 }
            boolean r8 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0039 }
            if (r8 != 0) goto L_0x0067
            java.util.concurrent.ConcurrentHashMap r8 = r6.f21577b     // Catch:{ all -> 0x0039 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
            r8.put(r4, r9)     // Catch:{ all -> 0x0039 }
            r3.put(r1, r9)     // Catch:{ all -> 0x0039 }
        L_0x0067:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r8.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = "sendAliasOperation sequence:"
            r8.append(r9)     // Catch:{ all -> 0x0039 }
            r8.append(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = ", content:"
            r8.append(r9)     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = s1.a.g(r3)     // Catch:{ all -> 0x0039 }
            r8.append(r9)     // Catch:{ all -> 0x0039 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0039 }
            s1.a.a(r0, r8)     // Catch:{ all -> 0x0039 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0039 }
            byte[] r8 = g1.d.d(r8)     // Catch:{ all -> 0x0039 }
            if (r8 != 0) goto L_0x0092
            return
        L_0x0092:
            com.engagelab.privates.core.api.MTProtocol r9 = new com.engagelab.privates.core.api.MTProtocol     // Catch:{ all -> 0x0039 }
            r9.<init>()     // Catch:{ all -> 0x0039 }
            long r1 = (long) r2     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.core.api.MTProtocol r9 = r9.h(r1)     // Catch:{ all -> 0x0039 }
            r1 = 29
            com.engagelab.privates.core.api.MTProtocol r9 = r9.g(r1)     // Catch:{ all -> 0x0039 }
            r1 = 1
            com.engagelab.privates.core.api.MTProtocol r9 = r9.j(r1)     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.core.api.MTProtocol r8 = r9.f(r8)     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = y1.a.f24870a     // Catch:{ all -> 0x0039 }
            com.engagelab.privates.core.api.MTProtocol r8 = r8.i(r9)     // Catch:{ all -> 0x0039 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r9.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "protocol"
            r9.putParcelable(r1, r8)     // Catch:{ all -> 0x0039 }
            r8 = 2222(0x8ae, float:3.114E-42)
            h1.a.j(r7, r8, r9)     // Catch:{ all -> 0x0039 }
            goto L_0x00d9
        L_0x00c1:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "sendAliasOperation failed "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            s1.a.h(r0, r7)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c0.f(android.content.Context, int, android.os.Bundle):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e A[Catch:{ all -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(android.content.Context r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "MTAliasBusiness"
            java.lang.String r1 = "protocol"
            android.os.Parcelable r10 = r10.getParcelable(r1)     // Catch:{ all -> 0x006f }
            com.engagelab.privates.core.api.MTProtocol r10 = (com.engagelab.privates.core.api.MTProtocol) r10     // Catch:{ all -> 0x006f }
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            long r1 = r10.c()     // Catch:{ all -> 0x006f }
            int r1 = (int) r1     // Catch:{ all -> 0x006f }
            byte[] r10 = r10.a()     // Catch:{ all -> 0x006f }
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)     // Catch:{ all -> 0x006f }
            java.lang.String r10 = u1.m.f(r10)     // Catch:{ all -> 0x006f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x006f }
            r2.<init>(r10)     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r10.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "onAliasOperationSuccess sequence:"
            r10.append(r3)     // Catch:{ all -> 0x006f }
            r10.append(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = ", content:"
            r10.append(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = s1.a.g(r2)     // Catch:{ all -> 0x006f }
            r10.append(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x006f }
            s1.a.a(r0, r10)     // Catch:{ all -> 0x006f }
            java.lang.String r10 = "code"
            int r10 = r2.optInt(r10)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "op"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x006f }
            int r4 = r3.hashCode()     // Catch:{ all -> 0x006f }
            r5 = 99339(0x1840b, float:1.39204E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L_0x007c
            r5 = 102230(0x18f56, float:1.43255E-40)
            if (r4 == r5) goto L_0x0072
            r5 = 113762(0x1bc62, float:1.59415E-40)
            if (r4 == r5) goto L_0x0065
            goto L_0x0086
        L_0x0065:
            java.lang.String r4 = "set"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0086
            r3 = 0
            goto L_0x0087
        L_0x006f:
            r9 = move-exception
            goto L_0x00e8
        L_0x0072:
            java.lang.String r4 = "get"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0086
            r3 = r7
            goto L_0x0087
        L_0x007c:
            java.lang.String r4 = "del"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0086
            r3 = r6
            goto L_0x0087
        L_0x0086:
            r3 = -1
        L_0x0087:
            java.lang.String r4 = "alias"
            r5 = 3017(0xbc9, float:4.228E-42)
            if (r3 == 0) goto L_0x009e
            if (r3 == r7) goto L_0x0097
            java.lang.String r2 = ""
            if (r3 == r6) goto L_0x0094
            goto L_0x00b3
        L_0x0094:
            r5 = 3019(0xbcb, float:4.23E-42)
            goto L_0x00b3
        L_0x0097:
            java.lang.String r2 = r2.optString(r4)     // Catch:{ all -> 0x006f }
            r5 = 3018(0xbca, float:4.229E-42)
            goto L_0x00b3
        L_0x009e:
            java.util.concurrent.ConcurrentHashMap r2 = r8.f21577b     // Catch:{ all -> 0x006f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x006f }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x006f }
            java.util.concurrent.ConcurrentHashMap r3 = r8.f21577b     // Catch:{ all -> 0x006f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x006f }
            r3.remove(r6)     // Catch:{ all -> 0x006f }
        L_0x00b3:
            com.engagelab.privates.push.api.AliasMessage r3 = new com.engagelab.privates.push.api.AliasMessage     // Catch:{ all -> 0x006f }
            r3.<init>()     // Catch:{ all -> 0x006f }
            com.engagelab.privates.push.api.AliasMessage r1 = r3.c(r1)     // Catch:{ all -> 0x006f }
            com.engagelab.privates.push.api.AliasMessage r10 = r1.b(r10)     // Catch:{ all -> 0x006f }
            com.engagelab.privates.push.api.AliasMessage r10 = r10.a(r2)     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = "onAliasOperationSuccess aliasMessage:"
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x006f }
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006f }
            s1.a.a(r0, r1)     // Catch:{ all -> 0x006f }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            r1.putParcelable(r4, r10)     // Catch:{ all -> 0x006f }
            h1.a.i(r9, r5, r1)     // Catch:{ all -> 0x006f }
            goto L_0x0100
        L_0x00e8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "onAliasOperationSuccess failed "
            r10.append(r1)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            s1.a.h(r0, r9)
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.c0.g(android.content.Context, android.os.Bundle):void");
    }
}

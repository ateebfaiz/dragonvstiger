package g1;

import android.content.Context;
import android.os.Build;
import java.nio.ByteBuffer;
import java.util.Iterator;
import s1.a;
import t1.b;
import u1.e;
import u1.m;
import u1.n;

public abstract class o {
    public static int a(Context context, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s10 = wrap.getShort();
        n.i(context, s10);
        if (s10 == 0) {
            int i10 = wrap.getInt();
            wrap.getShort();
            m.f(wrap);
            int i11 = wrap.getInt();
            wrap.get();
            n.r(context, i10);
            n.d(context, (long) i11);
            a.a("MTCoreProtocol", "onLoginSuccess seedId:" + i10 + ", serverTime:" + i11);
        } else if (s10 != 108) {
            String f10 = m.f(wrap);
            a.b("MTCoreProtocol", "login failed code:" + s10 + ", message:" + f10);
        } else {
            n.j(context, 0);
            n.n(context, "");
            n.k(context, "");
            n.r(context, 0);
            n.d(context, 0);
            a.b("MTCoreProtocol", "onLoginFailed, will re-register");
        }
        return s10;
    }

    public static String b() {
        int d10;
        Iterator it = t1.a.b().f24068a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.i() && i10 < (d10 = bVar.d())) {
                i10 = d10;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 1; i11 <= i10; i11++) {
            Iterator it2 = t1.a.b().f24068a.iterator();
            while (it2.hasNext()) {
                b bVar2 = (b) it2.next();
                if (bVar2.i() && bVar2.d() == i11) {
                    String[] split = bVar2.e().split("\\.");
                    sb2.append((Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]));
                }
            }
        }
        return sb2.toString();
    }

    public static String c(Context context) {
        return Build.VERSION.RELEASE.toLowerCase() + "," + Build.VERSION.SDK_INT + "$$" + Build.MODEL.toLowerCase() + "$$" + "" + "$$" + Build.DEVICE.toLowerCase() + "$$" + p1.a.a(context) + "$$" + e() + "$$" + n.c(context) + "$$" + e.g(context) + "$$" + Build.MANUFACTURER.toLowerCase();
    }

    public static int d(Context context, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s10 = wrap.getShort();
        n.m(context, s10);
        if (s10 != 0) {
            String f10 = m.f(wrap);
            a.b("MTCoreProtocol", "onRegisterFailed code:" + s10 + ", message:" + f10);
        } else {
            long j10 = wrap.getLong();
            String f11 = m.f(wrap);
            String f12 = m.f(wrap);
            n.j(context, j10);
            n.n(context, f12);
            n.k(context, f11);
            a.a("MTCoreProtocol", "onRegisterSuccess uid:" + j10 + ", registrationId:" + f12 + ", password:" + f11);
        }
        return s10;
    }

    public static String e() {
        int d10;
        Iterator it = t1.a.b().f24068a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.i() && i10 < (d10 = bVar.d())) {
                i10 = d10;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 <= i10; i11++) {
            Iterator it2 = t1.a.b().f24068a.iterator();
            while (it2.hasNext()) {
                b bVar2 = (b) it2.next();
                if (bVar2.i() && bVar2.d() == i11) {
                    sb2.append(bVar2.e());
                    sb2.append("|");
                }
            }
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public static String f(Context context) {
        String n10 = p1.a.n(context);
        return "0$$" + n10 + "$$ $$ $$ $$ ";
    }

    public static short g() {
        int d10;
        Iterator it = t1.a.b().f24068a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.i() && i10 < (d10 = bVar.d())) {
                i10 = d10;
            }
        }
        short s10 = 0;
        for (int i11 = 0; i11 <= i10; i11++) {
            Iterator it2 = t1.a.b().f24068a.iterator();
            while (it2.hasNext()) {
                b bVar2 = (b) it2.next();
                if (bVar2.i() && bVar2.d() == i11) {
                    s10 = (short) (s10 | bVar2.b());
                }
            }
        }
        return s10;
    }

    public static byte[] h(Context context) {
        w1.b bVar = new w1.b(1);
        bVar.l(g());
        return bVar.d();
    }

    public static byte[] i(Context context) {
        String i10 = m.i(n.v(context));
        String b10 = b();
        String b11 = p1.a.b(context);
        short g10 = g();
        byte w10 = n.w(context);
        int v10 = p1.a.v();
        String a10 = m1.a.a(context);
        String j10 = p1.a.j(context);
        a.b("MTCoreProtocol", "login with uid:" + n.G(context) + ", registrationId:" + n.y(context) + ", platform:" + w10);
        byte[] bytes = i10.getBytes();
        byte[] bytes2 = b10.getBytes();
        byte[] bytes3 = b11.getBytes();
        byte[] bytes4 = a10.getBytes();
        byte[] bytes5 = "".getBytes();
        byte[] bytes6 = j10.getBytes();
        byte[] bytes7 = "".getBytes();
        w1.b bVar = new w1.b(bytes.length + 4 + bytes2.length + bytes3.length + 7 + bytes4.length + bytes5.length + bytes6.length + bytes7.length);
        bVar.l(97);
        bVar.l(0);
        bVar.h(0);
        bVar.g(bytes);
        bVar.g(bytes2);
        bVar.g(bytes3);
        bVar.l(0);
        bVar.j((long) g10);
        bVar.l(w10);
        bVar.l(v10);
        bVar.g(bytes4);
        bVar.g(bytes5);
        bVar.g(bytes6);
        bVar.g(bytes7);
        return bVar.d();
    }

    public static byte[] j(Context context) {
        n.j(context, 0);
        n.n(context, "");
        n.k(context, "");
        n.r(context, 0);
        n.d(context, 0);
        String str = " $$ $$" + context.getPackageName() + "$$" + p1.a.b(context);
        String e10 = p1.a.e(context);
        String c10 = c(context);
        String f10 = f(context);
        short g10 = g();
        a.a("MTCoreProtocol", "register with clientInfo:" + c10 + ", deviceInfo:" + f10);
        byte[] bytes = str.getBytes();
        byte[] bytes2 = e10.getBytes();
        byte[] bytes3 = c10.getBytes();
        byte[] bytes4 = f10.getBytes();
        byte[] bytes5 = "".getBytes();
        w1.b bVar = new w1.b(bytes.length + bytes2.length + bytes3.length + 1 + bytes4.length + 4 + bytes5.length);
        bVar.g(bytes);
        bVar.g(bytes2);
        bVar.g(bytes3);
        bVar.l(0);
        bVar.g(bytes4);
        bVar.j((long) g10);
        bVar.g(bytes5);
        return bVar.d();
    }
}

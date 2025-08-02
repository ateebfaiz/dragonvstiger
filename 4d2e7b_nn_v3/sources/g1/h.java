package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.engagelab.privates.core.api.MTProtocol;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import s1.a;
import u1.l;
import u1.n;
import w1.b;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap f21590a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f21591b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21592c;

    public final MTProtocol a(Context context, byte[] bArr) {
        byte b10;
        byte b11;
        byte b12;
        byte[] c10;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        try {
            MTProtocol mTProtocol = new MTProtocol();
            byte[] bArr3 = new byte[2];
            System.arraycopy(bArr2, 0, bArr3, 0, 2);
            short s10 = ByteBuffer.wrap(bArr3).getShort();
            int i10 = (s10 >>> 14) & 1;
            byte b13 = s10 & 16383;
            a.a(b(), "receive ahead length:2, encryption:" + ((s10 >>> 15) & 1) + ", expand:" + i10 + ", totalLength:" + b13);
            int i11 = b13 + -2;
            byte[] bArr4 = new byte[i11];
            System.arraycopy(bArr2, 2, bArr4, 0, i11);
            ByteBuffer wrap = ByteBuffer.wrap(bArr4);
            if (i10 == 1) {
                b11 = wrap.get();
                b10 = wrap.get();
            } else {
                b11 = 20;
                b10 = 0;
            }
            byte b14 = wrap.get() ^ 90;
            byte b15 = wrap.get() ^ 90;
            long j10 = wrap.getLong() ^ 6510615555426900570L;
            byte b16 = b13;
            long j11 = wrap.getLong() ^ 6510615555426900570L;
            short s11 = wrap.getShort();
            if (i10 == 1 && b10 == 1) {
                b12 = wrap.get();
            } else {
                b12 = 0;
            }
            mTProtocol.g(b14);
            mTProtocol.j(b15);
            mTProtocol.h(j11);
            try {
                a.a(b(), "receive head  length:" + b11 + ", headVersion:" + b10 + ", command:" + b14 + ", version:" + b15 + ", uid:" + j10 + ", rid:" + j11 + ", crc16:" + s11 + ", encrypt:" + b12);
                int i12 = (b16 - b11) - 2;
                byte[] bArr5 = new byte[i12];
                System.arraycopy(bArr4, b11, bArr5, 0, i12);
                String j12 = u1.a.j(n.G(context));
                if (b12 == 0) {
                    c10 = u1.a.c(bArr5, j12);
                } else if (b12 == 1) {
                    c10 = u1.a.d(bArr5, j12, j12.substring(0, 16));
                } else if (b12 != 2) {
                    mTProtocol.f(bArr5);
                    a.a(b(), "receive body  length:" + i12 + ", decryptBodyLength:" + bArr5.length);
                    return mTProtocol;
                } else {
                    c10 = l.h(bArr5, j12);
                }
                bArr5 = c10;
                mTProtocol.f(bArr5);
                a.a(b(), "receive body  length:" + i12 + ", decryptBodyLength:" + bArr5.length);
                return mTProtocol;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public abstract String b();

    public void c(Context context) {
        a.a(b(), "tcp disconnect");
        this.f21591b = false;
        h1.a.f(context, v1.a.f24387a, 2992);
        try {
            g(context);
        } catch (Throwable th) {
            String b10 = b();
            a.h(b10, "disconnect failed " + th.getMessage());
        }
    }

    public void d(Context context, Bundle bundle) {
        if (bundle == null) {
            try {
                a.a(b(), "can't send, bundle is null");
            } catch (Throwable th) {
                String b10 = b();
                a.h(b10, "send failed " + th.getMessage());
                c(context);
            }
        } else if (bundle.containsKey("data")) {
            if (this.f21591b) {
                if (n.b(context)) {
                    i(context, bundle.getByteArray("data"));
                    return;
                }
            }
            a.a(b(), "can't send data, tcp is not connected");
            c(context);
        } else {
            bundle.setClassLoader(MTProtocol.class.getClassLoader());
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable("protocol");
            if (!n.b(context)) {
                String b11 = b();
                a.a(b11, "can't send command:" + mTProtocol.b() + ", network is disConnected");
                c(context);
                h1.a.h(context, mTProtocol.d(), mTProtocol.b(), bundle, 0);
            } else if (!this.f21591b) {
                String b12 = b();
                a.a(b12, "can't send command:" + mTProtocol.b() + ", tcp is disConnected");
                c(context);
                h1.a.h(context, mTProtocol.d(), mTProtocol.b(), bundle, 0);
            } else {
                if (mTProtocol.c() == 0) {
                    mTProtocol.h(x1.a.h());
                }
                String b13 = b();
                a.a(b13, "send " + mTProtocol.toString());
                String d10 = mTProtocol.d();
                byte[] f10 = f(context, mTProtocol);
                if (f10 != null) {
                    i(context, f10);
                    if (!TextUtils.isEmpty(d10)) {
                        this.f21590a.put(mTProtocol, d10);
                        h1.a.h(context, d10, mTProtocol.b(), bundle, WorkRequest.MIN_BACKOFF_MILLIS);
                    }
                }
            }
        }
    }

    public final boolean e(Context context, String str, int i10) {
        try {
            if (!n.b(context)) {
                a.b(b(), "can't connect, network is disConnected");
                return false;
            }
            String b10 = b();
            a.a(b10, "tcp connect " + str + ":" + i10);
            if (k(context, str, i10)) {
                a.a(b(), "tcp connect success");
                this.f21591b = true;
                return true;
            }
            return false;
        } catch (Throwable th) {
            String b11 = b();
            a.h(b11, "tcp connect failed " + th.getMessage());
            c(context);
        }
    }

    public final byte[] f(Context context, MTProtocol mTProtocol) {
        int i10;
        int i11;
        int i12;
        try {
            int b10 = mTProtocol.b();
            int e10 = mTProtocol.e();
            long G = n.G(context);
            int z10 = n.z(context);
            long c10 = mTProtocol.c();
            int o10 = p1.a.o();
            if (o10 == 1 || o10 == 2) {
                i11 = 27;
                i10 = 1;
            } else {
                i11 = 24;
                i10 = 0;
            }
            b bVar = new b(i11);
            if (i10 != 0) {
                bVar.l(i11);
                bVar.l(i10);
                i12 = 1;
            } else {
                i12 = 0;
            }
            bVar.l(b10 ^ 90);
            bVar.l(e10 ^ 90);
            bVar.k(G ^ 6510615555426900570L);
            bVar.j((long) z10);
            bVar.k(c10 ^ 6510615555426900570L);
            bVar.h(0);
            if (i10 == 1) {
                bVar.l(o10);
            }
            byte[] d10 = bVar.d();
            byte[] a10 = mTProtocol.a();
            String j10 = u1.a.j(n.G(context));
            if (o10 == 0) {
                a10 = u1.a.e(a10, j10);
            } else if (o10 == 1) {
                a10 = u1.a.f(a10, j10, j10.substring(0, 16));
            } else if (o10 == 2) {
                a10 = l.k(a10, j10, j10.substring(0, 16));
            }
            int length = a10.length;
            int i13 = i11 + 2;
            int i14 = i13 + length;
            byte[] bArr = a10;
            byte b11 = (byte) ((i14 >>> 8) & 255);
            int i15 = i13;
            byte[] bArr2 = {b11, (byte) (i14 & 255)};
            byte b12 = (byte) (b11 | 128);
            bArr2[0] = b12;
            if (i12 != 0) {
                bArr2[0] = (byte) (b12 | 64);
            }
            String b13 = b();
            StringBuilder sb2 = new StringBuilder();
            byte[] bArr3 = d10;
            sb2.append("send ahead length:2, encryption:");
            sb2.append(1);
            sb2.append(", expand:");
            sb2.append(i12);
            sb2.append(", totalLength:");
            sb2.append(i14);
            a.a(b13, sb2.toString());
            a.a(b(), "send head  length:" + i11 + ", headVersion:" + i10 + ", command:" + b10 + ", version:" + e10 + ", uid:" + G + ", rid:" + c10 + ", crc16:" + 0 + ", encrypt:" + o10);
            String b14 = b();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("send body  length:");
            sb3.append(length);
            a.a(b14, sb3.toString());
            byte[] bArr4 = new byte[i14];
            System.arraycopy(bArr2, 0, bArr4, 0, 2);
            System.arraycopy(bArr3, 0, bArr4, 2, i11);
            System.arraycopy(bArr, 0, bArr4, i15, length);
            return bArr4;
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract void g(Context context);

    public final void h(Context context, MTProtocol mTProtocol) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("protocol", mTProtocol);
        Iterator it = this.f21590a.keySet().iterator();
        while (it.hasNext()) {
            MTProtocol mTProtocol2 = (MTProtocol) it.next();
            if (mTProtocol2.c() == mTProtocol.c()) {
                String str = (String) this.f21590a.get(mTProtocol2);
                mTProtocol.i(str);
                String b10 = b();
                a.a(b10, "receive " + mTProtocol.toString());
                it.remove();
                h1.a.f(context, str, mTProtocol2.b());
                h1.a.g(context, str, mTProtocol.b(), bundle);
                return;
            }
        }
        Iterator it2 = t1.a.b().f24068a.iterator();
        while (it2.hasNext()) {
            t1.b bVar = (t1.b) it2.next();
            if (bVar.j(mTProtocol.b())) {
                String str2 = bVar.f()[0];
                mTProtocol.i(str2);
                String b11 = b();
                a.a(b11, "receive " + mTProtocol.toString());
                h1.a.g(context, str2, mTProtocol.b(), bundle);
            }
        }
    }

    public final void i(Context context, byte[] bArr) {
        try {
            if (!this.f21591b) {
                a.a(b(), "can't send, tcp is not connected");
                return;
            }
            boolean m10 = m(context, bArr);
            String b10 = b();
            a.a(b10, "sendImp :" + m10);
        } catch (IOException e10) {
            String message = e10.getMessage();
            String b11 = b();
            a.h(b11, "send IOException " + message);
            if (message != null && message.startsWith("MyCertificateException:")) {
                n.c(context, -1);
            }
            c(context);
        } catch (NotYetConnectedException e11) {
            String b12 = b();
            a.h(b12, "send NotYetConnectedException " + e11.getMessage());
            c(context);
        } catch (Throwable th) {
            String b13 = b();
            a.h(b13, "send throwable " + th.getMessage());
            c(context);
        }
    }

    public boolean j() {
        return this.f21591b;
    }

    public abstract boolean k(Context context, String str, int i10);

    public final boolean l(Context context) {
        MTProtocol i10 = new MTProtocol().h(x1.a.h()).g(1).j(23).f(o.i(context)).i(v1.a.f24389c);
        if (i10 == null) {
            a.h(b(), "login failed, send request failed");
            return false;
        }
        String b10 = b();
        a.a(b10, "send " + i10.toString());
        i(context, f(context, i10));
        MTProtocol a10 = a(context, o(context));
        if (a10 == null) {
            a.h(b(), "login failed, receive response failed");
            return false;
        }
        String b11 = b();
        a.a(b11, "receive " + a10.toString());
        if (o.a(context, a10.a()) == 0) {
            c.a().b(context);
            h1.a.i(context, 2001, (Bundle) null);
            h1.a.j(context, 2999, (Bundle) null);
            return true;
        }
        h1.a.i(context, 2002, (Bundle) null);
        h1.a.j(context, 2998, (Bundle) null);
        return false;
    }

    public abstract boolean m(Context context, byte[] bArr);

    public abstract List n(Context context);

    public abstract byte[] o(Context context);

    public final void p(Context context) {
        byte[] o10;
        a.a(b(), "receiving......");
        while (this.f21591b && (o10 = o(context)) != null) {
            MTProtocol a10 = a(context, o10);
            if (a10 == null) {
                a.a(b(), "parseResponse failed");
            } else {
                h(context, a10);
            }
        }
    }

    public final boolean q(Context context) {
        long G = n.G(context);
        String y10 = n.y(context);
        String v10 = n.v(context);
        String b10 = b();
        a.a(b10, "register uid:" + G + ",rid:" + y10 + ",password:" + v10);
        if (G > 0 && !TextUtils.isEmpty(y10) && !TextUtils.isEmpty(v10)) {
            return true;
        }
        MTProtocol i10 = new MTProtocol().h(x1.a.h()).g(0).j(19).f(o.j(context)).i(v1.a.f24389c);
        if (i10 == null) {
            a.h(b(), "register failed, send request failed");
            return false;
        }
        String b11 = b();
        a.a(b11, "send " + i10.toString());
        i(context, f(context, i10));
        MTProtocol a10 = a(context, o(context));
        if (a10 == null) {
            a.h(b(), "register failed, receive response failed");
            return false;
        }
        String b12 = b();
        a.a(b12, "receive " + a10.toString());
        if (o.d(context, a10.a()) == 0) {
            c.a().d(context);
            return true;
        }
        h1.a.i(context, 2002, (Bundle) null);
        h1.a.j(context, 2998, (Bundle) null);
        return false;
    }

    public void r(Context context) {
        this.f21592c = true;
        if (this.f21591b) {
            a.a(b(), "can't connect, isTcpConnecting");
            return;
        }
        this.f21591b = true;
        List n10 = n(context);
        if (n10.isEmpty()) {
            a.h(b(), "there are no tcp connect address");
            c(context);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(n10);
        int b10 = x1.a.b();
        for (int i10 = 0; i10 < b10; i10++) {
            a.a(b(), "connect retry count is " + i10);
            for (String str : arrayList) {
                if (!n.p(context)) {
                    a.a(b(), "can't connect ,connect state is false");
                    return;
                } else if (!this.f21592c) {
                    a.a(b(), "can't connect ,tcp state is false");
                    return;
                } else {
                    String[] split = str.split(":");
                    String str2 = split[split.length - 1];
                    if (!e(context, str.substring(0, (str.length() - str2.length()) - 1), Integer.parseInt(str2))) {
                        c(context);
                    } else if (!q(context)) {
                        c(context);
                    } else if (!l(context)) {
                        c(context);
                    } else {
                        p(context);
                    }
                }
            }
        }
    }

    public void s(Context context) {
        this.f21592c = false;
        c(context);
        h1.a.i(context, 2002, (Bundle) null);
        h1.a.j(context, 2998, (Bundle) null);
    }
}

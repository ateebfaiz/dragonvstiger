package g1;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.pdns.s.e.c;
import com.engagelab.privates.core.api.Address;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import s1.a;
import u1.g;
import u1.m;
import u1.n;
import w1.b;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public DatagramSocket f21598a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21599b;

    public final void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("http_report");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            Set q10 = n.q(context);
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                q10.add(c.f18246k + optJSONArray.get(i10));
            }
            n.f(context, q10);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("https_report");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            Set q11 = n.q(context);
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                q11.add(c.f18247l + optJSONArray2.get(i11));
            }
            n.f(context, q11);
        }
    }

    public final boolean b(Context context, String str, int i10) {
        try {
            if (TextUtils.isEmpty(str) || i10 <= 0) {
                return false;
            }
            a.a("UdpClient", "udp connect " + str + ":" + i10);
            InetAddress byName = InetAddress.getByName(str);
            byte[] d10 = d(context);
            if (d10 == null) {
                return false;
            }
            DatagramPacket datagramPacket = new DatagramPacket(d10, d10.length, byName, i10);
            DatagramSocket datagramSocket = new DatagramSocket();
            this.f21598a = datagramSocket;
            datagramSocket.setSoTimeout(6000);
            this.f21598a.send(datagramPacket);
            byte[] bArr = new byte[1024];
            this.f21598a.receive(new DatagramPacket(bArr, 1024));
            return c(context, bArr);
        } catch (Throwable th) {
            a.a("UdpClient", "udp connect failed " + th.getMessage());
            return false;
        }
    }

    public final boolean c(Context context, byte[] bArr) {
        byte[] bArr2;
        try {
            byte[] bArr3 = new byte[10];
            System.arraycopy(bArr, 0, bArr3, 0, 10);
            ByteBuffer wrap = ByteBuffer.wrap(bArr3);
            short s10 = wrap.getShort();
            wrap.getShort();
            int i10 = wrap.getInt();
            long j10 = (long) (16777215 & i10);
            wrap.getShort();
            int i11 = i10 >>> 28;
            int i12 = (i10 >>> 24) & 1;
            String j11 = u1.a.j(j10);
            a.a("UdpClient", "receive totalLength:" + s10 + ", encryption:" + i11 + ", compress:" + i12 + ", sid:" + j10);
            int i13 = s10 - 10;
            byte[] bArr4 = new byte[i13];
            System.arraycopy(bArr, 10, bArr4, 0, i13);
            if (i11 == 1) {
                bArr2 = u1.a.d(bArr4, j11, j11.substring(0, 16));
            } else if (i11 != 2) {
                bArr2 = u1.a.c(bArr4, j11);
            } else {
                bArr2 = u1.l.h(bArr4, j11);
            }
            if (i12 == 1) {
                bArr2 = g.b(bArr2);
            }
            JSONObject jSONObject = new JSONObject(new String(bArr2));
            a.a("UdpClient", "udp receive " + a.g(jSONObject));
            j(context, jSONObject);
            h(context, jSONObject);
            f(context, jSONObject);
            a(context, jSONObject);
            return true;
        } catch (Throwable th) {
            a.h("UdpClient", "parseResponse failed " + th.getMessage());
            return false;
        }
    }

    public final byte[] d(Context context) {
        int i10;
        byte b10;
        byte[] bArr;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", 0);
            jSONObject.put("sdkver", "3.6.0");
            jSONObject.put("appkey", p1.a.b(context));
            jSONObject.put("uid", n.G(context));
            jSONObject.put("type", p1.a.v());
            jSONObject.put("opera", p1.a.s());
            if (p1.a.x()) {
                int h10 = n.h(context);
                if (h10 == -1) {
                    h10 = 1;
                }
                jSONObject.put("cert_ver", h10);
            }
            a.a("UdpClient", "udp send:" + a.g(jSONObject));
            byte[] g10 = m.g(jSONObject.toString());
            byte[] c10 = g.c(g10);
            if (c10 == null) {
                i10 = 0;
            } else {
                g10 = c10;
                i10 = 1;
            }
            int length = g10.length;
            int h11 = u1.a.h();
            long j10 = (long) h11;
            String j11 = u1.a.j(j10);
            if (i10 != 0) {
                b10 = (byte) 1;
            } else {
                b10 = 0;
            }
            int o10 = p1.a.o();
            if (o10 == 1) {
                b10 = (byte) (b10 | 16);
                bArr = u1.a.f(g10, j11, j11.substring(0, 16));
            } else if (o10 != 2) {
                bArr = u1.a.e(g10, j11);
            } else {
                b10 = (byte) (b10 | 32);
                bArr = u1.l.k(g10, j11, j11.substring(0, 16));
            }
            b bVar = new b(bArr.length + 10);
            bVar.h(0);
            bVar.e("UG".getBytes());
            bVar.j(j10);
            bVar.m(b10, 4);
            bVar.h(length);
            bVar.e(bArr);
            bVar.i(bVar.b(), 0);
            a.a("UdpClient", "send totalLength:" + bVar.b() + ", encryption:" + o10 + ", compress:" + i10 + ", sid:" + h11);
            return bVar.d();
        } catch (Throwable th) {
            a.h("UdpClient", "packageRequest failed " + th.getMessage());
            return null;
        }
    }

    public final List e(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(g(context));
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public final void f(Context context, JSONObject jSONObject) {
        if (!p1.a.x()) {
            return;
        }
        if (jSONObject.has("cert_ver")) {
            int optInt = jSONObject.optInt("cert_ver");
            if (optInt != n.E(context)) {
                n.o(context, new LinkedHashSet());
            }
            n.u(context, optInt);
            JSONArray optJSONArray = jSONObject.optJSONArray("ssl_ips");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                Set D = n.D(context);
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    D.add(String.valueOf(optJSONArray.get(i10)));
                }
                n.o(context, D);
                return;
            }
            return;
        }
        a.a("UdpClient", "no has cert_ver");
        n.o(context, new LinkedHashSet());
    }

    public final Set g(Context context) {
        Set F = n.F(context);
        Address a10 = x1.a.a();
        int g10 = a10.g();
        if (g10 <= 0) {
            return F;
        }
        String[] e10 = a10.e();
        if (e10 != null && e10.length > 0) {
            for (String str : e10) {
                F.add(str + ":" + g10);
            }
        }
        String[] f10 = a10.f();
        if (f10 != null && f10.length > 0) {
            for (String str2 : f10) {
                F.add(str2 + ":" + g10);
            }
        }
        return F;
    }

    public final void h(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ips");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            Set C = n.C(context);
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                C.add(String.valueOf(optJSONArray.get(i10)));
            }
            n.l(context, C);
        }
    }

    public void i(Context context) {
        if (this.f21599b) {
            a.a("UdpClient", "can't connect, isUdpConnecting");
            return;
        }
        this.f21599b = true;
        List e10 = e(context);
        if (e10.isEmpty()) {
            a.a("UdpClient", "there are no udp connect address");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < 3; i10++) {
            arrayList.addAll(e10);
        }
        for (String str : arrayList) {
            if (!n.p(context)) {
                a.a("UdpClient", "can't connect ,connect state is false");
                l(context);
                return;
            } else if (!n.b(context)) {
                a.a("UdpClient", "can't connect, network is disConnected");
                return;
            } else {
                String[] split = str.split(":");
                String str2 = split[split.length - 1];
                if (b(context, str.substring(0, (str.length() - str2.length()) - 1), Integer.parseInt(str2))) {
                    k(context);
                    return;
                }
            }
        }
    }

    public final void j(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            Set F = n.F(context);
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                F.add(String.valueOf(optJSONArray.get(i10)));
            }
            n.s(context, F);
        }
    }

    public final void k(Context context) {
        if (p1.a.x()) {
            int h10 = n.h(context);
            int E = n.E(context);
            if (h10 != E || h10 == -1 || E == -1) {
                a.a("UdpClient", "connectSSL_crt_v：" + h10);
                a.a("UdpClient", "tcpAddressSSL_crt_v：" + E);
                boolean b10 = g.b(context);
                a.a("UdpClient", "get crt：" + b10);
            }
        }
    }

    public void l(Context context) {
        this.f21599b = false;
        if (this.f21598a != null) {
            a.a("UdpClient", "udp disconnect");
            this.f21598a.close();
        }
    }
}

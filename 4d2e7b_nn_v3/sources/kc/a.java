package kc;

import dd.c;
import hc.m;
import java.math.BigInteger;
import java.util.Hashtable;
import rc.d;
import rc.e;
import rc.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static e f496a = new C0005a();

    /* renamed from: b  reason: collision with root package name */
    static e f497b = new b();

    /* renamed from: c  reason: collision with root package name */
    static final Hashtable f498c = new Hashtable();

    /* renamed from: d  reason: collision with root package name */
    static final Hashtable f499d = new Hashtable();

    /* renamed from: e  reason: collision with root package name */
    static final Hashtable f500e = new Hashtable();

    /* renamed from: kc.a$a  reason: collision with other inner class name */
    static class C0005a extends e {
        C0005a() {
        }

        /* access modifiers changed from: protected */
        public d a() {
            BigInteger a10 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger a11 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger a12 = a.e("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger a13 = a.e("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger valueOf = BigInteger.valueOf(1);
            c b10 = a.c(new c.e(a10, a11, a12, a13, valueOf));
            return new d(b10, new f(b10, ae.d.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), a13, valueOf, (byte[]) null);
        }
    }

    static class b extends e {
        b() {
        }

        /* access modifiers changed from: protected */
        public d a() {
            BigInteger a10 = a.e("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger a11 = a.e("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger a12 = a.e("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger a13 = a.e("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger valueOf = BigInteger.valueOf(1);
            c b10 = a.c(new c.e(a10, a11, a12, a13, valueOf));
            return new d(b10, new f(b10, ae.d.a("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), a13, valueOf, (byte[]) null);
        }
    }

    static {
        d("wapip192v1", b.J, f497b);
        d("sm2p256v1", b.F, f496a);
    }

    /* access modifiers changed from: private */
    public static c c(c cVar) {
        return cVar;
    }

    static void d(String str, m mVar, e eVar) {
        f498c.put(zd.f.d(str), mVar);
        f500e.put(mVar, str);
        f499d.put(mVar, eVar);
    }

    /* access modifiers changed from: private */
    public static BigInteger e(String str) {
        return new BigInteger(1, ae.d.a(str));
    }

    public static d f(String str) {
        m h10 = h(str);
        if (h10 == null) {
            return null;
        }
        return g(h10);
    }

    public static d g(m mVar) {
        e eVar = (e) f499d.get(mVar);
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public static m h(String str) {
        return (m) f498c.get(zd.f.d(str));
    }
}

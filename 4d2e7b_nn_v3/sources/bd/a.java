package bd;

import c.d;
import com.alibaba.pdns.j;
import hc.m;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import kd.e;
import ud.c;
import wd.f;
import wd.g;

public final class a extends Provider {

    /* renamed from: a  reason: collision with root package name */
    private static String f31a = "BouncyCastle Security Provider v1.58";

    /* renamed from: b  reason: collision with root package name */
    public static final xc.a f32b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final Map f33c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f34d = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f35e = {"SipHash", "Poly1305"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f36f = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f37g = {"X509", "IES"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f38h = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f39i = {"GOST3411", "Keccak", "MD2", "MD4", j.f17955b, "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "DSTU7564"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f40j = {"BC", "BCFKS", "PKCS12"};

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f41w = {"DRBG"};

    /* renamed from: bd.a$a  reason: collision with other inner class name */
    class C0000a implements PrivilegedAction {
        C0000a() {
        }

        public Object run() {
            a.this.e();
            return null;
        }
    }

    public a() {
        super("SC", 1.58d, f31a);
        AccessController.doPrivileged(new C0000a());
    }

    private void c(String str, String[] strArr) {
        int i10 = 0;
        while (i10 != strArr.length) {
            Class a10 = yc.a.a(a.class, str + strArr[i10] + "$Mappings");
            if (a10 == null) {
                i10++;
            } else {
                try {
                    d.a(a10.newInstance());
                    throw null;
                } catch (Exception e10) {
                    throw new InternalError("cannot create instance of " + str + strArr[i10] + "$Mappings : " + e10);
                }
            }
        }
    }

    private void d() {
        b(e.f577r, new c());
        b(e.f581v, new sd.c());
        b(e.f582w, new f());
        b(e.B, new g());
        b(e.f572m, new rd.f());
        b(e.f573n, new rd.e());
        b(e.f560a, new td.c());
    }

    /* access modifiers changed from: private */
    public void e() {
        c("org.spongycastle.jcajce.provider.digest.", f39i);
        c("org.spongycastle.jcajce.provider.symmetric.", f34d);
        c("org.spongycastle.jcajce.provider.symmetric.", f35e);
        c("org.spongycastle.jcajce.provider.symmetric.", f36f);
        c("org.spongycastle.jcajce.provider.asymmetric.", f37g);
        c("org.spongycastle.jcajce.provider.asymmetric.", f38h);
        c("org.spongycastle.jcajce.provider.keystore.", f40j);
        c("org.spongycastle.jcajce.provider.drbg.", f41w);
        d();
        put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    public void b(m mVar, zc.a aVar) {
        Map map = f33c;
        synchronized (map) {
            map.put(mVar, aVar);
        }
    }
}

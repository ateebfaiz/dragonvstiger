package com.geetest.core;

import com.adjust.sdk.Constants;
import com.alibaba.pdns.j;
import com.geetest.core.s0;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateParsingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, String> f6084a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Integer, String> f6085b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Integer, String> f6086c;
    public i A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public Boolean K;
    public Boolean L;
    public Boolean M;
    public Boolean N;
    public Boolean O;

    /* renamed from: d  reason: collision with root package name */
    public Integer f6087d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f6088e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f6089f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f6090g;

    /* renamed from: h  reason: collision with root package name */
    public Long f6091h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f6092i;

    /* renamed from: j  reason: collision with root package name */
    public Date f6093j;

    /* renamed from: k  reason: collision with root package name */
    public Date f6094k;

    /* renamed from: l  reason: collision with root package name */
    public Date f6095l;

    /* renamed from: m  reason: collision with root package name */
    public Integer f6096m;

    /* renamed from: n  reason: collision with root package name */
    public Boolean f6097n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f6098o;

    /* renamed from: p  reason: collision with root package name */
    public Boolean f6099p;

    /* renamed from: q  reason: collision with root package name */
    public Boolean f6100q;

    /* renamed from: r  reason: collision with root package name */
    public String f6101r;

    /* renamed from: s  reason: collision with root package name */
    public Date f6102s;

    /* renamed from: t  reason: collision with root package name */
    public Boolean f6103t;

    /* renamed from: u  reason: collision with root package name */
    public Boolean f6104u;

    /* renamed from: v  reason: collision with root package name */
    public p f6105v;

    /* renamed from: w  reason: collision with root package name */
    public Integer f6106w;

    /* renamed from: x  reason: collision with root package name */
    public Integer f6107x;

    /* renamed from: y  reason: collision with root package name */
    public Integer f6108y;

    /* renamed from: z  reason: collision with root package name */
    public Integer f6109z;

    static {
        HashMap hashMap = new HashMap();
        f6084a = hashMap;
        hashMap.put(1, "NONE");
        hashMap.put(2, "OAEP");
        hashMap.put(3, "PSS");
        hashMap.put(4, "PKCS1 ENCRYPT");
        hashMap.put(5, "PKCS1 SIGN");
        hashMap.put(64, "PKCS7");
        HashMap hashMap2 = new HashMap();
        f6085b = hashMap2;
        hashMap2.put(0, "NONE");
        hashMap2.put(1, j.f17955b);
        hashMap2.put(2, "SHA1");
        hashMap2.put(3, "SHA224");
        hashMap2.put(4, "SHA256");
        hashMap2.put(5, "SHA384");
        hashMap2.put(6, "SHA512");
        HashMap hashMap3 = new HashMap();
        f6086c = hashMap3;
        hashMap3.put(1, "DECRYPT");
        hashMap3.put(0, "ENCRYPT");
        hashMap3.put(2, "SIGN");
        hashMap3.put(3, "VERIFY");
        hashMap3.put(5, "WRAP");
    }

    public n(v vVar) throws CertificateParsingException {
        if (vVar instanceof s0) {
            t0 l10 = ((s0) vVar).l();
            for (z0 a10 = a(l10); a10 != null; a10 = a(l10)) {
                int k10 = a10.k();
                p0 d10 = a10.j().d();
                if (k10 == 1) {
                    c.d(d10);
                } else if (k10 == 2) {
                    this.f6088e = Integer.valueOf(c.c((v) d10));
                } else if (k10 == 3) {
                    this.f6089f = Integer.valueOf(c.c((v) d10));
                } else if (k10 == 5) {
                    c.d(d10);
                } else if (k10 == 6) {
                    c.d(d10);
                } else if (k10 == 600) {
                    this.f6100q = Boolean.TRUE;
                } else if (k10 == 601) {
                    this.f6101r = new String(c.b((v) d10));
                } else if (k10 == 10) {
                    this.f6090g = Integer.valueOf(c.c((v) d10));
                } else if (k10 == 200) {
                    this.f6091h = c.e(d10);
                } else if (k10 == 203) {
                    c.d(d10);
                } else if (k10 == 303) {
                    this.f6104u = Boolean.TRUE;
                } else if (k10 == 305) {
                    this.f6092i = Boolean.TRUE;
                } else if (k10 == 405) {
                    this.f6096m = Integer.valueOf(c.c((v) d10));
                } else if (k10 != 723) {
                    switch (k10) {
                        case Constants.MINIMAL_ERROR_STATUS_CODE /*400*/:
                            this.f6093j = c.a(d10);
                            break;
                        case 401:
                            this.f6094k = c.a(d10);
                            break;
                        case 402:
                            this.f6095l = c.a(d10);
                            break;
                        default:
                            switch (k10) {
                                case 503:
                                    this.f6097n = Boolean.TRUE;
                                    break;
                                case 504:
                                    c.c((v) d10);
                                    break;
                                case 505:
                                    this.f6098o = Integer.valueOf(c.c((v) d10));
                                    break;
                                case 506:
                                    this.f6099p = Boolean.TRUE;
                                    break;
                                case 507:
                                    this.K = Boolean.TRUE;
                                    break;
                                case 508:
                                    this.L = Boolean.TRUE;
                                    break;
                                case 509:
                                    this.M = Boolean.TRUE;
                                    break;
                                default:
                                    switch (k10) {
                                        case 701:
                                            this.f6102s = c.a(d10);
                                            break;
                                        case 702:
                                            c.c((v) d10);
                                            break;
                                        case 703:
                                            this.f6103t = Boolean.TRUE;
                                            break;
                                        case 704:
                                            this.f6105v = new p(d10);
                                            break;
                                        case 705:
                                            this.f6106w = Integer.valueOf(c.c((v) d10));
                                            break;
                                        case 706:
                                            this.f6107x = Integer.valueOf(c.c((v) d10));
                                            break;
                                        default:
                                            switch (k10) {
                                                case 709:
                                                    this.A = new i(c.b(c.b((v) d10)));
                                                    break;
                                                case 710:
                                                    this.B = a(d10);
                                                    break;
                                                case 711:
                                                    this.C = a(d10);
                                                    break;
                                                case 712:
                                                    this.H = a(d10);
                                                    break;
                                                case 713:
                                                    this.D = a(d10);
                                                    break;
                                                case 714:
                                                    this.E = a(d10);
                                                    break;
                                                case 715:
                                                    this.G = a(d10);
                                                    break;
                                                case 716:
                                                    this.I = a(d10);
                                                    break;
                                                case 717:
                                                    this.J = a(d10);
                                                    break;
                                                case 718:
                                                    this.f6108y = Integer.valueOf(c.c((v) d10));
                                                    break;
                                                case 719:
                                                    this.f6109z = Integer.valueOf(c.c((v) d10));
                                                    break;
                                                case 720:
                                                    this.N = Boolean.TRUE;
                                                    break;
                                                case 721:
                                                    this.O = Boolean.TRUE;
                                                    break;
                                                default:
                                                    throw new CertificateParsingException("Unknown tag " + k10 + " found");
                                            }
                                    }
                            }
                    }
                } else {
                    this.F = a(d10);
                }
            }
            return;
        }
        throw new CertificateParsingException("Expected sequence for authorization list, found " + vVar.getClass().getName());
    }

    public static z0 a(t0 t0Var) throws CertificateParsingException {
        try {
            v f10 = ((s0.a) t0Var).f();
            if (f10 == null || (f10 instanceof z0)) {
                return (z0) f10;
            }
            throw new CertificateParsingException("Expected tagged object, found " + f10.getClass().getName());
        } catch (IOException e10) {
            throw new CertificateParsingException("Failed to parse ASN1 sequence", e10);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (this.f6088e != null) {
            sb2.append("\nAlgorithm: ");
            int intValue = this.f6088e.intValue();
            if (intValue == 1) {
                str2 = "RSA";
            } else if (intValue == 3) {
                str2 = "ECDSA";
            } else if (intValue == 128) {
                str2 = "HMAC";
            } else if (intValue == 32) {
                str2 = "AES";
            } else if (intValue != 33) {
                str2 = "Unknown (" + intValue + ")";
            } else {
                str2 = "3DES";
            }
            sb2.append(str2);
        }
        if (this.f6089f != null) {
            sb2.append("\nKeySize: ");
            sb2.append(this.f6089f);
        }
        if (this.f6090g != null) {
            sb2.append("\nEC Curve: ");
            Integer num = this.f6090g;
            if (num == null) {
                str = "NULL";
            } else {
                int intValue2 = num.intValue();
                if (intValue2 == 0) {
                    str = "secp224r1";
                } else if (intValue2 == 1) {
                    str = "secp256r1";
                } else if (intValue2 == 2) {
                    str = "secp384r1";
                } else if (intValue2 == 3) {
                    str = "secp521r1";
                } else if (intValue2 != 4) {
                    str = "unknown (" + num + ")";
                } else {
                    str = "CURVE_25519";
                }
            }
            sb2.append(str);
        }
        if (this.f6091h != null) {
            sb2.append("\nRSA exponent: ");
            sb2.append(this.f6091h);
        }
        if (this.f6092i != null) {
            sb2.append("\nEarly boot only");
        }
        if (this.f6093j != null) {
            sb2.append("\nActive: ");
            sb2.append(DateFormat.getDateTimeInstance().format(this.f6093j));
        }
        if (this.f6094k != null) {
            sb2.append("\nOrigination expire: ");
            sb2.append(DateFormat.getDateTimeInstance().format(this.f6094k));
        }
        if (this.f6095l != null) {
            sb2.append("\nUsage expire: ");
            sb2.append(DateFormat.getDateTimeInstance().format(this.f6095l));
        }
        if (this.f6096m != null) {
            sb2.append("\nUsage count limit: ");
            sb2.append(this.f6096m);
        }
        if (this.f6097n != null) {
            sb2.append("\nNo Auth Required");
        }
        if (this.f6098o != null) {
            sb2.append("\nAuth timeout: ");
            sb2.append(this.f6098o);
        }
        if (this.f6099p != null) {
            sb2.append("\nAllow While On Body");
        }
        if (this.f6100q != null) {
            sb2.append("\nAll Applications");
        }
        if (this.f6101r != null) {
            sb2.append("\nApplication ID: ");
            sb2.append(this.f6101r);
        }
        if (this.f6102s != null) {
            sb2.append("\nCreated: ");
            sb2.append(DateFormat.getDateTimeInstance().format(this.f6102s));
        }
        if (this.f6103t != null) {
            sb2.append("\nRollback resistant");
        }
        if (this.f6104u != null) {
            sb2.append("\nRollback resistance");
        }
        if (this.f6105v != null) {
            sb2.append("\nRoot of Trust:\n");
            sb2.append(this.f6105v);
        }
        if (this.f6106w != null) {
            sb2.append("\nOS Version: ");
            sb2.append(this.f6106w);
        }
        if (this.f6107x != null) {
            sb2.append("\nOS Patchlevel: ");
            sb2.append(this.f6107x);
        }
        if (this.f6108y != null) {
            sb2.append("\nVendor Patchlevel: ");
            sb2.append(this.f6108y);
        }
        if (this.f6109z != null) {
            sb2.append("\nBoot Patchlevel: ");
            sb2.append(this.f6109z);
        }
        if (this.A != null) {
            sb2.append("\nAttestation Application Id:\n");
            sb2.append(this.A);
        }
        if (this.K != null) {
            sb2.append("\nUser presence required");
        }
        if (this.L != null) {
            sb2.append("\nConfirmation required");
        }
        if (this.M != null) {
            sb2.append("\nUnlocked Device Required");
        }
        if (this.N != null) {
            sb2.append("\nDevice unique attestation");
        }
        if (this.O != null) {
            sb2.append("\nIdentity Credential Key");
        }
        if (this.B != null) {
            sb2.append("\nBrand: ");
            sb2.append(this.B);
        }
        if (this.C != null) {
            sb2.append("\nDevice type: ");
            sb2.append(this.C);
        }
        if (this.H != null) {
            sb2.append("\nProduct: ");
            sb2.append(this.H);
        }
        if (this.D != null) {
            sb2.append("\nSerial: ");
            sb2.append(this.D);
        }
        if (this.E != null) {
            sb2.append("\nIMEI: ");
            sb2.append(this.E);
        }
        if (this.F != null) {
            sb2.append("\nSecond IMEI:");
            sb2.append(this.F);
        }
        if (this.G != null) {
            sb2.append("\nMEID: ");
            sb2.append(this.G);
        }
        if (this.I != null) {
            sb2.append("\nManufacturer: ");
            sb2.append(this.I);
        }
        if (this.J != null) {
            sb2.append("\nModel: ");
            sb2.append(this.J);
        }
        return sb2.toString();
    }

    public final String a(p0 p0Var) throws CertificateParsingException {
        try {
            return c.f(p0Var);
        } catch (UnsupportedEncodingException e10) {
            throw new CertificateParsingException("Error parsing ASN.1 value", e10);
        }
    }

    public n(n4 n4Var) throws CertificateParsingException {
        for (i4 next : n4Var.a()) {
            int intValue = ((p4) next).a().intValue();
            if (intValue == -80706) {
                this.f6107x = Integer.valueOf(c.e(n4Var, next));
            } else if (intValue == -80705) {
                this.f6106w = Integer.valueOf(c.e(n4Var, next));
            } else if (intValue == -80703) {
                this.f6103t = Boolean.TRUE;
            } else if (intValue == -80702) {
                c.e(n4Var, next);
            } else if (intValue == -80006) {
                c.f(n4Var, next);
            } else if (intValue != -80005) {
                switch (intValue) {
                    case -80720:
                        this.N = Boolean.TRUE;
                        break;
                    case -80719:
                        this.f6109z = Integer.valueOf(c.e(n4Var, next));
                        break;
                    case -80718:
                        this.f6108y = Integer.valueOf(c.e(n4Var, next));
                        break;
                    case -80717:
                        this.J = c.h(n4Var, next);
                        break;
                    case -80716:
                        this.I = c.h(n4Var, next);
                        break;
                    case -80715:
                        this.G = c.h(n4Var, next);
                        break;
                    default:
                        switch (intValue) {
                            case -80713:
                                this.D = c.h(n4Var, next);
                                break;
                            case -80712:
                                this.H = c.h(n4Var, next);
                                break;
                            case -80711:
                                this.C = c.h(n4Var, next);
                                break;
                            case -80710:
                                this.B = c.h(n4Var, next);
                                break;
                            case -80709:
                                this.A = new i(c.b(c.c(n4Var, next)));
                                break;
                            default:
                                switch (intValue) {
                                    case -80601:
                                        this.f6101r = c.h(n4Var, next);
                                        break;
                                    case -80305:
                                        break;
                                    case -80303:
                                        this.f6104u = Boolean.TRUE;
                                        continue;
                                    case -80203:
                                        c.f(n4Var, next);
                                        continue;
                                    case -80200:
                                        this.f6091h = Long.valueOf(c.g(n4Var, next));
                                        continue;
                                    case -80010:
                                        this.f6090g = Integer.valueOf(c.e(n4Var, next));
                                        continue;
                                    case -76002:
                                        this.f6087d = Integer.valueOf(o.b(c.e(n4Var, next)));
                                        continue;
                                    case -75009:
                                        this.E = c.h(n4Var, next);
                                        continue;
                                    case 6:
                                        this.f6102s = c.d(n4Var, next);
                                        continue;
                                    default:
                                        switch (intValue) {
                                            case -80509:
                                                this.M = Boolean.TRUE;
                                                break;
                                            case -80508:
                                                this.L = Boolean.TRUE;
                                                break;
                                            case -80507:
                                                this.K = c.a(n4Var, next);
                                                break;
                                            case -80506:
                                                this.f6099p = Boolean.TRUE;
                                                break;
                                            case -80505:
                                                this.f6098o = Integer.valueOf(c.e(n4Var, next));
                                                break;
                                            case -80504:
                                                c.e(n4Var, next);
                                                break;
                                            case -80503:
                                                this.f6097n = Boolean.TRUE;
                                                break;
                                            default:
                                                switch (intValue) {
                                                    case -80402:
                                                        this.f6095l = c.d(n4Var, next);
                                                        break;
                                                    case -80401:
                                                        this.f6094k = c.d(n4Var, next);
                                                        break;
                                                    case -80400:
                                                        this.f6093j = c.d(n4Var, next);
                                                        break;
                                                    default:
                                                        switch (intValue) {
                                                            case -80003:
                                                                this.f6089f = Integer.valueOf(c.e(n4Var, next));
                                                                break;
                                                            case -80002:
                                                                this.f6088e = Integer.valueOf(c.e(n4Var, next));
                                                                break;
                                                            case -80001:
                                                                c.f(n4Var, next);
                                                                continue;
                                                            default:
                                                                throw new CertificateParsingException("Unknown EAT tag: " + next);
                                                        }
                                                }
                                        }
                                }
                                this.f6092i = Boolean.TRUE;
                                break;
                        }
                }
            } else {
                c.f(n4Var, next);
            }
        }
    }
}

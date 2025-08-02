package com.geetest.core;

import android.os.Build;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import z8.k;
import z8.l;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public int f5998a;

    /* renamed from: b  reason: collision with root package name */
    public int f5999b;

    /* renamed from: c  reason: collision with root package name */
    public int f6000c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f6001d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6002e;

    /* renamed from: f  reason: collision with root package name */
    public n f6003f;

    /* renamed from: g  reason: collision with root package name */
    public n f6004g;

    public h(X509Certificate x509Certificate) {
        b(x509Certificate);
    }

    public static h a(X509Certificate x509Certificate) throws CertificateParsingException {
        if (x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.25") == null && x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17") == null) {
            throw new CertificateParsingException("No attestation extensions found");
        } else if (x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.25") != null) {
            if (x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17") == null) {
                try {
                    return new o(x509Certificate);
                } catch (q3 e10) {
                    throw new CertificateParsingException("Unable to parse EAT extension", e10);
                }
            } else {
                throw new CertificateParsingException("Multiple attestation extensions found");
            }
        } else if (x509Certificate.getExtensionValue("2.5.29.31") == null) {
            return new g(x509Certificate);
        } else {
            throw new CertificateParsingException("CRL Distribution Points extension found in leaf certificate.");
        }
    }

    public abstract int a();

    public abstract p b();

    public Set<String> b(X509Certificate x509Certificate) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll((Collection) x509Certificate.getCriticalExtensionOIDs().stream().filter(new k()).collect(Collectors.toSet()));
        hashSet.addAll((Collection) x509Certificate.getNonCriticalExtensionOIDs().stream().filter(new l()).collect(Collectors.toSet()));
        return hashSet;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extension type: ");
        sb2.append(getClass());
        sb2.append("\nAttest version: ");
        int i10 = this.f5998a;
        String str3 = "KeyMint version 1.0";
        if (i10 == 100) {
            str = str3;
        } else if (i10 == 200) {
            str = "KeyMint version 2.0";
        } else if (i10 == 300) {
            str = "KeyMint version 3.0";
        } else if (i10 == 1) {
            str = "Keymaster version 2.0";
        } else if (i10 == 2) {
            str = "Keymaster version 3.0";
        } else if (i10 == 3) {
            str = "Keymaster version 4.0";
        } else if (i10 != 4) {
            str = "Unkown (" + i10 + ")";
        } else {
            str = "Keymaster version 4.1";
        }
        sb2.append(str);
        sb2.append("\nAttest security: ");
        sb2.append(a(a()));
        sb2.append("\nKM version: ");
        int i11 = this.f5999b;
        if (i11 == 41) {
            str3 = "Keymaster version 4.1";
        } else if (i11 != 100) {
            if (i11 == 200) {
                str3 = "KeyMint version 2.0";
            } else if (i11 == 300) {
                str3 = "KeyMint version 3.0";
            } else if (i11 == 0) {
                str3 = "Keymaster version 0.2 or 0.3";
            } else if (i11 == 1) {
                str3 = "Keymaster version 1.0";
            } else if (i11 == 2) {
                str3 = "Keymaster version 2.0";
            } else if (i11 == 3) {
                str3 = "Keymaster version 3.0";
            } else if (i11 != 4) {
                str3 = "Unkown (" + i11 + ")";
            } else {
                str3 = "Keymaster version 4.0";
            }
        }
        sb2.append(str3);
        sb2.append("\nKM security: ");
        sb2.append(a(this.f6000c));
        sb2.append("\nChallenge");
        byte[] bArr = this.f6001d;
        if (bArr != null) {
            str2 = new String(bArr);
        } else {
            str2 = "null";
        }
        char[] charArray = str2.toCharArray();
        int length = charArray.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                sb2.append(": [");
                sb2.append(str2);
                sb2.append("]");
                break;
            } else if (charArray[i12] > 127) {
                sb2.append(" (base64): [");
                sb2.append(Base64.encodeToString(this.f6001d, 0));
                sb2.append("]");
                break;
            } else {
                i12++;
            }
        }
        if (this.f6002e != null) {
            sb2.append("\nUnique ID (base64): [");
            sb2.append(Base64.encodeToString(this.f6002e, 0));
            sb2.append("]");
        }
        sb2.append("\n-- SW enforced --");
        sb2.append(this.f6003f);
        sb2.append("\n-- TEE enforced --");
        sb2.append(this.f6004g);
        return sb2.toString();
    }

    public static String a(int i10) {
        if (i10 == 0) {
            return ExifInterface.TAG_SOFTWARE;
        }
        if (i10 == 1) {
            return "TEE";
        }
        if (i10 == 2) {
            return "StrongBox";
        }
        return "Unknown (" + i10 + ")";
    }

    public static /* synthetic */ boolean a(String str) {
        return !"2.5.29.15".equals(str);
    }

    public static /* synthetic */ boolean b(String str) {
        return !"1.3.6.1.4.1.11129.2.1.17".equals(str) && !"1.3.6.1.4.1.11129.2.1.25".equals(str);
    }
}

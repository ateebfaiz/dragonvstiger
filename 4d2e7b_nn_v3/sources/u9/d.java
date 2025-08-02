package u9;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import s9.h;

public abstract class d {
    private static Signature a(String str, Provider provider) {
        return b(str, provider, (PSSParameterSpec) null);
    }

    private static Signature b(String str, Provider provider, PSSParameterSpec pSSParameterSpec) {
        Signature signature;
        if (provider != null) {
            try {
                signature = Signature.getInstance(str, provider);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } else {
            signature = Signature.getInstance(str);
        }
        if (pSSParameterSpec != null) {
            try {
                signature.setParameter(pSSParameterSpec);
            } catch (InvalidAlgorithmParameterException e10) {
                throw new s9.d("Invalid RSASSA-PSS salt length parameter: " + e10.getMessage(), e10);
            }
        }
        return signature;
    }

    public static Signature c(h hVar, Provider provider) {
        Signature a10;
        Signature b10;
        Signature a11;
        Signature b11;
        Signature a12;
        Signature b12;
        Signature a13;
        Signature a14;
        Signature a15;
        if (hVar.equals(h.f13016g) && (a15 = a("SHA256withRSA", provider)) != null) {
            return a15;
        }
        if (hVar.equals(h.f13017h) && (a14 = a("SHA384withRSA", provider)) != null) {
            return a14;
        }
        if (hVar.equals(h.f13018i) && (a13 = a("SHA512withRSA", provider)) != null) {
            return a13;
        }
        h hVar2 = h.Y;
        if (hVar.equals(hVar2) && (b12 = b("RSASSA-PSS", provider, new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1))) != null) {
            return b12;
        }
        if (hVar.equals(hVar2) && (a12 = a("SHA256withRSAandMGF1", provider)) != null) {
            return a12;
        }
        h hVar3 = h.Z;
        if (hVar.equals(hVar3) && (b11 = b("RSASSA-PSS", provider, new PSSParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, 48, 1))) != null) {
            return b11;
        }
        if (hVar.equals(hVar3) && (a11 = a("SHA384withRSAandMGF1", provider)) != null) {
            return a11;
        }
        h hVar4 = h.N0;
        if (hVar.equals(hVar4) && (b10 = b("RSASSA-PSS", provider, new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1))) != null) {
            return b10;
        }
        if (hVar.equals(hVar4) && (a10 = a("SHA512withRSAandMGF1", provider)) != null) {
            return a10;
        }
        throw new s9.d(a.b(hVar, e.f13162c));
    }
}

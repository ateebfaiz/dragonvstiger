package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

public abstract class EllipticCurveProvider extends SignatureProvider {
    private static final Map<SignatureAlgorithm, String> EC_CURVE_NAMES = createEcCurveNames();

    /* renamed from: io.jsonwebtoken.impl.crypto.EllipticCurveProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.jsonwebtoken.SignatureAlgorithm[] r0 = io.jsonwebtoken.SignatureAlgorithm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm = r0
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x001d }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.crypto.EllipticCurveProvider.AnonymousClass1.<clinit>():void");
        }
    }

    protected EllipticCurveProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm must be an Elliptic Curve algorithm.");
    }

    private static Map<SignatureAlgorithm, String> createEcCurveNames() {
        HashMap hashMap = new HashMap();
        hashMap.put(SignatureAlgorithm.ES256, "secp256r1");
        hashMap.put(SignatureAlgorithm.ES384, "secp384r1");
        hashMap.put(SignatureAlgorithm.ES512, "secp521r1");
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return generateKeyPair(SignatureAlgorithm.ES512);
    }

    public static int getSignatureByteArrayLength(SignatureAlgorithm signatureAlgorithm) throws JwtException {
        int i10 = AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        if (i10 == 1) {
            return 64;
        }
        if (i10 == 2) {
            return 96;
        }
        if (i10 == 3) {
            return 132;
        }
        throw new JwtException("Unsupported Algorithm: " + signatureAlgorithm.name());
    }

    public static byte[] transcodeSignatureToConcat(byte[] bArr, int i10) throws JwtException {
        int i11;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new JwtException("Invalid ECDSA signature format");
        }
        byte b10 = bArr[1];
        if (b10 > 0) {
            i11 = 2;
        } else if (b10 == -127) {
            i11 = 3;
        } else {
            throw new JwtException("Invalid ECDSA signature format");
        }
        byte b11 = bArr[i11 + 1];
        int i12 = b11;
        while (i12 > 0 && bArr[((i11 + 2) + b11) - i12] == 0) {
            i12--;
        }
        int i13 = i11 + 2 + b11;
        byte b12 = bArr[i13 + 1];
        int i14 = b12;
        while (i14 > 0 && bArr[((i13 + 2) + b12) - i14] == 0) {
            i14--;
        }
        int max = Math.max(Math.max(i12, i14), i10 / 2);
        byte b13 = bArr[i11 - 1];
        if ((b13 & 255) == bArr.length - i11 && (b13 & 255) == b11 + 4 + b12 && bArr[i11] == 2 && bArr[i13] == 2) {
            int i15 = max * 2;
            byte[] bArr2 = new byte[i15];
            System.arraycopy(bArr, i13 - i12, bArr2, max - i12, i12);
            System.arraycopy(bArr, ((i13 + 2) + b12) - i14, bArr2, i15 - i14, i14);
            return bArr2;
        }
        throw new JwtException("Invalid ECDSA signature format");
    }

    public static byte[] transcodeSignatureToDER(byte[] bArr) throws JwtException {
        int i10;
        int i11;
        byte[] bArr2;
        int length = bArr.length / 2;
        int i12 = length;
        while (i12 > 0 && bArr[length - i12] == 0) {
            i12--;
        }
        int i13 = length - i12;
        if (bArr[i13] < 0) {
            i10 = i12 + 1;
        } else {
            i10 = i12;
        }
        int i14 = length;
        while (i14 > 0 && bArr[(length * 2) - i14] == 0) {
            i14--;
        }
        int i15 = (length * 2) - i14;
        if (bArr[i15] < 0) {
            i11 = i14 + 1;
        } else {
            i11 = i14;
        }
        int i16 = i10 + 4 + i11;
        if (i16 <= 255) {
            int i17 = 1;
            if (i16 < 128) {
                bArr2 = new byte[(i10 + 6 + i11)];
            } else {
                bArr2 = new byte[(i10 + 7 + i11)];
                bArr2[1] = -127;
                i17 = 2;
            }
            bArr2[0] = 48;
            bArr2[i17] = (byte) i16;
            bArr2[i17 + 1] = 2;
            bArr2[i17 + 2] = (byte) i10;
            int i18 = i17 + 3 + i10;
            System.arraycopy(bArr, i13, bArr2, i18 - i12, i12);
            bArr2[i18] = 2;
            bArr2[i18 + 1] = (byte) i11;
            System.arraycopy(bArr, i15, bArr2, ((i18 + 2) + i11) - i14, i14);
            return bArr2;
        }
        throw new JwtException("Invalid ECDSA signature format");
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        return generateKeyPair(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        return generateKeyPair("EC", (String) null, signatureAlgorithm, secureRandom);
    }

    public static KeyPair generateKeyPair(String str, String str2, SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        KeyPairGenerator keyPairGenerator;
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm argument cannot be null.");
        Assert.isTrue(signatureAlgorithm.isEllipticCurve(), "SignatureAlgorithm argument must represent an Elliptic Curve algorithm.");
        try {
            if (Strings.hasText(str2)) {
                keyPairGenerator = KeyPairGenerator.getInstance(str, str2);
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance(str);
            }
            keyPairGenerator.initialize(new ECGenParameterSpec(EC_CURVE_NAMES.get(signatureAlgorithm)), secureRandom);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e10) {
            throw new IllegalStateException("Unable to generate Elliptic Curve KeyPair: " + e10.getMessage(), e10);
        }
    }
}

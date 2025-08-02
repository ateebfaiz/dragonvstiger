package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

public class DefaultSignatureValidatorFactory implements SignatureValidatorFactory {
    public static final SignatureValidatorFactory INSTANCE = new DefaultSignatureValidatorFactory();

    /* renamed from: io.jsonwebtoken.impl.crypto.DefaultSignatureValidatorFactory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.jsonwebtoken.SignatureAlgorithm[] r0 = io.jsonwebtoken.SignatureAlgorithm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm = r0
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.HS256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x001d }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.HS384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.HS512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.RS256     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x003e }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.RS384     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.RS512     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.PS256     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.PS384     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x006c }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.PS512     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES256     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES384     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0090 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.ES512     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.crypto.DefaultSignatureValidatorFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public SignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key, "Signing Key cannot be null.");
        switch (AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new MacValidator(signatureAlgorithm, key);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return new RsaSignatureValidator(signatureAlgorithm, key);
            case 10:
            case 11:
            case 12:
                return new EllipticCurveSignatureValidator(signatureAlgorithm, key);
            default:
                throw new IllegalArgumentException("The '" + signatureAlgorithm.name() + "' algorithm cannot be used for signing.");
        }
    }
}

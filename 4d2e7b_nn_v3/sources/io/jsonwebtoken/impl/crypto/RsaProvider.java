package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;

public abstract class RsaProvider extends SignatureProvider {
    private static final Map<SignatureAlgorithm, PSSParameterSpec> PSS_PARAMETER_SPECS = createPssParameterSpecs();

    /* renamed from: io.jsonwebtoken.impl.crypto.RsaProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.jsonwebtoken.SignatureAlgorithm[] r0 = io.jsonwebtoken.SignatureAlgorithm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm = r0
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.RS256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x001d }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.PS256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.RS384     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$jsonwebtoken$SignatureAlgorithm     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.jsonwebtoken.SignatureAlgorithm r1 = io.jsonwebtoken.SignatureAlgorithm.PS384     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.crypto.RsaProvider.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    protected RsaProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isRsa(), "SignatureAlgorithm must be an RSASSA or RSASSA-PSS algorithm.");
    }

    private static Map<SignatureAlgorithm, PSSParameterSpec> createPssParameterSpecs() {
        HashMap hashMap = new HashMap();
        MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
        hashMap.put(SignatureAlgorithm.PS256, new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 32, 1));
        MGF1ParameterSpec mGF1ParameterSpec2 = MGF1ParameterSpec.SHA384;
        hashMap.put(SignatureAlgorithm.PS384, new PSSParameterSpec(mGF1ParameterSpec2.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec2, 48, 1));
        MGF1ParameterSpec mGF1ParameterSpec3 = MGF1ParameterSpec.SHA512;
        hashMap.put(SignatureAlgorithm.PS512, new PSSParameterSpec(mGF1ParameterSpec3.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec3, 64, 1));
        return hashMap;
    }

    public static KeyPair generateKeyPair() {
        return generateKeyPair(4096);
    }

    /* access modifiers changed from: protected */
    public Signature createSignatureInstance() {
        Signature createSignatureInstance = super.createSignatureInstance();
        PSSParameterSpec pSSParameterSpec = PSS_PARAMETER_SPECS.get(this.alg);
        if (pSSParameterSpec != null) {
            setParameter(createSignatureInstance, pSSParameterSpec);
        }
        return createSignatureInstance;
    }

    /* access modifiers changed from: protected */
    public void doSetParameter(Signature signature, PSSParameterSpec pSSParameterSpec) throws InvalidAlgorithmParameterException {
        signature.setParameter(pSSParameterSpec);
    }

    /* access modifiers changed from: protected */
    public void setParameter(Signature signature, PSSParameterSpec pSSParameterSpec) {
        try {
            doSetParameter(signature, pSSParameterSpec);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new SignatureException("Unsupported RSASSA-PSS parameter '" + pSSParameterSpec + "': " + e10.getMessage(), e10);
        }
    }

    public static KeyPair generateKeyPair(int i10) {
        return generateKeyPair(i10, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        Assert.isTrue(signatureAlgorithm.isRsa(), "Only RSA algorithms are supported by this method.");
        int i10 = AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        return generateKeyPair((i10 == 1 || i10 == 2) ? 2048 : (i10 == 3 || i10 == 4) ? 3072 : 4096, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(int i10, SecureRandom secureRandom) {
        return generateKeyPair("RSA", i10, secureRandom);
    }

    protected static KeyPair generateKeyPair(String str, int i10, SecureRandom secureRandom) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(str);
            instance.initialize(i10, secureRandom);
            return instance.genKeyPair();
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("Unable to obtain an RSA KeyPairGenerator: " + e10.getMessage(), e10);
        }
    }
}

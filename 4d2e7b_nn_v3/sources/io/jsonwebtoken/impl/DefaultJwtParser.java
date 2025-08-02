package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import io.jsonwebtoken.impl.io.InstanceLocator;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public class DefaultJwtParser implements JwtParser {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private long allowedClockSkewMillis = 0;
    private Decoder<String, byte[]> base64UrlDecoder = Decoders.BASE64URL;
    private Clock clock = DefaultClock.INSTANCE;
    private CompressionCodecResolver compressionCodecResolver = new DefaultCompressionCodecResolver();
    private Deserializer<Map<String, ?>> deserializer;
    private Claims expectedClaims = new DefaultClaims();
    private Key key;
    private byte[] keyBytes;
    private SigningKeyResolver signingKeyResolver;

    private static Object normalize(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        return obj;
    }

    private void validateExpectedClaims(Header header, Claims claims) {
        InvalidClaimException invalidClaimException;
        for (String str : this.expectedClaims.keySet()) {
            Object normalize = normalize(this.expectedClaims.get(str));
            Object normalize2 = normalize(claims.get(str));
            if (normalize instanceof Date) {
                try {
                    normalize2 = claims.get(str, Date.class);
                } catch (Exception unused) {
                    throw new IncorrectClaimException(header, claims, "JWT Claim '" + str + "' was expected to be a Date, but its value " + "cannot be converted to a Date using current heuristics.  Value: " + normalize2);
                }
            }
            if (normalize2 == null) {
                invalidClaimException = new MissingClaimException(header, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, new Object[]{str, normalize}));
                continue;
            } else if (!normalize.equals(normalize2)) {
                invalidClaimException = new IncorrectClaimException(header, claims, String.format(ClaimJwtException.INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE, new Object[]{str, normalize, normalize2}));
                continue;
            } else {
                invalidClaimException = null;
                continue;
            }
            if (invalidClaimException != null) {
                invalidClaimException.setClaimName(str);
                invalidClaimException.setClaimValue(normalize);
                throw invalidClaimException;
            }
        }
    }

    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    /* access modifiers changed from: protected */
    public JwtSignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        return new DefaultJwtSignatureValidator(signatureAlgorithm, key2, this.base64UrlDecoder);
    }

    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer2) {
        Assert.notNull(deserializer2, "deserializer cannot be null.");
        this.deserializer = deserializer2;
        return this;
    }

    public boolean isSigned(String str) {
        if (str == null) {
            return false;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (i11 != 2) {
                if (charAt == '.') {
                    i11++;
                }
                i10++;
            } else if (Character.isWhitespace(charAt) || charAt == '.') {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public Jwt parse(String str) throws ExpiredJwtException, MalformedJwtException, SignatureException {
        boolean z10;
        JwsHeader jwsHeader;
        CompressionCodec compressionCodec;
        String str2;
        DefaultClaims defaultClaims;
        SigningKeyResolver signingKeyResolver2;
        String str3 = str;
        if (this.deserializer == null) {
            this.deserializer = (Deserializer) ((InstanceLocator) Classes.newInstance("io.jsonwebtoken.impl.io.RuntimeClasspathDeserializerLocator")).getInstance();
        }
        Assert.hasText(str3, "JWT String argument cannot be null or empty.");
        StringBuilder sb2 = new StringBuilder(128);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        SignatureAlgorithm signatureAlgorithm = null;
        String str4 = null;
        String str5 = null;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                break;
            }
            char c10 = charArray[i10];
            if (c10 == '.') {
                CharSequence clean = Strings.clean((CharSequence) sb2);
                String charSequence = clean != null ? clean.toString() : null;
                if (i11 == 0) {
                    str5 = charSequence;
                } else if (i11 == 1) {
                    str4 = charSequence;
                }
                i11++;
                sb2.setLength(0);
            } else {
                sb2.append(c10);
            }
            i10++;
        }
        if (i11 == 2) {
            String sb3 = sb2.length() > 0 ? sb2.toString() : null;
            if (str4 != null) {
                if (str5 != null) {
                    Map<String, ?> readValue = readValue(new String(this.base64UrlDecoder.decode(str5), Strings.UTF_8));
                    if (sb3 != null) {
                        jwsHeader = new DefaultJwsHeader(readValue);
                    } else {
                        jwsHeader = new DefaultHeader(readValue);
                    }
                    compressionCodec = this.compressionCodecResolver.resolveCompressionCodec(jwsHeader);
                } else {
                    compressionCodec = null;
                    jwsHeader = null;
                }
                byte[] decode = this.base64UrlDecoder.decode(str4);
                if (compressionCodec != null) {
                    decode = compressionCodec.decompress(decode);
                }
                String str6 = new String(decode, Strings.UTF_8);
                DefaultClaims defaultClaims2 = (str6.charAt(0) == '{' && str6.charAt(str6.length() - 1) == '}') ? new DefaultClaims(readValue(str6)) : null;
                if (sb3 != null) {
                    JwsHeader jwsHeader2 = jwsHeader;
                    if (jwsHeader != null) {
                        String algorithm = jwsHeader2.getAlgorithm();
                        if (Strings.hasText(algorithm)) {
                            signatureAlgorithm = SignatureAlgorithm.forName(algorithm);
                        }
                    }
                    if (signatureAlgorithm == null || signatureAlgorithm == SignatureAlgorithm.NONE) {
                        throw new MalformedJwtException("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
                    }
                    Key key2 = this.key;
                    if (key2 != null && this.keyBytes != null) {
                        throw new IllegalStateException("A key object and key bytes cannot both be specified. Choose either.");
                    } else if ((key2 == null && this.keyBytes == null) || this.signingKeyResolver == null) {
                        if (key2 == null) {
                            byte[] bArr = this.keyBytes;
                            if (Objects.isEmpty(bArr) && (signingKeyResolver2 = this.signingKeyResolver) != null) {
                                key2 = defaultClaims2 != null ? signingKeyResolver2.resolveSigningKey(jwsHeader2, (Claims) defaultClaims2) : signingKeyResolver2.resolveSigningKey(jwsHeader2, str6);
                            }
                            if (!Objects.isEmpty(bArr)) {
                                Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes can only be specified for HMAC signatures. Please specify a PublicKey or PrivateKey instance.");
                                key2 = new SecretKeySpec(bArr, signatureAlgorithm.getJcaName());
                            }
                        }
                        Assert.notNull(key2, "A signing key must be specified if the specified JWT is digitally signed.");
                        String str7 = str5 + JwtParser.SEPARATOR_CHAR + str4;
                        try {
                            signatureAlgorithm.assertValidVerificationKey(key2);
                            if (!createSignatureValidator(signatureAlgorithm, key2).isValid(str7, sb3)) {
                                throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                            }
                        } catch (WeakKeyException e10) {
                            throw e10;
                        } catch (InvalidKeyException | IllegalArgumentException e11) {
                            String value = signatureAlgorithm.getValue();
                            throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the " + value + " signature " + "algorithm, but the specified signing key of type " + key2.getClass().getName() + " may not be used to validate " + value + " signatures.  Because the specified " + "signing key reflects a specific and expected algorithm, and the JWT does not reflect " + "this algorithm, it is likely that the JWT was not expected and therefore should not be " + "trusted.  Another possibility is that the parser was configured with the incorrect " + "signing key, but this cannot be assumed for security reasons.", e11);
                        }
                    } else {
                        throw new IllegalStateException("A signing key resolver and " + (key2 != null ? "a key object" : "key bytes") + " cannot both be specified. Choose either.");
                    }
                }
                if (this.allowedClockSkewMillis <= 0) {
                    z10 = false;
                }
                if (defaultClaims2 != null) {
                    Date now = this.clock.now();
                    long time = now.getTime();
                    Date expiration = defaultClaims2.getExpiration();
                    if (expiration != null) {
                        DefaultClaims defaultClaims3 = defaultClaims2;
                        long j10 = time - this.allowedClockSkewMillis;
                        if (!(z10 ? new Date(j10) : now).after(expiration)) {
                            defaultClaims = defaultClaims3;
                        } else {
                            throw new ExpiredJwtException(jwsHeader, defaultClaims3, "JWT expired at " + DateFormats.formatIso8601(expiration, false) + ". Current time: " + DateFormats.formatIso8601(now, false) + ", a difference of " + (j10 - expiration.getTime()) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                        }
                    } else {
                        defaultClaims = defaultClaims2;
                    }
                    Date notBefore = defaultClaims.getNotBefore();
                    str2 = sb3;
                    if (notBefore != null) {
                        JwsHeader jwsHeader3 = jwsHeader;
                        long j11 = time + this.allowedClockSkewMillis;
                        if (!(z10 ? new Date(j11) : now).before(notBefore)) {
                            jwsHeader = jwsHeader3;
                        } else {
                            throw new PrematureJwtException(jwsHeader3, defaultClaims, "JWT must not be accepted before " + DateFormats.formatIso8601(notBefore, false) + ". Current time: " + DateFormats.formatIso8601(now, false) + ", a difference of " + (notBefore.getTime() - j11) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                        }
                    }
                    validateExpectedClaims(jwsHeader, defaultClaims);
                } else {
                    defaultClaims = defaultClaims2;
                    str2 = sb3;
                }
                if (defaultClaims != null) {
                    str6 = defaultClaims;
                }
                if (str2 != null) {
                    return new DefaultJws(jwsHeader, str6, str2);
                }
                return new DefaultJwt(jwsHeader, str6);
            }
            throw new MalformedJwtException("JWT string '" + str3 + "' is missing a body/payload.");
        }
        throw new MalformedJwtException("JWT strings must contain exactly 2 period characters. Found: " + i11);
    }

    public Jws<Claims> parseClaimsJws(String str) {
        return (Jws) parse(str, new JwtHandlerAdapter<Jws<Claims>>() {
            public Jws<Claims> onClaimsJws(Jws<Claims> jws) {
                return jws;
            }
        });
    }

    public Jwt<Header, Claims> parseClaimsJwt(String str) {
        try {
            return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, Claims>>() {
                public Jwt<Header, Claims> onClaimsJwt(Jwt<Header, Claims> jwt) {
                    return jwt;
                }
            });
        } catch (IllegalArgumentException e10) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e10);
        }
    }

    public Jws<String> parsePlaintextJws(String str) {
        try {
            return (Jws) parse(str, new JwtHandlerAdapter<Jws<String>>() {
                public Jws<String> onPlaintextJws(Jws<String> jws) {
                    return jws;
                }
            });
        } catch (IllegalArgumentException e10) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e10);
        }
    }

    public Jwt<Header, String> parsePlaintextJwt(String str) {
        return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, String>>() {
            public Jwt<Header, String> onPlaintextJwt(Jwt<Header, String> jwt) {
                return jwt;
            }
        });
    }

    /* access modifiers changed from: protected */
    public Map<String, ?> readValue(String str) {
        try {
            return this.deserializer.deserialize(str.getBytes(Strings.UTF_8));
        } catch (DeserializationException e10) {
            throw new MalformedJwtException("Unable to read JSON value: " + str, e10);
        }
    }

    public JwtParser require(String str, Object obj) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        Assert.notNull(obj, "The value cannot be null for claim name: " + str);
        this.expectedClaims.put(str, obj);
        return this;
    }

    public JwtParser requireAudience(String str) {
        this.expectedClaims.setAudience(str);
        return this;
    }

    public JwtParser requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    public JwtParser requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    public JwtParser requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    public JwtParser requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    public JwtParser requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    public JwtParser requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    public JwtParser setAllowedClockSkewSeconds(long j10) {
        this.allowedClockSkewMillis = Math.max(0, j10 * 1000);
        return this;
    }

    public JwtParser setClock(Clock clock2) {
        Assert.notNull(clock2, "Clock instance cannot be null.");
        this.clock = clock2;
        return this;
    }

    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver2) {
        Assert.notNull(compressionCodecResolver2, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver2;
        return this;
    }

    public JwtParser setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }

    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver2) {
        Assert.notNull(signingKeyResolver2, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver2;
        return this;
    }

    public JwtParser setSigningKey(String str) {
        Assert.hasText(str, "signing key cannot be null or empty.");
        this.keyBytes = Decoders.BASE64.decode(str);
        return this;
    }

    public JwtParser setSigningKey(Key key2) {
        Assert.notNull(key2, "signing key cannot be null.");
        this.key = key2;
        return this;
    }

    public <T> T parse(String str, JwtHandler<T> jwtHandler) throws ExpiredJwtException, MalformedJwtException, SignatureException {
        Assert.notNull(jwtHandler, "JwtHandler argument cannot be null.");
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        Jwt parse = parse(str);
        if (parse instanceof Jws) {
            Jws jws = (Jws) parse;
            if (jws.getBody() instanceof Claims) {
                return jwtHandler.onClaimsJws(jws);
            }
            return jwtHandler.onPlaintextJws(jws);
        } else if (parse.getBody() instanceof Claims) {
            return jwtHandler.onClaimsJwt(parse);
        } else {
            return jwtHandler.onPlaintextJwt(parse);
        }
    }
}

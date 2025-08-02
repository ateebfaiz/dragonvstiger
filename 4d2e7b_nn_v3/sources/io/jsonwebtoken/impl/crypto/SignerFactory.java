package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

public interface SignerFactory {
    Signer createSigner(SignatureAlgorithm signatureAlgorithm, Key key);
}

package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

public interface SignatureValidatorFactory {
    SignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key);
}

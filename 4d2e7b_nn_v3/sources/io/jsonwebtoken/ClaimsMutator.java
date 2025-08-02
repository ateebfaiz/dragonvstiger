package io.jsonwebtoken;

import io.jsonwebtoken.ClaimsMutator;
import java.util.Date;

public interface ClaimsMutator<T extends ClaimsMutator> {
    T setAudience(String str);

    T setExpiration(Date date);

    T setId(String str);

    T setIssuedAt(Date date);

    T setIssuer(String str);

    T setNotBefore(Date date);

    T setSubject(String str);
}

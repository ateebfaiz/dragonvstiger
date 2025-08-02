package io.jsonwebtoken.lang;

import java.security.Provider;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RuntimeEnvironment {
    private static final String BC_PROVIDER_CLASS_NAME = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    public static final boolean BOUNCY_CASTLE_AVAILABLE = Classes.isAvailable(BC_PROVIDER_CLASS_NAME);
    private static final AtomicBoolean bcLoaded = new AtomicBoolean(false);

    static {
        enableBouncyCastleIfPossible();
    }

    private RuntimeEnvironment() {
    }

    public static void enableBouncyCastleIfPossible() {
        if (BOUNCY_CASTLE_AVAILABLE && !bcLoaded.get()) {
            try {
                Class forName = Classes.forName(BC_PROVIDER_CLASS_NAME);
                for (Provider isInstance : Security.getProviders()) {
                    if (forName.isInstance(isInstance)) {
                        bcLoaded.set(true);
                        return;
                    }
                }
                Security.addProvider((Provider) Classes.newInstance(forName));
                bcLoaded.set(true);
            } catch (UnknownClassException unused) {
            }
        }
    }
}

package w9;

import java.security.Provider;
import java.security.SecureRandom;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Provider f13217a;

    /* renamed from: b  reason: collision with root package name */
    private SecureRandom f13218b;

    public a() {
        this((Provider) null, (SecureRandom) null);
    }

    public Provider a() {
        return this.f13217a;
    }

    public a(Provider provider, SecureRandom secureRandom) {
        this.f13217a = provider;
        this.f13218b = secureRandom;
    }
}

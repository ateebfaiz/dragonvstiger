package k9;

import java.util.List;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final String f12548a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12549b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12550c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12551d;

    /* renamed from: e  reason: collision with root package name */
    private final List f12552e;

    /* renamed from: f  reason: collision with root package name */
    private final List f12553f;

    /* renamed from: g  reason: collision with root package name */
    private final List f12554g;

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f12555a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f12556b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f12557c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f12558d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List f12559e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public List f12560f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public List f12561g;

        public b h(String str) {
            this.f12556b = str;
            return this;
        }

        public i i() {
            return new i(this);
        }

        public b j(List list) {
            this.f12561g = list;
            return this;
        }

        public b k(String str) {
            this.f12555a = str;
            return this;
        }

        public b l(String str) {
            this.f12558d = str;
            return this;
        }

        public b m(List list) {
            this.f12559e = list;
            return this;
        }

        public b n(List list) {
            this.f12560f = list;
            return this;
        }

        public b o(String str) {
            this.f12557c = str;
            return this;
        }
    }

    public String a() {
        return this.f12548a;
    }

    public String b() {
        return this.f12551d;
    }

    public String toString() {
        return "OpenIdDiscoveryDocument{issuer='" + this.f12548a + '\'' + ", authorizationEndpoint='" + this.f12549b + '\'' + ", tokenEndpoint='" + this.f12550c + '\'' + ", jwksUri='" + this.f12551d + '\'' + ", responseTypesSupported=" + this.f12552e + ", subjectTypesSupported=" + this.f12553f + ", idTokenSigningAlgValuesSupported=" + this.f12554g + '}';
    }

    private i(b bVar) {
        this.f12548a = bVar.f12555a;
        this.f12549b = bVar.f12556b;
        this.f12550c = bVar.f12557c;
        this.f12551d = bVar.f12558d;
        this.f12552e = bVar.f12559e;
        this.f12553f = bVar.f12560f;
        this.f12554g = bVar.f12561g;
    }
}

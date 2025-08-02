package k9;

import android.text.TextUtils;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List f12530a;

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List f12531a;

        public g b() {
            return new g(this);
        }

        public b c(List list) {
            this.f12531a = list;
            return this;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f12532a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12533b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12534c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12535d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12536e;

        /* renamed from: f  reason: collision with root package name */
        private final String f12537f;

        /* renamed from: g  reason: collision with root package name */
        private final String f12538g;

        public static final class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f12539a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f12540b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public String f12541c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public String f12542d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public String f12543e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public String f12544f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public String f12545g;

            public a h(String str) {
                this.f12540b = str;
                return this;
            }

            public c i() {
                return new c(this);
            }

            public a j(String str) {
                this.f12543e = str;
                return this;
            }

            public a k(String str) {
                this.f12542d = str;
                return this;
            }

            public a l(String str) {
                this.f12539a = str;
                return this;
            }

            public a m(String str) {
                this.f12541c = str;
                return this;
            }

            public a n(String str) {
                this.f12544f = str;
                return this;
            }

            public a o(String str) {
                this.f12545g = str;
                return this;
            }
        }

        public String a() {
            return this.f12536e;
        }

        public String b() {
            return this.f12535d;
        }

        public String c() {
            return this.f12537f;
        }

        public String d() {
            return this.f12538g;
        }

        public String toString() {
            return "JWK{keyType='" + this.f12532a + '\'' + ", algorithm='" + this.f12533b + '\'' + ", use='" + this.f12534c + '\'' + ", keyId='" + this.f12535d + '\'' + ", curve='" + this.f12536e + '\'' + ", x='" + this.f12537f + '\'' + ", y='" + this.f12538g + '\'' + '}';
        }

        private c(a aVar) {
            this.f12532a = aVar.f12539a;
            this.f12533b = aVar.f12540b;
            this.f12534c = aVar.f12541c;
            this.f12535d = aVar.f12542d;
            this.f12536e = aVar.f12543e;
            this.f12537f = aVar.f12544f;
            this.f12538g = aVar.f12545g;
        }
    }

    public c a(String str) {
        for (c cVar : this.f12530a) {
            if (TextUtils.equals(cVar.b(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public String toString() {
        return "JWKSet{keys=" + this.f12530a + '}';
    }

    private g(b bVar) {
        this.f12530a = bVar.f12531a;
    }
}

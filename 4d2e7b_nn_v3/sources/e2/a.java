package e2;

import com.facebook.AccessToken;
import com.facebook.o;
import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.p0;

public final class a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final C0261a f21119c = new C0261a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f21120a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21121b;

    /* renamed from: e2.a$a  reason: collision with other inner class name */
    public static final class C0261a {
        private C0261a() {
        }

        public /* synthetic */ C0261a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final C0262a f21122c = new C0262a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f21123a;

        /* renamed from: b  reason: collision with root package name */
        private final String f21124b;

        /* renamed from: e2.a$b$a  reason: collision with other inner class name */
        public static final class C0262a {
            private C0262a() {
            }

            public /* synthetic */ C0262a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str, String str2) {
            m.f(str2, "appId");
            this.f21123a = str;
            this.f21124b = str2;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new a(this.f21123a, this.f21124b);
        }
    }

    public a(String str, String str2) {
        m.f(str2, "applicationId");
        this.f21121b = str2;
        this.f21120a = p0.Y(str) ? null : str;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new b(this.f21120a, this.f21121b);
    }

    public final String a() {
        return this.f21120a;
    }

    public final String b() {
        return this.f21121b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!p0.c(aVar.f21120a, this.f21120a) || !p0.c(aVar.f21121b, this.f21121b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        String str = this.f21120a;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return i10 ^ this.f21121b.hashCode();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(AccessToken accessToken) {
        this(accessToken.m(), o.g());
        m.f(accessToken, "accessToken");
    }
}

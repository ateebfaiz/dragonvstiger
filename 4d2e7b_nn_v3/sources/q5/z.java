package q5;

import android.net.Uri;
import android.os.Bundle;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class z extends e {

    /* renamed from: c  reason: collision with root package name */
    public static final a f23551c = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final Uri a(String str, Bundle bundle) {
            m.f(str, "action");
            if (m.b(str, "oauth")) {
                return p0.f(i0.j(), "oauth/authorize", bundle);
            }
            String j10 = i0.j();
            return p0.f(j10, o.r() + DomExceptionUtils.SEPARATOR + "dialog/" + str, bundle);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(String str, Bundle bundle) {
        super(str, bundle);
        m.f(str, "action");
        c(f23551c.a(str, bundle == null ? new Bundle() : bundle));
    }
}

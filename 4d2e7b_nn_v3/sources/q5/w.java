package q5;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.o;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class w {

    /* renamed from: f  reason: collision with root package name */
    public static final c f23532f = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f23533a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f23534b;

    /* renamed from: c  reason: collision with root package name */
    private final b f23535c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23536d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f23537e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private b f23538a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23539b;

        /* renamed from: c  reason: collision with root package name */
        private Object f23540c;

        /* renamed from: d  reason: collision with root package name */
        private final Context f23541d;

        /* renamed from: e  reason: collision with root package name */
        private final Uri f23542e;

        public a(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "imageUri");
            this.f23541d = context;
            this.f23542e = uri;
        }

        public final w a() {
            Context context = this.f23541d;
            Uri uri = this.f23542e;
            b bVar = this.f23538a;
            boolean z10 = this.f23539b;
            Object obj = this.f23540c;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return new w(context, uri, bVar, z10, obj, (DefaultConstructorMarker) null);
        }

        public final a b(boolean z10) {
            this.f23539b = z10;
            return this;
        }

        public final a c(b bVar) {
            this.f23538a = bVar;
            return this;
        }

        public final a d(Object obj) {
            this.f23540c = obj;
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!m.b(this.f23541d, aVar.f23541d) || !m.b(this.f23542e, aVar.f23542e)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            Context context = this.f23541d;
            int i11 = 0;
            if (context != null) {
                i10 = context.hashCode();
            } else {
                i10 = 0;
            }
            int i12 = i10 * 31;
            Uri uri = this.f23542e;
            if (uri != null) {
                i11 = uri.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "Builder(context=" + this.f23541d + ", imageUri=" + this.f23542e + ")";
        }
    }

    public interface b {
        void a(x xVar);
    }

    public static final class c {
        private c() {
        }

        public final Uri a(String str, int i10, int i11, String str2) {
            boolean z10;
            q0.n(str, "userId");
            int max = Math.max(i10, 0);
            int max2 = Math.max(i11, 0);
            if (max == 0 && max2 == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Uri.Builder buildUpon = Uri.parse(i0.g()).buildUpon();
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.US, "%s/%s/picture", Arrays.copyOf(new Object[]{o.r(), str}, 2));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                Uri.Builder path = buildUpon.path(format);
                if (max2 != 0) {
                    path.appendQueryParameter(Snapshot.HEIGHT, String.valueOf(max2));
                }
                if (max != 0) {
                    path.appendQueryParameter(Snapshot.WIDTH, String.valueOf(max));
                }
                path.appendQueryParameter("migration_overrides", "{october_2012:true}");
                if (!p0.Y(str2)) {
                    path.appendQueryParameter("access_token", str2);
                } else if (p0.Y(o.n()) || p0.Y(o.g())) {
                    Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
                } else {
                    path.appendQueryParameter("access_token", o.g() + "|" + o.n());
                }
                Uri build = path.build();
                m.e(build, "builder.build()");
                return build;
            }
            throw new IllegalArgumentException("Either width or height must be greater than 0".toString());
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ w(Context context, Uri uri, b bVar, boolean z10, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, bVar, z10, obj);
    }

    public static final Uri d(String str, int i10, int i11, String str2) {
        return f23532f.a(str, i10, i11, str2);
    }

    public final b a() {
        return this.f23535c;
    }

    public final Object b() {
        return this.f23537e;
    }

    public final Uri c() {
        return this.f23534b;
    }

    public final boolean e() {
        return this.f23536d;
    }

    private w(Context context, Uri uri, b bVar, boolean z10, Object obj) {
        this.f23533a = context;
        this.f23534b = uri;
        this.f23535c = bVar;
        this.f23536d = z10;
        this.f23537e = obj;
    }
}

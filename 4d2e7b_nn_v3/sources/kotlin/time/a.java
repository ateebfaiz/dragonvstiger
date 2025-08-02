package kotlin.time;

import ac.b;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.pdns.model.DomainUhfReportModel;
import io.jsonwebtoken.JwtParser;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.k;
import kotlin.text.j;
import okhttp3.internal.http2.Http2Connection;

public abstract class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0014a f833a = new C0014a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final long f834b = d(0);

    /* renamed from: c  reason: collision with root package name */
    private static final long f835c = b.e(4611686018427387903L);

    /* renamed from: d  reason: collision with root package name */
    private static final long f836d = b.e(-4611686018427387903L);

    /* renamed from: kotlin.time.a$a  reason: collision with other inner class name */
    public static final class C0014a {
        private C0014a() {
        }

        public final long a() {
            return a.f834b;
        }

        public /* synthetic */ C0014a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final void b(long j10, StringBuilder sb2, int i10, int i11, int i12, String str, boolean z10) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append(JwtParser.SEPARATOR_CHAR);
            String f02 = j.f0(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = f02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (f02.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z10 || i15 >= 3) {
                sb2.append(f02, 0, ((i13 + 3) / 3) * 3);
                m.e(sb2, "append(...)");
            } else {
                sb2.append(f02, 0, i15);
                m.e(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    public static int c(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return m.h(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        if (u(j10)) {
            return -i10;
        }
        return i10;
    }

    public static long d(long j10) {
        if (ac.a.a()) {
            if (s(j10)) {
                if (!new k(-4611686018426999999L, 4611686018426999999L).e(p(j10))) {
                    throw new AssertionError(p(j10) + " ns is out of nanoseconds range");
                }
            } else if (!new k(-4611686018427387903L, 4611686018427387903L).e(p(j10))) {
                throw new AssertionError(p(j10) + " ms is out of milliseconds range");
            } else if (new k(-4611686018426L, 4611686018426L).e(p(j10))) {
                throw new AssertionError(p(j10) + " ms is denormalized");
            }
        }
        return j10;
    }

    public static final long e(long j10) {
        if (u(j10)) {
            return x(j10);
        }
        return j10;
    }

    public static final int f(long j10) {
        if (t(j10)) {
            return 0;
        }
        return (int) (h(j10) % ((long) 24));
    }

    public static final long g(long j10) {
        return v(j10, b.DAYS);
    }

    public static final long h(long j10) {
        return v(j10, b.HOURS);
    }

    public static final long i(long j10) {
        if (!r(j10) || !q(j10)) {
            return v(j10, b.MILLISECONDS);
        }
        return p(j10);
    }

    public static final long j(long j10) {
        return v(j10, b.MINUTES);
    }

    public static final long k(long j10) {
        return v(j10, b.SECONDS);
    }

    public static final int l(long j10) {
        if (t(j10)) {
            return 0;
        }
        return (int) (j(j10) % ((long) 60));
    }

    public static final int m(long j10) {
        long p10;
        if (t(j10)) {
            return 0;
        }
        if (r(j10)) {
            p10 = b.f(p(j10) % ((long) 1000));
        } else {
            p10 = p(j10) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        }
        return (int) p10;
    }

    public static final int n(long j10) {
        if (t(j10)) {
            return 0;
        }
        return (int) (k(j10) % ((long) 60));
    }

    private static final b o(long j10) {
        if (s(j10)) {
            return b.NANOSECONDS;
        }
        return b.MILLISECONDS;
    }

    private static final long p(long j10) {
        return j10 >> 1;
    }

    public static final boolean q(long j10) {
        return !t(j10);
    }

    private static final boolean r(long j10) {
        return (((int) j10) & 1) == 1;
    }

    private static final boolean s(long j10) {
        return (((int) j10) & 1) == 0;
    }

    public static final boolean t(long j10) {
        if (j10 == f835c || j10 == f836d) {
            return true;
        }
        return false;
    }

    public static final boolean u(long j10) {
        return j10 < 0;
    }

    public static final long v(long j10, b bVar) {
        m.f(bVar, "unit");
        if (j10 == f835c) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j10 == f836d) {
            return Long.MIN_VALUE;
        }
        return c.a(p(j10), o(j10), bVar);
    }

    public static String w(long j10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f835c) {
            return "Infinity";
        }
        if (j10 == f836d) {
            return "-Infinity";
        }
        boolean u10 = u(j10);
        StringBuilder sb2 = new StringBuilder();
        if (u10) {
            sb2.append('-');
        }
        long e10 = e(j10);
        long g10 = g(e10);
        int f10 = f(e10);
        int l10 = l(e10);
        int n10 = n(e10);
        int m10 = m(e10);
        int i10 = 0;
        if (g10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (f10 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (l10 != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (n10 == 0 && m10 == 0) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z10) {
            sb2.append(g10);
            sb2.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(f10);
            sb2.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            sb2.append(l10);
            sb2.append('m');
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(' ');
            }
            if (n10 != 0 || z10 || z11 || z12) {
                b(j10, sb2, n10, m10, 9, DomainUhfReportModel.SCENE, false);
            } else if (m10 >= 1000000) {
                b(j10, sb2, m10 / 1000000, m10 % 1000000, 6, "ms", false);
            } else if (m10 >= 1000) {
                b(j10, sb2, m10 / 1000, m10 % 1000, 3, "us", false);
            } else {
                sb2.append(m10);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (u10 && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }

    public static final long x(long j10) {
        return b.d(-p(j10), ((int) j10) & 1);
    }
}

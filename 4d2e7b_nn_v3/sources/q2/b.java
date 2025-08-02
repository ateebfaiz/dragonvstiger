package q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f23187b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final File f23188a;

    public static final class a {
        private a() {
        }

        public final b a(File file) {
            m.f(file, "file");
            return new b(file, (DefaultConstructorMarker) null);
        }

        public final b b(File file) {
            if (file != null) {
                return new b(file, (DefaultConstructorMarker) null);
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ b(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    public static final b b(File file) {
        return f23187b.a(file);
    }

    public static final b c(File file) {
        return f23187b.b(file);
    }

    public InputStream a() {
        return new FileInputStream(this.f23188a);
    }

    public final File d() {
        return this.f23188a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return m.b(this.f23188a, ((b) obj).f23188a);
    }

    public int hashCode() {
        return this.f23188a.hashCode();
    }

    public long size() {
        return this.f23188a.length();
    }

    private b(File file) {
        this.f23188a = file;
    }
}

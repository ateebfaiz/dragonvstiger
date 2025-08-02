package tb;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.sequences.Sequence;

public final class g implements Sequence<File> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final File f2067a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final FileWalkDirection f2068b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f2069c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function1 f2070d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Function2 f2071e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f2072f;

    private static abstract class a extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            m.f(file, "rootDir");
        }
    }

    private final class b extends kotlin.collections.b {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque f2073c;

        private final class a extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f2075b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f2076c;

            /* renamed from: d  reason: collision with root package name */
            private int f2077d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f2078e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ b f2079f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                m.f(file, "rootDir");
                this.f2079f = bVar;
            }

            public File b() {
                if (!this.f2078e && this.f2076c == null) {
                    Function1 d10 = g.this.f2069c;
                    if (d10 != null && !((Boolean) d10.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f2076c = listFiles;
                    if (listFiles == null) {
                        Function2 e10 = g.this.f2071e;
                        if (e10 != null) {
                            e10.invoke(a(), new a(a(), (File) null, "Cannot list files in a directory", 2, (DefaultConstructorMarker) null));
                        }
                        this.f2078e = true;
                    }
                }
                File[] fileArr = this.f2076c;
                if (fileArr != null) {
                    int i10 = this.f2077d;
                    m.c(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f2076c;
                        m.c(fileArr2);
                        int i11 = this.f2077d;
                        this.f2077d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f2075b) {
                    this.f2075b = true;
                    return a();
                }
                Function1 f10 = g.this.f2070d;
                if (f10 != null) {
                    f10.invoke(a());
                }
                return null;
            }
        }

        /* renamed from: tb.g$b$b  reason: collision with other inner class name */
        private final class C0035b extends c {

            /* renamed from: b  reason: collision with root package name */
            private boolean f2080b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f2081c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0035b(b bVar, File file) {
                super(file);
                m.f(file, "rootFile");
                this.f2081c = bVar;
            }

            public File b() {
                if (this.f2080b) {
                    return null;
                }
                this.f2080b = true;
                return a();
            }
        }

        private final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            private boolean f2082b;

            /* renamed from: c  reason: collision with root package name */
            private File[] f2083c;

            /* renamed from: d  reason: collision with root package name */
            private int f2084d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ b f2085e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                m.f(file, "rootDir");
                this.f2085e = bVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
                if (r0.length == 0) goto L_0x0081;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f2082b
                    r1 = 0
                    if (r0 != 0) goto L_0x0028
                    tb.g$b r0 = r10.f2085e
                    tb.g r0 = tb.g.this
                    kotlin.jvm.functions.Function1 r0 = r0.f2069c
                    if (r0 == 0) goto L_0x0020
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x0020
                    return r1
                L_0x0020:
                    r0 = 1
                    r10.f2082b = r0
                    java.io.File r0 = r10.a()
                    return r0
                L_0x0028:
                    java.io.File[] r0 = r10.f2083c
                    if (r0 == 0) goto L_0x0047
                    int r2 = r10.f2084d
                    kotlin.jvm.internal.m.c(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0035
                    goto L_0x0047
                L_0x0035:
                    tb.g$b r0 = r10.f2085e
                    tb.g r0 = tb.g.this
                    kotlin.jvm.functions.Function1 r0 = r0.f2070d
                    if (r0 == 0) goto L_0x0046
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L_0x0046:
                    return r1
                L_0x0047:
                    java.io.File[] r0 = r10.f2083c
                    if (r0 != 0) goto L_0x0093
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f2083c = r0
                    if (r0 != 0) goto L_0x0077
                    tb.g$b r0 = r10.f2085e
                    tb.g r0 = tb.g.this
                    kotlin.jvm.functions.Function2 r0 = r0.f2071e
                    if (r0 == 0) goto L_0x0077
                    java.io.File r2 = r10.a()
                    tb.a r9 = new tb.a
                    java.io.File r4 = r10.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L_0x0077:
                    java.io.File[] r0 = r10.f2083c
                    if (r0 == 0) goto L_0x0081
                    kotlin.jvm.internal.m.c(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x0093
                L_0x0081:
                    tb.g$b r0 = r10.f2085e
                    tb.g r0 = tb.g.this
                    kotlin.jvm.functions.Function1 r0 = r0.f2070d
                    if (r0 == 0) goto L_0x0092
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L_0x0092:
                    return r1
                L_0x0093:
                    java.io.File[] r0 = r10.f2083c
                    kotlin.jvm.internal.m.c(r0)
                    int r1 = r10.f2084d
                    int r2 = r1 + 1
                    r10.f2084d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: tb.g.b.c.b():java.io.File");
            }
        }

        public /* synthetic */ class d {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f2086a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    kotlin.io.FileWalkDirection[] r0 = kotlin.io.FileWalkDirection.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.TOP_DOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f2086a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: tb.g.b.d.<clinit>():void");
            }
        }

        public b() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f2073c = arrayDeque;
            if (g.this.f2067a.isDirectory()) {
                arrayDeque.push(f(g.this.f2067a));
            } else if (g.this.f2067a.isFile()) {
                arrayDeque.push(new C0035b(this, g.this.f2067a));
            } else {
                c();
            }
        }

        private final a f(File file) {
            int i10 = d.f2086a[g.this.f2068b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new n();
        }

        private final File g() {
            File b10;
            while (true) {
                c cVar = (c) this.f2073c.peek();
                if (cVar == null) {
                    return null;
                }
                b10 = cVar.b();
                if (b10 == null) {
                    this.f2073c.pop();
                } else if (m.b(b10, cVar.a()) || !b10.isDirectory() || this.f2073c.size() >= g.this.f2072f) {
                    return b10;
                } else {
                    this.f2073c.push(f(b10));
                }
            }
            return b10;
        }

        /* access modifiers changed from: protected */
        public void a() {
            File g10 = g();
            if (g10 != null) {
                d(g10);
            } else {
                c();
            }
        }
    }

    private static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private final File f2087a;

        public c(File file) {
            m.f(file, "root");
            this.f2087a = file;
        }

        public final File a() {
            return this.f2087a;
        }

        public abstract File b();
    }

    private g(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i10) {
        this.f2067a = file;
        this.f2068b = fileWalkDirection;
        this.f2069c = function1;
        this.f2070d = function12;
        this.f2071e = function2;
        this.f2072f = i10;
    }

    public Iterator iterator() {
        return new b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ g(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i11 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public g(File file, FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, (Function1) null, (Function1) null, (Function2) null, 0, 32, (DefaultConstructorMarker) null);
        m.f(file, "start");
        m.f(fileWalkDirection, "direction");
    }
}

package aa;

import ga.c;
import java.io.Writer;
import java.util.Objects;
import y9.g;

public abstract class m {
    public static void a(g gVar, c cVar) {
        ba.m.V.d(cVar, gVar);
    }

    public static Writer b(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    private static final class b extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f2325a;

        /* renamed from: b  reason: collision with root package name */
        private final a f2326b = new a();

        private static class a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f2327a;

            /* renamed from: b  reason: collision with root package name */
            private String f2328b;

            private a() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f2327a = cArr;
                this.f2328b = null;
            }

            public char charAt(int i10) {
                return this.f2327a[i10];
            }

            public int length() {
                return this.f2327a.length;
            }

            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f2327a, i10, i11 - i10);
            }

            public String toString() {
                if (this.f2328b == null) {
                    this.f2328b = new String(this.f2327a);
                }
                return this.f2328b;
            }
        }

        b(Appendable appendable) {
            this.f2325a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i10, int i11) {
            this.f2326b.a(cArr);
            this.f2325a.append(this.f2326b, i10, i11 + i10);
        }

        public Writer append(CharSequence charSequence) {
            this.f2325a.append(charSequence);
            return this;
        }

        public void write(int i10) {
            this.f2325a.append((char) i10);
        }

        public Writer append(CharSequence charSequence, int i10, int i11) {
            this.f2325a.append(charSequence, i10, i11);
            return this;
        }

        public void write(String str, int i10, int i11) {
            Objects.requireNonNull(str);
            this.f2325a.append(str, i10, i11 + i10);
        }
    }
}

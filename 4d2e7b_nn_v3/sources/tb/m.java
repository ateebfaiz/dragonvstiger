package tb;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.sequences.Sequence;

final class m implements Sequence {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f2088a;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2089a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2090b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f2091c;

        a(m mVar) {
            this.f2091c = mVar;
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f2089a;
                this.f2089a = null;
                kotlin.jvm.internal.m.c(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f2089a == null && !this.f2090b) {
                String readLine = this.f2091c.f2088a.readLine();
                this.f2089a = readLine;
                if (readLine == null) {
                    this.f2090b = true;
                }
            }
            if (this.f2089a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(BufferedReader bufferedReader) {
        kotlin.jvm.internal.m.f(bufferedReader, "reader");
        this.f2088a = bufferedReader;
    }

    public Iterator iterator() {
        return new a(this);
    }
}

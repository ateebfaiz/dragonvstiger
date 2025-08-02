package tb;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.Sequence;
import kotlin.sequences.h;

public abstract class o {

    static final class a extends n implements Function1<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2092a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.f2092a = arrayList;
        }

        public final void a(String str) {
            m.f(str, "it");
            this.f2092a.add(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f12577a;
        }
    }

    public static final long a(Reader reader, Writer writer, int i10) {
        m.f(reader, "<this>");
        m.f(writer, "out");
        char[] cArr = new char[i10];
        int read = reader.read(cArr);
        long j10 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j10 += (long) read;
            read = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(reader, writer, i10);
    }

    public static final void c(Reader reader, Function1 function1) {
        BufferedReader bufferedReader;
        m.f(reader, "<this>");
        m.f(function1, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            for (Object invoke : d(bufferedReader)) {
                function1.invoke(invoke);
            }
            Unit unit = Unit.f12577a;
            c.a(bufferedReader, (Throwable) null);
        } catch (Throwable th) {
            c.a(bufferedReader, th);
            throw th;
        }
    }

    public static final Sequence d(BufferedReader bufferedReader) {
        m.f(bufferedReader, "<this>");
        return h.d(new m(bufferedReader));
    }

    public static final List e(Reader reader) {
        m.f(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        c(reader, new a(arrayList));
        return arrayList;
    }

    public static final String f(Reader reader) {
        m.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        m.e(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}

package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this((Charset) null, 1, (DefaultConstructorMarker) null);
        }

        public final Builder add(String str, String str2) {
            String str3 = str;
            m.f(str3, "name");
            m.f(str2, "value");
            HttpUrl.Companion companion = HttpUrl.Companion;
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str3, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            String str3 = str;
            m.f(str3, "name");
            m.f(str2, "value");
            HttpUrl.Companion companion = HttpUrl.Companion;
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str3, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset2) {
            this.charset = charset2;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Charset charset2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : charset2);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        m.f(list, "encodedNames");
        m.f(list2, "encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z10) {
        Buffer buffer;
        if (z10) {
            buffer = new Buffer();
        } else {
            m.c(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i10));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i10));
        }
        if (!z10) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m40deprecated_size() {
        return size();
    }

    public long contentLength() {
        return writeOrCountBytes((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i10) {
        return this.encodedNames.get(i10);
    }

    public final String encodedValue(int i10) {
        return this.encodedValues.get(i10);
    }

    public final String name(int i10) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i10), 0, 0, true, 3, (Object) null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i10) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i10), 0, 0, true, 3, (Object) null);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        m.f(bufferedSink, "sink");
        writeOrCountBytes(bufferedSink, false);
    }
}

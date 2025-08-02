package org.cocos2dx.okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this((Charset) null);
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset2) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset2;
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z10) {
        Buffer buffer;
        if (z10) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
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

    public long contentLength() {
        return writeOrCountBytes((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i10) {
        return this.encodedNames.get(i10);
    }

    public String encodedValue(int i10) {
        return this.encodedValues.get(i10);
    }

    public String name(int i10) {
        return HttpUrl.percentDecode(encodedName(i10), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i10) {
        return HttpUrl.percentDecode(encodedValue(i10), true);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}

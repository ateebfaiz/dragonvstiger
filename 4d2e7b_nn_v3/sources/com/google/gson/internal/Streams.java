package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        throw new com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        return com.google.gson.JsonNull.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000d A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0011 A[ExcHandler: MalformedJsonException (r2v4 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader r2) throws com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0027, MalformedJsonException -> 0x0011, IOException -> 0x000f, NumberFormatException -> 0x000d }
            r0 = 0
            com.google.gson.TypeAdapter<com.google.gson.JsonElement> r1 = com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT     // Catch:{ EOFException -> 0x0013, MalformedJsonException -> 0x0011, IOException -> 0x000f, NumberFormatException -> 0x000d }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x0013, MalformedJsonException -> 0x0011, IOException -> 0x000f, NumberFormatException -> 0x000d }
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2     // Catch:{ EOFException -> 0x0013, MalformedJsonException -> 0x0011, IOException -> 0x000f, NumberFormatException -> 0x000d }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0015
        L_0x000f:
            r2 = move-exception
            goto L_0x001b
        L_0x0011:
            r2 = move-exception
            goto L_0x0021
        L_0x0013:
            r2 = move-exception
            goto L_0x0029
        L_0x0015:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001b:
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0021:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0027:
            r2 = move-exception
            r0 = 1
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            com.google.gson.JsonNull r2 = com.google.gson.JsonNull.INSTANCE
            return r2
        L_0x002e:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Streams.parse(com.google.gson.stream.JsonReader):com.google.gson.JsonElement");
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    private static final class b extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f9385a;

        /* renamed from: b  reason: collision with root package name */
        private final a f9386b = new a();

        private static class a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f9387a;

            /* renamed from: b  reason: collision with root package name */
            private String f9388b;

            private a() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f9387a = cArr;
                this.f9388b = null;
            }

            public char charAt(int i10) {
                return this.f9387a[i10];
            }

            public int length() {
                return this.f9387a.length;
            }

            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f9387a, i10, i11 - i10);
            }

            public String toString() {
                if (this.f9388b == null) {
                    this.f9388b = new String(this.f9387a);
                }
                return this.f9388b;
            }
        }

        b(Appendable appendable) {
            this.f9385a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i10, int i11) {
            this.f9386b.a(cArr);
            this.f9385a.append(this.f9386b, i10, i11 + i10);
        }

        public Writer append(CharSequence charSequence) {
            this.f9385a.append(charSequence);
            return this;
        }

        public void write(int i10) {
            this.f9385a.append((char) i10);
        }

        public Writer append(CharSequence charSequence, int i10, int i11) {
            this.f9385a.append(charSequence, i10, i11);
            return this;
        }

        public void write(String str, int i10, int i11) {
            Objects.requireNonNull(str);
            this.f9385a.append(str, i10, i11 + i10);
        }
    }
}

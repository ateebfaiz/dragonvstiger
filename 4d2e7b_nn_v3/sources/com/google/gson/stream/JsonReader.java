package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    class a extends JsonReaderInternalAccess {
        a() {
        }

        public void promoteNameToValue(JsonReader jsonReader) {
            if (jsonReader instanceof JsonTreeReader) {
                ((JsonTreeReader) jsonReader).promoteNameToValue();
                return;
            }
            int i10 = jsonReader.peeked;
            if (i10 == 0) {
                i10 = jsonReader.doPeek();
            }
            if (i10 == 13) {
                jsonReader.peeked = 9;
            } else if (i10 == 12) {
                jsonReader.peeked = 8;
            } else if (i10 == 14) {
                jsonReader.peeked = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
            }
        }
    }

    static {
        JsonReaderInternalAccess.INSTANCE = new a();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i10 = this.pos;
        this.pos = i10 - 1;
        if (i10 + 4 <= this.limit || fillBuffer(5)) {
            int i11 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == 10) {
                this.pos = i11 + 5;
            }
        }
    }

    private boolean fillBuffer(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.buffer;
        int i13 = this.lineStart;
        int i14 = this.pos;
        this.lineStart = i13 - i14;
        int i15 = this.limit;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.limit = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i17 = this.limit;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.limit + read;
            this.limit = i11;
            if (this.lineNumber == 0 && (i12 = this.lineStart) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i12 + 1;
                i10++;
                continue;
            }
        } while (i11 < i10);
        return true;
    }

    private String getPath(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.stackSize;
            if (i10 >= i11) {
                return sb2.toString();
            }
            int i12 = this.stack[i10];
            if (i12 == 1 || i12 == 2) {
                int i13 = this.pathIndices[i10];
                if (z10 && i13 > 0 && i10 == i11 - 1) {
                    i13--;
                }
                sb2.append('[');
                sb2.append(i13);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(JwtParser.SEPARATOR_CHAR);
                String str = this.pathNames[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private boolean isLiteral(char c10) throws IOException {
        if (c10 == 9 || c10 == 10 || c10 == 12 || c10 == 13 || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (!(c10 == '/' || c10 == '=')) {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z10) throws IOException {
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = this.limit;
        while (true) {
            if (i10 == i11) {
                this.pos = i10;
                if (fillBuffer(1)) {
                    i10 = this.pos;
                    i11 = this.limit;
                } else if (!z10) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + locationString());
                }
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == 10) {
                this.lineNumber++;
                this.lineStart = i12;
            } else if (!(c10 == ' ' || c10 == 13 || c10 == 9)) {
                if (c10 == '/') {
                    this.pos = i12;
                    if (i12 == i11) {
                        this.pos = i10;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c10;
                        }
                    }
                    checkLenient();
                    int i13 = this.pos;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.pos = i13 + 1;
                        if (skipTo("*/")) {
                            i10 = this.pos + 2;
                            i11 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c11 != '/') {
                        return c10;
                    } else {
                        this.pos = i13 + 1;
                        skipToEndOfLine();
                        i10 = this.pos;
                        i11 = this.limit;
                    }
                } else if (c10 == '#') {
                    this.pos = i12;
                    checkLenient();
                    skipToEndOfLine();
                    i10 = this.pos;
                    i11 = this.limit;
                } else {
                    this.pos = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextQuotedValue(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.buffer
            r1 = 0
        L_0x0003:
            int r2 = r9.pos
            int r3 = r9.limit
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004d
            r9.pos = r7
            int r7 = r7 - r3
            int r2 = r7 + -1
            if (r1 != 0) goto L_0x003e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L_0x003e:
            r1.append(r0, r3, r2)
            char r2 = r9.readEscapeCharacter()
            r1.append(r2)
            int r2 = r9.pos
            int r3 = r9.limit
            goto L_0x0007
        L_0x004d:
            r5 = 10
            if (r2 != r5) goto L_0x0058
            int r2 = r9.lineNumber
            int r2 = r2 + r6
            r9.lineNumber = r2
            r9.lineStart = r7
        L_0x0058:
            r2 = r7
            goto L_0x0009
        L_0x005a:
            if (r1 != 0) goto L_0x006a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.pos = r2
            boolean r2 = r9.fillBuffer(r6)
            if (r2 == 0) goto L_0x0078
            goto L_0x0003
        L_0x0078:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.syntaxError(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r1
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r0.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r1
            r6.pos = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        int i10;
        String str;
        String str2;
        char c10 = this.buffer[this.pos];
        if (c10 == 't' || c10 == 'T') {
            str2 = "true";
            str = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str2 = "false";
            str = "FALSE";
            i10 = 6;
        } else if (c10 != 'n' && c10 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i10 = 7;
        }
        int length = str2.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.pos + i11 >= this.limit && !fillBuffer(i11 + 1)) {
                return 0;
            }
            char c11 = this.buffer[this.pos + i11];
            if (c11 != str2.charAt(i11) && c11 != str.charAt(i11)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i10;
        return i10;
    }

    private int peekNumber() throws IOException {
        char c10;
        char c11;
        boolean z10;
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = this.limit;
        int i12 = 0;
        int i13 = 0;
        char c12 = 0;
        boolean z11 = false;
        boolean z12 = true;
        long j10 = 0;
        while (true) {
            if (i10 + i13 == i11) {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!fillBuffer(i13 + 1)) {
                    break;
                }
                i10 = this.pos;
                i11 = this.limit;
            }
            c10 = cArr[i10 + i13];
            if (c10 == '+') {
                c11 = 6;
                i12 = 0;
                if (c12 != 5) {
                    return 0;
                }
            } else if (c10 == 'E' || c10 == 'e') {
                i12 = 0;
                if (c12 != 2 && c12 != 4) {
                    return 0;
                }
                c12 = 5;
                i13++;
            } else if (c10 != '-') {
                c11 = 3;
                if (c10 == '.') {
                    i12 = 0;
                    if (c12 != 2) {
                        return 0;
                    }
                } else if (c10 >= '0' && c10 <= '9') {
                    if (c12 == 1 || c12 == 0) {
                        j10 = (long) (-(c10 - '0'));
                        c12 = 2;
                    } else if (c12 != 2) {
                        if (c12 == 3) {
                            i12 = 0;
                            c12 = 4;
                        } else if (c12 == 5 || c12 == 6) {
                            i12 = 0;
                            c12 = 7;
                        }
                        i13++;
                    } else if (j10 == 0) {
                        return 0;
                    } else {
                        long j11 = (10 * j10) - ((long) (c10 - '0'));
                        int i14 = (j10 > -922337203685477580L ? 1 : (j10 == -922337203685477580L ? 0 : -1));
                        if (i14 > 0 || (i14 == 0 && j11 < j10)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z12 &= z10;
                        j10 = j11;
                    }
                    i12 = 0;
                    i13++;
                }
            } else {
                c11 = 6;
                i12 = 0;
                if (c12 == 0) {
                    c12 = 1;
                    z11 = true;
                    i13++;
                } else if (c12 != 5) {
                    return 0;
                }
            }
            c12 = c11;
            i13++;
        }
        if (isLiteral(c10)) {
            return 0;
        }
        if (c12 == 2 && z12 && ((j10 != Long.MIN_VALUE || z11) && (j10 != 0 || !z11))) {
            if (!z11) {
                j10 = -j10;
            }
            this.peekedLong = j10;
            this.pos += i13;
            this.peeked = 15;
            return 15;
        } else if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i13;
            this.peeked = 16;
            return 16;
        }
    }

    private void push(int i10) {
        int i11 = this.stackSize;
        int[] iArr = this.stack;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.stack = Arrays.copyOf(iArr, i12);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i12);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i12);
        }
        int[] iArr2 = this.stack;
        int i13 = this.stackSize;
        this.stackSize = i13 + 1;
        iArr2[i13] = i10;
    }

    private char readEscapeCharacter() throws IOException {
        int i10;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 + 1;
            this.pos = i12;
            char c10 = cArr[i11];
            if (c10 == 10) {
                this.lineNumber++;
                this.lineStart = i12;
            } else if (!(c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\')) {
                if (c10 == 'b') {
                    return 8;
                }
                if (c10 == 'f') {
                    return 12;
                }
                if (c10 == 'n') {
                    return 10;
                }
                if (c10 == 'r') {
                    return 13;
                }
                if (c10 == 't') {
                    return 9;
                }
                if (c10 != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i11 + 5 <= this.limit || fillBuffer(4)) {
                    int i13 = this.pos;
                    int i14 = i13 + 4;
                    char c11 = 0;
                    while (i13 < i14) {
                        char c12 = this.buffer[i13];
                        char c13 = (char) (c11 << 4);
                        if (c12 >= '0' && c12 <= '9') {
                            i10 = c12 - '0';
                        } else if (c12 >= 'a' && c12 <= 'f') {
                            i10 = c12 - 'W';
                        } else if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                        } else {
                            i10 = c12 - '7';
                        }
                        c11 = (char) (c13 + i10);
                        i13++;
                    }
                    this.pos += 4;
                    return c11;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c10;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c10) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i10 = this.pos;
            int i11 = this.limit;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.pos = i12;
                    return;
                } else if (c11 == '\\') {
                    this.pos = i12;
                    readEscapeCharacter();
                    i10 = this.pos;
                    i11 = this.limit;
                } else {
                    if (c11 == 10) {
                        this.lineNumber++;
                        this.lineStart = i12;
                    }
                    i10 = i12;
                }
            }
            this.pos = i10;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i10 = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i11 = this.pos;
            if (cArr[i11] == 10) {
                this.lineNumber++;
                this.lineStart = i11 + 1;
            } else {
                while (i10 < length) {
                    if (this.buffer[this.pos + i10] == str.charAt(i10)) {
                        i10++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c10;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i10 = this.pos;
                int i11 = i10 + 1;
                this.pos = i11;
                c10 = cArr[i10];
                if (c10 == 10) {
                    this.lineNumber++;
                    this.lineStart = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* access modifiers changed from: package-private */
    public int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i10 = this.stackSize;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i11 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i12 = this.pos;
                        if (cArr[i12] == '>') {
                            this.pos = i12 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i11 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    public void endArray() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 4) {
            int i11 = this.stackSize;
            this.stackSize = i11 - 1;
            int[] iArr = this.pathIndices;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 2) {
            int i11 = this.stackSize;
            int i12 = i11 - 1;
            this.stackSize = i12;
            this.pathNames[i12] = null;
            int[] iArr = this.pathIndices;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 2 || i10 == 4 || i10 == 17) {
            return false;
        }
        return true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    /* access modifiers changed from: package-private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        char c10;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.peekedLong;
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i10 == 8 || i10 == 9) {
            if (i10 == 8) {
                c10 = '\'';
            } else {
                c10 = '\"';
            }
            this.peekedString = nextQuotedValue(c10);
        } else if (i10 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i10 != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        char c10;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 15) {
            long j10 = this.peekedLong;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.peekedString = nextQuotedValue(c10);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i13 = this.stackSize - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i14 = (int) parseDouble;
        if (((double) i14) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i15 = this.stackSize - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        char c10;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.peekedLong;
        }
        if (i10 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.peekedString = nextQuotedValue(c10);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j10 = (long) parseDouble;
        if (((double) j10) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i13 = this.stackSize - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String str;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 14) {
            str = nextUnquotedValue();
        } else if (i10 == 12) {
            str = nextQuotedValue('\'');
        } else if (i10 == 13) {
            str = nextQuotedValue('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        if (i10 == 10) {
            str = nextUnquotedValue();
        } else if (i10 == 8) {
            str = nextQuotedValue('\'');
        } else if (i10 == 9) {
            str = nextQuotedValue('\"');
        } else if (i10 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i10 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i10 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i10 = this.peeked;
        if (i10 == 0) {
            i10 = doPeek();
        }
        switch (i10) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z10) {
        this.lenient = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r7.peeked = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void skipValue() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r7.peeked
            if (r2 != 0) goto L_0x000a
            int r2 = r7.doPeek()
        L_0x000a:
            r3 = 39
            r4 = 34
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x006f;
                case 2: goto L_0x005f;
                case 3: goto L_0x0059;
                case 4: goto L_0x0051;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x004d;
                case 9: goto L_0x0049;
                case 10: goto L_0x0045;
                case 11: goto L_0x0014;
                case 12: goto L_0x0038;
                case 13: goto L_0x002b;
                case 14: goto L_0x001e;
                case 15: goto L_0x0014;
                case 16: goto L_0x0016;
                case 17: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0074
        L_0x0015:
            return
        L_0x0016:
            int r2 = r7.pos
            int r3 = r7.peekedNumberLength
            int r2 = r2 + r3
            r7.pos = r2
            goto L_0x0074
        L_0x001e:
            r7.skipUnquotedValue()
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x002b:
            r7.skipQuotedValue(r4)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0038:
            r7.skipQuotedValue(r3)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0045:
            r7.skipUnquotedValue()
            goto L_0x0074
        L_0x0049:
            r7.skipQuotedValue(r4)
            goto L_0x0074
        L_0x004d:
            r7.skipQuotedValue(r3)
            goto L_0x0074
        L_0x0051:
            int r2 = r7.stackSize
            int r2 = r2 - r6
            r7.stackSize = r2
        L_0x0056:
            int r1 = r1 + -1
            goto L_0x0074
        L_0x0059:
            r7.push(r6)
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x0074
        L_0x005f:
            if (r1 != 0) goto L_0x0069
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r4 = 0
            r2[r3] = r4
        L_0x0069:
            int r2 = r7.stackSize
            int r2 = r2 - r6
            r7.stackSize = r2
            goto L_0x0056
        L_0x006f:
            r2 = 3
            r7.push(r2)
            goto L_0x005c
        L_0x0074:
            r7.peeked = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.pathIndices
            int r1 = r7.stackSize
            int r1 = r1 - r6
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipValue():void");
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}

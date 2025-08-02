package okhttp3.internal.http2;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(Source source2, int i10) {
            this(source2, i10, 0, 4, (DefaultConstructorMarker) null);
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i11 - i10);
            }
        }

        private final void clearDynamicTable() {
            j.m(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i10) {
            return this.nextHeaderIndex + 1 + i10;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                        this.nextHeaderIndex += i12;
                    } else {
                        Header header = this.dynamicTable[length];
                        m.c(header);
                        int i13 = header.hpackSize;
                        i10 -= i13;
                        this.dynamicTableByteCount -= i13;
                        this.headerCount--;
                        i12++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i11 + 1, headerArr2, i11 + 1 + i12, this.headerCount);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final ByteString getName(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    m.c(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void insertIntoDynamicTable(int i10, Header header) {
            this.headerList.add(header);
            int i11 = header.hpackSize;
            if (i10 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i10)];
                m.c(header2);
                i11 -= header2.hpackSize;
            }
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            if (i10 == -1) {
                int i13 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i14 = this.nextHeaderIndex;
                this.nextHeaderIndex = i14 - 1;
                this.dynamicTable[i14] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i10 + dynamicTableIndex(i10) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i11;
        }

        private final boolean isStaticHeader(int i10) {
            if (i10 < 0 || i10 > Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1) {
                return false;
            }
            return true;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i10) throws IOException {
            if (isStaticHeader(i10)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i10]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i10 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    m.c(header);
                    this.headerList.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i10) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i10) throws IOException {
            this.headerList.add(new Header(getName(i10), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> w02 = r.w0(this.headerList);
            this.headerList.clear();
            return w02;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            boolean z10;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z10 = true;
            } else {
                z10 = false;
            }
            long readInt = (long) readInt(readByte, 127);
            if (!z10) {
                return this.source.readByteString(readInt);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, readInt, buffer);
            return buffer.readByteString();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                } else if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, Hpack.PREFIX_5_BITS);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i11 + (readByte << i13);
                }
                i11 += (readByte & 127) << i13;
                i13 += 7;
            }
        }

        public Reader(Source source2, int i10, int i11) {
            m.f(source2, "source");
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source2);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Reader(Source source2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(source2, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i10, Buffer buffer) {
            this(i10, false, buffer, 2, (DefaultConstructorMarker) null);
        }

        private final void adjustDynamicTableByteCount() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i11 - i10);
            }
        }

        private final void clearDynamicTable() {
            j.m(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i11 = this.nextHeaderIndex;
                    if (length < i11 || i10 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i13 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i13 + 1, i13 + 1 + i12, (Object) null);
                        this.nextHeaderIndex += i12;
                    } else {
                        Header header = this.dynamicTable[length];
                        m.c(header);
                        i10 -= header.hpackSize;
                        int i14 = this.dynamicTableByteCount;
                        Header header2 = this.dynamicTable[length];
                        m.c(header2);
                        this.dynamicTableByteCount = i14 - header2.hpackSize;
                        this.headerCount--;
                        i12++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i11 + 1, headerArr3, i11 + 1 + i12, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i132 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i132 + 1, i132 + 1 + i12, (Object) null);
                this.nextHeaderIndex += i12;
            }
            return i12;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i10 = header.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public final void resizeHeaderTable(int i10) {
            this.headerTableSizeSetting = i10;
            int min = Math.min(i10, 16384);
            int i11 = this.maxDynamicTableByteCount;
            if (i11 != min) {
                if (min < i11) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        public final void writeByteString(ByteString byteString) throws IOException {
            m.f(byteString, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        public final void writeHeaders(List<Header> list) throws IOException {
            int i10;
            int i11;
            m.f(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i12 = this.smallestHeaderTableSizeSetting;
                if (i12 < this.maxDynamicTableByteCount) {
                    writeInt(i12, Hpack.PREFIX_5_BITS, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, Hpack.PREFIX_5_BITS, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header = list.get(i13);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i10 = intValue + 1;
                    if (2 <= i10 && 7 >= i10) {
                        if (m.b(hpack.getSTATIC_HEADER_TABLE()[intValue].value, byteString)) {
                            i11 = i10;
                        } else if (m.b(hpack.getSTATIC_HEADER_TABLE()[i10].value, byteString)) {
                            i11 = i10;
                            i10 = intValue + 2;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
                if (i10 == -1) {
                    int i14 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i14];
                        m.c(header2);
                        if (m.b(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i14];
                            m.c(header3);
                            if (m.b(header3.value, byteString)) {
                                i10 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i14 - this.nextHeaderIndex);
                                break;
                            } else if (i11 == -1) {
                                i11 = (i14 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i14++;
                    }
                }
                if (i10 != -1) {
                    writeInt(i10, 127, 128);
                } else if (i11 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || !(!m.b(Header.TARGET_AUTHORITY, asciiLowercase))) {
                    writeInt(i11, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i11, 15, 0);
                    writeByteString(byteString);
                }
            }
        }

        public final void writeInt(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.out.writeByte(i10 | i12);
                return;
            }
            this.out.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.out.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.out.writeByte(i13);
        }

        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, (DefaultConstructorMarker) null);
        }

        public Writer(int i10, boolean z10, Buffer buffer) {
            m.f(buffer, "out");
            this.headerTableSizeSetting = i10;
            this.useCompression = z10;
            this.out = buffer;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i10;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Writer(int i10, boolean z10, Buffer buffer, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, buffer);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, DomExceptionUtils.SEPARATOR);
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header header8 = new Header(byteString4, "200");
        Header header9 = new Header(byteString4, "204");
        Header header10 = new Header(byteString4, "206");
        Header header11 = new Header(byteString4, "304");
        Header header12 = new Header(byteString4, "400");
        Hpack hpack2 = hpack;
        Header header13 = new Header(byteString4, "404");
        Header header14 = new Header(byteString4, "500");
        Header header15 = new Header("accept-charset", "");
        Header header16 = header14;
        Header header17 = new Header("accept-encoding", "gzip, deflate");
        Header header18 = new Header("accept-language", "");
        Header header19 = new Header("accept-ranges", "");
        Header header20 = new Header("accept", "");
        Header header21 = new Header("access-control-allow-origin", "");
        Header header22 = new Header("age", "");
        Header header23 = new Header("allow", "");
        Header header24 = new Header("authorization", "");
        Header header25 = new Header("cache-control", "");
        Header header26 = new Header("content-disposition", "");
        Header header27 = new Header("content-encoding", "");
        Header header28 = new Header("content-language", "");
        Header header29 = new Header("content-length", "");
        Header header30 = new Header("content-location", "");
        Header header31 = new Header("content-range", "");
        Header header32 = new Header("content-type", "");
        Header header33 = new Header("cookie", "");
        Header header34 = new Header("date", "");
        Header header35 = new Header("etag", "");
        Header header36 = new Header("expect", "");
        Header header37 = new Header("expires", "");
        Header header38 = new Header(Constants.MessagePayloadKeys.FROM, "");
        Header header39 = new Header("host", "");
        Header header40 = new Header("if-match", "");
        Header header41 = new Header("if-modified-since", "");
        Header header42 = new Header("if-none-match", "");
        Header header43 = new Header("if-range", "");
        Header header44 = new Header("if-unmodified-since", "");
        Header header45 = new Header("last-modified", "");
        Header header46 = new Header("link", "");
        Header header47 = new Header(FirebaseAnalytics.Param.LOCATION, "");
        Header header48 = new Header("max-forwards", "");
        Header header49 = new Header("proxy-authenticate", "");
        Header header50 = new Header("proxy-authorization", "");
        Header header51 = new Header("range", "");
        Header header52 = new Header("referer", "");
        Header header53 = new Header("refresh", "");
        Header header54 = new Header("retry-after", "");
        Header header55 = new Header("server", "");
        Header header56 = new Header("set-cookie", "");
        Header header57 = new Header("strict-transport-security", "");
        Header header58 = new Header("transfer-encoding", "");
        Header header59 = new Header("user-agent", "");
        Header header60 = new Header("vary", "");
        Header header61 = new Header("www-authenticate", "");
        Header[] headerArr = new Header[61];
        headerArr[0] = header;
        headerArr[1] = header2;
        headerArr[2] = header3;
        headerArr[3] = header4;
        headerArr[4] = header5;
        headerArr[5] = header6;
        headerArr[6] = header7;
        headerArr[7] = header8;
        headerArr[8] = header9;
        headerArr[9] = header10;
        headerArr[10] = header11;
        headerArr[11] = header12;
        headerArr[12] = header13;
        headerArr[13] = header16;
        headerArr[14] = header15;
        headerArr[15] = header17;
        headerArr[16] = header18;
        headerArr[17] = header19;
        headerArr[18] = header20;
        headerArr[19] = header21;
        headerArr[20] = header22;
        headerArr[21] = header23;
        headerArr[22] = header24;
        headerArr[23] = header25;
        headerArr[24] = header26;
        headerArr[25] = header27;
        headerArr[26] = header28;
        headerArr[27] = header29;
        headerArr[28] = header30;
        headerArr[29] = header31;
        headerArr[30] = header32;
        headerArr[PREFIX_5_BITS] = header33;
        headerArr[32] = header34;
        headerArr[33] = header35;
        headerArr[34] = header36;
        headerArr[35] = header37;
        headerArr[36] = header38;
        headerArr[37] = header39;
        headerArr[38] = header40;
        headerArr[39] = header41;
        headerArr[40] = header42;
        headerArr[41] = header43;
        headerArr[42] = header44;
        headerArr[43] = header45;
        headerArr[44] = header46;
        headerArr[45] = header47;
        headerArr[46] = header48;
        headerArr[47] = header49;
        headerArr[48] = header50;
        headerArr[49] = header51;
        headerArr[50] = header52;
        headerArr[51] = header53;
        headerArr[52] = header54;
        headerArr[53] = header55;
        headerArr[54] = header56;
        headerArr[55] = header57;
        headerArr[56] = header58;
        headerArr[57] = header59;
        headerArr[58] = header60;
        headerArr[59] = new Header("via", "");
        headerArr[60] = header61;
        STATIC_HEADER_TABLE = headerArr;
        NAME_TO_FIRST_INDEX = hpack2.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i10].name)) {
                linkedHashMap.put(headerArr2[i10].name, Integer.valueOf(i10));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        m.e(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString byteString) throws IOException {
        m.f(byteString, "name");
        int size = byteString.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b10 = (byte) 65;
            byte b11 = (byte) 90;
            byte b12 = byteString.getByte(i10);
            if (b10 <= b12 && b11 >= b12) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}

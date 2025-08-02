package org.cocos2dx.okhttp3.internal.http2;

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
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Source;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static final Header[] f1656a;

    /* renamed from: b  reason: collision with root package name */
    static final Map f1657b = b();

    /* renamed from: org.cocos2dx.okhttp3.internal.http2.a$a  reason: collision with other inner class name */
    static final class C0026a {

        /* renamed from: a  reason: collision with root package name */
        private final List f1658a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f1659b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1660c;

        /* renamed from: d  reason: collision with root package name */
        private int f1661d;

        /* renamed from: e  reason: collision with root package name */
        Header[] f1662e;

        /* renamed from: f  reason: collision with root package name */
        int f1663f;

        /* renamed from: g  reason: collision with root package name */
        int f1664g;

        /* renamed from: h  reason: collision with root package name */
        int f1665h;

        C0026a(int i10, Source source) {
            this(i10, i10, source);
        }

        private void a() {
            int i10 = this.f1661d;
            int i11 = this.f1665h;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                d(i11 - i10);
            }
        }

        private void b() {
            Arrays.fill(this.f1662e, (Object) null);
            this.f1663f = this.f1662e.length - 1;
            this.f1664g = 0;
            this.f1665h = 0;
        }

        private int c(int i10) {
            return this.f1663f + 1 + i10;
        }

        private int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f1662e.length;
                while (true) {
                    length--;
                    i11 = this.f1663f;
                    if (length < i11 || i10 <= 0) {
                        Header[] headerArr = this.f1662e;
                        System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.f1664g);
                        this.f1663f += i12;
                    } else {
                        int i13 = this.f1662e[length].hpackSize;
                        i10 -= i13;
                        this.f1665h -= i13;
                        this.f1664g--;
                        i12++;
                    }
                }
                Header[] headerArr2 = this.f1662e;
                System.arraycopy(headerArr2, i11 + 1, headerArr2, i11 + 1 + i12, this.f1664g);
                this.f1663f += i12;
            }
            return i12;
        }

        private ByteString f(int i10) {
            if (h(i10)) {
                return a.f1656a[i10].name;
            }
            int c10 = c(i10 - a.f1656a.length);
            if (c10 >= 0) {
                Header[] headerArr = this.f1662e;
                if (c10 < headerArr.length) {
                    return headerArr[c10].name;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private void g(int i10, Header header) {
            this.f1658a.add(header);
            int i11 = header.hpackSize;
            if (i10 != -1) {
                i11 -= this.f1662e[c(i10)].hpackSize;
            }
            int i12 = this.f1661d;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f1665h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f1664g + 1;
                Header[] headerArr = this.f1662e;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f1663f = this.f1662e.length - 1;
                    this.f1662e = headerArr2;
                }
                int i14 = this.f1663f;
                this.f1663f = i14 - 1;
                this.f1662e[i14] = header;
                this.f1664g++;
            } else {
                this.f1662e[i10 + c(i10) + d10] = header;
            }
            this.f1665h += i11;
        }

        private boolean h(int i10) {
            if (i10 < 0 || i10 > a.f1656a.length - 1) {
                return false;
            }
            return true;
        }

        private int i() {
            return this.f1659b.readByte() & 255;
        }

        private void l(int i10) {
            if (h(i10)) {
                this.f1658a.add(a.f1656a[i10]);
                return;
            }
            int c10 = c(i10 - a.f1656a.length);
            if (c10 >= 0) {
                Header[] headerArr = this.f1662e;
                if (c10 < headerArr.length) {
                    this.f1658a.add(headerArr[c10]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private void n(int i10) {
            g(-1, new Header(f(i10), j()));
        }

        private void o() {
            g(-1, new Header(a.a(j()), j()));
        }

        private void p(int i10) {
            this.f1658a.add(new Header(f(i10), j()));
        }

        private void q() {
            this.f1658a.add(new Header(a.a(j()), j()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f1658a);
            this.f1658a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public ByteString j() {
            boolean z10;
            int i10 = i();
            if ((i10 & 128) == 128) {
                z10 = true;
            } else {
                z10 = false;
            }
            int m10 = m(i10, 127);
            if (z10) {
                return ByteString.of(d.f().c(this.f1659b.readByteArray((long) m10)));
            }
            return this.f1659b.readByteString((long) m10);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f1659b.exhausted()) {
                byte readByte = this.f1659b.readByte();
                byte b10 = readByte & 255;
                if (b10 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(b10, 127) - 1);
                } else if (b10 == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(b10, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m10 = m(b10, 31);
                    this.f1661d = m10;
                    if (m10 < 0 || m10 > this.f1660c) {
                        throw new IOException("Invalid dynamic table size update " + this.f1661d);
                    }
                    a();
                } else if (b10 == 16 || b10 == 0) {
                    q();
                } else {
                    p(m(b10, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }

        C0026a(int i10, int i11, Source source) {
            this.f1658a = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f1662e = headerArr;
            this.f1663f = headerArr.length - 1;
            this.f1664g = 0;
            this.f1665h = 0;
            this.f1660c = i10;
            this.f1661d = i11;
            this.f1659b = Okio.buffer(source);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Buffer f1666a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1667b;

        /* renamed from: c  reason: collision with root package name */
        private int f1668c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1669d;

        /* renamed from: e  reason: collision with root package name */
        int f1670e;

        /* renamed from: f  reason: collision with root package name */
        int f1671f;

        /* renamed from: g  reason: collision with root package name */
        Header[] f1672g;

        /* renamed from: h  reason: collision with root package name */
        int f1673h;

        /* renamed from: i  reason: collision with root package name */
        int f1674i;

        /* renamed from: j  reason: collision with root package name */
        int f1675j;

        b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            int i10 = this.f1671f;
            int i11 = this.f1675j;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                c(i11 - i10);
            }
        }

        private void b() {
            Arrays.fill(this.f1672g, (Object) null);
            this.f1673h = this.f1672g.length - 1;
            this.f1674i = 0;
            this.f1675j = 0;
        }

        private int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f1672g.length;
                while (true) {
                    length--;
                    i11 = this.f1673h;
                    if (length < i11 || i10 <= 0) {
                        Header[] headerArr = this.f1672g;
                        System.arraycopy(headerArr, i11 + 1, headerArr, i11 + 1 + i12, this.f1674i);
                        Header[] headerArr2 = this.f1672g;
                        int i13 = this.f1673h;
                        Arrays.fill(headerArr2, i13 + 1, i13 + 1 + i12, (Object) null);
                        this.f1673h += i12;
                    } else {
                        int i14 = this.f1672g[length].hpackSize;
                        i10 -= i14;
                        this.f1675j -= i14;
                        this.f1674i--;
                        i12++;
                    }
                }
                Header[] headerArr3 = this.f1672g;
                System.arraycopy(headerArr3, i11 + 1, headerArr3, i11 + 1 + i12, this.f1674i);
                Header[] headerArr22 = this.f1672g;
                int i132 = this.f1673h;
                Arrays.fill(headerArr22, i132 + 1, i132 + 1 + i12, (Object) null);
                this.f1673h += i12;
            }
            return i12;
        }

        private void d(Header header) {
            int i10 = header.hpackSize;
            int i11 = this.f1671f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f1675j + i10) - i11);
            int i12 = this.f1674i + 1;
            Header[] headerArr = this.f1672g;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f1673h = this.f1672g.length - 1;
                this.f1672g = headerArr2;
            }
            int i13 = this.f1673h;
            this.f1673h = i13 - 1;
            this.f1672g[i13] = header;
            this.f1674i++;
            this.f1675j += i10;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10) {
            this.f1670e = i10;
            int min = Math.min(i10, 16384);
            int i11 = this.f1671f;
            if (i11 != min) {
                if (min < i11) {
                    this.f1668c = Math.min(this.f1668c, min);
                }
                this.f1669d = true;
                this.f1671f = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(ByteString byteString) {
            if (!this.f1667b || d.f().e(byteString) >= byteString.size()) {
                h(byteString.size(), 127, 0);
                this.f1666a.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            d.f().d(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            h(readByteString.size(), 127, 128);
            this.f1666a.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        public void g(List list) {
            int i10;
            int i11;
            if (this.f1669d) {
                int i12 = this.f1668c;
                if (i12 < this.f1671f) {
                    h(i12, 31, 32);
                }
                this.f1669d = false;
                this.f1668c = Integer.MAX_VALUE;
                h(this.f1671f, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header = (Header) list.get(i13);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = (Integer) a.f1657b.get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i10 = intValue + 1;
                    if (i10 > 1 && i10 < 8) {
                        Header[] headerArr = a.f1656a;
                        if (Util.equal(headerArr[intValue].value, byteString)) {
                            i11 = i10;
                        } else if (Util.equal(headerArr[i10].value, byteString)) {
                            int i14 = i10;
                            i10 = intValue + 2;
                            i11 = i14;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
                if (i10 == -1) {
                    int i15 = this.f1673h + 1;
                    int length = this.f1672g.length;
                    while (true) {
                        if (i15 >= length) {
                            break;
                        }
                        if (Util.equal(this.f1672g[i15].name, asciiLowercase)) {
                            if (Util.equal(this.f1672g[i15].value, byteString)) {
                                i10 = (i15 - this.f1673h) + a.f1656a.length;
                                break;
                            } else if (i11 == -1) {
                                i11 = (i15 - this.f1673h) + a.f1656a.length;
                            }
                        }
                        i15++;
                    }
                }
                if (i10 != -1) {
                    h(i10, 127, 128);
                } else if (i11 == -1) {
                    this.f1666a.writeByte(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    h(i11, 63, 64);
                    f(byteString);
                    d(header);
                } else {
                    h(i11, 15, 0);
                    f(byteString);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f1666a.writeByte(i10 | i12);
                return;
            }
            this.f1666a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f1666a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f1666a.writeByte(i13);
        }

        b(int i10, boolean z10, Buffer buffer) {
            this.f1668c = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.f1672g = headerArr;
            this.f1673h = headerArr.length - 1;
            this.f1674i = 0;
            this.f1675j = 0;
            this.f1670e = i10;
            this.f1671f = i10;
            this.f1667b = z10;
            this.f1666a = buffer;
        }
    }

    static {
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
        Header header13 = new Header(byteString4, "404");
        Header header14 = new Header(byteString4, "500");
        Header header15 = header14;
        f1656a = new Header[]{header, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12, header13, header15, new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header(Constants.MessagePayloadKeys.FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    static ByteString a(ByteString byteString) {
        int size = byteString.size();
        int i10 = 0;
        while (i10 < size) {
            byte b10 = byteString.getByte(i10);
            if (b10 < 65 || b10 > 90) {
                i10++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1656a.length);
        int i10 = 0;
        while (true) {
            Header[] headerArr = f1656a;
            if (i10 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i10].name)) {
                linkedHashMap.put(headerArr[i10].name, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}

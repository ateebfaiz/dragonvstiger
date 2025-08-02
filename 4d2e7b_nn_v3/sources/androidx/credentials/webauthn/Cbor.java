package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import g0.b;
import g0.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.ranges.l;
import kotlin.text.d;
import okhttp3.internal.ws.WebSocketProtocol;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Cbor {
    private final int TYPE_ARRAY = 4;
    private final int TYPE_BYTE_STRING = 2;
    private final int TYPE_FLOAT = 7;
    private final int TYPE_MAP = 5;
    private final int TYPE_NEGATIVE_INT = 1;
    private final int TYPE_TAG = 6;
    private final int TYPE_TEXT_STRING = 3;
    private final int TYPE_UNSIGNED_INT;

    public static final class Arg {
        private final long arg;
        private final int len;

        public Arg(long j10, int i10) {
            this.arg = j10;
            this.len = i10;
        }

        public static /* synthetic */ Arg copy$default(Arg arg2, long j10, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j10 = arg2.arg;
            }
            if ((i11 & 2) != 0) {
                i10 = arg2.len;
            }
            return arg2.copy(j10, i10);
        }

        public final long component1() {
            return this.arg;
        }

        public final int component2() {
            return this.len;
        }

        public final Arg copy(long j10, int i10) {
            return new Arg(j10, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arg)) {
                return false;
            }
            Arg arg2 = (Arg) obj;
            return this.arg == arg2.arg && this.len == arg2.len;
        }

        public final long getArg() {
            return this.arg;
        }

        public final int getLen() {
            return this.len;
        }

        public int hashCode() {
            return (c.a(this.arg) * 31) + this.len;
        }

        public String toString() {
            return "Arg(arg=" + this.arg + ", len=" + this.len + ')';
        }
    }

    public static final class Item {
        private final Object item;
        private final int len;

        public Item(Object obj, int i10) {
            m.f(obj, "item");
            this.item = obj;
            this.len = i10;
        }

        public static /* synthetic */ Item copy$default(Item item2, Object obj, int i10, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                obj = item2.item;
            }
            if ((i11 & 2) != 0) {
                i10 = item2.len;
            }
            return item2.copy(obj, i10);
        }

        public final Object component1() {
            return this.item;
        }

        public final int component2() {
            return this.len;
        }

        public final Item copy(Object obj, int i10) {
            m.f(obj, "item");
            return new Item(obj, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item2 = (Item) obj;
            return m.b(this.item, item2.item) && this.len == item2.len;
        }

        public final Object getItem() {
            return this.item;
        }

        public final int getLen() {
            return this.len;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.len;
        }

        public String toString() {
            return "Item(item=" + this.item + ", len=" + this.len + ')';
        }
    }

    private final byte[] createArg(int i10, long j10) {
        int i11 = i10 << 5;
        int i12 = (int) j10;
        if (j10 < 24) {
            return new byte[]{(byte) ((i11 | i12) & 255)};
        } else if (j10 <= 255) {
            return new byte[]{(byte) ((i11 | 24) & 255), (byte) (i12 & 255)};
        } else if (j10 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return new byte[]{(byte) ((i11 | 25) & 255), (byte) ((i12 >> 8) & 255), (byte) (i12 & 255)};
        } else if (j10 <= 4294967295L) {
            return new byte[]{(byte) ((i11 | 26) & 255), (byte) ((i12 >> 24) & 255), (byte) ((i12 >> 16) & 255), (byte) ((i12 >> 8) & 255), (byte) (i12 & 255)};
        } else {
            throw new IllegalArgumentException("bad Arg");
        }
    }

    /* access modifiers changed from: private */
    public static final int encode$lambda$0(y yVar, byte[] bArr, byte[] bArr2) {
        m.f(yVar, "$byteMap");
        Object obj = ((Map) yVar.f725a).get(bArr);
        m.c(obj);
        byte[] bArr3 = (byte[]) obj;
        Object obj2 = ((Map) yVar.f725a).get(bArr2);
        m.c(obj2);
        byte[] bArr4 = (byte[]) obj2;
        if (bArr.length > bArr2.length) {
            return 1;
        }
        if (bArr.length >= bArr2.length) {
            if (bArr3.length > bArr4.length) {
                return 1;
            }
            if (bArr3.length >= bArr4.length) {
                return 0;
            }
        }
        return -1;
    }

    private final Arg getArg(byte[] bArr, int i10) {
        long j10 = ((long) bArr[i10]) & 31;
        int i11 = (j10 > 24 ? 1 : (j10 == 24 ? 0 : -1));
        if (i11 < 0) {
            return new Arg(j10, 1);
        }
        if (i11 == 0) {
            return new Arg(((long) bArr[i10 + 1]) & 255, 2);
        }
        if (j10 == 25) {
            return new Arg((((long) bArr[i10 + 2]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8), 3);
        } else if (j10 == 26) {
            return new Arg((((long) bArr[i10 + 4]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 24) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 8), 5);
        } else {
            throw new IllegalArgumentException("Bad arg");
        }
    }

    private final int getType(byte[] bArr, int i10) {
        return (bArr[i10] & 255) >> 5;
    }

    private final Item parseItem(byte[] bArr, int i10) {
        int type = getType(bArr, i10);
        Arg arg = getArg(bArr, i10);
        System.out.println("Type " + type + ' ' + arg.getArg() + ' ' + arg.getLen());
        if (type == this.TYPE_UNSIGNED_INT) {
            return new Item(Long.valueOf(arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_NEGATIVE_INT) {
            return new Item(Long.valueOf(((long) -1) - arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_BYTE_STRING) {
            return new Item(j.R(bArr, l.l(arg.getLen() + i10, i10 + arg.getLen() + ((int) arg.getArg()))), arg.getLen() + ((int) arg.getArg()));
        }
        if (type == this.TYPE_TEXT_STRING) {
            return new Item(new String(j.R(bArr, l.l(arg.getLen() + i10, i10 + arg.getLen() + ((int) arg.getArg()))), d.f797b), arg.getLen() + ((int) arg.getArg()));
        }
        int i11 = 0;
        if (type == this.TYPE_ARRAY) {
            ArrayList arrayList = new ArrayList();
            int len = arg.getLen();
            int arg2 = (int) arg.getArg();
            while (i11 < arg2) {
                Item parseItem = parseItem(bArr, i10 + len);
                arrayList.add(parseItem.getItem());
                len += parseItem.getLen();
                i11++;
            }
            return new Item(r.w0(arrayList), len);
        } else if (type == this.TYPE_MAP) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int len2 = arg.getLen();
            int arg3 = (int) arg.getArg();
            while (i11 < arg3) {
                Item parseItem2 = parseItem(bArr, i10 + len2);
                int len3 = len2 + parseItem2.getLen();
                Item parseItem3 = parseItem(bArr, i10 + len3);
                len2 = len3 + parseItem3.getLen();
                linkedHashMap.put(parseItem2.getItem(), parseItem3.getItem());
                i11++;
            }
            return new Item(i0.p(linkedHashMap), len2);
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    public final Object decode(byte[] bArr) {
        m.f(bArr, "data");
        return parseItem(bArr, 0).getItem();
    }

    public final byte[] encode(Object obj) {
        m.f(obj, "data");
        if (obj instanceof Number) {
            if (!(obj instanceof Double)) {
                long longValue = ((Number) obj).longValue();
                if (longValue >= 0) {
                    return createArg(this.TYPE_UNSIGNED_INT, longValue);
                }
                return createArg(this.TYPE_NEGATIVE_INT, ((long) -1) - longValue);
            }
            throw new IllegalArgumentException("Don't support doubles yet");
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            return j.n(createArg(this.TYPE_BYTE_STRING, (long) bArr.length), bArr);
        } else if (obj instanceof String) {
            String str = (String) obj;
            return j.n(createArg(this.TYPE_TEXT_STRING, (long) str.length()), kotlin.text.j.n(str));
        } else if (obj instanceof List) {
            List list = (List) obj;
            byte[] createArg = createArg(this.TYPE_ARRAY, (long) list.size());
            for (Object next : list) {
                m.c(next);
                createArg = j.n(createArg, encode(next));
            }
            return createArg;
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            byte[] createArg2 = createArg(this.TYPE_MAP, (long) map.size());
            y yVar = new y();
            yVar.f725a = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                m.c(key);
                byte[] encode = encode(key);
                Object value = entry.getValue();
                m.c(value);
                ((Map) yVar.f725a).put(encode, encode(value));
            }
            ArrayList arrayList = new ArrayList(((Map) yVar.f725a).keySet());
            r.s0(arrayList, new b(yVar));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                m.e(bArr2, "key");
                byte[] n10 = j.n(createArg2, bArr2);
                Object obj2 = ((Map) yVar.f725a).get(bArr2);
                m.c(obj2);
                createArg2 = j.n(n10, (byte[]) obj2);
            }
            return createArg2;
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    public final int getTYPE_ARRAY() {
        return this.TYPE_ARRAY;
    }

    public final int getTYPE_BYTE_STRING() {
        return this.TYPE_BYTE_STRING;
    }

    public final int getTYPE_FLOAT() {
        return this.TYPE_FLOAT;
    }

    public final int getTYPE_MAP() {
        return this.TYPE_MAP;
    }

    public final int getTYPE_NEGATIVE_INT() {
        return this.TYPE_NEGATIVE_INT;
    }

    public final int getTYPE_TAG() {
        return this.TYPE_TAG;
    }

    public final int getTYPE_TEXT_STRING() {
        return this.TYPE_TEXT_STRING;
    }

    public final int getTYPE_UNSIGNED_INT() {
        return this.TYPE_UNSIGNED_INT;
    }
}

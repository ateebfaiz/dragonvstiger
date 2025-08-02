package okhttp3.internal.http2;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.pdns.DNSResolver;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class Huffman {
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, DNSResolver.GOBACK_LOCAL, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 103, LocationRequestCompat.QUALITY_LOW_POWER, 105, 106, 107, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_BIT_COUNTS;
    public static final Huffman INSTANCE;
    private static final Node root = new Node();

    static {
        Huffman huffman = new Huffman();
        INSTANCE = huffman;
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        CODE_BIT_COUNTS = bArr;
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            huffman.addCode(i10, CODES[i10], CODE_BIT_COUNTS[i10]);
        }
    }

    private Huffman() {
    }

    private final void addCode(int i10, int i11, int i12) {
        Node node = new Node(i10, i12);
        Node node2 = root;
        while (i12 > 8) {
            i12 -= 8;
            int i13 = (i11 >>> i12) & 255;
            Node[] children = node2.getChildren();
            m.c(children);
            Node node3 = children[i13];
            if (node3 == null) {
                node3 = new Node();
                children[i13] = node3;
            }
            node2 = node3;
        }
        int i14 = 8 - i12;
        int i15 = (i11 << i14) & 255;
        Node[] children2 = node2.getChildren();
        m.c(children2);
        j.k(children2, node, i15, (1 << i14) + i15);
    }

    public final void decode(BufferedSource bufferedSource, long j10, BufferedSink bufferedSink) {
        m.f(bufferedSource, "source");
        m.f(bufferedSink, "sink");
        Node node = root;
        int i10 = 0;
        int i11 = 0;
        for (long j11 = 0; j11 < j10; j11++) {
            i10 = (i10 << 8) | Util.and(bufferedSource.readByte(), 255);
            i11 += 8;
            while (i11 >= 8) {
                int i12 = i11 - 8;
                Node[] children = node.getChildren();
                m.c(children);
                node = children[(i10 >>> i12) & 255];
                m.c(node);
                if (node.getChildren() == null) {
                    bufferedSink.writeByte(node.getSymbol());
                    i11 -= node.getTerminalBitCount();
                    node = root;
                } else {
                    i11 = i12;
                }
            }
        }
        while (i11 > 0) {
            Node[] children2 = node.getChildren();
            m.c(children2);
            Node node2 = children2[(i10 << (8 - i11)) & 255];
            m.c(node2);
            if (node2.getChildren() == null && node2.getTerminalBitCount() <= i11) {
                bufferedSink.writeByte(node2.getSymbol());
                i11 -= node2.getTerminalBitCount();
                node = root;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void encode(okio.ByteString r9, okio.BufferedSink r10) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.m.f(r9, r0)
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.m.f(r10, r0)
            int r0 = r9.size()
            r1 = 0
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r3 >= r0) goto L_0x003a
            byte r5 = r9.getByte(r3)
            r6 = 255(0xff, float:3.57E-43)
            int r5 = okhttp3.internal.Util.and((byte) r5, (int) r6)
            int[] r6 = CODES
            r6 = r6[r5]
            byte[] r7 = CODE_BIT_COUNTS
            byte r5 = r7[r5]
            long r1 = r1 << r5
            long r6 = (long) r6
            long r1 = r1 | r6
            int r4 = r4 + r5
        L_0x002a:
            r5 = 8
            if (r4 < r5) goto L_0x0037
            int r4 = r4 + -8
            long r5 = r1 >> r4
            int r5 = (int) r5
            r10.writeByte(r5)
            goto L_0x002a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0012
        L_0x003a:
            if (r4 <= 0) goto L_0x0048
            int r9 = 8 - r4
            long r0 = r1 << r9
            r2 = 255(0xff, double:1.26E-321)
            long r2 = r2 >>> r4
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.writeByte(r9)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Huffman.encode(okio.ByteString, okio.BufferedSink):void");
    }

    public final int encodedLength(ByteString byteString) {
        m.f(byteString, "bytes");
        int size = byteString.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 += (long) CODE_BIT_COUNTS[Util.and(byteString.getByte(i10), 255)];
        }
        return (int) ((j10 + ((long) 7)) >> 3);
    }

    private static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int i10, int i11) {
            this.children = null;
            this.symbol = i10;
            int i12 = i11 & 7;
            this.terminalBitCount = i12 == 0 ? 8 : i12;
        }
    }
}
